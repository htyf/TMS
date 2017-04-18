package com.tms.model;

public class Menu {
	private Integer hid;
	private String hname;
	private Integer tid;
	private String tname;
	private String address;
	private String tnameEng;

	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public String getTnameEng() {
		return tnameEng;
	}

	public void setTnameEng(String tnameEng) {
		this.tnameEng = tnameEng;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
