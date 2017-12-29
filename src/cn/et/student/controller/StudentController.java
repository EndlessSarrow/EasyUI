package cn.et.student.controller;

import java.io.File;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.et.student.entity.Result;
import cn.et.student.entity.Student;
import cn.et.student.services.StudentServices;
import cn.et.student.utils.Pager;

@Controller
public class StudentController {

	@Autowired
	private StudentServices services;
	private static final String ABS_PATH = "E:/Learning/temp/171212/"; 

	@ResponseBody
	@RequestMapping(value = "query", method = RequestMethod.GET)
	public Pager queryStusByName(Integer page, String queryValue, Integer rows ,Integer queryType) {
		return services.queryStus(page, queryValue, rows, queryType);
	}

	@ResponseBody
	@RequestMapping(value = "deleteStu", method = RequestMethod.DELETE)
	public Result deleteStudentById(String idString, OutputStream os) {
		Result result = new Result();
		// 1表示成功
		result.setCode(1);
		try {
			services.deleteStudentsByIdArray(idString);
		} catch (Exception e) {
			result.setCode(0);
			result.setMessage(e);
		}
		return result;
	}

	/**
	 * 修改学生信息
	 * 
	 * @param sid
	 * @param student
	 * @param os
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "update/{sid}", method = RequestMethod.PUT)
	public Result updateStudent(@PathVariable Integer sid, Student student,
			OutputStream os) {
		Result result = new Result();
		// 1表示成功
		result.setCode(1);
		try {
			services.updateStu(student);
		} catch (Exception e) {
			result.setCode(0);
			result.setMessage(e);
		}
		return result;
	}

	
	@ResponseBody
	@RequestMapping(value = "addStudent", method = RequestMethod.POST)
	public Result addStudent(Student student, OutputStream os , MultipartFile studentImage) {
		Result result = new Result();
		// 1表示成功
		result.setCode(1);
		try {
			
			services.insertStu(student);
			
			// 存储到本地
			File stuImg = new File(ABS_PATH + studentImage.getOriginalFilename());
			studentImage.transferTo(stuImg);
		} catch (Exception e) {
			result.setCode(0);
			result.setMessage(e);
		}
		return result;
	}
}
