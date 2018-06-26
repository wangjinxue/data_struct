package me.wjx.tree;

/**
 * @author wjx
 * @date 2018/6/11 11:04
 */
public class App {
    public static void main(String[] args) {
//        BinaryTree tree=new BinaryTree();
//        tree.insert(2);
//        tree.insert(211);
//        tree.insert(12);
//        tree.insert(21);
//        tree.insert(23);
//        BinaryTree.Node[] nodes = tree.mVal();
//        System.out.println("min:"+nodes[0].iData);
//        System.out.println("max:"+nodes[1].iData);
        AVLTree tree=new AVLTree();
        tree.insert(111);
        tree.insert(22);
        tree.insert(31);
        tree.insert(2);
        tree.insert(18);
        tree.insert(29);
        tree.printBalance();


    }
}
