package singleton;

/**
 * @author: wangruirui
 * @date: 2017/8/18
 * @description: 懒汉式 保证线程安全
 */
public class Singleton2 {
    //声明一个私有的构造方法
    private Singleton2(){}
    //声明一个静态变量保存单例的引用
    private static Singleton2 singleton = null;
    //提供一个静态的构造方法获取单例的引用
    //加入synchronizde关键字确保多线程下正确访问
    public static synchronized Singleton2 getInstance(){
        if(null==singleton){
            singleton = new Singleton2();
        }
        return singleton;
    }
}
