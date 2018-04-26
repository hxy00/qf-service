package com.emt.qf.task;

import com.emt.qf.mthread.TKRunnable;
import com.emt.qf.mthread.ZFRunnable;
import com.emt.qf.sv.inter.IDataFromSv;
import com.emt.qf.sv.inter.IDataToSv;
import com.emt.qf.util.ToolsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 数据同步定时任务
 *
 * @Author: Mr.Huang
 * @Date: 2018-04-10
 * @Description:
 */

@Component
@EnableScheduling
public class QfDataSyncTask {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDataFromSv iDataFromSv;

    @Autowired
    private IDataToSv iDataToSv;

    @Scheduled(cron = "0 0 1 * * ?") //每天凌晨1点执行一次
    public void statusCheck() {
        logger.info("[QfDataSyncTask]定时任务开始执行......");

        //获取查询规则日期数据
        String[] dateStr = ToolsUtil.getDates();

        if (null == dateStr || dateStr.length == 0)
            return;

        logger.info("[QfDataSyncTask]当前查询日期段：【{}/{}】", dateStr[0], dateStr[1]);

        //数据同步
        syncData();
    }

    /**
     * 数据同步
     */
    private void syncData() {
        try {
            //处理支付数据线程
            new Thread(new ZFRunnable(iDataFromSv, iDataToSv)).start();
            //处理退款数据线程
            new Thread(new TKRunnable(iDataFromSv, iDataToSv)).start();
        } catch (Exception e){
            logger.error(e.getMessage());
//            e.printStackTrace();
        }
    }

}
