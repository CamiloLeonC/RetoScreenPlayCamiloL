package com.demoqa.automation.tasks;

import com.demoqa.automation.questions.GetTextQuestion;
import com.demoqa.automation.ui.RegisterNewUserPage;
import com.demoqa.automation.utils.SpecialMethods;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RegisterValidationWithConfProperties implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        SpecialMethods.confProperties();
        actor.should(
                seeThat(GetTextQuestion.in(RegisterNewUserPage.VALIDATION_OF_SUBMITTING_FORM),equalToIgnoringCase(SpecialMethods.properties.getProperty("Validation")))
        );
    }

    public static RegisterValidationWithConfProperties validationWithConfProperties(){
        return instrumented(RegisterValidationWithConfProperties.class);
    }
}
