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
import cn.lp.po.account.Dept;
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
		PageHelper.startPage(page,10);
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

	@Override
	public List<Dept> selectDeptInfo() {
		// TODO Auto-generated method stub

		List<Dept> depts = deptMapper.selectAllDept();

		return depts;
	}

	@Override
	public Boolean changeDeptManager(int deptId, int staffId) {
		// TODO Auto-generated method stub

		// 认为已经验证完成
		Dept dept = deptMapper.selectByPrimaryKey(deptId);
		int staffIdBefore = dept.getStaffId();
		Account accountBefor = accountMappper.selectByStaffId(staffIdBefore);
		dept.setId(deptId);
		dept.setStaffId(staffId);
		Account account = accountMappper.selectByStaffId(staffId);
		account.setStaffId(staffId);
		accountBefor.setGrade(1);
		account.setGrade(2);
		if (accountMappper.updateByPrimaryKeySelective(account) == 1) {//将晋升后的账户权限修改
			if (accountMappper.updateByPrimaryKeySelective(accountBefor) == 1) {//将降级的账户权限修改
				if (deptMapper.updateByPrimaryKeySelective(dept) == 1)
					return true;
			}
		}

		return false;
	}

}
