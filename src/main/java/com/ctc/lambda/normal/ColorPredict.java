package com.ctc.lambda.normal;

public class ColorPredict implements Predict {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals(Color.RED);
    }
}

