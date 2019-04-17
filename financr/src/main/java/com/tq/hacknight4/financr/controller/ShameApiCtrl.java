package com.tq.hacknight4.financr.controller;

import com.tq.hacknight4.financr.service.SomethingSomethingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v0/shame")
public class ShameApiCtrl {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  SomethingSomethingService something;

  @GetMapping
  public void get( ) {
    log.info("web api controller");
    something.shameMe();
  }


}
