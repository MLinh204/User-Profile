package com.example.userprofile.frontend;

import com.example.userprofile.frontend.objects.Elements;
import com.example.userprofile.frontend.pages.AddProjectForm;
import com.example.userprofile.frontend.pages.HomePage;
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

public class AddProjectFormTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private Elements elements;
    private UserDetailPage detailPage;
    private AddProjectForm projectForm;
    private HomePage homePage;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        elements = new Elements(driver);
        detailPage = new UserDetailPage(driver);
        projectForm = new AddProjectForm(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage.navigateTo();
        homePage.clickViewProfile("Johan L");

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void createProject() {
        int initialCount = detailPage.getProjectCount();
        detailPage.clickAddProjectBtn();
        projectForm.createProject("Johan L", "Exercise for Automation QA", "Java Selenium", "Dev - Automation QA");
        wait.until(ExpectedConditions.visibilityOf(elements.getUsernameH1()));
        assertEquals(detailPage.getProjectCount(), initialCount + 1);
        detailPage.clickDeleteBtn("Johan L");
    }

    @Test
    public void projectNameIsRequired() {
        detailPage.clickAddProjectBtn();
        projectForm.createProject("", "Exercise for Automation QA", "Java Selenium", "Dev - Automation QA");
        assertTrue(driver.getCurrentUrl().contains("http://localhost:8080/projects/create"));
    }

    @Test
    public void projectDescriptionIsRequired() {
        detailPage.clickAddProjectBtn();
        projectForm.createProject("Johan L", "", "Java Selenium", "Dev - Automation QA");
        assertTrue(driver.getCurrentUrl().contains("http://localhost:8080/projects/create"));
    }

    @Test
    public void projectTechnologiesIsRequired() {
        detailPage.clickAddProjectBtn();
        projectForm.createProject("Johan L", "Exercise for Automation QA", "", "Dev - Automation QA");
        assertTrue(driver.getCurrentUrl().contains("http://localhost:8080/projects/create"));
    }

    @Test
    public void userPositionIsRequired() {
        detailPage.clickAddProjectBtn();
        projectForm.createProject("Johan L", "Exercise for Automation QA", "Java Selenium", "");
        assertTrue(driver.getCurrentUrl().contains("http://localhost:8080/projects/create"));
    }

//    @Test
//    public void test(){
//        detailPage.clickAddProjectBtn();
//        elements.getSubmitProjectButton().click();
//    }
}
