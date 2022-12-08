package leetcode.binaryTree;

public class DiameterOfBinaryTree {
    // 记录最大直径的长度
    int maxdDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxdDiameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 后序位置，计算最大直径
        int myDiameter = leftMax + rightMax;
        maxdDiameter = Math.max(maxdDiameter, myDiameter);
        return 1 + Math.max(leftMax, rightMax);
    }
}
