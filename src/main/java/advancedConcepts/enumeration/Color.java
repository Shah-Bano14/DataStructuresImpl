package src.main.java.advancedConcepts.enumeration;

/**
 * Enums in java: the values are contants and never changes throughout the execution
 */
public enum Color {
    RED("red"),GREEN("green");
    String color;
    Color(String color) {
        this.color = color;
    }

    /**
     *
     *
     * @return
     */
    public String getColor()
    {
        return color;
    }
}
