//Aleksandra Trifonova
//Computer Science 282 Monday Wednesday
//Assignment #1
//9-12-2018
//This is a sudoku program. I had trouble with the solve method and using the contain methods in it therefore i just used loops in order to achieve the result I wanted. I also had trouble getting the actual values to print on the sudoku board.
class prog1 {
    private final int[][] board;
    //Copy Constructor
    public prog1 p;

    // default constructor -- I never seem to use it....
    public prog1() {
        board = new int[9][9];
    }

    // Construct a new sudoku puzzle from a string
// This piece of code might be useful to you:
// (int) (s[row].charAt(col + col/3)) - 48
    public prog1(String[] s) {
        board = new int[9][9];

        for (int col = 0; col < 9; col++) {
            board[0][col] = (int) (s[0].charAt(col + col / 3)) - 48;
        }
        for (int col = 0; col < 9; col++) {
            board[1][col] = (int) (s[1].charAt(col + col / 3)) - 48;
        }
        for (int col = 0; col < 9; col++) {
            board[2][col] = (int) (s[2].charAt(col + col / 3)) - 48;
        }
        for (int col = 0; col < 9; col++) {
            board[3][col] = (int) (s[3].charAt(col + col / 3)) - 48;
        }
        for (int col = 0; col < 9; col++) {
            board[4][col] = (int) (s[4].charAt(col + col / 3)) - 48;
        }
        for (int col = 0; col < 9; col++) {
            board[5][col] = (int) (s[5].charAt(col + col / 3)) - 48;
        }
        for (int col = 0; col < 9; col++) {
            board[6][col] = (int) (s[6].charAt(col + col / 3)) - 48;
        }
        for (int col = 0; col < 9; col++) {
            board[7][col] = (int) (s[7].charAt(col + col / 3)) - 48;
        }
        for (int col = 0; col < 9; col++) {
            board[8][col] = (int) (s[8].charAt(col + col / 3)) - 48;
        }
    }

    prog1(prog1 p) {
        this.board = p.board;
    }

    public static String myName() {
        return "Aleksandra Trifonova";

    }

    // Hint: use String.valueOf( i ) to convert an int to a String
    public String toString() {
        String newline = "";
        int divider = 0;
        for (int[] aBoard : board) {
            switch (newline += newline + "\n") {
            }
            newline += newline + "--------\n";
        }
        return newline;

    }

