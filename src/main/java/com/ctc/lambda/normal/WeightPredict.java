package com.ctc.lambda.normal;

public class WeightPredict implements Predict {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 100;
    }
}

