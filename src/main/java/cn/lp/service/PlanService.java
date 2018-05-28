package cn.lp.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.lp.po.plan.Manufacture;
import cn.lp.po.plan.Plan;
import cn.lp.po.plan.PlanDetail;

public interface PlanService {

	// Part selectPartById(Integer id);
	// PageInfo<Part> selectAllPart(int page);
	// PartTechnology selectPartTechById(Integer id);
	// PageInfo<PartTechnology> selectAllPartTechByPartId(Integer id,Integer page);
	// Boolean changePartTech(PartTechnology partTech);
	// Boolean addPartTech(PartTechnology partTech);
	// Boolean deletePartTechById(Integer id);
	// PartTechnology selectPartTechByCount(Integer count ,Integer id);
	PageInfo<Plan> selectAllPlan(int page);

	Plan selectPlanById(Integer id);

	Boolean addPlan(Plan plan);

	Boolean deletePlan(Integer id);

	PageInfo<PlanDetail> selectAllPlanDetailByPlanId(int page, int planId);

	List<PlanDetail> selectPlanDetailByPlanId(Integer planId);

	PlanDetail selectPlanDetailById(Integer id);

	Boolean addPlanDetail(PlanDetail planDetail);

	Boolean changePlanDetail(PlanDetail planDetail);

	Boolean deletePlanDetail(Integer id);

	PageInfo<Manufacture> selectAllManufacture(int page, Manufacture manu);

	PageInfo<Manufacture> selectAllManufacture(int page);

	Manufacture addPartName(Manufacture manu);
	
	Manufacture selectManuById(Integer id);
	
	Boolean addMaun(Manufacture manu);

	Boolean changeMaun(Manufacture manu);

	Boolean deleteMaun(Integer id);
	

}
