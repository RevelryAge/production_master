package cn.lp.control.plan;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.lp.check.PowerCheck;
import cn.lp.mapper.plan.ManufactureMapper;
import cn.lp.mapper.plan.PlanDetailMapper;
import cn.lp.mapper.plan.PlanMapper;
import cn.lp.po.account.Staff;
import cn.lp.po.part.Part;
import cn.lp.po.plan.Manufacture;
import cn.lp.po.plan.Plan;
import cn.lp.po.plan.PlanDetail;
import cn.lp.service.AccountService;
import cn.lp.service.PartService;
import cn.lp.service.PlanService;

@Controller
public class PlanControler {

	@Autowired
	PlanService planService;
	@Autowired
	AccountService accountService;
	@Autowired
	PlanMapper planMapper;
	@Autowired
	PartService partService;
	@Autowired
	PlanDetailMapper planDetailMapper;
	@Autowired
	ManufactureMapper maunMapper;

	@RequestMapping("plan_all")
	public String selectAll(@RequestParam(required = true, defaultValue = "1") int page, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if ((!PowerCheck.check(3)) && (!PowerCheck.check(4))) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		PageInfo<Plan> pageInfo = planService.selectAllPlan(page);
		m.addAttribute(pageInfo);
		return "plan_all";
	}

	@RequestMapping("plan_complete")
	public String planComplete(@RequestParam(required = true, defaultValue = "1") int page, Integer planId, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(3)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		if (planId == null) {
			return "index";
		}
		Plan plan = new Plan();
		plan.setId(planId);
		plan.setState("计划分配");
		m.addAttribute("message", "成功");
		planMapper.updateByPrimaryKeySelective(plan);
		PageInfo<Plan> pageInfo = planService.selectAllPlan(page);
		m.addAttribute(pageInfo);
		return "plan_all";
	}

	@RequestMapping("plan_do")
	public String planDo(@RequestParam(required = true, defaultValue = "1") int page, Integer planId, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(3)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		if (planId == null) {
			return "index";
		}
		Plan plan = new Plan();
		plan.setId(planId);
		plan.setState("加工");
		m.addAttribute("message", "成功");
		planMapper.updateByPrimaryKeySelective(plan);
		PageInfo<Plan> pageInfo = planService.selectAllPlan(page);
		m.addAttribute(pageInfo);
		return "plan_all";
	}

	@RequestMapping("plan_checked")
	public String planChecked(@RequestParam(required = true, defaultValue = "1") int page, Integer planId, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(4)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		if (planId == null) {
			return "index";
		}
		Plan plan = new Plan();
		List<PlanDetail> planDetails = planDetailMapper.selectPlanDetailByPlanId(planId);
		for (int i = 0; i < planDetails.size(); i++) {
			PlanDetail planDetail = planDetails.get(i);

			Manufacture ma = new Manufacture();
			ma.setPlanDetailId(planDetail.getId());
			List<Manufacture> manus = maunMapper.selectManufactureSelective(ma);
			int nq = 0, unq = 0;
			if (manus.size() > 0) {
				for (int j = 0; j < manus.size(); j++) {
					nq = nq + manus.get(j).getQualifiedNum();
					unq = unq + manus.get(j).getUnqualifiedNum();

				}
				if (nq + unq != planDetail.getNum()) {
					/*m.addAttribute("message", "并未完成");
					PageInfo<Plan> pageInfo = planService.selectAllPlan(page);
					m.addAttribute(pageInfo);
					return "plan_all";*/
				}
				planDetail.setQualifiedNum(nq);
				planDetail.setUnqualifiedNum(unq);
				planDetailMapper.updateByPrimaryKeySelective(planDetail);
			}
		}

		plan.setId(planId);
		plan.setState("完成");
		plan.setRealityTime(new Date());

		m.addAttribute("message", "成功");
		planMapper.updateByPrimaryKeySelective(plan);
		PageInfo<Plan> pageInfo = planService.selectAllPlan(page);
		m.addAttribute(pageInfo);
		return "plan_all";
	}

