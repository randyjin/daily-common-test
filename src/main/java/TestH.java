import cn.hutool.core.date.DateTime;
import cn.hutool.core.io.FileUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * TestH
 *
 * @author 奕超
 */
public class TestH {

    public static void main(String[] args) {
        List<String> lines = FileUtil.readLines("/Users/aguda/Desktop/hello", "UTF-8");
        Map<String, Integer> result = Maps.newHashMap();
        for (String line : lines) {
            String[] data = StringUtils.split(line,",");
            result.put(data[0], Integer.valueOf(data[1]));
        }
        List<String> noList = Lists.newArrayList("2020051261521875440239218,2020051261834974508613694,2020051261693845704278681,2020051262050582793814122,2020051262257787774173503,2020051262249023729828192,2020051262611756618875529,2020051262436761104023578".split(","));
        Integer amount = 0;
        for(String billNo : result.keySet()) {
            if(noList.contains(billNo)) {
                amount = amount + result.get(billNo);
            }
        }
        System.out.println(amount);
//        Map<String,Map<String, Integer>> result = Maps.newHashMap();
//        for (String line : lines) {
//            String[] data = StringUtils.split(line,",");
//            Map<String,Integer> temp = result.get(data[2]);
//            if(temp == null) {
//                temp = Maps.newHashMap();
//            }
//            temp.put(data[0], Integer.valueOf(data[1]));
//            result.put(data[2], temp);
//        }
//        List<String> notInclude = getNoList();
//        Map<String,Integer> tempResult = result.get("20200521");
//
//        Integer amount = 0;
//        for (String billNo : tempResult.keySet()) {
//            if(notInclude.contains(billNo)) {
//                continue;
//            }
//            amount = amount + tempResult.get(billNo);
//        }
//        Map<String, Integer> beforeResult = result.get("20200520");
//        List<String> beforeList = getBeforeNoList();
//        for (String billNo : beforeResult.keySet()) {
//            if(beforeList.contains(billNo)) {
//                amount = amount+beforeResult.get(billNo);
//            }
//        }
//        System.out.println(amount);
    }

    private static List<String> getNoList() {
        String a = "2020051262791841565115349,2020051263058582287417608,2020051263062155847008779,2020051263047284891845457,2020051263001524817101112,2020051263031757234503901,2020051262994276359340577,2020051262937536817266755,2020051262790216029045466,2020051262787274072916916,2020051262862450118623732,2020051262853112960385783,2020051263056660012728446,2020051262974529169260557,2020051262918765549453331,2020051262995617211220455,2020051263074267612840924,2020051263052990500045781,2020051263023653826593526,2020051262997798798754605,2020051263060061249339726,2020051262991467593335249,2020051263001876350108349,2020051263037956420010223,2020051262992065311014985,2020051263030768272147313,2020051262902419050726229,2020051263132182218539480,2020051262972929608516001,2020051263047136388317703,2020051262988469894906682,2020051263080764635873615,2020051262999172072604177,2020051263107484000715600,2020051262991467593334959,2020051263056248333402172,2020051263026953795928320,2020051263025530295288051";
//        return Lists.newArrayList(StringUtils.split(a, ","));
        return Lists.newArrayList();
    }
    private static List<String> getBeforeNoList() {
        String a = "2020051262787274072916916,2020051262790216029045466,2020051262791841565115349,2020051262853112960385783,2020051262862450118623732,2020051262902419050726229,2020051262918765549453331,2020051262937536817266755,2020051262972929608516001,2020051262974529169260557,2020051262988469894906682,2020051262991467593334959,2020051262991467593335249,2020051262992065311014985,2020051262994276359340577,2020051262995617211220455,2020051262997798798754605,2020051262999172072604177,2020051263001524817101112,2020051263001876350108349,2020051263023653826593526,2020051263025530295288051,2020051263026953795928320,2020051263030768272147313,2020051263031757234503901,2020051263037956420010223,2020051263047136388317703,2020051263047284891845457,2020051263052990500045781,2020051263056248333402172,2020051263056660012728446,2020051263058582287417608,2020051263060061249339726,2020051263062155847008779,2020051263074267612840924,2020051263080764635873615,2020051263107484000715600,2020051263132182218539480";
        return Lists.newArrayList(StringUtils.split(a, ","));
    }
}
