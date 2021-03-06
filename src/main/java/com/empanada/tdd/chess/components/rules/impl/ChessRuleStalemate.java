package com.empanada.tdd.chess.components.rules.impl;

import com.empanada.tdd.chess.components.rules.AbstractRule;
import com.empanada.tdd.chess.components.rules.RuleStatus;
import com.empanada.tdd.chess.model.table.Coordinate;
import com.empanada.tdd.chess.model.table.Table;

public class ChessRuleStalemate extends AbstractRule {

  @Override
  public RuleStatus apply(Coordinate origin, Coordinate destination, Table table) {
    return (invalidMove())
        ? RuleStatus.invalid("checkmage.")
        : applyNextRule(origin, destination, table);
  }

  private boolean invalidMove() {
    return !validMove();
  }

  private boolean validMove() {
    return true;
  }
}
