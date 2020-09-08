import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Test
 *
 * @author 奕超
 */
public class Test {

    public static void main(String[] args) {
        String a = "1445334,1296595,1749851,1250705,146817,1807263,1935195,936392,1468049,1793052,1588816,2180456,2139179,1091165,1683988,2181423,1554183,1754190,53653,1311756,2268347,1972484,1487434,1758086,1780678,673429,2003196,640557,199270,1454003,1704188,430752,1827314,1342141,2309578,982496,2058161,2213647,1572344,1343973,976828,1018237,1267748,2061672,2198424,567155,1744678,2034531";
        String b = "53653,146817,199270,430752,567155,640557,673429,673429,884210,936392,982496,1018237,1091165,1267748,1296595,1311756,1342141,1343973,1445334,1454003,1468049,1487434,1519334,1554183,1572344,1586493,1588816,1744678,1749851,1758086,1780678,1793052,1807263,1827314,1935195,1972484,2003196,2034531,2058161,2061672,2139179,2180456,2181423,2198424,2213647,2268347,2279301,2309578";
        Set<String> set = Sets.newHashSet();


        for(String c : StringUtils.split(b, ",")) {
            set.add(c);

        }

        for(String c : StringUtils.split(a, ",")) {
            if(!set.contains(c)) {
                System.out.println(c);
            }
        }

        System.out.println(JSON.toJSONString(set));

//        test();
//        FileUtil.writeString("", "/Users/aguda/Desktop/curlfk", "utf-8");
//        List<String> lines =  FileUtil.readLines("/Users/aguda/Desktop/1", "UTF-8");
//        String origin = "curl -X POST \"http://localhost:8080/test/deletedBalance\" -H \"accept: */*\" -H \"Content-Type: application/json\" -d \"";
//        int index = 0;
//        int end = 1000;
//        int offset = 1000;
//        int count = 0;
//        boolean needContinue = true;
//        while (true) {
//            if(!needContinue) {
//                break;
//            }
//            if(lines.size()<end) {
//                end=lines.size();
//                needContinue = false;
//            }
//            List<String> temp = lines.subList(index, end);
//            if(CollectionUtils.isEmpty(temp)) {
//                break;
//            }
//            String curl = origin + StringUtils.join(temp, ",") + "\"\n";
//            count = count+temp.size();
//            FileUtil.appendString(curl, "/Users/aguda/Desktop/curlfk", "utf-8");
//            index = end;
//            end = end + offset;
//        }
//        System.out.println(count);
    }

    public static void test() {
        FileUtil.writeString("", "/Users/aguda/Desktop/checkSql", "utf-8");
        List<String> lines =  FileUtil.readLines("/Users/aguda/Desktop/1", "UTF-8");
        int index = 0;
        int end = 5000;
        int offset = 5000;
        int count = 0;
        boolean needContinue = true;
        while (true) {
            if(!needContinue) {
                break;
            }
            if(lines.size()<end) {
                end=lines.size();
                needContinue = false;
            }
            List<String> temp = lines.subList(index, end);
            if(CollectionUtils.isEmpty(temp)) {
                break;
            }
            String sql = "select * from finance.account_balance where status=1 and biz_doc_no in(";
            String no = "";
            for (String s : temp) {
                no = no+","+"'"+s+"'";
            }
            sql = sql + no + ")\n";
            FileUtil.appendString(sql, "/Users/aguda/Desktop/checkSql", "utf-8");
            index = end;
            end = end + offset;
        }
        System.out.println(count);
    }
}
