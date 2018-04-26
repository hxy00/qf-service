package com.emt.qf.dao.mapper.mp2;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.Huang
 * @Date: 2018-04-10
 * @Description:
 */
@Mapper
public interface DataToMapper {

     /**
      * 删除支付数据
      * @param beginDate
      * @param endDate
      * @return
      */
     int delZFData(@Param("beginDate") String beginDate, @Param("endDate")String endDate);

     /**
      * 删除退款数据
      * @param beginDate
      * @param endDate
      * @return
      */
     int delTKData(@Param("beginDate") String beginDate, @Param("endDate")String endDate);

     /**
      * 保存支付数据
      * @param lst
      * @return
      */
     int insertZFData(@Param("lst") List<Map<String, Object>> lst);

     /**
      * 保存退款数据
      * @param lst
      * @return
      */
     int insertTKData(@Param("lst") List<Map<String, Object>> lst);

     /**
      * 获取数据
      * @param beginDate
      * @param endDate
      * @return
      */
     List<Map<String, Object>> getData(@Param("beginDate") String beginDate, @Param("endDate")String endDate);
}
