package com.abc.test.q03;

import java.math.BigDecimal;

/**
 * @author tam.nguyen
 * Created on 30-May-2019
 */
public interface DiscountRule {

  BigDecimal apply(Bill bill);
}
