import org.apache.log4j.LogManager;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

@OrderWith(Alphanumeric.class)
public class TestTheJazzSingerPage extends Base{

    public Oscar oscar;
    public TheJazzSinger theJazzSinger;
    public Search search;
    public Home home;
    protected Logger logger;

    public TestTheJazzSingerPage() {
        oscar = new Oscar();
        theJazzSinger = new TheJazzSinger();
        search = new Search();
        home = new Home();
        logger = LogManager.getLogger("Test The Jazz Singer Page");
    }

    @Test
    public void testOscarPage() {
        driver.get(oscar.oscarsPageUrl);

        logger.info("Waiting for Oscars Page");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(oscar.oscarTitlePath)));

        WebElement rightArrowElement = driver.findElement(oscar.rightArrowInEventHistoryPath);
        Assert.assertTrue(rightArrowElement.isDisplayed());
        rightArrowElement.click();

        WebElement oneThousandNineHundredTwentyButtonElement = driver.findElement(oscar.oneThousandNineHundredTwentyButtonPath);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(oscar.oneThousandNineHundredTwentyButtonPath)));
        oneThousandNineHundredTwentyButtonElement.click();

        logger.info("Waiting 1929 Button");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(oscar.oneThousandNineHundredTwentyNineButtonPath)));

        WebElement oneThousandNineHundredTwentyNineButtonElement = driver.findElement(oscar.oneThousandNineHundredTwentyNineButtonPath);
        Assert.assertTrue(oneThousandNineHundredTwentyNineButtonElement.isDisplayed());
        oneThousandNineHundredTwentyNineButtonElement.click();

        WebElement editPageButtonElement = driver.findElement(oscar.scrollUntilEditPageButtonPath);
        logger.info("Waiting Oscar List");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(oscar.scrollUntilEditPageButtonPath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editPageButtonElement);

        WebElement theJazzSingerItemElement = driver.findElement(oscar.theJazzSingerItemPath);
        Assert.assertTrue(theJazzSingerItemElement.isDisplayed());
        theJazzSingerItemElement.click();

    }


    @Test
    public void testTheJazzSingerPAge() {
        driver.get(theJazzSinger.theJazzSingerPageUrl);

        logger.info("Waiting for The Jazz Singer Detail Page");
        String title = driver.getTitle();
        Assert.assertEquals(title,"The Jazz Singer (1927) - IMDb");

        WebElement directorOfTheJazzSingerElement = driver.findElement(theJazzSinger.directorOfTheJazzSingerPath);
        String director = directorOfTheJazzSingerElement.getText();
        System.out.println(director);

        List<WebElement> writersOfTheJazzSingerElement = driver.findElements(theJazzSinger.writersOfTheJazzSingerPath);
        System.out.println("Counts of element " + writersOfTheJazzSingerElement.size());
        ArrayList<String> writersOfList = new ArrayList<>();

        for(int i = 0; i < writersOfTheJazzSingerElement.size(); i++) {
            writersOfList.add(writersOfTheJazzSingerElement.get(i).getText());
        }
        System.out.println(writersOfList);


        List<WebElement> starsOfTheJazzSingerElement = driver.findElements(theJazzSinger.starsOfTheJazzSingerPath);
        System.out.println("Counts of element " + starsOfTheJazzSingerElement.size());
        ArrayList<String> starsOfList = new ArrayList<>();

        for(int i = 0; i < starsOfTheJazzSingerElement.size(); i++) {
            starsOfList.add(starsOfTheJazzSingerElement.get(i).getText());
        }
        System.out.println(starsOfList);

        WebElement imdbButtonElement = driver.findElement(home.imdbButtonPath);
        imdbButtonElement.click();

        logger.info("Waiting for IMDb MainPage");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(home.signInForMoreAccessButtonPath)));

        logger.info("Waiting for Search Button");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(search.searchBoxPath)));

        WebElement searchInputElement = driver.findElement(search.searchBoxPath);
        WebElement searchButtonElement = driver.findElement(search.searchButtonPath);

        searchInputElement.sendKeys(search.searchKeywordForTheJazzSinger);
        searchButtonElement.click();

        WebElement searchResultTheJazzSingerElement = driver.findElement(theJazzSinger.searchResultTheJazzSingerPath);
        searchResultTheJazzSingerElement.click();

        WebElement searchResultDirectorOfTheJazzSingerElement = driver.findElement(theJazzSinger.searchResultDirectorOfTheJazzSingerPath);
        Assert.assertEquals("Director does not match.",director,searchResultDirectorOfTheJazzSingerElement.getText());

        List<WebElement> searchResultWritersOfTheJazzSingerElement = driver.findElements(theJazzSinger.searchResultWritersOfTheJazzSingerPath);
        ArrayList<String> searchResulWritersOfList = new ArrayList<>();

        for(int i = 0; i < searchResultWritersOfTheJazzSingerElement.size(); i++) {
            searchResulWritersOfList.add(searchResultWritersOfTheJazzSingerElement.get(i).getText());
        }
        Assert.assertEquals("Writers do not match",writersOfList,searchResulWritersOfList);


        List<WebElement> searchResultStarsOfTheJazzSingerElement = driver.findElements(theJazzSinger.searchResultStarsOfTheJazzSingerPath);
        ArrayList<String> searchResultStarsOfList = new ArrayList<>();

        for(int i = 0; i < searchResultStarsOfTheJazzSingerElement.size(); i++) {
            searchResultStarsOfList.add(searchResultStarsOfTheJazzSingerElement.get(i).getText());
        }
        Assert.assertEquals("Stars do not match",starsOfList,searchResultStarsOfList);

    }
}
