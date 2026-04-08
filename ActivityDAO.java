package DAOPackage;

import java.sql.*;
import java.util.*;
import java.sql.Date;

import Connector.SQLConnection;
import ClassPackage.Activity;

import javax.swing.*;

//This class creates objects from the database, acts as a bridge between the database and GUIs
public class ActivityDAO
{

    //Method that returns a list of Activity objects to access data from
    public List<Activity> getAllActivities()
    {

        //Declare a list of Manager objects
        List<Activity> activities = new ArrayList<>();

        //Connect to database
        try
        {
            Connection con = SQLConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Activity");

            //Populate Activity objects
            while(rs.next())
            {
                Activity activity = new Activity
                    (
                        rs.getInt("activityID"),
                        rs.getString("title"),
                        rs.getDate("date"),
                        rs.getTime("time"),
                        rs.getString("description"),
                        rs.getString("participantNotes"),
                        rs.getString("status")
                    );

                //Add objects to List
                activities.add(activity);
            }

            //Close resources
            rs.close();
            stmt.close();
            con.close();

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        //Return list of Activity objects
        return activities;

    }

    //Method that returns one activity object to access data from
    public Activity getOneActivity(String inputTitle)
    {

        //Declare an Activity object
        Activity activity = new Activity();

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();

            //Search by Activity Title
            if(inputTitle != null && !inputTitle.trim().isEmpty())
            {

                //Use a prepared statement in order to use user input in the query
                String query = "SELECT * FROM Activity WHERE title = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                //Set string to names (changes ? in statement to names)
                stmt.setString(1, inputTitle);

                //Execute query
                ResultSet rs = stmt.executeQuery();

                //Save attributes to object
                while (rs.next())
                {
                    activity = new Activity
                    (
                        rs.getInt("activityID"),
                        rs.getString("title"),
                        rs.getDate("date"),
                        rs.getTime("time"),
                        rs.getString("description"),
                        rs.getString("participantNotes"),
                        rs.getString("status")
                    );
                }

                //Close resources
                rs.close();
                stmt.close();
                con.close();

                //Return object
                return activity;

            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        //Return no results if user input does not match any database entries
        return null;

    }

    //Method to create an activity in the database
    public void createActivity(int inputActivityID, String inputTitle, Date inputDate, Time inputTime,
                               String inputDescription, String inputParticipantNotes, String inputStatus)
    {

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();

            //Query for creating a new entry into the database
            String query = "INSERT INTO Activity (title, date, time, description, participantNotes, status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, inputTitle);
            stmt.setDate(2, inputDate);
            stmt.setTime(3, inputTime);
            stmt.setString(4, inputDescription);
            stmt.setString(5, inputParticipantNotes);
            stmt.setString(6, inputStatus);

            //Execute query
            stmt.executeUpdate();

            //Close resources
            stmt.close();
            con.close();

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    //Method to modify an activity in the database
    public void modifyActivity(int inputActivityID, String inputTitle, Date inputDate, Time inputTime,
                               String inputDescription, String inputParticipantNotes, String inputStatus)
    {

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();

            //Search by Activity Title
            if(inputTitle != null && !inputTitle.trim().isEmpty())
            {

                //Use a prepared statement in order to use user input in the query
                String query = "UPDATE Activity SET title = ?, date = ?, time = ?, description = ?, participantNotes = ?, status = ? WHERE activityID =?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, inputTitle);
                stmt.setDate(2, inputDate);
                stmt.setTime(3, inputTime);
                stmt.setString(4, inputDescription);
                stmt.setString(5, inputParticipantNotes);
                stmt.setString(6, inputStatus);
                stmt.setInt(7, inputActivityID);

                //Execute query
                stmt.executeUpdate();

                //Close resources
                stmt.close();

            }

            //Close connection
            con.close();

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    //Method to delete an activity in the database
    public void deleteActivity(String inputTitle)
    {

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();

            //Search by Activity Title
            if(inputTitle != null && !inputTitle.trim().isEmpty())
            {

                //Use a prepared statement in order to use user input in the query
                String query = "DELETE FROM Activity WHERE title = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, inputTitle);

                //Execute query
                stmt.executeUpdate();

                //Close resources
                stmt.close();

            }

            //Close connection
            con.close();

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

}
