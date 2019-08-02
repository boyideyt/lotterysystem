package com.talenco.lotterysystem.service;

import com.talenco.lotterysystem.POJO.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getOne(Long id);

    void insert(Employee employee) throws Exception;

    void update(Employee employee);

    void delete(Long[] ids);
}
