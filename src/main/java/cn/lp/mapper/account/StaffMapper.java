package cn.lp.mapper.account;

import org.apache.ibatis.annotations.Mapper;

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

}