import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		try {
			// Create file reader
			FileReader reader= new FileReader("triplog.gpx");
			BufferedReader bufferedReader = new BufferedReader(reader);
			
			// Create file writer
			FileWriter writer = new FileWriter("triplogCSV.csv");
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			bufferedWriter.write("Time, Latitude, Longitude");
			bufferedWriter.newLine();

			String line;
            int counter = 0;
            while ((line = bufferedReader.readLine()) != null) {
                Pattern pattern = Pattern.compile("lat=\"\\s*(.*?)\\s*\"\\s+lon=\"\\s*(.*?)\\s*\"");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String lat = matcher.group(1).replaceAll("\\s+|\\?", "");
                    String lon = matcher.group(2).replaceAll("\\s+|\\?", "");
                    bufferedWriter.write(Integer.toString(counter));
                    bufferedWriter.write(",");
                    bufferedWriter.write(lat);
                    bufferedWriter.write(",");
                    bufferedWriter.write(lon);
                    bufferedWriter.newLine();  // This is to add a new line after writing each line into the new file
                    counter += 5;
                }
            }
			
			reader.close();
			writer.close();
			
			System.out.println("Data copied successfully");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
	
