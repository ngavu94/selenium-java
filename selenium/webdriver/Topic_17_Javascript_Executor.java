package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_17_Javascript_Executor {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();
        jsExecutor = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
       // driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }

    public void TC_01_Javascript_Executor(){
      executeForBrowser("window.location='http://live.techpanda.org/'");
      //verify domain
      String pandaDomain =(String) executeForBrowser("return document.domain;");
        Assert.assertEquals(pandaDomain,"live.techpanda.org");
        //verify url
        String pandaUrl = (String) executeForBrowser("return document.URL;");
        Assert.assertEquals(pandaUrl,"http://live.techpanda.org/");

        //highlight
        hightlightElement("//a[text()='Mobile']");
        //Open mobile page
        clickToElementByJS("//a[text()='Mobile']");
        clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
        //Verify message hien thi
        String samsungMessage= getInnerText();
        Assert.assertTrue(samsungMessage.contains("Samsung Galaxy was added to your shopping cart."));
        //Open CUSTOMER SERVICE page
        clickToElementByJS("//a[text()='Customer Service']");
        Assert.assertEquals((String) executeForBrowser("return document.title;"),"Customer Service");
        //scroll
        scrollToElementOnDown("//input[@id='newsletter']");
        //nhap email hop le
        sendkeyToElementByJS("//input[@id='newsletter']","ngavt1234@gmail.com");
        //click button Subscriber
        clickToElementByJS("//button[@title='Subscribe']");
        Assert.assertTrue(getInnerText().contains("Thank you for your subscription."));
        //navigate toi fb
        navigateToUrlByJS("https://www.facebook.com/");
        //verify domain
       Assert.assertEquals((String) executeForBrowser("return document.domain;"),"facebook.com");

    }

    @Test
    public void TC_02_Javascript_Executor(){
        driver.get("https://sieuthimaymocthietbi.com/account/register");
        driver.findElement(By.xpath("//button[text()='Đăng ký']")).click();
        String mess = getElementValidationMessage("//input[@id='lastName']");
        Assert.assertEquals(mess,"Please fill out this field.");
    }

//common function
    public Object executeForBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText() {
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor.executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
        return status;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }
}
