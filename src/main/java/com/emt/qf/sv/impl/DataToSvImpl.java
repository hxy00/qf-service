package com.emt.qf.sv.impl;

import com.emt.qf.dao.mapper.mp2.DataToMapper;
import com.emt.qf.sv.inter.IDataToSv;
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
public class DataToSvImpl implements IDataToSv {

    @Autowired
    private DataToMapper dataToMapper;

    /**
     * 删除支付数据
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public int delZFData(String beginDate, String endDate) {
        return dataToMapper.delZFData(beginDate, endDate);
    }

    /**
     * 删除退款数据
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public int delTKData(String beginDate, String endDate) {
        return dataToMapper.delTKData(beginDate, endDate);
    }

    /**
     * 保存支付数据
     *
     * @param lst
     * @return
     */
    @Override
    public int insertZFData(List<Map<String, Object>> lst) {
        return dataToMapper.insertZFData(lst);
    }

    /**
     * 保存退款数据
     *
     * @param lst
     * @return
     */
    @Override
    public int insertTKData(List<Map<String, Object>> lst) {
        return dataToMapper.insertTKData(lst);
    }

    /**
     * 获取数据
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public List<Map<String, Object>> getData(String beginDate, String endDate) {
        return dataToMapper.getData(beginDate, endDate);
    }
}
