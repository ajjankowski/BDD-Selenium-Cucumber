package tests;

import org.testng.annotations.Test;
import pages.GoldenmarkPage;
import pages.MennicaPage;

import java.util.HashMap;

public class GoldMonitorTest extends BaseTest {

    @Test
    public void goldMonitorTest() throws InterruptedException {

// TODO: Set value below to expected gold price -> waitUntilPrice
        new MennicaPage(BaseTest.driver).waitUntilPrice(8000);

// TODO: Set names and links from goldenmark.com to desired coins
        HashMap<String, String> goldenmarkCoinsList = new HashMap<>();
        goldenmarkCoinsList.put("Kangaroo", "https://goldenmark.com/pl/australijski-kangur-1-uncja-zlota/#/282-cennik-1_dzien");
        goldenmarkCoinsList.put("Leaf", "https://goldenmark.com/pl/kanadyjski-lisc-klonowy-1-uncja-zlota/#/282-cennik-1_dzien");
        goldenmarkCoinsList.put("Britannia", "https://goldenmark.com/pl/britannia-1-uncja-zlota-2929/#/282-cennik-1_dzien");
        new GoldenmarkPage(BaseTest.driver).checkGoldenmarkPrices(goldenmarkCoinsList);
    }
}
