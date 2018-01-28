import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AppPage;
import pages.MainPage;
import pages.StrahPage;
import pages.SummaPage;

import java.util.ArrayList;

public class SecondHomeTest extends BaseTest {
    @Test
    public void newInsuranceTest() throws InterruptedException {

        //2. Нажать на – Застраховать себя и имущество
        //3. Выбрать – Страхование путешественников
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Застраховать");
        MainPage subMenu = new MainPage(driver);
        subMenu.selectSubMenu(driver);

        //4. Проверить наличие на странице заголовка – Страхование путешественников
        StrahPage strahPage = new StrahPage(driver);
        Assert.assertEquals("Страхование путешественников",strahPage.list.getText());
        strahPage.baton.click();
        ArrayList<String> NewTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(NewTab.get(1));

        //5. Нажать на – Оформить Онлайн (самой кнопки нет, есть только информационный блок)
        //6. На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        SummaPage choiceSumPage = new SummaPage(driver);
        choiceSumPage.selectSum("Минимальная");
        choiceSumPage.selectIssueButton();

        //7. Нажать Оформить
        //8. На вкладке Оформить заполнить поля:
        AppPage fullFillPage = new AppPage(driver);
        fullFillPage.fillField("ФамилияСтрахуемого","Dryupina");
        fullFillPage.fillField("ИмяСтрахуемого","Ekaterina");
        fullFillPage.fillField("ДатаРожденияСтрахуемого","23.03.1985");
        fullFillPage.fillField("Фамилия","Фадеева");
        fullFillPage.fillField("Имя","Екатерина");
        fullFillPage.fillField("Отчество","Игоревна");
        fullFillPage.fillField("ДатаРождения","23.03.1995");
        driver.findElement(By.name("female")).click();
        fullFillPage.fillField("ПаспортСерия","3609");
        fullFillPage.fillField("ПаспортНомер","123456");
        fullFillPage.fillField("ПаспортДатаВыдачи","01.12.2017");
        fullFillPage.fillField("ПаспортГдеВыдан","ОФМС России по Московской области");

        //9.       Проверить, что все поля заполнены правильно
        Assert.assertEquals("Dryupina",fullFillPage.insured0surname.getAttribute("value"));
        Assert.assertEquals("Ekaterina",fullFillPage.insured0name.getAttribute("value"));
        Assert.assertEquals("23.03.1985",fullFillPage.insured0birthdate.getAttribute("value"));
        Assert.assertEquals("Фадеева",fullFillPage.surname.getAttribute("value"));
        Assert.assertEquals("Екатерина",fullFillPage.name.getAttribute("value"));
        Assert.assertEquals("Игоревна",fullFillPage.middlename.getAttribute("value"));
        Assert.assertEquals("23.03.1995",fullFillPage.birthDate.getAttribute("value"));
        Assert.assertEquals("1",driver.findElement(By.name("female")).getAttribute("value"));
        Assert.assertEquals("3609",fullFillPage.passportseries.getAttribute("value"));
        Assert.assertEquals("123456",fullFillPage.passportnumber.getAttribute("value"));
        Assert.assertEquals("01.12.2017",fullFillPage.issuedate.getAttribute("value"));
        Assert.assertEquals("ОФМС России по Московской области",fullFillPage.issueplace.getAttribute("value"));

        //10.   Нажать продолжить
        fullFillPage.batton.click();

        //11.   Проверить, что появилось сообщение - Заполнены не все обязательные поля
        Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);
        WebElement alertText = driver.findElement(By.xpath("//div [text()='Заполнены не все обязательные поля']"));
      //  wait.until(ExpectedConditions.visibilityOf(alertText));
        Assert.assertEquals("Заполнены не все обязательные поля",alertText.getText());
    }
}



