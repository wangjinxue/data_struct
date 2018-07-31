package me.wjx.design_mode.flyweight;

import java.util.HashMap;

/**
 * @author wjx
 * @date 2018/7/27 18:38
 */
public class ShapeFactory {
    private static final HashMap<String,Shape> circleMap=new HashMap<>();
    public static Shape getCircle(String color){
        Circle circle = (Circle) circleMap.get(color);
        if(circle==null){
            circle=new Circle(color);
            circleMap.put(color,circle);
            System.out.println("create circle of color :"+ color);
        }
        return circle;
    }

}
