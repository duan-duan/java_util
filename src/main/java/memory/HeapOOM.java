package memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangruirui
 * @date: 2017/8/11
 * @description:
 */
public class HeapOOM {
    /**
     * vm args: -verbose:gc -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     *
     * 堆内存溢出 demo
     */
    static class OOMObject{
    }
    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
