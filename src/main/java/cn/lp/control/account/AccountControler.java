package cn.lp.control.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.lp.check.PowerCheck;
import cn.lp.mapper.account.AccountMapper;
import cn.lp.po.account.Account;
import cn.lp.po.account.Dept;
import cn.lp.po.account.Staff;
import cn.lp.service.AccountService;

@Controller
public class AccountControler {
	@Autowired
	AccountMapper accountMapper;
	@Autowired
	AccountService accountService;

	@RequestMapping("/goaddstaff")
	public String goaddinfo(Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(5)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}

		return "addstaff";
	}

	@RequestMapping("/addstaff")
	public String addinfo(Model m, Staff staff) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(5)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		if (staff.getName() == null) {
			m.addAttribute("message", "请填写");
			return "addstaff";
		}

		if (accountService.addStaff(staff)) {
			m.addAttribute("message", "插入成功");
		} else {

			m.addAttribute("message", "插入失败");
		}

		return "index";

	}

	@RequestMapping("/goaddaccount")
	public String goaddaccount(Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(5)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}

		return "addaccount";
	}

	@RequestMapping("/addaccount")
	public String addaccount(Model m, Account account) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(5)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		if (account.getStaffId() == null) {
			m.addAttribute("message", "请填写");
			return "addaccount";
		}
		Staff staff = accountService.selectStaffById(account.getStaffId());
		if (staff == null) {
			m.addAttribute("message", "没有对应的员工");
			return "addaccount";
		}
		if (accountMapper.selectByStaffId(account.getStaffId()) != null) {
			m.addAttribute("message", "该员工已有账号");
			return "addaccount";
		}
		account.setStaffName(staff.getName());
		account.setGrade(1);
		if (accountService.addAccount(account)) {
			m.addAttribute("message", "插入成功");
		} else {
			m.addAttribute("message", "插入失败");
			return "addaccount";
		}
		return "index";

	}

	@RequestMapping("/all_staff_info")
	public String selectAllStaff(@RequestParam(required = true, defaultValue = "1") int page, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(5)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		PageInfo<Staff> pageInfo = accountService.selectAllStaff(page);
		m.addAttribute(pageInfo);
		return "all_staff_info";

	}

	@RequestMapping("/staff_info")
	public String staffinfo(int id, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(5)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		Staff staffinfo = accountService.selectStaffById(id);
		staffinfo = accountService.addDept(staffinfo);
		staffinfo = accountService.addAccountToStaff(staffinfo);
		m.addAttribute("staffinfo", staffinfo);
		return "staff_info";

	}

	@RequestMapping("/go_change_staff")
	public String goChangStaff(Model m, Integer id) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(5)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		Staff staffinfo = accountService.selectStaffById(id);
		staffinfo = accountService.addDept(staffinfo);
		m.addAttribute("staffinfo", staffinfo);

		return "change_staff";
	}

	@RequestMapping("/change_staff")
	public String changStaffInfo(Staff staff, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(5)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}

		if (staff.getId() == null) {
			m.addAttribute("message", "请填写");
			return "redirect:go_change_staff";
		}

		if (accountService.changeStaff(staff)) {

			m.addAttribute("message", "修改成功");
			return "index";
		}
		return "redirect:go_change_staff";

	}

	@RequestMapping("/staff_quit")
	public String staffQuit(@RequestParam int id, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(5, 0)) {
			m.addAttribute("message", "不好意思 没有权限");

		}
		if (accountService.quitStaff(id))
			m.addAttribute("message", "离职成功");
		else
			m.addAttribute("message", "离职失败");
		System.out.println(1);
		return "index";

	}

	@RequestMapping("/dept_all")
	public String deptInfo(Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(6, 0)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";

		}

		List<Dept> depts = accountService.selectDeptInfo();
		m.addAttribute("depts", depts);
		return "dept_all";
	}
	@RequestMapping("/go_deptManager_change")
	public String goDeptManagerChange(Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(6, 0)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";

		}

		return "deptManager_change";
	}
	@RequestMapping("/deptManager_change")
	public String changeDeptManager(@RequestParam Integer staffId, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(6, 0)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";

		}
		if (staffId == null) {
			return "deptManager_change";

		}
		Staff staff = accountService.selectStaffById(staffId);
		Account account = accountMapper.selectByStaffId(staffId);
		if (staff == null || account == null) {
			m.addAttribute("message", "晋升员工不存在");
		}
		if (accountService.changeDeptManager(staff.getDeptId(), staffId)) {
			m.addAttribute("message", "成功");
		}

		List<Dept> depts = accountService.selectDeptInfo();
		m.addAttribute("depts", depts);
		return "dept_all";

	}

}
