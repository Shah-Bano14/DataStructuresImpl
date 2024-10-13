package src.main.java.advancedConcepts.IOOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

public class ByteStreams {

    private static Logger log = Logger.getLogger(ByteStreams.class.getName());

    public static void main(String[] args) throws IOException {

        String readFilename = System.getProperty("user.dir")
                + File.separator+"readFile.txt";
        String writeFilename = System.getProperty("user.dir")
                + File.separator+"dest.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(readFilename);
            fos = new FileOutputStream(writeFilename);
            int content;
            while((content = fis.read())!=-1) {
                fos.write((byte)content);
            }

            log.info("Writing completed");

        } catch (Exception e) {
            e.printStackTrace();
        }
            finally
         {
            fis.close();
            fos.close();
        }
    }
}
