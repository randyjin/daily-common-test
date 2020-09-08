import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.math.NumberUtils;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by damao on 2017/4/19.
 */
public class DateUtil {

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    private DateUtil() {
    }

    public static final SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat formater_yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");

    public static void test(String time) {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = formater_yyyyMMdd.format(ca.getTime());
        Date returnDate = null;
        try {
            returnDate = formater2.parse(last + time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(time + ":" + returnDate);
    }

    public static void main(String[] args) {
        List<String> a = Lists.newArrayList(" 10:00:00"," 10:30:00", " 11:00:00", " 12:00:00");
       for (int i=0;  i<1000000; i++) {
           new Thread() {
               @Override
               public void run(){
                   try {
                       Thread.sleep(100L);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   Random random = new Random();
                   int next = random.nextInt();
                   if(next<0) {
                       next = 0-next;
                   }
                   DateUtil.test(a.get(next%4));
               }

           }.start();
       }
    }

}
