package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;

public class NullPiece extends AbstractPiece {

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {
  }

}