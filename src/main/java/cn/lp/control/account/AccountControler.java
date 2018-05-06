package cn.lp.control.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lp.check.PowerCheck;
import cn.lp.mapper.account.AccountMapper;
import cn.lp.po.account.Account;
import cn.lp.po.account.Staff;
import cn.lp.service.AccountService;
import cn.lp.util.BaseUtil;

@Controller
public class AccountControler {
	@Autowired
	AccountMapper accountMapper;
	@Autowired AccountService accountService;
	@RequestMapping("/updatePassword")
	public String updatePassWord(Model m, Account account, String password1) {
		if(!PowerCheck.check())
			return "redirect:gologin";
		if (account != null ) {
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
	public String goUpdate() {
		if(!PowerCheck.check())
			return "redirect:gologin";
		return "updatePassword";
	}

	@RequestMapping("/selfInfo")
	public String selfInfo(Model m) {
		if(!PowerCheck.check())
			return "redirect:gologin";
		Staff staff=accountService.selectStaffInfo();
		m.addAttribute("staffinfo", staff);
		return "selfInfo";
	}
	@RequestMapping("/goaddstaff")
	public String goaddinfo(Model m) {
		if(!PowerCheck.check(5)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "redirect:index";
		}
			
		return "addstaff";	
	}
	@RequestMapping("/addstaff")
	public String addinfo(Model m ,Staff staff) {
		if(!PowerCheck.check(5)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "redirect:index";
		}
		
		if(accountService.addStaff(staff))
		{
			m.addAttribute("message", "插入成功");
		}else {
			
			m.addAttribute("message", "插入失败");
		}
		
		return "index";	
		
	}
	
	
}
