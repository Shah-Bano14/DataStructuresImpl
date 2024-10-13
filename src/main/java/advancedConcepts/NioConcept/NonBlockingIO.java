package src.main.java.advancedConcepts.NioConcept;

import java.io.*;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.util.logging.Logger;

/**
 * This is nio package to handle io operations for multiple threads basically supporting mutilthreading
 * In this create a file input or output stream and then craete a channel for that stream to read or write
 * channel can be file channel or socket channel depending on the requirement
 * and then create a buffer either to read into it or to write from it
 */
public class NonBlockingIO {

    private static Logger log = Logger.getLogger(NonBlockingIO.class.getName());

    public static void main(String[] args) throws IOException {

        String source = System.getProperty("user.dir")+ File.separator + "readFile.txt";
        String dest = System.getProperty("user.dir") + File.separator + "destFile.txt";
        FileInputStream fileInputStream = new FileInputStream(source);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int bytesRead = channel.read(byteBuffer);

        log.info("File read and byte read are : " + bytesRead);

        FileOutputStream fileOutputStream = new FileOutputStream(dest);
        FileChannel channel1 = fileOutputStream.getChannel();
        byteBuffer.flip();
        int bytes = channel1.write(byteBuffer);

        log.info(("date written to destination file and byte size is "+ bytes ));

        }


    }
