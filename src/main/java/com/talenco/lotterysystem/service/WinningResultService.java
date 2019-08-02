package com.talenco.lotterysystem.service;


import com.talenco.lotterysystem.POJO.WinningResult;

import java.util.List;

public interface WinningResultService {

    List<WinningResult> getAll();

    List<WinningResult> getOne(int gid);

    void delete(int[] ids);

    void deleteAll();
}
