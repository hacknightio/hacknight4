package com.tq.hacknight4.financr.Repo;

import com.plaid.client.*;
import com.plaid.client.request.TransactionsGetRequest;
import org.springframework.stereotype.Repository;

@Repository
public class PlaidRepo {
    PlaidClient client;



    void test() {
        client.service().
        TransactionsGetRequest request = new TransactionsGetRequest()
        client.service().transactionsGet()
    }
}
