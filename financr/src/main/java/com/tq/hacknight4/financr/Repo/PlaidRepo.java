package com.tq.hacknight4.financr.Repo;

import static com.tq.hacknight4.financr.RandUtils.randFrom;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

import com.plaid.client.PlaidClient;
import com.plaid.client.request.CategoriesGetRequest;
import com.plaid.client.request.TransactionsGetRequest;
import com.plaid.client.response.CategoriesGetResponse.Category;
import com.plaid.client.response.TransactionsGetResponse;
import com.tq.hacknight4.financr.Model.CoolTransaction;
import com.tq.hacknight4.financr.model.TransModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import retrofit2.Response;

@Repository
public class PlaidRepo {

  Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlaidClient client;

    @Autowired
    TransModel transModel;

    @Autowired
    @Qualifier("api_token")
    String apiToken;

    double min = 5D;
    double max = 100D;
    int TRANSACTION_COUNT = 5000;

    private CoolTransaction getRandomTransaction() {
        String payee = randFrom(transModel.getPayee());
        List<String> category = Arrays.asList(randFrom(transModel.getCategory()), randFrom(transModel.getCategory()));

        CoolTransaction firstTransaction = new CoolTransaction();
        firstTransaction.setAccountId("cooldude420");
        firstTransaction.setAccountOwner("Jaden Smith");
        firstTransaction.setAmount(ThreadLocalRandom.current().nextDouble(min, max));
        firstTransaction.setName("12345");
        firstTransaction.setDate("4/16/2019");
        firstTransaction.setOriginalDescription(payee);
        firstTransaction.setCategory(category);

        return firstTransaction;
    }


    public List<CoolTransaction> moneyTrail() {


        ArrayList<CoolTransaction> transactions = new ArrayList<>();

        for (int i = 0; i < TRANSACTION_COUNT; i++) {
            transactions.add(getRandomTransaction());
        }

        return transactions;
    }

    public void theRealDeal() {
              Date date = new Date(2016, 4,15);
        Date secondDate = new Date(2019, 4, 16);


        TransactionsGetRequest request = new TransactionsGetRequest(apiToken, date, secondDate);
        try {


          // CATEGORIES
          List<Category> allCats = client.service()
              .categoriesGet(new CategoriesGetRequest()).execute().body().getCategories();
          Set<String> uniqCats = allCats.stream()
              .flatMap(cat -> cat.getHierarchy().stream()).collect(toSet());
          String holyCrap = uniqCats.stream().collect(joining("*****"));
log.info("ya holy crap {}",holyCrap);
          // CATEGORIES

          Response<TransactionsGetResponse> response = client.service().transactionsGet(request).execute();
            //List<TransactionsGetResponse.Transaction> transactions = client.service().transactionsGet(request).execute().body().getTransactions();
            //transactions.forEach(System.out::println);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