    // for easy checking of your answers
    public String toString2() {

        String result = "";
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                result = result + String.valueOf(board[row][col]);
            }
        }
        return result;
    }

    // create rotated sudoku puzzle – used by my test programs
    public void rotate() {
        int[][] temp = new int[9][9];
        int row, col;
        for (row = 0; row < 9; row++) {
            for (col = 0; col < 9; col++) {
                temp[col][8 - row] = board[row][col];
            }
        }
        for (row = 0; row < 9; row++) {
            for (col = 0; col < 9; col++) {
                board[row][col] = temp[row][col];
            }
        }
    }

    // Does the current board satisfy all the sudoku rules?
    //SUDOKU RULES
    //1. Board must exist
    //// 2. Nine rows
    //// 3. Nine COLUMNs per row
    //// 4. No repeating number in row
    //// 5. No repeating number in column
    //// 6. No repeating number in box
    public Boolean isValid() {
        boolean isValid = true;
        int tempval = 0; //this value will hold a temporary value from the board
//keeps track of what row we are on
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board[0].length; row++) {
                if (!(board[row][col] == 0)) {
                    board[row][col] = tempval;
                    board[row][col] = 0;
                    if (doesBoxContain(row, col, tempval) || doesRowContain(row, tempval) || doesColContain(col, tempval)) {
                        board[row][col] = tempval;
                        isValid = false;
                    }
                    board[row][col] = tempval;
                }
            }
        }
        return isValid;
    }

    // Is this a solved sudoku?
    public boolean isComplete() {
        boolean result = true;
        // end of first for loop
        return true;
    }//end of isComplete method

    // return true if val appears in the row of the puzzle
    private boolean doesRowContain(int row, int val) {
        boolean tester = false;
        int col;
        for (col = 0; col < 9; col++) {
            if (board[row][col] == val) {
                tester = true;
            }// end of if statement
        }// end of for-loop


        if (tester) {
            if (isValid()) {

            }

        }
        return tester;
    }

    // return true if val appears in the col (column) of the puzzle
    private boolean doesColContain(int col, int val) {
        boolean tester;
        int row;
        for (row = 0; row < 9; row++) {
            if (board[row][col] == val) {
                tester = true;
            }//end if statementy
        }//end for-loop
        tester = false;
        return false;
    }


    // return n if n is the only possible value for this spot
    // return 0 otherwise

    // return true if val appears in the 3 x 3 box
    private boolean doesBoxContain(int row, int col, int val) {
        boolean tester = false;
        int toprow = (row / 3) * 3;//returns first box in the first row
        int firstcol = (col / 3) * 3;//this will return the first box in the column
        for (toprow = 0; toprow < 3; toprow++) {
            firstcol = 0;
        }
        //return tester;

        return false;
    }

    private int fillSpot(Spot sq) {
        int number = 0;
        int Potentialnumber = 1;
        int Potentialvaluecounter = 0; //if there is more than one possible value for the spot the counter will keep track of it and return 0

        for (number = 1; number < 9; number++) {
            for (int column = 0; column < 9; column++) {
                if (!doesRowContain(sq.getRow(), number) && !doesColContain(sq.getCol(), number) && !doesBoxContain(sq.getRow(), sq.getCol(), number)) {
                    Potentialnumber = number;
                    if (Potentialnumber > 1) {
                        Potentialnumber = 0;
                        Potentialvaluecounter++;

                    }
                }
                if (number != 1) {
                    number = 0;
                }

            }

        }
        return Potentialnumber;
    }

    // return a valid spot if only one possibility for val in row
    // return null otherwise
    private Spot rowFill(int row, int val) {
        Spot potentialSpot = new Spot(row, 0);
        int count = 0;
        for (int column = 0; column < 9; column++) {
            assert potentialSpot != null;
            potentialSpot.setCol(column);
            if (fillSpot(potentialSpot) != 0 && board[potentialSpot.getRow()][potentialSpot.getCol()] == 0) {
                count++;
            }
            if (count > 1) {
                potentialSpot = null;
            }
        }
        return potentialSpot;
    }

    // return a valid spot if only one possibility for val in col
    // return null otherwise
    private Spot colFill(int col, int val) {
        // return a valid spot if only one possibility for val in the box
        // return null otherwise
        Spot potentialSpot = new Spot(0, col);
        int count = 0;
        assert potentialSpot != null;
        potentialSpot.setCol(0);
        if (fillSpot(potentialSpot) != 0 && board[potentialSpot.getRow()][potentialSpot.getCol()] == 0) {
            count++;
        }
        if (count > 1) {
            potentialSpot = null;
        }
        assert potentialSpot != null;
        potentialSpot.setCol(1);
        if (fillSpot(potentialSpot) != 0 && board[potentialSpot.getRow()][potentialSpot.getCol()] == 0) {
            count++;
        }
        if (count > 1) {
            potentialSpot = null;
        }
        assert potentialSpot != null;
        potentialSpot.setCol(2);
        if (fillSpot(potentialSpot) != 0 && board[potentialSpot.getRow()][potentialSpot.getCol()] == 0) {
            count++;
        }
        if (count > 1) {
            potentialSpot = null;
        }
        assert potentialSpot != null;
        potentialSpot.setCol(3);
        if (fillSpot(potentialSpot) != 0 && board[potentialSpot.getRow()][potentialSpot.getCol()] == 0) {
            count++;
        }
        if (count > 1) {
            potentialSpot = null;
        }
        assert potentialSpot != null;
        potentialSpot.setCol(4);
        if (fillSpot(potentialSpot) != 0 && board[potentialSpot.getRow()][potentialSpot.getCol()] == 0) {
            count++;
        }
        if (count > 1) {
            potentialSpot = null;
        }
        assert potentialSpot != null;
        potentialSpot.setCol(5);
        if (fillSpot(potentialSpot) != 0 && board[potentialSpot.getRow()][potentialSpot.getCol()] == 0) {
            count++;
        }
        if (count > 1) {
            potentialSpot = null;
        }
        assert potentialSpot != null;
        potentialSpot.setCol(6);
        if (fillSpot(potentialSpot) != 0 && board[potentialSpot.getRow()][potentialSpot.getCol()] == 0) {
            count++;
        }
        if (count > 1) {
            potentialSpot = null;
        }
        assert potentialSpot != null;
        potentialSpot.setCol(7);
        if (fillSpot(potentialSpot) != 0 && board[potentialSpot.getRow()][potentialSpot.getCol()] == 0) {
            count++;
        }
        if (count > 1) {
            potentialSpot = null;
        }
        assert potentialSpot != null;
        potentialSpot.setCol(8);
        if (fillSpot(potentialSpot) != 0 && board[potentialSpot.getRow()][potentialSpot.getCol()] == 0) {
            count++;
        }
        if (count > 1) {
            potentialSpot = null;
        }
        return potentialSpot;
    }

    private Spot boxFill(int rowbox, int colbox, int val) {
        Spot potentialSpot = new Spot(rowbox, colbox);
        if (!doesBoxContain(rowbox, colbox, val)) {
            potentialSpot = new Spot(rowbox, colbox);
        } else potentialSpot = null;
        return potentialSpot;
    }


    // who are you? Put your name here!
    //public static String myName() {
    //return "Aleksandra Trifonova";

    public void solve() {
        int limitation = 0;
        if (isValid()) {

        }
    }

}

//Aleksandra Trifonova
//Computer Science 282 Monday Wednesday
//Assignment #1
//9-12-2018
class Spot {
    private int row, col;

    public Spot(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return this.col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}



