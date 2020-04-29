package factory.abstractfactory;

import org.junit.jupiter.api.Test;

class AbstractFactoryTest {

  @Test
  void make() {
    AbstractFactory miFactory = new MiFactory();
    AbstractFactory appleFactory = new AppleFactory();
    miFactory.makeWatch();
    miFactory.makeTv();
    appleFactory.makeWatch();
    appleFactory.makeTv();
  }
}
