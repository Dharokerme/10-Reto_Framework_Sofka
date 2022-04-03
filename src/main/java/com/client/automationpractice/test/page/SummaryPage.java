package com.client.automationpractice.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {

    @CacheLookup
    @FindBy(xpath ="//*[@id=\"center_column\"]/p[2]/a[1]/span")
    WebElement proceedToCheckout2;

    @CacheLookup
    @FindBy(xpath ="//*[@id=\"center_column\"]/form/p/button/span")
    WebElement proceedToCheckout3;

    @CacheLookup
    @FindBy(id="uniform-cgv")
    WebElement termsOfService;

    @CacheLookup
    @FindBy(xpath ="//*[@id=\"form\"]/p/button/span")
    WebElement proceedToCheckout4;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    WebElement payByBankWire;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span")
    WebElement confirmOrder;

    @CacheLookup
    @FindBy(xpath="//*[@id=\"center_column\"]/div/p/strong")
    WebElement orderConfirmation;

    @CacheLookup
    @FindBy(className = "cart_quantity_delete")
    WebElement trash;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    WebElement emptyCart;

    public WebElement getProceedToCheckoutSummary() {
        return proceedToCheckout2;
    }

    public WebElement getProceedToCheckoutAddress() {
        return proceedToCheckout3;
    }

    public WebElement getTermsOfService() {
        return termsOfService;
    }

    public WebElement getProceedToCheckoutShipping() {
        return proceedToCheckout4;
    }

    public WebElement getPayByBankWire() {
        return payByBankWire;
    }

    public WebElement getConfirmOrder() {
        return confirmOrder;
    }

    public WebElement getOrderConfirmation() {return orderConfirmation;}

    public WebElement getTrash() {return trash;}

    public WebElement getEmptyCart() {return emptyCart;}

    public SummaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}