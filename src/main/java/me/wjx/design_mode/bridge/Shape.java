package me.wjx.design_mode.bridge;

/**
 * @author wjx
 * @date 2018/7/12 15:47
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI=drawAPI;
    }
    public abstract void draw();
}
