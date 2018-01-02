package cn.et.entity;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Result {
	private int code;
	private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * 取异常堆栈的前500个字符就好
	 * @return
	 */
	public String getMessage() {
		if (message != null && message.length() > 500) {
			return message.substring(0 , 500);
		}
		return message;
	}
	/**
	 * 将异常堆栈信息设置到message上
	 * @param msg
	 */
	public void setMessage(Exception msg) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		msg.printStackTrace(new PrintStream(baos));
		this.message = new String(baos.toByteArray());
	}
}
