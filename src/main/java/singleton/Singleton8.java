package singleton;

/**
 * @author: wangruirui
 * @date: 2017/8/18
 * @description:
 */
public class Singleton8 {
    String name = null;
    //注意这里用到了volatile
    private static volatile Singleton8  singleton = null;
    //双重锁
    public static Singleton8 getInstance(){
        if(null==singleton){
            synchronized(Singleton8.class){
                if(null==singleton){
                    singleton = new Singleton8();
                }
            }
        }
        return singleton;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void printInfo(){
        System.out.println("the name is "+ name);
    }
}
