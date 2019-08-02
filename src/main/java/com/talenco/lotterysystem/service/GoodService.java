package com.talenco.lotterysystem.service;

import com.talenco.lotterysystem.POJO.Employee;
import com.talenco.lotterysystem.POJO.Good;

import java.util.List;

public interface GoodService {

    List<Good> getAll();

    Good getOne(Long id);

    void insert(Good good) throws Exception;

    void update(Good good);

    void delete(Long[] ids);
}
