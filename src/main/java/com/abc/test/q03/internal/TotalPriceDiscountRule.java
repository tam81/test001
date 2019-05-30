package com.abc.test.q03.internal;

import com.abc.test.q03.Bill;
import com.abc.test.q03.DiscountRule;

import java.math.BigDecimal;

/**
 * @author tam.nguyen
 * Created on 30-May-2019
 */
public class TotalPriceDiscountRule implements DiscountRule {

  private static final int QUALIFIED_AMOUNT = 100;
  private static final int AMOUNT_DISCOUNT = 5;

  @Override
  public BigDecimal apply(Bill bill) {
    final BigDecimal totalPrice = bill.getTotalPrice();
    return totalPrice.divideAndRemainder(BigDecimal.valueOf(QUALIFIED_AMOUNT))[0].multiply(BigDecimal.valueOf(AMOUNT_DISCOUNT));
  }
}
