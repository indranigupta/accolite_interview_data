package model;

import org.jfree.chart.JFreeChart;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Step 1: Create table in the database
            DatabaseManager.createTable();

            // Step 2: Read Excel data
            List<DataModelObject> data = ExcelReader.readExcel("C:\\Users\\indrani.gupta\\Downloads\\demo\\assignment2_ques2\\src\\main\\resources\\Accolite Interview Data - Q4 2023 - Grad Program November 2023.xlsx");

            // Step 3: Insert data into the database
            DatabaseManager.insertData(data);
            DatabaseManager.teamWithMaxInterviews();
            DatabaseManager.teamWithMinInterviews();
            DatabaseManager.top3Skills();
            DatabaseManager.top3Panels();
            DatabaseManager.skillsInPeakTime();

            // Step 4: Generate charts
            JFreeChart chart = ChartGenerator.createChart(data);

            // Step 5: Generate PDF and embed charts
            PdfGenerator.generatePdf(data, "Output.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
