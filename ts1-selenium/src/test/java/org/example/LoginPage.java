package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "login-email" )
    private WebElement emailInput;

    @FindBy(id = "email-submit")
    private WebElement loginButtonElement;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage inputEmail(String email){
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public void login(){
        loginButtonElement.click();
    }


}
