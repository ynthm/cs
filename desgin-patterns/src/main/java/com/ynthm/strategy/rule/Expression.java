package com.ynthm.strategy.rule;

import com.ynthm.strategy.enums.Operator;

public class Expression {
  private int x;
  private int y;
  private Operator operator;

  public Expression(int x, int y, Operator operator) {
    this.x = x;
    this.y = y;
    this.operator = operator;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Operator getOperator() {
    return operator;
  }

  public void setOperator(Operator operator) {
    this.operator = operator;
  }
}
