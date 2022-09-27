package com.luv2code.junitdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

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

    @DisplayName("Same and Not Same")
    @Test
    void testSameAndNotSame() {
        String str = "hello";
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate());
        assertNotSame(str, demoUtils.getAcademy());
    }

    @DisplayName("True and False")
    @Test
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo));
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne));
    }

    void testArrayEquals() {
        String[] stingArray = {"A", "B", "C"};

        assertArrayEquals(stingArray, demoUtils.getFirstThreeLettersOfAlphabet());
    }

    void testIterableEquals() {
        List<String> theList = List.of("luv", "2", "code");
        assertIterableEquals(theList, demoUtils.getAcademyInList());
    }

    @Test
    void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> { demoUtils.checkTimeout(); },
                "Method should execute in 3 seconds");
    }
}