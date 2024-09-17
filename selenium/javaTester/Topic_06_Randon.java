package javaTester;

import graphql.execution.preparsed.persisted.ApolloPersistedQuerySupport;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import java.sql.SQLOutput;
import java.util.Random;

public class Topic_06_Randon {
    WebDriver driver;
    //Java BuildIn- sẽ cung cấp sẵn - lấy ra sử dụng

    //Java Libraries (do 1 cá nhân - tổ chức tự viết)
    public static void main(String[] args) {
        Random ran = new Random();
        System.out.println(ran.nextInt());
        System.out.println(ran.nextDouble());
        System.out.println(ran.nextFloat());
        System.out.println(ran.nextBoolean());
        System.out.println(ran.nextInt(99999));
        System.out.println(ran.nextInt(99999));
        System.out.println(ran.nextInt(99999));
        System.out.println(ran.nextInt(99999));
        System.out.println(ran.nextInt(99999));
        //String email = getEmailAddress();

    }
//    AfterClass
//    public void afterClass(){driver.quit()}
    public String getEmailAddress(){
        Random ran = new Random();
        String emailAddress = "Automation"+ran.nextInt(99999)+"@gmail.net";
        System.out.println(emailAddress);
        return emailAddress;
    }
    public String getMonthOfYear(){
        Random ran = new Random();
        String monthOfYear = +ran.nextInt(12)+"/"+ran.nextInt(2040);
        System.out.println(monthOfYear);
        return monthOfYear;
    }
}
