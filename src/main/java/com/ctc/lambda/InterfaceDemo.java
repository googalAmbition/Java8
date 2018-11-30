package com.ctc.lambda;

import org.junit.Assert;
import org.junit.Test;

public class InterfaceDemo {

    interface Formula {
        double calculate(int a);

        default double sqrt(int a) {
            return Math.sqrt(a);
        }

        static int positive(int a) {
            return a > 0 ? a : 0;
        }
    }

    @Test
    public void testInteface(){
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return Math.sqrt(a*100);
            }
        };
        formula.calculate(100);
        System.out.println(formula.calculate(100));
        Assert.assertEquals(100.0D,formula.calculate(100),0.001D);
    }
}

