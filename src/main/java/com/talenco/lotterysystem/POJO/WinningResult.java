package com.talenco.lotterysystem.POJO;

import java.util.Date;

public class WinningResult {
    private Integer empno;

    private Date wintime;

    private String ename;

    private Integer gid;

    private String gname;

    private String greword;

    public WinningResult(Integer empno, Date wintime, String ename, Integer gid, String gname, String greword) {
        this.empno = empno;
        this.wintime = wintime;
        this.ename = ename;
        this.gid = gid;
        this.gname = gname;
        this.greword = greword;
    }

    public WinningResult() {
        super();
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public Date getWintime() {
        return wintime;
    }

    public void setWintime(Date wintime) {
        this.wintime = wintime;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public String getGreword() {
        return greword;
    }

    public void setGreword(String greword) {
        this.greword = greword == null ? null : greword.trim();
    }
}