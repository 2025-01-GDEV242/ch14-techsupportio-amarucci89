import java.io.*;
import java.util.*;

/**
 * A class that reads responses from a file.
 *
 * @author Alessandro Marucci
 * @version 2025-04-28
 */
public class ResponseReader
{
    private static final String FILE_OF_DEFAULT_RESPONSES = "default.txt";
    private static final String FILE_OF_MAIN_RESPONSES = "responses.txt";

    /**
     * Constructor for objects of class ResponseReader
     */
    public ResponseReader()
    {
    }

    /**
     * Read a list of default responses.
     * @return The list of responses.
     */
    public List<String> readDefaultResponses()
    {
        String filename = FILE_OF_DEFAULT_RESPONSES;
        List<String> defaultResponses = new ArrayList<>();
        
        try {
            BufferedReader reader = 
                new BufferedReader(new FileReader(filename));
            String response = reader.readLine();
            while(response != null) {
                defaultResponses.add(response);
                response = reader.readLine();
            }
            reader.close();
        }
        
        catch(FileNotFoundException e) {
            System.err.println("Unable to open " + filename);
        }
        
        catch(IOException e) {
            System.err.println("A problem was encountered reading " +
                               filename);
        }
        
        if(defaultResponses.size() == 0) {
            defaultResponses.add("Could you elaborate on that?");
        }
        
        return defaultResponses;  
    }
}
