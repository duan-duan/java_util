package demo;

/**
 * @author: wangruirui .
 * @date: 2017/7/30.
 * @description: .
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
