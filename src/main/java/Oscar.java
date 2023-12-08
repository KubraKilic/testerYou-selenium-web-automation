import org.openqa.selenium.By;

public class Oscar {

    public String oscarsPageUrl = "https://www.imdb.com/oscars/?ref_=nv_ev_csegosc";
    public By oscarTitlePath = By.xpath("//div[@class='ipc-page-content-container ipc-page-content-container--full sc-872d7ac7-0 fqEQWL']/div[3]/div[2]/div/div/div/a/h1[@class='ipc-title__text']");
    public By rightArrowInEventHistoryPath = By.xpath("//div[@class='ipc-tabs ipc-tabs--base ipc-tabs--align-left ipc-tabs--display-tab ipc-tabs--shade1']/li[2]");
    public By oneThousandNineHundredTwentyButtonPath =By.xpath("//section[@class='ipc-page-section ipc-page-section--base ipc-page-section--tp-none ipc-page-section--bp-none ipc-page-section--b-responsiveLine']/div/ul/li[11]");
    public By oneThousandNineHundredTwentyNineButtonPath = By.xpath("//section[@class='ipc-page-section ipc-page-section--base ipc-page-section--tp-none ipc-page-section--bp-none']/div/div[@class='ipc-chip-list__scroller']/a");
    public By scrollUntilEditPageButtonPath = By.id("contribute-main-button");
    public By theCircusItemPath = By.xpath("//a[text()='The Circus']");
    public By theJazzSingerItemPath = By.xpath("(//a[text()='The Jazz Singer'])[1]");

}
