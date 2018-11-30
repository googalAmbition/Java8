package com.ctc.lambda;

import org.junit.Test;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Lambda5 {

    @Test
    public void test() {
        BiConsumer<String, Integer> print = (k, v)
                -> System.out.println(MessageFormat.format("{0}-->{1}", k, v));
        print.accept("one",1);
        print.accept("two",2);
        System.out.println("=================");

        Map<String, Integer> map = new HashMap<String, Integer>(){{
            put("one",1);
            put("two",2);
        }};

        map.forEach(print);

    }
}

