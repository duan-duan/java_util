package lock;

/**
 * @author: wangruirui
 * @date: 2017/8/18
 * @description:
 */
public class LockDemo1 {

    A a = new A();

    static  A b = new A();

    //实例锁
    public synchronized void someMehtod(){

    }
    //类锁
    public static synchronized void someMethod2(){

    }
    //实例锁
    public void someMethod3(){
        //this 是一个实例锁
        synchronized(this){

        }
    }

    //实例锁
    public void someMethod4(){
        //是一个实例锁
        synchronized(a){

        }
    }

    public void someMethod5(){
        // 类锁
        synchronized(b){

        }
    }
}
class A {

}

