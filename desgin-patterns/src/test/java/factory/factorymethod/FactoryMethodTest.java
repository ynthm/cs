package factory.factorymethod;

import org.junit.jupiter.api.Test;

class FactoryMethodTest {

  @Test
  void makeWatch() {
    AbstractFactory miFactory = new MiFactory();
    AbstractFactory appleFactory = new AppleFactory();
    miFactory.makeWatch();
    appleFactory.makeWatch();
  }
}
