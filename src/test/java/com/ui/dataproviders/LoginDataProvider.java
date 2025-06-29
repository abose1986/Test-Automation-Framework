package com.ui.dataproviders;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider(){
        Gson gson = new Gson();
        File testDatafile = new File(System.getProperty("user.dir")+"\\testData\\loginData.json");
        FileReader fileReader;
        try{
            fileReader = new FileReader(testDatafile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        TestData testData = gson.fromJson(fileReader, TestData.class);
        List<Object[]> dataToReturn = new ArrayList<>();
        for (User user : testData.getData()){
            dataToReturn.add(new Object[]{user});
        }
        return dataToReturn.iterator();
    }

}
