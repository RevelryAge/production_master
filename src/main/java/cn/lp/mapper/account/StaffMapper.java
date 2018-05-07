package cn.lp.mapper.account;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.lp.po.account.Staff;

@Mapper
public interface StaffMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Staff record);

	int insertSelective(Staff record);

	Staff selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Staff record);

	int updateByPrimaryKey(Staff record);

	Staff Check(Integer id);
	
	List<Staff> findAll();
	int updateState(@Param("id")Integer id,@Param("state")String state);

}