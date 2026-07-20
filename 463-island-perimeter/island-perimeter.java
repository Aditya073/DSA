class Solution {
    public int islandPerimeter(int[][] grid) {
        // out of bounce on any side --> +1
        // water at next or prev --> +1
        // another land at next or prev --> +0

        int sum = 0;

        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    // up
                    if(i > 0 && grid[i-1][j] == 0 || i == 0){
                        sum = sum + 1;
                    }
                    // down
                    if((i < grid.length-1 && grid[i+1][j] == 0) || i == grid.length-1){
                        sum = sum + 1;
                    }


                    // left
                    if(j > 0 && grid[i][j-1] == 0 || j == 0){
                        sum = sum + 1;
                    }
                    // right
                    if((j < grid[i].length-1 && grid[i][j+1] == 0) || j ==  grid[i].length-1){
                        sum = sum + 1;
                    }
                }
            }
        }
        return sum;
    }
}