package cn.et.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.entity.TreeNode;
import cn.et.entity.dept.Dept;
import cn.et.services.DeptService;
import cn.et.utils.Pager;

@Controller
public class DeptController {

	@Autowired
	private DeptService deptService;

	@ResponseBody
	@RequestMapping(value = "queryDepts", method = RequestMethod.GET)
	public List<TreeNode> queryTreeNode(Integer id) {
		if (id == null) {
			id = 0; // 默认查根节点
		}
		return deptService.queryTreeNode(id);
	}

	@ResponseBody
	@RequestMapping(value = "queryDeptsById", method = RequestMethod.GET)
	public List<Dept> queryDepts(Integer id) {
		return deptService.queryDepts(id);
	}

	@ResponseBody
	@RequestMapping(value = "getAllDepts", method = RequestMethod.GET)
	public List<Dept> getAllDepts() {
		return deptService.getAllDepts();
	}

	@ResponseBody
	@RequestMapping(value = "queryEmps", method = RequestMethod.GET)
	public Pager queryEmps(Integer id, Integer page, Integer rows) {
		if (id == null) {
			id = 0; // 默认查根节点
		}
		return deptService.queryEmpsByPId(id, page, rows);
	}
}
