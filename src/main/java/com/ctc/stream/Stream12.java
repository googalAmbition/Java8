package com.ctc.stream;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Stream12 {

    @Test
    public void test1(){
        SecureRandom random = new SecureRandom(new byte[]{1,3,3,7});
        int[] array = IntStream.generate(random::nextInt)
                .filter(n -> n > 0)
                .limit(10)
                .toArray();
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test2(){
        int[] array = IntStream.iterate(1, n -> n * 2).limit(11).toArray();
        System.out.println(Arrays.toString(array));
    }
}

