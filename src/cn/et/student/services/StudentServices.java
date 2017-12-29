package cn.et.student.services;

import cn.et.student.entity.Student;
import cn.et.student.entity.StudentExample;
import cn.et.student.utils.Pager;

public interface StudentServices {

	/**
	 * 根据学生姓名查询学生
	 * @param page
	 * @param stuName
	 * @param rows
	 * @return
	 */
	public Pager queryStus(Integer page,String queryValue,Integer rows , Integer queryType);

	/**
	 * 获取总记录数
	 * @param example
	 * @return
	 */
	public abstract int getTotal(StudentExample example);

	/**
	 * 根据ID删除学生信息
	 * @param sid
	 */
	public abstract void deleteStudentById(Integer sid);

	public abstract void updateStu(Student student);

	public abstract void insertStu(Student student);
	
	public abstract void deleteStudentsByIdArray(String idArray);

}