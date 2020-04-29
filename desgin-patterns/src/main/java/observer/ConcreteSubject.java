package observer;

import java.util.ArrayList;
import java.util.List;

/** @author Ynthm */
public class ConcreteSubject implements Subject {
  private List<Observer> observerList = new ArrayList<>();
  private int state;

  @Override
  public void setState(int state) {
    this.state = state;
    notifyObservers("new state: " + state);
  }

  @Override
  public void register(Observer obs) {
    observerList.add(obs);
  }

  @Override
  public void cancel(Observer obs) {
    observerList.remove(obs);
  }

  @Override
  public void notifyObservers(String msg) {
    for (Observer observer : observerList) {
      observer.update(msg);
    }
  }
}
