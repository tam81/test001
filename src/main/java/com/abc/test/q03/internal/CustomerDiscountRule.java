package com.abc.test.q03.internal;

import com.abc.test.q03.Bill;
import com.abc.test.q03.DiscountRule;
import com.abc.test.q03.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author tam.nguyen
 * Created on 30-May-2019
 */
public class CustomerDiscountRule implements DiscountRule {

  private static final double PERCENTAGE_DISCOUNT = 0.05;
  private static final int MIN_OF_YEARS = 2;

  @Override
  public BigDecimal apply(Bill bill) {
    final User user = bill.getUser();
    final LocalDateTime now = LocalDateTime.now();
    if (now.getYear() - user.getRegisteredDate().getYear() >= MIN_OF_YEARS) {
      return bill.getTotalPrice().multiply(BigDecimal.valueOf(PERCENTAGE_DISCOUNT));
    }
    return BigDecimal.ZERO;
  }
}
