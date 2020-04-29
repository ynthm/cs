package singleton;

/**
 * 双重校验锁
 * @author Ynthm
 */
public class SingletonDoubleCheckedLocking {
    /**
     *  声明成 volatile, 保证多线程可见性
     */
    private volatile static SingletonDoubleCheckedLocking instance;
    private SingletonDoubleCheckedLocking (){}

    public static SingletonDoubleCheckedLocking getSingleton() {
        //Single Checked
        if (instance == null) {
            synchronized (SingletonDoubleCheckedLocking.class) {
                //Double Checked
                if (instance == null) {
                    instance = new SingletonDoubleCheckedLocking();
                }
            }
        }
        return instance;
    }
}
