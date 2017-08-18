package singleton;


/**
 * @author: wangruirui
 * @date: 2017/8/18
 * @description: 饿汉式  静态内部类
 */
public class Singleton4 {
    //1 将构造方法私有化
    private Singleton4(){};
    //内部类的初始化，需要依赖主类
    // 当jvm 加载Singleton4类的时候  InnerClass 也同时被加载过来
    // 目前还没有被实例化，需要主类先实例化之后，内部类才被实例化
    private static class InnerClass{
        // final 防止内部将这个属性值覆盖掉
        private static final Singleton4 INSTANCE = new Singleton4();
    }
    //提供一个静态方法调用
    //加final防止子类重写父类方法
    public static final Singleton4 getInstance(){
        return InnerClass.INSTANCE;
    }
}
