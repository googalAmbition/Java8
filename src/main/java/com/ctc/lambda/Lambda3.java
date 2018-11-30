package com.ctc.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda3 {

    @FunctionalInterface
    private interface Fun {
        void foo();
    }


    @Test
    public void predictTest() {
        Predicate<String> predicate = (s) -> s.length() > 0;
        predicate.test("foo");
        predicate.negate().test("foo");

//        Predicate<Boolean> nonNull = (o) -> Objects.nonNull(o);
        Predicate<Boolean> nonNull = Objects::nonNull;

        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }

    @Test
    public void functionTest() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = String::valueOf;

        Assert.assertEquals("123", backToString.apply("123"));
    }

    @Test
    public void supplyTest() {
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();
    }

    @Test
    public void consumerTest() {
        Consumer<Person> greeter = (p) -> System.out.println(MessageFormat.format("Hello {0}!", p.getFirstName()));
        greeter.accept(new Person("tom", "hanks"));
    }

    @Test
    public void comparator() {
        Comparator<Person> comparator1 = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());

        Comparator<Person> comparator = Comparator.comparing(Person::getFirstName);
        Person person1 = new Person("tom", "hanks");
        Person person2 = new Person("morgen","foreman");
        comparator.compare(person1,person2);
    }

    @Test
    public void runTest(){
        Runnable runnable = ()-> System.out.println("hello world");
        new Thread(runnable).start();
    }

    @Test
    public void callableTest() throws Exception {
        Callable<UUID> callable = UUID::randomUUID;
        callable.call();
    }
}

