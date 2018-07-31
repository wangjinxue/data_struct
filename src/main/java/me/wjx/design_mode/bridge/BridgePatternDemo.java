package me.wjx.design_mode.bridge;

/**
 * @author wjx
 * @date 2018/7/12 15:50
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle=new Circle(100,100,10,new RedCircle());
        Shape greenCircle=new Circle(100,100,10,new GreenCircle());
        redCircle.draw();
        greenCircle.draw();
    }
}
