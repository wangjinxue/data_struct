package me.wjx.design_mode.prototype;

/**
 * @author wjx
 * @date 2018/7/12 14:52
 */
public class Rectangle extends Shape {
    public Rectangle(){
        type="rectangle";
    }

    @Override
    void draw() {
        System.out.println("rectangle draw");
    }
}
