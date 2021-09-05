package com.ynthm.demo.algorithm.util;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class StopWatchTest {

  @Test
  void test() throws Exception {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start("001");
    TimeUnit.SECONDS.sleep(1L);
    stopWatch.stop();
    System.out.println(stopWatch.toString());
    System.out.println(stopWatch.toString1());
    stopWatch.start("002");
    TimeUnit.SECONDS.sleep(1L);
    stopWatch.stop();
    System.out.println(stopWatch.toString());
    System.out.println(stopWatch.toString1());

    try (StopWatch ignored = stopWatch.start("003")) {
      TimeUnit.SECONDS.sleep(1L);
    }
    System.out.println(stopWatch.toString());
    System.out.println(stopWatch.toString1());

    TraceHolder.run(
        stopWatch,
        "004",
        () -> {
          try {
            TimeUnit.SECONDS.sleep(1L);
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          }
        });

    System.out.println(stopWatch.toString());
    System.out.println(stopWatch.toString1());
  }
}
