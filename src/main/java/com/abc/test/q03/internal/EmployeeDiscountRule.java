package com.abc.test.q03.internal;

import com.abc.test.q03.Bill;
import com.abc.test.q03.DiscountRule;
import com.abc.test.q03.User;

import java.math.BigDecimal;

/**
 * @author tam.nguyen
 * Created on 30-May-2019
 */
public class EmployeeDiscountRule implements DiscountRule {

  private static final double PERCENTAGE_DISCOUNT = 0.3;

  @Override
  public BigDecimal apply(Bill bill) {
    final User user = bill.getUser();
    if (user.isEmployee()){
      return bill.getTotalPrice().multiply(BigDecimal.valueOf(PERCENTAGE_DISCOUNT));
    }
    return BigDecimal.ZERO;
  }
}
