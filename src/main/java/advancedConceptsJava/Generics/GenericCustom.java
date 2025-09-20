package advancedConceptsJava.Generics;

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
