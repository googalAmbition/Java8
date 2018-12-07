package com.ctc.stream;

import org.junit.Assert;
import org.junit.Test;

import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Stream1 {
    private List<String> list = Arrays.asList(
            "ddd2",
            "aaa2",
            "bbb1",
            "aaa1",
            "bbb3",
            "ccc",
            "bbb2",
            "ddd1");

    @Test
    public void filterTest() {
        list.stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    @Test
    public void sortTest() {
        list.stream()
                .sorted()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    @Test
    public void mapping() {
        list.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        list.stream()
                .map(String::toUpperCase)
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }

    @Test
    public void matchTest() {
        boolean match1 = list.stream().anyMatch(s -> s.startsWith("a"));
        boolean match2 = list.stream().noneMatch(s -> s.startsWith("a"));
        boolean match3 = list.stream().allMatch(s->s.startsWith("a"));
        Assert.assertEquals(true,match1);
        Assert.assertEquals(false,match2);
        Assert.assertEquals(false,match3);
    }

    @Test
    public void countTest(){
        long a = list.stream().filter(s -> s.startsWith("a")).count();
        Assert.assertEquals(2L,a);
    }

    @Test
    public void reduceTest(){
        Optional<String> optional = list.stream().sorted().reduce((s1,s2)->s1+"#"+s2);
        optional.ifPresent(System.out::print);
    }

}

