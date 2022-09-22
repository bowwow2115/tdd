package com.luv2code.junitdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {
   
    DemoUtils demoUtils;

    @BeforeEach
    void setupBefoeEach() {
        demoUtils = new DemoUtils();
        System.out.println("@BeforEach");
    }

    @Test
    @DisplayName("Equals and Not Equals")
    void tesetEqualsAndNotEquals() {

        System.out.println("Running test: tesetEqualsAndNotEquals");

        assertEquals(6, demoUtils.add(2, 4));
        assertNotEquals(4, demoUtils.add(2, 4));
    }

    @Test
    @DisplayName("Null and Not Null")
    void testNullAndNotNull() {

        System.out.println("Running test: testNullAndNotNull");

        assertNull(demoUtils.checkNull(null));
        assertNotNull(demoUtils.checkNull("notNull"));
    }
}