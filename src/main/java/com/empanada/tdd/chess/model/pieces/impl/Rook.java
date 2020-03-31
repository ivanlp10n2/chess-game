package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;
import com.empanada.tdd.chess.model.pieces.moves.AbstractMove;
import com.empanada.tdd.chess.model.pieces.moves.MovementBuilder;
import com.empanada.tdd.chess.model.pieces.moves.impl.HorizontalMove;
import com.empanada.tdd.chess.model.pieces.moves.impl.VerticalMove;

public class Rook extends AbstractPiece {

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {
    MovementBuilder builder = new MovementBuilder();
    builder = builder.use(new HorizontalMove(-1));
    builder = builder.and();
    builder = builder.use(new VerticalMove(0));
    final AbstractMove rookMove = builder.create();

    super.addValidMove(rookMove);
  }

}
