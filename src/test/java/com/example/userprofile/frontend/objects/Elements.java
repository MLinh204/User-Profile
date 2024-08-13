package com.example.userprofile.frontend.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Elements {
    //Add project Page
    @FindBy(name = "projectName")
    private WebElement projectNameField;
    @FindBy(name = "projectDescription")
    private WebElement projectDescriptionField;
    @FindBy(name = "projectTechnologies")
    private WebElement projectTechnologiesField;
    @FindBy(name = "userPosition")
    private WebElement userPositionField;
    @FindBy(css = "button[type='submit']")
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
    @FindBy(className = "nav-btn")
    private WebElement navButton;

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
    @FindBy(xpath = "//a[text()='Edit User Profile']")
    private WebElement editProfileBtn;
    @FindBy(xpath = "//a[text()='Back to User Profile']")
    private WebElement backToProfileBtn;
    @FindBy(xpath = "//div[@class='detail-container']/h2")
    private WebElement projectDetailName;

    //Edit Project Profile
    @FindBy(className = "form-container")
    private WebElement editProjectForm;

    public Elements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public WebElement getProjectNameField() {
        return projectNameField;
    }

    public WebElement getProjectDescriptionField() {
        return projectDescriptionField;
    }

    public WebElement getProjectTechnologiesField() {
        return projectTechnologiesField;
    }

    public WebElement getUserPositionField() {
        return userPositionField;
    }

    public WebElement getSubmitProjectButton() {
        return submitProjectButton;
    }

    public List<WebElement> getUserContainer() {
        return userContainer;
    }

    public WebElement getCreateUserBtn() {
        return createUserBtn;
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getNavButton() {
        return navButton;
    }

    public WebElement getAgeField() {
        return ageField;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getYOEField() {
        return YOEField;
    }

    public WebElement getPositionField() {
        return positionField;
    }

    public WebElement getProfilePictureField() {
        return profilePictureField;
    }

    public WebElement getSubmitUserButton() {
        return submitUserButton;
    }

    public List<WebElement> getProjectHolder() {
        return projectHolder;
    }

    public WebElement getEditBtn() {
        return editBtn;
    }

    public WebElement getAddProjectBtn() {
        return addProjectBtn;
    }

    public WebElement getViewProjectBtn() {
        return viewProjectBtn;
    }

    public WebElement getDeleteProjectBtn() {
        return deleteProjectBtn;
    }

    public WebElement getAddProjectForm() {
        return addProjectForm;
    }

    public WebElement getProjectDetailForm() {
        return projectDetailForm;
    }

    public WebElement getEditProfileBtn() {
        return editProfileBtn;
    }

    public WebElement getBackToProfileBtn() {
        return backToProfileBtn;
    }

    public WebElement getProjectDetailName() {
        return projectDetailName;
    }

    public WebElement getEditProjectForm() {
        return editProjectForm;
    }

    public WebElement getUsernameH1() {
        return usernameH1;
    }
}
