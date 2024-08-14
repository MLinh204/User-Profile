package com.example.userprofile.frontend.pages;

import com.example.userprofile.frontend.objects.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddProjectForm {
    private WebDriver driver;
    private Elements elements;
    private WebDriverWait wait;
    public AddProjectForm(WebDriver driver){
        this.driver = driver;
        this.elements = new Elements(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
