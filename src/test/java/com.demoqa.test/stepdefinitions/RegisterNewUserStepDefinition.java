package com.demoqa.test.stepdefinitions;

import com.demoqa.automation.interactions.OpenTheBrowser;
import com.demoqa.automation.tasks.*;
import com.demoqa.automation.ui.RegisterNewUserPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegisterNewUserStepDefinition {

    @Managed
    private WebDriver driver;


    @Before
    public void actorSetUp(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Camilo").can(BrowseTheWeb.with(driver));
    }

    @Given("^That a web user i want to register in the form$")
    public void thatAWebUserIWantToRegisterInTheForm() {
        theActorInTheSpotlight().attemptsTo(OpenTheBrowser.on(RegisterNewUserPage.URL));
    }


    @When("^fill all the requested fields in the form with faker$")
    public void fillAllTheRequestedFieldsInTheFormWithFaker() throws IOException {
        theActorInTheSpotlight().attemptsTo(SetRegisterNewUserWithFaker.successful());

    }

    @When("^fill all the requested fields in the form with Excel$")
    public void fillAllTheRequestedFieldsInTheFormWithExcel() {
        theActorInTheSpotlight().attemptsTo(SetRegisterNewUserWithExcel.dataInjectionSheet());

    }

    @When("^fill all the requested fields in the form with conf properties$")
    public void fillAllTheRequestedFieldsInTheFormWithConfProperties() {
        theActorInTheSpotlight().attemptsTo(SetRegisterNewUserWithConfProperties.dataInjectionConfProperties());

    }

    @Then("^we can see the form with our information with faker$")
    public void weCanSeeTheFormWithOurInformationWithFaker() {
        theActorInTheSpotlight().attemptsTo(RegisterValidationWithFaker.validationWithFaker());

    }

    @Then("^we can see the form with our information with Excel$")
    public void weCanSeeTheFormWithOurInformationWithExcel() {
        theActorInTheSpotlight().attemptsTo(RegisterValidationWithExcel.validationWithExcel());

    }
    @Then("^we can see the form with our information with conf properties$")
    public void weCanSeeTheFormWithOurInformationWithConfProperties() {
        theActorInTheSpotlight().attemptsTo(RegisterValidationWithConfProperties.validationWithConfProperties());

    }
}
