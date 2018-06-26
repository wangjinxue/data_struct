package me.wjx.sort;

import java.util.Arrays;

/**

 * @author wjx
 * @date 2018/6/14 10:59
 */
public class Sort {
    /**
     * 直接插入排序{20,10,8}
     * @param sorted
     */
    public static void directInsertSort(int[] sorted){
        for(int i=1;i<sorted.length;i++){
            //第一次10、20、8
            //第二次 10 20，20  20，10,20  20,10,8
            int temp=sorted[i];//10,8
            int j;
            //第一次循环 29
            //第二次循环 20,10
            for(j=i-1;j>=0;j--){
                //第一次 20
                //第二次 10
                if(sorted[j]>temp){
                    sorted[j+1]=sorted[j];
                }else{
                    break;
                }
            }
            sorted[j+1]=temp;
        }
    }

    /**
     * {20,10,8}
     * 二分插入排序，在直接插入的基础上，每次和mid比较
     * @param sorted
     */
    public static void binaryInsertSort(int[] sorted){
        //排序过程分析
        //
        for(int i=0;i<sorted.length;i++){
            //临时变量
            int temp=sorted[i];
            //记录数据范围左
            int left=0;
            //记录数据范围右
            int right=i-1;
            //记录数据范围的中坐标
            int mid;
            while(left<=right){
                //取中
                mid=(left+right)/2;
                //判断插入的数据是否小于中间值，小于就取前半段数据,否则就取后半段数据
                if(temp<sorted[mid]){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
            System.arraycopy(sorted, left, sorted, left + 1, i - left);
            if(left!=i){
                sorted[left]=temp;
            }
        }
    }

    public static void simpleSelectorSort(int[] array){
        int position=0;
//        for(int i=0;i<array.length)
    }

    public static void main(String[] args) {
        int[] sorted=new int[]{10,20,30,40,50};
//        directInsertSort(sorted);
        binaryInsertSort(sorted);
        System.out.println(Arrays.toString(sorted));
    }
}
