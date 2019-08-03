package com.talenco.lotterysystem.service;


import com.talenco.lotterysystem.POJO.WinningResult;
import com.talenco.lotterysystem.entity.WinningResultSetting;

import java.util.List;

public interface WinningResultService {

    List<WinningResult> getAll();

    List<WinningResultSetting> getAllByGid();

    List<WinningResult> getOne(int gid);

    void delete(int[] ids);

    void deleteAll();
}
