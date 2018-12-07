package com.ctc.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Stream9 {
    private class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
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
        List<Person> list = persons.stream().filter(p -> p.name.startsWith("P")).collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void test2() {
        Map<Integer, List<Person>> groupByAge = persons.stream().collect(Collectors.groupingBy(p -> p.age));
        groupByAge.forEach((age, name) -> System.out.println(age + "-->" + name));
    }

    @Test
    public void test3() {
        Double averageAge = persons.stream().collect(Collectors.averagingInt(p -> p.age));
        System.out.println(averageAge);
    }

    @Test
    public void test4() {
        IntSummaryStatistics sumAge = persons.stream().collect(Collectors.summarizingInt(p -> p.age));
        System.out.println(sumAge);
    }

    @Test
    public void test5() {
        String string = persons.stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                .collect(Collectors.joining(" and ", "IN China ", " language."));
        System.out.println(string);
    }

    @Test
    public void test6() {
        Map<Integer, String> map = persons.stream()
                .collect(Collectors.toMap(p -> p.age, p -> p.name, (name1, name2) -> name1 + "->" + name2));
        System.out.println(map);
    }

    @Test
    public void test7() {
//        Collector<Person, StringJoiner, String> personNameCollector =
//                Collector.of(
//                        () -> new StringJoiner(" | "),          // supplier
//                        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
//                        (j1, j2) -> j1.merge(j2),               // combiner
//                        StringJoiner::toString);                // finisher

        Collector<Person, StringJoiner, String> collector =
                Collector.of(() -> new StringJoiner("|"),
                        (j, p) -> j.add(p.name.toUpperCase()),
                        (j1, j2) -> j1.merge(j2),
                        StringJoiner::toString);

        String names = persons.stream().collect(collector);
        System.out.println(names);
    }

    @Test
    public void test8() {
        Collector<Person, StringJoiner, String> collector =
                Collector.of(() -> {
                            System.out.println("string join |");
                            return new StringJoiner("|");
                        },
                        (j, p) -> {
                            System.out.printf("j:%s,p:%s\n",j,p);
                            j.add(p.name.toUpperCase());
                        },
                        (j1, j2) -> {
                            System.out.println("merge");
                            return j1.merge(j2);
                        },
                        j -> {
                            System.out.println("finish");
                            return j.toString();
                        });
        String names = persons.stream().collect(collector);
        System.out.println(names);
    }

    @Test
    public void test9(){
        Collector<Person, StringJoiner, String> collector =
                Collector.of(() -> {
                            System.out.println("string join |");
                            return new StringJoiner("|");
                        },
                        (j, p) -> {
                            System.out.printf("j:%s,p:%s\n",j,p);
                            j.add(p.name.toUpperCase());
                        },
                        (j1, j2) -> {
                            System.out.println("merge");
                            return j1.merge(j2);
                        },
                        j -> {
                            System.out.println("finish");
                            return j.toString();
                        });
        String names = persons.parallelStream().collect(collector);
        System.out.println(names);

    }
}

