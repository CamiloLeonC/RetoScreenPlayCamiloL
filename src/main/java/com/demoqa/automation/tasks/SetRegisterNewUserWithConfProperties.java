package com.demoqa.automation.tasks;

import com.demoqa.automation.ui.RegisterNewUserPage;
import com.demoqa.automation.utils.SpecialMethods;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SetRegisterNewUserWithConfProperties implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        SpecialMethods.confProperties();
        actor.attemptsTo(
                Enter.theValue(SpecialMethods.properties.getProperty("First")).into(RegisterNewUserPage.FIRST_NAME_INPUT),
                Enter.theValue(SpecialMethods.properties.getProperty("Last")).into(RegisterNewUserPage.LAST_NAME_INPUT),
                Enter.theValue(SpecialMethods.properties.getProperty("Email")) .into(RegisterNewUserPage.USER_EMAIL_INPUT),
                JavaScriptClick.on(RegisterNewUserPage.GENDER_RADIO_INPUT),
                //Enter.keyValues(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,3)).into(RegisterNewUserPage.USER_NUMBER_INPUT),
                //Enter.keyValues(Integer.(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,3))).into(RegisterNewUserPage.USER_NUMBER_INPUT),
                Enter.theValue(SpecialMethods.properties.getProperty("Mobile")).into(RegisterNewUserPage.USER_NUMBER_INPUT),
                Enter.keyValues(Keys.CONTROL+Keys.chord("a")).into(RegisterNewUserPage.DATE_OF_BIRTH_INPUT),
                Enter.keyValues(SpecialMethods.properties.getProperty("Date")).into(RegisterNewUserPage.DATE_OF_BIRTH_INPUT),
                Hit.the(Keys.ENTER).into(RegisterNewUserPage.DATE_OF_BIRTH_INPUT),

                //Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,5)) .into(RegisterNewUserPage.SUBJECTS_CONTAINER_LIST),
                Scroll.to(RegisterNewUserPage.SUBJECTS_CONTAINER_LIST),

                Enter.keyValues(SpecialMethods.properties.getProperty("Subject")).into(RegisterNewUserPage.SUBJECTS_CONTAINER_LIST),
                Hit.the(Keys.ARROW_DOWN).into(RegisterNewUserPage.SUBJECTS_CONTAINER_LIST),
                Hit.the(Keys.ENTER).into(RegisterNewUserPage.SUBJECTS_CONTAINER_LIST),
                JavaScriptClick.on(RegisterNewUserPage.HOBBIES_CHECK_BOX),
                Enter.keyValues(SpecialMethods.properties.getProperty("Picture")) .into(RegisterNewUserPage.UPLOAD_PICTURE_INPUT),
                Enter.theValue(SpecialMethods.properties.getProperty("Address")) .into(RegisterNewUserPage.CURRENT_ADDRESS_INPUT),

                Enter.keyValues(SpecialMethods.properties.getProperty("State")).into(RegisterNewUserPage.STATE_INPUT),
                Hit.the(Keys.ARROW_DOWN).into(RegisterNewUserPage.STATE_INPUT),
                Hit.the(Keys.ENTER).into(RegisterNewUserPage.STATE_INPUT),
                Enter.keyValues(SpecialMethods.properties.getProperty("City")).into(RegisterNewUserPage.CITY_INPUT),
                Hit.the(Keys.ARROW_DOWN).into(RegisterNewUserPage.CITY_INPUT),
                Hit.the(Keys.ENTER).into(RegisterNewUserPage.CITY_INPUT),


                JavaScriptClick.on(RegisterNewUserPage.SUBMIT_BUTTON),
                WaitUntil.the(RegisterNewUserPage.VALIDATION_OF_SUBMITTING_FORM,isVisible())
                //Scroll.to(RegisterNewUserPage.CLOSE_BUTTON),
                //WaitUntil.the(RegisterNewUserPage.CLOSE_BUTTON,isVisible()),
                //JavaScriptClick.on(RegisterNewUserPage.CLOSE_BUTTON)
                //Enter.keyValues(ScreenShot.)

        );
    }
    public static SetRegisterNewUserWithConfProperties dataInjectionConfProperties(){
        return instrumented(SetRegisterNewUserWithConfProperties.class);
    }
}
