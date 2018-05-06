package cn.lp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lp.mapper.account.DeptMapper;
import cn.lp.mapper.account.StaffMapper;
import cn.lp.po.account.Account;
import cn.lp.po.account.Staff;
import cn.lp.service.AccountService;
import cn.lp.util.BaseUtil;
@Service
public class AccountServiceImpl implements AccountService {
@Autowired StaffMapper staffMapper;
@Autowired DeptMapper detpMapper;
	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public Staff selectStaffInfo() {
		// TODO Auto-generated method stub
		Account a=   (Account) BaseUtil.getSession().getAttribute("account");
		Staff staff=staffMapper.selectByPrimaryKey(a.getStaffId());
		int deptId=staff.getDeptId();
		staff.setDept(detpMapper.selectByPrimaryKey(deptId));
		return staff;
	}

	@Override
	public Boolean addStaff(Staff staff) {
		// TODO Auto-generated method stub
		if(staffMapper.insertSelective(staff)==1) 
			return true;
		return false;
	}

}
