package cn.lp.control.account;

import cn.lp.util.BaseUtil;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.lp.check.PowerCheck;
import cn.lp.mapper.account.AccountMapper;
import cn.lp.mapper.account.DeptMapper;
import cn.lp.mapper.account.StaffMapper;
import cn.lp.po.account.Account;
import cn.lp.po.account.Dept;
import cn.lp.po.account.Staff;
import cn.lp.service.AccountService;

@Controller
public class LoginController {
	@Autowired
	AccountMapper accountMapper;
	@Autowired
	StaffMapper staffMapper;
	@Autowired
	DeptMapper deptMapper;
	@Autowired
	AccountService accountService;
	 @RequestMapping("/")
	    public String hello(Model m) {
	        return "login";
	    }
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
		return "redirect:gologin";
	}
	@RequestMapping("/updatePassword")
	public String updatePassWord(Model m, Account account, String password1) {

		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (account != null) {
			Account accountTemp = accountMapper.login(account);

			if (accountTemp != null) {

				account.setPassword(password1);
				accountMapper.updateByPrimaryKeySelective(account);
				m.addAttribute("message", "修改成功 ，请重新登陆");
				return "login";
			} else
				m.addAttribute("message", "密码错误， 修改失败 ，请重试");
		}

		return "updatePassword";
	}

	@RequestMapping("/goupdatePassword")
	public String goUpdate(Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		return "updatePassword";
	}

	@RequestMapping("/selfInfo")
	public String selfInfo(Model m) {
		if (!PowerCheck.check())
			if (!PowerCheck.check()) {
				m.addAttribute("message", "请登录");
				return "login";
			}
		Staff staff = accountService.selectStaffInfo();
		m.addAttribute("staffinfo", staff);
		return "selfInfo";
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
