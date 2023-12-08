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
public class TestTheCircusPage extends Base {

    public Oscar oscar;
    public TheCircus theCircus;
    public Search search;
    public Home home;
    protected Logger logger;

    public TestTheCircusPage() {
        oscar = new Oscar();
        theCircus = new TheCircus();
        search = new Search();
        home =new Home();
        logger = LogManager.getLogger("Test The Circus Page");
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

        logger.info("Waiting Oscar List");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(oscar.scrollUntilEditPageButtonPath)));

        WebElement editPageButtonElement = driver.findElement(oscar.scrollUntilEditPageButtonPath);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editPageButtonElement);

        WebElement theCircusItemElement = driver.findElement(oscar.theCircusItemPath);
        Assert.assertTrue(theCircusItemElement.isDisplayed());
        theCircusItemElement.click();

    }


    @Test
    public void testTheCircus() {
        driver.get(theCircus.theCircusPageUrl);

        logger.info("Waiting for The Circus Detail Page");
        String title = driver.getTitle();
        Assert.assertEquals(title,"The Circus (1928) - IMDb");

        WebElement directorOfTheCircusElement = driver.findElement(theCircus.directorOfTheCircusPath);
        String director = directorOfTheCircusElement.getText();
        System.out.println(director);

        WebElement writerOfTheCircusElement = driver.findElement(theCircus.writerOfTheCircusPath);
        String writer = writerOfTheCircusElement.getText();
        System.out.println(writer);

        List<WebElement> starsOfListElement = driver.findElements(theCircus.starsOfTheCircusPath);
        System.out.println("Counts of element " + starsOfListElement.size());
        ArrayList<String> starsOfList = new ArrayList<>();

        for(int i = 0; i < starsOfListElement.size(); i++) {
            starsOfList.add(starsOfListElement.get(i).getText());
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

        searchInputElement.sendKeys(search.searchKeywordForTheCircus);
        searchButtonElement.click();

        WebElement searchResultTheCircusElement = driver.findElement(theCircus.searchResultTheCircusPath);
        searchResultTheCircusElement.click();

        WebElement searchResultDirectorOfTheCircusElement = driver.findElement(theCircus.searchResultDirectorOfTheCircusPath);
        Assert.assertEquals("Director does not match.",director,searchResultDirectorOfTheCircusElement.getText());

        WebElement searchResultWriterOfTheCircusElement = driver.findElement(theCircus.searchResultWriterOfTheCircusPath);
        Assert.assertEquals("Writer does not match",writer,searchResultWriterOfTheCircusElement.getText());

        List<WebElement> searchResultStarsOfTheCircusElement = driver.findElements(theCircus.searchResultStarsOfTheCircusPath);
        ArrayList<String> searchResultStarsOfList = new ArrayList<>();

        for(int i = 0; i < searchResultStarsOfTheCircusElement.size(); i++) {
            searchResultStarsOfList.add(searchResultStarsOfTheCircusElement.get(i).getText());
        }
        Assert.assertEquals("Stars do not match",starsOfList,searchResultStarsOfList);

    }
}
