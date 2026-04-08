package DAOPackage;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import ClassPackage.Report;
import Connector.SQLConnection;

import javax.swing.*;

//This class creates objects from the database, acts as a bridge between the database and GUIs
public class ReportDAO
{
    //Method that generates report
    public List<Report> generateReport(String type, Integer year, Integer month)
    {
        List<Report> reports = new ArrayList<>();

        try
        {
            Connection con = SQLConnection.getConnection();

            String query = "SELECT * FROM Report WHERE type = ?";

            // FILTER BY YEAR
            if(year != null)
            {
                query += " AND YEAR(generatedAt) = " + year;
            }

            // FILTER BY MONTH
            if(month != null)
            {
                query += " AND MONTH(generatedAt) = " + month;
            }

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, type);

            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                Report report = new Report(
                        rs.getInt("reportID"),
                        rs.getString("type"),
                        rs.getDate("generatedAt"),
                        rs.getString("content")
                );

                reports.add(report);
            }

            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return reports;
    }

    //Method that returns a list of report objects to access data from
    public List<Report> getAllReports()
    {

        //Declare a list of Report objects
        List<Report> reports = new ArrayList<>();

        //Connect to database
        try
        {
            Connection con = SQLConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Report");

            //Populate Report objects
            while (rs.next())
            {
                Report report = new Report
                (
                    rs.getInt("reportID"),
                    rs.getString("type"),
                    rs.getDate("generatedAt"),
                    rs.getString("content")
                );

                //Add objects to List
                reports.add(report);
            }

            //Close resources
            rs.close();
            stmt.close();
            con.close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        //Return list of Report objects
        return reports;

    }

    //Method that returns one report object to access data from
    public Report getOneReport(String inputDate)
    {

        //Declare a report object
        Report report = new Report();

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();

            //Search by year date
            if (inputDate != null && !inputDate.trim().isEmpty())
            {
                //Use a prepared statement in order to use user input in the query
                String query = "SELECT * FROM Report WHERE generatedAt = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, inputDate);

                //Execute query
                ResultSet rs = stmt.executeQuery();

                //Save attributes to object
                while (rs.next())
                {
                    report = new Report
                    (
                        rs.getInt("reportID"),
                        rs.getString("type"),
                        rs.getDate("generatedAt"),
                        rs.getString("content")
                    );
                }

                //Close resources
                rs.close();
                stmt.close();
                con.close();

                //Return report object
                return report;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        //Return no results if user input does not match any database entries
        return null;

    }

    //Method to create a report in the database
    public void createReport(int inputReportID, String inputType, Date inputGeneratedAt, String inputContent)
    {

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();

            //Query for creating a new entry into the database
            String query = "INSERT INTO Report VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, inputReportID);
            stmt.setString(2, inputType);
            stmt.setDate(3, inputGeneratedAt);
            stmt.setString(4, inputContent);


            //Execute query
            stmt.executeUpdate();

            //Close resources
            stmt.close();
            con.close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

}

