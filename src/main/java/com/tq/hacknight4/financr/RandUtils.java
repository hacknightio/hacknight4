package com.tq.hacknight4.financr;

import java.security.SecureRandom;
import java.util.List;

public final class RandUtils {

  private static final SecureRandom rand = new SecureRandom();

  public static <T> T randFrom(List<T> list) {
    return list.get(rand.nextInt(list.size()));
  }

}
