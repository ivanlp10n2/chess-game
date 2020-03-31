package com.empanada.tdd.chess.components.games.impl;

import com.empanada.tdd.chess.components.games.Game;
import com.empanada.tdd.chess.components.games.GameStatus;
import com.empanada.tdd.chess.components.rules.AbstractRule;
import com.empanada.tdd.chess.components.rules.RuleStatus;
import com.empanada.tdd.chess.components.rules.impl.ChessRuleCheck;
import com.empanada.tdd.chess.components.rules.impl.ChessRuleCheckmate;
import com.empanada.tdd.chess.components.rules.impl.ChessRulePieceMovement;
import com.empanada.tdd.chess.components.rules.impl.ChessRuleStalemate;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.model.table.Table;
import com.empanada.tdd.chess.shared.ExecutionResult;
import com.empanada.tdd.chess.shared.ExecutionStatus;

public class ChessGame implements Game {

  GameStatus state;
  AbstractRule ruleChain;
  Table table;

  public static ChessGame of(Table table) {
    return new ChessGame(table);
  }

  private ChessGame(Table table) {
    this.table = table;
    this.state = GameStatus.NOT_STARTED;
  }

  private ChessGame() {
  }

  @Override
  public Game initialize() {
    try {
      setupTable();
      setupRules();
      state = GameStatus.STARTED;
    } catch (final Exception e) {
      state = GameStatus.NOT_STARTED;
    }

    return this;
  }

  private void setupTable() {
    table.init();
  }

  private void setupRules() {
    ruleChain = new ChessRuleCheckmate()
        .addRule(new ChessRuleStalemate())
        .addRule(new ChessRuleCheck())
        .addRule(new ChessRulePieceMovement());

  }

  @Override
  public ExecutionResult execute(Command command) {
    if (this.hasNotStarted())
      return ExecutionResult.of(ExecutionStatus.GAME_NOT_STARTED);

    final RuleStatus status = ruleChain.applyRule(command, table);
    if (status.isInvalid())
      return ExecutionResult.of(ExecutionStatus.NOT_OK, status.getMessage());

    return table.move(command);

  }

  @Override
  public boolean hasNotStarted() {
    return !hasStarted();
  }

  @Override
  public boolean hasStarted() {
    return state == GameStatus.STARTED;
  }

}
