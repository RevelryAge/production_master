package cn.lp.mapper.plan;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.lp.po.plan.Manufacture;


@Mapper
public interface ManufactureMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Manufacture record);

	int insertSelective(Manufacture record);

	Manufacture selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Manufacture record);

	int updateByPrimaryKey(Manufacture record);

	List<Manufacture> selectManufactureSelective(Manufacture manu);

	List<Manufacture> selectManu();
	
	List<Manufacture> selectManuByPlanDetail(int id);
	
}