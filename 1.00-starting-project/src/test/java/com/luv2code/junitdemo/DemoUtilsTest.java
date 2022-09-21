package com.luv2code.junitdemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {
    
    @Test
    void tesetEqualsAndNotEquals() {
        DemoUtils demoUtils = new DemoUtils();
        
        assertEquals(6, demoUtils.add(2, 4));
        assertNotEquals(4, demoUtils.add(2, 4));
    }
}