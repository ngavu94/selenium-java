package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Topic_18_UploadFile {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String image1 = "image01.png";
    String image2 ="image02.png";
    String image3 ="image03.png";

    String image01Path = projectPath+File.separator+"uploadFiles"+File.separator+image1;
    String image02Path = projectPath+File.separator+"uploadFiles"+File.separator+image2;
    String image03Path = projectPath+File.separator+"uploadFiles"+File.separator+image3;

    @BeforeClass
    public void BeforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void TC_01_Upload_File_By_Sendkey(){
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

//        String osName = System.getProperty("os.name");
//        Keys key;
//        if(osName.startsWith("Windows")){
//            key=Keys.CONTROL;
//        }else {
//            key=Keys.COMMAND;
//        }
//        Keys cmdctrl = Platform.getCurrent().is(Platform.WINDOWS)? Keys.CONTROL : Keys.COMMAND;
//        String characters =  Platform.getCurrent().is(Platform.WINDOWS)? "\\":"/";
////Hoac dung  File.separator
//
//
//        String projectPath = System.getProperty("user.dir");
//        String image1 = "image01.png";
//        String image2 ="image02.png";
//        String image3 ="image03.png";
        //Window: \\
        //Mac: /
        //Để máy khác cũng chayj được thi phai dung duong dan tuong doi

        //senKey lan luot tung file
//      driver.findElement(By.xpath("//input[@type='file']")).sendKeys(image01Path);
//      driver.findElement(By.xpath("//input[@type='file']")).sendKeys(image02Path);
//      driver.findElement(By.xpath("//input[@type='file']")).sendKeys(image03Path);
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(image01Path+"\n"+image02Path+"\n"+image03Path);

      driver.findElement(By.xpath("(//button[@class='btn btn-primary start']/span[text()='Start'])[1]")).click();
      driver.findElement(By.xpath("(//button[@class='btn btn-primary start']/span[text()='Start'])[2]")).click();
      driver.findElement(By.xpath("(//button[@class='btn btn-primary start']/span[text()='Start'])[3]")).click();

      sleepInSecond(5);
        Assert.assertTrue(driver.findElement(By.xpath("//a[@download='"+image1+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[@download='"+image2+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[@download='"+image3+"']")).isDisplayed());

    }

    @Test
    public void TC_02_Upload_File_By_AutoIT(){
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

//        WinWaitActive("File Upload")
//        Send("D:\SoftwareTestingMaterial\UploadFile.txt")
//        Send("{ENTER}")

        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(image01Path+"\n"+image02Path+"\n"+image03Path);

        driver.findElement(By.xpath("(//button[@class='btn btn-primary start']/span[text()='Start'])[1]")).click();
        driver.findElement(By.xpath("(//button[@class='btn btn-primary start']/span[text()='Start'])[2]")).click();
        driver.findElement(By.xpath("(//button[@class='btn btn-primary start']/span[text()='Start'])[3]")).click();

        sleepInSecond(5);
        Assert.assertTrue(driver.findElement(By.xpath("//a[@download='"+image1+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[@download='"+image2+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[@download='"+image3+"']")).isDisplayed());

    }



    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
