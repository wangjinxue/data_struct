package me.wjx.design_mode.prototype;

import java.util.HashMap;

/**
 * @author wjx
 * @date 2018/7/12 14:56
 */
public class App {
    public static final String SHAPE_RECTANGLE="rectange";
    public static final String SHAPE_SQUARE="square";

    private final static HashMap<String, Shape> shapeMap = new HashMap<>(5);

    public static void main(String[] args) {
        initData();
        Shape shape1 = getShape(SHAPE_RECTANGLE);
        Shape shape2 = getShape(SHAPE_RECTANGLE);
        System.out.println(shape1==shape2);
    }

    public static Shape getShape(String shapeId) {
        Shape shape = shapeMap.get(shapeId);
        return (Shape) shape.clone();
    }
    static void initData(){
        Shape rectangle=new Rectangle();
        shapeMap.put(SHAPE_RECTANGLE,rectangle);
        Shape square=new Square();
        shapeMap.put(SHAPE_SQUARE,square);
    }
}
