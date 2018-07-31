package me.wjx.design_mode.proxy;

/**
 * @author wjx
 * @date 2018/7/30 13:50
 */
public class RealImage implements Image {
    private String fileName;
    public RealImage(String fileName){
        this.fileName=fileName;
        loadFromDisk(fileName);
    }
    @Override
    public void display() {
        System.out.println("Displaying "+fileName);
    }
    private void loadFromDisk(String fileName){
        System.out.println("Loading "+fileName);
    }
}
