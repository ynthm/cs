package factory.abstractfactory;

/** @author Ynthm */
public class MiTv implements Tv {
  public MiTv() {
    this.make();
  }

  @Override
  public void make() {
    System.out.println("make Mi TV!");
  }
}
