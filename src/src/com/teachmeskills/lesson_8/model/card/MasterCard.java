package com.teachmeskills.lesson_8.model.card;

import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.document.Check;
import com.teachmeskills.lesson_8.transfer.CardTransferService;
import com.teachmeskills.lesson_8.utils.Constants;

import java.util.Date;

public class MasterCard extends BaseCard implements CardTransferService, Constants {

    public String country;
    public int limit;
    private static final double MAX_MASTERCARD_TRANSFER_LIMIT = 700;

    public MasterCard(String cardNumber, int cvv, Date validDate, String cardHolder, String currency, double amount, String country, int limit) {
        super(cardNumber, cvv, validDate, cardHolder, currency, amount);
        this.country = country;
        this.limit = limit;
    }

    @Override
    public boolean checkCardLimitTransfer(double sum) {
        return sum <= MAX_MASTERCARD_TRANSFER_LIMIT && this.amount >= sum;
    }

    @Override
    public Check transferFromCardToCard(BaseCard senderCard, BaseCard receiverCard, double sum, int data, int numberCart) {
        if (checkCardLimitTransfer(sum) && senderCard.amount >= sum) {
            senderCard.amount -= sum;
            receiverCard.amount += sum;
            System.out.println("Transfer completed successfully.");
            return new Check(sum, data, numberCart);
        } else {
            System.out.println("Transfer failed.");
            return new Check(sum, data, numberCart);
        }
    }

    @Override
    public Check transferFromCardToAccount(BaseCard senderCard, Account receiverAccount, double sum, int data, int numberCart) {
        if (checkCardLimitTransfer(sum) && senderCard.amount >= sum) {
            senderCard.amount -= sum;
            receiverAccount.setBalance(receiverAccount.getBalance() + sum); // Зачисление суммы на счет получателя
            System.out.println("Transfer completed successfully.");
            return new Check(sum, data, numberCart);
        } else {
            System.out.println("Transfer faileds.");
            return new Check(sum, data, numberCart);
        }
    }
}
