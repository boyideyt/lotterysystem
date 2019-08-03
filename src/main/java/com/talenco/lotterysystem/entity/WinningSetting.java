package com.talenco.lotterysystem.entity;

import com.talenco.lotterysystem.POJO.Good;
import lombok.*;

import java.util.ArrayList;

/**
 * 奖项设置,每个奖项有多少个名额
 */
@ToString
@Setter
@Getter
@Generated
@Value
public class WinningSetting {

    // 奖项数
    private int gnum;

    // 奖项配置
    private ArrayList<Good> gset;

}
