package com.example.userprofile.frontend.pages;

import com.example.userprofile.frontend.objects.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateUserForm {

    private WebDriver webDriver;
    private Elements elements;


    public CreateUserForm(WebDriver driver){
        this.webDriver = driver;
        this.elements = new Elements(driver);
        PageFactory.initElements(driver, this);
    }

    public void createAUser(String name, String age, String position, String yearOfExperience, String profilePicture){
        elements.getNameField().sendKeys(name);
        elements.getAgeField().clear();
        elements.getAgeField().sendKeys(age);
        elements.getPositionField().sendKeys(position);
        elements.getYOEField().clear();
        elements.getYOEField().sendKeys(yearOfExperience);
        elements.getProfilePictureField().sendKeys(profilePicture);
        elements.getSubmitUserButton().click();
    }
}
