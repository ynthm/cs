package observer;

import org.junit.jupiter.api.Test;

class ObserverTest {
  @Test
  void test() {
    Observer observerA = new ConcreteObserver("A");
    Observer observerB = new ConcreteObserver("B");
    Subject sub = new ConcreteSubject();
    sub.register(observerA);
    sub.register(observerB);
    sub.setState(666);
    sub.cancel(observerB);
    sub.notifyObservers("just test subject notify function!");
  }
}
