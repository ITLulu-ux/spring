package com.myapp.traffic.mapper;

import com.myapp.traffic.traffic.Traffic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TrafficMapper {
    List<Traffic> selectAll();  //Entity라는 클래스를 불러온거지, db를 불러온게 아님(db는 schema.sql)
    List<Traffic> selectById(@Param("id") Long id);
    List<Traffic> selectBysumTime(@Param("tmName") String tmName);
    List<Traffic> selectOrderByconZoneNameDesc();
    List<Traffic> selectAllOrderBy(@Param("order") String order, @Param("dir") String dir);
    List<Traffic> selecttrafficAmount( @Param("trafficAmout") int trafficAmout);
    List<Traffic> selectcarType(@Param("carType") String carType);
    Traffic findById(@Param("id") Long id);
    int selectAllCount();
    int insert (@Param("entity") Traffic traffic);
    int update (@Param("entity") Traffic traffic);
    void delete (@Param("id") Long id);
    //int deleteById (@Param("entity") Long traffic);
    int deleteAll ();
}


