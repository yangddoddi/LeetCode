class Solution {
    private int[] moveX = {1, -1, 0, 0};
    private int[] moveY = {0, 0, 1, -1};
    private final int X_IDX = 1;
    private final int Y_IDX = 0;
    private int count = 0;
    
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == '0' || visited[i][j]) continue;
                bfs(grid, visited, new int[]{i, j});
            }
        }
        
        return count;
    }
    
    public void bfs(char[][] grid, boolean[][] visited, int[] node) {
        Queue<int[]> queue = new LinkedList<>();
        visited[node[Y_IDX]][node[X_IDX]] = true;
        queue.add(new int[]{node[Y_IDX], node[X_IDX]});
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for (int i=0; i<moveX.length; i++) {
                int nextX = curr[X_IDX] + moveX[i];
                int nextY = curr[Y_IDX] + moveY[i];
                
                if (nextX >= 0 && nextX < grid[0].length && nextY >= 0 && nextY < grid.length && !visited[nextY][nextX] && grid[nextY][nextX] == '1') {
                    queue.add(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                }
            }
        }
        
        count++;
    }
}