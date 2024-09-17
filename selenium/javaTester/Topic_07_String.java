package javaTester;

import java.sql.SQLOutput;

public class Topic_07_String {
    public static void main(String[] args) {
        String firstName= "Automation";
        String lastName ="FC";
        String fullName = firstName +" "+lastName;
        System.out.println(fullName);
        String fullName2 = firstName.concat(" ").concat(lastName);
        System.out.println(fullName2);
    }
//    public void concatString(){
//        String firstName= "Automation";
//        String lastName ="FC";
//        String fullName = firstName +" "+lastName;
//        System.out.println(fullName);
//        String fullName2 = firstName.concat(firstName).concat(lastName);
//        System.out.println(fullName2);
//    }


}
