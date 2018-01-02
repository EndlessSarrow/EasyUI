package cn.et.services.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.dao.StudentMapper;
import cn.et.entity.Student;
import cn.et.entity.StudentExample;
import cn.et.entity.StudentExample.Criteria;
import cn.et.services.StudentServices;
import cn.et.utils.Pager;

@Service
public class StudentServicesImpl implements StudentServices {
	
	@Autowired
	private StudentMapper mapper;
	
	/**
	 * 根据学生姓名查询学生
	 * @param page
	 * @param stuName
	 * @param rows
	 * @return
	 */
	public Pager queryStus(Integer page,String queryValue,Integer rows , Integer queryType){
		
		// 创建Example实例
		StudentExample sc = new StudentExample();
		
		// 获取用于添加查询条件的Criteria
		Criteria criteria = sc.createCriteria();
		
		//  根据查询方式添加条件
		switch (queryType == null ? 0 : queryType) {
		case 1:
			criteria.andSidEqualTo(Integer.parseInt(queryValue));
		break;
		case 2:
			criteria.andAddressLike("%" + queryValue + "%");
		break;
		default:
			criteria.andSnameLike("%" + queryValue + "%");
			break;
		}
		
		// 获取总记录数
		int total = getTotal(sc);
		
		// 初始化pager
		Pager pager = new Pager(page, total, rows);
		
		// 初始化RowBounds设置分页起点(偏移位置,MySQL默认从0开始)以及每页大小
		RowBounds rowBounds = new RowBounds(pager.getStartIndex() - 1, rows);
		
		// 将example和rowBounds作为参数传递到selectByExampleWithRowbounds方法中
		List<Student> list = mapper.selectByExampleWithRowbounds(sc, rowBounds);
		
		// 塞到pager类里面
		pager.setRows(list);
		
		return pager;
	}
	
	/**
	 * 获取总记录数
	 * @param example
	 * @return
	 */
	public int getTotal(StudentExample example){
		return (int) mapper.countByExample(example);
	}
	
	/**
	 * 根据ID删除学生信息
	 * @param sid
	 */
	public void deleteStudentById(Integer sid){
		mapper.deleteByPrimaryKey(sid);
	}
	
	/**
	 * 批量删除
	 */
	public void deleteStudentsByIdArray(String idString){
		
		// 前台拼接后的字符串首位会有[]符号,去掉之后再根据逗号分隔
		idString = idString.substring(1, idString.length() - 1);
		
		// 根据逗号分隔成数组
		String [] idArray = idString.split(",");
		for (String stuId : idArray) {	//  遍历删除
			deleteStudentById(Integer.parseInt(stuId));
		}
	}
	
	/**
	 * 更新学生信息
	 */
	public void updateStu(Student student){
		mapper.updateByPrimaryKey(student);
	}
	
	/**
	 * 添加学生
	 */
	public void insertStu(Student student){
		mapper.insert(student);
	}
}
