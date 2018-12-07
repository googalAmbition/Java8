package com.ctc.stream;

import org.junit.Test;

import java.util.Arrays;

public class Stream8 {
    @Test
    public void test(){
        Arrays.asList("a1","b1","c1","c2")
                .stream()
                .filter(a->a.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}

