package com.talenco.lotterysystem.utils;

import com.talenco.lotterysystem.POJO.Employee;
import com.talenco.lotterysystem.POJO.Good;
import com.talenco.lotterysystem.POJO.WinningResult;
import com.talenco.lotterysystem.entity.WinningSetting;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LuckDrawUtils {


    public static ArrayList<Employee> GenerateLists() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "李哲"));
        employees.add(new Employee(2, "王喆"));
        employees.add(new Employee(3, "林义成"));
        employees.add(new Employee(4, "赵更"));
        employees.add(new Employee(5, "朱海尔"));
        employees.add(new Employee(6, "王豪聪"));
        employees.add(new Employee(7, "朱盈颖"));
        employees.add(new Employee(8, "郭星卉"));
        employees.add(new Employee(9, "宋智林"));
        employees.add(new Employee(10, "吴廷庭"));
        employees.add(new Employee(11, "李凤宇"));
        employees.add(new Employee(12, "舒倩"));
        employees.add(new Employee(13, "杨文斌"));
        employees.add(new Employee(14, "熊瑞婷"));
        employees.add(new Employee(15, "王佳萍"));
        employees.add(new Employee(16, "赵雅婷"));
        employees.add(new Employee(17, "余露"));
        employees.add(new Employee(18, "杨磊"));
        return employees;
    }


    public static List<WinningResult> start(ArrayList<Employee> employees, WinningSetting winningSetting) {
        ArrayList<WinningResult> winningResults = new ArrayList<>();

        ArrayList<Good> gset = winningSetting.getGset();
        // 有多少个奖项抽多少次
        for (Good good : gset) {
            //  有多少个名额抽多少次
            for (int i = 0; i < good.getGnum(); i++) {
                int size = employees.size();
                int random = (int) (Math.random() * size);
                Employee employee = employees.get(random);
                WinningResult winningResult = new WinningResult(employee.getEmpno(), new Date(), employee.getEname(), good.getGid(), good.getGname(), good.getGreward());
                winningResults.add(winningResult);
                employees.remove(random);
            }
        }
        return winningResults;
    }

    public static void main(String[] args) throws ParseException {
        ArrayList<Good> goods = new ArrayList<>();
        goods.add(new Good(1, 1, "特等奖", "手机",null));
        goods.add(new Good(2, 2, "一等奖", "耳机",null));
        goods.add(new Good(3, 3, "二等奖", "大购物卡",null));
        goods.add(new Good(4, 5, "三等奖", "小购物卡",null));
        // 获取名单
        ArrayList<Employee> employees = GenerateLists();
        // 获取奖项设置
        WinningSetting winningSetting = new WinningSetting(goods.size(), goods);
        //开始抽奖
        List<WinningResult> start = start(employees, winningSetting);
        System.out.println(start);

    }
}
