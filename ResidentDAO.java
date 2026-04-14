package DAOPackage;

import java.io.InputStream;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import Connector.SQLConnection;
import ClassPackage.Resident;

import javax.swing.*;

//This class creates objects from the database, acts as a bridge between the database and GUIs
public class ResidentDAO
{

    //Method that returns a list of Resident objects to access data from
    public List<Resident> getAllResidents()
    {

        //Declare a list Resident objects
        List<Resident> residents = new ArrayList<>();

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Resident");

            //Populate Resident objects
            while (rs.next())
            {
                Resident resident = new Resident
                (
                    rs.getString("HCN"),
                    rs.getString("fName"),
                    rs.getString("lName"),
                    rs.getString("dateOfBirth"),
                    rs.getString("email"),
                    rs.getString("phoneNo"),
                    rs.getBlob("profileImage"),
                    rs.getString("eContact_fName"),
                    rs.getString("eContact_phoneNo")
                );

                //Add objects to List
                residents.add(resident);
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

        //Return a list of Resident objects
        return residents;

    }

    //Method that returns one resident object to access data from (BY WORK ID)
    public Resident getOneResidentViaID(String inputHCN)
    {

        //Declare a resident object
        Resident resident = null;

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();

            //Search by HCN
            if (inputHCN != null && !inputHCN.trim().isEmpty())
            {
                //Use a prepared statement in order to use user input in the query
                String query = "SELECT * FROM Resident WHERE HCN = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, inputHCN);

                //Execute query
                ResultSet rs = stmt.executeQuery();

                //Save attributes to object
                while (rs.next())
                {
                    resident = new Resident
                    (
                        rs.getString("HCN"),
                        rs.getString("fName"),
                        rs.getString("lName"),
                        rs.getString("dateOfBirth"),
                        rs.getString("email"),
                        rs.getString("phoneNo"),
                        rs.getBlob("profileImage"),
                        rs.getString("eContact_fName"),
                        rs.getString("eContact_phoneNo")
                    );
                }

                //Close resources
                rs.close();
                stmt.close();
                con.close();

                //Return resident object
                return resident;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        //Return no results if user input does not match any database entries
        return resident;

    }

    //Method that returns one resident object to access data from (BY NAME)
    public Resident getOneResidentViaName(String inputFullName)
    {

        //Declare a resident object
        Resident resident = null;

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();

            //Search by full name
            if (inputFullName != null && !inputFullName.trim().isEmpty())
            {

                //Split the full name into a first and last name
                String[] nameSplit = inputFullName.trim().split(" ");

                //Check if user entered a full name
                if (nameSplit.length < 2)
                {
                    JOptionPane.showMessageDialog(null, "Please enter both a first and a last name");
                    return null;
                }

                //Save split full name to separate variables
                String fName = nameSplit[0];
                String lName = nameSplit[1];

                //Use a prepared statement in order to use user input in the query
                String query = "SELECT * FROM Resident WHERE fName = ? AND lName = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                //Set string to names (changes ? in statement to names)
                stmt.setString(1, fName);
                stmt.setString(2, lName);

                //Execute query
                ResultSet rs = stmt.executeQuery();

                //Save attributes to object
                while (rs.next())
                {
                    resident = new Resident
                    (
                        rs.getString("HCN"),
                        rs.getString("fName"),
                        rs.getString("lName"),
                        rs.getString("dateOfBirth"),
                        rs.getString("email"),
                        rs.getString("phoneNo"),
                        rs.getBlob("profileImage"),
                        rs.getString("eContact_fName"),
                        rs.getString("eContact_phoneNo")
                    );
                }

                //Close resources
                rs.close();
                stmt.close();
                con.close();

                //Return object
                return resident;

            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        //Return no results if user input does not match any database entries
        return resident;

    }

    //Method to create a resident in the database
    public void createResident(String inputHCN, String inputFName, String inputLName, Date inputDateOfBirth, String inputEmail,
                               String inputPhoneNo, InputStream inputProfileImage, String inputEContact_fName, String inputEContact_phoneNo)
    {

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();

            //Query for creating a new entry into the database
            String query = "INSERT INTO Resident (HCN, fName, lName, dateOfBirth, email, phoneNo, profileImage, eContact_fName, eContact_phoneNo)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, inputHCN);
            stmt.setString(2, inputFName);
            stmt.setString(3, inputLName);
            stmt.setDate(4, inputDateOfBirth);
            stmt.setString(5, inputEmail);
            stmt.setString(6, inputPhoneNo);
            stmt.setBinaryStream(7, inputProfileImage);
            stmt.setString(8, inputEContact_fName);
            stmt.setString(9, inputEContact_phoneNo);

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

    //Method to modify a resident in the database
    public void modifyResident(String inputHCN, String inputFName, String inputLName, String inputDateOfBirth, String inputEmail,
                               String inputPhoneNo, InputStream inputProfileImage, String inputEContact_fName, String inputEContact_phoneNo)
    {

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();

            //Convert datatype for DOB
            java.sql.Date inputDOB = java.sql.Date.valueOf(inputDateOfBirth);

            PreparedStatement stmt;

            //If user uploaded a new photo, update the photo too
            if(inputProfileImage != null)
            {
                String query = "UPDATE Resident SET HCN = ?, fName = ?, lName = ?, dateOfBirth = ?, email = ?, phoneNo = ?, profileImage = ?, eContact_fName = ?, eContact_phoneNo = ? WHERE HCN = ?";
                stmt = con.prepareStatement(query);
                stmt.setString(1, inputHCN);
                stmt.setString(2, inputFName);
                stmt.setString(3, inputLName);
                stmt.setDate(4, inputDOB);
                stmt.setString(5, inputEmail);
                stmt.setString(6, inputPhoneNo);
                stmt.setBinaryStream(7, inputProfileImage);
                stmt.setString(8, inputEContact_fName);
                stmt.setString(9, inputEContact_phoneNo);
                stmt.setString(10, inputHCN);
            }
            else
            {
                //If user did not upload a new photo, keep the old one
                String query = "UPDATE Resident SET HCN = ?, fName = ?, lName = ?, dateOfBirth = ?, email = ?, phoneNo = ?, eContact_fName = ?, eContact_phoneNo = ? WHERE HCN = ?";
                stmt = con.prepareStatement(query);
                stmt.setString(1, inputHCN);
                stmt.setString(2, inputFName);
                stmt.setString(3, inputLName);
                stmt.setDate(4, inputDOB);
                stmt.setString(5, inputEmail);
                stmt.setString(6, inputPhoneNo);
                stmt.setString(7, inputEContact_fName);
                stmt.setString(8, inputEContact_phoneNo);
                stmt.setString(9, inputHCN);
            }

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

    //Method to delete a resident in the database
    public void deleteResident(String inputHCN)
    {

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();

            //Use a prepared statement in order to use user input in the query
            String query = "DELETE FROM Resident WHERE HCN = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, inputHCN);

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


