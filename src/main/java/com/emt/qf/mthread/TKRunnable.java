package com.emt.qf.mthread;

import com.emt.qf.sv.inter.IDataFromSv;
import com.emt.qf.sv.inter.IDataToSv;
import com.emt.qf.util.ToolsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 处理退款数据线程
 *
 * @Author: Mr.Huang
 * @Date: 2018-04-11
 * @Description:
 */
public class TKRunnable implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private IDataFromSv iDataFromSv;
    private IDataToSv iDataToSv;

    public TKRunnable(IDataFromSv iDataFromSv, IDataToSv iDataToSv) {
        this.iDataFromSv = iDataFromSv;
        this.iDataToSv = iDataToSv;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        /**
         * 1、获取原支付数据
         * 2、获取原退款数据
         * 3、删除现有支付数据
         * 4、删除现有退款数据
         * 5、插入原支付数据到现有支付数据表
         * 6、插入原退款数据到现有退款数据表
         */

        logger.info("[TKRunnable]TKRunnable执行开始");

        String[] dateStr = ToolsUtil.getDates();
        if(null == dateStr || dateStr.length < 2)
            return;

        List<Map<String, Object>> lstTKOrg = iDataFromSv.getTKOrgData(dateStr[0], dateStr[1]);

        if (null != lstTKOrg && lstTKOrg.size() > 0) {
            //删除现有退款数据，保存原退款数据到现有表。
            int delInt = iDataToSv.delTKData(dateStr[0], dateStr[1]);
            logger.info("[TKRunnable]现有退款表，删除：{}", delInt);

            List<List<Map<String, Object>>> lstTK1 = ToolsUtil.subList(lstTKOrg, ToolsUtil.BATCH_INSERT_COUNTS);
            if (null == lstTK1 || lstTK1.size() == 0)
                return;

            logger.info("[TKRunnable]将lstZFOrg={}按照每{}条一批进行分割，分割长度={}", lstTKOrg.size(), ToolsUtil.BATCH_INSERT_COUNTS, lstTK1.size());
            int saveInt = 0;
            for (List<Map<String, Object>> lst2 : lstTK1) {
                saveInt += iDataToSv.insertTKData(lst2);
                logger.info("[TKRunnable]现有退款表，保存：{}", saveInt);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        logger.info("[TKRunnable]TKRunnable执行完毕");
    }
}
