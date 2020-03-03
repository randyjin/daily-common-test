import cn.hutool.core.io.FileUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * BillDataFix
 *
 * @author 奕超
 * @date 2018/11/28
 */
public class BillDataFix {

    public static void main(String[] args) {
//        deleteTask();
        deleteResultDetail();
        deleteNoReturn();
        deleteRequest();
        deleteTarget();
        deleteTargetRule();
    }

    private static void deleteTarget() {
        List<String> lines = FileUtil.readLines("/Users/aguda/Desktop/datafixAfterOp/bill.log", "utf-8");
        List<Long> bizIdList = Lists.newArrayList();
        for (String line : lines) {
            Long bizId = parseBizId(line);
            if (Objects.nonNull(bizId)) {
                bizIdList.add(bizId);
            }
        }
        FileUtil.writeString("", "/Users/aguda/Desktop/datafixAfterOp/deleteTarget.sql", "utf-8");
        int count = bizIdList.size();
        int pageSize = 2000;
        int start = 0;
        int end = pageSize;
        boolean needContinue = true;
        while (needContinue) {
            if (end > count) {
                end = count;
                needContinue = false;
            }
            List<Long> subList = bizIdList.subList(start, end);
            String deleteSql = buildDeleteTargetSql(subList);
            if (StringUtils.isNotBlank(deleteSql)) {
                FileUtil.appendString(deleteSql, "/Users/aguda/Desktop/datafixAfterOp/deleteTarget.sql", "utf-8");
            }
            start = start + pageSize;
            end = end + pageSize;
        }
    }

    private static String buildDeleteTargetSql(List<Long> id) {
        if (CollectionUtils.isEmpty(id)) {
            return null;
        }
        String bizIdsStr = StringUtils.join(id, ",");
        return "delete from bill.billing_target where id in(" + bizIdsStr + ");\nsleep(1);\n";
    }

    private static void deleteTargetRule() {
        List<String> lines = FileUtil.readLines("/Users/aguda/Desktop/datafixAfterOp/bill.log", "utf-8");
        List<Long> bizIdList = Lists.newArrayList();
        for (String line : lines) {
            Long bizId = parseBizId(line);
            if (Objects.nonNull(bizId)) {
                bizIdList.add(bizId);
            }
        }
        FileUtil.writeString("", "/Users/aguda/Desktop/datafixAfterOp/deleteTargetRule.sql", "utf-8");
        int count = bizIdList.size();
        int pageSize = 2000;
        int start = 0;
        int end = pageSize;
        boolean needContinue = true;
        while (needContinue) {
            if (end > count) {
                end = count;
                needContinue = false;
            }
            List<Long> subList = bizIdList.subList(start, end);
            String deleteSql = buildTargetRuleSql(subList);
            if (StringUtils.isNotBlank(deleteSql)) {
                FileUtil.appendString(deleteSql, "/Users/aguda/Desktop/datafixAfterOp/deleteTargetRule.sql", "utf-8");
            }
            start = start + pageSize;
            end = end + pageSize;
        }
    }

    private static String buildTargetRuleSql(List<Long> targetId) {
        if (CollectionUtils.isEmpty(targetId)) {
            return null;
        }
        String bizIdsStr = StringUtils.join(targetId, ",");
        return "delete from bill.billing_target_rule where billing_target_id in(" + bizIdsStr + ");\nsleep(1);\n";
    }

    private static void deleteRequest() {
        List<String> lines = FileUtil.readLines("/Users/aguda/Desktop/datafixAfterOp/orderNo.log", "utf-8");
        FileUtil.writeString("", "/Users/aguda/Desktop/datafixAfterOp/deleteRequest.sql", "utf-8");
        Set<String> orderNoSet = Sets.newHashSet(lines);
        lines = Lists.newArrayList(orderNoSet);
        int count = lines.size();
        int pageSize = 2000;
        int start = 0;
        int end = pageSize;
        boolean needContinue = true;
        while (needContinue) {
            if (end > count) {
                end = count;
                needContinue = false;
            }
            List<String> subList = lines.subList(start, end);
            String deleteSql = buildDeleteRequestSql(subList);
            if (StringUtils.isNotBlank(deleteSql)) {
                FileUtil.appendString(deleteSql, "/Users/aguda/Desktop/datafixAfterOp/deleteRequest.sql", "utf-8");
            }
            start = start + pageSize;
            end = end + pageSize;
        }
    }

    private static String buildDeleteRequestSql(List<String> orderNoList) {
        String s = "";
        int size = orderNoList.size();
        for (int index = 0; index < size; index++) {
            s = s + "'" + orderNoList.get(index) + "'";
            if(index != size -1) {
                s = s + ",";
            }
        }

        return "delete from bill.billing_request where bill_biz_no in(" + s + ");\nslees(1);\n";
    }

