package com.ynthm.factory.abstractfactory;

import com.ynthm.factory.simple.AppleWatch;
import com.ynthm.factory.simple.Watch;

/** @author Ynthm */
public class AppleFactory implements AbstractFactory {
  @Override
  public Watch makeWatch() {
    return new AppleWatch();
  }

  @Override
  public Tv makeTv() {
    return new AppleTv();
  }
}
