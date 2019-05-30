package com.abc.test.q03.internal;

import com.abc.test.q03.Bill;
import com.abc.test.q03.Store;
import com.abc.test.q03.User;
import com.abc.test.q03.UserType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author tam.nguyen
 * Created on 30-May-2019
 */
public class EmployeeDiscountRuleSpec {

  @Test
  public void shouldApply30PercentDiscountOnEmployeeUser(){

    final EmployeeDiscountRule rule = new EmployeeDiscountRule();

    final Bill bill = new Bill(BigDecimal.valueOf(100), new User(UserType.EMPLOYEE), new Store());

    final BigDecimal amount = rule.apply(bill);

    Assertions.assertEquals(BigDecimal.valueOf(30.0), amount);
  }
}
