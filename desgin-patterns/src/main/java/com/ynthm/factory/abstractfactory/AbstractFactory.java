package com.ynthm.factory.abstractfactory;

import com.ynthm.factory.simple.Watch;

/** @author Ynthm */
public interface AbstractFactory {
  Watch makeWatch();

  Tv makeTv();
}
