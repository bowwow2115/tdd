package com.udemy.tdd.example;

public class Money {
    protected int amount;

    //assert의 equals 를 Overide해서 기존의 메소드를 변경시킴
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && this.getClass().equals(object.getClass());
    }
}
