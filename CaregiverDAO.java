package DAOPackage;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

import Connector.SQLConnection;
import ClassPackage.Caregiver;

import javax.swing.*;

//This class creates objects from the database, acts as a bridge between the database and GUIs
public class CaregiverDAO
{

    //Method that returns a list of Caregiver objects to access data from
    public List<Caregiver> getAllCaregivers()
    {

        //Declare a list of Caregiver objects
        List<Caregiver> caregivers = new ArrayList<>();

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Caregiver");

            //Populate Caregiver objects
            while(rs.next())
            {
                Caregiver caregiver = new Caregiver
                (
                    rs.getString("workID"),
                    rs.getString("fName"),
                    rs.getString("lName"),
                    rs.getString("email"),
                    rs.getString("phoneNo"),
                    rs.getBlob("profileImage")
                );

                //Add objects to List
                caregivers.add(caregiver);
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

        //Return list of Caregiver objects
        return caregivers;

    }

    //Method that returns one caregiver object to access data from (BY WORK ID)
    public Caregiver getOneCaregiverViaID(String inputWorkID)
    {

        //Declare a Caregiver object
        Caregiver caregiver = null;

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();

            //Search by workID
            if(inputWorkID != null && !inputWorkID.trim().isEmpty())
            {
                //Use a prepared statement in order to use user input in the query
                String query = "SELECT * FROM Caregiver WHERE workID = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, inputWorkID);

                //Execute query
                ResultSet rs = stmt.executeQuery();

                //Save attributes to object
                while(rs.next())
                {
                    caregiver = new Caregiver
                    (
                        rs.getString("workID"),
                        rs.getString("fName"),
                        rs.getString("lName"),
                        rs.getString("email"),
                        rs.getString("phoneNo"),
                        rs.getBlob("profileImage")
                    );
                }

                //Close resources
                rs.close();
                stmt.close();
                con.close();

                //Return Caregiver object
                return caregiver;
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        //Return no results if user input does not match any database entries
        return null;

    }

    //Method that returns one caregiver object to access data from (BY NAME)
    public Caregiver getOneCaregiverViaName(String inputFullName)
    {

        //Declare a Caregiver object
        Caregiver caregiver = null;

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();

            //Search by Full name
            if(inputFullName != null && !inputFullName.trim().isEmpty())
            {

                //Split the full name into a first and last name
                String[] nameSplit = inputFullName.trim().split(" ");

                //Check if user entered a full name
                if(nameSplit.length < 2)
                {
                    JOptionPane.showMessageDialog(null, "Please enter both a first name and last name");
                    return null;
                }

                //Save split full name to separate variables
                String fName = nameSplit[0];
                String lName = nameSplit[1];

                //Use a prepared statement in order to use user input in the query
                String query = "SELECT * FROM Caregiver WHERE fName = ? AND lName = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, fName);
                stmt.setString(2, lName);

                //Execute query
                ResultSet rs = stmt.executeQuery();

                //Save attributes to object
                while(rs.next())
                {
                    caregiver = new Caregiver
                    (
                        rs.getString("workID"),
                        rs.getString("fName"),
                        rs.getString("lName"),
                        rs.getString("email"),
                        rs.getString("phoneNo"),
                        rs.getBlob("profileImage")
                    );
                }

                //Close resources
                rs.close();
                stmt.close();
                con.close();

                //Return object
                return caregiver;

            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        //Return no results if user input does not match any database entries
        return null;

    }

    //Method to create a caregiver in the database
    public void createCaregiver(String inputWorkID, String inputFName, String inputLName, String inputEmail,
                                String inputPhoneNo, InputStream inputProfileImage)
    {

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();

            //Query for creating a new entry into the database
            String query = "INSERT INTO Caregiver (workID, fName, lName, email, phoneNo, profileImage) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, inputWorkID);
            stmt.setString(2, inputFName);
            stmt.setString(3, inputLName);
            stmt.setString(4, inputEmail);
            stmt.setString(5, inputPhoneNo);
            stmt.setBinaryStream(6, inputProfileImage);

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

    //Method to modify a caregiver in the database
    public void modifyCaregiver(String inputWorkID, String inputFName, String inputLName,
                                String inputEmail, String inputPhoneNo, InputStream inputProfileImage)
    {
        //Connect to database
        try
        {
            Connection con = SQLConnection.getConnection();

            PreparedStatement stmt;

            //If user uploaded a new photo, update the photo too
            if(inputProfileImage != null)
            {
                String query = "UPDATE Caregiver SET fName = ?, lName = ?, email = ?, phoneNo = ?, profileImage = ? WHERE workID = ?";
                stmt = con.prepareStatement(query);
                stmt.setString(1, inputFName);
                stmt.setString(2, inputLName);
                stmt.setString(3, inputEmail);
                stmt.setString(4, inputPhoneNo);
                stmt.setBinaryStream(5, inputProfileImage);
                stmt.setString(6, inputWorkID);
            }
            else
            {
                //If user did not upload a new photo, keep the old one
                String query = "UPDATE Caregiver SET fName = ?, lName = ?, email = ?, phoneNo = ? WHERE workID = ?";
                stmt = con.prepareStatement(query);
                stmt.setString(1, inputFName);
                stmt.setString(2, inputLName);
                stmt.setString(3, inputEmail);
                stmt.setString(4, inputPhoneNo);
                stmt.setString(5, inputWorkID);
            }

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

    //Method to delete a caregiver in the database
    public void deleteCaregiver(String inputWorkID)
    {

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();


            //Use a prepared statement in order to use user input in the query
            String query = "DELETE FROM Caregiver WHERE workID = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, inputWorkID);

            //Execute query
            stmt.executeUpdate();

            //Close resources
            con.close();

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

}
