package com.demoqa.automation.utils;

import com.demoqa.automation.ui.RegisterNewUserPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenShot {


    public Performable captureScreen(Target target) throws IOException {
        String path;

        File scrFile = ((TakesScreenshot)RegisterNewUserPage.VALIDATION_OF_SUBMITTING_FORM).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\camil\\Documents\\ScreenShot\\Prueba.png"));
        return null;
    }


    
}
