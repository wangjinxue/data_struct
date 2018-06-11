package me.wjx.tree;

import java.util.LinkedList;

/**
 * @author wjx
 * @date 2018/6/11 10:33
 */
public class BinaryTree {
    private Node root;
    public Node getRoot(){
        return root;
    }
    public class Node{
        public int iData;
        public Node leftNode;
        public Node rightNode;

        public Node(int iData) {
            this.iData =iData;
        }

        public void showNode(){
            System.out.println("{leftNode:"+(leftNode==null?null:leftNode.iData)+",iData:" +iData+",rightNode:"+(rightNode==null?null:rightNode.iData)+"}");

        }
    }

    /**
     * 插入数据
     * @param iData
     */
    public void insert(int iData){
        Node newData=new Node(iData);
        if(root==null){
            root=newData;
        }else{
            Node current=root;
            Node parent;
            while(true){
                //如果插入的数据小于根节点插入到父的做节点
                parent=current;
                if(iData <current.iData){
                   current=current.leftNode;
                   //只有为null时才插入
                   if(current==null){
                       parent.leftNode=newData;
                       return;
                   }
                }else{
                    current=current.rightNode;
                    if(current==null){
                        parent.rightNode=newData;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 不断循环遍历查找关键字
     * @return
     */
    public Node find(int key){
        Node current=root;
        while(current.iData!=key){
            if(current.iData>key){
                current=current.leftNode;
            }else{
                current=current.rightNode;
            }
            if(current==null){
                return null;
            }
        }
        return current;
    }

    /**
     * 利用链表遍历树
     */
    public void print(){
        LinkedList<Node> list=new LinkedList<>();
        Node p;
        list.push(root);
        while(!list.isEmpty()){
            p=list.removeFirst();
            System.out.println(p.iData);
            if(p.leftNode!=null){
                list.addLast(p.leftNode);
            }
            if(p.rightNode!=null){
                list.addLast(p.rightNode);
            }
        }
    }

    /**
     * 先序递归遍历
     * @param root
     */
    public void print1(Node root){
        if(root!=null){
            System.out.println(root.iData);
            print1(root.leftNode);
            print1(root.rightNode);
        }
    }
    /**
     * 中序递归遍历
     */
    public void printMide(Node root){
        if(root!=null){
            printMide(root.leftNode);
            System.out.println(root.iData);
            printMide(root.rightNode);
        }
    }
    /**
     * 后序递归遍历
     */
    public void printAfter(Node root){
        if(root!=null){
            printAfter(root.leftNode);
            printAfter(root.rightNode);
            System.out.println(root.iData);
        }
    }

    /**
     * 极值查找
     * @return
     */
    public Node[] mVal(){
        Node minNode=null;
        Node maxNode=null;
        Node[] maxMinVal=new Node[2];
        Node current=root;
        while(current!=null){
            minNode=current;
            current=current.leftNode;
        }
        maxMinVal[0]=minNode;
        current=root;
        while(current!=null){
            maxNode=current;
            current=current.rightNode;
        }
        maxMinVal[1]=maxNode;
        return maxMinVal;
    }
}
