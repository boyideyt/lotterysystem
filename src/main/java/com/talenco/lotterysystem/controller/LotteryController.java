package com.talenco.lotterysystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.talenco.lotterysystem.POJO.*;
import com.talenco.lotterysystem.entity.Result;
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
        return (List<WinningResult>) JSONObject.toJSON(this.lotteryService.random(randomEntity.getGid(), randomEntity.getEmployeeList()));
    }


    /**
     * @param winningResult
     * @return
     */
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

    /**
     * @param
     * @return WinningSetting
     */
    @RequestMapping("/getWinningSetting")
    @ResponseBody
    public WinningSetting getWinningSetting() {

        WinningSetting winningSetting = lotteryService.getWinningSetting();
        return winningSetting;
    }


    /*
     *
     */
    @RequestMapping("/cancel")
    @ResponseBody
    public Result cancel(WinningResult winningResult) {
        try {
            lotteryService.cancel(winningResult);
            return new Result(true, "取消成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "取消失败");
        }
    }

}
