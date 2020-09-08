/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: JdkTest.java
 * Author:   yichao
 * Date:    16/9/28 下午9:47
 * Description:
 */

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * JdkTest
 *
 * @author yichao
 * @date 16/9/28
 */
public class JdkTest {

    public static void main(String[] args) {
        String a = "65210,65210,355119,355119,673429,673429,738883,738883,820698,820698,824067,824067,982496,982496,1029088,1029088,1094515,1094515,1102445,1102445,1250705,1250705,1267748,1267748,1342141,1342141,1487434,1487434,1501573,1501573,1683988,1683988,1704188,1704188,1744678,1744678,1749851,1749851,1754190,1754190,1780678,1780678,1793052,1793052,1794027,1794027,1807263,1807263,1809688,1809688,1855300,1855300,1970658,1970658,2058161,2058161";
        System.out.println(Sets.newHashSet(a.split(",")));
//        test5();
//        test4();
//        test1();
//        test2();
    }

    public static void test5() {
        List<String> jsonList = FileUtil.readLines("/Users/aguda/Desktop/有问题task0130", "utf-8");
        FileUtil.writeString("", "/Users/aguda/Desktop/tasksql0130", "utf-8");
        for (String json : jsonList) {
            JSONArray jsonArray = JSONArray.parseArray(json);
            int size = jsonArray.size();
            for (int i=0;i<size;i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                Long billingMainBizId = jsonObject.getLong("billingMainBizId");
                Long billingBizId = jsonObject.getLong("billingBizId");
                Long startTime = jsonObject.getLong("startTime");
                Date startTimeDate = new Date(startTime);
                String startTimeStr = DateUtil.format(startTimeDate, "yyyy-MM-dd HH:mm:ss");
                String sql = "select * from finance.account_bill where billing_main_biz_id=" + billingMainBizId + " and start_time='" + startTimeStr +"';\n";
                FileUtil.appendString("#----\n", "/Users/aguda/Desktop/tasksql0130", "utf-8");
                FileUtil.appendString(sql, "/Users/aguda/Desktop/tasksql0130", "utf-8");
                sql = "select * from finance.account_bill_task where billing_main_biz_id ="+billingMainBizId + " and billing_biz_id ="+ billingBizId + " and start_time = '" + startTimeStr +"'; \n\n";
                FileUtil.appendString(sql, "/Users/aguda/Desktop/tasksql0130", "utf-8");
            }
        }
    }

    public static void test1() {
        List<String> billDataList = FileUtil.readLines("/Users/aguda/Desktop/审计对数据/bill", "utf-8");
        List<String> balanceDataList = FileUtil.readLines("/Users/aguda/Desktop/审计对数据/balance", "utf-8");
        System.out.println("bill条数：" + billDataList.size());
        System.out.println("balance条数：" + balanceDataList.size());
        List<String> result = Lists.newArrayList();
        for (String balanceData : balanceDataList) {
            if(billDataList.contains(balanceData)) {
                continue;
            }
            result.add(balanceData);
        }
        System.out.println("差异条数：" + result.size());
        System.out.println(JSON.toJSONString(result));
    }

    public static void test2() {
        List<String> list = FileUtil.readLines("/Users/aguda/Desktop/重复账户数据/重复账户20191112晚", "utf-8");
        List<String> result = Lists.newArrayList();
        Map<String, String>  existed = Maps.newHashMap();
        for (String s : list) {
            String temp[] = StringUtils.split(s, ",");
            if(StringUtils.isNotBlank(existed.get(temp[1]))) {
                result.add(temp[0]);
            } else {
                existed.put(temp[1],temp[0]);
            }
        }
        System.out.println(StringUtils.join(result, ","));
    }

    public static void test3() {
        List<String> meList = FileUtil.readLines("/Users/aguda/Desktop/test1", "utf-8");
        List<String> bkList = FileUtil.readLines("/Users/aguda/Desktop/test2", "utf-8");
        List<String> meResultList = Lists.newArrayList();
        for (String s : meList) {
            if(StringUtils.isNotBlank(s)) {
                meResultList.add(s);
            }
        }
        List<String> bkResultList = Lists.newArrayList();
        for (String s : bkList) {
            if(StringUtils.isNotBlank(s)) {
                bkResultList.add(s);
            }
        }
        List<String> temp1 = Lists.newArrayList();
        List<String> temp2 = Lists.newArrayList();
        for (String s : meResultList) {
            if(!bkResultList.contains(s)) {
                temp1.add(s);
            }
        }
        for (String s : bkResultList) {
            if(!meResultList.contains(s)) {
                temp2.add(s);
            }
        }
        System.out.println("temp1:" + StringUtils.join(temp1, ","));
        System.out.println("temp2:" + StringUtils.join(temp2, ","));
    }

    public static void test4() {
        List<String> originList = FileUtil.readLines("/Users/aguda/Desktop/origin", "utf-8");
        List<String> resultList = FileUtil.readLines("/Users/aguda/Desktop/result", "utf-8");
        List<String> list1 = Lists.newArrayList();
        List<String> list2 = Lists.newArrayList();
        for (String s : originList) {
            if(resultList.contains(s)) {
                continue;
            }
            list1.add(s);
        }
        for (String s : resultList) {
            if(originList.contains(s)) {
                continue;
            }
            list2.add(s);
        }
        System.out.println(list1);
        System.out.println(list2);
    }
}