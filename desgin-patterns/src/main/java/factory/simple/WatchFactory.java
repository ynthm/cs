package factory.simple;

/** @author Ynthm */
public class WatchFactory {
  public enum WatchType {
    XIAOMI,
    APPLE
  }

  public Watch makePhone(WatchType type) {
    if (WatchType.APPLE.equals(type)) {
      return new AppleWatch();
    } else if (WatchType.XIAOMI.equals(type)) {
      return new MiWatch();
    }
    return null;
  }
}
