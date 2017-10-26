package com.epam.homework.multithreading.java1_5.bank;

public class IncorrectWithdrawalException extends RuntimeException {

    public IncorrectWithdrawalException() {
        super();
    }

    public IncorrectWithdrawalException(String s) {
        super(s);
    }
}