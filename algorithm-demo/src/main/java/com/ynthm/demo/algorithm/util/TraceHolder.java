package com.ynthm.demo.algorithm.util;

/** @author Ethan Wang */
public class TraceHolder {

  public static void run(StopWatch stopWatch, String taskName, Runnable runnable) {
    try {
      stopWatch.start(taskName);
      runnable.run();
    } finally {
      stopWatch.stop();
    }
  }
}
