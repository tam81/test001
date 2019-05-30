package com.abc.test.q03.internal;

import com.abc.test.q03.Bill;
import com.abc.test.q03.DiscountRule;
import com.abc.test.q03.Store;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author tam.nguyen
 * Created on 30-May-2019
 */
public class PercentageDiscountRule implements DiscountRule {

  private final List<DiscountRule> percentageDiscountRules;

  public PercentageDiscountRule(List<DiscountRule> percentageDiscountRules) {
    this.percentageDiscountRules = percentageDiscountRules;
  }

  @Override
  public BigDecimal apply(Bill bill) {
    Store store = bill.getStore();
    if (!store.isGrocery()) {
      for (DiscountRule discountRule : percentageDiscountRules) {
        final BigDecimal amount = discountRule.apply(bill);
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
          return amount;
        }
      }
    }
    return BigDecimal.ZERO;
  }
}
