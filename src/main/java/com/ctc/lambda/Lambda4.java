package com.ctc.lambda;

import org.junit.Test;

public class Lambda4 {

    private int outNumber;

    @Test
    public void scropTest(){
        Lambda2.Convert<Integer, String> toInteger =Integer::valueOf;
        toInteger.convert("123");

        Lambda2.Convert<Integer, String> convert = (a)->{
            Integer integer = Integer.valueOf(a);
            return integer+2;
        };
        convert.convert("123");
    }


}

