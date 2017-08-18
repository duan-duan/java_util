package singleton;

/**
 * @author: wangruirui
 * @date: 2017/8/18
 * @description: 懒汉式  在第一次调用的时候实例化自己
 */
public class Singleton1 {
    //构造方法私有化 , 在反射面前，没卵用
    private Singleton1(){};
    //声明一个静态变量保存单例的引用
    private static Singleton1 singleton = null;
    //通过一个静态的方法获取单例的引用
    public static Singleton1 getInstance(){
        if(null==singleton){
            singleton = new Singleton1();
        }
        return singleton;
    }
}
