package singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: wangruirui
 * @date: 2017/8/18
 * @description: 登记注册式
 */
public class Singleton7 {
    private static Map<String,Singleton7>  map = new ConcurrentHashMap<String, Singleton7>();
    static{
        Singleton7 singleton = new Singleton7();
        map.put(singleton.getClass().getName(),singleton);
    }
    //保护的默认构造方法
    protected Singleton7(){};
    //静态工厂方法，返回唯一实例
    public static Singleton7 getInstance(String name){
        if(null==name){
            name = Singleton7.class.getName();
        }
        if(null==map.get(name)){
            try {
                map.put(name,(Singleton7) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return map.get(name);
    }
}
