package com.teachmeskills.lesson_8.model.document;

// TODO добавить поля: сумма перевода, дата перевода, номер счета или номер карты +
// TODO создать метод для вывода информации о чеке на экран +
public class Check {
    double sum ;
    int data;
    int numberCart;

    public Check(double sum, int data, int numberCart) {
        this.sum = sum;
        this.data = data;
        this.numberCart = numberCart;
    }

    public void infoCheck() {
        System.out.println("Transfer amount: " + sum + ", transfer date: " + data + ", card number: " + numberCart);
        System.out.println();
    }
}
