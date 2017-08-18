package singleton;

/**
 * @author: wangruirui
 * @date: 2017/8/18
 * @description: 懒汉式 保证线程安全
 */
public class Singleton3 {
    private Singleton3(){};
    private static Singleton3 singleton = null;
    //双重锁 保证多线程访问安全
    public static Singleton3 getInstance(){
        if(null==singleton){
            synchronized(Singleton3.class){
                if(null==singleton){
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}
