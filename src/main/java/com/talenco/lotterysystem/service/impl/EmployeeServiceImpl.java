package com.talenco.lotterysystem.service.impl;

import com.talenco.lotterysystem.POJO.Employee;
import com.talenco.lotterysystem.POJO.EmployeeExample;
import com.talenco.lotterysystem.dao.EmployeeMapper;
import com.talenco.lotterysystem.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAll() {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.setOrderByClause("empno desc");
        return employeeMapper.selectByExample(employeeExample);
    }

    @Override
    public Employee getOne(Long id) {
        return employeeMapper.selectByPrimaryKey(id.intValue());
    }

    @Override
    public void insert(Employee employee) throws Exception {
        employeeMapper.insert(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public void delete(Long[] ids) {

        for (Long id : ids) {
            employeeMapper.deleteByPrimaryKey(id.intValue());
        }
    }
}
