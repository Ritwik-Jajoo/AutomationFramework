package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Utils extends Setup {

    public static boolean isDisplayed(WebElement element) {
        boolean flag = false;
        try {
            wait(element);
            if (element.isDisplayed())
                flag = true;
        } catch (NoSuchElementException e) {
            flag = false;
        }
        return flag;
    }

    public static boolean listOfWebElementsAreDisplayed(List<WebElement> list) {
        boolean flag = false;
        for (WebElement e : list) {
            if (isDisplayed(e))
                flag = true;
            else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void holdExecution(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement wait(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitBeforeClicking(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element) {
        try {
            wait(element);
            element.click();
        } catch (StaleElementReferenceException e) {
            element.click();
            holdExecution(10);
        } catch (NoSuchElementException e) {
            element.click();
            holdExecution(10);
        }
    }

    public static void enterText(WebElement element, String text) {
        try {
            wait(element);
            element.clear();
            element.sendKeys(text);
        } catch (StaleElementReferenceException e) {
            element.sendKeys(text);
            holdExecution(10);
        } catch (NoSuchElementException e) {
            element.sendKeys(text);
            holdExecution(10);
        }
    }

    public static void performWindowToDifferentSize() {
        Dimension d = new Dimension(915, 525);
        driver.manage().window().setSize(d);
    }

    public static void hoverMouse(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public static boolean isColorChanged(WebElement element, String actual) {
        boolean flag = false;
        String expected = element.getCssValue("background-color");
        //System.out.println(expected);
        if (expected.equals(actual))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void scrollTillTheElementIsVisible(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false)", element);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
}
