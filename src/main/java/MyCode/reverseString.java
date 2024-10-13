package src.main.java.MyCode;

public class reverseString {

    public static void main(String args[]) {
        String name = "Shah applied for MACS";
        String reversedString = "";
        for (int i=0;i< name.length(); i++)
        {
            reversedString = name.charAt(i)+reversedString;
        }

        System.out.println("The reversed string is :" + reversedString);

    }
}
