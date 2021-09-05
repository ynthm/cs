package com.ynthm.strategy.enums;

public class Calculator {
  public int calculate(int a, int b, Operator operator) {
    return operator.apply(a, b);
  }
}
