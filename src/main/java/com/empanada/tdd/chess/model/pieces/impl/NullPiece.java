package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;

public class NullPiece extends AbstractPiece {

  private final String name = "NullPiece";

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {
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
