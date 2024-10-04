package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class Topic_09_Parameter {

        WebDriver driver;

        //    @Parameters("browser")
        @Parameters({"browser","version"})
        @BeforeClass
        public void beforeClass(String browserName, String browserVersion) {
            driver= getBrowserDriver(browserName);
            System.out.println("Browser "+browserName + "with version "+browserVersion);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @Parameters("environment")
        @Test
        public void TC_01_Login_ToSystem(@Optional("live") String environmentName) throws InterruptedException {
            //Chức năng login
            driver.get(getEnvironmentUrl(environmentName)+ "/index.php/customer/account/login/");
            driver.findElement(By.xpath("//*[@id='email']")).sendKeys("selenium_11_01@gmail.com");
            driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("111111");
            driver.findElement(By.xpath("//*[@id='send2']")).click();
            // System.out.println("Age: " + age);
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("selenium_11_01@gmail.com"));
            //Action cho tất cả các user đều giống nhau
            //Mua sản phẩm - thanh toán - verify
            driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
            driver.findElement(By.xpath("//a[text()='Log Out']")).click();
        }
        @AfterClass
        public void afterClass(){
            driver.quit();
        }

    public WebDriver getBrowserDriver(String browserName) {
        if(browserName.equals("firefox")){
            driver = new FirefoxDriver();
        } else if (browserName.equals("chrome")) {
            driver= new ChromeDriver();
        }else if(browserName.equals("edge")){
            driver = new EdgeDriver();
        }else{
            throw new RuntimeException("Browser Name is not valid");
        }
        return driver;
    }
    public String getEnvironmentUrl(String environmentName){
            String urlValue;
            if(environmentName.equals("dev")){
                urlValue="http://dev.techpanda.org";
            } else if (environmentName.equals("testing")) {
                urlValue="http://testing.techpanda.org";
            } else if (environmentName.equals("staging")) {
                urlValue="http://staging.techpanda.org";
            } else if (environmentName.equals("live")) {
                urlValue="http://live.techpanda.org";
            }else{
                throw new RuntimeException("Environment name is not valid");
            }
            return  urlValue;
    }
}
