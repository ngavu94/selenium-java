package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_12_Interactions {
    WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //@Test
    public void TC_01_Tooltip() {
        Actions builder = new Actions(driver);
        WebElement toolTip = driver.findElement(By.cssSelector("input#age"));
        driver.get("https://automationfc.github.io/jquery-tooltip/");

        Assert.assertEquals(toolTip.getAttribute("title"), "We ask for your age only for statistical purposes.");
        System.out.println("1 " + toolTip.getAttribute("title"));
        builder.moveToElement(toolTip).perform();
        sleepInSecond(2);
        Assert.assertEquals(toolTip.getAttribute("title"), "");
        System.out.println("2 " + toolTip.getAttribute("title"));


    }

    @Test
    public void TC_02_Hover_To_Element() {
        Actions builder = new Actions(driver);
        driver.get("https://www.myntra.com/");
        builder.moveToElement(driver.findElement(By.xpath("//a[@href='/shop/kids']"))).perform();
    }

    @Test
    public void TC_03_Fahasa() {
        Actions builder = new Actions(driver);
        driver.get("https://www.fahasa.com/");
        sleepInSecond(2);
        builder.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
        builder.moveToElement(driver.findElement(By.xpath("//span[text()='FOREIGN BOOKS']"))).perform();
        sleepInSecond(1);
        Assert.assertEquals(driver.findElement(By.xpath("//a[@title='FOREIGN BOOKS']/span")).getText(),"FOREIGN BOOKS");
    }
    @Test
    public void TC_04_Click_And_Hold(){
        Actions action = new Actions(driver);
        driver.get("https://automationfc.github.io/jquery-selectable/");
        sleepInSecond(2);
        action.clickAndHold(driver.findElement(By.xpath("//li[text()='1']")))// Click vào số 1 và giữ chột
                .moveToElement(driver.findElement(By.xpath("//li[text()='4']")))// Di chuột tới số 4
                .release() // Nhả chuột trái ra = kết thucs sự kện
                .perform(); // Thực thi caác câu lenh trên

        //li.ui-selected
        List<WebElement> btnList = driver.findElements(By.cssSelector("li.ui-selected"));
            Assert.assertEquals(btnList.get(0).getText(),"1");
        Assert.assertEquals(btnList.get(1).getText(),"2");
        Assert.assertEquals(btnList.get(2).getText(),"3");
        Assert.assertEquals(btnList.get(3).getText(),"4");
        System.out.println("value"+btnList.get(0).getText());
        System.out.println("value"+btnList.get(1).getText());
        System.out.println("value"+btnList.get(2).getText());
        System.out.println("value"+btnList.get(3).getText());
    }
    @Test
    public void TC_05_Click_And_SelectElement(){
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> btnListRandom = driver.findElements(By.cssSelector("ol#selectable>li"));
        Actions action = new Actions(driver);
        //Giu phim ctrl ko nhả
        action.keyDown(Keys.CONTROL).perform();
        action.click(btnListRandom.get(0))
                .click(btnListRandom.get(2))
                .click(btnListRandom.get(4))
                .click(btnListRandom.get(6)).perform();
        //Nhảphisim Ctrl
        action.keyUp(Keys.CONTROL).perform();
//Verify các button da duoc click
        List<WebElement> btnList2 = driver.findElements(By.cssSelector("li.ui-selected"));
        Assert.assertEquals(btnList2.size(),"4");

        Assert.assertEquals(btnList2.get(0).getText(),"1");
        Assert.assertEquals(btnList2.get(1).getText(),"3");
        Assert.assertEquals(btnList2.get(2).getText(),"5");
        Assert.assertEquals(btnList2.get(3).getText(),"7");
    }

    @Test
    public void TC_06_Double_Click(){
        Actions action = new Actions(driver);
        driver.get("https://automationfc.github.io/basic-form/index.html");

        action.moveToElement(driver.findElement(By.xpath("//button[text()='Double click me']")))
                .doubleClick()
                .release()
                .perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!");
    }
    @Test
    public void TC_07_Right_Click(){
        Actions action = new Actions(driver);
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

        action.moveToElement(driver.findElement(By.xpath("//span[text()='right click me']")))
                .contextClick()
                .release()
                .perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.context-menu-icon-quit>span")).getText(),"Quit");
    }

    @Test
    public void TC_08_Drag_And_Drop(){
        Actions action = new Actions(driver);
        driver.get("https://automationfc.github.io/kendo-drag-drop/");
        sleepInSecond(3);
        WebElement sourceElement= driver.findElement(By.cssSelector("div#draggable"));
        WebElement targetElement = driver.findElement(By.cssSelector("div#droptarget"));

        action.dragAndDrop(sourceElement,targetElement)
                .release()
                .perform();

        Assert.assertEquals(targetElement.getText(),"You did great!");
    }
    @Test
    public void TC_09_Drag_And_Drop(){
        Actions action = new Actions(driver);
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        sleepInSecond(3);
        WebElement sourceElement= driver.findElement(By.cssSelector("div#draggable"));
        WebElement targetElement = driver.findElement(By.cssSelector("div#droptarget"));

        action.dragAndDrop(sourceElement,targetElement)
                .release()
                .perform();

        Assert.assertEquals(targetElement.getText(),"You did great!");
    }

//    @AfterClass
//    public void AfterClass() {
//        driver.quit();
//    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
