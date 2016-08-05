package org.trlove.collection;

import java.text.Collator;
import java.util.*;

/**
 * Created by aguda on 16/6/8.
 */
public class SortDemo {
    public static void main(String[] args) {
        Location l1 = new Location(1L, "杭州");
        Location l4 = new Location(1L, "hangzhou");
        Location l2 = new Location(2L, "北方");
        Location l5 = new Location(2L, "beifang");
        Location l3 = new Location(3L, "beijing");
        Location l6 = new Location(3L, "北京");
        List<Location> list = new ArrayList<Location>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);
        list.add(l6);
        Collections.sort(list, new Comparator<Location>() {
            @Override
            public int compare(Location location1, Location location2) {
                Comparator cmp = (Collator.getInstance(Locale.CHINA));
                return cmp.compare(location1.getName(), location2.getName());
            }
        });
        for(Location location : list) {
            System.out.println(location.getName());
        }
    }

}
