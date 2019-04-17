package com.tq.hacknight4.financr.Repo;

import com.plaid.client.*;
import com.plaid.client.request.TransactionsGetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class PlaidRepo {


    @Autowired
    PlaidClient client;

    @Autowired
    @Qualifier("api_token")
    String apiToken;


    void test() {
        client.service().
        TransactionsGetRequest request = new TransactionsGetRequest()
        client.service().transactionsGet()
    }
}
