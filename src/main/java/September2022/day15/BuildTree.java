package September2022.day15;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/15 16:29
 */
public class BuildTree {
    public static void main(String[] args) {


    }

    static public TreeNode createTree(int[] nums, int index) {
        TreeNode root = new TreeNode();
        if (index >= nums.length) {
            return root;
        }
        root.val = nums[index];
        root.left = createTree(nums, 2 * index + 1);
        root.right = createTree(nums, 2 * index + 2);
        return root;
    }

    static public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode tree = build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        return tree;
    }

    static public TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode();
        //root在中序的位置
        int rootIndex = 0;
        int rootVal = postorder[postEnd];
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        root.val = rootVal;
        int leftLength = rootIndex - inStart;
        // 位置参数一定要细心
        root.left = build(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftLength - 1);
        root.right = build(inorder, postorder, rootIndex + 1, inEnd, postStart + leftLength, postEnd - 1);
        return root;
    }
}

class TreeNode {
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
