package singleton;

/**
 * @author: wangruirui .
 * @date: 2017/7/30.
 * @description: . 内部类
 */
public class Singleton {

    private static class Holder{
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton(){}
    public static final Singleton getInstance(){
        return Holder.INSTANCE;
    }

}
