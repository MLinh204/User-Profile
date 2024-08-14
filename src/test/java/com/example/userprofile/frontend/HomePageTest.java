package com.example.userprofile.frontend;

import com.example.userprofile.frontend.objects.ConfigProperties;
import com.example.userprofile.frontend.objects.Elements;
import com.example.userprofile.frontend.pages.CreateUserForm;
import com.example.userprofile.frontend.pages.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest {
    private WebDriver webDriver;
    private HomePage homePage;
    private CreateUserForm createUserForm;
    private Elements elements;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        createUserForm = new CreateUserForm(webDriver);
        elements = new Elements(webDriver);
        homePage.navigateTo();
    }
    @AfterEach
    public void tearDown(){
        if(webDriver != null){
            webDriver.quit();
        }
    }

    @Test
    public void testHomePageLoads(){
        assertTrue(webDriver.getTitle().contains("Home"));
        assertTrue(elements.getNavButton().getText().contains("User Profile List"));
        assertEquals("User Profile List", webDriver.findElement(By.tagName("h1")).getText());
        assertTrue(webDriver.findElement(By.cssSelector(".logo")).isDisplayed());
        assertTrue(webDriver.findElement(By.tagName("button")).getText().contains("Create User Profile"));
    }
    @Test
    public void clickLogo(){
        homePage.clickLogo();
        assertEquals(ConfigProperties.BASE_URL, webDriver.getCurrentUrl());
    }
    @Test
    public void clickNavBtn(){
        homePage.clickNavBtn();
        assertEquals(ConfigProperties.BASE_URL, webDriver.getCurrentUrl());
    }
    @Test
    public void testUserDisplayList(){
        assertTrue(homePage.getUserCount()>0);
    }
    @Test
    public void testCreateUserNavigation(){
        homePage.clickCreateUser();
        assertEquals(ConfigProperties.CREATE_USER_URL, webDriver.getCurrentUrl());
    }
    @Test
    public void checkViewProfile(){
        homePage.clickViewProfile("Johan L");
        assertEquals("Johan L's Profile", webDriver.findElement(By.tagName("h1")).getText());
    }
    @Test
    public void clickEditBtn(){
        homePage.clickEditBtn("Johan L");
        assertEquals("Edit User Profile", elements.getEditUserH2().getText());
    }
    @Test
    public void clickDeleteBtn(){
        homePage.clickCreateUser();
        createUserForm.createAUser("J1", "30", "SE", "5", "http://example.com/profile.jpg");
        homePage.clickDeleteBtn("J1");
    }
}
