package com.talenco.lotterysystem.POJO;

import lombok.ToString;

@ToString
public class Employee {
    private Integer empno;

    private String ename;

    public Employee(Integer empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }

    public Employee() {
        super();
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }
}