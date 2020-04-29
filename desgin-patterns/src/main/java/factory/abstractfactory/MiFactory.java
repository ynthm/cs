package factory.abstractfactory;

import factory.simple.MiWatch;
import factory.simple.Watch;

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
