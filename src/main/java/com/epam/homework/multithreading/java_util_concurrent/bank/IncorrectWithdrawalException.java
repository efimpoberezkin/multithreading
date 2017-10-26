package com.epam.homework.multithreading.java_util_concurrent.bank;

public class IncorrectWithdrawalException extends RuntimeException {

    public IncorrectWithdrawalException() {
        super();
    }

    public IncorrectWithdrawalException(String s) {
        super(s);
    }
}