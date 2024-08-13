package com.example.userprofile.frontend.pages;

import com.example.userprofile.frontend.objects.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddProjectForm {
    private WebDriver driver;
    private Elements elements;
    public AddProjectForm(WebDriver driver){
        this.driver = driver;
        this.elements = new Elements(driver);
        PageFactory.initElements(driver, this);
    }
    public void createProject(String name, String description,String technologies,String position){
        elements.getProjectNameField().sendKeys(name);
        elements.getProjectDescriptionField().sendKeys(description);
        elements.getProjectTechnologiesField().sendKeys(technologies);
        elements.getUserPositionField().sendKeys(position);
        elements.getSubmitProjectButton().click();
    }
}
