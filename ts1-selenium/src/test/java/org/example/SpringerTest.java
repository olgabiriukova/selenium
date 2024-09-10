package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;



public class SpringerTest {
    public WebDriver driver;
    public static MainPage mainPage;
    public static LoginPage loginPage;
    public static SearchPage searchPage;
    private AdvancedSearchPage advancedSearchPage;
    private ArticlePage articlePage;
    ArticleSearch articleSearch = new ArticleSearch();
    ArticleInfObj[] searchObjects;


    @BeforeMethod
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://link.springer.com/");
        searchObjects = articleSearch.Search();

        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        advancedSearchPage = PageFactory.initElements(driver, AdvancedSearchPage.class);
        articlePage = PageFactory.initElements(driver, ArticlePage.class);
        searchPage = PageFactory.initElements(driver, SearchPage.class);

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testArticleSearch() throws IOException{
        setUp();
        WebElement acceptCookiesButton = driver.findElement(By.cssSelector("button[data-cc-action='accept']"));
        acceptCookiesButton.click();
        mainPage.goToLoginPage();
        loginPage.inputEmail("email@example.com").login();
        WebElement acceptCookiesButton2 = driver.findElement(By.cssSelector("button[data-cc-action='accept']"));
        acceptCookiesButton2.click();
        for (int i=0; i<4; i++) {

            driver.get("https://link.springer.com/advanced-search ");
            String searchedName = searchObjects[i].getName();
            advancedSearchPage.fillForm(searchedName, "", "", "",
                    "", "",  "",  "");
            advancedSearchPage.submitSearch();
            String name = articlePage.getArticleTitle();
            searchPage.goToArticle();
            String actualDOI = articlePage.getDoi();
            String expectedDOI = searchObjects[i].getDoi();
            String actualDate = articlePage.getPublishedDate();
            String expectedDate = searchObjects[i].getDate();
            Assert.assertEquals(expectedDOI, actualDOI);
            Assert.assertEquals(expectedDate, actualDate);

        }
    }
}
