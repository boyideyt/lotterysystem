package com.talenco.lotterysystem.dao;

import com.talenco.lotterysystem.POJO.Employee;
import com.talenco.lotterysystem.POJO.WinningResult;

import java.util.List;

public interface LotteryDao {

    // 获取候选名单
    List<Employee> getAll();

    // 在获奖名单存储
    void saveWinner(WinningResult winningResult);

    // 在候选名单删除
    void deleWinner(WinningResult winningResult);

}
