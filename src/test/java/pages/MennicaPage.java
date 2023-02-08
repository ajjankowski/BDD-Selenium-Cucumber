package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitManager;

import java.util.List;

public class MennicaPage {
    private static WebDriver driver;

    public MennicaPage(WebDriver driver) {
        MennicaPage.driver = driver;
        PageFactory.initElements(MennicaPage.driver, this);
    }

    @FindBy(xpath = "//span[@class='price_oz']/span")
    private List<WebElement> goldPriceElement;

    public void waitUntilPrice(int price) {
        if (checkGoldPrice() <= price) {
            System.out.println("Time to buy coin!");
        } else {
            System.out.println("--> Wait until price drops to " + price + " PLN");
        }
    }

    public int checkGoldPrice() {
        String mennicaLink = "https://mennicakapitalowa.pl/";
        System.out.println("Opening " + mennicaLink);
        driver.get(mennicaLink);
        WaitManager.waitUntilTextDisappears(driver, goldPriceElement.get(0), "0.00", 5);
        String[] goldPrice = goldPriceElement.get(0).getText().split("\\.");
        System.out.println("Gold price is: " + goldPrice[0] + " /oz");
        return Integer.parseInt(goldPrice[0]);
    }
}
