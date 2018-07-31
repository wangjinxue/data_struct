package me.wjx.design_mode.filter.demo;

import java.io.File;
 
public class Clienter {
    public static void createTree(Noder node){
        File file = new File(node.nodeName);
        File[] f = file.listFiles();
        for(File fi : f){
            if(fi.isFile()){
                Filer filer = new Filer(fi.getAbsolutePath());
                node.addFiler(filer);
            }
            if(fi.isDirectory()){
                Noder noder = new Noder(fi.getAbsolutePath());
                node.addNoder(noder);
                createTree(noder);//使用递归生成树结构
            }
        }
    }
    public static void main(String[] args) {
        Noder noder = new Noder("D:\\ide\\app\\YouKnow");
        createTree(noder);//创建目录树形结构
        noder.display();//显示目录及文件
    }
}