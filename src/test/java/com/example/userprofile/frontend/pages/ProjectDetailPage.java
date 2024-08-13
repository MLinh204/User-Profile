package com.example.userprofile.frontend.pages;

import com.example.userprofile.frontend.objects.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProjectDetailPage {
    private WebDriver driver;
    private Elements elements;

    public ProjectDetailPage(WebDriver driver){
        this.driver = driver;
        this.elements = new Elements(driver);
        PageFactory.initElements(driver, this);
    }
    public void clickEditProfile(){
        elements.getEditProfileBtn().click();
    }
    public void clickBackToUserProfile(){
        elements.getBackToProfileBtn().click();
    }
}
