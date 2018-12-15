/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kffekko_report.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile 
{
    private String header[];
    private String body[][];
    private String lastFileName = null;
    private String lastSheetName = null;
    
    public ExcelFile(String fileName, String sheetName) throws IOException
    {
        this.setLastFileName(fileName);
        this.setLastSheetName(sheetName);
        FileInputStream inputStream = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        Iterator<Row> rowIterator = sheet.iterator();
        int indexRow = 0;
        List rows = new ArrayList();
        String celValue = "";
        int hight = sheet.getLastRowNum() - sheet.getFirstRowNum();
        XSSFRow firstRow = sheet.getRow(0);
        int length = firstRow.getLastCellNum() - firstRow.getFirstCellNum();
        this.body = new String[hight][length];
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            int indexCell = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                CellType cellType = cell.getCellTypeEnum();
                switch (cellType) {
                case _NONE:
                    celValue = "";
                    break;
                case BOOLEAN:
                    celValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    celValue = "";
                    break;
                case NUMERIC:
                    celValue = String.valueOf(cell.getNumericCellValue());
                    break;
                case STRING:
                    celValue = cell.getStringCellValue();
                    break;
                case ERROR:
                    celValue = "";
                    break;
                }
                this.body[indexRow][indexCell] = celValue;
                indexCell +=1;
            }
            indexRow +=1;
        }
        workbook.close();
        inputStream.close();
        
         /*try {
            file = new FileInputStream(fileName);
            Workbook workbook = Workbook.getWorkbook(file);
            file.close();
                
               try {
                workbook = WorkbookFactory.create(file);
                final Sheet sheet = workbook.getSheet(sheetName);
                } catch (IOException ex) {
                Logger.getLogger(ExcelFile.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidFormatException ex) {
                Logger.getLogger(ExcelFile.class.getName()).log(Level.SEVERE, null, ex);
                } catch (EncryptedDocumentException ex) {
                Logger.getLogger(ExcelFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelFile.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (IOException ex) {
                Logger.getLogger(ExcelFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        */
        /*try
        {
            /*
            
            
            int top = sheet.getFirstRowNum();
            int bottom = sheet.getLastRowNum();
            Row line = sheet.getRow(top);
            int start = line.getFirstCellNum();
            int end = line.getLastCellNum();    
            int length = end - start;*/
            /*while(length == 0)
            {
                top++;
                line = sheet.getRow(top);
                start = line.getFirstCellNum();
                end = line.getLastCellNum();    
                length = end - start;
            }*/
            /*int hight = bottom - top;
            this.header =  new String[length];
            this.body = new String[hight][length];*/
            /*for (int i = 0; i < length; i++)
            {
                header[i] = line.getCell(start + i).getStringCellValue();  
               
            }*/
            
            /*if(sheet != null){
                for (int index = 1; index < hight; index++) 
                {
                    line = sheet.getRow(index);
                    if(line != null){
                        for (int i = 0; i < length; i++)
                        {
                            if(line != null){
                                Cell cellule = line.getCell(i);
                                if(cellule != null){
                                    cellule.setCellType(Cell.CELL_TYPE_STRING);
                                    this.body[index][i] = new String(String.valueOf(cellule.getStringCellValue()).getBytes(), Charset.forName("UTF-8"));
                                    switch (cellule.getCellType())
                                    {
                                        case Cell.CELL_TYPE_STRING : 
                                            this.body[index][i] = new String(String.valueOf(cellule.getStringCellValue()).getBytes(), Charset.forName("UTF-8"));
                                            break;
                                        case Cell.CELL_TYPE_BOOLEAN : 
                                            this.body[index][i] = new String(String.valueOf(cellule.getBooleanCellValue()).getBytes(), Charset.forName("UTF-8"));
                                            break;
                                        default :
                                            this.body[index][i] = new String(String.valueOf(cellule.getNumericCellValue()).getBytes(), Charset.forName("UTF-8"));
                                    }
                                }

                            }

                        }
                    }

                }
            }*/
            
           /* workbook.close();
            file.close();
        }*/
        /* catch (InvalidFormatException | IOException e) 
        {
             e.printStackTrace();
        }*/
    }
    
    public void saveAs(String fileName, String sheetName)
    {
        try 
        {
            if (this.getLastFileName().compareTo(fileName) != 0)
                this.setLastFileName(fileName);
            if (this.getLastSheetName() != sheetName)
                this.setLastSheetName(sheetName);
            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet(sheetName);
            Row row = sheet.createRow(0);
            for(int i = 0; i < this.getHeader().length; i++)
            {
                row.createCell(i).setCellValue(this.getHeader()[i]);
            }
            
            for (int index = 0; index < this.getBody().length; index++)
            {
                row = sheet.createRow(index + 1);
                for (int i = 0; i < this.getBody()[index].length; i++)
                {
                    String valeur = String.valueOf(this.getBody()[index][i]);
                    row.createCell(i).setCellValue(valeur);
                }
            }
            FileOutputStream fileOut = new FileOutputStream(fileName);
            workbook.write(fileOut);
            workbook.close();
            fileOut.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    public void save()
    {
        this.saveAs(this.getLastFileName(), this.getLastSheetName());
    }
    
    public String[] getHeader() 
    {
        return this.header;
    }
    
    public String[][] getBody() 
    {
        return this.body;
    }

    public String getLastFileName() {
        return this.lastFileName;
    }

    private void setLastFileName(String lastFileName) {
        this.lastFileName = lastFileName;
    }

    public String getLastSheetName() {
        return this.lastSheetName;
    }

    private void setLastSheetName(String lastSheetName) {
        this.lastSheetName = lastSheetName;
    }
}