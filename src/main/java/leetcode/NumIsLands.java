package leetcode;

public class NumIsLands {
    public int numIslands(char[][] grid) {
        int count = 0; // 岛屿数量
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j); // 深度优先遍历，遍历所有的陆地
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        // 防止i和j越界，也就是防止超出岛屿边界，特别主语到遍历到海洋的时候也退出循环
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        // 将遍历的陆地变为海洋，防止重复遍历
        grid[i][j] = '0';
        dfs(grid, i + 1, j); // 上
        dfs(grid, i - 1, j); // 下
        dfs(grid, i, j - 1); // 左
        dfs(grid, i, j + 1); // 右
    }
}
