package com.epam.homework.multithreading.bank;

public class IncorrectWithdrawalException extends RuntimeException {

    public IncorrectWithdrawalException() {
        super();
    }

    public IncorrectWithdrawalException(String s) {
        super(s);
    }
}