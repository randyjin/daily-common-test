import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;

/**
 * BillTargetDup
 *
 * @author 奕超
 */
public class BillTargetDup {

    public static void main(String[] args) {
        List<String> list = FileUtil.readLines("/Users/aguda/Desktop/财务结账数据核对/计费对象疑似重复数据","utf-8");
        Map<String, List<String>> map = Maps.newHashMap();
        for (String s : list) {
            String[] a = s.split(",");
            List<String> temp = map.get(a[0]);
            if(Objects.isNull(temp)) {
                temp = Lists.newArrayList();
            }
            temp.add(s);
            map.put(a[0], temp);
        }
        Set<String> shopIdSet = Sets.newHashSet();
        for (String a : map.keySet()) {
            List<String> tempList = map.get(a);
            if(CollectionUtils.isEmpty(tempList)) {
                continue;
            }
            List<Map<String, Date>> temp = Lists.newArrayList();
            for (String s : tempList) {
                String[] aa = s.split(",");
                Date start = DateUtil.parse(aa[4], "yyyy-MM-dd HH:mm:ss");
                Date end = DateUtil.parse(aa[5], "yyyy-MM-dd HH:mm:ss");
                Map<String, Date> aaa = Maps.newHashMap();
                aaa.put("start", start);
                aaa.put("end", end);
                //判断是否有重复
                for(Map<String, Date> aaaa : temp) {
                    Date start1 = aaaa.get("start");
                    Date end1 = aaaa.get("end");
                    if ((start1.compareTo(start) < 0 && start1.compareTo(end) < 0 && end1.compareTo(start) < 0 && end1.compareTo(end) < 0)
                            || (start1.compareTo(start) > 0 && start1.compareTo(end) > 0
                            && end1.compareTo(start) > 0 && end1.compareTo(end) > 0)) {
                        continue;
                    }
                    shopIdSet.add(aa[0]);
                    System.out.println(aa[0]);
                }
                temp.add(aaa);
            }
        }
        System.out.println(shopIdSet);
        List<String> aaaaaa = Lists.newArrayList();
        for (String s : list) {
            String[] a = s.split(",");
            if(shopIdSet.contains(a[0])) {
                aaaaaa.add(s);
            }
        }
        FileUtil.writeLines(aaaaaa,"/Users/aguda/Desktop/财务结账数据核对/重复问题数据", "UTF-8");
    }

}
