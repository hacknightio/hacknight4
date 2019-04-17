package com.tq.hacknight4.financr.model;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "insults")
public class InsultModel {


  private List<String> people;
  private List<String> templates;
  private List<String> yothang;

  public List<String> getYothang() {
    return yothang;
  }

  public void setYothang(List<String> yothang) {
    this.yothang = yothang;
  }

  public List<String> getPeople() {
    return people;
  }

  public void setPeople(List<String> people) {
    this.people = people;
  }

  public List<String> getTemplates() {
    return templates;
  }

  public void setTemplates(List<String> templates) {
    this.templates = templates;
  }
}
