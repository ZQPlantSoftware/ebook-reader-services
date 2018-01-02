package com.gz.fz.model;

public class EpubPage extends BaseEntity {

	public EpubPage () {}
	
	public EpubPage (Integer book_id) {
		this.setBook_id(book_id);
	}
	
	private Integer book_id;
	private String cfi;
	private Integer page;
	private double height;
	
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public String getCfi() {
		return cfi;
	}
	public void setCfi(String cfi) {
		this.cfi = cfi;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
}
