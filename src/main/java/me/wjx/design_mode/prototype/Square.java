package me.wjx.design_mode.prototype;

/**
 * @author wjx
 * @date 2018/7/12 14:52
 */
public class Square extends Shape {
    public Square(){
        type="square";
    }

    @Override
    public void draw() {
        System.out.println("square draw");
    }

}
