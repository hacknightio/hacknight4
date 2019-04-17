package com.tq.hacknight4.financr.service;

import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import com.tq.hacknight4.financr.Model.CoolTransaction;
import com.tq.hacknight4.financr.RandUtils;
import com.tq.hacknight4.financr.Repo.InsultRepo;
import com.tq.hacknight4.financr.Repo.PlaidRepo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SomethingSomethingService {

  Logger log = LoggerFactory.getLogger(this.getClass());


  @Autowired
  PlaidRepo plaidRepo;

  @Autowired
  InsultRepo insultRepo;

  public String getShame() {
    log.info("SERVICE");

//    plaidRepo.theRealDeal();

    List<CoolTransaction> transactions = plaidRepo.moneyTrail();

    Map<String, Long> weightedCategories = transactions.stream()
        // get a stream of all the categories
        .flatMap(ct -> ct.getCategory().stream())
        .collect(groupingBy(identity(), counting()))
        .entrySet().stream()
            // sort my category map by counts
            .sorted(reverseOrder(comparingByValue()))
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e2,
            LinkedHashMap::new));


    // now the map has the most spent categories first

    log.info("wow map {}",weightedCategories);

    String shameCategory = weightedCategories.entrySet().stream().findFirst().get().getKey();

    CoolTransaction shameTransaction = RandUtils.randFrom(transactions.stream().filter(ct->ct.getCategory().contains(shameCategory)).collect(toList()));

    String insult = insultRepo.getInsult(shameTransaction.getOriginalDescription(), shameCategory);

    return insult;

  }
}
