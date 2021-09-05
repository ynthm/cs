package com.ynthm.factory.abstractfactory;

import com.ynthm.factory.simple.MiWatch;
import com.ynthm.factory.simple.Watch;

/** @author Ynthm */
public class MiFactory implements AbstractFactory {
  @Override
  public Watch makeWatch() {
    return new MiWatch();
  }

  @Override
  public Tv makeTv() {
    return new MiTv();
  }
}
