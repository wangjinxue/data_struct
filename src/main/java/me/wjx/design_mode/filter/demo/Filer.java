package me.wjx.design_mode.filter.demo;

/**
 * 文件节点
 * 文件节点是终节点，无下级节点
 * 包含：
 * 1、文件名
 * 2、文件显示方法
 */
public class Filer {
    String fileName;//文件名

    public Filer(String fileName) {
        this.fileName = fileName;
    }

    //文件显示方法
    public void display() {
        System.out.println(fileName);
    }
}