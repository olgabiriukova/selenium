package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(id = "identity-account-widget" )
    private WebElement loginLink;

    @FindBy(id = "homepage-search")
    private WebElement searchLink;

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage() {
        loginLink.click();
    }


}
