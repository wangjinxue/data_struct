package me.wjx.stack;

/**
 * @author wjx
 * @date 2018/6/7 11:48
 */
public class CheckExpression {
    public static String isValid(String exp) {
        LinkedStack<String> stack = new LinkedStack<>();
        int i = 0;
        while (i < exp.length()) {
            char ch = exp.charAt(i);
            i++;
            switch (ch) {
                case '(':
                    stack.push(ch + "");
                    break;
                case ')':
                    if (stack.isEmpty() || !"(".equals(stack.pop())) {
                        return "(";
                    }
                    break;
                default:
                    break;
            }

        }
        if (stack.isEmpty()) {
            return "check pass!";
        } else {
            return "check exception!";
        }
    }
}
