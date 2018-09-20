package com.ict.ajax.vo;

public class Ticket {

	private Integer tmnum = 0;
	private String tmname = "";
	private Integer tmprice = 0;
	private String tmstartdat = "";
	private String tmenddat = "";
	private String tmdesc = "";
	private Integer tmcnt = 0;
	private String tmimg = "";
	
	public Ticket() {}

	public Ticket(Integer tmnum, String tmname, Integer tmprice, String tmstartdat, String tmenddat, String tmdesc,
			Integer tmcnt, String tmimg) {
		super();
		this.tmnum = tmnum;
		this.tmname = tmname;
		this.tmprice = tmprice;
		this.tmstartdat = tmstartdat;
		this.tmenddat = tmenddat;
		this.tmdesc = tmdesc;
		this.tmcnt = tmcnt;
		this.tmimg = tmimg;
	}

	public Integer getTmnum() {
		return tmnum;
	}

	public void setTmnum(Integer tmnum) {
		this.tmnum = tmnum;
	}

	public String getTmname() {
		return tmname;
	}

	public void setTmname(String tmname) {
		this.tmname = tmname;
	}

	public Integer getTmprice() {
		return tmprice;
	}

	public void setTmprice(Integer tmprice) {
		this.tmprice = tmprice;
	}

	public String getTmstartdat() {
		return tmstartdat;
	}

	public void setTmstartdat(String tmstartdat) {
		this.tmstartdat = tmstartdat;
	}

	public String getTmenddat() {
		return tmenddat;
	}

	public void setTmenddat(String tmenddat) {
		this.tmenddat = tmenddat;
	}

	public String getTmdesc() {
		return tmdesc;
	}

	public void setTmdesc(String tmdesc) {
		this.tmdesc = tmdesc;
	}

	public Integer getTmcnt() {
		return tmcnt;
	}

	public void setTmcnt(Integer tmcnt) {
		this.tmcnt = tmcnt;
	}

	public String getTmimg() {
		return tmimg;
	}

	public void setTmimg(String tmimg) {
		this.tmimg = tmimg;
	}

	@Override
	public String toString() {
		return "Ticket [tmnum=" + tmnum + ", tmname=" + tmname + ", tmprice=" + tmprice + ", tmstartdat=" + tmstartdat
				+ ", tmenddat=" + tmenddat + ", tmdesc=" + tmdesc + ", tmcnt=" + tmcnt + ", tmimg=" + tmimg + "]";
	}

}
