package me.wjx.atomic;

import com.sun.deploy.util.ReflectionUtil;
import me.wjx.block_queue.Message;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.concurrent.atomic.*;

/**
 * @author wjx
 * @date 2018/7/3 14:41
 */
public class AtomicIntegerApp {
    private static AtomicIntegerFieldUpdater<User> atomicIntegerFieldUpdater=AtomicIntegerFieldUpdater.newUpdater(User.class,"age");
    private static AtomicReferenceFieldUpdater<User,String>   atomicReferenceFieldUpdater=AtomicReferenceFieldUpdater.newUpdater(User.class,String.class,"name");
    public static void main(String[] args) {
//        AtomicInteger atomicInteger=new AtomicInteger(1);
//        System.out.println( atomicInteger.getAndUpdate(operand -> -2));
//        System.out.println(atomicInteger.getAndAdd(5));
//        System.out.println(atomicInteger.get());
//        AtomicBoolean atomicBoolean=new AtomicBoolean(false);
//        atomicBoolean.getAndSet(true);
//        System.out.println(atomicBoolean.get());
//        AtomicLong atomicLong = new AtomicLong(100L);
//        atomicLong.accumulateAndGet(2L, (left, right) -> {
//            System.out.println(left);
//            System.out.println(right);
//            return left;
//        });
//        atomicLong.getAndDecrement();
//        System.out.println(atomicLong.get());
//        int[] intArray = new int[]{1, 2, 3, 4, 5};
//        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(intArray);
//        atomicIntegerArray.getAndUpdate(0, operand -> 2);
//        atomicIntegerArray.getAndSet(0, 2);
//        System.out.println(Arrays.toString(intArray));
//        System.out.println(atomicIntegerArray.get(0));
//        try {
//            Field array = atomicIntegerArray.getClass().getDeclaredField("array");
//            array.setAccessible(true);
//            System.out.println(Arrays.toString((int[])(array.get(atomicIntegerArray))));
//            System.out.println(intArray);
//
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
        //原子数组类型
//        Message[] messages=new Message[5];
//        for(int i=0;i<5;i++){
//            Message message=new Message();
//            message.setMessage("message"+i);
//            messages[i]=message;
//        }
//        AtomicReferenceArray<Message> messageAtomicReferenceArray=new AtomicReferenceArray<Message>(messages);
//        messages[0].setMessage("new message");
//        messageAtomicReferenceArray.set(0,messages[0]);
//        System.out.println(messageAtomicReferenceArray.get(0));
//        Message message=new Message();
//        message.setMessage("hello world");
//        AtomicReference<Message> atomicReference=new AtomicReference<>(message);
//        Message newMessage=new Message();
//        newMessage.setMessage("new hello world");
//        atomicReference.set(newMessage);
//        System.out.println(atomicReference.get());
       User user=new User("wangjinxue",24);

//        System.out.println(atomicIntegerFieldUpdater.getAndIncrement(user));
//        System.out.println(atomicIntegerFieldUpdater.get(user));
//        System.out.println();
        System.out.println(atomicReferenceFieldUpdater.getAndSet(user,"wangjinyi"));
        System.out.println(atomicReferenceFieldUpdater.get(user));
    }

    private static class User{
        public volatile String name;
        public volatile int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }
    }
}
