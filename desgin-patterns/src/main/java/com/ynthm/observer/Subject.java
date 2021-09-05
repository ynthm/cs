package com.ynthm.observer;

/** @author Ynthm */
public interface Subject {
  void setState(int state);

  void register(Observer obs);

  void cancel(Observer obs);

  void notifyObservers(String msg);
}
