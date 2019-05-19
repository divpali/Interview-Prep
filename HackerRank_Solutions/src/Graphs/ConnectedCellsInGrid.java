
package Graphs;

import java.util.Scanner;

public class ConnectedCellsInGrid {
    
    public static void main(String[] args) {
        /* Read and save grid */
        int[][] grid = {{1,1,0,0},
        				{0,1,1,0},
        				{0,0,1,0},
        				{1,0,0,0}};

        System.out.print("max region size = ");
        System.out.print(largestRegion(grid));
    }

	private static int largestRegion(int[][] grid) {
		// TODO Auto-generated method stub
		int max_region = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col]==1) {
					int size = findLargestRegion(grid, row, col);
					max_region = Math.max(size, max_region);
				}
			}
		}
		return max_region;
	}

	private static int findLargestRegion(int[][] grid, int row, int col) {
		// TODO Auto-generated method stub
		if(row < 0 || row >= grid.length || col < 0 || col >=grid[row].length) {
			return 0;
		}
		if(grid[row][col]==0) {
			return 0;
		}
		int size=1;
		grid[row][col] = 0;
		for (int r = row-1; r <= row+1; r++) {
			for (int c = col-1; c <= col+1; c++) {
				size+=findLargestRegion(grid, r, c);
			}
		}
		return size;
	}

}
