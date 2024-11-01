/**
 * @author Arboy Magomba
 * @version 1.0
 * Project 1
 */

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Convert {
    public static void convertFile(String filename) throws IOException, FileNotFoundException {
        // Create reader
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        // Create writer
        BufferedWriter writer = new BufferedWriter(new FileWriter("triplog.csv"));

        // Write headers
        writer.write("Time,Latitude,Longitude\n");

        String line;
        
        int time = 0; // Time variable which keeps track of intervals 0,5,10,15,20,15...etc
        String lat = "", lon = "";
        
        while ((line = reader.readLine()) != null) {
            if (line.contains("<trkpt")) {
                lat = extractValue(line, "lat");
                lon = extractValue(line, "lon");

                if (!lat.isEmpty() && !lon.isEmpty()) {
                    writer.write(time + "," + lat + "," + lon + "\n");
                    time += 5;
                }
            }
        }

        // Closing the reader and writer
        reader.close();
        writer.close();

        System.out.println("Data converted successfully!");
    }

    // Another method to help extract the Values from the gpx file while considering data anomalies present in the file
    private static String extractValue(String line, String attrName) {
        Pattern pattern = Pattern.compile(attrName + "=\"(.*?)\"");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            // This removes any non-numeric characters except the negative sign and decimal point. It also trims extra spaces
            return matcher.group(1).replaceAll("[^0-9.-]", "").trim();
        } else {
            return "";
        }
    }
}
