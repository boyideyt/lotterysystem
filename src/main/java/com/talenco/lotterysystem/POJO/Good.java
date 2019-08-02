package com.talenco.lotterysystem.POJO;

import lombok.ToString;

@ToString
public class Good {
    private Integer gid;

    private Integer gnum;

    private String gname;

    private String greward;

    public Good(Integer gid, Integer gnum, String gname, String greward) {
        this.gid = gid;
        this.gnum = gnum;
        this.gname = gname;
        this.greward = greward;
    }

    public Good() {
        super();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getGnum() {
        return gnum;
    }

    public void setGnum(Integer gnum) {
        this.gnum = gnum;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public String getGreward() {
        return greward;
    }

    public void setGreward(String greward) {
        this.greward = greward == null ? null : greward.trim();
    }
}