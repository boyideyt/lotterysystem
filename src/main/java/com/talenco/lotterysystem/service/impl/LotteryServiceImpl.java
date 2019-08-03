package com.talenco.lotterysystem.service.impl;

import com.talenco.lotterysystem.POJO.*;
import com.talenco.lotterysystem.dao.EmployeeMapper;
import com.talenco.lotterysystem.dao.GoodMapper;
import com.talenco.lotterysystem.dao.WinningResultMapper;
import com.talenco.lotterysystem.entity.WinningSetting;
import com.talenco.lotterysystem.service.LotteryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


@Service
public class LotteryServiceImpl implements LotteryService {

    @Resource
    private WinningResultMapper winningResultMapper;
    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private GoodMapper goodMapper;

    @Override
    public List<WinningResult> random(Integer gid,List<Employee> employeeList) {

        // 获奖结果列表
        List<WinningResult> winningResultList = new ArrayList<>();

        Good good = goodMapper.selectByPrimaryKey(gid);

        int winnerIndex;
        Employee winner;

        for (int i = 0; i < good.getGnum(); i++) {
            // 获取当前候选人员长度
            int size = employeeList.size();
            // 随机方式获取获奖者的索引
            winnerIndex = (int) (Math.random() * size);
            winner = employeeList.get(winnerIndex);
            // 剔除中奖者
            employeeList.remove(winnerIndex);
            WinningResult winningResult = new WinningResult();

            // 录入中奖者的编号，姓名，中奖结果（中奖id）
            winningResult.setWintime(new Date());
            winningResult.setEmpno(winner.getEmpno());
            winningResult.setEname(winner.getEname());
            winningResult.setGid(gid);
            winningResult.setGname(good.getGname());
            winningResult.setGreword(good.getGreward());
            // 追加到中奖列表
            winningResultList.add(winningResult);
        }

        return winningResultList;
    }

    @Override
    public void saveWinner(List<WinningResult> winningResultList) {
        // 遍历该轮的获奖者
        for (WinningResult winningResult : winningResultList) {
            //在获奖名单中存储获胜者
            winningResultMapper.insert(winningResult);
        }
    }

    @Override
    public void cancel(WinningResult winningResult) {

    }

    @Override
    public WinningSetting getWinningSetting() {
        GoodExample goodExample = new GoodExample();
        ArrayList<Good> goods = (ArrayList<Good>) goodMapper.selectByExample(goodExample);
        int count = (int) goodMapper.countByExample(goodExample);
        return new WinningSetting(count,goods);
    }
}
