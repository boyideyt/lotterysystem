package com.talenco.lotterysystem.service.impl;

import com.talenco.lotterysystem.POJO.WinningResult;
import com.talenco.lotterysystem.POJO.WinningResultExample;
import com.talenco.lotterysystem.dao.WinningResultMapper;
import com.talenco.lotterysystem.service.WinningResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WinningResultImpl implements WinningResultService {

    @Resource
    WinningResultMapper winningResultMapper;

    @Override
    public List<WinningResult> getAll() {
        return winningResultMapper.selectByExample(new WinningResultExample());
    }

    @Override
    public List<WinningResult> getOne(int gid) {
        WinningResultExample winningResultExample = new WinningResultExample();
        WinningResultExample.Criteria criteria = winningResultExample.createCriteria();
        criteria.andGidEqualTo(gid);
        return winningResultMapper.selectByExample(winningResultExample);
    }

    @Override
    public void delete(int[] ids) {
        WinningResultExample winningResultExample = new WinningResultExample();
        WinningResultExample.Criteria criteria = winningResultExample.createCriteria();
        for (int gid : ids) {
            criteria.andGidEqualTo(gid);
        }
        winningResultMapper.deleteByExample(winningResultExample);
    }

    @Override
    public void deleteAll() {
        winningResultMapper.truncateTable();
    }
}
