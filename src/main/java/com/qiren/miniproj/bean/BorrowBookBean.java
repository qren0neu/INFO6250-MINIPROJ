package com.qiren.miniproj.bean;

public class BorrowBookBean {

	private String pkBorrowBook;
	private String fromDate;
	private String toDate;
	private String fkUser;
	private String fkBook;

	public String getPkBorrowBook() {
		return pkBorrowBook;
	}

	public void setPkBorrowBook(String pkBorrowBook) {
		this.pkBorrowBook = pkBorrowBook;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getFkUser() {
		return fkUser;
	}

	public void setFkUser(String fkUser) {
		this.fkUser = fkUser;
	}

	public String getFkBook() {
		return fkBook;
	}

	public void setFkBook(String fkBook) {
		this.fkBook = fkBook;
	}

}
