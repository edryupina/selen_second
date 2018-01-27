package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppPage {
    @FindBy(xpath = "//span [contains(text(),'Оформление')]" )
    public WebElement zayavka;
    @FindBy(name = "insured0_surname")
    public WebElement insured0surname;
    @FindBy(name = "insured0_name")
    public WebElement insured0name;
    @FindBy(name = "insured0_birthDate")
    public WebElement insured0birthdate;
    @FindBy(name = "surname")
    public WebElement surname;
    @FindBy(name = "name")
    public WebElement name;
    @FindBy(name = "middlename")
    public WebElement middlename;
    @FindBy(name = "birthDate")
    public WebElement birthDate;
    @FindBy(name = "female")
    public WebElement female;
    @FindBy(name = "passport_series")
    public WebElement passportseries;
    @FindBy(name = "passport_number")
    public WebElement passportnumber;
    @FindBy(name = "issueDate")
    public WebElement issuedate;
    @FindBy(name = "issuePlace")
    public WebElement issueplace;

    @FindBy(xpath = "//span [contains(text(),'Продолжить')]" )
    public WebElement batton;

    @FindBy(xpath = "//div [text()='Заполнены не все обязательные поля']" )
    public WebElement alertText;

    public AppPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);
        wait.until(ExpectedConditions.visibilityOf(zayavka));
        wait.until(ExpectedConditions.visibilityOf(batton));
    }

    public void fillField(String fildName, String value){
        switch (fildName){
            case "ФамилияСтрахуемого": fullFillRefactor(insured0surname, value);
                break;
            case "ИмяСтрахуемого": fullFillRefactor(insured0name, value);
                break;
            case "ДатаРожденияСтрахуемого": fullFillRefactor(insured0birthdate, value);
                break;
            case "Фамилия": fullFillRefactor(surname, value);
                break;
            case "Имя": fullFillRefactor(name, value);
                break;
            case "Отчество": fullFillRefactor(middlename, value);
                break;
            case "ДатаРождения": fullFillRefactor(birthDate, value);
                break;
            case "Пол": fullFillRefactor(female, value);
                break;
            case "ПаспортСерия": fullFillRefactor(passportseries, value);
                break;
            case "ПаспортНомер": fullFillRefactor(passportnumber, value);
                break;
            case "ПаспортДатаВыдачи": fullFillRefactor(issuedate, value);
                break;
            case "ПаспортГдеВыдан": fullFillRefactor(issueplace, value);
                break;
            default: throw new AssertionError("Поле '" + fildName + "' не объявлено на странице");
        }
    }

    protected void fullFillRefactor(WebElement element, String value)
    {
        element.clear();
        element.sendKeys(value);
    }
}
