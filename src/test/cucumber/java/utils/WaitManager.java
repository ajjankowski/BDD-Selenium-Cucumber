package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitManager {

    public static void waitUntilTextDisappears(WebDriver driver, WebElement element, String textToDisappear, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        try {
            wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, textToDisappear)));
        } catch (Exception e) {
            wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, textToDisappear)));
        }

    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
