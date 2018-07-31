package me.wjx.design_mode.filter.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 目录节点
 * 包含：
 * 1、目录名
 * 2、下级文件列表
 * 3、下级目录列表
 * 4、新增文件方法
 * 5、新增目录方法
 * 6、显示下级内容方法
 */
public class Noder {
    String nodeName;//目录名

    //通过构造器为目录命名
    public Noder(String nodeName) {
        this.nodeName = nodeName;
    }

    List<Noder> nodeList = new ArrayList<Noder>();//目录的下级目录列表
    List<Filer> fileList = new ArrayList<Filer>();//目录的下级文件列表

    //新增下级目录
    public void addNoder(Noder noder) {
        nodeList.add(noder);
    }

    //新增文件
    public void addFiler(Filer filer) {
        fileList.add(filer);
    }

    //显示下级目录及文件
    public void display() {
        for (Noder noder : nodeList) {
            System.out.println(noder.nodeName);
            noder.display();//递归显示目录列表
        }
        for (Filer filer : fileList) {
            filer.display();
        }
    }
}