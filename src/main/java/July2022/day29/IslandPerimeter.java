package July2022.day29;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/7/29 22:06
 */
public class IslandPerimeter {

    public static int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int path = dfs(grid, i, j);
                    result += path;
                }
            }
        }
        return result;
    }

    public static int dfs(int[][] grid, int i, int j) {
        //从一个岛屿方格走向网格边界，周长加 1
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 1;
        }
        //从一个岛屿方格走向水域方格，周长加 1
        if (grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
    }
}
