package com.emt.qf.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: Mr.Huang
 * @Date: 2018-04-11
 * @Description:
 */
public class ToolsUtil {
    private static Logger logger = LoggerFactory.getLogger(ToolsUtil.class);

    //定义每批次插入条数
    public static final int BATCH_INSERT_COUNTS = 200;

    //减去天数
    public static final int MINUS_DAYS = 7;

    /**
     * 将list按blockSize大小等分，最后多余的单独一份
     * @param list
     * @param blockSize
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> subList(List<T> list, int blockSize) {
        logger.info("[ToolsUtil]list开始分割");
        List<List<T>> lists = new ArrayList<List<T>>();
        if (list != null && blockSize > 0) {
            int listSize = list.size();
            if (listSize <= blockSize) {
                lists.add(list);
                return lists;
            }
            int batchSize = listSize / blockSize;
            int remain = listSize % blockSize;
            for (int i = 0; i < batchSize; i++) {
                int fromIndex = i * blockSize;
                int toIndex = fromIndex + blockSize;
//                logger.info("[ToolsUtil]fromIndex=" + fromIndex + ", toIndex=" + toIndex);
                lists.add(list.subList(fromIndex, toIndex));
            }
            if (remain > 0) {
//                logger.info("[ToolsUtil]fromIndex=" + (listSize - remain) + ", toIndex=" + (listSize));
                lists.add(list.subList(listSize - remain, listSize));
            }
        }
        return lists;
    }

    /**
     * 获取查询的有效日期
     *
     * @return
     */
    public static String[] getDates() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        Date date1 = calendar.getTime();
        String endDate = format.format(date1);

        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - MINUS_DAYS);
        Date date2 = calendar.getTime();
        String beginDate = format.format(date2);

        return new String[]{beginDate, endDate};
    }
}
