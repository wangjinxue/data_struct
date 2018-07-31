package me.wjx.design_mode.decorator;

/**
 * @author wjx
 * @date 2018/7/27 18:15
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle=new Circle();
        Shape redCircle=new RedShapeDecorator(circle);
        Shape redRectangle=new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();
        System.out.println("circle with red border");
        redCircle.draw();
        System.out.println("rectangele with red border");
        redRectangle.draw();
    }
}
