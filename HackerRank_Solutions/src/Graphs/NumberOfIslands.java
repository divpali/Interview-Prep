package Graphs;

public class NumberOfIslands {
	
	public int numOfIslands(char[][] grid) {
		int count = 0;
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					explore(grid,i,j);
					count++;
				}
				
			}
		}
		return count;
	}

	private void explore(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '-';
            explore(grid, i - 1, j);
            explore(grid, i, j - 1);
            explore(grid, i + 1, j);
            explore(grid, i, j + 1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {{'1','1','0','0','0'},
						 {'1','1','0','0','0'},
						 {'0','0','1','0','0'},
						 {'0','0','0','1','1'}};
		NumberOfIslands n = new NumberOfIslands();
		int res = n.numOfIslands(grid);
		System.out.println(res);
	}

}
