package javaTester;

import com.beust.ah.A;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Topic_01_Data_Type {
    // Các kiểu dữ lieu
    // Kieu nguyen thuy
    // Kieu sô nguyen: byte, short, int, long
    byte bNumber = 40;
    short sNumber = 3000;
    int iNumber = 15635658;
    long lNumber = 234343400;

    // Kieu so thuc: Float, double
    float fNUmber = 9.99F;
    double dNumber = 9.99;
    //Kieu ky tu: Char
    char c = 'c';
    //KIeu logic: boolean
    Boolean gioiTinh = true;

    // kieu du lieu tham chieu (Reference type- kieu tham chieu)

    String str = "char";
    //Class

     FirefoxDriver firefoxDriver = new FirefoxDriver();
    //Object
    Object oClass = "Automation 31";
    //Array
    int[] studentAge = {12,23,24};
    String[] studentName = {"Nga", "Nam", "Hung"};


    //Collection
    List<String> arrayList = new ArrayList<String>();
    List<String> studentCity = new LinkedList<>();
    List<String> studentPhone = new Vector<>();

    //Khai bao 1 bien de luu tru 1 dư lieu nao do
    //Access modifier: Pham vi truy cap (public, private, protected, default
    //Kieu dư lieu
    //Ten bien
    // Gia tri cua bien


}
