package com.ctc.stream;

import org.junit.Test;

import java.util.Optional;

/**
 * @author ctc
 */
public class Optional1 {
    @Test
    public void test(){
        Optional<String> optional =Optional.of("bam");
        optional.isPresent();
        optional.get();
        optional.orElse("");

        optional.ifPresent(System.out::print);
    }
}

