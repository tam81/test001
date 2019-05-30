package com.abc.test.q03;

/**
 * @author tam.nguyen
 * Created on 30-May-2019
 */
public class Store {

  private final boolean isAffiliate;
  private final boolean isGrocery;

  public Store(boolean isAffiliate, boolean isGrocery) {
    this.isAffiliate = isAffiliate;
    this.isGrocery = isGrocery;
  }

  public Store() {
    this(true, true);
  }

  public boolean isAffiliate() {
    return isAffiliate;
  }

  public boolean isGrocery() {
    return isGrocery;
  }
}
