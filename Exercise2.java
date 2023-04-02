import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise2 {
    
    public static void writeToFile(String result) {
        BufferedWriter writer = null;
        try {
            File file = new File("log.txt");
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(result);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file: " + e.getMessage());
            }
        }
    }
    
}




    
    
