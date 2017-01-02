import java.util.*;
import java.io.*;

public class Main {
    static final int GRID_DIM = 9;

    //IT WORKS! SOLUTION: 24702
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[GRID_DIM][GRID_DIM];

        int result = 0;
        //READ IN GRID
        while(in.hasNextLine()) {
            in.nextLine();
            for(int i = 0; i < 9; ++i) {
                String s = in.nextLine();
                for(int j = 0; j < GRID_DIM; ++j) {

                    grid[i][j] = Integer.valueOf(s.substring(j,j+1));
                }
            }

            printGrid(grid);

            if(recursiveSltn(grid,0,0)) {
                printGrid(grid);
                result += (grid[0][0]*100) + (grid[0][1]*10) + grid[0][2];
            }else {
                System.out.println("No Unique Solution");
                printGrid(grid);
                break;
            }
        }

        System.out.println("RESULT: " + result);
    }

    public static boolean recursiveSltn(int[][] grid, int row, int col) {
        //shouldn't happen...
        if(row >= GRID_DIM || col >= GRID_DIM) {
            return false;
        }

        //If there's already a number there
        if(grid[row][col] != 0) {
            int nextRow,nextCol;
            if(row == GRID_DIM - 1 && col == GRID_DIM - 1) {return true;}
            else if(col == GRID_DIM - 1) {return recursiveSltn(grid,row+1,0);}
            else {return recursiveSltn(grid,row,col+1);}
        }

        GUESS:
        for(int i = 1; i <= GRID_DIM; ++i) {
            if(validPlacement(grid,row,col,i)) {
                boolean backTrack = true;
                grid[row][col] = i;
                //If its the last box
                if(row == GRID_DIM-1 && col == GRID_DIM -1) {
                    return true;
                }else if(col == GRID_DIM-1) {
                    backTrack = recursiveSltn(grid,row+1,0);
                }else{
                    backTrack = recursiveSltn(grid,row,col+1);
                }

                if(!backTrack) {
                    grid[row][col] = 0;
                    continue;
                }else {
                    return true;
                }

            }
        }

        return false;


    }

    public static boolean validPlacement(int[][] grid, int row, int col, int val) {
        //if(grid[x][y] != 0) {return false;}
        System.out.print("Checking: " + val + " for " + row + "," + col + " | ");
        if(!checkRow(grid,row,col,val)) {System.out.println("It failed RowCheck");return false;}
        if(!checkCol(grid,row,col,val)) {System.out.println("It failed ColCheck");return false;}
        if(!checkBox(grid,row,col,val)) {System.out.println("It failed BoxCheck");return false;}
        System.out.println("It Passed");
        return true;
    }

    public static boolean checkBox(int[][] grid, int row, int col, int val) {
        int startRow = row - (row%3);
        int startCol = col - (col%3);

        for(int i = startRow; i < startRow + 3; ++i) {
            for(int j = startCol; j < startCol + 3; ++j) {
                if(grid[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkRow(int[][] grid, int row, int col, int val) {
        for(int i = 0; i < GRID_DIM; ++i) {
            if(grid[row][i] == val) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkCol(int[][] grid, int row, int col, int val) {
        for(int i = 0; i < GRID_DIM; ++i) {
            if(grid[i][col] == val) {
                return false;
            }
        }
        return true;
    }

    public static void printGrid(int[][] grid) {
        for(int i = 0; i < GRID_DIM; ++i) {
            for(int j = 0; j < GRID_DIM; ++j) {
                System.out.print(grid[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
