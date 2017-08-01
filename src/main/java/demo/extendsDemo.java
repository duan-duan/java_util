package demo;

/**
 * @author: wangruirui
 * @date: 2017/7/31
 * @description:  类的初始化    static final 方法不能被子类 重写 覆盖
 */
public class extendsDemo {
    public static void main(String[] args){
         new B();
//        a.f1();
//        a.f2();
    }
}
 class A {
    static{
        System.out.println("a ++++");
    }
    public  static void f1(){
        System.out.println("a");
    }
     public void f2 (){
         System.out.println("a1");
     }
}
class B extends A {
    static{
        System.out.println("b ++++");
    }
    public static  void f1(){
        System.out.println("b");
    }
    public  void f2(){
        System.out.println("b1");
    }
}
