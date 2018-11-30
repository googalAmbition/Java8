package com.ctc.lambda;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

/**
 * @author ctc
 */
public class Lambda1 {

    @Test
    public void sortTest() {
        List<String> list = Arrays.asList("hello", "world", "tome", "jack", "rose");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareToIgnoreCase(b);
            }
        });
        System.out.println(list);

        Collections.sort(list, (a, b) -> a.compareToIgnoreCase(b));

        list.sort(Collections.reverseOrder());
        System.out.println(list);

    }

    @Test
    public void sortTest2() {
        List<String> list = Arrays.asList("tom", "jack", "rose", "hello", null, "world");
        list.sort(Comparator.nullsLast(String::compareTo));
        System.out.println(list);

        List<String> list1 = null;
        Optional.ofNullable(list1).ifPresent(list2 -> list.sort(Comparator.naturalOrder()));
        System.out.println(list);
        System.out.println(list1);

    }
}

