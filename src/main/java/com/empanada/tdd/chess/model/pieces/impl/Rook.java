package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;
import com.empanada.tdd.chess.model.pieces.moves.Movement;
import com.empanada.tdd.chess.model.pieces.moves.impl.HorizontalMove;
import com.empanada.tdd.chess.model.pieces.moves.impl.VerticalMove;

public class Rook extends AbstractPiece {

  private static final String name = "Rook";

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {
    super.addValidMove(Movement.of(HorizontalMove.withAnySteps()));
    super.addValidMove(Movement.of(VerticalMove.withAnySteps()));
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return getName();
  }

}
