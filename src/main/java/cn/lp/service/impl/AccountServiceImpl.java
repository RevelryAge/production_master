package cn.lp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.lp.mapper.account.AccountMapper;
import cn.lp.mapper.account.DeptMapper;
import cn.lp.mapper.account.StaffMapper;
import cn.lp.po.account.Account;
import cn.lp.po.account.Staff;
import cn.lp.service.AccountService;
import cn.lp.util.BaseUtil;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	StaffMapper staffMapper;
	@Autowired
	DeptMapper deptMapper;
	@Autowired
	AccountMapper accountMappper;

	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public Staff selectStaffInfo() {
		// TODO Auto-generated method stub
		Account a = (Account) BaseUtil.getSession().getAttribute("account");
		Staff staff = staffMapper.selectByPrimaryKey(a.getStaffId());

		staff = addDept(staff);
		return staff;
	}

	public Boolean addStaff(Staff staff) {
		// TODO Auto-generated method stub
		if (staffMapper.insertSelective(staff) == 1)
			return true;
		return false;
	}

	public Boolean addAccount(Account account) {
		// TODO Auto-generated method stub
		if (accountMappper.insertSelective(account) == 1) {
			staffMapper.updateState(account.getStaffId(), "在职");
			return true;

		}
		return false;
	}

	@Override
	public Staff selectStaffById(Integer id) {
		// TODO Auto-generated method stub
		return staffMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<Staff> selectAllStaff(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		List<Staff> staffs = staffMapper.findAll();
		PageInfo<Staff> p = new PageInfo<>(staffs);

		return p;
	}

	@Override
	public Staff addDept(Staff staff) {
		// TODO Auto-generated method stub
		// 给staff加上dept 变成po类

		staff.setDept(deptMapper.selectByPrimaryKey(staff.getDeptId()));

		return staff;
	}

	@Override
	public Boolean changeStaff(Staff staff) {
		// TODO Auto-generated method stub
		if (staffMapper.updateByPrimaryKeySelective(staff) == 1) {
			return true;
		}

		return false;
	}

	@Override
	public Boolean quitStaff(Integer id) {
		// TODO Auto-generated method stub
		if (checkQuit(id)) {

			int accountId = accountMappper.selectByStaffId(id).getId();
			if (accountMappper.deleteByPrimaryKey(accountId) == 1) {
				staffMapper.updateState(id, "离职");
				System.out.println(2);
				return true;
			}
		}

		return false;
	}

	@Override
	public Boolean checkQuit(Integer id) {
		// TODO Auto-generated method stub
		// 解决是否有工作未完成
		return true;
	}

	@Override
	public Staff addAccountToStaff(Staff staff) {
		// TODO Auto-generated method stub
		Account account = accountMappper.selectByStaffId(staff.getId());
		if (account != null)
			account.setPassword(null);
		staff.setAccount(account);
		return staff;
	}

}
