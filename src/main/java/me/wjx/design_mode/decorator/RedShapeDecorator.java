package me.wjx.design_mode.decorator;

/**
 * @author wjx
 * @date 2018/7/27 18:14
 */
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }
    public void  setRedBorder(Shape decoratedShape){
        System.out.println("red border");
    }

}
