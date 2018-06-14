package cn.lp.control.plan;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.lp.check.PowerCheck;
import cn.lp.mapper.part.PartTechnologyMapper;
import cn.lp.mapper.plan.ManufactureMapper;
import cn.lp.mapper.plan.PlanDetailMapper;
import cn.lp.po.account.Account;
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
	ManufactureMapper manuMapper;
	@Autowired
	PartService partService;
	@Autowired
	PlanDetailMapper planDetailMapper;
	@Autowired
	PartTechnologyMapper partTechMapper;

	@RequestMapping("manufacture_all")
	public String selectAll(@RequestParam(required = true, defaultValue = "1") int page, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if ((!PowerCheck.check(3)) && (!PowerCheck.check(4)) && (!PowerCheck.check(1))) {
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
		if ((!PowerCheck.check(3)) && (!PowerCheck.check(4)) && (!PowerCheck.check(1))) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		Manufacture maun = planService.selectManuById(id);
		planService.addPartName(maun);
		m.addAttribute("manufacture", maun);

		return "manufacture_info";
	}

	@RequestMapping("manufacture_get")
	public String manuGet(Model m, int id) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(1)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		Manufacture maun = planService.selectManuById(id);
		maun.setState("接单");
		manuMapper.updateByPrimaryKeySelective(maun);
		m.addAttribute("message", "成功");
		m.addAttribute("manufacture", maun);
		return "manufacture_info";
	}

	@RequestMapping("manufacture_complete")
	public String manuComplete(Model m, int id) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(1)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		Manufacture maun = planService.selectManuById(id);
		HttpSession s = BaseUtil.getSession();
		Account acccount = (Account) s.getAttribute("account");
		maun.setWorkStaffId(acccount.getStaffId());
		maun.setState("完成");
		maun.setRealityTime(new Date());
		manuMapper.updateByPrimaryKeySelective(maun);
		m.addAttribute("message", "成功");
		m.addAttribute("manufacture", maun);
		return "manufacture_info";
	}

	@RequestMapping("manufacture_go_checked")
	public String manuGoChecked(Model m, Integer id) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(4)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		if (id == null)
			return "index";
		m.addAttribute("id", id);
		return "manu_checked";
	}

	@RequestMapping("manufacture_checked")
	public String manuChecked(Model m, Integer id, Integer num) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(4)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		if (id == null)
			return "index";
		Manufacture manu = manuMapper.selectByPrimaryKey(id);

		if (num <= 0 || num > manu.getNum()) {
			m.addAttribute("id", id);
			m.addAttribute("message", "数字不合法");
			return "manu_checked";
		}
		manu.setQualifiedNum(num);
		HttpSession s = BaseUtil.getSession();
		Account acccount = (Account) s.getAttribute("account");
		manu.setCheckStaffId(acccount.getStaffId());
		manu.setState("已检验");
		manu.setUnqualifiedNum(manu.getNum() - num);
		manuMapper.updateByPrimaryKeySelective(manu);
		PageInfo<Manufacture> pageInfo = planService.selectAllManufacture(1);
		m.addAttribute(pageInfo);
		return "manufacture_all";

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
		PlanDetail planDetail = planService.selectPlanDetailById(manu.getPlanDetailId());
		if (planDetail == null) {
			m.addAttribute("message", "计划详情号出错");
			return "manufacture_add";
		}
		PartTechnology partTech = new PartTechnology();
		
	
		partTech = partTechMapper.selectPartTechByCount(manu.getPartTechnologyId(), planDetail.getPartId());// partTechId传过来实质是工序号count
		System.out.println(partTech);
		if (staff == null) {
			m.addAttribute("message", "员工号出错");
			return "manufacture_add";
		}
		
		if (partTech == null) {
			m.addAttribute("message", "工序号出错");
			return "manufacture_add";

		}
		Plan plan = planService.selectPlanById(planDetail.getPlanId());
System.out.println(plan);
		if (!plan.getState().equals("计划分配") ) {
			m.addAttribute("message", "该计划不是计划分配阶段");
			return "manufacture_add";
		}
		if (planDetail.getPartId() != partTech.getPartId()) {
			m.addAttribute("message", "工序与计划详情不符");
			return "manufacture_add";
		}

		Manufacture ma = new Manufacture();
		ma.setPlanDetailId(planDetail.getId());
		List<Manufacture> manus = manuMapper.selectManufactureSelective(ma);
		int num = manu.getNum();
		if (manus.size() > 0) {
			for (int j = 0; j < manus.size(); j++) {
				num = num + manus.get(j).getNum();

			}
			System.out.println(num);
			if (num > planDetail.getNum()) {
				m.addAttribute("message", "数量过多");
				return "manufacture_add";
			}

		}

		HttpSession s = BaseUtil.getSession();
		Staff planStaff = (Staff) s.getAttribute("staff");
		manu.setPlanStaffId(planStaff.getId());
		manu.setPlanEndTime(plan.getPlanEnd());

		manu.setState("下单");
		if (!planService.addMaun(manu)) {
			m.addAttribute("message", "插入失败");
			return "manufacture_add";
		}

		return "redirect:manufacture_all";

	}

}
