package com.ctc.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Stream4 {

    private List<String> list = Arrays.asList("d2", "a3", "a2", "b1", "b3", "c", "a1");

    @Test
    public void test1() {
        list.stream().filter(s -> {
            System.out.println("filter-->" + s);
            return true;
        }).forEach(s -> System.out.println("forEach-->" + s));
    }

    @Test
    public void test2() {
        list.stream().map(s -> {
            System.out.println("map-->" + s);
            return s.toUpperCase();
        }).filter(s -> {
            System.out.println("filter-->" + s);
            return s.startsWith("A");
        }).forEach(s -> System.out.println("forEach-->" + s));
    }

    @Test
    public void test3() {
        list.stream().filter(s -> {
            System.out.println("filter-->" + s);
            return s.startsWith("a");
        }).map(s -> {
            System.out.println("map-->" + s);
            return s.toUpperCase();
        }).forEach(s -> System.out.println("forEach-->" + s));
    }

    @Test
    public void test4() {
        list.stream().sorted((s1, s2) -> {
            System.out.println("sort-->" + s1 + "--" + s2);
            return s1.compareTo(s2);
        }).filter(s -> {
            System.out.println("filter-->" + s);
            return s.startsWith("a");
        }).map(s -> {
            System.out.println("map-->" + s);
            return s.toUpperCase();
        }).forEach(s -> System.out.println("forEach-->" + s));
    }

    @Test
    public void test5() {
        list.stream().filter(s -> {
            System.out.println("filter-->" + s);
            return s.startsWith("a");
        }).sorted((s1, s2) -> {
            System.out.println("sort-->" + s1 + "--" + s2);
            return s1.compareTo(s2);
        }).map(s -> {
            System.out.println("map-->" + s);
            return s.toUpperCase();
        }).forEach(s -> System.out.println("forEach-->" + s));
    }

    @Test
    public void test6() {
        list.stream().map(s -> {
            System.out.println("map-->" + s);
            return s.toUpperCase();
        }).anyMatch(s -> {
            System.out.println("match-->" + s);
            return s.startsWith("A");
        });
    }

    @Test
    public void test7() {
        Stream<String> stream =
                list.stream().filter(s -> s.startsWith("a"));
        stream.anyMatch(s -> true);

        Stream<String> stream1 =
                list.stream().filter(s -> s.startsWith("a"));
        stream1.noneMatch(s -> true);
    }

    @Test
    public void test8() {
        Supplier<Stream<String>> supplier = () -> list.stream().filter(s -> s.startsWith("a"));
        supplier.get().anyMatch(s -> true);
        supplier.get().noneMatch(s -> true);
    }
}

