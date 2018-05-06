package cn.lp.control.account;

import cn.lp.util.BaseUtil;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.support.ModelAndViewContainer;

import cn.lp.check.PowerCheck;
import cn.lp.mapper.account.AccountMapper;
import cn.lp.mapper.account.DeptMapper;
import cn.lp.mapper.account.StaffMapper;
import cn.lp.po.account.Account;
import cn.lp.po.account.Dept;
import cn.lp.po.account.Staff;

@Controller
public class LoginController {
	@Autowired
	AccountMapper accountMapper;
	@Autowired
	StaffMapper staffMapper;
	@Autowired
	DeptMapper deptMapper;

	@RequestMapping("/login")
	public String login(Account accountTable, Model m) {
		// 已测试
		if(PowerCheck.check())
			return "redirect:index";
		Account account = accountMapper.login(accountTable);

		if (account != null) {

			m.addAttribute("message", "登陆成功！！！！");
			
			Staff staff = staffMapper.Check(account.getStaffId());
			Dept d = deptMapper.selectByPrimaryKey(staff.getDeptId());
			staff.setDept(d);
			HttpSession s = BaseUtil.getSession();
			System.out.println(staff.getDeptId());
			s.setAttribute("account", account);
			s.setAttribute("staff", staff);
			// System.out.println(account);
			return "redirect:index";
		} else if (accountTable != null)
			m.addAttribute("message", "登陆失败！！！！");
		return "login";
		/*
		 * System.out.println(id); return "index";
		 */

	}

	@RequestMapping("/gologin")
	public String goLogin() {
		if(PowerCheck.check())
			return "redirect:index";
		//用于接受其第一次登陆的请求
		return "login";
	
	}

	@RequestMapping("/logout")
	public String logout() {
		BaseUtil.getSession().invalidate();
		return "redirect:index";
	}

	@RequestMapping("/index")
	public String show(Model m) {
		if(!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		return "index";
	}
}
