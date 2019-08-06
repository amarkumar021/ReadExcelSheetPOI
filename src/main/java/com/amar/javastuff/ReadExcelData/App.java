package com.amar.javastuff.ReadExcelData;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws EncryptedDocumentException, InvalidFormatException, IOException
    {
        System.out.println( "App Started..." );
        ReadExcelDataService readExcelDataService = new ReadExcelDataService();
        readExcelDataService.readData();
    }
}
