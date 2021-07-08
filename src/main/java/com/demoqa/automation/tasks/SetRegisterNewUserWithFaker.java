package com.demoqa.automation.tasks;

import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.ui.RegisterNewUserPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SetRegisterNewUserWithFaker implements Task {

    DataInjection dataInjection = new DataInjection();

    @Override

    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                Enter.theValue(dataInjection.getFirstName()).into(RegisterNewUserPage.FIRST_NAME_INPUT),
                Enter.theValue(dataInjection.getLastName()).into(RegisterNewUserPage.LAST_NAME_INPUT),
                Enter.theValue(dataInjection.getEmail()).into(RegisterNewUserPage.USER_EMAIL_INPUT),
                JavaScriptClick.on(RegisterNewUserPage.GENDER_RADIO_INPUT),
                Enter.theValue(dataInjection.getNumberMobile()).into(RegisterNewUserPage.USER_NUMBER_INPUT),
                Enter.keyValues(Keys.CONTROL+Keys.chord("a")).into(RegisterNewUserPage.DATE_OF_BIRTH_INPUT),
                Enter.keyValues("1 Feb 1999").into(RegisterNewUserPage.DATE_OF_BIRTH_INPUT),
                Hit.the(Keys.ENTER).into(RegisterNewUserPage.DATE_OF_BIRTH_INPUT),
                Enter.keyValues("Arts").into(RegisterNewUserPage.SUBJECTS_CONTAINER_LIST),
                Hit.the(Keys.ENTER).into(RegisterNewUserPage.SUBJECTS_CONTAINER_LIST),
                JavaScriptClick.on(RegisterNewUserPage.HOBBIES_CHECK_BOX),
                Scroll.to(RegisterNewUserPage.SUBMIT_BUTTON),
                Enter.keyValues("C:\\SQASCREENPLAY\\FB_IMG_1606176054106.jpg").into(RegisterNewUserPage.UPLOAD_PICTURE_INPUT),
                Enter.theValue(dataInjection.getCurrentAddress()).into(RegisterNewUserPage.CURRENT_ADDRESS_INPUT),
                Enter.keyValues("NCR").into(RegisterNewUserPage.STATE_INPUT),
                Hit.the(Keys.ENTER).into(RegisterNewUserPage.STATE_INPUT),
                Enter.keyValues("Delhi").into(RegisterNewUserPage.CITY_INPUT),
                Hit.the(Keys.ENTER).into(RegisterNewUserPage.CITY_INPUT),
                JavaScriptClick.on(RegisterNewUserPage.SUBMIT_BUTTON),
                WaitUntil.the(RegisterNewUserPage.VALIDATION_OF_SUBMITTING_FORM,isVisible()),
                Scroll.to(RegisterNewUserPage.CLOSE_BUTTON),
                WaitUntil.the(RegisterNewUserPage.CLOSE_BUTTON,isVisible())
               // JavaScriptClick.on(RegisterNewUserPage.CLOSE_BUTTON)

                );
        //as (actor) .getDriver (). navigate (). refresh ();
    }



    public static SetRegisterNewUserWithFaker successful(){
        return instrumented(SetRegisterNewUserWithFaker.class);
    }

}
