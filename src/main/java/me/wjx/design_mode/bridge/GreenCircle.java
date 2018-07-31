package me.wjx.design_mode.bridge;

/**
 * @author wjx
 * @date 2018/7/12 15:47
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
