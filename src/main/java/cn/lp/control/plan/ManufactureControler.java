package cn.lp.control.plan;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.lp.check.PowerCheck;
import cn.lp.po.account.Staff;
import cn.lp.po.part.PartTechnology;
import cn.lp.po.plan.Manufacture;
import cn.lp.po.plan.Plan;
import cn.lp.po.plan.PlanDetail;
import cn.lp.service.AccountService;
import cn.lp.service.PartService;
import cn.lp.service.PlanService;
import cn.lp.util.BaseUtil;

@Controller
public class ManufactureControler {

	@Autowired
	PlanService planService;
	@Autowired
	AccountService accountService;

	@Autowired
	PartService partService;

	@RequestMapping("manufacture_all")
	public String selectAll(@RequestParam(required = true, defaultValue = "1") int page, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(3)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		PageInfo<Manufacture> pageInfo = planService.selectAllManufacture(page);
		m.addAttribute(pageInfo);
		return "manufacture_all";
	}

	@RequestMapping("manufacture_info")
	public String addPlanDetail(Model m, int id) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(3, 2)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		Manufacture maun = planService.selectManuById(id);
		m.addAttribute("manufacture", maun);

		return "manufacture_info";
	}

	@RequestMapping("manufacture_go_add")
	public String addPlan(Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(3)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}

		return "manufacture_add";
	}

	@RequestMapping("/manufacture_add")
	public String addPlan(Model m, Manufacture manu) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		System.out.println(manu);
		if (!PowerCheck.check(3)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		if (manu.getPlanDetailId() == null) {
			m.addAttribute("message", "请填写");
			return "manufacture_add";
		}
		Staff staff = accountService.selectStaffById(manu.getWorkStaffId());
		PlanDetail planDetail=planService.selectPlanDetailById(manu.getPlanDetailId());
		PartTechnology partTech=partService.selectPartTechById(manu.getPartTechnologyId());

		if (staff == null) {
			m.addAttribute("message", "员工号出错");
			return "manufacture_add";
		}if (planDetail == null) {
			m.addAttribute("message", "计划详情号出错");
			return "manufacture_add";
		}if (partTech == null) {
			m.addAttribute("message", "工序号出错");
			return "manufacture_add";
		}

		Plan plan=planService.selectPlanById(planDetail.getPlanId());
		HttpSession s= BaseUtil.getSession();
		Staff planStaff=(Staff) s.getAttribute("staff");
		manu.setPlanStaffId(planStaff.getId());
		manu.setPlanEndTime(plan.getPlanEnd());;

		if (!planService.addMaun(manu)) {
			m.addAttribute("message", "插入失败");
			return "manufacture_add";
		}
		
		return "redirect:manufacture_all";

	}

	/*@RequestMapping("plan_detail_info")
	public String selectPlanDetail(@RequestParam(required = true, defaultValue = "1") int page, int id, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(3)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		PageInfo<PlanDetail> pageInfo = planService.selectAllPlanDetailByPlanId(page, id);
		Plan plan = planService.selectPlanById(id);
		m.addAttribute(pageInfo);
		m.addAttribute("plan", plan);
		return "plan_detail_info";
	}*/

	/*
	 * @RequestMapping("plan_detail_go_add") public String addPlanDetail(Model m,
	 * int planId) { if (!PowerCheck.check()) { m.addAttribute("message", "请登录");
	 * return "login"; } if (!PowerCheck.check(3, 2)) { m.addAttribute("message",
	 * "不好意思 没有权限"); return "index"; }
	 * 
	 * m.addAttribute("planId", planId);
	 * 
	 * return "plan_detail_add"; }
	 */

	/*
	 * @RequestMapping("/plan_detail_add") public String addPlanDetail(Model m,
	 * PlanDetail planDetail) { if (!PowerCheck.check()) { m.addAttribute("message",
	 * "请登录"); return "login"; } if (!PowerCheck.check(3, 2)) {
	 * m.addAttribute("message", "不好意思 没有权限"); return "index"; } if
	 * (planDetail.getPartId() == null) {
	 * 
	 * return "index"; } Part part =
	 * partService.selectPartById(planDetail.getPartId());
	 * 
	 * if (part == null) { m.addAttribute("message", "零部件号出错"); return "plan_add"; }
	 * 
	 * int id = planDetail.getPlanId();
	 * 
	 * if (!planService.addPlanDetail(planDetail)) { m.addAttribute("message",
	 * "插入失败"); m.addAttribute("planId", id); return "plan_detail_add"; }
	 * PageInfo<PlanDetail> pageInfo = planService.selectAllPlanDetailByPlanId(1,
	 * id); Plan plan = planService.selectPlanById(id); m.addAttribute(pageInfo);
	 * m.addAttribute("plan", plan); return "plan_detail_info";
	 * 
	 * }
	 * 
	 * @RequestMapping("plan_detail_delete") public String
	 * deletePlanDetail(@RequestParam(required = true, defaultValue = "1") int page,
	 * Integer planDetailId, Model m) { if (!PowerCheck.check()) {
	 * m.addAttribute("message", "请登录"); return "login"; } if (!PowerCheck.check(3,
	 * 2)) { m.addAttribute("message", "不好意思 没有权限"); return "index"; } if
	 * (planDetailId == null) {
	 * 
	 * return "index"; } PlanDetail planDetail =
	 * planService.selectPlanDetailById(planDetailId); if
	 * (planService.deletePlanDetail(planDetailId)) {
	 * 
	 * m.addAttribute("message", "成功"); } else { m.addAttribute("message", "失败"); }
	 * 
	 * PageInfo<PlanDetail> pageInfo = planService.selectAllPlanDetailByPlanId(1,
	 * planDetail.getPlanId()); Plan plan =
	 * planService.selectPlanById(planDetail.getPlanId()); m.addAttribute(pageInfo);
	 * m.addAttribute("plan", plan); return "plan_detail_info"; }
	 * 
	 * @RequestMapping("plan_detail_go_change") public String
	 * goChangePlanDetail(Model m, int planDetailId) { if (!PowerCheck.check()) {
	 * m.addAttribute("message", "请登录"); return "login"; } if (!PowerCheck.check(3,
	 * 2)) { m.addAttribute("message", "不好意思 没有权限"); return "index"; }
	 * 
	 * m.addAttribute("planDetailId", planDetailId);
	 * 
	 * return "plan_detail_change"; }
	 * 
	 * @RequestMapping("/plan_detail_change") public String changePlanDetail(Model
	 * m, PlanDetail planDetail) { if (!PowerCheck.check()) {
	 * m.addAttribute("message", "请登录"); return "login"; } if (!PowerCheck.check(3,
	 * 2)) { m.addAttribute("message", "不好意思 没有权限"); return "index"; }
	 * 
	 * System.out.println(planDetail);
	 * 
	 * planDetail = planService.selectPlanDetailById(planDetail.getId()); int id =
	 * planDetail.getPlanId();
	 * 
	 * if (!planService.changePlanDetail(planDetail)) { m.addAttribute("message",
	 * "修改失败"); m.addAttribute("planId", id); return "plan_detail_add"; }
	 * m.addAttribute("message", "修改成功"); PageInfo<PlanDetail> pageInfo =
	 * planService.selectAllPlanDetailByPlanId(1, id); Plan plan =
	 * planService.selectPlanById(id); m.addAttribute(pageInfo);
	 * m.addAttribute("plan", plan); return "plan_detail_info";
	 * 
	 * }
	 */
}
