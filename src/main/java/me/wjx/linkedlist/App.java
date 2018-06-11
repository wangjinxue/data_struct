package me.wjx.linkedlist;

import me.wjx.System1;

import java.util.LinkedList;

/**
 * @author wjx
 * @date 2018/6/4 16:49
 */
public class App {
    public static void main(String[] args) {
//        LinkedList<String> list1 = new LinkedList<>();
//        for (int i = 0; i < 10; i++) {
//            list1.addFirst("hello" + i);
//        }

//        long time1=System.currentTimeMillis();
//        SingleLinkedList<String> list=new SingleLinkedList<>();
//        for(int i=0;i<5;i++){
//            list.addHead("hello"+i);
//        }
//        System.out.println(list.size());
//        list.deleteHead();
//        list.deleteHead();
//        list.deleteHead();
//        list.deleteHead();
//        list.find("hello999990");
//        System.out.println("time consuming "+(System.currentTimeMillis()-time1)+"ms");
//
//        for(String s:list){
//            System.out.println(s);
//        }
//        list.forEach(System.out::println);
//        list.display();

//        StackSingleLink<String> list=new StackSingleLink<>();
//        for(int i=0;i<5;i++){
//            list.push("hello"+i);
//        }
        OrderLinkedList list=new OrderLinkedList();
        list.insert(15);
        list.insert(134);
        list.insert(21);
        list.insert(111);
        list.insert(12);
        list.forEach(System1::println);
    }
}
