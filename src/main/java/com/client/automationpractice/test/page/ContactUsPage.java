package com.client.automationpractice.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    @CacheLookup
    @FindBy(id ="id_contact")
    WebElement subjectHeading;

    @CacheLookup
    @FindBy(id ="email")
    WebElement email;

    @CacheLookup
    @FindBy(id ="id_order")
    WebElement orderRef;

    @CacheLookup
    @FindBy(id ="message")
    WebElement message;

    @CacheLookup
    @FindBy(id ="submitMessage")
    WebElement submitMessage;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/div")
    WebElement errorMessage;


    public WebElement getSubjectHeading() {return subjectHeading;}

    public WebElement getEmail() {
        return email;
    }

    public WebElement getOrderRef() {
        return orderRef;
    }

    public WebElement getMessage() {return message;}

    public WebElement getSubmitMessage() {return submitMessage;}

    public WebElement getSuccessMessage() {return successMessage;}

    public WebElement getErrorMessage() {return errorMessage;}

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}