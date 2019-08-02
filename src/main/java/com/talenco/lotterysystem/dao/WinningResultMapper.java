package com.talenco.lotterysystem.dao;


import com.talenco.lotterysystem.POJO.WinningResult;
import com.talenco.lotterysystem.POJO.WinningResultExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WinningResultMapper {
    long countByExample(WinningResultExample example);

    int deleteByExample(WinningResultExample example);

    int deleteByPrimaryKey(Integer empno);

    int insert(WinningResult record);

    int insertSelective(WinningResult record);

    List<WinningResult> selectByExample(WinningResultExample example);

    WinningResult selectByPrimaryKey(Integer empno);

    int updateByExampleSelective(@Param("record") WinningResult record, @Param("example") WinningResultExample example);

    int updateByExample(@Param("record") WinningResult record, @Param("example") WinningResultExample example);

    int updateByPrimaryKeySelective(WinningResult record);

    int updateByPrimaryKey(WinningResult record);

    int truncateTable();
}