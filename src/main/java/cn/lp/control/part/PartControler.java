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
		if (!PowerCheck.check(2)) {
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
		if (!PowerCheck.check(2)) {
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

	/*
	 * @RequestMapping("/go_change_staff2") public String goChangStaff(Model
	 * m,Integer id ) { if (!PowerCheck.check()) { m.addAttribute("message", "请登录");
	 * return "login"; } if (!PowerCheck.check(6)) { m.addAttribute("message",
	 * "不好意思 没有权限"); return "index"; } Staff staffinfo =
	 * accountService.selectStaffById(id); staffinfo =
	 * accountService.addDept(staffinfo); m.addAttribute("staffinfo", staffinfo);
	 * 
	 * return "change_staff"; }
	 * 
	 * @RequestMapping("/change_staff1") public String changStaffInfo(Staff
	 * staff,Model m) { if (!PowerCheck.check()) { m.addAttribute("message", "请登录");
	 * return "login"; } if (!PowerCheck.check(5)) { m.addAttribute("message",
	 * "不好意思 没有权限"); return "index"; }
	 * 
	 * if(staff.getId()==null) { m.addAttribute("message", "请填写"); return
	 * "redirect:go_change_staff"; }
	 * 
	 * if(accountService.changeStaff(staff)) {
	 * 
	 * m.addAttribute("message", "修改成功"); return "index"; } return
	 * "redirect:go_change_staff";
	 * 
	 * }
	 * 
	 * @RequestMapping("/staff_quit2") public String staffQuit( @RequestParam int
	 * id, Model m) { if (!PowerCheck.check()) { m.addAttribute("message", "请登录");
	 * return "login"; } if (!PowerCheck.check(5,0)) { m.addAttribute("message",
	 * "不好意思 没有权限");
	 * 
	 * } if(accountService.quitStaff(id)) m.addAttribute("message", "离职成功"); else
	 * m.addAttribute("message", "离职失败"); System.out.println(1); return "index";
	 * 
	 * }
	 */

}
