package me.wjx.set;

import java.util.*;

/**
 * @author wjx
 * @date 2018/6/5 10:46
 */
public class App {
    public static void main(String[] args) {
//        Set<String> set=new HashSet<>();
//        set.add("hello");
//        set.add(null);
//        System.out.println(set.size());
//        Set<Person> personSet=new HashSet<>();
//        Person person=new Person();
//        person.setName("wangjinxue");
//        personSet.add(person);
//        Person person1=new Person();
//        person1.setName("wangjinxue");
//        personSet.add(person1);
//        System.out.println(personSet.size());
        ArrayList<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.remove("2");
    }
}
