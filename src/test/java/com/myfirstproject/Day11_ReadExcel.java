package com.myfirstproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day11_ReadExcel {

    @Test
public void readExcel() throws IOException {
        String path = "./src/test/java/resources/Capitals.xlsx";
//        Open the file
        FileInputStream fileInputStream = new FileInputStream(path);
//        Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);
//        Open the first worksheet
        Sheet sheet1 = workbook.getSheetAt(0);
//        Go to first row
        Row row1 = sheet1.getRow(0);
//        Go to first cell on that first row and print
        Cell cell1 = row1.getCell(0);
        System.out.println(cell1);
//        Go to second cell on that first row and print
        Cell cell2 = row1.getCell(1);
        System.out.println(cell2.toString());
//        Go to 2nd row first cell  and assert if the data equal to USA
        String row2Cell1 = sheet1.getRow(1).getCell(0).toString();
        System.out.println(row2Cell1);
        Assert.assertEquals("USA", row2Cell1);
//        Go to 3rd row 2nd cell-chain the row and cell
        String row3Cell2 = sheet1.getRow(2).getCell(1).toString();
        System.out.println(row3Cell2);
//        Find the number of row
        int lastRowNum = sheet1.getLastRowNum() + 1; //Index starts from 0 , so add 1 to match row number
        System.out.println(lastRowNum);
//        Find the number of used row
        int numOfUsedRow = sheet1.getPhysicalNumberOfRows(); // no need to add 1 to match, because index start from 1
        System.out.println(numOfUsedRow);
//        Print country, capitol key value pairs as map object
        Map<String,String> countryCapitals =new HashMap<>();
        for(int rowNumber =1; rowNumber<lastRowNum;rowNumber++){
                //            usa     = sheet1.getRow(1).getCell(0);
//            france  = sheet1.getRow(2).getCell(0);
//            england = sheet1.getRow(3).getCell(0);
//            turkey  = sheet1.getRow(4).getCell(0);
//            D.C     = sheet1.getRow(1).getCell(1);
//            paris   = sheet1.getRow(2).getCell(1);
//            london  = sheet1.getRow(3).getCell(1);
//            ankara  = sheet1.getRow(4).getCell(1);
                //We use this pattern to get countries and capitals
                String countries = sheet1.getRow(rowNumber).getCell(0).toString();
                String capitals  = sheet1.getRow(rowNumber).getCell(1).toString();
//                System.out.println("Countries : "+countries);
//                System.out.println("Capitals  : "+capitals);

                //Map put function is used to add key value pains inside the map
                countryCapitals.put(countries,capitals);

        }
            System.out.println("countryCapitals = " + countryCapitals);


    }
}