import org.openqa.selenium.By;

public class Search {

    public By searchBoxPath = By.name("q");
    public By searchButtonPath = By.xpath("//div[@id='suggestion-search-container']/form/button");
    public String searchKeywordForTheCircus = "The Circus";
    public String searchKeywordForTheJazzSinger = "The Jazz Singer";

}
