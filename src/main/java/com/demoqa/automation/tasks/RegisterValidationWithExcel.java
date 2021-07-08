package com.demoqa.automation.tasks;

import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.questions.GetTextQuestion;
import com.demoqa.automation.ui.RegisterNewUserPage;
import com.demoqa.automation.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.io.IOException;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class RegisterValidationWithExcel implements Task {

    DataInjection dataInjection = new DataInjection();

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.should(
                    seeThat(GetTextQuestion.in(RegisterNewUserPage.VALIDATION_OF_SUBMITTING_FORM),equalToIgnoringCase(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetNameValidation(),0,0)))
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static RegisterValidationWithExcel validationWithExcel(){
        return instrumented(RegisterValidationWithExcel.class);
    }
}
