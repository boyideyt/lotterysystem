package com.talenco.lotterysystem.controller;


import com.alibaba.fastjson.JSONObject;
import com.talenco.lotterysystem.POJO.Employee;
import com.talenco.lotterysystem.POJO.Good;
import com.talenco.lotterysystem.entity.Result;
import com.talenco.lotterysystem.service.EmployeeService;
import com.talenco.lotterysystem.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/GoodController")
public class GoodController {


    @Autowired
    private GoodService goodService;


    @RequestMapping("/getAll")
    @ResponseBody
    public List<Good> getAll() {
        return (List<Good>) JSONObject.toJSON(this.goodService.getAll());
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public String getOne(Long gid) {
        Good good = goodService.getOne(gid);
        return JSONObject.toJSONString(good);
    }

    @RequestMapping("/insert")
    public Result insert(@RequestBody Good good) {
        try {
            goodService.insert(good);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            return new Result(false, "添加失败,ID可能重复了");
        }
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Good good) {
        try {
            goodService.update(good);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Long[] ids) {
        try {
            goodService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
