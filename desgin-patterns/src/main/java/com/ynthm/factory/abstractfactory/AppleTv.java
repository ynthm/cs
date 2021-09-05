package com.ynthm.factory.abstractfactory;

/** @author Ynthm */
public class AppleTv implements Tv {
  public AppleTv() {
    this.make();
  }

  @Override
  public void make() {
    System.out.println("make Apple TV!");
  }
}
