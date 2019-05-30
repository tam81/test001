package com.abc.test.q03.internal;

import com.abc.test.q03.Bill;
import com.abc.test.q03.DiscountRule;
import com.abc.test.q03.Store;

import java.math.BigDecimal;

/**
 * @author tam.nguyen
 * Created on 30-May-2019
 */
public class AffiliateStoreDiscountRule implements DiscountRule {

  private static final double PERCENTAGE_DISCOUNT = 0.1;

  @Override
  public BigDecimal apply(Bill bill) {
    final Store store = bill.getStore();
    if (store.isAffiliate()){
      return bill.getTotalPrice().multiply(BigDecimal.valueOf(PERCENTAGE_DISCOUNT));
    }
    return BigDecimal.ZERO;
  }
}
