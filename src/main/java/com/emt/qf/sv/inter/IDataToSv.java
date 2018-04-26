package com.emt.qf.sv.inter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.Huang
 * @Date: 2018-04-10
 * @Description:
 */
public interface IDataToSv {
    /**
     * 删除支付数据
     * @param beginDate
     * @param endDate
     * @return
     */
    int delZFData(String beginDate, String endDate);

    /**
     * 删除退款数据
     * @param beginDate
     * @param endDate
     * @return
     */
    int delTKData(String beginDate, String endDate);

    /**
     * 保存支付数据
     * @param lst
     * @return
     */
    int insertZFData(List<Map<String, Object>> lst);

    /**
     * 保存退款数据
     * @param lst
     * @return
     */
    int insertTKData(List<Map<String, Object>> lst);

    /**
     * 获取数据
     * @param beginDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> getData(String beginDate, String endDate);
}
