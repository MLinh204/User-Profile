package com.example.userprofile.frontend;

import com.example.userprofile.frontend.objects.Elements;
import com.example.userprofile.frontend.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDetailPageTest {
    private WebDriver driver;
    private HomePage homePage;
    private UserDetailPage detailPage;
    private AddProjectForm addProjectForm;
    private Elements elements;
    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        detailPage = new UserDetailPage(driver);
        addProjectForm = new AddProjectForm(driver);
        elements = new Elements(driver);
        homePage.navigateTo();
        homePage.clickViewProfile("Johan L");
    }
    @AfterEach
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
    @Test
    public void clickAddProject(){
        detailPage.clickAddProjectBtn();
        assertTrue(elements.getAddProjectForm().isDisplayed());
    }
    @Test
    public void clickViewProject(){
        detailPage.clickViewProjectBtn("Johan L");
        assertTrue(elements.getProjectDetailForm().isDisplayed());
        assertTrue(elements.getProjectDetailName().getText().contains("Johan L"));
    }
    @Test
    public void clickDeleteBtn(){
        detailPage.clickAddProjectBtn();
        addProjectForm.createProject("Johan L", "Exercise for Automation QA", "Java Selenium", "Dev - Automation QA");
        detailPage.clickDeleteBtn("Johan L");
    }
}
