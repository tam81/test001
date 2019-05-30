package com.abc.test.q03;

import java.math.BigDecimal;

/**
 * @author tam.nguyen
 * Created on 30-May-2019
 */
public class Bill {

  // A bill may have more info such as bill item, created date

  private final BigDecimal totalPrice;
  private final User user;
  private final Store store;

  public Bill(BigDecimal totalPrice, User user, Store store) {
    this.totalPrice = totalPrice;
    this.user = user;
    this.store = store;
  }

  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  public User getUser() {
    return user;
  }

  public Store getStore() {
    return store;
  }
}
