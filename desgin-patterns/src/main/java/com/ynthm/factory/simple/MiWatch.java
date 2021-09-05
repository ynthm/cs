package com.ynthm.factory.simple;

/** @author Ynthm */
public class MiWatch implements Watch {
  public MiWatch() {
    this.make();
  }

  @Override
  public void make() {
    System.out.println("make Mi Watch!");
  }
}
