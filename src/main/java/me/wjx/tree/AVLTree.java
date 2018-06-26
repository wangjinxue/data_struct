package me.wjx.tree;

/**
 * 平衡二叉树
 */
public class AVLTree {
    /**
     * 根节点
     */
    private Node root;

    /**
     * 保存节点数据
     */
    private class Node {
        /**
         * 键
         */
        private int key;
        /**
         * 平衡点
         */
        private int balance;
        /**
         * 高度
         */
        private int height;
        /**
         * 左节点、右节点、父节点
         */
        private Node left, right, parent;

        /**
         * 构造函数
         * @param k
         * @param p
         */
        Node(int k, Node p) {
            key = k;
            parent = p;
        }
    }

    /**
     * 插入数据
     * @param key 键，键重复插入失败
     * @return
     */
    public boolean insert(int key) {
        //判断根节点是否为空，为空直接设置为根节点
        if (root == null) {
            root = new Node(key, null);
        } else {
            //根节点
            Node n = root;
            //父节点
            Node parent;
            while (true) {
                //不允许插入重复值
                if (n.key == key) {
                    return false;
                }
                //父节点赋值给跟节点
                parent = n;
                //如果节点插入的key小于父节点，放在左子节点
                boolean goLeft = n.key > key;
                //
                n = goLeft ? n.left : n.right;

                if (n == null) {
                    if (goLeft) {
                        parent.left = new Node(key, parent);
                    } else {
                        parent.right = new Node(key, parent);
                    }
                    rebalance(parent);
                    break;
                }
            }
        }
        return true;
    }

    private void delete(Node node) {
        if (node.left == null && node.right == null) {
            if (node.parent == null) {
                root = null;
            } else {
                Node parent = node.parent;
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                rebalance(parent);
            }
            return;
        }
        if (node.left != null) {
            Node child = node.left;
            while (child.right != null) {
                child = child.right;
            }
            node.key = child.key;
            delete(child);
        } else {
            Node child = node.right;
            while (child.left != null) {
                child = child.left;
            }
            node.key = child.key;
            delete(child);
        }
    }

    public void delete(int delKey) {
        if (root == null) {
            return;
        }
        Node node = root;
        Node child = root;

        while (child != null) {
            node = child;
            child = delKey >= node.key ? node.right : node.left;
            if (delKey == node.key) {
                delete(node);
                return;
            }
        }
    }

    private void rebalance(Node n) {
        setBalance(n);
        if (n.balance == -2) {

            if (height(n.left.left) >= height(n.left.right)) {
                n = rotateRight(n);
            } else {
                n = rotateLeftThenRight(n);
            }
        } else if (n.balance == 2) {
            if (height(n.right.right) >= height(n.right.left)) {//判断是否是右的情况
                n = rotateLeft(n);
            } else {
                n = rotateRightThenLeft(n);
            }
        }
        if (n.parent != null) {
            rebalance(n.parent);
        } else {
            root = n;
        }
    }
    private Node rotateLeft(Node a) {

        Node b = a.right;
        b.parent = a.parent;

        a.right = b.left;

        if (a.right != null) {
            a.right.parent = a;
        }

        b.left = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        setBalance(a, b);

        return b;
    }

    private Node rotateRight(Node a) {

        Node b = a.left;
        b.parent = a.parent;

        a.left = b.right;

        if (a.left != null) {
            a.left.parent = a;
        }

        b.right = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        setBalance(a, b);

        return b;
    }

    private Node rotateLeftThenRight(Node n) {
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }

    private Node rotateRightThenLeft(Node n) {
        n.right = rotateRight(n.right);
        return rotateLeft(n);
    }

    private int height(Node n) {
        if (n == null) {
            return -1;
        }
        return n.height;
    }

    private void setBalance(Node... nodes) {
        for (Node n : nodes) {
            reheight(n);
            n.balance = height(n.right) - height(n.left);
        }
    }

    public void printBalance() {
        printBalance(root);
    }

    private void printBalance(Node n) {
        if (n != null) {
            printBalance(n.left);
            System.out.printf("balance:%s,key:%d \n ", n.balance,n.key);
            printBalance(n.right);
        }
    }

    private void reheight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        System.out.println("Inserting values 1 to 10");
        for (int i = 1; i < 10; i++) {
            tree.insert(i);
        }

        System.out.print("Printing balance: ");
        tree.printBalance();
    }
}
