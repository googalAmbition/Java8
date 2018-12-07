package com.ctc.stream;

import org.junit.Test;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Stream3 {

    @Test
    public void rangTest() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        IntStream.range(0, 10).forEach(i -> {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        });

        IntStream.rangeClosed(0, 10)
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);
    }

    @Test
    public void reduceTest() {
        OptionalInt reduce = IntStream.range(0, 10).reduce((a, b) -> a + b);
        System.out.println(reduce.getAsInt());

        int reduce1 = IntStream.range(0, 10).reduce(7, (a, b) -> a + b);
        System.out.println(reduce1);
    }
}

