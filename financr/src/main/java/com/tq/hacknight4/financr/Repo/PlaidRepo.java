package com.tq.hacknight4.financr.Repo;

import com.plaid.client.*;
import org.springframework.stereotype.Repository;

@Repository
public class PlaidRepo {
    PlaidClient client;

    void test() {
        client.service().transactionsGet()
    }
}
