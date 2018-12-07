package com.ctc.stream;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author ctc
 */
public class Optional2 {

    static class Outer {

        Nested nested = new Nested();

        public Nested getNested() {
            return nested;
        }
    }

    static class Nested {
        Inner inner = new Inner();

        public Inner getInner() {
            return inner;
        }
    }

    static class Inner {
        String foo = "boo";

        String getFoo() {
            return foo;
        }
    }

    private static <T> Optional<T> resolve(Supplier<T> resolver){
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }

    @Test
    public void test1(){
        Optional.of(new Outer())
                .flatMap(o->Optional.ofNullable(o.nested))
                .flatMap(n->Optional.ofNullable(n.inner))
                .flatMap(i->Optional.ofNullable(i.foo))
                .ifPresent(System.out::print);
    }

    @Test
    public void test2(){
        Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(System.out::print);
    }

    @Test
    public void test3(){
        Outer outer = new Outer();
        resolve(()->outer.getNested().getInner().getFoo()).ifPresent(System.out::print);
    }
}

