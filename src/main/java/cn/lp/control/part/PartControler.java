package cn.lp.control.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.lp.check.PowerCheck;
import cn.lp.po.part.Part;

import cn.lp.service.PartService;

@Controller

public class PartControler {

	@Autowired
	PartService partService;

	@RequestMapping("part_all")
	public String selectAll(@RequestParam(required = true, defaultValue = "1") int page, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (PowerCheck.check(5) && !PowerCheck.check(6)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		PageInfo<Part> pageInfo = partService.selectAllPart(page);
		m.addAttribute(pageInfo);
		return "part_all";

	}

	@RequestMapping("part_info")
	public String partinfo(@RequestParam int id, Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (PowerCheck.check(5) && !PowerCheck.check(6)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}
		Part part = partService.selectPartById(id);
		m.addAttribute("partinfo", part);
		return "part_info";

	}

	@RequestMapping("part_go_add")
	public String goChangePlanDetail(Model m) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(3, 2)) {
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}

		return "part_add";
	}

	@RequestMapping("/part_add")
	public String addPlanDetail(Model m, Part part) {
		if (!PowerCheck.check()) {
			m.addAttribute("message", "请登录");
			return "login";
		}
		if (!PowerCheck.check(3, 2)) {
			System.out.println(part);
			m.addAttribute("message", "不好意思 没有权限");
			return "index";
		}

		if (part.getName() == null) {

			return "index";
		}
		part.setState("未完成");

		if (!partService.addPart(part)) {
			m.addAttribute("message", "插入失败");

		} else {
			m.addAttribute("message", "成功");
		}

		return "redirect:part_all";

	}

}
