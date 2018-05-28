package cn.lp.mapper.plan;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.lp.po.plan.Plan;

@Mapper
public interface PlanMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Plan record);

	int insertSelective(Plan record);

	Plan selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Plan record);

	int updateByPrimaryKey(Plan record);

	List<Plan> selectALLPlan();
	//查询所有Plan
}