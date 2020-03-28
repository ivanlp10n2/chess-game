package com.empanada.tdd.chess.components.impl;

import com.empanada.tdd.chess.shared.OperationResult;
import com.empanada.tdd.chess.shared.OperationStatus;

public class ExecutionResult {

  private ExecutionStatus status;
  private String message;

  public static ExecutionResult of(ExecutionStatus status) {
    return new ExecutionResult(status);
  }

  private ExecutionResult(ExecutionStatus status) {
    this.status = status;
  }

  public static ExecutionResult of(ExecutionStatus status, String message) {
    return new ExecutionResult(status, message);
  }

  private ExecutionResult(ExecutionStatus status, String message) {
    this.status = status;
    this.message = message;
  }

  private ExecutionResult() {
  }

  OperationResult toOperationResult() {
    return (status.isSuccessful())
        ? OperationResult.of(OperationStatus.OK, message)
        : OperationResult.of(OperationStatus.INVALID_MOVE, message);
  }

}
