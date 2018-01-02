package com.gz.fz.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

/**
 * Annotator JSON 对象实体类
 * 
 * {
    "quote": "TTText",
    "ranges": [
        {
            "start": "/p[34]",
            "startOffset": 140,
            "end": "/p[34]",
            "endOffset": 148
        }
    ],
    "text": "bbb"
 *}
 * @author georgezou
 *
 */
public class Annotator {

	private Integer id;
	private Date created;
	private String text;
	private String quote;
	private String uri;
	private String token;
	private Integer user_id;
	private String description;
	private Integer book_id;
	private String chapter;
	private Double percentage;
	
	public static Annotator parse(String json) {
		HashMap<String, Object> attr = new HashMap<String,Object>();
		attr.put("ranges", Ranges.class);
		JSONObject obj = JSONObject.fromObject(json);
		return (Annotator) JSONObject.toBean(obj, Annotator.class, attr);
	}
	
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	private List<Ranges> ranges;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public List<Ranges> getRanges() {
		return ranges;
	}
	public void setRanges(List<Ranges> ranges) {
		this.ranges = ranges;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

}
