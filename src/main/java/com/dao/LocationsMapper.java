package com.dao;

import com.dto.Locations;
import com.dto.LocationsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LocationsMapper {
    int countByExample(LocationsExample example);

    int deleteByExample(LocationsExample example);

    int deleteByPrimaryKey(Short locationId);

    int insert(Locations record);

    int insertSelective(Locations record);

    List<Locations> selectByExample(LocationsExample example);

    Locations selectByPrimaryKey(Short locationId);

    int updateByExampleSelective(@Param("record") Locations record, @Param("example") LocationsExample example);

    int updateByExample(@Param("record") Locations record, @Param("example") LocationsExample example);

    int updateByPrimaryKeySelective(Locations record);

    int updateByPrimaryKey(Locations record);
}