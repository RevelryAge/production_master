package cn.lp.check;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import cn.lp.mapper.account.DeptMapper;
import cn.lp.po.account.Account;
import cn.lp.po.account.Dept;
import cn.lp.po.account.Staff;
import cn.lp.util.BaseUtil;

public class PowerCheck {
	@Autowired
	DeptMapper deptMapper;

	public static boolean check() {
		// 验证是否登陆

		HttpSession s = BaseUtil.getSession();
		if (s.getAttribute("account") != null) {

			return true;
		}
		return false;

	}

	public static boolean check(int i) {
		// 验证部门普通员工权限
		HttpSession s = BaseUtil.getSession();
		Account a = (Account) s.getAttribute("account");
		try {
			if (a.getGrade() >= 3) {
				return true;
			}

			Staff staff = (Staff) s.getAttribute("staff");

			if (staff.getDeptId() == i || staff.getDeptId() == 6)
				return true;

			return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public static boolean check(int i, byte j) {
		// 验证经理级别权限
		HttpSession s = BaseUtil.getSession();
		Account a = (Account) s.getAttribute("account");
		try {
		if (a.getGrade() >= 3) {
			return true;
		}
		Staff staff = (Staff) s.getAttribute("staff");
		if (staff.getId() == staff.getDept().getStaffId())
			return true & check(i);
		return false;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
