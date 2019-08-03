package com.talenco.lotterysystem.POJO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Good {
    private Integer gid;

    private Integer gnum;

    private String gname;

    private String greward;

    private String gpicture;

    public Good() {
    }

    public Good(Integer gid, Integer gnum, String gname, String greward, String gpicture) {
        this.gid = gid;
        this.gnum = gnum;
        this.gname = gname;
        this.greward = greward;
        this.gpicture = gpicture;
    }
}