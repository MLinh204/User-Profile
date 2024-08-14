package com.example.userprofile.frontend.pages;

import com.example.userprofile.frontend.objects.ConfigProperties;
import com.example.userprofile.frontend.objects.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {
    private WebDriver webDriver;

    private WebDriverWait wait;
    private Elements elements;
    private JavascriptExecutor js;

    public HomePage(WebDriver driver){
        this.webDriver = driver;
        this.elements = new Elements(driver);
        this.js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }
    public void navigateTo(){
        webDriver.get(ConfigProperties.BASE_URL);
    }
    public int getUserCount(){
        return elements.getUserContainer().size();
    }
    public void clickLogo(){
        elements.getLogo().click();
    }
    public void clickNavBtn(){
        elements.getNavButton().click();
    }
    public void clickCreateUser(){
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        elements.getCreateUserBtn().click();
        wait.until(ExpectedConditions.urlToBe(ConfigProperties.CREATE_USER_URL));
        assertEquals(ConfigProperties.CREATE_USER_URL, webDriver.getCurrentUrl());
    }
    public void clickViewProfile(String username){
        for(WebElement container : elements.getUserContainer()){
            WebElement nameElement = container.findElement(By.tagName("h2"));
            if(nameElement.getText().equals(username)){
                container.findElement(By.linkText("View Profile")).click();
                break;
            }
        }
    }

    public void clickEditBtn(String username){
        for (WebElement container : elements.getUserContainer()){
            WebElement nameElement = container.findElement(By.tagName("h2"));
            if(nameElement.getText().equals(username)){
                container.findElement(By.linkText("Edit User Profile")).click();
                break;
            }
        }
    }
    public void clickDeleteBtn(String username){
        int currentContainer = getUserCount();
        for (WebElement container : elements.getUserContainer()){
            WebElement nameElement = container.findElement(By.tagName("h2"));
            if(nameElement.getText().equals(username)){
                WebElement deleteBtn = container.findElement(By.linkText("Delete User"));
                js.executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
                deleteBtn.click();
                Alert confirmDialog = wait.until(ExpectedConditions.alertIsPresent());
                confirmDialog.accept();
                wait.until(ExpectedConditions.invisibilityOf(nameElement));

            }
        }
        assertEquals(getUserCount(),currentContainer-1);
    }

}
