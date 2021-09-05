package com.ynthm.factory.simple;

import org.junit.jupiter.api.Test;

class SimpleFactoryTest {

  @Test
  void makePhone() {
    WatchFactory factory = new WatchFactory();
    Watch miWatch = factory.makePhone(WatchFactory.WatchType.XIAOMI);
    AppleWatch appleWatch = (AppleWatch) factory.makePhone(WatchFactory.WatchType.APPLE);
  }
}
