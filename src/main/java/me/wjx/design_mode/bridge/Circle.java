package me.wjx.design_mode.bridge;

/**
 * @author wjx
 * @date 2018/7/12 15:49
 */
public class Circle extends Shape {
    private int x,y,radius;
    public Circle(int x,int y,int raduis,DrawAPI drawAPI){
        super(drawAPI);
        this.x=x;
        this.y=y;
        this.radius=raduis;
    }
    @Override
    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}
