package com.demoqa.automation.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SpecialMethods {

    public static Properties properties;

    public static void confProperties(){
        properties = new Properties();
        try {
            //properties.load(new FileReader("conf.properties"));
            properties.load(new FileReader("C:\\SQASCREENPLAY\\conf.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
