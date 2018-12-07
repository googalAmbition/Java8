package com.ctc.stream;

import org.junit.Test;
import sun.management.counter.perf.PerfInstrumentation;

import java.util.Arrays;
import java.util.List;

public class Stream10 {

    private static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private List<Person> persons =
            Arrays.asList(
                    new Person("Max", 18),
                    new Person("Peter", 23),
                    new Person("Pamela", 23),
                    new Person("David", 12));

    @Test
    public void test1() {
        persons.stream().reduce((p1, p2) -> p1.age > p2.age ? p1 : p2).ifPresent(System.out::println);
    }

    @Test
    public void test2() {
        Person person = persons.stream().reduce(new Person("", 0), (p1, p2) -> {
            p1.age += p2.age;
            p1.name += p2.name;
            return p1;
        });

        System.out.printf("name=%s--age=%s\n", person.name, person.age);
    }

    @Test
    public void test3() {
        Integer sum = persons.stream().reduce(0, (su, p) -> su += p.age, (sum1, sum2) -> sum1 + sum2);
        System.out.println(sum);
    }

    @Test
    public void test4(){
        Integer n = persons.stream().reduce(0, (s, p) -> {
            System.out.printf("s=%s\tp=%s\n", s, p);
            s += p.age;
            return s;
        }, (sum1, sum2) -> {
            System.out.println("sum1+sum2");
            return sum1 + sum2;
        });
        System.out.println(n);
    }

    @Test
    public void test5(){
        Integer n = persons.parallelStream().reduce(0, (s, p) -> {
            System.out.printf("s=%s\tp=%s\n", s, p);
            s += p.age;
            return s;
        }, (sum1, sum2) -> {
            System.out.println("sum1+sum2=="+(sum1+sum2));
            return sum1 + sum2;
        });
        System.out.println(n);
    }

    @Test
    public void test6(){
        Integer n = persons.parallelStream().reduce(0, (s, p) -> {
            System.out.printf("s=%s\tp=%s\tthread=%s\n", s, p,Thread.currentThread().getName());
            s += p.age;
            return s;
        }, (sum1, sum2) -> {
            System.out.println("sum1+sum2=="+(sum1+sum2)+Thread.currentThread().getName());
            return sum1 + sum2;
        });
        System.out.println(n);
    }
}

