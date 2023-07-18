package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestLogger;
import utils.WaitManager;

import java.util.List;
import java.util.Objects;

public class MennicaPage {
    private static WebDriver driver;

    public MennicaPage(WebDriver driver) {
        MennicaPage.driver = driver;
        PageFactory.initElements(MennicaPage.driver, this);
    }

    @FindBy(xpath = "//span[@class='price_oz']/span")
    private List<WebElement> goldPriceElement;

    public void loadPage() {
        String mennicaLink = "https://mennicakapitalowa.pl/";
        TestLogger.info("Opening " + mennicaLink);
        driver.get(mennicaLink);
    }

    public void waitUntilPrice(String metal, int price) {
        if (checkMetalPrice(metal) <= price) {
            TestLogger.info("-> Time to buy a coin!");
        } else {
            TestLogger.info("-> Wait until price drops to " + price + " PLN");
        }
    }

    public int checkMetalPrice(String metal) {
        int metalType;
        if (Objects.equals(metal, "Gold")) {
            metalType = 0;
        } else {
            metalType = 1;
        }
        WaitManager.waitUntilTextDisappears(driver, goldPriceElement.get(metalType), "0.00", 5);
        String[] metalPrice = goldPriceElement.get(metalType).getText().split("\\.");
        TestLogger.info(metal + " price is: " + metalPrice[0] + " /oz");
        return Integer.parseInt(metalPrice[0]);
    }
}
