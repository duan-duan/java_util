package singleton;

/**
 * @author: wangruirui
 * @date: 2017/8/18
 * @description: 饿汉式 线程是安全的，只是如果没有使用的话，会浪费一定的内存空间
 */
public class Singleton5 {
    private Singleton5(){};
    // 声明静态变量，在类初始化之前初始化变量，将对象引用保存
    private static final Singleton5 singleton = new Singleton5();
    //开发静态方法获取实例
    public static Singleton5 getInstance(){
        return singleton;
    }
}
