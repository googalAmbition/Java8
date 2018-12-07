package com.ctc.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream7 {

    @Test
    public void test1() {
        Arrays.asList("a1", "a2", "a3")
                .stream().findFirst()
                .ifPresent(System.out::print);

        Stream.of("a1", "a2", "a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        IntStream.range(1, 4).mapToObj(i -> "i" + i).forEach(System.out::println);

        Arrays.stream(new int[]{1, 2, 3}).map(n -> 2 * n + 1).average().ifPresent(System.out::println);

        Stream.of(1.0,2.0,3.0).mapToInt(Double::intValue).mapToObj(i->"a"+i).forEach(System.out::println);
    }
}

