package cn.lp.mapper.part;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.lp.po.part.PartTechnology;

@Mapper
public interface PartTechnologyMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(PartTechnology record);

	int insertSelective(PartTechnology record);

	PartTechnology selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(PartTechnology record);

	int updateByPrimaryKey(PartTechnology record);

	List<PartTechnology> selectAllPartTechByPartId(Integer id);

	PartTechnology selectPartTechByCount(@Param("count")Integer count,@Param("id")Integer id);

}