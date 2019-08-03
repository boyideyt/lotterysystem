package com.talenco.lotterysystem.controller;

import com.talenco.lotterysystem.POJO.*;
import com.talenco.lotterysystem.entity.Result;
import com.talenco.lotterysystem.entity.WinningSetting;
import com.talenco.lotterysystem.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/LotteryController")
public class LotteryController {

    @Autowired
    private LotteryService lotteryService;


    @RequestMapping("/random")
    @ResponseBody
    public List<WinningResult> random(@RequestBody RandomEntity randomEntity) throws Exception {
        return this.lotteryService.random(randomEntity.getGid(), randomEntity.getEmployeeList());
    }


    @RequestMapping("/saveWinner")
    @ResponseBody
    public Result saveWinner(@RequestBody List<WinningResult> winningResult) {
        try {
            lotteryService.saveWinner(winningResult);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败");
        }
    }

    @RequestMapping("/getWinningSetting")
    @ResponseBody
    public WinningSetting getWinningSetting() {

        WinningSetting winningSetting = lotteryService.getWinningSetting();
        return winningSetting;
    }

}
