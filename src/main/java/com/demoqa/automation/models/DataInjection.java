package com.demoqa.automation.models;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataInjection {
    Faker faker = new Faker(new Locale("en-US"));


    private String firstName, lastName, email, numberMobile,  subjects, currentAddress, state, city, extensionSubmittingForm, uploadPicture, date, filepath, sheetName, sheetNameValidation;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getNumberMobile() {
        return numberMobile;
    }

   /* public String getDate() {
        return date;
    }

    public String getSubjects() {
        return subjects;
    }

    public String getUploadPicture() {
        return uploadPicture;
    }
*/
    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getExtensionSubmittingForm() {
        return extensionSubmittingForm;
    }

    public String getFilepath() {
        return filepath;
    }

    public String getSheetName() {
        return sheetName;
    }

    public String getSheetNameValidation() {
        return sheetNameValidation;
    }

    public DataInjection() {

        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.numberMobile = Integer.toString(faker.number().numberBetween(1000000000,1999999999));
        this.currentAddress = faker.address().fullAddress();
        this.subjects = "Arts";
        this.state = "NCR";
        this.city = "Delhi";
        this.extensionSubmittingForm = "Thanks for submitting the form";
        this.uploadPicture = "C:\\SQASCREENPLAY\\FB_IMG_1606176054106.jpg";
        this.date = "01 Feb 1999";
        //this.filepath = "resources/Datos.xlsx";
        this.filepath = "C:\\SQASCREENPLAY\\Datos.xlsx";
        this.sheetName = "Datos";
        this.sheetNameValidation = "Validacion";

    }
}
