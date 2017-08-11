package demo;

import java.util.Arrays;

/**
 * @author: wangruirui .
 * @date: 2017/7/31.
 * @description: . 排序算法
 */
public class Sort {
    public static void main(String[] args){
        int[] nums = {3,1,5,2,7,9,0};
        bubbleSort(nums);
        System.out.print(Arrays.toString(nums));

    }
    /**
     * 冒泡排序
     * 比较相邻的两个元素，大的向后挪移，从第一对开始到最后一对,最后一个值不用比较
     * 循环比较，知道最后一个
     *
     */
    public static void bubbleSort(int[] args){
        int temp = 0;
        for(int i = 0;i<args.length-1;i++){
            for(int j=0;j<args.length-i-1;j++){
                if(args[j]>args[j+1]){
                    temp = args[j];
                    args[j] = args[j+1];
                    args[j+1] = temp;
                }
            }
        }
    }

    /**
     * 快速排序算法
     *
     */
    public static void qucikSort(int[] args,int start,int end){

        int i,j,index;
        if(start>end){
            return;
        }

        i = start;
        j = end;
        index = args[i];
        while(i<j){
            while(i<j&&args[i]<index)
                i++;
            if(i<j){
                args[j--] = args[i];
            }
            while(i<j&&args[j]>=index)
                j--;
            if(i<j){
                args[i++] = args[j];
            }

        }
        args[i] = index;
        qucikSort(args,start,i-1);
        qucikSort(args,i+1,end);
    }




}
