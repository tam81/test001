package com.abc.test.q03.internal;

import com.abc.test.q03.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tam.nguyen
 * Created on 30-May-2019
 */
public class PercentageDiscountRuleSpec {

  private List<DiscountRule> percentageDiscountRules = new ArrayList<DiscountRule>() {{
    add(new EmployeeDiscountRule());
    add(new AffiliateStoreDiscountRule());
    add(new CustomerDiscountRule());
  }};

  private DiscountRule percentageDiscountRule;

  @BeforeEach
  public void init() {
    percentageDiscountRule = new PercentageDiscountRule(percentageDiscountRules);
  }

  @Test
  public void shouldApplyOnlyOnePercentageDiscountRulePerBill() {

    final Bill bill = new Bill(BigDecimal.valueOf(200), new User(UserType.EMPLOYEE), new Store(true, false));

    final BigDecimal discountAmount = percentageDiscountRule.apply(bill);

    Assertions.assertEquals(BigDecimal.valueOf(60.0), discountAmount);
  }

  @Test
  public void shouldNotApplyDiscountRuleIfStoreIsGrocery() {
    final Bill bill = new Bill(BigDecimal.valueOf(200), new User(UserType.EMPLOYEE), new Store(true, true));

    final BigDecimal discountAmount = percentageDiscountRule.apply(bill);

    Assertions.assertEquals(BigDecimal.ZERO, discountAmount);
  }
}
