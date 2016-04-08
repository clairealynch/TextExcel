/**
 * Created by bal_calynch on 3/2/2016.
 */
public class Board {

    //set constants
    public static final String HEADER_ROW = "            |     A      |     B      |     C      |     D      |     E      |     F      |     G      |";
    public static final String FOOTER_ROW = "------------+------------+------------+------------+------------+------------+------------+------------+";
    public static final String COL_SPLIT = "|            |            |            |            |            |            |            |";
    public static final int COL_SPLITROWS = 12;
    public static final int ROWS = 10; //10 rows created
    public static final int COLUMNS = 7; //7 columns created
    public Cell[][] theBoardArray;


    public Board() {
        theBoardArray = new Cell[COLUMNS][ROWS]; //an array for the board
        for (int i = 0; i<COLUMNS; i++){
            for(int j = 0; j < ROWS; j++){
                theBoardArray[i][j] = new Cell();
            }
        }

    }

    public String getValue(int letterNum, int numNum){
        Cell contents = theBoardArray[letterNum][numNum];
        return contents.toString();

    }

   /* public int lengthOfCell(String theInput){ //would deal with splitting up the columns, if its 12 characters or less, make it 12
        if (theInput.length() <= 12){
            System.out.println(theInput);
        }
    }*/

    //convert to number method
    public int convertToNumber(String letter){ //converts letter from user input to the column number

        if (letter.contains("A")) {
            int Column = 0;
            return Column;
        }
        else if (letter.contains("B")) {
            int Column = 1;
            return Column;
        }
        else if (letter.contains("C")) {
            int Column = 2;
            return Column;
        }
        else if (letter.contains("D")) {
            int Column = 3;
            return Column;
        }
        else if (letter.contains("E")) {
            int Column = 4;
            return Column;
        }
        else if (letter.contains("F")) {
            int Column = 5;
            return Column;
        }
        else if (letter.contains("G")) {
            int Column = 6;
            return Column;
        }
        return 0;
    }

    public int convertNumToNum(int theNumber){

        if (theNumber == 1){
            theNumber = 0;
        }
        if (theNumber == 2){
            theNumber = 1;
        }
        if (theNumber == 3){
            theNumber = 2;
        }
        if (theNumber == 4){
            theNumber = 3;
        }
        if (theNumber == 5){
            theNumber = 4;
        }
        if (theNumber == 6){
            theNumber = 5;
        }
        if (theNumber == 7){
            theNumber = 6;
        }
        if (theNumber == 8){
            theNumber = 7;
        }
        if (theNumber == 9){
            theNumber = 8;
        }
        if (theNumber == 10){
            theNumber = 9;
        }
        return theNumber;
    }

    public String letterSplit(String input) { //splits the input into the letter
        String letter = input.substring(0, 1);
        return letter;
    }

    public int numberSplit(String input) { //splits the input at the number
        String theNumber = input.substring(1, 2);
        int number = Integer.parseInt(theNumber);
        return number;
    }

    //creates the board
    public String theBoard() {
        System.out.println(HEADER_ROW);

        for (int i = 0; i < ROWS; i++) {
            System.out.println(FOOTER_ROW);
            if (i < ROWS - 1) {
                System.out.print("     " + (i + 1) + "      ");
                System.out.println(theBoardArray);
                System.out.println(COL_SPLIT);
            } else {
                System.out.print("     " + (i + 1) + "     ");
                System.out.println(COL_SPLIT);
            }
        }
        System.out.println(FOOTER_ROW);
        return "";
    }

}
