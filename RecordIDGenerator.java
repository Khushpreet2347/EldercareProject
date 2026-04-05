package ClassPackage;

import Connector.SQLConnection;

import java.sql.*;
import java.util.Random;


public class RecordIDGenerator {

    //method to generate UID
    public static int generateRecordID() {

        Random random = new Random();
        int num;

        while (true) {
            //random 6 digits number
            num = 100000 + random.nextInt(900000);

            //check if the ID already exists in the db
            if (!idExists(num)) {
                return num;
            }
            //if ID already exists: generate a new one
        }
    }

    //method to check if ID already exists in the Health Record table
    private static boolean idExists(int id) {
        try {
            Connection con = SQLConnection.getConnection();

            String query = "SELECT recordID FROM HealthRecord WHERE recordID = ?";
            PreparedStatement stmt = con.prepareStatement(query);

            //id takes place on "?"
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            //if the ID exists it will be returned
            boolean exists = rs.next();

            rs.close();
            stmt.close();
            con.close();

            return exists;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
}
