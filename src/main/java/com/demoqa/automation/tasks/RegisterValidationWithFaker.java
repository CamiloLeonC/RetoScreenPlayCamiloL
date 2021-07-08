package com.demoqa.automation.tasks;

import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.questions.GetTextQuestion;
import com.demoqa.automation.ui.RegisterNewUserPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;


public class RegisterValidationWithFaker implements Task {

    DataInjection dataInjection = new DataInjection();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.should(
                seeThat(GetTextQuestion.in(RegisterNewUserPage.VALIDATION_OF_SUBMITTING_FORM),equalToIgnoringCase(dataInjection.getExtensionSubmittingForm()))
        );

    }

    public static RegisterValidationWithFaker validationWithFaker(){
        return instrumented(RegisterValidationWithFaker.class);
    }
}
