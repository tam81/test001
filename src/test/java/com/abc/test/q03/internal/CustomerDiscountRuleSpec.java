package com.abc.test.q03.internal;

import com.abc.test.q03.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author tam.nguyen
 * Created on 30-May-2019
 */
public class CustomerDiscountRuleSpec {

  @Test
  public void shouldApply5PercentDiscountForCustomerUser() {

    final DiscountRule rule = new CustomerDiscountRule();

    final Bill bill = new Bill(BigDecimal.valueOf(100), new User(UserType.CUSTOMER, LocalDateTime.now().minusYears(3)), new Store());

    final BigDecimal amount = rule.apply(bill);

    Assertions.assertEquals(0, BigDecimal.valueOf(5d).compareTo(amount));
  }

  @Test
  public void shouldNotApplyDiscountIfUserNotBeanCustomerFor2Years() {

    final DiscountRule rule = new CustomerDiscountRule();

    final Bill bill = new Bill(BigDecimal.valueOf(100), new User(UserType.CUSTOMER, LocalDateTime.now().minusYears(1)), new Store());

    final BigDecimal amount = rule.apply(bill);

    Assertions.assertEquals(BigDecimal.ZERO, amount);
  }

}
