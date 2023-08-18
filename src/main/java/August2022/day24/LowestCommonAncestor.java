package August2022.day24;

import java.util.Scanner;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/23 22:03
 * 236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] tree = s.split(" ");
        Integer[] arr = new Integer[tree.length];
        for (int i = 0; i < arr.length; i++) {
            if ("null".equals(tree[i])) {
                arr[i] = null;
            } else {
                arr[i] = Integer.valueOf(tree[i]);
            }
        }
        TreeNode root = createTree(arr, 0);
        System.out.println(root);

        String a = "3 5 1 6 2 0 8 null null 7 4";


    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        //去左子树找两个结点的最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //去右子树找两个结点的最近公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //自己是自己的公共祖先，若左右两边都没找到，说明p,q两个结点就不在左右子树上
        if (left == null && right == null) {
            return null;
        } else if(left != null && right != null) {//左右字数都找到了最近公共祖先，其实找到的就是自己
            return root;
        } else if (left == null) {//右子树找到了最近公共祖先
            return right;
        } else {//左子树找到了最近公共祖先
            return left;
        }

    }

    /**
     * 从数组构造一棵二叉树
     */
    private static TreeNode createTree(Integer[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }
        Integer value = arr[index];
        if (value == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(value);
        treeNode.left = createTree(arr, 2 * index + 1);
        treeNode.right = createTree(arr, 2 * index + 2);
        return treeNode;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
