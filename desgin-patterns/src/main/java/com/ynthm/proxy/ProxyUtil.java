package com.ynthm.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Proxy;

/**
 * @author Ynthm
 * @version 1.0
 */
public class ProxyUtil {
  private ProxyUtil() {}

  /**
   * 动态代理:程序运行时,生成一个代理类对象,代替原有的类做事情. 方法上的增强. 代理:替别人做事情. 动态:运行时.
   *
   * <p>继承 : 子类重写父类方法 可以增强 . 包装 : BufferedXxx增强 普通FileXX流. read writ 动态代理:方法上的增强.
   *
   * <p>通过 Proxy 类 生成的代理类对象.
   *
   * <p>Proxy.newProxyInstance(loader, interfaces, h) ClassLoader loader : 类加载器 . 当前类的加载器,传递进去即可.
   * Class[] interfaces : 被代理类(歌手)的所有接口. 这些接口是给生成代理类(经纪人)时使用的. InvocationHandler h : 处理类.
   * 指定代理类如何执行方法. 每次调用代理对象的方法,都会执行invoke public Object invoke(Object proxy, Method method, Object[]
   * args){} proxy : 代理对象. method : 正在调用的方法 args[] : 正在调用的方法的实际参数
   *
   * <p>Object :返回值类型 .. Object o = proxy.method(args);
   */
  public Object getProxyByJdk(Object object) {

    return Proxy.newProxyInstance(
        object.getClass().getClassLoader(),
        object.getClass().getInterfaces(),
        (proxy, method, args) -> {
          System.out.println("调用前...");
          Object invoke = method.invoke(object, args);
          System.out.println("调用后...");
          return invoke;
        });
  }

  /**
   * Code Generation Library
   *
   * @param object
   * @return
   */
  public Object getProxyByCglib(Object object) {
    // 创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
    Enhancer enhancer = new Enhancer();
    // 设置目标类的字节码文件
    enhancer.setSuperclass(object.getClass());
    // 设置回调函数
    enhancer.setCallback(
        (MethodInterceptor)
            (o, method, objects, methodProxy) -> {
              System.out.println("调用前...");
              // 执行目标对象的方法
              Object returnValue = method.invoke(object, objects);
              System.out.println("调用后...");
              return returnValue;
            });

    // 这里的creat方法就是正式创建代理类
    return enhancer.create();
  }
}
