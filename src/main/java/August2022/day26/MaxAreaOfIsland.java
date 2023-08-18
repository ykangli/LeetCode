package August2022.day26;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/26 16:46
 * dfs
 */
public class MaxAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 0;
        int left = dfs(grid, i + 1, j);
        int right = dfs(grid, i - 1, j);
        int top = dfs(grid, i, j + 1);
        int bottom = dfs(grid, i, j - 1);
        return left + bottom + top + right + 1;
    }
}
