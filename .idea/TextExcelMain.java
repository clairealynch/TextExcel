/**
 * Created by bal_calynch on 3/2/2016.
 */
import java.util.Scanner;

public class TextExcelMain {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean stillGoing = true;

        System.out.println("Welcome to TextExcel!");
        String instructions = "To print the board, enter print. Type help to repeat instructions, and exit to quit program.";
        System.out.println(instructions);//make this a method within this class?

        while (stillGoing) {
            System.out.println("Command: ");

            String userInput = in.nextLine();
            //String userInput = "A3 = (4.0 + 5.9)";
            boolean notDone = true;
            Board board = new Board();
            Cell cell = new Cell();

            //should the split of the input be up here? would help with clarity of print/clear/etc. commands?
            //can't work right now with the clear/print commands bc they aren't set up like: "xx = clear", needs to accept "clear" etc.


            while (notDone) {
                if (userInput.toLowerCase().contains("print")) { //if user types in print
                    board.theBoard(); //prints board
                    notDone = false;

                }
                else if (userInput.toLowerCase().contains("exit")) { //if user types in exit
                    System.out.println("Goodbye!");
                    notDone = false;
                    stillGoing = false;
                }
                else if (userInput.toLowerCase().contains("help")) { //if user types in help
                    System.out.println(instructions);
                    notDone = false;
                }
                else if (userInput.toLowerCase().contains("clear") && !userInput.toLowerCase().contains("\"clear\"")){
                    //if it contains clear for a specified cell value, clear indv cell
                    //else if it contains clear with no specified cell value, clear whole board

                    System.out.println("Contains clear.");
                    userInput=null;//??
                    notDone= false;
                }
                else if (userInput.contains("=")){ //else if the user inputs a specified row/col
                    //cant have it set equal to 2, bc can have A10, etc.- also need it to ignore letters beyond G

                    String leftSide = cell.cellSplit(userInput);
                    String preRightSide = cell.inputSplit(userInput);
                    Cell rightSide = cell.makeCell(preRightSide);
                    System.out.println("Left side is: " + leftSide.toUpperCase());
                    System.out.println("Right side is: " + rightSide);


                    if (leftSide.length() == 2 || leftSide.contains("10")) {  //the cell position input length is equal to 2 and number is less than 10
                            //Gets the cell value, before the equals sign
                        String letter = board.letterSplit(leftSide);
                        int number = board.numberSplit(leftSide);
                        int firstArrayNumber = board.convertToNumber(letter);
                        int secondArrayNumber = board.convertNumToNum(number);
                        String theArrayPosition = firstArrayNumber + "" + secondArrayNumber;
                        System.out.println("The position of the cell in the array is: " + theArrayPosition);
                        //right now, because I've split up the left and right side, content isn't connecting to the specified cell

                        String contents = board.getValue(firstArrayNumber, secondArrayNumber); //gets the contents of the cell
                       // String contents2 = board.getValue(board.theBoardArray[firstArrayNumber][secondArrayNumber]);
                        System.out.println(board.theBoardArray[firstArrayNumber][secondArrayNumber]= rightSide);
                        //System.out.println(board.theBoardArray[firstArrayNumber][secondArrayNumber]);


                        System.out.println("Contents: " + contents);
                       // System.out.println(userInput + " = " + cell.getCell(contents));




                    }

                    //split into two sections - so the input of "A7 = "hello"" would split into A7, and the input

                    //DEALING with the Cell position

                        //= cell.makeCell(rightSide);
                       //set the value in the array?
                    // board.theBoardArray[firstNumber][convertedNum]; //should set the type of the cell
                              //cell.makeCell(rightSide);

                   // else if (/*the cell position input length is not equal to 2, letter goes beyond G, or number higher than 10*/){
                        //System.out.println("Invalid input.");
                        //notDone = false;
                    //}

                    //cell.makeCell(rightSide);

                    //DEALING with the user cell input
                    //gets the user input, after the equals sign
                   /* if (inputPos.contains("(") && userInput.contains(")")){
                        System.out.println("Input is of FormulaCell type.");
                        //input is of FormulaCell type
                    }
                    if (inputPos.contains("")){
                        System.out.println("Input is of StringCell type.");
                        //if it contains quotations, input is of StringCell type
                    }
                    if (inputPos.contains()){
                        //if user input is a number, input is of DoubleCell type
                        //input is a number if the input can be parsed by Double.parseDouble(String)
                    }*/

                    notDone = false;
                }
                else if (userInput.length() != 2) {
                    System.out.println("Invalid input.");
                    notDone = false;
                }


            }
        }

    }

}
