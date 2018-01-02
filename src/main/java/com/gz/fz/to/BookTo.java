package com.gz.fz.to;

import java.util.HashMap;
import java.util.List;

import com.gz.fz.model.Book;
import com.gz.fz.model.EpubMetadata;
import com.gz.fz.model.EpubPage;
import com.gz.fz.model.EpubSpine;

import net.sf.json.JSONObject;

public class BookTo {

	private Book book;
	private InitParamsTo params;
	private EpubMetadata metadata;
	private List<EpubPage> pages;
	private List<EpubSpine> spines;
	
	public static BookTo parse(String json) {
		HashMap<String, Object> attr = new HashMap<String,Object>();
		attr.put("book", Book.class);
		attr.put("params", InitParamsTo.class);
		attr.put("metadata", EpubMetadata.class);
		attr.put("pages", EpubPage.class);
		attr.put("spines", EpubSpine.class);
		
		JSONObject obj = JSONObject.fromObject(json);
		return (BookTo) JSONObject.toBean(obj, BookTo.class, attr);
	}
	
	public InitParamsTo getParams() {
		return params;
	}
	public void setParams(InitParamsTo params) {
		this.params = params;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public EpubMetadata getMetadata() {
		return metadata;
	}
	public void setMetadata(EpubMetadata metadata) {
		this.metadata = metadata;
	}
	public List<EpubPage> getPages() {
		return pages;
	}
	public void setPages(List<EpubPage> pages) {
		this.pages = pages;
	}
	public List<EpubSpine> getSpines() {
		return spines;
	}
	public void setSpines(List<EpubSpine> spines) {
		this.spines = spines;
	}
	
}
