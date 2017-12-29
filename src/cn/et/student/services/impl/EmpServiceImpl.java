package cn.et.student.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.student.dao.emp.EmpMapper;
import cn.et.student.entity.emp.Emp;
import cn.et.student.services.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpMapper mapper;

	// 新增员工
	public void saveEmp(Emp emp) {
		mapper.insert(emp);
	}

	public void updateEmp(Emp emp) {
		mapper.updateByPrimaryKey(emp);
	}

	public void deleteEmp(Integer empid) {
		mapper.deleteByPrimaryKey(empid);
	}

	/**
	 * 批量删除
	 * @param idString
	 */
	public void deleteBath(String idString) {
		// 前台拼接后的字符串首位会有[]符号,去掉之后再根据逗号分隔
		idString = idString.substring(1, idString.length() - 1);

		// 根据逗号分隔成数组
		String[] idArray = idString.split(",");
		for (String empid : idArray) { // 遍历删除
			deleteEmp(Integer.parseInt(empid));
		}
	}
}
