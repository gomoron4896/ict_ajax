package com.ict.ajax;

public class Emp {

	private Integer empno;
	private String empname;
	private String empjob;
	private Integer empmgr;
	private String hiredate;
	private Integer sal;
	private Integer comm;
	private Integer deptno;

	public Emp() {}
	
	public Emp(Integer empno, String empname, String empjob, Integer empmgr, String hiredate, Integer sal, Integer comm,
			Integer deptno) {
		super();
		this.empno = empno;
		this.empname = empname;
		this.empjob = empjob;
		this.empmgr = empmgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpjob() {
		return empjob;
	}

	public void setEmpjob(String empjob) {
		this.empjob = empjob;
	}

	public Integer getEmpmgr() {
		return empmgr;
	}

	public void setEmpmgr(Integer empmgr) {
		this.empmgr = empmgr;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public Integer getSal() {
		return sal;
	}

	public void setSal(Integer sal) {
		this.sal = sal;
	}

	public Integer getComm() {
		return comm;
	}

	public void setComm(Integer comm) {
		this.comm = comm;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", empname=" + empname + ", empjob=" + empjob + ", empmgr=" + empmgr
				+ ", hiredate=" + hiredate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}

}
