package com.udemy.tdd.example;

public class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }


    //팩토리 기법인듯?
    public static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    public static Money franc(int amount){
        return new Money(amount,"CHF");
    }

    //assert의 equals 를 Overide해서 기존의 메소드를 변경시킴(기존의 메모리 주소값 비교에서 가지고 있는 값 비교로
    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && this.currency == money.currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    public Expression plus(Money addend) {
        return new Money(amount + addend.amount,  this.currency);
    }
}
