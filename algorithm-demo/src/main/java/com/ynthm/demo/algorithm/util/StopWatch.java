package com.ynthm.demo.algorithm.util;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/** @author Ethan Wang */
public class StopWatch implements AutoCloseable {
  private final String id;
  private List<TaskInfo> taskList;
  private String currentTaskName;
  private long startTimeNanos;
  private StopWatch.TaskInfo lastTaskInfo;
  private int taskCount;
  private long totalTimeNanos;

  public static StopWatch create(String id) {
    return new StopWatch(id);
  }

  public StopWatch() {
    this("");
  }

  public StopWatch(String id) {
    this(id, true);
  }

  public StopWatch(String id, boolean keepTaskList) {
    this.id = id;
    if (keepTaskList) {
      this.taskList = new ArrayList<>();
    }
  }

  public String getId() {
    return this.id;
  }

  public void setKeepTaskList(boolean keepTaskList) {
    if (keepTaskList) {
      if (null == this.taskList) {
        this.taskList = new ArrayList();
      }
    } else {
      this.taskList = null;
    }
  }

  public void start() throws IllegalStateException {
    this.start("");
  }

  public StopWatch start(String taskName) throws IllegalStateException {
    if (null != this.currentTaskName) {
      throw new IllegalStateException("Can't start StopWatch: it's already running");
    } else {
      this.currentTaskName = taskName;
      this.startTimeNanos = System.nanoTime();
    }

    return this;
  }

  public void stop() throws IllegalStateException {
    if (null == this.currentTaskName) {
      throw new IllegalStateException("Can't stop StopWatch: it's not running");
    } else {
      long lastTime = System.nanoTime() - this.startTimeNanos;
      this.totalTimeNanos += lastTime;
      this.lastTaskInfo = new StopWatch.TaskInfo(this.currentTaskName, lastTime);
      if (null != this.taskList) {
        this.taskList.add(this.lastTaskInfo);
      }

      ++this.taskCount;
      this.currentTaskName = null;
    }
  }

  public void reset() {
    this.taskCount = 0;
    this.currentTaskName = null;
    this.startTimeNanos = 0L;
    this.totalTimeNanos = 0L;
  }

  public boolean isRunning() {
    return this.currentTaskName != null;
  }

  public String currentTaskName() {
    return this.currentTaskName;
  }

  public long getLastTaskTimeNanos() throws IllegalStateException {
    if (this.lastTaskInfo == null) {
      throw new IllegalStateException("No tasks run: can't get last task interval");
    } else {
      return this.lastTaskInfo.getTimeNanos();
    }
  }

  public long getLastTaskTimeMillis() throws IllegalStateException {
    if (this.lastTaskInfo == null) {
      throw new IllegalStateException("No tasks run: can't get last task interval");
    } else {
      return this.lastTaskInfo.getTimeMillis();
    }
  }

  public String getLastTaskName() throws IllegalStateException {
    if (this.lastTaskInfo == null) {
      throw new IllegalStateException("No tasks run: can't get last task name");
    } else {
      return this.lastTaskInfo.getTaskName();
    }
  }

  public StopWatch.TaskInfo getLastTaskInfo() throws IllegalStateException {
    if (this.lastTaskInfo == null) {
      throw new IllegalStateException("No tasks run: can't get last task info");
    } else {
      return this.lastTaskInfo;
    }
  }

  public long getTotalTimeNanos() {
    return this.totalTimeNanos;
  }

  public int getTaskCount() {
    return this.taskCount;
  }

  public StopWatch.TaskInfo[] getTaskInfo() {
    if (null == this.taskList) {
      throw new UnsupportedOperationException("Task info is not being kept!");
    } else {
      return this.taskList.toArray(new TaskInfo[0]);
    }
  }

  public String shortSummary() {
    return String.format("StopWatch '%s': running time = %d ns", this.id, this.totalTimeNanos);
  }

