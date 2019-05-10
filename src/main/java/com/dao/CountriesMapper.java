package com.dao;

import com.dto.Countries;
import com.dto.CountriesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CountriesMapper {
    int countByExample(CountriesExample example);

    int deleteByExample(CountriesExample example);

    int deleteByPrimaryKey(String countryId);

    int insert(Countries record);

    int insertSelective(Countries record);

    List<Countries> selectByExample(CountriesExample example);

    Countries selectByPrimaryKey(String countryId);

    int updateByExampleSelective(@Param("record") Countries record, @Param("example") CountriesExample example);

    int updateByExample(@Param("record") Countries record, @Param("example") CountriesExample example);

    int updateByPrimaryKeySelective(Countries record);

    int updateByPrimaryKey(Countries record);
}