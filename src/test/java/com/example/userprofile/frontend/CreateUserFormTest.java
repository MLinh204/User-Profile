package com.example.userprofile.frontend;

import com.example.userprofile.frontend.objects.ConfigProperties;
import com.example.userprofile.frontend.pages.CreateUserForm;
import com.example.userprofile.frontend.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateUserFormTest {
    private WebDriver webDriver;
    private CreateUserForm createUserForm;
    private WebDriverWait wait;

    private HomePage homePage;


    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        createUserForm = new CreateUserForm(webDriver);
    }
    @AfterEach
    public void tearDown(){
        if(webDriver != null){
            webDriver.quit();
        }
    }
    @Test
    public void createUserProfileSuccess()  {
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        homePage.navigateTo();
        homePage.clickCreateUser();
        createUserForm.createAUser("J1", "30", "SE", "5", "example");
        wait.until(ExpectedConditions.urlToBe(ConfigProperties.BASE_URL));
        WebElement newUserElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='J1']")));
        assertTrue(newUserElement.isDisplayed());
        homePage.clickDeleteBtn("J1");
    }
    @Test
    public void nameIsRequired(){
        homePage.navigateTo();
        homePage.clickCreateUser();
        createUserForm.createAUser("", "30", "SE", "5", "example");
        assertEquals(ConfigProperties.CREATE_USER_URL, webDriver.getCurrentUrl());
    }
    @Test
    public void ageIsRequired(){
        homePage.navigateTo();
        homePage.clickCreateUser();
        createUserForm.createAUser("J1", "", "SE", "5", "example");
        assertEquals(ConfigProperties.CREATE_USER_URL, webDriver.getCurrentUrl());
    }
    @Test
    public void positionIsRequired(){
        homePage.navigateTo();
        homePage.clickCreateUser();
        createUserForm.createAUser("J1", "30", "", "5", "example");
        assertEquals(ConfigProperties.CREATE_USER_URL, webDriver.getCurrentUrl());
    }
    @Test
    public void experienceIsRequired(){
        homePage.navigateTo();
        homePage.clickCreateUser();
        createUserForm.createAUser("J1", "30", "SE", "", "example");
        assertEquals(ConfigProperties.CREATE_USER_URL, webDriver.getCurrentUrl());
    }
    @Test
    public void profilePictureIsRequired(){
        homePage.navigateTo();
        homePage.clickCreateUser();
        createUserForm.createAUser("J1", "30", "SE", "5", "");
        assertEquals(ConfigProperties.CREATE_USER_URL, webDriver.getCurrentUrl());
    }
}
