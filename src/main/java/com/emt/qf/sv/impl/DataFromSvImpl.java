package com.emt.qf.sv.impl;

import com.emt.qf.dao.mapper.mp1.DataFromMapper;
import com.emt.qf.sv.inter.IDataFromSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.Huang
 * @Date: 2018-04-10
 * @Description:
 */
@Repository
@Transactional
public class DataFromSvImpl implements IDataFromSv {

    @Autowired
    private DataFromMapper dataFromMapper;

    /**
     * 获取支付源数据
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public List<Map<String, Object>> getZFOrgData(String beginDate, String endDate) {
        return dataFromMapper.getZFOrgData(beginDate, endDate);
    }

    /**
     * 获取退款源数据
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public List<Map<String, Object>> getTKOrgData(String beginDate, String endDate) {
        return dataFromMapper.getTKOrgData(beginDate, endDate);
    }
}
