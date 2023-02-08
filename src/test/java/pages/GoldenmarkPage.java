package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;

public class GoldenmarkPage {
    private static WebDriver driver;

    public GoldenmarkPage(WebDriver driver) {
        GoldenmarkPage.driver = driver;
        PageFactory.initElements(GoldenmarkPage.driver, this);
    }

    @FindBy(xpath = "//span[@itemprop='price']")
    private WebElement goldenmarkCoinPrice;

    @FindBy(xpath = "//input[@title=\"1 dzień\"]")
    private WebElement oneDayRadioButton;

    public void checkGoldenmarkPrices(HashMap<String, String> goldenmarkCoinsList) throws InterruptedException {
        System.out.println("Goldenmark price of coins 24h:");
        for (String coinName : goldenmarkCoinsList.keySet()) {
            openWeb(goldenmarkCoinsList.get(coinName));
            checkRadioButton();
            checkPrice(coinName, goldenmarkCoinsList.get(coinName));
        }
    }

    public void openWeb(String link) {
        driver.get(link);
        Assert.assertEquals(driver.getCurrentUrl(), link);
    }

    public void checkRadioButton() {
        if (!oneDayRadioButton.isSelected()) {
            oneDayRadioButton.click();
        }
    }

    public void checkPrice(String coinName, String link) throws InterruptedException {
        Thread.sleep(1000);
        String coinPrice = goldenmarkCoinPrice.getAttribute("content");
        String logInfo = coinPrice + " - " + coinName + " " + link;
        System.out.println(logInfo);
    }
}
