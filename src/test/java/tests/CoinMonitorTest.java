package tests;

import org.testng.annotations.Test;
import pages.GoldenmarkPage;
import pages.MennicaPage;

import java.util.HashMap;

public class CoinMonitorTest extends BaseTest {

    @Test
    public void goldMonitorTest() throws InterruptedException {

// TODO: Set value below to expected gold price -> waitUntilPrice
        new MennicaPage(BaseTest.driver).waitUntilPrice("Gold", 8000);

// TODO: Set names and links from goldenmark.com to desired coins
        HashMap<String, String> goldenmarkCoinsList = new HashMap<>();
        goldenmarkCoinsList.put("Kangaroo", "https://goldenmark.com/pl/australijski-kangur-1-uncja-zlota/");
        goldenmarkCoinsList.put("Leaf", "https://goldenmark.com/pl/kanadyjski-lisc-klonowy-1-uncja-zlota/");
        goldenmarkCoinsList.put("Britannia", "https://goldenmark.com/pl/britannia-1-uncja-zlota-2929/");
        new GoldenmarkPage(BaseTest.driver).checkGoldenmarkPrices(goldenmarkCoinsList);
    }

    @Test
    public void silverMonitorTest() throws InterruptedException {

// TODO: Set value below to expected silver price -> waitUntilPrice
        new MennicaPage(BaseTest.driver).waitUntilPrice("Silver", 80);

// TODO: Set names and links from goldenmark.com to desired coins
        HashMap<String, String> goldenmarkCoinsList = new HashMap<>();
        goldenmarkCoinsList.put("Kangaroo", "https://goldenmark.com/pl/australijski-kangur-1-uncja-srebra/");
        goldenmarkCoinsList.put("Leaf", "https://goldenmark.com/pl/kanadyjski-lisc-klonowy-1-uncja-srebra/");
        goldenmarkCoinsList.put("Vienna", "https://goldenmark.com/pl/wiedenscy-filharmonicy-1-uncja-srebra/");
        new GoldenmarkPage(BaseTest.driver).checkGoldenmarkPrices(goldenmarkCoinsList);
    }
}
