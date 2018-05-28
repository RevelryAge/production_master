package cn.lp.mapper.part;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.lp.po.part.Part;
@Mapper
public interface PartMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Part record);

	int insertSelective(Part record);

	Part selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Part record);

	int updateByPrimaryKey(Part record);

	List<Part> selectAllPart();
}