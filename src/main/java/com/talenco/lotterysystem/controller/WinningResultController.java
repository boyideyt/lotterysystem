package com.talenco.lotterysystem.controller;


import com.alibaba.fastjson.JSONObject;
import com.talenco.lotterysystem.POJO.Good;
import com.talenco.lotterysystem.POJO.WinningResult;
import com.talenco.lotterysystem.entity.Result;
import com.talenco.lotterysystem.entity.WinningResultSetting;
import com.talenco.lotterysystem.service.GoodService;
import com.talenco.lotterysystem.service.WinningResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/WinningResultController")
public class WinningResultController {


    @Autowired
    private WinningResultService winningResultService;


    @RequestMapping("/getAll")
    @ResponseBody
    public List<WinningResultSetting> getAll() {
        return winningResultService.getAllByGid();
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public String getOne(int gid) {
        List<WinningResult> winningResultList = winningResultService.getOne(gid);
        return JSONObject.toJSONString(winningResultList);
    }



    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(int[] ids) {
        try {
            winningResultService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public Result deleteAll() {
        try {
            winningResultService.deleteAll();
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
