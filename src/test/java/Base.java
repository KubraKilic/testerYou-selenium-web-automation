import org.apache.log4j.BasicConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Base {
    protected static WebDriver driver;
    protected static WebDriverWait wait;


    @BeforeClass
    public static void startUp() {
        File geckoDriverFile = new File("src/main/resources/drivers/geckodriver.exe");
        String geckoDriverPath = geckoDriverFile.getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", geckoDriverPath);

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,30);

        BasicConfigurator.configure();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
