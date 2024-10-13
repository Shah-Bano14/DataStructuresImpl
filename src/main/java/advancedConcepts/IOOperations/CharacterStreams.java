package src.main.java.advancedConcepts.IOOperations;

import javax.xml.stream.events.Characters;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class CharacterStreams {

    private static Logger log = Logger.getLogger(CharacterStreams.class.getName());

    public static void main(String[] args) throws IOException{

        String readFilename = System.getProperty("user.dir")
                + File.separator+"readFile.txt";
        String writeFilename = System.getProperty("user.dir")
                + File.separator+"dest.txt";

        InputStream inputStream = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileWriter fr = null;
        BufferedWriter bw = null;

        try {
            inputStream = new FileInputStream(readFilename);
            isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
            fr = new FileWriter(writeFilename);
            bw = new BufferedWriter(fr);
            String content;
            while((content = br.readLine())!= null) {
                if (content.length() > 0) {
                    bw.write(content);
                    bw.newLine(); // Add a newline after each line if needed
                }
            }

            log.info("Writing completed");

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            if (bw != null) {
                bw.flush(); // Flush the buffer
                bw.close();
            }
            fr.close();
            br.close();
            isr.close();
        }
    }

}


