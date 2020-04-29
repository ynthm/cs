package singleton;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.function.Supplier;

class SingletonStaticNestedClassTest {

  @Test
  void testEagerSingleton() throws InterruptedException {
    System.out.println("饿汉");
    getInstance(
        () -> {
          SingletonEager singleton = SingletonEager.getInstance();
          return "";
        });
  }

  @Test
  void testLazySingleton() throws InterruptedException {
    System.out.println("懒汉");
    getInstance(
        () -> {
          SingletonLazy singleton = SingletonLazy.getSafeInstance();
          return "";
        });
  }

  @Test
  void testDoubleCheckedLockingSingleton() throws InterruptedException {
    System.out.println("双重检测锁");
    getInstance(
        () -> {
          SingletonDoubleCheckedLocking singleton = SingletonDoubleCheckedLocking.getSingleton();
          return "";
        });
  }

  @Test
  void testStaticNestedClassSingleton() throws InterruptedException {
    System.out.println("静态内部类");
    getInstance(
        () -> {
          SingletonStaticNestedClass singleton = SingletonStaticNestedClass.getInstance();
          return "";
        });
  }

  @Test
  void testEnumSingleton() throws InterruptedException {
    System.out.println("枚举");
    getInstance(
        () -> {
          SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
          return "";
        });
  }

  private void getInstance(Supplier<String> supplier) throws InterruptedException {
    long start = System.currentTimeMillis();
    int threadNum = 100;
    final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
    for (int i = 0; i < threadNum; i++) {
      new Thread(
              () -> {
                for (int i1 = 0; i1 < 1000000; i1++) {
                  supplier.get();
                }
                countDownLatch.countDown();
              })
          .start();
    }

    countDownLatch.await(); // main线程阻塞，直到计数器变为0，才会继续往下执行！

    long end = System.currentTimeMillis();
    System.out.println("总耗时：" + (end - start));
  }
}
