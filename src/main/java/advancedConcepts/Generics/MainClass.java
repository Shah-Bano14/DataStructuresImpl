package src.main.java.advancedConcepts.Generics;

public class MainClass {

    public static void main(String[] args) {

        GenericCustom<Integer> genericCustom = new GenericCustom<>(10);
        System.out.println(genericCustom.getValue());

        GenericCustom<String> genericCustom1 = new GenericCustom<>("Shah");
        System.out.println(genericCustom1.getValue());
    }
}
