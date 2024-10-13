package src.main.java.advancedConcepts.network;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

public class MainClass {

    private static Logger log = Logger.getLogger(MainClass.class.getName());
    public static void main(String[] args) throws UnknownHostException {

        String url = "www.google.com";

        InetAddress inetAddress = Inet4Address.getByName(url);

        log.info(" "+inetAddress.getAddress());
        log.info(" host address " + inetAddress.getHostAddress());
        log.info(" is loopback address "+ inetAddress.isLoopbackAddress());
        log.info(" site local address "+ inetAddress.isSiteLocalAddress());


    }
}
