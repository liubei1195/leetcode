package leetcode.bfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root本身就是一层，depth初始化为1
        int depth = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 判断是否到达终点 */
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                /* 将cur的相邻节点加入队列 */
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++; // 这里增加步数
        }
        return depth;
    }
}
