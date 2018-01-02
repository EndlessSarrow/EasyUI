package cn.et.entity;

import java.util.ArrayList;
import java.util.List;

import cn.et.entity.dept.Dept;

public class TreeNode {

	private int id;
	private String text;
	private String state = "closed"; // 默认closed
	private List<Dept> list = new ArrayList<Dept>();
	
	public List<Dept> getList() {
		return list;
	}
	public void setList(List<Dept> list) {
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
