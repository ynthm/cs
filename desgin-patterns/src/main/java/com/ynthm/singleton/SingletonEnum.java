package com.ynthm.singleton;

/**
 * 使用枚举除了线程安全和防止反射强行调用构造器之外，还提供了自动序列化机制，防止反序列化的时候创建新的对象。
 * 通过EasySingleton.INSTANCE来访问实例。创建枚举默认就是线程安全的，所以不需要担心double checked locking， 而且还能防止反序列化导致重新创建新的对象。
 *
 * @author Ynthm
 */
public enum SingletonEnum {
  INSTANCE;
}
