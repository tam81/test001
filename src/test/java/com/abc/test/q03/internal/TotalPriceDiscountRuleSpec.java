package com.abc.test.q03.internal;

import com.abc.test.q03.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author tam.nguyen
 * Created on 30-May-2019
 */
public class TotalPriceDiscountRuleSpec {

  @Test
  public void shouldApplyTotalPriceDiscount() {

    final DiscountRule rule = new TotalPriceDiscountRule();
    final Bill bill = new Bill(BigDecimal.valueOf(550), new User(UserType.EMPLOYEE), new Store());

    final BigDecimal amount = rule.apply(bill);

    Assertions.assertEquals(BigDecimal.valueOf(25), amount);
  }

  @Test
  public void shouldNotApplyTotalPriceDiscount() {

    final DiscountRule rule = new TotalPriceDiscountRule();
    final Bill bill = new Bill(BigDecimal.valueOf(99), new User(UserType.EMPLOYEE), new Store());

    final BigDecimal amount = rule.apply(bill);

    Assertions.assertEquals(BigDecimal.ZERO, amount);
  }
}
