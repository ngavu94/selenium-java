package webdriver;

import javaTester.Topic_06_Randon;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_10_Checkbox_Radio {
    WebDriver driver;
    Topic_06_Randon random = new Topic_06_Randon();

    @BeforeClass
    public void BeforeClass() {
        //Muon dung duoc phai khoi tao
        //Neu ko khoi tao: Lỗi NullPointerException
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //driver.get("https://www.facebook.com/");
        // driver.navigate()
    }

    // @Test
    public void TC_03_Default_Checkbox(){
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        sleepInSecond(5);
        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
        By rearSideCheckbox = By.xpath("//label[text()='Rear side airbags']/preceding-sibling::span/input");

        //click vao checkbox
        //case 1: Neu app mo ra ma checkbox nay da duoc chon thi sao
        if(!driver.findElement(rearSideCheckbox).isSelected()){
            driver.findElement(rearSideCheckbox).click();
            sleepInSecond(2);
        }
        //case 2: Neu app mo ra ma checkbox nay chua duoc chon thi sao
        if(!driver.findElement(dualZoneCheckbox).isSelected()){
            driver.findElement(dualZoneCheckbox).click();
            sleepInSecond(2);
        }

        //Verify checkbox da duoc chon chua
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());
        Assert.assertTrue(driver.findElement(rearSideCheckbox).isSelected());

        //Bo chon checkbox
        if(driver.findElement(rearSideCheckbox).isSelected()){
            driver.findElement(rearSideCheckbox).click();
            sleepInSecond(2);
        }
        if(driver.findElement(dualZoneCheckbox).isSelected()){
            driver.findElement(dualZoneCheckbox).click();
            sleepInSecond(2);
        }
        //Kiem tra da bo chon
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());
        Assert.assertFalse(driver.findElement(rearSideCheckbox).isSelected());

    }
    @Test
    public void TC_04_Default_RadioButton(){
        //Truy cap trang
        driver.get("https://material.angular.io/components/radio/examples");

        By winterRadio = By.xpath("//label[text()='Winter']/preceding-sibling::div/input");
        By summerRadio = By.xpath("//label[text()='Summer']/preceding-sibling::div/input");
        //Kiem tra neu radioButton chua duoc click thi click
        if(!driver.findElement(winterRadio).isSelected()){
            driver.findElement(winterRadio).click();
            sleepInSecond(2);
        }

        Assert.assertTrue(driver.findElement(winterRadio).isSelected());
        Assert.assertFalse(driver.findElement(summerRadio).isSelected());

        //scroll
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        // click vao radio button Summer
        if(!driver.findElement(summerRadio).isSelected()){
            driver.findElement(summerRadio).click();
            sleepInSecond(2);
        }

        //chuyen trang khac
        driver.navigate().to("https://material.angular.io/components/checkbox/examples");
        By checked = By.xpath("//label[text()='Checked']/preceding-sibling::div/input");
        By indeterminate = By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input");

        //check vao checkbox
        selectOneCheckbox(checked);
        selectOneCheckbox(indeterminate);
        // Ktra checkbox duoc chon chua
        Assert.assertTrue(driver.findElement(checked).isSelected());
        Assert.assertTrue(driver.findElement(indeterminate).isSelected());

        // Bo chon checkbox
        unSelectOneCheckbox(checked);
        unSelectOneCheckbox(indeterminate);
    }

   // @Test
    public void TC_05_Check_All_CheckBox(){
        driver.get("https://automationfc.github.io/multiple-fields/");
        // By checkbox = By.cssSelector("div.form-single-column input");
        By cssCheckbox = By.cssSelector("div.form-single-column>span.form-checkbox-item input");
        SelectAllCheclbox(cssCheckbox);
        UnselectAllCheckbox(cssCheckbox);
        selectOneCheckboxInAll(cssCheckbox,"Heart Attack");

    }
    @Test
    public void TC_06_Checbox_Radio_Custom(){
        driver.get("https://login.ubuntu.com/");

        driver.findElement(By.xpath("//span[text()='I don’t have an Ubuntu One account']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input#id_new_user")).isSelected());
        sleepInSecond(2);
        //scroll xuong cuoi trang
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        sleepInSecond(2);
        driver.findElement(By.xpath("//input[@id='id_accept_tos']/parent::div/label")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input#id_accept_tos")).isSelected());

    }

    @Test
    public void TC_07_Checkbox_Radio_Custom(){
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        WebElement xpathCanTho = driver.findElement(By.xpath("//span[text()='Cần Thơ']/parent::div/parent::div/parent::div/div/div"));
       sleepInSecond(2);
        if(xpathCanTho.isDisplayed()){
           xpathCanTho.click();
       }
        Assert.assertTrue(xpathCanTho.isDisplayed());
    }


    // Ham chon 1 checkbox
    public void selectOneCheckbox(By xpathCheckbox){
        if(!driver.findElement(xpathCheckbox).isSelected()){
            driver.findElement(xpathCheckbox).click();
            sleepInSecond(2);
        }
    }
    // Ham chon 1 checkbox
    public void unSelectOneCheckbox(By xpathCheckbox){
        if(driver.findElement(xpathCheckbox).isSelected()){
            driver.findElement(xpathCheckbox).click();
            sleepInSecond(2);
        }
    }
    //Ham chon all checkbox
    public void SelectAllCheclbox(By cssCheckbox){
        List<WebElement> listCheckbox = driver.findElements(cssCheckbox);
        for(WebElement item:listCheckbox){
            if(!item.isSelected()){
                item.click();
                Assert.assertTrue(item.isSelected());
            }
        }
    }
    //Ham bo chon all checkbox
    public void UnselectAllCheckbox(By cssCheckbox){
        List<WebElement> listCheckbox = driver.findElements(cssCheckbox);
        for(WebElement item:listCheckbox){
            if(item.isSelected()){
                item.click();
                Assert.assertFalse(item.isSelected());
            }
        }
    }
    //Chon 1 checkbox trong 1 list checkbox
    public void selectOneCheckboxInAll (By cssCheckbox, String checkboxName){
        List<WebElement> listCheckbox = driver.findElements(cssCheckbox);
        for(WebElement item:listCheckbox){
            if(!item.isSelected() && item.getAttribute("value").equals(checkboxName)){
                item.click();
                Assert.assertTrue(item.isSelected());
            }
        }
    }


//    public void selectCheckbox(String itemLabel,String itemInput, String option) {
//        List<WebElement> allItemsLabel = driver.findElements(By.cssSelector(itemLabel));
//        List<WebElement> allItemsInput = driver.findElements(By.cssSelector(itemInput));
//        for (Integer i : allItemsLabel.lastIndexOf()) {
//            WebElement itemInput = allItemsInput.;
//            String textItem = item.getText();
//            System.out.println("" + textItem);
//            if (textItem.equals(option)) {
//                item.click();
//                break; // 9-19 ko duoc kiem tra
//            }
//        }
//    }

    public void sleepInSecond( long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
