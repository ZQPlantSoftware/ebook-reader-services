package com.gz.fz.json;

public class BaseJson {

	public BaseJson() {}
	
	public BaseJson(String code, String msg) {
		this.setCode(code);
		this.setMsg(msg);
	}
	
	public BaseJson(String code, String msg, Object data) {
		this.setCode(code);
		this.setMsg(msg);
		this.setData(data);
	}
	
	public static BaseJson error(String msg) {
		BaseJson json = new BaseJson();
		json.setCode("500");
		json.setMsg(msg);
		return json;
	}
	
	public BaseJson(Object data) {
		this.setData(data);
	}
	
	private String msg = "SUCCESS";
	private String code = "200";
	private Object data;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
