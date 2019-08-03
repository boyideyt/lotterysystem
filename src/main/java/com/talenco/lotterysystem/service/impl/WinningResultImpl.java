package com.talenco.lotterysystem.service.impl;

import com.talenco.lotterysystem.POJO.Good;
import com.talenco.lotterysystem.POJO.GoodExample;
import com.talenco.lotterysystem.POJO.WinningResult;
import com.talenco.lotterysystem.POJO.WinningResultExample;
import com.talenco.lotterysystem.dao.GoodMapper;
import com.talenco.lotterysystem.dao.WinningResultMapper;
import com.talenco.lotterysystem.entity.WinningResultSetting;
import com.talenco.lotterysystem.service.WinningResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class WinningResultImpl implements WinningResultService {

    @Resource
    WinningResultMapper winningResultMapper;
    @Resource
    GoodMapper goodMapper;

    @Override
    public List<WinningResult> getAll() {
        WinningResultExample winningResultExample = new WinningResultExample();
        return winningResultMapper.selectByExample(winningResultExample);
    }

    @Override
    public List<WinningResultSetting> getAllByGid() {
        ArrayList<WinningResultSetting> list = new ArrayList<>();
        GoodExample goodExample = new GoodExample();
        ArrayList<Good> goods = (ArrayList<Good>) goodMapper.selectByExample(goodExample);
        for (Good good : goods) {
            WinningResultExample winningResultExample = new WinningResultExample();
            WinningResultSetting winningResultSetting = new WinningResultSetting();
            WinningResultExample.Criteria criteria = winningResultExample.createCriteria();
            criteria.andGidEqualTo(good.getGid());
            List<WinningResult> winningResults = winningResultMapper.selectByExample(winningResultExample);
            winningResultSetting.setName(good.getGname());
            winningResultSetting.setWinningResultList(winningResults);
            list.add(winningResultSetting);
        }
        return list;
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
