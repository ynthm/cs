package com.ynthm.factory.factorymethod;

import com.ynthm.factory.simple.AppleWatch;
import com.ynthm.factory.simple.Watch;

/** @author Ynthm */
public class AppleFactory implements AbstractFactory {
  @Override
  public Watch makeWatch() {
    return new AppleWatch();
  }
}
