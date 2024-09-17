package prj.bipower;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Common_Function {

    public void selectItemInDropdown(WebDriver driver, String parentCss, String option) {
        List<WebElement> allItems = driver.findElements(By.cssSelector(parentCss));
        for (WebElement item : allItems) {
            String textItem = item.getText();
            System.out.println("" + textItem);
            if (textItem.equals(option)) {
                item.click();
                break; // 9-19 ko duoc kiem tra
            }
        }
    }
}
