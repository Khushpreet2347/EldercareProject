package MainPackage;

import GUIPackage.DeclineAlertWindow;
import java.sql.*;
import java.util.ArrayList;

public class TrendAnalyzer
{

    //Method to grab last 14 days of records
    public static ArrayList<int[]> getRecordsTwoWeeks(String hcnInput)
        {
            ArrayList<int[]> records = new ArrayList<>();

            try
            {
                Connection conn = Connector.SQLConnection.getConnection();

                String query = "SELECT v.systolic, v.diastolic, v.bloodSugar, v.heartRate, v.temperature " + "FROM HealthRecord h " +
                        "JOIN VitalSigns v ON h.recordID = v.recordID " + "WHERE h.HCN = ? " +
                        "ORDER BY h.entryDate DESC " + "LIMIT 14";

                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, hcnInput);

                ResultSet rs = stmt.executeQuery();

                while(rs.next())
                {
                    int systolic = rs.getInt("systolic");
                    int diastolic = rs.getInt("diastolic");
                    int sugar = rs.getInt("bloodSugar");
                    int heartRate = rs.getInt("heartRate");
                    int temp = (int) rs.getDouble("temperature");

                    int[] vitals = {systolic, diastolic, sugar, heartRate, temp};

                    records.add(vitals);
                }

                rs.close();
                stmt.close();
                conn.close();

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            return records;
    }

    public static void declineDetectionAlgorithm(String hcnInput)
    {

        //Variables
        int weekOneFlags = 0;
        int weekTwoFlags = 0;

        ArrayList<int[]> records = getRecordsTwoWeeks(hcnInput);

        //Check if there are 14 records
        if(records.size() < 14)
        {
            return;
        }


        //COUNT FLAGS FOR WEEK ONE////////////////////////////////////////
        for(int i = 0; i < 7; i++)
        {
            int[] r = records.get(i);

            int systolic = r[0];
            int diastolic = r[1];
            int sugar = r[2];
            int heartRate = r[3];
            int temp = r[4];

            if(systolic < 90 || systolic > 130) {
                weekOneFlags++;
            }

            if(diastolic < 60 || diastolic > 80) {
                weekOneFlags++;
            }

            if(sugar > 200 || sugar < 60) {
                weekOneFlags++;
            }

            if(heartRate < 50 || heartRate > 110) {
                weekOneFlags++;
            }

            if(temp < 35 || temp > 38) {
                weekOneFlags++;
            }
        }

        //COUNT FLAGS FOR WEEK TWO////////////////////////////////////////

        for(int i = 7; i < 14; i++)
        {
            int[] r = records.get(i);

            int systolic = r[0];
            int diastolic = r[1];
            int sugar = r[2];
            int heartRate = r[3];
            int temp = r[4];

            if(systolic < 90 || systolic > 130) {
                weekTwoFlags++;
            }

            if(diastolic < 60 || diastolic > 80) {
                weekTwoFlags++;
            }

            if(sugar > 200 || sugar < 60) {
                weekTwoFlags++;
            }

            if(heartRate < 50 || heartRate > 110) {
                weekTwoFlags++;
            }

            if(temp < 35 || temp > 38) {
                weekTwoFlags++;
            }

        }


        //Trigger alert window (more than 2)
        if(weekTwoFlags >= weekOneFlags + 2)
        {
            DeclineAlertWindow.openDeclineAlertWindow();
        }

    }

    public static void medicationStatusAlgorithm(int scheduledHour, int actualHour) {

        int timeDifference;

        //if not given
        if(actualHour == 0) {
            DeclineAlertWindow.openDeclineAlertWindow();
            return;
        }

        timeDifference = Math.abs(actualHour - scheduledHour);

        //if given
        if(timeDifference >= 0 && timeDifference <= 1) {
            return;
        }

        //if late
        if(timeDifference > 1 && timeDifference <= 2) {
            DeclineAlertWindow.openDeclineAlertWindow();
        }

        //if missed
        if(timeDifference > 2) {
            DeclineAlertWindow.openDeclineAlertWindow();
        }


    }

}