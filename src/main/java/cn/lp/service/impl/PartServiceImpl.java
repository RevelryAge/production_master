package cn.lp.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.lp.mapper.part.PartMapper;
import cn.lp.mapper.part.PartTechnologyMapper;
import cn.lp.po.part.Part;
import cn.lp.po.part.PartTechnology;

@Service
public class PartServiceImpl implements cn.lp.service.PartService {
	@Autowired
	PartMapper partMapper;
	@Autowired
	PartTechnologyMapper partTechMapper;

	@Override
	public PageInfo<Part> selectAllPart(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		List<Part> parts = partMapper.selectAllPart();
		PageInfo<Part> p = new PageInfo<>(parts);

		return p;
	}

	@Override
	public Part selectPartById(Integer id) {
		// TODO Auto-generated method stub
		return partMapper.selectByPrimaryKey(id);
	}

	@Override
	public PartTechnology selectPartTechById(Integer id) {
		// TODO Auto-generated method stub
		return partTechMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<PartTechnology> selectAllPartTechByPartId(Integer id, Integer page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		List<PartTechnology> partTech = partTechMapper.selectAllPartTechByPartId(id);
		Collections.sort(partTech);
		PageInfo<PartTechnology> p = new PageInfo<>(partTech);

		return p;
	}

	@Override
	public Boolean changePartTech(PartTechnology partTech) {
		// TODO Auto-generated method stub

		if (partTechMapper.updateByPrimaryKeySelective(partTech) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean addPartTech(PartTechnology partTech) {
		// TODO Auto-generated method stub
		if (partTechMapper.insertSelective(partTech) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletePartTechById(Integer id) {
		// TODO Auto-generated method stub
		if (partTechMapper.deleteByPrimaryKey(id) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public PartTechnology selectPartTechByCount(Integer count, Integer id) {
		// TODO Auto-generated method stub
		return partTechMapper.selectPartTechByCount(count, id);
	}

	@Override
	public Boolean addPart(Part part) {
		// TODO Auto-generated method stub
		
		if(partMapper.insert(part)==1) {
			return true;
		}
		return false;
	}

}
