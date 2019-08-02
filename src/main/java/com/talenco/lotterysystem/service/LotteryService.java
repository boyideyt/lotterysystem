package com.talenco.lotterysystem.service;

import com.talenco.lotterysystem.POJO.Employee;
import com.talenco.lotterysystem.POJO.WinningResult;
import com.talenco.lotterysystem.POJO.WinningSetting;

import java.util.List;

public interface LotteryService {


    List<WinningResult> random(Integer gradeID, List<Employee> employeeList);

    void saveWinner(List<WinningResult> winningResultList);

    void cancel(WinningResult winningResult);

    WinningSetting getWinningSetting();
}
