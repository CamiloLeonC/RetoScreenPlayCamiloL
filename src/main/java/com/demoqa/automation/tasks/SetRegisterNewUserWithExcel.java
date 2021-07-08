package com.demoqa.automation.tasks;

import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.ui.RegisterNewUserPage;
import com.demoqa.automation.utils.Excel;
import com.demoqa.automation.utils.ScreenShot;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import java.io.IOException;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SetRegisterNewUserWithExcel implements Task {

    DataInjection dataInjection = new DataInjection();
    ScreenShot screenShot = new ScreenShot();

    @Override
  public <T extends Actor> void performAs(T actor) {
      try {
          actor.attemptsTo(
                  Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,0)).into(RegisterNewUserPage.FIRST_NAME_INPUT),
                  Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,1)).into(RegisterNewUserPage.LAST_NAME_INPUT),
                  Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,2)) .into(RegisterNewUserPage.USER_EMAIL_INPUT),
                  JavaScriptClick.on(RegisterNewUserPage.GENDER_RADIO_INPUT),
                  //Enter.keyValues(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,3)).into(RegisterNewUserPage.USER_NUMBER_INPUT),
                  //Enter.keyValues(Integer.(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,3))).into(RegisterNewUserPage.USER_NUMBER_INPUT),
                  Enter.theValue(dataInjection.getNumberMobile()).into(RegisterNewUserPage.USER_NUMBER_INPUT),
                  Enter.keyValues(Keys.CONTROL+Keys.chord("a")).into(RegisterNewUserPage.DATE_OF_BIRTH_INPUT),
                  Enter.keyValues(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,4)).into(RegisterNewUserPage.DATE_OF_BIRTH_INPUT),
                  Hit.the(Keys.ENTER).into(RegisterNewUserPage.DATE_OF_BIRTH_INPUT),

                  //Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,5)) .into(RegisterNewUserPage.SUBJECTS_CONTAINER_LIST),
                  Scroll.to(RegisterNewUserPage.SUBJECTS_CONTAINER_LIST),

                  Enter.keyValues(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,5)).into(RegisterNewUserPage.SUBJECTS_CONTAINER_LIST),
                  Hit.the(Keys.ARROW_DOWN).into(RegisterNewUserPage.SUBJECTS_CONTAINER_LIST),
                  Hit.the(Keys.ENTER).into(RegisterNewUserPage.SUBJECTS_CONTAINER_LIST),
                  JavaScriptClick.on(RegisterNewUserPage.HOBBIES_CHECK_BOX),
                  Enter.keyValues(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,6)) .into(RegisterNewUserPage.UPLOAD_PICTURE_INPUT),
                  Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,7)) .into(RegisterNewUserPage.CURRENT_ADDRESS_INPUT),

                  Enter.keyValues(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,8)).into(RegisterNewUserPage.STATE_INPUT),
                  Hit.the(Keys.ARROW_DOWN).into(RegisterNewUserPage.STATE_INPUT),
                  Hit.the(Keys.ENTER).into(RegisterNewUserPage.STATE_INPUT),
                  Enter.keyValues(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,9)).into(RegisterNewUserPage.CITY_INPUT),
                  Hit.the(Keys.ARROW_DOWN).into(RegisterNewUserPage.CITY_INPUT),
                  Hit.the(Keys.ENTER).into(RegisterNewUserPage.CITY_INPUT),

                  JavaScriptClick.on(RegisterNewUserPage.SUBMIT_BUTTON),
                  WaitUntil.the(RegisterNewUserPage.VALIDATION_OF_SUBMITTING_FORM,isVisible())
                  //Scroll.to(RegisterNewUserPage.CLOSE_BUTTON),
                  //WaitUntil.the(RegisterNewUserPage.CLOSE_BUTTON,isVisible())
                  //JavaScriptClick.on(RegisterNewUserPage.CLOSE_BUTTON)
                  // WaitUntil.the(RegisterNewUserPage.VALIDATION_OF_SUBMITTING_FORM,isVisible())
                  //screenShot.captureScreen(RegisterNewUserPage.VALIDATION_OF_SUBMITTING_FORM)

          );

      } catch (IOException e) {
          e.printStackTrace();
      }

  }
    public static SetRegisterNewUserWithExcel dataInjectionSheet(){
        return instrumented(SetRegisterNewUserWithExcel.class);
    }

}
