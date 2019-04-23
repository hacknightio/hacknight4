package com.tq.hacknight4.financr.controller;

import com.tq.hacknight4.financr.service.SomethingSomethingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class ScheduleCtrl {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  SomethingSomethingService something;


  @Scheduled(fixedRate = 60_000) // 1 minute
  public void timed() {
    log.info("scheduled controller");
    log.info(something.getShame());

  }

}
