package com.tq.hacknight4.financr.Repo;

import com.plaid.client.*;

public class PlaidRepo {
    PlaidClient client;

    void test() {
        client.service().transactionsGet()
    }
}
