package August2022.day20;

import java.util.*;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/19 22:08
 * 102. 二叉树的层序遍历
 */
public class LevelOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        TreeNode bt = createBT(data);
        System.out.println(bt);


    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //当前层的节点数
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            //for循环用来将一层的结点出队完
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }


    /**
     * 利用递归从数组构建二叉树
     */
    public static TreeNode createBinaryTree(String[] data, int index) {
        if (index < data.length) {
            TreeNode treeNode = new TreeNode();
            String value = data[index];
            if (value.equals("null")) {
                return null;
            }
            treeNode = new TreeNode();
            treeNode.left = createBinaryTree(data, 2 * index + 1);
            treeNode.left = createBinaryTree(data, 2 * index + 2);
            return treeNode;
        } else {
            return null;
        }
    }

    /**
     * 从一个数组构建二叉树  (其实是二叉树的反序列化)  leetcode 297
     */
    public static TreeNode createBT(String data) {
        String[] nodes = data.split(" ");
        TreeNode root = getNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode parent = root;
        boolean isLeft = true;
        for (int i = 1; i < nodes.length; i++) {
            TreeNode curr = getNode(nodes[i]);
            if (isLeft) {
                assert parent != null;
                parent.left = curr;
            } else {
                parent.right = curr;
            }
            if (curr != null) {
                queue.offer(curr);
            }
            isLeft = !isLeft;
            if (isLeft) {
                parent = queue.peek();
                queue.poll();
            }
        }
        return root;
    }

    public static TreeNode getNode(String node) {
        if ("null".equals(node)) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(node));
        }
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
