package com.teachmeskills.lesson_8.transfer.impl;

import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.BaseCard;
import com.teachmeskills.lesson_8.model.document.Check;
import com.teachmeskills.lesson_8.transfer.CardTransferService;

// TODO реализовать имплементацию интерфейса +
public class MasterCardTransferService implements CardTransferService {

    @Override
    public Check transferFromCardToCard(BaseCard senderCard, BaseCard receiverCard, double sum, int data, int numberCart) {
        if (senderCard.checkCardLimitTransfer(sum)) {
            senderCard.amount -= sum;
            receiverCard.amount += sum;
            System.out.println("Transfer from MasterCard to another card completed successfully.");
            return new Check(sum, data, numberCart);
        } else {
            System.out.println("Transfer from MasterCard to another card failed.");
            return new Check(sum, data, numberCart);
        }
    }

        @Override
        public Check transferFromCardToAccount (BaseCard senderCard, Account receiverAccount,double sum, int data,
        int numberCart){
            if (senderCard.checkCardLimitTransfer(sum)) {
                senderCard.amount -= sum;
                receiverAccount.setBalance(receiverAccount.getBalance() + sum);
                System.out.println("Transfer from MasterCard to account completed successfully.");
                return new Check(sum, data, numberCart);
            } else {
                System.out.println("Transfer from MasterCard to account failed.");
                return new Check(sum, data, numberCart);
            }
    }
}