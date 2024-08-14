package com.example.userprofile.frontend.objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Elements {
    private WebDriver driver;
    //Add project Page
    @FindBy(name = "projectName")
    private WebElement projectNameField;
    @FindBy(name = "projectDescription")
    private WebElement projectDescriptionField;
    @FindBy(name = "projectTechnologies")
    private WebElement projectTechnologiesField;
    @FindBy(name = "userPosition")
    private WebElement userPositionField;
    @FindBy(xpath = "//button[@type='submit' and text()='Add Project']")
    private WebElement submitProjectButton;
    @FindBy(className = "form-container")
    private WebElement addProjectForm;


    //Home page
    @FindBy(css = ".user-container")
    private List<WebElement> userContainer;
    @FindBy(className = "top-right-button")
    private WebElement createUserBtn;
    @FindBy(css = ".logo")
    private WebElement logo;
    @FindBy(css = "nav .a-tag-edit")
    private WebElement navButton;
    @FindBy(linkText = "Delete User")
    private WebElement deleteUserBtn;

    //Create User Page
    @FindBy(name = "age")
    private WebElement ageField;
    @FindBy(name = "name")
    private  WebElement nameField;
    @FindBy(name = "yearOfExperience")
    private  WebElement YOEField;
    @FindBy(name = "position")
    private  WebElement positionField;
    @FindBy(name = "profilePicture")
    private WebElement profilePictureField;
    @FindBy(css = "button[type='submit']")
    private WebElement submitUserButton;

    //User detail page
    @FindBy(css = ".project-controller")
    private List<WebElement> projectHolder;
    @FindBy(className = "edit-button-project")
    private WebElement editBtn;
    @FindBy(xpath = "//a[text()='Add project']")
    private WebElement addProjectBtn;
    @FindBy(xpath = "//a[text()='View Project'")
    private WebElement viewProjectBtn;
    @FindBy(xpath = "//a[text()='Delete Project'")
    private WebElement deleteProjectBtn;
    @FindBy(tagName = "h1")
    private WebElement usernameH1;

    //Project Detail page
    @FindBy(className = "detail-container")
    private WebElement projectDetailForm;
    @FindBy(css = ".btn-holder #edit")
    private WebElement editProjectBtn;
    @FindBy(css = ".btn-holder #return")
    private WebElement backToProfileBtn;
    @FindBy(xpath = "//div[@class='detail-container']/h2")
    private WebElement projectDetailName;

    //Edit User Profile
    @FindBy(css = "h2")
    private WebElement editUserH2;

    //Edit Project Profile
    @FindBy(css = ".form-container")
    private WebElement editProjectForm;

    public Elements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement getProjectNameField() {
        scrollIntoView(projectNameField);
        return projectNameField;
    }

    public WebElement getProjectDescriptionField() {
        scrollIntoView(projectDescriptionField);
        return projectDescriptionField;
    }

    public WebElement getProjectTechnologiesField() {
        scrollIntoView(projectTechnologiesField);
        return projectTechnologiesField;
    }

    public WebElement getUserPositionField() {
        scrollIntoView(userPositionField);
        return userPositionField;
    }

    public WebElement getSubmitProjectButton() {
        scrollIntoView(submitProjectButton);
        return submitProjectButton;
    }

    public List<WebElement> getUserContainer() {
        if (!userContainer.isEmpty()) {
            scrollIntoView(userContainer.get(0));
        }
        return userContainer;
    }

    public WebElement getCreateUserBtn() {
        scrollIntoView(createUserBtn);
        return createUserBtn;
    }

    public WebElement getLogo() {
        scrollIntoView(logo);
        return logo;
    }

    public WebElement getNavButton() {
        scrollIntoView(navButton);
        return navButton;
    }

    public WebElement getAgeField() {
        scrollIntoView(ageField);
        return ageField;
    }

    public WebElement getNameField() {
        scrollIntoView(nameField);
        return nameField;
    }

    public WebElement getYOEField() {
        scrollIntoView(YOEField);
        return YOEField;
    }

    public WebElement getPositionField() {
        scrollIntoView(positionField);
        return positionField;
    }

    public WebElement getProfilePictureField() {
        scrollIntoView(profilePictureField);
        return profilePictureField;
    }

    public WebElement getSubmitUserButton() {
        scrollIntoView(submitUserButton);
        return submitUserButton;
    }

    public List<WebElement> getProjectHolder() {
        if (!projectHolder.isEmpty()) {
            scrollIntoView(projectHolder.get(0));
        }
        return projectHolder;
    }

    public WebElement getEditBtn() {
        scrollIntoView(editBtn);
        return editBtn;
    }

    public WebElement getAddProjectBtn() {
        scrollIntoView(addProjectBtn);
        return addProjectBtn;
    }

    public WebElement getViewProjectBtn() {
        scrollIntoView(viewProjectBtn);
        return viewProjectBtn;
    }

    public WebElement getDeleteProjectBtn() {
        scrollIntoView(deleteProjectBtn);
        return deleteProjectBtn;
    }

    public WebElement getAddProjectForm() {
        scrollIntoView(addProjectForm);
        return addProjectForm;
    }

    public WebElement getProjectDetailForm() {
        scrollIntoView(projectDetailForm);
        return projectDetailForm;
    }

    public WebElement getEditProjectBtn() {
        scrollIntoView(editProjectBtn);
        return editProjectBtn;
    }

    public WebElement getBackToProfileBtn() {
        scrollIntoView(backToProfileBtn);
        return backToProfileBtn;
    }

    public WebElement getProjectDetailName() {
        scrollIntoView(projectDetailName);
        return projectDetailName;
    }

    public WebElement getEditProjectForm() {
        scrollIntoView(editProjectForm);
        return editProjectForm;
    }

    public WebElement getUsernameH1() {
        scrollIntoView(usernameH1);
        return usernameH1;
    }

    public WebElement getDeleteUserBtn() {
        scrollIntoView(deleteUserBtn);
        return deleteUserBtn;
    }

    public WebElement getEditUserH2() {
        scrollIntoView(editUserH2);
        return editUserH2;
    }
}
