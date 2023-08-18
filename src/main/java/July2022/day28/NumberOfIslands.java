package July2022.day28;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/7/28 17:22   leetcode 200 岛屿数量 https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] input  = {
                {'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(input));
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //从某一格开始向四面八方遍历
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private static void dfs(char[][] grid, int i, int j) {
        //base case
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        //已遍历过
        if (grid[i][j] != '1') {
            return;
        }
        //避免重复  二叉树不会重复遍历一个结点
        grid[i][j] = '2';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}

