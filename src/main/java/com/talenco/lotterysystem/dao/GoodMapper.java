package com.talenco.lotterysystem.dao;


import com.talenco.lotterysystem.POJO.Good;
import com.talenco.lotterysystem.POJO.GoodExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodMapper {
    long countByExample(GoodExample example);

    int deleteByExample(GoodExample example);

    int deleteByPrimaryKey(Integer gid);

    int insert(Good record) throws Exception;

    int insertSelective(Good record);

    List<Good> selectByExample(GoodExample example);

    Good selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(@Param("record") Good record, @Param("example") GoodExample example);

    int updateByExample(@Param("record") Good record, @Param("example") GoodExample example);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);

}