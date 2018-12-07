package com.ctc.stream;

import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Stream6 {

    private class Foo {
        private String name;
        private List<Bar> bars = new ArrayList<>();

        public Foo(String name) {
            this.name = name;
        }
    }

    private class Bar {
        private String name;

        public Bar(String name) {
            this.name = name;
        }
    }

    @Test
    public void test1() {
        List<Foo> foos = new ArrayList<>();
        IntStream.range(0, 4).forEach(num -> foos.add(new Foo("foot" + num)));

        foos.stream().forEach(f ->
                IntStream.range(1, 4)
                        .forEach(num ->
                                f.bars.add(new Bar("bar" + num + "<-" + f.name))));

        foos.stream().flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));
    }

    @Test
    public void test2() {
        IntStream.range(1, 4).mapToObj(num -> new Foo("foo" + num))
                .peek(f -> IntStream.range(1, 4).mapToObj(num->new Bar("bar" + num + "<-" + f.name))
                                .forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));
    }
}

