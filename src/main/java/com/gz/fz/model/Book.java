package com.gz.fz.model;

/**
 *
 * @author georgezou
 *
 */
public class Book extends BaseEntity{

	public Book() { }

	public Book(String url) {
		this.setUrl(url);
	}

	public Book(String url, String bid) {
		this.setUrl(url);
		this.setBid(bid);
	}

	public Book(String url, String bid, String source) {
		this.setUrl(url);
		this.setBid(bid);
		this.setSource(source);
	}

	public Book(Integer id, String url) {
		this.setUrl(url);
		this.setId(id);
	}

	private String bid;
	private String title;
	private String book_code;
	private String url;
	private Integer total_page_num;
	private String cfis;
	private String description;
	private double price;
	private Integer probation;
	private String source;
	private Integer is_init = 0;				// 0为未初始化 1为初始化了
	private Integer is_index = 0;			// 0为导入到搜索系统了 1为未导入


	public Integer getIs_init() {
		return is_init;
	}

	public void setIs_init(Integer is_init) {
		this.is_init = is_init;
	}

	public Integer getIs_index() {
		return is_index;
	}

	public void setIs_index(Integer is_index) {
		this.is_index = is_index;
	}

	public String getSource() {
		return this.source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBook_code() {
		return book_code;
	}
	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getTotal_page_num() {
		return total_page_num;
	}
	public void setTotal_page_num(Integer total_page_num) {
		this.total_page_num = total_page_num;
	}
	public String getCfis() {
		return cfis;
	}
	public void setCfis(String cfis) {
		this.cfis = cfis;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getProbation() {
		return probation;
	}

	public void setProbation(Integer probation) {
		this.probation = probation;
	}

}
