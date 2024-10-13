package src.main.java.advancedConcepts.enumeration;

public class MainClass {

    public static void main(String[] args) {
        Color color = Color.GREEN;
        System.out.println(color.name());
        System.out.println(color.getColor());

        for (Color c: Color.values()
             ) {
            System.out.println(c.getColor());

        }

    }

}
