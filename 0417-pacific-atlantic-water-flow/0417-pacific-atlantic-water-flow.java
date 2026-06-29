import java.util.*;

class Solution {

    int rows, cols;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific borders
        for (int r = 0; r < rows; r++) {
            dfs(heights, pacific, r, 0);
            dfs(heights, atlantic, r, cols - 1);
        }

        // Atlantic borders
        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, 0, c);
            dfs(heights, atlantic, rows - 1, c);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int r, int c) {

        if (visited[r][c]) return;

        visited[r][c] = true;

        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nc < 0 || nr >= rows || nc >= cols)
                continue;

            if (heights[nr][nc] < heights[r][c])
                continue;

            dfs(heights, visited, nr, nc);
        }
    }
}