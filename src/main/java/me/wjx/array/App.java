package me.wjx.array;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author wjx
 * @date 2018/6/20 16:19
 */
public class App {
    public final static int LENGTH = 10;

    public static void main(String[] args) {
//        String[] strings=new String[LENGTH];
//
//        for(int i=0;i<LENGTH;i++){
//            strings[i]= UUID.randomUUID().toString();
//        }
//        long time=System.currentTimeMillis();
////        Arrays.parallelSort(strings);
//        Arrays.sort(strings);
////        System.out.println("consume time :"+(System.currentTimeMillis()-time)+"ms");
//        List<Student> students=new ArrayList<>(LENGTH);
//        for(int i=0;i<LENGTH;i++){
//           students.add(new Student(10,"wangjin xue"+i));
//        }
//        System.out.println(Arrays.deepToStrin\g(students.toArray()));
//        
        int[] b1 = {21, 2, 32, 14, 53, 126, 73, 8, 9, 10};

        IntStream stream = Arrays.stream(b1);
        stream.forEachOrdered(System.out::println);
    }
}
