package com.ctc.lambda.normal;

import java.util.List;

public class Filter {

    public static void filter(List<Apple> list, Predict predict){
        for (Apple apple : list){
            if (predict.test(apple)){
                System.out.println(apple);
            }
        }
    }

}

