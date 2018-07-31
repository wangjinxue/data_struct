package me.wjx.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wjx
 * @date 2018/7/18 17:21
 */
public class Iterator {
    public static void main(String[] args) {
//        List<Integer> list1=new ArrayList<>(1000);
        List<Integer> list2=new LinkedList<>();
        for(int i=0;i<400000;i++){
//            list1.add(i);
            list2.add(i);
        }
        long time1=System.currentTimeMillis();
        remove(list2);
        System.out.println("耗时:"+(System.currentTimeMillis()-time1));
    }
    public static void remove(List<Integer> list){
        java.util.Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            if(iterator.next()%2==0){
                iterator.remove();
            }
        }
    }
}
