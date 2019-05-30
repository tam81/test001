package com.abc.test.q03;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author tam.nguyen
 * Created on 30-May-2019
 */
public class DiscountCalculator {

  private final List<DiscountRule> discountRules;

  public DiscountCalculator(List<DiscountRule> discountRules) {
    this.discountRules = discountRules;
  }

  public BigDecimal calculate(Bill bill) {
    BigDecimal total = BigDecimal.ZERO;
    for (DiscountRule discountRule : discountRules) {
      total = total.add(discountRule.apply(bill));
    }
    return total;
  }
}
