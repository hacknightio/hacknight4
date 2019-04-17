package com.tq.hacknight4.financr.model;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "trans")
public class TransModel {


  private List<String> payee;
  private List<String> category;

  public List<String> getPayee() {
    return payee;
  }

  public void setPayee(List<String> payee) {
    this.payee = payee;
  }
}
