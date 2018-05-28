package cn.lp.control.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.lp.check.PowerCheck;
import cn.lp.po.part.Part;
import cn.lp.po.part.PartTechnology;
import cn.lp.service.PartService;

@Controller

public class PartTechControler {
	@Autowired
	PartService partService;

	@RequestMapping("/part_tech_info")
	public String selectAllPartTech(@RequestParam(required = true, defaultValue = "1") int page, int id, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(2)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		m.addAttribute("partinfo", partService.selectPartById(id));

		PageInfo<PartTechnology> pageInfo = partService.selectAllPartTechByPartId(id, page);
		m.addAttribute(pageInfo);
		return "part_tech_info";

	}

	@RequestMapping("/part_tech_go_change")
	public String goChange(@RequestParam int techId, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(2)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		PartTechnology partTech = partService.selectPartTechById(techId);
		Part part = partService.selectPartById(partTech.getPartId());
		m.addAttribute("partinfo", part);
		m.addAttribute("partTech", partTech);

		return "part_tech_change";

	}

	@RequestMapping("/part_tech_change")
	public String ChangPartTech(Model m, PartTechnology partTech) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(2)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		if (partTech.getPartId() == null) {

			return "index";
		}
		PartTechnology partTech1 = partService.selectPartTechByCount(partTech.getCount(), partTech.getId());
		if (partTech1 != null) {
			if (partTech.getId() != partTech1.getId()) {
				m.addAttribute("message", "工序号已存在，请先删除");

				PageInfo<PartTechnology> pageInfo = partService.selectAllPartTechByPartId(partTech.getPartId(), 1);
				Part part = partService.selectPartById(partTech.getPartId());
				m.addAttribute("partinfo", part);
				m.addAttribute(pageInfo);
				return "part_tech_info";
			}
		}
		if (partService.changePartTech(partTech)) {
			m.addAttribute("message", "修改成功");

		} else {
			m.addAttribute("message", "修改失败");
		}

		PageInfo<PartTechnology> pageInfo = partService.selectAllPartTechByPartId(partTech.getPartId(), 1);
		m.addAttribute(pageInfo);
		return "part_tech_info";
	}

	@RequestMapping("/part_tech_go_add")
	public String goAddTech(Integer partId, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(2)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}

		/*
		 * if (.getId() == null) { m.addAttribute("message", "请填写"); return
		 * "redirect:go_change_staff"; }
		 */
		Part part = partService.selectPartById(partId);
		m.addAttribute("partinfo", part);

		return "part_tech_add";

	}

	@RequestMapping("/part_tech_add")
	public String addTech(PartTechnology partTech, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(5, 0)) {
			m.addAttribute("message", "不好意思 没有权限");

		}
		if (partTech.getPartId() == null) {

			return "index";
		}

		if (partService.selectPartTechByCount(partTech.getCount(), partTech.getId()) != null) {
			m.addAttribute("message", "工序号已存在，请先删除");
			System.out.println("工序号已存在，请先删除");
			PageInfo<PartTechnology> pageInfo = partService.selectAllPartTechByPartId(partTech.getPartId(), 1);
			Part part = partService.selectPartById(partTech.getPartId());
			m.addAttribute("partinfo", part);
			m.addAttribute(pageInfo);
			return "part_tech_info";
		}
		if (partService.addPartTech(partTech)) {
			m.addAttribute("message", "添加成功");

		} else {
			m.addAttribute("message", "添加失败");
		}

		PageInfo<PartTechnology> pageInfo = partService.selectAllPartTechByPartId(partTech.getPartId(), 1);
		m.addAttribute(pageInfo);
		return "part_tech_info";
	}

	@RequestMapping("/part_tech_delete")
	public String deletePartTech(Integer techId, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(5, 0)) {
			m.addAttribute("message", "不好意思 没有权限");

		}
		if (partService.selectPartTechById(techId) == null || techId == null) {

			return "index";
		}
		PartTechnology partTech = partService.selectPartTechById(techId);
		if (partService.deletePartTechById(techId)) {
			m.addAttribute("message", "删除成功");

		} else {
			m.addAttribute("message", "删除失败");
		}

		PageInfo<PartTechnology> pageInfo = partService.selectAllPartTechByPartId(partTech.getPartId(), 1);
		m.addAttribute(pageInfo);
		return "part_tech_info";
	}

}
