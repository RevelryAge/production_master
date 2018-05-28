package cn.lp.service;

import com.github.pagehelper.PageInfo;

import cn.lp.po.account.Account;
import cn.lp.po.account.Staff;
import cn.lp.po.part.Part;
import cn.lp.po.part.PartTechnology;

public interface PartService {

//	Staff selectStaffInfo();
//	//用来查询自身的信息
//	Boolean addStaff(Staff staff);
//	Boolean quitStaff(Integer id);
//	Boolean addAccount(Account account);
//	Boolean changeStaff(Staff staff);
//	Boolean checkQuit(Integer id );
	Part selectPartById(Integer id);
	PageInfo<Part> selectAllPart(int page);
	PartTechnology selectPartTechById(Integer id);
	PageInfo<PartTechnology> selectAllPartTechByPartId(Integer id,Integer page);
	Boolean changePartTech(PartTechnology partTech);
	Boolean addPartTech(PartTechnology partTech);
	Boolean deletePartTechById(Integer id);
	PartTechnology selectPartTechByCount(Integer count ,Integer id);
	Boolean addPart(Part part);
//	Staff addDept(Staff staff);
//	Staff addAccountToStaff(Staff staff);
	
}