    private static void deleteNoReturn() {
        List<String> lines = FileUtil.readLines("/Users/aguda/Desktop/datafixAfterOp/orderNo.log", "utf-8");
        FileUtil.writeString("", "/Users/aguda/Desktop/datafixAfterOp/deleteNoReturnDataSql.sql", "utf-8");
        Set<String> orderNoSet = Sets.newHashSet(lines);
        lines = Lists.newArrayList(orderNoSet);
        int count = lines.size();
        int pageSize = 2000;
        int start = 0;
        int end = pageSize;
        boolean needContinue = true;
        while (needContinue) {
            if (end > count) {
                end = count;
                needContinue = false;
            }
            List<String> subList = lines.subList(start, end);
            String deleteSql = buildDeleteNoReturn(subList);
            if (StringUtils.isNotBlank(deleteSql)) {
                FileUtil.appendString(deleteSql, "/Users/aguda/Desktop/datafixAfterOp/deleteNoReturnDataSql.sql", "utf-8");
            }
            start = start + pageSize;
            end = end + pageSize;
        }
    }

    private static String buildDeleteNoReturn(List<String> subList) {
        String s = "";
        int size = subList.size();
        for (int index = 0; index < size; index++) {
            s = s + "'" + subList.get(index) + "'";
            if(index != size -1) {
                s = s + ",";
            }
        }

        return "delete from bill.no_return_order where order_no in(" + s + ");\nslees(1);\n";
    }

    private static void deleteResultDetail() {
        List<String> lines = FileUtil.readLines("/Users/aguda/Desktop/datafixAfterOp/orderNo.log", "utf-8");
        FileUtil.writeString("", "/Users/aguda/Desktop/datafixAfterOp/deleteResultSql.sql", "utf-8");
        Set<String> orderNoSet = Sets.newHashSet(lines);
        lines = Lists.newArrayList(orderNoSet);
        int count = lines.size();
        int pageSize = 2000;
        int start = 0;
        int end = pageSize;
        boolean needContinue = true;
        while (needContinue) {
            if (end > count) {
                end = count;
                needContinue = false;
            }
            List<String> subList = lines.subList(start, end);
            String deleteSql = buildDeleteResultDetail(subList);
            if (StringUtils.isNotBlank(deleteSql)) {
                FileUtil.appendString(deleteSql, "/Users/aguda/Desktop/datafixAfterOp/deleteResultSql.sql", "utf-8");
            }
            start = start + pageSize;
            end = end + pageSize;
        }
    }

    private static String buildDeleteResultDetail(List<String> subList) {
        String s = "";
        int size = subList.size();
        for (int index = 0; index < size; index++) {
            s = s + "'" + subList.get(index) + "'";
            if(index != size -1) {
                s = s + ",";
            }
        }

        return "delete from bill.billing_result_detail where bill_biz_no in(" + s + ");\nslees(1);\n";
    }

    private static void deleteTask() {
        List<String> lines = FileUtil.readLines("/Users/aguda/Desktop/bill.log", "utf-8");
        List<Long> bizIdList = Lists.newArrayList();
        for (String line : lines) {
            Long bizId = parseBizId(line);
            if (Objects.nonNull(bizId)) {
                bizIdList.add(bizId);
            }
        }
        FileUtil.writeString("", "/Users/aguda/Desktop/deleteTaskSql.sql", "utf-8");
        int count = bizIdList.size();
        int pageSize = 2000;
        int start = 0;
        int end = pageSize;
        boolean needContinue = true;
        while (needContinue) {
            if (end > count) {
                end = count;
                needContinue = false;
            }
            List<Long> subList = bizIdList.subList(start, end);
            String deleteSql = buildDeleteTaskSql(subList);
            if (StringUtils.isNotBlank(deleteSql)) {
                FileUtil.appendString(deleteSql, "/Users/aguda/Desktop/deleteTaskSql.sql", "utf-8");
            }
            start = start + pageSize;
            end = end + pageSize;
        }
    }

    private static String removeTargetId(String line) {
        return line.substring(line.indexOf(",") + 1, line.length());
    }

    private static Long parseBizId(String data) {
        if (StringUtils.isBlank(data)) {
            return null;
        }
        List<String> dataList = Lists.newArrayList(StringUtils.split(data, ","));
        try {
            return Long.parseLong(dataList.get(0));
        } catch (Exception e) {
            return null;
        }
    }

    private static String buildDeleteTaskSql(List<Long> bizIdList) {
        if (CollectionUtils.isEmpty(bizIdList)) {
            return null;
        }
        String bizIdsStr = StringUtils.join(bizIdList, ",");
        return "update bill.task set deleted=1 where biz_id in(" + bizIdsStr + ");\nsleep(1);\n";
    }

}
