package com.talenco.lotterysystem.POJO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class RandomEntity {
    private int gid;
    List<Employee> employeeList;

    public RandomEntity() {
    }

    public RandomEntity(int gid, List<Employee> employeeList) {
        this.gid = gid;
        this.employeeList = employeeList;
    }
}
