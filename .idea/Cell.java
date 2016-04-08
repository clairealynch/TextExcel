/**
 * Created by bal_calynch on 3/2/2016.
 */
public class Cell {

    //eventually be able to return "<empty>" when certain cell is input

    protected String theCell;
    protected int number;
    protected String letter;
    protected int length; //length of the cell (always equal to 12)
    private String contents;


    public Cell(String x){ //parse the user input- such as "A3", into "A" and "3"

       /* String column = theCell.substring(0, 1);
        String row = theCell.substring(1);
        int theRow = Integer.parseInt(row);
        number = theRow;
        letter = column;*/

           // theCell = (column, row);
    }

    public Cell(){

    }

    public String toString(){
        return contents;
    }

    public String getCell(String theContents){ //input/*String letter, int number*/){
        if (theContents == null){
            theContents = "<empty>";
        }
        else {
            theContents = "something";
        }
        return theContents;
    }

    public String cellSplit(String contents){
        String cellPos = contents.substring(0, contents.indexOf("=")-1);
       // System.out.println("The cell value is: " + cellPos);
        return cellPos;
    }
    public String inputSplit(String contents){
        String inputPos = contents.substring(contents.indexOf("=")+1, contents.length());
        //System.out.println("The input value is: " + inputPos);
        return inputPos;
    }

    public Cell makeCell(String input) {
        if (input.contains("\"") && input.contains("\"")) {//StringCell
            String theString = input.substring(input.indexOf("\"")+1, input.lastIndexOf("\"")); //removes extra spaces and quotations in the String
            StringCell theStringCell = new StringCell(theString);
            return theStringCell;
        }
        else if (input.contains("(") && input.contains(")")) { //FormulaCell
            String theFormula = input.substring(input.indexOf("("), input.lastIndexOf(")")+1); //removes extra spaces
            FormulaCell theFormulaCell = new FormulaCell(theFormula);
            return theFormulaCell;
        }
        else {//DoubleCell
            //shouldn't be just else, because other values don't fall in any of these three categories
            double theInput = Double.parseDouble(input);
            DoubleCell theDoubleCell = new DoubleCell(theInput);
            return theDoubleCell;


        }
     //have this method go into the Form/Doub/String cell classes if the input matches certain aspects of the classes
        //reach this from the Main class
    }




}
