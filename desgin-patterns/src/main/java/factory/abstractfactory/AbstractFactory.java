package factory.abstractfactory;

import factory.simple.Watch;

/** @author Ynthm */
public interface AbstractFactory {
  Watch makeWatch();

  Tv makeTv();
}
