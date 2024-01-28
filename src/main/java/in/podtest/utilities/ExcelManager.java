package in.podtest.utilities;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelManager {

   // private static final String propertyFilePath= "src\\main\\resources\\file.xlsx";

    static String filePath = "src\\main\\resources\\TestData.xlsx";

    public static Object[][] readData1() throws IOException {

       File testDataFile = new File(filePath);

       FileInputStream fileInput = new FileInputStream(testDataFile);


       //apache poi
        XSSFWorkbook workbook = new XSSFWorkbook(fileInput);

       XSSFSheet sheet = workbook.getSheetAt(0);// login

       XSSFRow row =  sheet.getRow(0);
       int rowCount = sheet.getLastRowNum();  //2
        int actualRowCount = rowCount+1;

       int colCount = row.getLastCellNum();

        System.out.println("Row is"+ actualRowCount);
        System.out.println("Column is"+colCount);

       //Rows 3 , each row 2 columns, 2*2

        Object[][] loginData = new Object[rowCount][colCount];  //2*2

       for (int r = 0; r< rowCount; r++) {  //2
           for(int c =0 ; c <colCount; c++) {  //2

               //r=0, c=0 ==> Arry 0,0   <-- 1,0 excel
               //r=0, c=1 ==> Arry 0,1   <-- 1,1 excel
               //r=1, c=0 ==> Arry 1,0   <-- 2,0 excel
               //r=1, c=1 ==> Arry 1,1   <-- 2,1 excel
               //read from apache poi
               loginData[r][c] = sheet.getRow(r+1).getCell(c).toString(); //0,0   <-- 1,2
           }
       }

        System.out.println("Print the test Data");
       for (int i = 0 ; i< rowCount; i ++) {
           for (int j= 0; j <colCount; j++) {
               System.out.println(loginData[i][j]);
           }
       }

        workbook.close();
        fileInput.close();
        testDataFile = null;

        return loginData;

       //Animal --> Dog, Cat
        //Animal a1 = new Dog();
        //Object o1 = new String();




    }


    public static void main(String[] args) throws IOException {
        ExcelManager.readData1();
    }
/*
    public static Object[][] readData() throws IOException {
        File file = new File(propertyFilePath);
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheetAt(0);

        int[][] a1 = new int[2][2];

        a1[0][1] = 50;


        int rowCount = sheet.getLastRowNum();  //0 based  1: 0 , 1
        int colCount = sheet.getRow(0).getLastCellNum(); //1 based

        //  System.out.println(rowCount);
        //  System.out.println(colCount);

        Object [][] dataObject = new Object[rowCount+1][colCount];

        for(int x =0; x <rowCount+1; x++) {
            for(int y =0; y < colCount; y++) {
                dataObject[x][y] = sheet.getRow(x).getCell(y).toString(); // here cell is 0 based
            }
        }


        workbook.close();
        fis.close();

        return dataObject;


        for(int x =0; x <rowCount+1; x++) {
            for(int y =0; y < colCount; y++) {

                System.out.print(dataObject[x][y] + "\t");
            }
            System.out.println();
        }

        for (Row row : sheet) {
            for (Cell cell : row) {

                System.out.print(cell.getStringCellValue() + "\t");
            }
            System.out.println();
        }


        if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
        {
            System.out.print(cell.getStringCellValue()+" ");
        }
        else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
        {
            System.out.print(cell.getNumericCellValue()+" ");
        }
        else
        {
        }


    }
*/


}
