package com.talenco.lotterysystem.controller;


import com.alibaba.fastjson.JSONObject;
import com.talenco.lotterysystem.POJO.Employee;
import com.talenco.lotterysystem.entity.Result;
import com.talenco.lotterysystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/EmployeeController")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("/getAll")
    @ResponseBody
    public List<Employee> getAll() {
        return (List<Employee>) JSONObject.toJSON(this.employeeService.getAll());
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public String getOne(Long empno) {
        Employee employee = employeeService.getOne(empno);
        return JSONObject.toJSONString(employee);
    }

    @RequestMapping("/insert")
    public Result insert(@RequestBody Employee employee) {
        try {
            employeeService.insert(employee);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败");
        }
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Employee employee) {
        try {
            employeeService.update(employee);
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
            employeeService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
