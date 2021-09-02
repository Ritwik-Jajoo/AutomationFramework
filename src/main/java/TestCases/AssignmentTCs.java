package TestCases;

import Pages.BasePage;
import Utilities.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignmentTCs extends Setup {

    public WebDriver driver;
    BasePage basePage;

    @BeforeClass
    public void tearUp() {
        driver = launchBrowser("chrome");
    }

    @BeforeMethod
    public void launchWebsite() {
        basePage = new BasePage(driver);
        driver.get("https://www.phptravels.net");
    }

//    @Test
//    public void test(){
//        System.out.println(BasePage.properties.getProperty("url"));
//    }


    @Test(priority = 1)
    public void verifyLogoOnTheBasePage() {
        Assert.assertTrue(basePage.isLogoPresent());
    }

    @Test(priority = 2)
    public void verifyMenuSectionIsDisplayed() {
        basePage.setWindowToDifferentSize();
        basePage.clickOnMenuButton();
        Assert.assertTrue(basePage.isMenuSectionDisplayed());
    }

    @Test(priority = 3)
    public void verifyColorChangeOnHoveringTheMouseOverCurrencyButton() {
        maximizeWindow();
        basePage.hoverOverCurrencyButton();
        basePage.isColorChangedOnCurrencyButton();
    }

    @Test(priority = 4)
    public void verifyMultipleLanguageOptionsAreDisplayedOnClickingLanguageButton() {
        basePage.clickOnLanguageButton();
        Assert.assertTrue(basePage.multipleLanguageOptionsAreDisplayed());
    }

//    @Test(priority = 5)
//    public void verifyUserIsAbleToChangeLanguage(){
//        basePage.clickOnLanguageButton();
//        basePage.clickOnEnglishLanguageButton();
//        Assert.assertTrue(basePage.languageOfPageChangedToEnglishLanguage());
//    }

    @Test(priority = 6)
    public void verifyMultipleFilterOptionsInHeaderAreDisplayed() {
        Assert.assertTrue(basePage.multipleFilterOptionsInHeaderAreDisplayed());
    }

    @Test(priority = 7)
    public void verifyColorChangeOnHoveringOverSearchButtonInHotels() {
        basePage.clickOnHotelButton();
        basePage.hoverOnSearchButtonInHotels();
        Assert.assertTrue(basePage.isColorChangedOnSearchButtonInHotels());
    }

    @Test(priority = 8)
    public void verifyMultipleOptionsAreDisplayedUnderHotelSection() {
        basePage.clickOnHotelButton();
        Assert.assertTrue(basePage.multipleOptionsDisplayedUnderHotelSection());
    }

    @Test(priority = 9)
    public void verifyLatestOnBlogsSectionIsDisplayed() {
        basePage.scrollToLatestOnBlogsSection();
        Assert.assertTrue(basePage.latestOnBlogsSectionDisplayed());
    }

    @Test(priority = 10)
    public void verifyFeaturedToursSectionIsDisplayed() {
        basePage.acceptCookie();
        basePage.scrollToFeaturedToursSection();
        Assert.assertTrue(basePage.FeaturedToursSectionDisplayed());
    }

    @Test(priority = 11)
    public void verifyOnHoveringFeaturedTourOptionPriceDetailsAreDisplayed() {
        basePage.scrollToFeaturedToursOption();
        basePage.hoverOnFeaturedToursOption();
        Assert.assertTrue(basePage.priceDetailsVisible());
    }

    @Test(priority = 12)
    public void verifyUserReturnToTheTopOfThePageOnCLickingReturnToTop() {
        Assert.assertTrue(basePage.scrollDownToTheBottomOfThePage());
        Assert.assertTrue(basePage.clickOnReturnToTopButton());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
