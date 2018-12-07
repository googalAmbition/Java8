package com.ctc.stream;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ctc
 */
public class Stream5 {

    @Test
    public void test1() {
        int[] arr = {1, 3, 5, 7, 9};
        Arrays.stream(arr).average().ifPresent(System.out::print);
    }

    @Test
    public void test2(){
        IntStream.builder()
                .add(1)
                .add(2)
                .add(2)
                .add(2)
                .add(2)
                .build()
                .average()
                .ifPresent(System.out::print);
    }

    @Test
    public void test3(){
        IntStream.range(0,10).average().ifPresent(System.out::print);
    }

    @Test
    public void test4(){
        Stream.of(new BigDecimal("1.2"), new BigDecimal("2.8"))
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .ifPresent(System.out::print);
    }

}

