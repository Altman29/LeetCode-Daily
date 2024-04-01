package org.example;

/*
使用非递归的方式，实现一个二叉树的后序遍历。
 */
public class 二叉树后续遍历 {

    public static void postorderTraversal(TreeNode root) {
        if (root == null) return;

        Stack stack = new Stack();
        Stack resultStack = new Stack();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            resultStack.push(current);

            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        while (!resultStack.isEmpty()) {
            TreeNode node = resultStack.pop();
            System.out.print(node.val + " ");
        }
    }

    public static void main(String[] args) {
        // 构造二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("后序遍历结果:");
        postorderTraversal(root);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class StackNode {
    TreeNode node;
    StackNode next;

    StackNode(TreeNode node) {
        this.node = node;
    }
}

class Stack {
    private StackNode top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(TreeNode node) {
        StackNode newNode = new StackNode(node);
        newNode.next = top;
        top = newNode;
    }

    public TreeNode pop() {
        if (isEmpty()) {
            return null;
        }
        TreeNode node = top.node;
        top = top.next;
        return node;
    }

    public TreeNode peek() {
        if (isEmpty()) {
            return null;
        }
        return top.node;
    }
}
