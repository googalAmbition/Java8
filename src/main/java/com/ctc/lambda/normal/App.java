package com.ctc.lambda.normal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class App {

    private List<Apple> list = new ArrayList<Apple>() {{
        add(new Apple(50, Color.BLUE));
        add(new Apple(150, Color.RED));
        add(new Apple(50, Color.BROWN));
        add(new Apple(250, Color.GREEN));
        add(new Apple(50, Color.BLUE));
        add(new Apple(150, Color.RED));
        add(new Apple(50, Color.BROWN));
    }};

    @Test
    public void normalTest() {
        Filter.filter(list, new ColorPredict());
    }

    @Test
    public void anonymousTest() {

        Filter.filter(list, new Predict() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() == 150;
            }
        });
    }

    @Test
    public void lambda() {
        Filter.filter(list, (apple) -> apple.getWeight() == 150);
    }

    @Test
    public void predicateTest() {
        filter(list, (apple) -> apple.getWeight() == 150);
    }

    public static void filter(List<Apple> list, Predicate<Apple> predicate) {
        for (Apple apple : list) {
            if (predicate.test(apple)) {
                System.out.println(apple);
            }
        }
    }

}

