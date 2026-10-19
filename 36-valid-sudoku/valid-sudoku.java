class Solution {
    public boolean isValidSudoku(char[][] board) { // 1-9  --->  0-8
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];  // ---> 3X3 box

        for(int r = 0; r < 9; r = r+1){
            for(int c = 0; c < 9; c = c+1){
                if(board[r][c] == '.') continue; // empty

                int val = board[r][c] - '1'; // extract the value of that position (0-8)
                if(row[r][val] == 1) return false; // same number already exists in that row
                // put the element in the row
                row[r][val] = 1;


                if(col[c][val] == 1) return false; // same number already exists in that col
                // put the element in the col
                col[c][val] = 1;


                int boxId = 3 * (r / 3) + (c / 3);
                if(box[boxId][val] == 1) return false;

                box[boxId][val] = 1;
            }
        }

        return true;
    }
}