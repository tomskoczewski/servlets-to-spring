package com.skoczewski;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloServiceTest {

    private HelloService SUT = new HelloService();
    @Test
    public void test_null_prepareGreeting_returnsFallbackValue() throws Exception{
        //given, when
        var result = SUT.prepareGreeting(null);

        //then
        assertEquals("Hello " + HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void test_null_prepareGreeting_name_returnsGreetingWithName() throws Exception{
        //given
        var name = "aaaa";

        //when
        var result = SUT.prepareGreeting(name);

        //then
        assertEquals("Hello " + name, result);
    }
}
