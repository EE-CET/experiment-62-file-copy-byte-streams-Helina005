

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";

        // Step 1: Copy the file using Byte Streams
        try (FileInputStream fin = new FileInputStream(sourceFile);
             FileOutputStream fout = new FileOutputStream(destFile)) {

            int byteData;
            // Read byte by byte from source and write to destination
            while ((byteData = fin.read()) != -1) {
                fout.write(byteData);
            }
            
            System.out.println("File Copied");

        } catch (IOException e) {
            // If source.txt is missing, this handles the error
            return;
        }

        // Step 2: Display the content of the destination file
        try (FileInputStream fin = new FileInputStream(destFile)) {
            int byteData;
            while ((byteData = fin.read()) != -1) {
                System.out.print((char) byteData);
            }
            System.out.println(); // New line at the end
            
        } catch (IOException e) {
            // Handle read errors
        }
    }
}