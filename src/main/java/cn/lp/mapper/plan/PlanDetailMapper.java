package cn.lp.mapper.plan;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.lp.po.plan.PlanDetail;
@Mapper
public interface PlanDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlanDetail record);

    int insertSelective(PlanDetail record);

    PlanDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlanDetail record);

    int updateByPrimaryKey(PlanDetail record);
    
    List<PlanDetail> selectPlanDetailByPlanId(Integer planId);
    
    
}