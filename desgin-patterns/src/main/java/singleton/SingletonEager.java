package singleton;

/**
 * 恶汉模式
 *  单例的实例被声明成 static 和 final 变量了，在第一次加载类到内存中时就会初始化，所以创建实例本身是线程安全的。
 * 缺点是它不是一种懒加载模式（lazy initialization）。
 * @author Ynthm
 */
public class SingletonEager {
    /**
     * 类加载时就初始化
     */
    private static final SingletonEager INSTANCE = new SingletonEager();
    private SingletonEager(){}
    public static SingletonEager getInstance(){
        return INSTANCE;
    }
}
