package cn.et.student.services;

import java.util.List;

import cn.et.student.entity.TreeNode;
import cn.et.student.entity.dept.Dept;
import cn.et.student.utils.Pager;

public interface DeptService {

	public abstract List<TreeNode> queryTreeNode(Integer pId);
	
	public Pager queryEmpsByPId(Integer id, Integer page,Integer rows);

	public List<Dept> queryDepts(Integer id);
	
	public List<Dept> getAllDepts();
}