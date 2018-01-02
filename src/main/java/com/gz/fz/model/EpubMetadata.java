package com.gz.fz.model;

public class EpubMetadata extends BaseEntity {

	public EpubMetadata () {}
	
	public EpubMetadata (Integer book_id) {
		this.setBook_id(book_id);
	}
	
	private Integer book_id;
	
	private String book_title;
	private String creator;
	private String description;
	private String direction;
	private String identifier;
	private String language;
	private String layout;
	private String modified_data;
	private String orientation;
	private String pubdata;
	private String publisher;
	private String rights;
	private String spread;
	
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public String getModified_data() {
		return modified_data;
	}
	public void setModified_data(String modified_data) {
		this.modified_data = modified_data;
	}
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	public String getPubdata() {
		return pubdata;
	}
	public void setPubdata(String pubdata) {
		this.pubdata = pubdata;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	public String getSpread() {
		return spread;
	}
	public void setSpread(String spread) {
		this.spread = spread;
	}
	
}
