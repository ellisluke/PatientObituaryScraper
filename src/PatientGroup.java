import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;
import java.io.FileNotFoundException;   
import org.apache.poi.ss.usermodel.*;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;  

public class PatientGroup {

    private int nameCol = 0;
    private int ageCol = 2;
    private int dateCol = 1;
    private int employCol = 3;
    

    public static String filePath = "Users/lukeellis/Desktop/CSProjects/ObituaryScraper/ObituaryScraper/~$testbook.xlsx";

    /**
     * Constructor
     * 
     * @param sheetPath = a file path to the excel spreadsheet
     * @param nameC     = An excel column name e.g. "AA", "G"
     * @param ageC      = An excel column name e.g. "AA", "G"
     * @param dateC     = An excel column name e.g. "AA", "G"
     * @param employC   = An excel column name e.g. "AA", "G"
     */
    public PatientGroup(String sheetPath, String nameC, String ageC, String dateC, String employC) {
        filePath = sheetPath;
        // user entered identifiable column numbers
        nameCol = convertCol(nameC);
        ageCol = convertCol(ageC);
        dateCol = convertCol(dateC);
        employCol = convertCol(employC);

        constructSheet();
    }

    /**
     * Converts column char to int.
     * 
     * @param col a string with the Column values
     * @return the number column of the sheet MUST account for double and triple
     *         etc. AA BB AAA BBB 65 is ASCII value for A Index at 0
     * 
     *         TESTED: working
     */
    private int convertCol(String col) {
        // get first char
        // convert ascii value
        // add 26 * ( string length - 1)
        int result = col.charAt(0) - 65;
        result += 26 * (col.length() - 1);
        return result;
    }

    public static FileInputStream stream;
    public static HSSFWorkbook wb;

    /** Creates the necessary connections to an excel spreadsheet */
    private static void constructSheet() {

        try {
            stream = new FileInputStream(new File(filePath));
            wb = new HSSFWorkbook(stream);
        }
        catch (FileNotFoundException e) {
            System.out.println("This file does not exist!");
        }
        catch (IOException e1) {
            System.out.println("IO exception!");
        }
    }


}