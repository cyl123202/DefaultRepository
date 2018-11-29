package Decompose;

import Utils.TreeNode;

import java.util.Stack;

public class BinaryTreeAndTwoWayList {

    // 方法一：中序遍历（堆栈实现，非递归）
    /*public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = pRootOfTree;
        TreeNode pre = null;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {

            }
        }
    }*/

    // 方法二：递归实现
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        // 将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode current = left;
        // 定位至左子树双链表最后一个节点
        while (current != null && current.right != null) {
            current = current.right;
        }
        // 如果左子树链表不为空的话，将当前root追加到左子树链表
        if (left != null) {
            current.right = pRootOfTree;
            pRootOfTree.left = current;
        }
        // 将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(pRootOfTree.right);
        // 如果右子树链表不为空的话，将该链表追加到root节点之后
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return pRootOfTree == null ? null : left;
        //return left != null ? left : right;
    }

}
