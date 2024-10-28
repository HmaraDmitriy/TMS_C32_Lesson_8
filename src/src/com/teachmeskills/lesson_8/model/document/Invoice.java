package com.teachmeskills.lesson_8.model.document;

// TODO добавить поля на свое усмотрение +
public class Invoice {

    int dateRegistration;
    String holder;
    double balans;

    public Invoice(int dateRegistration, String holder, double balans) {
        this.dateRegistration = dateRegistration;
        this.holder = holder;
        this.balans = balans;
    }
}
