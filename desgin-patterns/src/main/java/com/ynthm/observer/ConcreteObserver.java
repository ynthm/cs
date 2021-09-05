package com.ynthm.observer;

/** @author Ynthm */
public class ConcreteObserver implements Observer {
  private String name;

  public ConcreteObserver(String name) {
    this.name = name;
  }

  @Override
  public void update(String msg) {
    System.out.println("ConcreteObserver " + name + " receive notify msg: " + msg);
  }
}
