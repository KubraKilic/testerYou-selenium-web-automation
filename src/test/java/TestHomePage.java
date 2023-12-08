import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestHomePage extends Base {

    public Home home;
    protected Logger logger;

    public TestHomePage() {
        home = new Home();
        logger = LogManager.getLogger("Test Home Page");
    }

    @Test
    public void testHomePage() {
        driver.get(home.homeUrl);

        logger.info("Waiting title");
        wait.until(ExpectedConditions.titleContains("IMDb"));

        String title = driver.getTitle();
        Assert.assertEquals(title,"IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows");
    }
}
