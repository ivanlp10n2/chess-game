package com.empanada.tdd.chess.components.rules;

import com.empanada.tdd.chess.model.table.Coordinate;
import com.empanada.tdd.chess.model.table.Table;

/**
 * it validates the play. It does not contain information about pieces location
 * and state of the game
 */
public abstract class AbstractRule implements Rule {

  private AbstractRule nextRule;

  public AbstractRule addRule(AbstractRule nextRule) {
    AbstractRule lastRule = this;

    while (lastRule.nextRule != null) {
      lastRule = lastRule.nextRule;
    }

    lastRule.nextRule = nextRule;

    return this;
  }

  protected RuleStatus applyNextRule(Coordinate origin, Coordinate destination, Table table) {
    if (nextRule == null)
      return RuleStatus.valid();

    return nextRule.apply(origin, destination, table);
  }

}
