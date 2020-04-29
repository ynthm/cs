package singleton;

/**
 * 静态内部类
 * 使用JVM本身机制保证了线程安全问题；
 * 由于 SingletonHolder 是私有的，除了 getInstance() 之外没有办法访问它，因此它是懒汉式的；
 * 同时读取实例的时候不会进行同步，没有性能缺陷；
 * @author Ynthm
 */
public class SingletonStaticNestedClass {
    private SingletonStaticNestedClass(){}

    private static class SingletonHolder {
        private static final SingletonStaticNestedClass INSTANCE = new SingletonStaticNestedClass();
    }

    public static final SingletonStaticNestedClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
