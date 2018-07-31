package me.wjx.design_mode.flyweight;

/**
 * @author wjx
 * @date 2018/7/27 18:40
 */
public class App {
    private static final String colors[] ={"Red","Green","Blue","White","Black"};
    public static void main(String[] args) {
        for(int i=0;i<20;++i){
            Circle circle= (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRAndomY());
            circle.draw();
        }
    }
    public static String getRandomColor(){
        return colors[(int) (Math.random()*colors.length)];
    }
    private static int getRandomX(){
        return (int) (Math.random()*100);
    }
    private static int getRAndomY(){
        return (int) (Math.random()*100);
    }
}