	@RequestMapping("plan_go_add")
	public String addPlan(Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(3, 2)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}

		return "plan_add";
	}

	@RequestMapping("/plan_add")
	public String addPlan(Model m, Plan plan) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(3, 2)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		if (plan.getCreateStaffId() == null) {
			m.addAttribute("message", "请填写");
			return "plan_add";
		}
		Staff staff = accountService.selectStaffById(plan.getPlanStaffId());

		if (staff == null) {
			m.addAttribute("message", "员工号出错");
			return "plan_add";
		}

		plan.setState("计划录入");
		plan.setCreateTime(new Date());

		if (!planService.addPlan(plan)) {
			m.addAttribute("message", "插入失败");
			return "plan_add";
		}
		return "redirect:plan_all";

	}

	@RequestMapping("plan_detail_info")
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
	}

	@RequestMapping("plan_detail_go_add")
	public String addPlanDetail(Model m, int planId) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(3, 2)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}

		m.addAttribute("planId", planId);

		return "plan_detail_add";
	}

	@RequestMapping("/plan_detail_add")
	public String addPlanDetail(Model m, PlanDetail planDetail) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(3, 2)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		if (planDetail.getPartId() == null) {

			return "index";
		}
		Part part = partService.selectPartById(planDetail.getPartId());

		if (part == null) {
			m.addAttribute("message", "零部件号出错");
			return "plan_add";
		}

		int id = planDetail.getPlanId();

		if (!planService.addPlanDetail(planDetail)) {
			m.addAttribute("message", "插入失败");
			m.addAttribute("planId", id);
			return "plan_detail_add";
		}
		PageInfo<PlanDetail> pageInfo = planService.selectAllPlanDetailByPlanId(1, id);
		Plan plan = planService.selectPlanById(id);
		m.addAttribute(pageInfo);
		m.addAttribute("plan", plan);
		return "plan_detail_info";

	}

	@RequestMapping("plan_detail_delete")
	public String deletePlanDetail(@RequestParam(required = true, defaultValue = "1") int page, Integer planDetailId,
			Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(3, 2)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		if (planDetailId == null) {

			return "index";
		}
		PlanDetail planDetail = planService.selectPlanDetailById(planDetailId);
		if (planService.deletePlanDetail(planDetailId)) {

			m.addAttribute("message", "成功");
		} else {
			m.addAttribute("message", "失败");
		}

		PageInfo<PlanDetail> pageInfo = planService.selectAllPlanDetailByPlanId(1, planDetail.getPlanId());
		Plan plan = planService.selectPlanById(planDetail.getPlanId());
		m.addAttribute(pageInfo);
		m.addAttribute("plan", plan);
		return "plan_detail_info";
	}

	@RequestMapping("plan_detail_go_change")
	public String goChangePlanDetail(Model m, int planDetailId) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(3, 2)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}

		m.addAttribute("planDetailId", planDetailId);

		return "plan_detail_change";
	}

	@RequestMapping("/plan_detail_change")
	public String changePlanDetail(Model m, PlanDetail planDetail) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(3, 2)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}

		System.out.println(planDetail);

		planDetail = planService.selectPlanDetailById(planDetail.getId());
		int id = planDetail.getPlanId();

		if (!planService.changePlanDetail(planDetail)) {
			m.addAttribute("message", "修改失败");
			m.addAttribute("planId", id);
			return "plan_detail_add";
		}
		m.addAttribute("message", "修改成功");
		PageInfo<PlanDetail> pageInfo = planService.selectAllPlanDetailByPlanId(1, id);
		Plan plan = planService.selectPlanById(id);
		m.addAttribute(pageInfo);
		m.addAttribute("plan", plan);
		return "plan_detail_info";

	}
}
