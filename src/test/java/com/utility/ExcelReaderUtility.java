package com.utility;

import com.ui.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {
    public static Iterator<User> readExcelFile(String filename) {
        File excelFile = new File(System.getProperty("user.dir") + "\\testData\\" + filename);
        XSSFWorkbook xssfWorkbook;
        XSSFSheet xssfSheet;
        Iterator<Row> rowIterator;
        Row row;
        Cell emailAddressCell;
        Cell passwordCell;
        List<User> userList = null;
        User user;

        try {
            xssfWorkbook = new XSSFWorkbook(excelFile);
            xssfSheet = xssfWorkbook.getSheet("LoginTestData");
            rowIterator = xssfSheet.iterator();
            rowIterator.next();//Skipping first row
            userList = new ArrayList<>();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                emailAddressCell = row.getCell(0);
                passwordCell = row.getCell(1);
                user = new User(emailAddressCell.toString(), passwordCell.toString());
                userList.add(user);
            }
            xssfWorkbook.close();
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }
        return userList.iterator();
    }
}
