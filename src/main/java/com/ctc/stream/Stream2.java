package com.ctc.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Stream2 {

    private static final int MAX = 1000000;

    private static void normal() {
        List<String> values = new ArrayList<>(MAX);
        for (int i = 0; i < MAX; i++) {
            values.add(UUID.randomUUID().toString());
        }
        long start = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long end = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(end-start);
        System.out.println(millis);
    }

    private static void parallel() {
        List<String> values = new ArrayList<>(MAX);
        for (int i = 0; i < MAX; i++) {
            values.add(UUID.randomUUID().toString());
        }
        long start = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println(count);
        long end = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(end-start);
        System.out.println(millis);
    }


    @Test
    public void parallelTest() {
        normal();
        parallel();
    }


}

