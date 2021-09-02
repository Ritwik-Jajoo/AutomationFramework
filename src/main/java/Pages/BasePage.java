package Pages;

import Utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class BasePage extends Utils {

    public WebDriver driver;
    public FileInputStream fis;
    public static Properties properties;

    public BasePage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
        properties = new Properties();
        try{
            fis=new FileInputStream("C:\\Users\\Ritwik Jajoo\\IdeaProjects\\AutomationFramework\\resources\\config.properties");
            properties.load(fis);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FindBy(xpath = "//div[@class=\"logo\"]//img[@alt=\"logo\"]")
    WebElement logoOnBasePage;

    @FindBy(xpath = "//i[@class=\"la la-bars\"]")
    WebElement MenuButton;

    @FindBy(xpath = "(//div[@class=\"main-menu-content\"]//ul)[1]/li")
    List<WebElement> MenuSection;

    @FindBy(xpath = "//button[@id=\"currency\"]")
    WebElement CurrencyButton;

    @FindBy(xpath = "//button[@id=\"languages\"]")
    WebElement LanguageButton;

    @FindBy(xpath = "//ul[@class=\"dropdown-menu show\"]/li")
    List<WebElement> LanguagesInLanguageButton;

    @FindBy(xpath = "//a[text()=\"Home\"]")
    WebElement HomeButtonInEnglishLanguagePage;

    @FindBy(xpath = "(//i[@class=\"la la-hotel mx-1\"])[2]")
    WebElement HotelButton;

    @FindBy(xpath = "(//button[@type=\"submit\"])[1]")
    WebElement SearchButtonInHotels;

    @FindBy(xpath = "//form[@id=\"hotels-search\"]//div[@class=\"row g-1\"]")
    WebElement MultipleOptionsForHotelSection;

    @FindBy(xpath = "//h2[text()=\"Latest on blogs\"]/../../../../..")
    WebElement LatestOnBlogsSection;

    @FindBy(xpath = "//h2[text()=\"Latest on blogs\"]")
    WebElement LatestOnBlogsText;

    @FindBy(xpath = "//h2[text()=\"Featured Tours\"]")
    WebElement FeaturedToursText;

    @FindBy(xpath = "//h2[text()=\"Featured Tours\"]/../../../../..")
    WebElement FeaturedToursSection;

    @FindBy(xpath = "//button[@id=\"cookie_stop\"]")
    WebElement GotItButton;

    @FindBy(xpath = "//h3[text()=\"Spectaculars Of The Nile 3 Nights\"]/..")
    WebElement FeaturedToursOption;

    @FindBy(xpath = "(//div[@class=\"card-body mb-1\"]//span[@class=\"price__num\"])[1]")
    WebElement HoverDetailsForFeaturedToursOption;

    @FindBy(xpath = "//i[@title=\"Go top\"]")
    WebElement ReturnToTop;

    @FindBy(xpath = " //strong[contains(.,\"PHPTRAVELS\")]")
    WebElement LogoAtTheBottomOfThePage;


    public boolean isLogoPresent() {
        return isDisplayed(logoOnBasePage);
    }

    public void setWindowToDifferentSize() {
        performWindowToDifferentSize();
    }

    public void clickOnMenuButton() {
        click(MenuButton);
        holdExecution(2);
    }

    public boolean isMenuSectionDisplayed() {
        return listOfWebElementsAreDisplayed(MenuSection);
    }

    public void hoverOverCurrencyButton() {
        hoverMouse(CurrencyButton);
        holdExecution(2);
    }

    public boolean isColorChangedOnCurrencyButton() {
        return isColorChanged(CurrencyButton, "rgba(227, 234, 240, 0.64)");
    }

    public void clickOnLanguageButton() {
        click(LanguageButton);
        holdExecution(2);
    }

    public boolean multipleLanguageOptionsAreDisplayed() {
        return listOfWebElementsAreDisplayed(LanguagesInLanguageButton);
    }

    public void clickOnEnglishLanguageButton() {
        click(LanguagesInLanguageButton.get(1));
    }

    public boolean languageOfPageChangedToEnglishLanguage() {
        return isDisplayed(HomeButtonInEnglishLanguagePage);
    }

    public boolean multipleFilterOptionsInHeaderAreDisplayed() {
        return listOfWebElementsAreDisplayed(MenuSection);
    }

    public void clickOnHotelButton() {
        click(HotelButton);
    }

    public void hoverOnSearchButtonInHotels() {
        hoverMouse(SearchButtonInHotels);
        holdExecution(2);
    }

    public boolean isColorChangedOnSearchButtonInHotels() {
        return isColorChanged(SearchButtonInHotels, "rgba(136, 136, 136, 1)");
    }

    public boolean multipleOptionsDisplayedUnderHotelSection() {
        return isDisplayed(MultipleOptionsForHotelSection);
    }

    public void scrollToLatestOnBlogsSection() {
        scrollTillTheElementIsVisible(LatestOnBlogsText);
        holdExecution(2);
    }

    public boolean latestOnBlogsSectionDisplayed() {
        return isDisplayed(LatestOnBlogsSection);
    }

    public void scrollToFeaturedToursSection() {
        scrollTillTheElementIsVisible(FeaturedToursText);
        holdExecution(2);
    }

    public boolean FeaturedToursSectionDisplayed() {
        return isDisplayed(FeaturedToursSection);
    }

    public void acceptCookie() {
        click(GotItButton);
    }

    public void scrollToFeaturedToursOption() {
        scrollTillTheElementIsVisible(FeaturedToursOption);
        holdExecution(2);
    }

    public void hoverOnFeaturedToursOption() {
        hoverMouse(FeaturedToursOption);
    }

    public boolean priceDetailsVisible() {
        return isDisplayed(HoverDetailsForFeaturedToursOption);
    }

    public boolean scrollDownToTheBottomOfThePage() {
        scrollDown();
        holdExecution(2);
        return isDisplayed(LogoAtTheBottomOfThePage);
    }

    public boolean clickOnReturnToTopButton() {
        click(ReturnToTop);
        holdExecution(2);
        return isLogoPresent();
    }

}