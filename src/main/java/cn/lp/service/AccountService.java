package cn.lp.service;

import cn.lp.po.account.Staff;

public interface AccountService {

	Staff selectStaffInfo();
	Boolean addStaff(Staff staff);
}
