package com.teachmeskills.lesson_8.model.card;

import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.document.Check;
import com.teachmeskills.lesson_8.transfer.CardTransferService;
import com.teachmeskills.lesson_8.utils.Constants;

import java.util.Date;

public class VisaCard extends BaseCard implements CardTransferService, Constants {

    int cashback;

    private static final double MAX_VISA_TRANSFER_LIMIT = 500;

    public VisaCard(String cardNumber, int cvv, Date validDate, String cardHolder, String currency, int cashback) {
        super(cardNumber, cvv, validDate, cardHolder, currency, cashback);
        this.cashback = cashback;
    }

    @Override
    public boolean checkCardLimitTransfer(double sum) {
        return sum <= MAX_VISA_TRANSFER_LIMIT && this.amount >= sum;
    }

    @Override
    public  Check transferFromCardToCard(BaseCard senderCard, BaseCard receiverCard, double sum, int data, int numberCart) {
        if (checkCardLimitTransfer(sum) && this.amount >= sum) {
            this.amount -= sum;
            receiverCard.amount += sum;
            System.out.println("Transfer completed successfully.");
            return new Check(sum, data, numberCart);
        } else {
            System.out.println("Transfer failed.");
            return new Check(sum, data, numberCart);
        }
    }

    @Override
    public  Check transferFromCardToAccount(BaseCard senderCard, Account receiverAccount, double sum, int data, int numberCart) {
        if (checkCardLimitTransfer(sum) && this.amount >= sum) {
            this.amount -= sum;
            receiverAccount.setBalance(receiverAccount.getBalance() + sum);
            System.out.println("Transfer completed successfully.");
            return new Check(sum, data, numberCart);
        } else {
            System.out.println("Transfer failed.");
            return new Check(sum, data, numberCart);
        }
    }
}

