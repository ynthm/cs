package factory.factorymethod;

import factory.simple.AppleWatch;
import factory.simple.Watch;

/** @author Ynthm */
public class AppleFactory implements AbstractFactory {
  @Override
  public Watch makeWatch() {
    return new AppleWatch();
  }
}
