package September2022.day15;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/15 17:49
 */
public class BuildTree2 {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return node;
    }

    public static TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        //先序的第一个就是根结点
        int rootVale = preorder[preStart];
        //rootIndex为 根节点在 中序遍历中的位置
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVale) {
                rootIndex = i;
                break;
            }
        }
        //leftLength 为在中序遍历结果中，左子树的部分长度
        int leftLength = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVale);
        root.left = build(preorder, inorder, preStart + 1, preStart + leftLength, inStart, rootIndex - 1);
        root.right = build(preorder, inorder, preStart + leftLength + 1, preEnd, rootIndex + 1, inEnd);
        return root;
    }


    public static TreeNode createTree(int[] nums, int index) {
        TreeNode root = new TreeNode();
        if (index >= nums.length) {
            return root;
        }
        root.val = nums[index];
        root.left = createTree(nums, 2 * index + 1);
        root.right = createTree(nums, 2 * index + 2);
        return root;
    }


}
