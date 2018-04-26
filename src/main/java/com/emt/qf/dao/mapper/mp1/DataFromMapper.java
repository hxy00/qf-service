package com.emt.qf.dao.mapper.mp1;

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
public interface DataFromMapper {

    /**
     * 获取支付源数据
     * @param beginDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> getZFOrgData(@Param("beginDate") String beginDate, @Param("endDate")String endDate);

    /**
     * 获取退款源数据
     * @param beginDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> getTKOrgData(@Param("beginDate") String beginDate, @Param("endDate")String endDate);
}
