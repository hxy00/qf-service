package com.emt.qf.sv.inter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.Huang
 * @Date: 2018-04-10
 * @Description:
 */
public interface IDataFromSv {
    /**
     * 获取支付源数据
     * @param beginDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> getZFOrgData(String beginDate, String endDate);

    /**
     * 获取退款源数据
     * @param beginDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> getTKOrgData(String beginDate, String endDate);
}
