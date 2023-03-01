package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeSuite
    public void setUp() {

// TODO: Set browser
        String driverType = "Chrome";
        System.out.println("Starting feature in " + driverType + " driver");
        switch (driverType.toLowerCase()) {
            case "chrome" -> {
                chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                edgedriver().setup();
                driver = new EdgeDriver();
            }
            default -> System.out.println("Wrong driver type: use Chrome, Firefox or Edge");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("Teardown starting");
        driver.quit();
    }
}
