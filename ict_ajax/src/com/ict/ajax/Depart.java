package com.ict.ajax;

public class Depart {

	private String dinum;
	private String diname;
	private String ditype;

	
	
	public String getDinum() {
		return dinum;
	}



	public void setDinum(String dinum) {
		this.dinum = dinum;
	}



	public String getDiname() {
		return diname;
	}



	public void setDiname(String diname) {
		this.diname = diname;
	}



	public String getDitype() {
		return ditype;
	}



	public void setDitype(String ditype) {
		this.ditype = ditype;
	}



	@Override
	public String toString() {
		return "Depart [dinum=" + dinum + ", diname=" + diname + ", ditype=" + ditype + "]";
	}

}
