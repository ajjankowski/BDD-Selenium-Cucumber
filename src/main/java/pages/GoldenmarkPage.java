package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

//TODO: Asercja
//import static org.junit.Assert.assertEquals;

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

    @FindBy(xpath = "//input[@title=\"9 dni\"]")
    private WebElement nineDayRadioButton;

    @FindBy(xpath = "//input[@title=\"45 dni\"]")
    private WebElement fortyFiveDayRadioButton;

    public void checkGoldenmarkPrices(HashMap<String, String> goldenmarkCoinsList) throws InterruptedException {
        System.out.println("Goldenmark coin prices:");
        for (String coinName : goldenmarkCoinsList.keySet()) {
            openWeb(goldenmarkCoinsList.get(coinName));
            checkRadioButton();
            checkPrice(coinName, goldenmarkCoinsList.get(coinName));
        }
    }

    public void openWeb(String link) {
        driver.get(link);
        //TODO: Asercja
//        Assert.assertEquals(driver.getCurrentUrl(), link);
    }

    public void checkRadioButton() {
        try {
            if (!oneDayRadioButton.isSelected()) {
                oneDayRadioButton.click();
            }
            System.out.println("Coin available in 24h");
        } catch (Exception e) {
            try {
                if (!nineDayRadioButton.isSelected()) {
                    nineDayRadioButton.click();
                }
                System.out.println("Coin available in 9 days");
            } catch (Exception e2) {
                try {
                    if (!fortyFiveDayRadioButton.isSelected()) {
                        fortyFiveDayRadioButton.click();
                    }
                    System.out.println("Coin available only in 45 days");
                } catch (Exception e3) {
                    System.out.println("Coin is unavailable");
                }
            }
        }
    }

    public void checkPrice(String coinName, String link) throws InterruptedException {
        Thread.sleep(1000);
        String coinPrice = goldenmarkCoinPrice.getAttribute("content");
        System.out.println("-> " + coinPrice + " - " + coinName + " " + link);
    }
}
