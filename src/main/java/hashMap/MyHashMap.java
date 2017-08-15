package hashMap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangruirui
 * @date: 2017/8/15
 * @description:
 */
public class MyHashMap<K, V> implements MyMap<K, V>{
    //定义默认数组的大小
    private static int defaulLenth = 1<<4;
    //扩容标准 所使用的 useSize/数组长度> 0.75
    // defaulAddSizeFactor 过大，造成扩容概率变低，存储小，但是存和取的效率降低
    //0.9 有限的数组长度空间位置会形成链表， 在存喝取 都需要大量的遍历和判断（逻辑）
    private static double defaulAddSizeFactor = 0.75;

    //使用数组的位置
    private int useSize;
    //定义map 骨架只要 数组之一 数组
    private Entry<K,V>[] table = null;
    //门面模式的运用
    public MyHashMap(){
        this(defaulLenth,defaulAddSizeFactor);
    }

    public MyHashMap(int length,double defaulAddSizeFactor){
        if(length>0){
            throw new IllegalArgumentException(("参数不能为负数")+length);
        }
        if(defaulAddSizeFactor<=0||Double.isNaN(defaulAddSizeFactor)){
            throw new IllegalArgumentException(("扩容标准必须大于0的数字")+defaulAddSizeFactor);
        }
        this.defaulLenth = length;
        this.defaulAddSizeFactor = defaulAddSizeFactor;
        table = new Entry[defaulLenth];
    }
    @Override
    public V put(K k, V v) {
        //判断是否需要扩容,  使用位置大于
        if(useSize>defaulLenth*defaulAddSizeFactor){
            up2Size();

        }
        int index = getIndex(k,table.length);
        Entry<K,V> entry = table[index];
        //使用位置没有被占用
        if(null == entry){
            table[index] = new Entry(k,v,null);
            //使用位置加1
            useSize++;
        }else if(null != entry){
            //构建链表
            table[index] = new Entry(k,v,entry);
        }
        return table[index].getValue();

    }

    private int getIndex(K k, int length) {
        int m = length-1;
        int index = hash(k.hashCode())&m;
        return index;
    }
    private int hash(int hashCode){
        hashCode = hashCode^((hashCode>>>20)^(hashCode>>>12));
        return hashCode^((hashCode>>>7)^(hashCode>>>4));
    }

    @Override
    public V get(K k, V v) {
        return null;
    }

    private void up2Size(){
        Entry<K,V>[] newTable = new Entry[2*defaulLenth];
        againHash(newTable);
    }

    private void againHash(Entry<K, V>[] newTable) {
        List<Entry<K,V>> entriyList = new ArrayList<MyHashMap<K,V>.Entry<K,V>>();
        //for 出来代表内容全部遍历到entriyList
        for (int i = 0; i < table.length; i++) {
            if(table[i]==null){
                continue;
            }
            //继续找存到数组的Entry对象
            foundEntryNext(table[i],entriyList);

        }
        //设置到entriyList
        if(entriyList.size()>0){
            useSize = 0;
            defaulLenth = 2*defaulLenth;
            for (Entry<K,V> entry:entriyList) {
                if(entry.next != null){
                    entry.next = null;
                }
                put(entry.getKey(),entry.getValue());

            }


        }
    }

    private void foundEntryNext(Entry<K, V> kvEntry, List<Entry<K, V>> entriyList) {
    }



    class Entry<K,V> implements MyMap.Entry<K,V> {
        K k;
        V v;
        Entry<K,V> next;
        public Entry( K k,V v,Entry<K,V> next){
            this.k = k;
            this.v = v;
            this.next = next;
        }
        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }
}
