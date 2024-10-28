package com.teachmeskills.lesson_8;

import com.teachmeskills.lesson_8.document_parser.IParser;
import com.teachmeskills.lesson_8.fabric.ParserFabric;
import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.BaseCard;
import com.teachmeskills.lesson_8.model.card.MasterCard;
import com.teachmeskills.lesson_8.model.card.VisaCard;
import com.teachmeskills.lesson_8.model.client.BaseClient;
import com.teachmeskills.lesson_8.model.client.IndividualClient;
import com.teachmeskills.lesson_8.model.client.LegalClient;
import com.teachmeskills.lesson_8.transfer.impl.MasterCardTransferService;
import com.teachmeskills.lesson_8.transfer.impl.VisaCardTransferService;
import com.teachmeskills.lesson_8.utils.Constants;

import java.util.Date;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {
        // TODO запросить с консоли путь и имя файла +
        System.out.println("Specify the path and file name");
        Scanner scanner = new Scanner(System.in);
        String pathway = scanner.nextLine();

        // TODO сделать метод createParser статичным и избавиться от необходимости создания объекта parserFabric +

        // TODO заменить "" на имя файла, полученное со сканера +
        IParser parser = ParserFabric.createParser(pathway);


        // TODO реализовать тестовый сценарий +
        // создать двух клиентов
        // каждому клиенту создать два счета и две карты
        // перевести с карты одного клиента на карту другого сумму денег
        // перевести с карты одного клинента на счет другого клиента сумму денег

        BaseClient client1  = new IndividualClient( "Client1",
                new Account[]{  new Account("67995", 8000), new Account("8674749", 935)},
                new BaseCard[]{new MasterCard("CH98751", 987, new Date(), "Karl", "USD", 358, "USS", Constants.MAX_TRANSFER_LIMIT),
                new VisaCard("846346",456,new Date(),"Karl","EU",5)});


        BaseClient client2  = new LegalClient( "Client2",
                new Account[]{  new Account("26868", 11000), new Account("28468244", 666)},
                new BaseCard[]{new MasterCard("RF32626", 123, new Date(), "Eva", "USD", 220, "USS", Constants.MAX_TRANSFER_LIMIT),
                new VisaCard("63564",654,new Date(),"Eva","EU",3) });

        MasterCardTransferService masterCardTransferService = new MasterCardTransferService();
        VisaCardTransferService visaCardTransferService = new VisaCardTransferService();

        BaseCard senderCard = client1.getCards()[0];
        BaseCard receiverCard = client2.getCards()[1];
        Account receiverAccount = client1.getAccounts()[0];

        BaseCard senderCard1 = client1.getCards()[0];
        BaseCard receiverCard1 = client2.getCards()[1];
        masterCardTransferService.transferFromCardToCard(senderCard, receiverCard, 100, 20231028, 1);

        Account receiverAccount1 = client1.getAccounts()[1];
        senderCard = client2.getCards()[1];
        visaCardTransferService.transferFromCardToAccount(senderCard, receiverAccount, 50, 20231028, 2);
    }
}

