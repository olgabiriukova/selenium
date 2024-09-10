package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearchPage {
    private WebDriver driver;

    @FindBy(id = "all-words")
    private WebElement allWordsInput;

    @FindBy(id="exact-phrase")
    private WebElement exactPhraseInput;

    @FindBy(id = "least-words")
    private WebElement leastWordsInput;

    @FindBy(id = "without-words")
    private WebElement withoutWordsInput;

    @FindBy(id = "author-is")
    private WebElement authorInput;

    @FindBy(id = "title-is")
    private WebElement titleInput;

    @FindBy(id = "facet-start-year")
    private WebElement yearFromInput;

    @FindBy(id = "facet-end-year")
    private WebElement yearToInput;

    @FindBy(id = "submit-advanced-search")
    private WebElement searchButton;


    public AdvancedSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillForm(String allWords, String exactPhrase, String leastWords, String withoutWords, String author, String title,  String yearFrom, String yearTo) {
        allWordsInput.clear();
        allWordsInput.sendKeys(allWords);

        exactPhraseInput.clear();
        exactPhraseInput.sendKeys(exactPhrase);

        leastWordsInput.clear();
        leastWordsInput.sendKeys(leastWords);

        withoutWordsInput.clear();
        withoutWordsInput.sendKeys(withoutWords);

        authorInput.clear();
        authorInput.sendKeys(author);

        titleInput.clear();
        titleInput.sendKeys(title);


        yearFromInput.clear();
        yearFromInput.sendKeys(yearFrom);

        yearToInput.clear();
        yearToInput.sendKeys(yearTo);
    }


    public void submitSearch() {
        searchButton.click();
    }




}
