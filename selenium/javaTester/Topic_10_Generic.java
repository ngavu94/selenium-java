package javaTester;

import java.util.ArrayList;
import java.util.List;

public class Topic_10_Generic {
    public static void main(String[] args) {
        //List chỉ chứa kiểu dữ liệu String
        List<String> students = new ArrayList<String>();
        students.add("Nga");
        students.add("Vương");
        students.add("Hương");
        students.add("Nam");

        //non-Generic
        List address = new ArrayList<>();
        address.add("Hà Nội"); //String
        address.add(15); //Integer
        address.add(true); //Boolean
        address.add(10.6); //Float
    }
}
