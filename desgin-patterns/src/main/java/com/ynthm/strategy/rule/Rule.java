package com.ynthm.strategy.rule;

public interface Rule {
  boolean evaluate(Expression expression);

  int getResult();
}
