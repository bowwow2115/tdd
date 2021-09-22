package com.udemy.tdd.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    void testMultiplicationDollar() {
        Dollar five = new Dollar(5);
//      하나의 객체를 만들어서 재활용 하는 것은 값이 메모리에 남기 때문에 조작시 변경된 값을 기준으로 잡고 해야 함 따라서 편의성을 위해 새로운 객체를 생성함.
        Dollar product = five.times(2);
        assertEquals(new Dollar(10), product);
        product = five.times(3);
        assertEquals(new Dollar(15),product);
    }

    @Test
    void testEqualityDollar() {
        assertEquals(new Dollar(5), new Dollar(5));
        assertNotEquals(new Dollar(8), new Dollar(1));
        assertNotEquals(new Dollar(5), new Franc(5));
    }

    @Test
    void testMultiplicationFranc() {
        Franc five = new Franc(5);
//      하나의 객체를 만들어서 재활용 하는 것은 값이 메모리에 남기 때문에 조작시 변경된 값을 기준으로 잡고 해야 함 따라서 편의성을 위해 새로운 객체를 생성함.
        Franc product = five.times(2);
        assertEquals(new Franc(10), product);
        product = five.times(3);
        assertEquals(new Franc(15),product);
    }

    @Test
    void testEqualityFranc() {
        assertEquals(new Franc(5), new Franc(5));
        assertNotEquals(new Franc(8), new Franc(1));
    }
}
