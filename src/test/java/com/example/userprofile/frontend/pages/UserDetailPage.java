package com.example.userprofile.frontend.pages;

import com.example.userprofile.frontend.objects.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDetailPage {
    private WebDriver driver;
    private Elements elements;
    private WebDriverWait wait;

    public UserDetailPage(WebDriver driver) {
        this.driver = driver;
        this.elements = new Elements(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public WebElement findProjectHolder(String project) {
        for (WebElement holder : elements.getProjectHolder()) {
            WebElement element = holder.findElement(By.tagName("h3"));
            if (element.getText().equals(project)) {
                return holder;
            }
        }
        throw new NoSuchElementException("No project found with name: " + project);
    }

    public int getProjectCount() {
        return elements.getProjectHolder().size();
    }

    public void clickAddProjectBtn() {
        elements.getAddProjectBtn().click();
    }

    public void clickViewProjectBtn(String project) {
        WebElement holder = findProjectHolder(project);
        WebElement viewProjectBtn = holder.findElement(By.linkText("View Project"));
        viewProjectBtn.click();
    }

    public void clickDeleteBtn(String projectName) {
        int initialCount = getProjectCount();
        WebElement holder = findProjectHolder(projectName);
        if(holder!= null){
            WebElement deleteBtn= driver.findElement(By.linkText("Delete Project"));
            deleteBtn.click();
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            wait.until(ExpectedConditions.invisibilityOf(holder));
            assertEquals(getProjectCount(), initialCount-1);
        } else {
            throw new NoSuchElementException("Project " + projectName + " not found");
        }
    }
}

