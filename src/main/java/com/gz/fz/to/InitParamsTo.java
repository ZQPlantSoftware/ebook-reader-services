package com.gz.fz.to;


import com.gz.fz.utils.SecretTool;

import net.sf.json.JSONObject;

public class InitParamsTo {

	public InitParamsTo () {}
	
	
	private String id;				// 阅读器数据库中的ID
	private String bid;				// 书籍ID
	private Integer uid;
	private String url;
	private Integer probation;
	private String token;
	
	public static InitParamsTo jParse(String json) {
		JSONObject obj = JSONObject.fromObject(json);
		return (InitParamsTo) JSONObject.toBean(obj, InitParamsTo.class);
	}
	
	public static InitParamsTo sParse(String sec) throws Exception {
		SecretTool secTool = new SecretTool("epubReader!@#8989");
		String json = secTool.decrypt(sec);
		return jParse(json);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getProbation() {
		return probation;
	}
	public void setProbation(Integer probation) {
		this.probation = probation;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
