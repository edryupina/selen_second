package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaPage {
    @FindBy(xpath = "//h3 [text()='Выберите сумму страховой защиты']/parent::section")
    WebElement summa;
    @FindBy(xpath = "//span [contains(text(),'Оформить')]")
    WebElement batton;
    public SummaPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);
        wait.until(ExpectedConditions.visibilityOf(summa));
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",summa);
        wait.until(ExpectedConditions.visibilityOf(batton));
    }
    public void selectSum(String menuItem){
        summa.findElement(By.xpath(".//div[text()='"+ menuItem +"']")).click();
    }
    public void selectIssueButton(){
        batton.click();
    }
}



