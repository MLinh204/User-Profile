package com.example.userprofile.frontend;

import com.example.userprofile.frontend.objects.Elements;
import com.example.userprofile.frontend.pages.HomePage;
import com.example.userprofile.frontend.pages.ProjectDetailPage;
import com.example.userprofile.frontend.pages.UserDetailPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectDetailPageTest {
    private WebDriver driver;
    private HomePage homePage;
    private ProjectDetailPage projectDetailPage;
    private UserDetailPage userDetailPage;
    private Elements elements;
    private WebDriverWait wait;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        projectDetailPage = new ProjectDetailPage(driver);
        userDetailPage = new UserDetailPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        elements = new Elements(driver);
        homePage.navigateTo();
        homePage.clickViewProfile("Johan L");
        userDetailPage.clickViewProjectBtn("Johan L");

    }
    @AfterEach
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    public void clickEditUser(){
        elements.getProjectDetailForm();
    }
    @Test
    public void clickBackToUser(){
        projectDetailPage.clickBackToUserProfile();
        wait.until(ExpectedConditions.visibilityOf(elements.getAddProjectBtn()));
        assertEquals(elements.getUsernameH1().getText(), "Johan L's Profile");
    }
}
