package cn.lp.service;

import com.github.pagehelper.PageInfo;

import cn.lp.po.account.Account;
import cn.lp.po.account.Staff;

public interface AccountService {

	Staff selectStaffInfo();
	//用来查询自身的信息
	Boolean addStaff(Staff staff);
	Boolean quitStaff(Integer id);
	Boolean addAccount(Account account);
	Boolean changeStaff(Staff staff);
	Boolean checkQuit(Integer id );
	Staff selectStaffById(Integer id);
	PageInfo<Staff> selectAllStaff(int page);
	Staff addDept(Staff staff);
	Staff addAccountToStaff(Staff staff);
	
}
