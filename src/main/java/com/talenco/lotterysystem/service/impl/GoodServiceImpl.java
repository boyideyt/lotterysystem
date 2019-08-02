package com.talenco.lotterysystem.service.impl;

import com.talenco.lotterysystem.POJO.Good;
import com.talenco.lotterysystem.POJO.GoodExample;
import com.talenco.lotterysystem.dao.GoodMapper;
import com.talenco.lotterysystem.service.GoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Resource
    private GoodMapper goodMapper;

    @Override
    public List<Good> getAll() {
        return goodMapper.selectByExample(new GoodExample());
    }

    @Override
    public Good getOne(Long id) {
        return goodMapper.selectByPrimaryKey(id.intValue());
    }

    @Override
    public void insert(Good good) throws Exception{
        goodMapper.insert(good);
    }

    @Override
    public void update(Good good) {
        goodMapper.updateByPrimaryKey(good);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            goodMapper.deleteByPrimaryKey(id.intValue());
        }
    }
}
