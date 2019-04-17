package com.tq.hacknight4.financr.controller;

import com.tq.hacknight4.financr.service.SomethingSomethingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

@Controller
public class StartupCtrl implements ApplicationRunner {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  SomethingSomethingService something;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    log.info("startup controller");
    log.info(something.getShame());
  }


}
