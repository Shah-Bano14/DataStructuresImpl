package src.main.java.advancedConcepts.annotations;

import java.lang.reflect.Method;

public class MainClass {

    @CustomAnnotation(getId = 10, getName = "Shah")
    public void useAnnotationInMethod()
    {
        System.out.println("I am using custom  annotation inside the method");
    }
    public static void main(String[] args) throws NoSuchMethodException {

        MainClass mainClass = new MainClass();
        Method method = mainClass.getClass().getMethod("useAnnotationInMethod");
        CustomAnnotation customAnnotation = method.getAnnotation(CustomAnnotation.class);
        System.out.println(customAnnotation.getId() +" "+ customAnnotation.getName());

    }
}
