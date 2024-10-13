package src.main.java.advancedConcepts.Generics;

public class GenericCustom<T> {

    T obj;
    GenericCustom(T value)
    {
        this.obj= value;
    }

    public T getValue(){
        return obj;
    }
}
