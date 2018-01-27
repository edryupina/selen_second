package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StrahPage {
    @FindBy(xpath = "//h1[contains(text(),'Страхование путешественников')]")
    public WebElement list;
    @FindBy(xpath = "//a//img [contains(@src,'banner-zashita-traveler')]")
    public WebElement baton;
    public StrahPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);
        wait.until(ExpectedConditions.visibilityOf(list));
        wait.until(ExpectedConditions.visibilityOf(baton));
    }
}