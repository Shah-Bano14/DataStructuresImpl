package src.main.java.advancedConcepts.serialization;

import java.io.Serializable;

/**
 * Converts objects to  byte stream
 */
public class PracticeSerialisation implements Serializable {

    /**
     * This value is to maintain the version of serialization so that
     * on each conversion to byte stream the value gets updated, so if an attacker tries to change the value, the version increases and
     * we can find out if any attack happened
     * default = 1L
     * type: long
     */
    private static long SerialVersionUid = 1L;

    private int id;
    private String name;
    private String organisation;
    /**
     * The transient values dont get serialised
     */
    transient int notSerializableValue;

    public PracticeSerialisation(int id, String name, String organisation) {
        this.id = id;
        this.name = name;
        this.organisation = organisation;
    }

    @Override
    public String toString() {
        return "PracticeSerialisation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", organisation='" + organisation + '\'' +
                ", notSerializableValue=" + notSerializableValue +
                '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public int getNotSerializableValue() {
        return notSerializableValue;
    }

    public void setNotSerializableValue(int notSerializableValue) {
        this.notSerializableValue = notSerializableValue;
    }
}
