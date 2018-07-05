package me.wjx;

import me.wjx.linkedlist.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App
{
    public static void main(String[] args) {
//        PriorityQueue<String> priorityQueue=new PriorityQueue<>(10);
        System.out.println('1'+1);
        String name=new String("wangjinxue");
        String intern = name.intern();
        String name1="wangjinxue";
        System.out.println(name==name1);
        System.out.println(name==intern);
    }
}
