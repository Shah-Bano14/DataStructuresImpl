package src.main.java.advancedConcepts.serialization;

import java.io.*;
import java.util.logging.Logger;

public class MainClass {

    private static Logger log = Logger.getLogger(MainClass.class.getName());
    public static void main(String[] args) {

        PracticeSerialisation practiceSerialisation = new PracticeSerialisation(1, "Shah",
                "JPMC");
        practiceSerialisation.setNotSerializableValue(111);

        String filename = "./text.txt";
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        //Serialization
        try {
            fos = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(practiceSerialisation);

            log.info("Serialization done");

            oos.close();
            fos.close();
        } catch (FileNotFoundException f)
        {
            log.info("file not present");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Deserialization

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);
            PracticeSerialisation p = (PracticeSerialisation) ois.readObject();
            System.out.println(p);
            //Transient value doesnt get serialised
            log.info("the value " + p.getNotSerializableValue());
            log.info("Deserialization happened");


            ois.close();
            fis.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
