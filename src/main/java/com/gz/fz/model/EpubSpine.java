package com.gz.fz.model;

public class EpubSpine extends BaseEntity {

	public EpubSpine () {}
	
	public EpubSpine (Integer book_id) {
		this.setBook_id(book_id);
	}
	
	private String cfi;
	private String cfi_base;
	private String href;
	private Integer s_index;
	private String s_linear;
	private String url;
	private Integer book_id;

	public String getCfi() {
		return cfi;
	}
	public void setCfi(String cfi) {
		this.cfi = cfi;
	}
	
	public String getCfi_base() {
		return cfi_base;
	}

	public void setCfi_base(String cfi_base) {
		this.cfi_base = cfi_base;
	}

	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Integer getS_index() {
		return s_index;
	}

	public void setS_index(Integer s_index) {
		this.s_index = s_index;
	}

	public String getS_linear() {
		return s_linear;
	}

	public void setS_linear(String s_linear) {
		this.s_linear = s_linear;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
}
