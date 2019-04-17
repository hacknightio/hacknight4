package com.tq.hacknight4.financr.Repo;

import com.plaid.client.*;
import com.plaid.client.request.TransactionsGetRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class PlaidRepo {

  Logger log = LoggerFactory.getLogger(this.getClass());


  @Autowired
    PlaidClient client;

    @Autowired
    @Qualifier("api_token")
    String apiToken;


    public void test() {

      log.info("hey-o {}", apiToken);
//        TransactionsGetRequest request = new TransactionsGetRequest()
//        client.service().transactionsGet()
    }
}
