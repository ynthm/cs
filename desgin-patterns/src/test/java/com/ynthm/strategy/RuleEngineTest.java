package com.ynthm.strategy;

import com.ynthm.strategy.enums.Operator;
import com.ynthm.strategy.rule.Expression;
import com.ynthm.strategy.rule.RuleEngine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RuleEngineTest {
  @Test
  void whenNumbersGivenToRuleEngine() {
    Expression expression = new Expression(5, 5, Operator.ADD);
    RuleEngine ruleEngine = new RuleEngine();
    int result = ruleEngine.process(expression);
    assertEquals(10, result);
  }
}
