package com.tq.hacknight4.financr.service;

import com.tq.hacknight4.financr.Repo.InsultRepo;
import com.tq.hacknight4.financr.Repo.PlaidRepo;
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

    plaidRepo.test();

    String insult = insultRepo.getInsult("shoes");

    return insult;

  }
}
