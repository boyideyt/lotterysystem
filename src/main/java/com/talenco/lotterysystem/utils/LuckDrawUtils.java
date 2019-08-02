package com.talenco.lotterysystem.utils;

import com.talenco.lotterysystem.POJO.Employee;
import com.talenco.lotterysystem.POJO.Good;
import com.talenco.lotterysystem.POJO.WinningResult;
import com.talenco.lotterysystem.POJO.WinningSetting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

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


    public static WinningResult start(ArrayList<Employee> employees, WinningSetting winningSetting) {

        ArrayList<Good> gset = winningSetting.getGset();
        // 有多少个奖项抽多少次
        for (Good good : gset) {
            //  有多少个名额抽多少次
            for (int i = 0; i < good.getGnum(); i++) {
                int size = employees.size();
                int random = (int) (Math.random() * size);
                System.out.println(good.getGname() + good.getGreward() + employees.get(random));
                employees.remove(random);
            }
        }


        WinningResult winningResult = new WinningResult();
        return winningResult;
    }

    public static void main(String[] args) throws ParseException {
//        ArrayList<Good> goods = new ArrayList<>();
//        goods.add(new Good(1, 1, "特等奖", "手机"));
//        goods.add(new Good(2, 2, "一等奖", "耳机"));
//        goods.add(new Good(3, 3, "二等奖", "大购物卡"));
//        goods.add(new Good(4, 5, "三等奖", "小购物卡"));
//        // 获取名单
//        ArrayList<Employee> employees = GenerateLists();
//        // 获取奖项设置
//        WinningSetting winningSetting = new WinningSetting(goods.size(), goods);
//        //开始抽奖
//        start(employees, winningSetting);

        Date date = new Date();
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df2.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = df2.format(date);
        Date date2 = df2.parse(format);
        System.out.println(date2);
    }
}
