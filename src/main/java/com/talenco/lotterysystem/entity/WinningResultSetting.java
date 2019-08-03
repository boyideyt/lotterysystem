package com.talenco.lotterysystem.entity;

import com.talenco.lotterysystem.POJO.WinningResult;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Setter
@Getter
public class WinningResultSetting {
    private String name;
    private List<WinningResult> winningResultList;

    public WinningResultSetting() {
    }

    public WinningResultSetting(String name, List<WinningResult> winningResultList) {
        this.name = name;
        this.winningResultList = winningResultList;
    }
}
