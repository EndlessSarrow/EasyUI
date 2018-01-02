package cn.et.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.dao.dept.DeptMapper;
import cn.et.dao.emp.EmpMapper;
import cn.et.entity.TreeNode;
import cn.et.entity.dept.Dept;
import cn.et.entity.dept.DeptExample;
import cn.et.entity.emp.Emp;
import cn.et.entity.emp.EmpExample;
import cn.et.services.DeptService;
import cn.et.utils.Pager;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper deptMapper;

	@Autowired
	private EmpMapper empMapper;

	public List<TreeNode> queryTreeNode(Integer pId) {

		DeptExample de = new DeptExample();

		// 根据Pid获取节点
		de.createCriteria().andPidEqualTo(pId);

		// 获取查询到的dept
		List<Dept> depts = deptMapper.selectByExample(de);

		// 声明节点List，将Dept封装到节点中
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();

		/*
		 * TreeNode添加数据，一个部门就是一个节点
		 */
		for (Dept dept : depts) {
			TreeNode tn = new TreeNode();
			tn.setId(dept.getDeptno());
			tn.setText(dept.getDname());

			// 递归用于查询是否还存在子节点，如果没有就停止加载
			if (queryTreeNode(dept.getDeptno()).size() == 0) {
				tn.setState("open");
			}
			treeNodes.add(tn);
		}

		return treeNodes;
	}

	/**
	 * 根据部门编号获取部门列表
	 * 
	 * @param id
	 * @return
	 */
	public List<Dept> queryDepts(Integer id) {
		DeptExample de = new DeptExample();

		// 根据Pid获取节点
		de.createCriteria().andDeptnoEqualTo(id);

		// 获取查询到的dept
		List<Dept> depts = deptMapper.selectByExample(de);
		return depts;
	}

	/**
	 * 获取所有部门
	 * 
	 * @return
	 */
	public List<Dept> getAllDepts() {
		DeptExample de = new DeptExample();

		// 根据Pid获取节点
		de.createCriteria().andDnameLike("%%");
		return deptMapper.selectByExample(de);
	}

	/**
	 * 根据部门编号查询部门下所有员工
	 * 
	 * @param id
	 * @return
	 */
	public Pager queryEmpsByPId(Integer id, Integer page, Integer rows) {
		
		// 创建实例 
		EmpExample empExample = new EmpExample();
		
		// 查询条件
		empExample.createCriteria().andDeptnoEqualTo(id);
		
		// 获取总记录数
		int total = getTotal(empExample);

		// 初始化pager
		Pager pager = new Pager(page, total, rows);

		// 初始化RowBounds设置分页起点(偏移位置,MySQL默认从0开始)以及每页大小
		RowBounds rowBounds = new RowBounds(pager.getStartIndex() - 1, rows);
		
		List<Emp> list = empMapper.selectByExampleWithRowbounds(empExample, rowBounds);
		
		pager.setRows(list);

		return pager;
	}

	/**
	 * 获取总记录数
	 * 
	 * @param example
	 * @return
	 */
	public int getTotal(EmpExample example) {
		return (int) empMapper.countByExample(example);
	}
}
