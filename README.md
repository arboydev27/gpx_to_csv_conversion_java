Overview:
The first part of a multi-project series, this Java program converts GPS data from a GPX file into a CSV format, allowing for easier data manipulation and integration in future projects.

A GPX file contains GPS data such as waypoints, routes, and tracks. For this project, we extract latitude and longitude data points from a provided GPX file (triplog.gpx), which was recorded during a recent trip. The program will process this data to create a CSV file (triplog.csv) containing time, latitude, and longitude in a standardized, structured format.

Features:
1. Data Extraction: Reads GPS data (latitude, longitude) from the GPX file and organizes it in a CSV format.
2. Time Increment: Adds a time column starting from 0 minutes, incrementing by 5 minutes for each point.
3. Error Handling: Handles inconsistencies in the GPX data, including extra spaces, newlines, and erroneous characters, ensuring clean data in the output CSV file.
4. Header Creation: Includes a header row ("Time,Latitude,Longitude") for ease of use in spreadsheet programs.

Requirements:
1. Conversion Method: Implement convertFile(String filename) in the Convert.java class. This method reads the GPX file and creates the CSV file, handling data anomalies as needed.
2. Data Anomalies Handling: Remove extra whitespaces, newlines, and '?' characters from the data to ensure a clean CSV output.
3. General Solution: The solution must work with any GPX data file, as the test file in Zybooks may differ from triplog.gpx.

Getting Started:
1. Setup: Clone the repository and import the files (Driver.java and triplog.gpx) into your preferred IDE.
2. Run: Execute Driver.java, which calls the convertFile method in Convert.java.
3. View Output: The resulting CSV file (triplog.csv) will be generated in the project directory.