package com.tq.hacknight4.financr.Repo;

import static com.tq.hacknight4.financr.RandUtils.randFrom;

import com.tq.hacknight4.financr.model.InsultModel;
import java.security.SecureRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InsultRepo {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired InsultModel insultModel;

  SecureRandom rand = new SecureRandom();

  private static final String
      PEOPLE = "<people>", YOTHANG="<yothang>", PET="<pet>",
      CAT="<cat>", PAYEE="<payee>";

  public String getInsult(String payee, String category) {

    log.info("insult repo");

    String insult = randFrom(insultModel.getTemplates());
    if(category.toLowerCase().contains("food")
        ||category.toLowerCase().contains("restaurant")
        ||category.toLowerCase().contains("drink")
        ||category.toLowerCase().contains("bar")
        ||category.toLowerCase().contains("dessert")
        ||category.toLowerCase().contains("sushi")
        ||category.toLowerCase().contains("lalafel")) {
      insult = randFrom(insultModel.getFoodTemplates());
    }

    if (payee != null) {
      insult = insult.replaceAll(PAYEE, payee);
    }

    if (category != null) {
      insult = insult.replaceAll(CAT, category);
    }

    insult = insult.replaceAll(PEOPLE, randFrom(insultModel.getPeople()));
    insult = insult.replaceAll(YOTHANG, randFrom(insultModel.getYothang()));
    insult = insult.replaceAll(PET, randFrom(insultModel.getPet()));

    return insult;

  }
}
