import java.io.*;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Random {
	
	public static void convertFileu(String filename) throws IOException, FileNotFoundException {
		FileReader filereader = new FileReader(filename);
		
		FileWriter filewriter = new FileWriter("triplog.csv");
		
		BufferedReader reader = new BufferedReader(filereader);
		BufferedWriter writer = new BufferedWriter(filewriter);
		
		writer.write("Time, Latitude, Longitude\n");
		
		String line;
		
		int interval = 0;
		
		String lat = "";
		String lon = "";
		
		while ((line = reader.readLine()) != null) {
            if (line.contains("<trkpt")) {
            	Pattern pattern = Pattern.compile(line + "=\"(.*?)\"");
                Matcher matcher = pattern.matcher(line);
                
                if (matcher.find()) {
                    // This removes any non-numeric characters except the negative sign and decimal point. It also trims extra spaces
                    lat = matcher.group(1).replaceAll("[^0-9.-]", "").trim();
                    lon =  matcher.group(1).replaceAll("[^0-9.-]", "").trim();
                } else {
                    lat = "";
                    lon = "";
                }
                
                if (!lat.isEmpty() && !lon.isEmpty()) {
                    writer.write(interval + "," + lat + "," + lon + "\n");
                    interval += 5;
                }
                
                
            }
        }
		
		// Closing the reader and writer
        reader.close();
        writer.close();

        System.out.println("Data converted successfully!");
		
	}

}
