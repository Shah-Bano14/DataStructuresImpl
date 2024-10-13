package src.main.java.advancedConcepts.Regex;

import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MainClass {
    private static Logger log = Logger.getLogger(MainClass.class.getName());
    public static void main(String[] args) {

        String pattern = ".[a-z&&^s]*";
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher("bano");
        boolean matchFound = matcher.find();

        if(matchFound)
        {
            log.info("match found");
        }
        else {
            log.info("match not found");
        }



    }
}
