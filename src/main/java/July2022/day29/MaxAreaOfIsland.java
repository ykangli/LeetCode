package July2022.day29;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/7/29 22:19
 */
public class MaxAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }
    public static int dfs(int[][] grid, int i, int j) {
        //超出边界为0
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        //网格是水或访问过面积为0
        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] =2;
        return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
    }
}
