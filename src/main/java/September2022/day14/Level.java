package September2022.day14;

import java.util.*;


public class Level {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            Stack stack = new Stack();
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.poll();
                if (level % 2 == 0) {
                    //默认尾插法
                    list.add(peek.val);
                } else {
                    //头插法
                    list.add(0, peek.val);
                }
                if (peek.left != null) {
                    queue.offer(peek.left);
                }
                if (peek.right != null) {
                    queue.offer(peek.right);
                }

            }
            level++;
            res.add(list);
        }
        return res;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
