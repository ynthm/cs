package factory.factorymethod;

import factory.simple.MiWatch;
import factory.simple.Watch;

/** @author Ynthm */
public class MiFactory implements AbstractFactory {
  @Override
  public Watch makeWatch() {
    return new MiWatch();
  }
}
