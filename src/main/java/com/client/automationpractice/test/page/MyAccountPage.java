package com.client.automationpractice.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
    WebElement tshirts;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")
    WebElement imageTshirt;

    //*[@id="center_column"]/ul/li/div/div[1]/div
    @CacheLookup
    @FindBy(id = "add_to_cart")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    WebElement proceedToCheckout;

    public WebElement getTshirts() {
        return tshirts;
    }

    public WebElement getImageTshirt() {
        return imageTshirt;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public WebElement getProceedToCheckout() {
        return proceedToCheckout;
    }

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}