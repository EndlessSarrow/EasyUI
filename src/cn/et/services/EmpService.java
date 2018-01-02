package cn.et.services;

import cn.et.entity.emp.Emp;

public interface EmpService {

	// 新增员工
	public abstract void saveEmp(Emp emp);

	public abstract void updateEmp(Emp emp);

	public abstract void deleteEmp(Integer empid);

	/**
	 * 批量删除
	 * @param idString
	 */
	public abstract void deleteBath(String idString);

}