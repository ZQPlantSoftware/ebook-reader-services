package com.gz.fz.to;

public class EpubSearch {

	/*
	 * baseCfi": "/6/60[chapter024]!", 
      "cfi": "/6/60[chapter024]!/4/18", 
      "highlight": "\u4e00\u5ea6\u8f83\u4e3a\u901a\u884c\u7684\u72af\u7f6a\u5316\u7684\u6807\u51c6\u6709\u6cd5\u76ca\u4fdd\u62a4\u539f\u5219\uff08\u968f\u7740\u7406\u8bba\u53d1\u5c55\uff0c\u9010\u6e10\u4e0e\u4f24\u5bb3\u539f\u5219\u76f8\u878d\u5408\uff09\u3001\u5192\u72af\u539f\u5219\u3001<b class='match'>\u6cd5\u5f8b</b>\u5bb6\u957f\u6ce8\u610f\u539f\u5219\u548c\u6cd5\u5f8b\u9053\u5fb7\u4e3b\u4e49\u539f\u5219 ...", 
      "href": "chapter024.html", 
      "path": "/Users/georgezou/Documents/WORK/DEMO/gz-epub/test/books/20170116/048b05f1//OPS/chapter024.html", 
      "title": ""
	 * 
	 */
	
	private String baseCfi;
	private String cfi;
	private String highlight;
	private String href;
	private String path;
	private String title;
	
	public String getBaseCfi() {
		return baseCfi;
	}
	public void setBaseCfi(String baseCfi) {
		this.baseCfi = baseCfi;
	}
	public String getCfi() {
		return cfi;
	}
	public void setCfi(String cfi) {
		this.cfi = cfi;
	}
	
	public String getHighlight() {
		return highlight;
	}
	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
