package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {
    public static Iterator<User> readCSVFile(String filename) {
        File csvFile = new File(System.getProperty("user.dir") + "\\testData\\" + filename);
        FileReader csvFileReader;
        CSVReader csvReader;
        String[] line;
        User userData;
        List<User> userList = new ArrayList<>();

        try {
            csvFileReader = new FileReader(csvFile);
            csvReader = new CSVReader(csvFileReader);
            csvReader.readNext();//Skipping first row

            while ((line = csvReader.readNext()) != null) {
                userData = new User(line[0], line[1]);
                userList.add(userData);
            }
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
        return userList.iterator();

    }


}
