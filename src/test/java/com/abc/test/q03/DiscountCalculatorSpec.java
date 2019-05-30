package com.abc.test.q03;

import com.abc.test.q03.internal.*;
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
public class DiscountCalculatorSpec {

  private DiscountCalculator discountCalculator;

  private List<DiscountRule> percentageDiscountRules = new ArrayList<DiscountRule>() {{
    add(new EmployeeDiscountRule());
    add(new AffiliateStoreDiscountRule());
    add(new CustomerDiscountRule());
  }};

  private List<DiscountRule> discountRules = new ArrayList<DiscountRule>() {{
    add(new PercentageDiscountRule(percentageDiscountRules));
    add(new TotalPriceDiscountRule());
  }};

  @BeforeEach
  public void init() {
    discountCalculator = new DiscountCalculator(discountRules);
  }

  @Test
  public void shouldOnyApplyEmployeeDiscountRule() {

    final Bill bill = new Bill(BigDecimal.valueOf(200), new User(UserType.EMPLOYEE), new Store(true, false));

    final BigDecimal discountAmount = discountCalculator.calculate(bill);

    // $60 (30% discount for employee) + $10 ( $5 on each $100)
    Assertions.assertEquals(BigDecimal.valueOf(70.0), discountAmount);
  }
}
