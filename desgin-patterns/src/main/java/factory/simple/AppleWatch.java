package factory.simple;

/** @author Ynthm */
public class AppleWatch implements Watch {
  public AppleWatch() {
    this.make();
  }

  @Override
  public void make() {
    System.out.println("make Apple Watch!");
  }
}
