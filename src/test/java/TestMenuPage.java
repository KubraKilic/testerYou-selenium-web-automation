import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestMenuPage extends Base{

    public Menu menu;
    public Home home;
    protected Logger logger;

    public TestMenuPage() {
        menu =new Menu();
        home = new Home();
        logger = LogManager.getLogger("Test Menu Page");
    }

    @Test
    public void testMenu() {
        driver.get(home.homeUrl);

        logger.info("Waiting menu button");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(menu.menuPath)));

        WebElement menuButtonElement = driver.findElement(menu.menuPath);
        menuButtonElement.click();

        logger.info("Waiting menu lists");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(menu.menuListPath)));

        WebElement thirdCategoryElement = driver.findElement(menu.AwardsEventsPath);
        Assert.assertTrue(thirdCategoryElement.isDisplayed());

        WebElement firstItemElement = driver.findElement(menu.firstItemInAwardsEventsPath);
        firstItemElement.click();

    }
}
