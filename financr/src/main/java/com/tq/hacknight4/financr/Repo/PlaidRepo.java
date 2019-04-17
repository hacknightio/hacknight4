package com.tq.hacknight4.financr.Repo;

import com.plaid.client.PlaidClient;
import com.plaid.client.response.TransactionsGetResponse.Transaction;
import com.tq.hacknight4.financr.Model.CoolTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class PlaidRepo {

  Logger log = LoggerFactory.getLogger(this.getClass());


  @Autowired
    PlaidClient client;

    @Autowired
    @Qualifier("api_token")
    String apiToken;

    double min = 5D;
    double max = 100D;


    public void test() {
//        Date date = new Date(2016, 4,15);
//        Date secondDate = new Date(2019, 4, 16);
//
//        TransactionsGetRequest request = new TransactionsGetRequest(apiToken, date, secondDate);
//        try {
//            Response<TransactionsGetResponse> response = client.service().transactionsGet(request).execute();
//            //List<TransactionsGetResponse.Transaction> transactions = client.service().transactionsGet(request).execute().body().getTransactions();
//            //transactions.forEach(System.out::println);
//            return;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ArrayList<CoolTransaction> transactions = new ArrayList<>();

        CoolTransaction firstTransaction = new CoolTransaction();
        firstTransaction.setAccountId("cooldude420");
        firstTransaction.setAccountOwner("Jaden Smith");
        firstTransaction.setAmount(ThreadLocalRandom.current().nextDouble(min, max));
        firstTransaction.setName("12345");
        firstTransaction.setDate("4/16/2019");
        firstTransaction.setOriginalDescription("shoes");
        transactions.add(firstTransaction);

        CoolTransaction secondTransaction = new CoolTransaction();
        secondTransaction.setAccountId("boringdude000");
        secondTransaction.setAccountOwner("Jeb Bush");
        secondTransaction.setAmount(85.00D);
        secondTransaction.setName("12345");
        secondTransaction.setDate("4/16/2019");
        secondTransaction.setOriginalDescription("");

        
    }
}
