package August2022.day27;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/27 20:54
 */
public class InvertTree {
    public static void main(String[] args) {

    }
    public static TreeNode creatTree(Integer[] nums, int index) {
        if (index >= nums.length) {
            return null;
        }
        Integer value = nums[index];
        if (value == null) {
            return null;
        }
        TreeNode root = new TreeNode(value);
        root.left = creatTree(nums, 2 * index + 1);
        root.right = creatTree(nums, 2 * index + 2);
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static class TreeNode {
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

}
