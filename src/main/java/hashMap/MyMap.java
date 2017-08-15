package hashMap;

/**
 * @author: wangruirui
 * @date: 2017/8/15
 * @description:
 */
public interface MyMap<K,V> {
    //快速存取 基本功能
    public V put(K k,V v);
    public V get(K k,V v);
    //定义一个内部的接口
    public interface Entry<K,V>{
        public K getKey();
        public V getValue();
    }
}
