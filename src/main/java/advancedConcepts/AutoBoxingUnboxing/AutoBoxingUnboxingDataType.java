package src.main.java.advancedConcepts.AutoBoxingUnboxing;

public class AutoBoxingUnboxingDataType {

    public static void main(String[] args) {

        int n = 2;
        Integer iobj = Integer.valueOf(n); //autoboxing
        System.out.println(iobj + " "+ iobj.getClass());
        int unboxing = iobj;
        System.out.println(unboxing);

        Character c = 'a';

        System.out.println(c + " type of c : "+ c.getClass() );
        char chUnbox = c;



    }
}
