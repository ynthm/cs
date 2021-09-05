package com.ynthm.singleton;

/**
 * 懒汉模式
 *
 * @author Ynthm
 */
public class SingletonLazy {

  private static SingletonLazy instance;

  private SingletonLazy() {}

  public static SingletonLazy getInstance() {
    if (instance == null) {
      instance = new SingletonLazy();
    }
    return instance;
  }

  /**
   * 最简单的方法是将整个 getInstance() 方法设为同步（synchronized）。 虽然做到了线程安全，并且解决了多实例的问题，但是它并不高效。
   * 但是同步操作只需要在第一次调用时才被需要，即第一次创建单例实例对象时。这就引出了双重检验锁。
   *
   * @return
   */
  public static synchronized SingletonLazy getSafeInstance() {
    if (instance == null) {
      instance = new SingletonLazy();
    }
    return instance;
  }
}
