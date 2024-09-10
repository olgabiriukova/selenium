package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlePage {
    private WebDriver driver;

    @FindBy(className = "app-card-open__heading")
    private WebElement articleTitle;

    @FindBy(name = "prism.doi")
    private WebElement doi;

    @FindBy(xpath = "//li[@class='c-article-identifiers__item']/time")
    private WebElement date;

    public ArticlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getArticleTitle() {
        return articleTitle.getText();
    }

    public String getPublishedDate() {
        return date.getAttribute("datetime");
    }

    public String getDoi() {
        return doi.getAttribute("content");
    }



}
