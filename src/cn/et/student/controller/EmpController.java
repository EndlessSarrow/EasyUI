package cn.et.student.controller;

import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.et.student.entity.Result;
import cn.et.student.entity.emp.Emp;
import cn.et.student.services.EmpService;

@Controller
public class EmpController {

	@Autowired
	private EmpService services;

	/**
	 * 批量删除员工
	 * @param idString
	 * @param os
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteEmp", method = RequestMethod.DELETE)
	public Result deleteEmpsById(String idString, OutputStream os) {
		Result result = new Result();
		System.out.println(idString);
		// 1表示成功
		result.setCode(1);
		try {
			services.deleteBath(idString);
		} catch (Exception e) {
			result.setCode(0);
			result.setMessage(e);
		}
		return result;
	}

	/**
	 * 修改员工信息
	 * 
	 * @param sid
	 * @param student
	 * @param os
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateEmp/{empid}", method = RequestMethod.PUT)
	public Result updateStudent(@PathVariable Integer empid , Emp emp, OutputStream os) {
		Result result = new Result();
		emp.setEmpno(empid);
		// 1表示成功
		result.setCode(1);
		try {
			services.updateEmp(emp);
		} catch (Exception e) {
			result.setCode(0);
			result.setMessage(e);
		}
		return result;
	}

	
	@ResponseBody
	@RequestMapping(value = "addEmp", method = RequestMethod.POST)
	public Result addStudent(Emp emp, OutputStream os , MultipartFile studentImage) {
		Result result = new Result();
		// 1表示成功
		result.setCode(1);
		try {
			services.saveEmp(emp);
		} catch (Exception e) {
			result.setCode(0);
			result.setMessage(e);
		}
		return result;
	}
}
