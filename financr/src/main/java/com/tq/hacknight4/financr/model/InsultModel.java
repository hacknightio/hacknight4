package com.tq.hacknight4.financr.model;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "insults")
public class InsultModel {


  private List<String> people;
  private List<String> templates;
  private List<String> foodTemplates;
  private List<String> yothang;
  private List<String> pet;

  public List<String> getFoodTemplates() {
    return foodTemplates;
  }

  public void setFoodTemplates(List<String> foodTemplates) {
    this.foodTemplates = foodTemplates;
  }

  public List<String> getYothang() {
    return yothang;
  }

  public List<String> getPet() {
    return pet;
  }

  public void setPet(List<String> pet) {
    this.pet = pet;
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