  public String prettyPrint() {
    StringBuilder sb = new StringBuilder(this.shortSummary());
    sb.append(System.lineSeparator());
    if (null == this.taskList) {
      sb.append("No task info kept");
    } else {
      sb.append("---------------------------------------------").append(System.lineSeparator());
      sb.append("ns         %     Task name").append(System.lineSeparator());
      sb.append("---------------------------------------------").append(System.lineSeparator());
      NumberFormat nf = NumberFormat.getNumberInstance();
      nf.setMinimumIntegerDigits(9);
      nf.setGroupingUsed(false);
      NumberFormat pf = NumberFormat.getPercentInstance();
      pf.setMinimumIntegerDigits(3);
      pf.setGroupingUsed(false);
      StopWatch.TaskInfo[] var4 = this.getTaskInfo();
      int var5 = var4.length;

      for (int var6 = 0; var6 < var5; ++var6) {
        StopWatch.TaskInfo task = var4[var6];
        sb.append(nf.format(task.getTimeNanos())).append("  ");
        sb.append(pf.format((double) task.getTimeNanos() / (double) this.getTotalTimeNanos()))
            .append("  ");
        sb.append(task.getTaskName()).append(System.lineSeparator());
      }
    }

    return sb.toString();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(this.shortSummary());
    if (null != this.taskList) {
      Iterator<TaskInfo> var2 = this.taskList.iterator();

      while (var2.hasNext()) {
        StopWatch.TaskInfo task = var2.next();
        sb.append("; [")
            .append(task.getTaskName())
            .append("] took ")
            .append(task.getTimeNanos())
            .append(" ns");
        long percent =
            Math.round(100.0D * (double) task.getTimeNanos() / (double) this.getTotalTimeNanos());
        sb.append(" = ").append(percent).append("%");
      }
    } else {
      sb.append("; no task info kept");
    }

    return sb.toString();
  }

  @Override
  public void close() throws Exception {
    this.stop();
  }

  public static final class TaskInfo {
    private final String taskName;
    private final long timeNanos;

    TaskInfo(String taskName, long timeNanos) {
      this.taskName = taskName;
      this.timeNanos = timeNanos;
    }

    public String getTaskName() {
      return this.taskName;
    }

    public long getTimeNanos() {
      return this.timeNanos;
    }

    public long getTimeMillis() {
      return TimeUnit.NANOSECONDS.toMillis(this.timeNanos);
    }
  }

  public String toString1() {
    long nanos = this.getLastTaskTimeNanos();
    TimeUnit unit = chooseUnit(nanos);
    double value = (double) nanos / (double) TimeUnit.NANOSECONDS.convert(1L, unit);
    return String.format(Locale.ROOT, "%.4g", value) + " " + abbreviate(unit);
  }

  private static TimeUnit chooseUnit(long nanos) {
    if (TimeUnit.DAYS.convert(nanos, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.DAYS;
    } else if (TimeUnit.HOURS.convert(nanos, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.HOURS;
    } else if (TimeUnit.MINUTES.convert(nanos, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.MINUTES;
    } else if (TimeUnit.SECONDS.convert(nanos, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.SECONDS;
    } else if (TimeUnit.MILLISECONDS.convert(nanos, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.MILLISECONDS;
    } else {
      return TimeUnit.MICROSECONDS.convert(nanos, TimeUnit.NANOSECONDS) > 0L
          ? TimeUnit.MICROSECONDS
          : TimeUnit.NANOSECONDS;
    }
  }

  private static String abbreviate(TimeUnit unit) {
    switch (unit) {
      case NANOSECONDS:
        return "ns";
      case MICROSECONDS:
        return "μs";
      case MILLISECONDS:
        return "ms";
      case SECONDS:
        return "s";
      case MINUTES:
        return "min";
      case HOURS:
        return "h";
      case DAYS:
        return "d";
      default:
        throw new AssertionError();
    }
  }
}
