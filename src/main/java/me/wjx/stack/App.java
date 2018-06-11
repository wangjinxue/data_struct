package me.wjx.stack;

/**
 * @author wjx
 * @date 2018/6/7 11:01
 */
public class App {
    public static void main(String[] args) {
//        OrderStack<String> stack=new OrderStack<>(10);
//        for(int i=0;i<10;i++){
//            stack.push("hello"+i);
//        }
//        stack.push("hello10");
//        stack.push("hello11");
//        stack.push("hello12");
//
//        int size=stack.getSize();
//        for(int i=0;i<size;i++){
//            System.out.println(stack.pop());
//        }
        java.util.Stack stack1=new java.util.Stack();
        LinkedStack<String> stack=new LinkedStack<>();
        for(int i=0;i<10;i++){
            stack.push("hello"+i);
        }
//        int size=stack.size();
//        for(int i=0;i<size;i++){
//            System.out.println(stack.pop());
//        }
//        String exp = "((5+5)*123)";
//        String result=CheckExpression.isValid(exp);
//        System.out.println(result);
    }
}
