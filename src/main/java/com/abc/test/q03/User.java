package com.abc.test.q03;

import java.time.LocalDateTime;

/**
 * @author tam.nguyen
 * Created on 30-May-2019
 */
public class User {

  private final UserType type;
  private final LocalDateTime registeredDate;

  public User(UserType type, LocalDateTime registeredDate) {
    this.type = type;
    this.registeredDate = registeredDate;
  }

  public User(UserType type) {
    this(type, LocalDateTime.now());
  }

  public UserType getType() {
    return type;
  }

  public LocalDateTime getRegisteredDate() {
    return registeredDate;
  }

  public boolean isEmployee() {
    return UserType.EMPLOYEE.equals(type);
  }
}
