package com.qiren.miniproj.bean;

public class BookBean {
	private String pkBook;
	private String ISBN;
	private String name;
	private String author;
	private String publisher;
	private String description;
	private String instock;
	private String coverimg;

	public String getPkBook() {
		return pkBook;
	}

	public void setPkBook(String pkBook) {
		this.pkBook = pkBook;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstock() {
		return instock;
	}

	public void setInstock(String instock) {
		this.instock = instock;
	}

	public String getCoverimg() {
		return coverimg;
	}

	public void setCoverimg(String coverimg) {
		this.coverimg = coverimg;
	}

}
