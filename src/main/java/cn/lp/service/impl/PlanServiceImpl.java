package cn.lp.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.lp.mapper.part.PartMapper;
import cn.lp.mapper.part.PartTechnologyMapper;
import cn.lp.mapper.plan.ManufactureMapper;
import cn.lp.mapper.plan.PlanDetailMapper;
import cn.lp.mapper.plan.PlanMapper;
import cn.lp.po.plan.Manufacture;
import cn.lp.po.plan.Plan;
import cn.lp.po.plan.PlanDetail;
import cn.lp.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {
	@Autowired
	PartMapper partMapper;
	@Autowired
	PlanMapper planMapper;
	@Autowired
	PlanDetailMapper planDetailMapper;
	@Autowired
	ManufactureMapper manuMapper;
	@Autowired
	PartTechnologyMapper partTechMapper;

	@Override
	public PageInfo<Plan> selectAllPlan(int page) {
		// TODO Auto-generated method stub

		PageHelper.startPage(page, 10);
		List<Plan> plans = planMapper.selectALLPlan();
		PageInfo<Plan> p = new PageInfo<>(plans);
		return p;
	}

	@Override
	public Plan selectPlanById(Integer id) {
		// TODO Auto-generated method stub
		return planMapper.selectByPrimaryKey(id);
	}

	@Override
	public Boolean addPlan(Plan plan) {
		// TODO Auto-generated method stub
		if (planMapper.insert(plan) == 1)
			return true;
		return false;

	}

	@Override
	public Boolean deletePlan(Integer id) {
		// TODO Auto-generated method stub
		if (planMapper.deleteByPrimaryKey(id) == 1)
			return true;
		return false;
	}

	@Override
	public PageInfo<PlanDetail> selectAllPlanDetailByPlanId(int page, int planId) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);

		PageInfo<PlanDetail> p = new PageInfo<>(selectPlanDetailByPlanId(planId));
		return p;
	}

	@Override
	public List<PlanDetail> selectPlanDetailByPlanId(Integer planId) {
		// TODO Auto-generated method stub

		return planDetailMapper.selectPlanDetailByPlanId(planId);
	}

	@Override
	public PlanDetail selectPlanDetailById(Integer id) {
		// TODO Auto-generated method stub
		return planDetailMapper.selectByPrimaryKey(id);
	}

	@Override
	public Boolean addPlanDetail(PlanDetail planDetail) {
		// TODO Auto-generated method stub
		if (planDetailMapper.insert(planDetail) == 1)
			return true;
		return false;
	}

	@Override
	public Boolean changePlanDetail(PlanDetail planDetail) {
		// TODO Auto-generated method stub

		if (planDetailMapper.updateByPrimaryKeySelective(planDetail) == 1)
			return true;
		return false;
	}

	@Override
	public Boolean deletePlanDetail(Integer id) {
		// TODO Auto-generated method stub
		if (planDetailMapper.deleteByPrimaryKey(id) == 1)
			return true;
		return false;
	}

	@Override
	public PageInfo<Manufacture> selectAllManufacture(int page, Manufacture manu) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		List<Manufacture> manus = manuMapper.selectManufactureSelective(manu);

		for (Iterator<Manufacture> iterator = manus.iterator(); iterator.hasNext();) {
			Manufacture manufacture = (Manufacture) iterator.next();
			addPartName(manufacture);
		}
		PageInfo<Manufacture> p = new PageInfo<>(manus);

		return p;
	}

	@Override
	public PageInfo<Manufacture> selectAllManufacture(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		List<Manufacture> manus = manuMapper.selectManu();

		for (Iterator<Manufacture> iterator = manus.iterator(); iterator.hasNext();) {
			Manufacture manufacture = (Manufacture) iterator.next();
			addPartName(manufacture);
		}
		PageInfo<Manufacture> p = new PageInfo<>(manus);

		return p;
	}

	@Override
	public Manufacture addPartName(Manufacture manu) {
		// TODO Auto-generated method stub
		int id;
		id = partTechMapper.selectByPrimaryKey(manu.getPartTechnologyId()).getPartId();
		manu.setPartName(partMapper.selectByPrimaryKey(id).getName());
		return manu;
	}

	@Override
	public Manufacture selectManuById(Integer id) {
		// TODO Auto-generated method stub
		return manuMapper.selectByPrimaryKey(id);
	}

	@Override
	public Boolean addMaun(Manufacture manu) {
		// TODO Auto-generated method stub
		if (manuMapper.insert(manu) == 1)
			return true;
		return false;
	}

	@Override
	public Boolean changeMaun(Manufacture manu) {
		// TODO Auto-generated method stub
		if (manuMapper.updateByPrimaryKeySelective(manu) == 1)
			return true;
		return false;
	}

	@Override
	public Boolean deleteMaun(Integer id) {
		// TODO Auto-generated method stub
		if (manuMapper.deleteByPrimaryKey(id) == 1)
			return true;

		return false;
	}

}
