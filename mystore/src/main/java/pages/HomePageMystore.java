package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageMystore {

    @FindBy(id = "search_query_top")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@id='contact-link']/a")
    private WebElement contactUs;

    public void setSearchBox(String item) {
        searchBox.sendKeys(item, Keys.ENTER);
    }

    public void contactUsLink() {
        contactUs.click();
    }
}
