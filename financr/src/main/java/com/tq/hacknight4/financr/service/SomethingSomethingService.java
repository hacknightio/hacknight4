package com.tq.hacknight4.financr.service;

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

  public void shameMe() {
    log.info("SERVICE");

    plaidRepo.test();

  }
}
