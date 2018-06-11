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

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.name = "hello" + i;
            list.add("hello"+i);
        }
       list.forEach(System1::println);
    }




}
