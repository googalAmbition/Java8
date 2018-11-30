package com.ctc.lambda;

import org.junit.Test;

public class Lambda2 {

    protected static interface Convert<T, F> {
        T convert(F from);
    }

    private static class Something {
        String startWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    private interface PersonFactory<P extends Person>{
        P create(String firstName,String lastName);
    }

    @Test
    public void convertTest(){
        Convert<Integer, String> convert = from -> Integer.valueOf(from);
        Integer integer = convert.convert("123");
        System.out.println(integer);

        Convert<Integer, String> convert2 = Integer::valueOf;
        Integer integer2 = convert.convert("345");
        System.out.println(integer2);
    }

    @Test
    public void someThingTest(){
        Something something = new Something();
        Convert<String,String> convert = something::startWith;
        String s = convert.convert("Java");
        System.out.println(s);
    }

    @Test
    public void personTest(){

        PersonFactory factory = (firstName,lastName)->new Person(firstName,lastName);
        factory.create("morgen","fieldsman");

        PersonFactory personFactory = Person::new;
        Person person = personFactory.create("tom","hanks");
        System.out.println(person);
    }

}

