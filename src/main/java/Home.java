import org.openqa.selenium.By;

public class Home {

    public String homeUrl = "https://www.imdb.com/";
    public By imdbButtonPath = By.id("home_img_holder");
    public By signInForMoreAccessButtonPath = By.xpath("//a[@class='ipc-btn ipc-btn--double-padding ipc-btn--center-align-content ipc-btn--default-height ipc-btn--core-accent1 ipc-btn--theme-baseAlt footer__sign-in-button']");

}
