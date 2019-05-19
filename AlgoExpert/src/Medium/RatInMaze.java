package Medium;

import java.util.Arrays;

public class RatInMaze {
	
	boolean solveMaze(int maze[][], int N) { 
        int sol[][] = {{0, 0, 0, 0}, 
        			   {0, 0, 0, 0}, 
        			   {0, 0, 0, 0}, 
        			   {0, 0, 0, 0} 
        }; 
  
        if (solveMazeUtil(maze, 0, 0, sol, N) == false) 
        { 
            System.out.print("Solution doesn't exist"); 
            return false; 
        } 
  
        printSolution(sol); 
        return true; 
    } 

	private void printSolution(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol.length; j++) {
				System.out.print(" "+sol[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	boolean solveMazeUtil(int maze[][], int row, int col, int sol[][], int N) { 
		//if its the dest
		if (row == N - 1 && col == N - 1) { 
			sol[row][col] = 1; 
			return true; 
		} 

		// Check if maze[row][col] is valid 
		if (isSafe(maze, row, col, N) == true) { 
		// mark row,col as part of solution path 
			sol[row][col] = 1;

			/* Move forward(down) in row direction */
			if (solveMazeUtil(maze, row + 1, col, sol, N)) {
				return true;
			} 

			/* If moving in row direction doesn't give solution then  Move down in col direction */
			if (solveMazeUtil(maze, row, col + 1, sol, N)) {
				return true; 
			}

			/* If none of the above movements works then BACKTRACK: 
			 * unmark row,col as part of solution path */
			sol[row][col] = 0; 
			return false; 
		} 
		return false; 
	}

	private boolean isSafe(int[][] maze, int row, int col, int N) {
		return (row>=0 && row<N && col>=0 && col<N && maze[row][col]==1);
	}

	public static void main(String[] args) {		
		RatInMaze rat = new RatInMaze();
		int maze[][] = {{1, 0, 0, 0}, 
	            {1, 1, 0, 1}, 
	            {0, 1, 0, 0}, 
	            {1, 1, 1, 1} 
	        }; 
	    boolean res = rat.solveMaze(maze, 4);
	    System.out.println(res);
	}

}
