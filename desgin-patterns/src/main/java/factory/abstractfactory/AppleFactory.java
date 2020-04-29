package factory.abstractfactory;

import factory.simple.AppleWatch;
import factory.simple.Watch;

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
