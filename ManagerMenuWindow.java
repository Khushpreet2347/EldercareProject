package GUIPackage;

import ClassPackage.*;
import Connector.SQLConnection;
import DAOPackage.*;
import MainPackage.CurrentSession;
import MainPackage.PasswordUtil;
import MainPackage.RecordIDGenerator;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerMenuWindow
{

    //MAIN MENU PANEL COMPONENTS | mm
    private JPanel mainMenuPanel;
    private JButton mmProfileButton;
    private JButton mmRecordsButton;
    private JButton mmActivitiesButton;
    private JButton mmReportsButton;
    private DefaultListModel<String> mmListModel;
    private JList<String> mmSelectionList;
    private JButton mmLogoutButton;
    private JLabel mmTitleLabel;
    private JLabel mmLogoLabel;
    private JLabel mmIconLabel;

    //PROFILE SEARCH PANEL COMPONENTS | ps
    private JPanel profileSearchPanel;
    private ButtonGroup profileSearchRadioGroup;
    private JRadioButton psCaregiverRadioButton;
    private JRadioButton psResidentRadioButton;
    private JRadioButton psManagerRadioButton;
    private JTextField psNameTextBox;
    private JTextField psIDTextBox;
    private JButton psSearchButton;
    private JButton psClearButton;
    private DefaultListModel<Object> psListModel;
    private JList<Object> psResultList;
    private JSeparator psSeparator;
    private JLabel psTitleLabel;
    private JLabel psNameLabel;
    private JLabel psIDLabel;
    private JToolBar psToolBar;
    private JButton psToolBarBackButton;

    //PROFILE MANAGEMENT PANEL COMPONENTS | pm
    private JPanel profileManagementPanel;
    private JLabel pmTitleLabel;
    private JRadioButton pmModifyRadioButton;
    private JRadioButton pmDeleteRadioButton;
    private JRadioButton pmCreateRadioButton;
    private JComboBox pmTypeComboBox;
    private JTextField pmSearchTextBox;
    private JButton pmSearchButton;
    private JSeparator pmSeparator;
    private JTextField pmIDTextBox;
    private JTextField pmEContactTextBox;
    private JTextField pmEPhoneTextBox;
    private JTextField pmDOBTextBox;
    private JTextField pmFNameTextBox;
    private JTextField pmLNameTextBox;
    private JTextField pmEmailTextBox;
    private JTextField pmPhoneTextBox;
    private JFileChooser pmFileChooser;
    private JLabel pmFilePathLabel;
    private JButton pmUploadButton;
    private JLabel pmIDSearchLabel;
    private JLabel pmIDLabel;
    private JLabel pmFNameLabel;
    private JLabel pmLNameLabel;
    private JLabel pmEmailLabel;
    private JLabel pmPhoneLabel;
    private JLabel pmDOBLabel;
    private JLabel pmEContactLabel;
    private JLabel pmEPhoneLabel;
    private JLabel pmPFPLabel;
    private JSeparator pmSeparatorTwo;
    private JTextField pmAssignmentTextBox;
    private JButton pmRemoveButton;
    private JButton pmAddButton;
    private DefaultListModel<String> pmListModel;
    private JList pmAssignmentList;
    private JButton pmClearButton;
    private JSeparator pmSeparatorThree;
    private JLabel pmAssignmentLabel;
    private JButton pmSaveButton;
    private JToolBar pmToolBar;
    private JButton pmToolBarBackButton;

    //MANAGER PROFILE EDIT PANEL COMPONENTS | me
    private JPanel managerEditPanel;
    private JLabel meTitleLabel;
    private JTextField meFNameTextBox;
    private JTextField meLNameTextBox;
    private JTextField meEmailTextBox;
    private JTextField meIDTextBox;
    private JPasswordField meCurrentPasswordTextBox;
    private JPasswordField meNewPasswordTextbox;
    private JPasswordField meConfirmPasswordTextBox;
    private JLabel meIDLabel;
    private JLabel meFNameLabel;
    private JLabel meLNameLabel;
    private JLabel meEmailLabel;
    private JTextField mePhoneTextBox;
    private JLabel mePhoneLabel;
    private JLabel meCurrentPasswordLabel;
    private JLabel meNewPasswordLabel;
    private JLabel meConfirmPasswordLabel;
    private JSeparator meSeparator;
    private JSeparator meSeparator2;
    private JButton meSaveButton;
    private JButton meClearButton;
    private JToolBar meToolBar;
    private JButton meToolBarBackButton;

    //RECORD SEARCH PANEL COMPONENTS | rs
    private JPanel recordSearchPanel;
    private JToolBar rsToolBar;
    private ButtonGroup healthRecordCheckGroup;
    private JLabel rsTitleLabel;
    private JCheckBox rsDateCheckBox;
    private JTextField rsDateTextbox;
    private JSeparator rsSeparator;
    private JSplitPane rsSpiltPane;
    private DefaultListModel<String> rsListModel;
    private JList rsResultList;
    private DefaultTableModel rsTableModel;
    private JTable rsResultTable;
    private DefaultTableModel rsMedTableModel;
    private JTable rsMedResultTable;
    private List<HealthRecord> rsSelectionResults;
    private JTextField rsNameTextBox;
    private JTextField rsMedStatusTextbox;
    private JCheckBox rsMedStatusCheckBox;
    private JCheckBox rsNameCheckBox;
    private JButton rsClearButton;
    private JButton rsSearchButton;
    private JButton rsToolBarBackButton;

    //RECORD MANAGEMENT PANEL | rm
    private JPanel recordManagementPanel;
    private JTabbedPane rmTabbedPanel;
    private JPanel rmInputTab;
    private JPanel rmEditTab;
    private JPanel rmDeleteTab;
    private JToolBar rmToolBar;
    private JButton rmToolBarBackButton;
    //INPUT TAB | iTab ++++++++++++++++++++++++++++++++++++++++++
    private JLabel iTabTitleLabel;
    private JTextField iTabHCNTextBox;
    private JTextField iTabNameTextBox;
    private JTextArea iTabNotesTextArea;
    private JTextField iTabSystolicPressureTextBox;
    private JTextField iTabBloodSugarTextBox;
    private JTextField iTabTemperatureTextBox;
    private JTextField iTabHeartRateTextBox;
    private JTextField iTabDiastolicPressureTextBox;
    private JSlider iTabMoodSlider;
    private JSlider iTabPainLevelSlider;
    private JSlider iTabSleepQualitySlider;
    private JComboBox iTabStatusComboBox;
    private JTextField iTabMedNameTextBox;
    private JTextField iTabDoseTextBox;
    private JTextField iTabMedNoteTextBox;
    private JButton iTabAddEntryButton;
    private JButton iTabRemoveEntryButton;
    private DefaultListModel<String> iTabListModel;
    private JList iTabMedEntryList;
    private JButton iTabClearAllButton;
    private JButton iTabSaveAllButton;
    private JLabel iTabGenInfoLabel;
    private JLabel iTabHCNLabel;
    private JLabel iTabNotesLabel;
    private JLabel iTabVitalSignslabel;
    private JLabel iTabBloodPressureLabel;
    private JLabel iTabBloodSugarLabel;
    private JLabel iTabHeartRateLabel;
    private JLabel iTabTemperatureLabel;
    private JLabel iTabConditionLabel;
    private JLabel iTabMoodLabel;
    private JLabel iTabPainLevelLabel;
    private JLabel iTabSleepQualityLabel;
    private JLabel iTabMedicationLabel;
    private JLabel iTabMedNameLabel;
    private JLabel iTabDoseLabel;
    private JTextField iTabTimeTextBox;
    private JLabel iTabTimeLabel;
    private JLabel iTabStatusLabel;
    private JLabel iTabMedNoteLabel;
    private JSeparator iTabSeparator;
    private JSeparator iTabSeparator2;
    //EDIT TAB | eTab ++++++++++++++++++++++++++++++++++++++++++
    private JTextField eTabSystolicPressureTextBox;
    private JTextField eTabDiastolicPressureTextBox;
    private JTextField eTabBloodSugarTextBox;
    private JTextField eTabTemperatureTextBox;
    private JTextField eTabHeartRateTextBox;
    private JComboBox eTabStatusComboBox;
    private JTextField eTabDoseTextBox;
    private JTextField eTabMedNameTextBox;
    private JTextField eTabMedNotesTextBox;
    private DefaultListModel<String> eTabListModel;
    private JList eTabResultsList;
    private DefaultListModel<String> eTabListModelResults;
    private JList eTabMedEntryList;
    private JButton eTabAddEntryButton;
    private JButton eTabRemoveEntryButton;
    private JTextField eTabHCNTextBox;
    private JTextField eTabNameTextBox;
    private JTextArea eTabNotesTextArea;
    private JSlider eTabSleepQualitySlider;
    private JSlider eTabPainLevelSlider;
    private JSlider eTabMoodSlider;
    private JButton eTabSaveAllButton;
    private JButton eTabClearAllButton;
    private JLabel eTabGenInfoLabel;
    private JLabel eTabVitalSignsLabel;
    private JLabel eTabConditionLabel;
    private JLabel eTabMedicationLabel;
    private JLabel eTabHCNLabel;
    private JLabel eTabNameLabel;
    private JLabel eTabNotesLabel;
    private JLabel eTabBloodPressureLabel;
    private JLabel eTabBloodSugarLabel;
    private JLabel eTabTemperatureLabel;
    private JLabel eTabHeartRateLabel;
    private JLabel eTabMoodLabel;
    private JLabel eTabPainLevelLabel;
    private JLabel eTabSleepQualityLabel;
    private JLabel eTabMedNameLabel;
    private JLabel eTabDoseLabel;
    private JTextField eTabTimeTextBox;
    private JLabel eTabTimeLabel;
    private JLabel eTabStatusLabel;
    private JLabel eTabMedNotesLabel;
    private JSeparator eTabSeparator;
    private JSeparator eTabSeparator2;
    private JSeparator eTabSeparator3;
    private JButton eTabSearchButton;
    private JCheckBox eTabSearchNameCheckBox;
    private JTextField eTabSearchNameTextBox;
    private JTextField eTabRecordIDTextBox;
    private JCheckBox eTabRecordIDCheckBox;
    //DELETE TAB | dTab ++++++++++++++++++++++++++++++++++++++++++
    private JLabel dTabTitleLabel;
    private JTextField dTabRecordIDTextBox;
    private JTextField dTabNameTextBox;
    private JRadioButton dTabRecordIDRadioButton;
    private JRadioButton dTabFullNameRadioButton;
    private JButton dTabClearButton;
    private JButton dTabSearchButton;
    private JButton dTabDeleteButton;
    private DefaultListModel<String> dTabListModel;
    private JList dTabResultList;
    private DefaultTableModel dTabTableModel;
    private JTable dTabResultsTable;
    private List<HealthRecord> dTabSelectionResults;

    //ACTIVITY SEARCH PANEL | as
    private JPanel activitySearch;
    private JPanel reportGeneratePanel;
    private JLabel asTitleLabel;
    private JTextField asSearchTextBox;
    private JLabel asActivityTitleLabel;
    private JSeparator asSeparator;
    private JSplitPane asSpiltPane;
    private DefaultListModel<String> asListModel;
    private JList asResultList;
    private DefaultTableModel asTableModel;
    private JTable asResultTable;
    private List<Activity> asSelectionResults;
    private JButton asClearButton;
    private JButton asSearchButton;
    private JToolBar asToolBar;
    private JButton asToolBarBackButton;

    //ACTIVITY MANAGEMENT PANEL | am
    private JPanel activityManagementPanel;
    private JLabel amTitleLabel;
    private JLabel amTitleSearchLabel;
    private JRadioButton amModifyRadioButton;
    private JRadioButton amDeleteRadioButton;
    private JRadioButton amCreateRadioButton;
    private JTextField amSearchTextBox;
    private JButton amSearchButton;
    private JSeparator amSeparator;
    private JTextField amTitleTextBox;
    private JLabel amActivityTitleLabel;
    private JTextField amDateTextBox;
    private JLabel amDateLabel;
    private JLabel amTimeLabel;
    private JTextField amTimeTextBox;
    private JLabel amDescriptionLabel;
    private JLabel amNotesLabel;
    private JLabel amStatusLabel;
    private JComboBox amStatusComboBox;
    private JSeparator amSeparatorTwo;
    private JButton amSaveButton;
    private JButton amClearButton;
    private JTextArea amDescriptionTextArea;
    private JTextArea amNotesTextArea;
    private JToolBar amToolBar;
    private JButton amToolBarBackButton;

    //REPORT GENERATE PANEL | rg
    private JLabel rgTitleLabel;
    private JLabel rgDetailsLabel;
    private JTable rgResultsTable;
    private DefaultTableModel rgTableModel;
    private JLabel rgSummaryLabel;
    private JTable rgTotalCountsTable;
    private DefaultTableModel rgTableModelCounts;
    private JSeparator rgSeparator;
    private JButton rgGenerateButton;
    private JButton rgClearButton;
    private JTextField rgYearTextBox;
    private JTextField rgMonthTextBox;
    private JCheckBox rgYearCheckBox;
    private JCheckBox rgMonthCheckBox;
    private JRadioButton rgHealthIrregRadioButton;
    private JRadioButton rgUserMedRadioButton;
    private JToolBar rgToolBar;
    private JButton rgToolBarBackButton;

    //REPORT SEARCH PANEL | rgs
    private JTextField rgsYearTextBox;
    private DefaultListModel<String> rgsListModel;
    private JList rgsResultList;
    private DefaultTableModel rgsTableModel;
    private JTable rgsResultTable;
    private List<Report> rgsSelectionResults;
    private JButton rgsToolBarButton;
    private JToolBar rgsToolBar;
    private JLabel rgsTitleLabel;
    private JRadioButton rgsUserMedicationSummaryRadioButton;
    private JRadioButton rgsHealthIrregularitiesSummaryRadioButton;
    private JCheckBox rgsYearCheckBox;
    private JCheckBox rgsMonthCheckBox;
    private JLabel rgsYearLabel;
    private JLabel rgsMonthLabel;
    private JTextField rgsMonthTextbox;
    private JButton rgsClearButton;
    private JButton rgsSearchButton;

    //Declare a root card panel, other card panels will attach to the root
    private JPanel rootPanel;
    private JPanel reportSearchPanel;

    //Radio Button Groups
    private ButtonGroup activityManagementRadioGroup;
    private ButtonGroup profileManagementRadioGroup;
    private ButtonGroup dTabRadioGroup;
    private ButtonGroup reportGenerateRadioGroup;
    private ButtonGroup getReportGenerateRadioGroup2;
    private ButtonGroup reportGenerateSearchRadioGroup;

    //File for profile photos
    private File pmSelectedProfilePhoto;

    //Declare CardLayout
    CardLayout menuCardLayout = new CardLayout();

    //Declare JFrame
    JFrame managerMenuWindowFrame = new JFrame();

    //ADDITIONAL METHODS FOR MENU WINDOWS
    //MAIN MENU METHODS | mm ///////////////////////////////////////////////////////////////////////////////////

    //Method to update the main menu JList selection of options
    private void setMainMenuList(String[] menuOptions)
    {
        mmListModel.clear();
        for(String mo : menuOptions)
        {
            mmListModel.addElement(mo);
        }
    }

    //HEALTH RECORD SEARCH METHODS | rs ///////////////////////////////////////////////////////////////////////////////////
    private void loadHealthRecords(HealthRecord healthRecord)
    {

        //Load DAOs to access data from
        ConditionDAO conditionDAO = new ConditionDAO();
        MedicationEntryDAO medicationEntryDAO = new MedicationEntryDAO();
        VitalSignsDAO vitalSignsDAO = new VitalSignsDAO();
        ResidentDAO residentDAO = new ResidentDAO();

        //Save health recordID to variable (is a foreign key in related health record tables in database
        int recordID = healthRecord.getRecordID();

        //Grab records of associated tables using a matching recordID from Health Record table (plus Resident name)
        //(Will return objects related to the Health Record entry
        Condition condition = conditionDAO.getOneCondition(recordID);
        List<MedicationEntry> medicationEntryList = medicationEntryDAO.getMedicationEntriesViaID(recordID);
        VitalSigns vitalSigns = vitalSignsDAO.getOneVitalSigns(recordID);
        Resident resident = residentDAO.getOneResidentViaID(healthRecord.getHCN());

        //Clear current data in tables
        rsTableModel.setColumnCount(0);
        rsTableModel.setRowCount(0);

        //Save values from each DAO and check if they are null
        //Condition
        int mood = 0;
        int painLevel = 0;
        int sleepQuality = 0;

        if(condition != null)
        {
            mood = condition.getMood();
            painLevel = condition.getPainLevel();
            sleepQuality = condition.getSleepQuality();
        }

        //Medication Entry
        String medicationName = "";
        double dose = 0.0;
        Time administeredTime = null;
        String status = "";
        String note = "";

        //Vital Signs
        int systolic = 0;
        int diastolic = 0;
        double bloodSugar = 0.0;
        double temperature = 0;
        int heartRate = 0;

        if(vitalSigns != null)
        {
            systolic = vitalSigns.getSystolic();
            diastolic = vitalSigns.getDiastolic();
            bloodSugar = vitalSigns.getBloodSugar();
            temperature = vitalSigns.getTemperature();
            heartRate = vitalSigns.getHeartRate();
        }

        //Resident Name
        String fullName = "";

        if(resident != null)
        {
            fullName = resident.getfName() + " " + resident.getlName();
        }

        //Add info to tables
        //HEALTH RECORD TABLE (Will show one record)
        rsTableModel.addRow
                (new Object[]{
                    recordID, healthRecord.getHCN(), fullName,
                        healthRecord.getEntryDate(), healthRecord.getEntryTime(), healthRecord.getNote(),
                    mood, painLevel, sleepQuality,
                    systolic, diastolic, bloodSugar, temperature, heartRate
                });

        //MEDICATION TABLE (Will show multiple records attach to the one health record
        if(medicationEntryList != null && !medicationEntryList.isEmpty())
        {
            for(MedicationEntry me : medicationEntryList)
            {
                rsMedTableModel.addRow(new Object[]{
                    me.getmName(),
                    me.getDose(),
                    me.getAdministeredTime(),
                    me.getStatus(),
                    me.getNote()
                });
            }
        }
        else
        {
            //Show an empty table if the record has no medications
            rsMedTableModel.addRow(new Object[]
                    {
                            "-", "-", "-", "-", "-"
                    });
        }
    }

    //REPORT GENERATE METHODS | rg ///////////////////////////////////////////////////////////////////////////////////

    private void generateReportUMS(int year, int month)
    {

        //Clear out previous results in table
        rgTableModel.setRowCount(0);
        rgTableModel.setColumnCount(0);
        rgTableModelCounts.setRowCount(0);
        rgTableModelCounts.setColumnCount(0);

        //Set headers for the table
        rgTableModelCounts.setColumnIdentifiers
                (new String[]{
                        "Active Residents",
                        "Active Caregivers"
                });

        rgTableModel.setColumnIdentifiers
                (new String[]{
                        "Name",
                        "Missed Medications"
                });

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();

            //Get count of active Residents from the database
            Statement stmtAR = con.createStatement();
            ResultSet rsAR = stmtAR.executeQuery("SELECT COUNT(*) FROM Resident");
            rsAR.next();
            int totalActiveResidents = rsAR.getInt(1);

            //Get count of active Caregivers from the database
            Statement stmtAC = con.createStatement();
            ResultSet rsAC = stmtAC.executeQuery("SELECT COUNT(*) FROM Caregiver");
            rsAC.next();
            int totalActiveCaregivers = rsAC.getInt(1);

            //Get count of missed medications from each Resident
            String query =
                    "SELECT r.fName, r.lName, COUNT(*) as missedCount " +
                            "FROM MedicationEntry me " +
                                "JOIN HealthRecord hr " +
                                    "ON me.recordID = hr.recordID " +
                                "JOIN Resident r " +
                                    "ON hr.HCN = r.HCN " +
                            "WHERE me.status = 'Missed' ";

            //Add onto query according to user entered year and/or month
            if(year != 0)
            {
                query += "AND YEAR(hr.entryDate) = " + year + " ";
            }

            if(month != 0)
            {
                query += "AND MONTH(hr.entryDate) = " + month + " ";
            }

            //Add onto query grouping and ordering by most missed meds to least
            query += "GROUP BY r.fName, r.lName ORDER BY missedCount DESC";

            Statement stmtMM = con.createStatement();;
            ResultSet rsMM = stmtMM.executeQuery(query);

            //Save missed medications by resident results to variables
            //Database keeps report type and its content so the content will be saved to a string builder for the db
            StringBuilder reportContentBuilder = new StringBuilder();

            //Append total counts of Residents and Caregivers
            reportContentBuilder.append("Total Active Residents: ")
                                .append(totalActiveResidents).append("\n");

            reportContentBuilder.append("Total Active Caregivers: ")
                                .append(totalActiveCaregivers).append("\n");

            //Append missed counts by Residents
            while(rsMM.next())
            {
                //Get name and counts
                String name = rsMM.getString("fName") + " " + rsMM.getString("lName");
                int missedCount = rsMM.getInt("missedCount");

                //Add Resident name and their total missed medication count to the results table
                rgTableModel.addRow
                (new Object[]{
                    name,
                    missedCount
                });

                //Add missed medication count by Residents to string builder to store as "content" in the database
                reportContentBuilder.append("Resident Name: ")
                                    .append(name)
                                    .append(" Total Missed Medications: ")
                                    .append(missedCount).append("\n");
            }

            //Add total counts of Residents and Caregivers to total counts table
            rgTableModelCounts.addRow
            (new Object[]{
                totalActiveResidents, totalActiveCaregivers
            });

            //Save the new generated report to the database
            ReportDAO reportDAO = new ReportDAO();
            reportDAO.createReport("UserMedicationSummary", year, month, reportContentBuilder.toString());

            //set column widths
            rgResultsTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            rgResultsTable.getColumnModel().getColumn(1).setPreferredWidth(120);

            rgTotalCountsTable.getColumnModel().getColumn(0).setPreferredWidth(140);
            rgTotalCountsTable.getColumnModel().getColumn(1).setPreferredWidth(140);

            //center numbers
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            rgResultsTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            rgTotalCountsTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            rgTotalCountsTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

            //Close resources
            stmtAR.close();
            stmtAC.close();
            stmtMM.close();
            rsAR.close();
            rsAC.close();
            rsMM.close();
            con.close();

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There was an error creating a report");
        }

    }

    private void generateReportHIS(int year, int month)
    {

        //Clear out previous results in table
        rgTableModel.setRowCount(0);
        rgTableModel.setColumnCount(0);
        rgTableModelCounts.setRowCount(0);
        rgTableModelCounts.setColumnCount(0);

        //Set headers for the table
        rgTableModelCounts.setColumnIdentifiers
                (new String[]{
                        "Blood Pressure",
                        "Blood Sugar",
                        "Heart Rate",
                        "Temperature"
                });

        rgTableModel.setColumnIdentifiers
                (new String[]{
                        "Name",
                        "Irreg BP",
                        "Irreg BS",
                        "Irreg HR",
                        "Irreg Temp"
                });

        //Connect to database
        try
        {

            Connection con = SQLConnection.getConnection();

            //Query to pass to grab total counts of abnormal vital signs
            //For the cases, THEN ELSE END counts which rows meet criteria (count as 1 for THEN) and which don't (count as 0 for ELSE)
            String query =
                    "SELECT r.fName, r.lName, " +
                            //BLOOD PRESSURE
                            "SUM(CASE WHEN " +
                            "vs.systolicPressure < 90 OR vs.diastolicPressure < 60 " +
                            "OR vs.systolicPressure >= 130 OR vs.diastolicPressure >= 80 "+
                            "THEN 1 ELSE 0 END) AS IrregBP, " +
                            //BLOOD SUGAR
                            "SUM(CASE WHEN " +
                            "vs.bloodSugar < 60 OR vs.bloodSugar >= 200 " +
                            "THEN 1 ELSE 0 END) AS IrregBS, " +
                            //HEART RATE
                            "SUM(CASE WHEN " +
                            "vs.heartRate < 50 OR vs.heartRate >= 110 " +
                            "THEN 1 ELSE 0 END) AS IrregHR, " +
                            //BODY TEMPERATURE
                            "SUM(CASE WHEN " +
                            "vs.temperature < 35 OR vs.temperature >= 38.3 " +
                            "THEN 1 ELSE 0 END) AS IrregTemp " +
                            //JOIN TABLES
                            "FROM VitalSigns vs " +
                                "JOIN HealthRecord hr " +
                                    "ON vs.recordID = hr.recordID " +
                                "JOIN Resident r " +
                                    "ON hr.HCN = r.HCN " +
                            //For append
                            "WHERE 1 = 1";

            //Add onto query according to user entered year and/or month
            if(year != 0)
            {
                query += " AND YEAR(hr.entryDate) = " + year;
            }

            if(month != 0)
            {
                query += " AND MONTH(hr.entryDate) = " + month;
            }

            //Add onto query grouping and ordering by most vital signs to least
            query += "GROUP BY r.fName, r.lName ORDER BY IrregBp + IrregBS + IrregHR + IrregTemp DESC";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            //Save abnormal vital sign counts to variables
            int totalBP = 0;
            int totalBS = 0;
            int totalHR = 0;
            int totalTemp = 0;

            //Save counts of irregular vital signs to database
            //Database keeps report type and its content so the content will be saved to a string builder for the db
            StringBuilder reportContentBuilder = new StringBuilder();

            while(rs.next())
            {
                //Get name and counts
                String name = rs.getString("fName") + " " + rs.getString("lName");

                //Grab counts from query results
                int ibp = rs.getInt("IrregBP");
                int ibs = rs.getInt("IrregBS");
                int ihr = rs.getInt("IrregHR");
                int it = rs.getInt("IrregTemp");

                //Add counts to totals variables
                totalBP += ibp;
                totalBS += ibs;
                totalHR += ihr;
                totalTemp += it;

                //Add irregular vital sign counts for each Resident to results table
                rgTableModel.addRow
                        (new Object[]{
                                name, ibp, ibs, ihr, it
                        });

                //Add irregular vital sign counts for each Resident to string builder to store as "content" in the database
                reportContentBuilder.append("Resident Name : ")
                        .append(name)
                        .append(" Blood Pressure: ").append(ibp)
                        .append(" Blood Sugar: ").append(ibs)
                        .append(" Heart Rate: ").append(ihr)
                        .append(" Temperature").append(it).append("\n");
            }

            //Add total counts of abnormal vital signs to total counts table
            rgTableModelCounts.addRow
                    (new Object[]{
                            totalBP, totalBS, totalHR, totalTemp
                    });

            //Save the new generated report to the database
            ReportDAO reportDAO = new ReportDAO();
            reportDAO.createReport("HealthIrregularitiesSummary", year, month, reportContentBuilder.toString());

            //set column widths
            rgResultsTable.getColumnModel().getColumn(0).setPreferredWidth(180);
            rgResultsTable.getColumnModel().getColumn(1).setPreferredWidth(60);
            rgResultsTable.getColumnModel().getColumn(2).setPreferredWidth(60);
            rgResultsTable.getColumnModel().getColumn(3).setPreferredWidth(60);
            rgResultsTable.getColumnModel().getColumn(4).setPreferredWidth(60);

            rgTotalCountsTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            rgTotalCountsTable.getColumnModel().getColumn(1).setPreferredWidth(60);
            rgTotalCountsTable.getColumnModel().getColumn(2).setPreferredWidth(60);
            rgTotalCountsTable.getColumnModel().getColumn(3).setPreferredWidth(60);

            //center numbers
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            rgResultsTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            rgResultsTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
            rgResultsTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
            rgResultsTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

            rgTotalCountsTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            rgTotalCountsTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            rgTotalCountsTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
            rgTotalCountsTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

            //Close resources
            rs.close();
            stmt.close();
            con.close();


        }
        catch(SQLException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There was an error creating a report");
        }

    }

    //Class holding methods for JFrame
    public ManagerMenuWindow()
    {

        //METHODS FOR MAIN MENU | mm ///////////////////////==////////////////////////////////////////////////////////////

        //SET UP FOR CARD SWITCHING IN JFRAME
        //Set card layout type in the root panel, then add panels with constraints
        rootPanel.setLayout(menuCardLayout);
        rootPanel.add(mainMenuPanel, "MAIN_MENU");
        rootPanel.add(profileSearchPanel, "PROFILE_SEARCH");
        rootPanel.add(profileManagementPanel, "PROFILE_MANAGEMENT");
        rootPanel.add(managerEditPanel, "PROFILE_MANAGER_EDIT");
        rootPanel.add(recordSearchPanel, "RECORD_SEARCH");
        rootPanel.add(recordManagementPanel, "RECORD_MANAGEMENT");
        rootPanel.add(activitySearch, "ACTIVITY_SEARCH");
        rootPanel.add(activityManagementPanel, "ACTIVITY_MANAGEMENT");
        rootPanel.add(reportGeneratePanel, "REPORT_GENERATE");
        rootPanel.add(reportSearchPanel, "REPORT_SEARCH");

        //SHOW MAIN MENU TO USER
        menuCardLayout.show(rootPanel, "MAIN_MENU");

        //SWITCHING "CARDS"/WINDOWS IN THE MAIN MENU
        //Declare a list model (allows a list to be edited)
        mmListModel = new DefaultListModel<>();
        mmSelectionList.setModel(mmListModel);

        //Menu arrays for option display in JList (Buttons will use these)
        String profileOptions[] = {"Profile Search", "Profile Management", "Edit Your Profile"};
        String recordOptions[] = {"Record Search", "Record Management"};
        String activityOptions[] = {"Activity Search", "Activity Management"};
        String reportOptions[] = {"Generate Report", "Search Reports"};

        //Button Functions to change JList sub menu options
        mmProfileButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setMainMenuList(profileOptions);
            }
        });

        mmRecordsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setMainMenuList(recordOptions);
            }
        });

        mmActivitiesButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setMainMenuList(activityOptions);
            }
        });

        mmReportsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setMainMenuList(reportOptions);
            }
        });

        //ICONS FOR MAIN MENU PAGE
        ImageIcon menuLogo = new ImageIcon(getClass().getResource("/CareOpsLogo.png"));
        ImageIcon menuIcon = new ImageIcon(getClass().getResource("/healthcare.png"));

        //Convert and scale images
        Image menuLogoImage = menuLogo.getImage();
        Image scaledMenuLogo = menuLogoImage.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledImageMenuLogo = new ImageIcon(scaledMenuLogo);

        Image menuIconImage = menuIcon.getImage();
        Image scaledMenuIcon = menuIconImage.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        ImageIcon scaledImageMenuIcon = new ImageIcon(scaledMenuIcon);

        //Set labels to be icons
        mmLogoLabel.setText("");
        mmIconLabel.setText("");
        mmLogoLabel.setIcon(scaledImageMenuLogo);
        mmIconLabel.setIcon(scaledImageMenuIcon);

        //Menu list options
        //Menu sub options after button option selection, each selection will change cards and bring the user
        //to their desired screen ex. User wishes to access Profile Search window, they will click
        //the Profile button, then the JList will display Profile sub options, user will select
        //Profile Search from JList and JFrame will switch cards to show Profile Search content
        mmSelectionList.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {

                //Check user selection in JList if there is a selection at all
                String subMenuOption = mmSelectionList.getSelectedValue();
                if(subMenuOption == null) { return; }

                //Switch cards in frame based on selection
                switch(subMenuOption)
                {

                    case "Profile Search":
                            menuCardLayout.show(rootPanel, "PROFILE_SEARCH");
                        break;
                    case "Profile Management":
                            menuCardLayout.show(rootPanel, "PROFILE_MANAGEMENT");
                        break;
                    case "Edit Your Profile":
                            menuCardLayout.show(rootPanel, "PROFILE_MANAGER_EDIT");
                        break;
                    case "Record Search":
                            menuCardLayout.show(rootPanel, "RECORD_SEARCH");
                        break;
                    case "Record Management":
                            menuCardLayout.show(rootPanel, "RECORD_MANAGEMENT");
                        break;
                    case "Activity Search":
                            menuCardLayout.show(rootPanel, "ACTIVITY_SEARCH");
                        break;
                    case "Activity Management":
                            menuCardLayout.show(rootPanel, "ACTIVITY_MANAGEMENT");
                        break;
                    case "Generate Report":
                            menuCardLayout.show(rootPanel, "REPORT_GENERATE");
                        break;
                    case "Search Reports":
                        menuCardLayout.show(rootPanel, "REPORT_SEARCH");
                        break;
                    default:
                        break;
                }
            }
        });

        //LOG OUT USER BUTTON
        mmLogoutButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                managerMenuWindowFrame.dispose();
                LogoutWindow.openLogoutWindow();
            }
        });

        //METHODS FOR PROFILE SEARCH | ps ///////////////////////////////////////////////////////////////////////////////////

        //TOOLBAR BACK BUTTON METHOD
        psToolBarBackButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                menuCardLayout.show(rootPanel, "MAIN_MENU");
                mmListModel.clear();
            }
        });

        //Declare a list model (allows a list to be edited)
        psListModel = new DefaultListModel<>();
        psResultList.setModel(psListModel);

        //CLEAR INPUT BUTTON
        psClearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                psResidentRadioButton.setSelected(true);
                psNameTextBox.setText("");
                psIDTextBox.setText("");
                psListModel.clear();
            }
        });

        //SEARCH PROFILES BUTTON
        psSearchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //DETECT INPUT
                if(psNameTextBox.getText().isEmpty() && psIDTextBox.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter either a name or ID");
                    return;
                }

                //Clear any past results
                psListModel.clear();

                //Grab user input and save to a variable (IDInput covers both workID and HCN
                String IDInput = psIDTextBox.getText().trim();
                String nameInput = psNameTextBox.getText().trim();

                //RADIO BUTTON OPTIONS
                //Create DAO objects to connect to database
                ResidentDAO residentDAO = new ResidentDAO();
                CaregiverDAO caregiverDAO = new CaregiverDAO();
                ManagerDAO managerDAO = new ManagerDAO();

                //When Resident option is selected
                if(psResidentRadioButton.isSelected())
                {
                    //Access method via DAO
                    Resident resident = null;

                    //Get by ID
                    if(!IDInput.isEmpty())
                    {
                       //Grab info
                        resident = residentDAO.getOneResidentViaID(IDInput);
                    }
                    //Get by name
                    else if(!nameInput.isEmpty())
                    {
                        //Grab info
                        resident = residentDAO.getOneResidentViaName(nameInput);
                    }

                    //Display results if a match is found
                    if(resident != null)
                    {
                        psListModel.addElement(resident);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No resident was found");
                    }
                }
                //When Care option is selected
                else if(psCaregiverRadioButton.isSelected())
                {

                    //Access method via DAO
                    Caregiver caregiver = null;

                    //Get by ID
                    if(!IDInput.isEmpty())
                    {
                        //Grab info
                        caregiver = caregiverDAO.getOneCaregiverViaID(IDInput);
                    }
                    //Get by name
                    else if(!nameInput.isEmpty())
                    {
                        //Grab info
                        caregiver = caregiverDAO.getOneCaregiverViaName(nameInput);
                    }

                    //Display results if a match is found
                    if(caregiver != null)
                    {
                        psListModel.addElement(caregiver);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No caregiver was found");
                    }
                }
                //When Manager option is selected
                else if(psManagerRadioButton.isSelected())
                {
                    //Access method via DAO
                    Manager manager = null;

                    //Get by ID
                    if(!IDInput.isEmpty())
                    {
                        //Grab info
                        manager = managerDAO.getOneManagerViaID(IDInput);
                    }
                    //Get by name
                    else if(!nameInput.isEmpty())
                    {
                        //Grab info
                        manager = managerDAO.getOneManagerViaName(nameInput);
                    }

                    //Display results if a match is found
                    if(manager != null)
                    {
                        psListModel.addElement(manager);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No manager was found");
                    }
                }
            }
        });

        //OPEN PROFILE WINDOWS WHEN USER CLICKS ON RESULTS
        psResultList.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);

                //Detect a double click from user to open a profile window
                if(e.getClickCount() == 2)
                {

                    //Save user selected value from list to an object
                    Object psSelected = psResultList.getSelectedValue();

                    //Check if selection is empty
                    if(psSelected == null) return;

                    //Open a profile window based on the type of profile account user has selected (3 types)
                    if(psSelected instanceof Resident)
                    {
                        ResidentProfileWindow.openResidentProfileWindow((Resident) psSelected);
                    }
                    else if(psSelected instanceof Caregiver)
                    {
                        CaregiverProfileWindow.openCaregiverProfileWindow((Caregiver) psSelected);
                    }
                    else if(psSelected instanceof Manager)
                    {
                        ManagerProfileWindow.openManagerProfileWindow((Manager) psSelected);
                    }
                }
            }
        });

        //METHODS FOR PROFILE MANAGEMENT | pm ///////////////////////////////////////////////////////////////////////////////////
        //NOTE: CAN ONLY MODIFY RESIDENT AND CAREGIVER PROFILES, MANAGERS CANNOT EDIT OTHER MANAGER PROFILES (ONLY THEIR OWN)

        //TOOLBAR BACK BUTTON METHOD
        pmToolBarBackButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                menuCardLayout.show(rootPanel, "MAIN_MENU");
                mmListModel.clear();
            }
        });

        //POPULATE PROFILE TYPE COMBOBOX
        pmTypeComboBox.addItem("Resident");
        pmTypeComboBox.addItem("Caregiver");
        pmTypeComboBox.setSelectedIndex(-1);

        //DISABLE RESIDENT TEXTBOXES IF COMBO BOX TYPE SELECTED IS CAREGIVER
        pmDOBTextBox.setEnabled(false);
        pmEContactTextBox.setEnabled(false);
        pmEPhoneTextBox.setEnabled(false);

        //ENABLE RESIDENT TEXTBOXES IF COMBO BOX TYPE SELECTED IS RESIDENT
        pmTypeComboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if("Resident".equals(pmTypeComboBox.getSelectedItem()))
                {
                    pmDOBTextBox.setEnabled(true);
                    pmEContactTextBox.setEnabled(true);
                    pmEPhoneTextBox.setEnabled(true);
                    pmAssignmentLabel.setText("Caregivers:");
                }
                else if("Caregiver".equals(pmTypeComboBox.getSelectedItem()))
                {
                    pmDOBTextBox.setEnabled(false);
                    pmEContactTextBox.setEnabled(false);
                    pmEPhoneTextBox.setEnabled(false);
                    pmAssignmentLabel.setText("Residents:");
                }
            }
        });

        //ENABLE SEARCH TEXT BOX IF MODIFY OR DELETE RADIO BUTTONS ARE SELECTED
        pmSearchTextBox.setEnabled(false);
        pmSearchButton.setEnabled(false);
        pmModifyRadioButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                pmSearchTextBox.setEnabled(true);
                pmSearchButton.setEnabled(true);
            }
        });
        pmDeleteRadioButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                pmSearchTextBox.setEnabled(true);
                pmSearchButton.setEnabled(true);
            }
        });

        //Declare a list model (allows a list to be edited)
        pmListModel = new DefaultListModel<>();
        pmAssignmentList.setModel(pmListModel);

        //CLEAR INPUT BUTTON
        pmClearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                pmCreateRadioButton.setSelected(true);
                pmTypeComboBox.setSelectedIndex(-1);
                pmSearchTextBox.setText("");
                pmIDTextBox.setText("");
                pmFNameTextBox.setText("");
                pmLNameTextBox.setText("");
                pmEmailTextBox.setText("");
                pmPhoneTextBox.setText("");
                pmDOBTextBox.setText("");
                pmEContactTextBox.setText("");
                pmEPhoneTextBox.setText("");
                pmSelectedProfilePhoto = null;
                pmFilePathLabel.setText("File Path");
                pmAssignmentTextBox.setText("");
                pmListModel.clear();
            }
        });

        //UPLOAD A PROFILE PHOTO BUTTON
        pmUploadButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                //Filter out unneeded file types
                FileNameExtensionFilter pmFilter = new FileNameExtensionFilter
                (
                    "Images", "jpeg", "png", "jpeg", "webp"
                );

                //Set the file chooser's filter
                pmFileChooser.setFileFilter(pmFilter);

                //Open a dialog window
                int pmPickedOption = pmFileChooser.showOpenDialog(null);

                if(pmPickedOption == JFileChooser.APPROVE_OPTION)
                {
                    //Save user selected file
                    pmSelectedProfilePhoto = pmFileChooser.getSelectedFile();

                    //Display the file path in the GUI
                    pmFilePathLabel.setText(pmSelectedProfilePhoto.getAbsolutePath());
                }
            }
        });

        //SEARCH PROFILES FOR MODIFYING BUTTON
        pmSearchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //DETECT INPUT
                if(pmSearchTextBox.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter a name");
                    return;
                }

                //Save input from search box to a variable
                String pmInputFullName = pmSearchTextBox.getText().trim();

                //RESIDENT SEARCH
                if("Resident".equals(pmTypeComboBox.getSelectedItem()))
                {
                    //Create a DAO to access the database
                    ResidentDAO residentDAO = new ResidentDAO();
                    Resident resident = residentDAO.getOneResidentViaName(pmInputFullName);

                    //Populate textboxes with data for user to modify
                    if(resident != null)
                    {
                        pmSelectedProfilePhoto = null;

                        if(resident.getProfileImage() != null)
                        {
                            pmFilePathLabel.setText("Photo uploaded");
                        }
                        else
                        {
                            pmFilePathLabel.setText("No photo uploaded");
                        }
                        pmIDTextBox.setText(resident.getHCN());
                        pmFNameTextBox.setText(resident.getfName());
                        pmLNameTextBox.setText(resident.getlName());
                        pmDOBTextBox.setText(resident.getDateOfBirth().toString());
                        pmEmailTextBox.setText(resident.getEmail());
                        pmPhoneTextBox.setText(resident.getPhoneNo());
                        pmEContactTextBox.setText(resident.geteContactFName());
                        pmEPhoneTextBox.setText(resident.geteContactPhoneNo());
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No Resident was found");
                    }
                }
                //CAREGIVER SEARCH
                else if("Caregiver".equals(pmTypeComboBox.getSelectedItem()))
                {
                    //Create a DAO to access the database
                    CaregiverDAO caregiverDAO = new CaregiverDAO();
                    Caregiver caregiver = caregiverDAO.getOneCaregiverViaName(pmInputFullName);

                    //Populate textboxes with data for user to modify
                    if(caregiver != null)
                    {
                        pmSelectedProfilePhoto = null;

                        if(caregiver.getProfileImage() != null)
                        {
                            pmFilePathLabel.setText("Photo uploaded");
                        }
                        else
                        {
                            pmFilePathLabel.setText("No photo uploaded");
                        }
                        pmIDTextBox.setText(caregiver.getWorkID());
                        pmFNameTextBox.setText(caregiver.getfName());
                        pmLNameTextBox.setText(caregiver.getlName());
                        pmEmailTextBox.setText(caregiver.getEmail());
                        pmPhoneTextBox.setText(caregiver.getPhoneNo());
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No Caregiver was found");
                    }
                }
            }
        });

        //ADD A ASSIGNMENT BETWEEN RESIDENT/CAREGIVER
        pmAddButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Save user input to a variable
                String pmAssignmentFullName = pmAssignmentTextBox.getText().trim();

                //DETECT INPUT
                if(pmAssignmentFullName.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter a name");
                    return;
                }

                //Add to list
                pmListModel.addElement(pmAssignmentFullName);
                pmAssignmentTextBox.setText("");
            }
        });

        //REMOVE A ASSIGNMENT BETWEEN RESIDENT/CAREGIVER
        pmRemoveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Save user selection from assignment list to a variable
                int pmAssignmentSelection = pmAssignmentList.getSelectedIndex();

                //DETECT INPUT
                if(pmAssignmentSelection != -1)
                {
                    pmListModel.remove(pmAssignmentSelection);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please enter a name");
                }
            }
        });

        //SAVE CHANGES TO DATABASE
        pmSaveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //DETECT INPUT
                if(pmTypeComboBox.getSelectedItem() == null)
                {
                    JOptionPane.showMessageDialog(null, "Please select a profile type");
                    return;
                }

                try
                {
                    //Handle DOB date conversion from text to date
                    java.sql.Date pmDOB = null;

                    try
                    {
                        pmDOB = java.sql.Date.valueOf(pmDOBTextBox.getText().trim());
                    }
                    catch (IllegalArgumentException ex)
                    {
                        JOptionPane.showMessageDialog(null, "Please use a yyyy-MM-dd format");
                        return;
                    }

                    //Handle profile photo conversion to stream if user reuploads an image
                    FileInputStream pmFIS = null;

                    if (pmSelectedProfilePhoto != null)
                    {
                        pmFIS = new FileInputStream(pmSelectedProfilePhoto);
                    }

                    //Get profile type from combo box and save to variable
                    String pmProfileType = pmTypeComboBox.getSelectedItem().toString();

                    //CREATE A PROFILE------------------------------------------------------
                    if (pmCreateRadioButton.isSelected())
                    {
                        //RESIDENT OPTION
                        if ("Resident".equals(pmProfileType))
                        {
                            //Create DAO object to access method to save input to database
                            ResidentDAO residentDAO = new ResidentDAO();

                            //Create a resident object using the DAO
                            residentDAO.createResident
                            (
                                pmIDTextBox.getText().trim(),
                                pmFNameTextBox.getText().trim(),
                                pmLNameTextBox.getText().trim(),
                                pmDOB,
                                pmEmailTextBox.getText().trim(),
                                pmPhoneTextBox.getText().trim(),
                                pmFIS,
                                pmEContactTextBox.getText().trim(),
                                pmEPhoneTextBox.getText().trim()
                            );

                            //Alert user of successful profile save
                            JOptionPane.showMessageDialog(null, "Resident profile has been saved");
                        }
                        //CAREGIVER OPTION
                        else if ("Caregiver".equals(pmProfileType))
                        {
                            //Create DAO object to access method to save input to database
                            CaregiverDAO caregiverDAO = new CaregiverDAO();

                            //Create a caregiver object using the DAO
                            caregiverDAO.createCaregiver
                            (
                                pmIDTextBox.getText().trim(),
                                pmFNameTextBox.getText().trim(),
                                pmLNameTextBox.getText().trim(),
                                pmEmailTextBox.getText().trim(),
                                pmPhoneTextBox.getText().trim(),
                                pmFIS
                            );

                            //Alert user of successful profile save
                            JOptionPane.showMessageDialog(null, "Caregiver profile has been saved");
                        }
                    }
                    //MODIFY A PROFILE
                    else if(pmModifyRadioButton.isSelected())
                    {
                        //RESIDENT OPTION
                        if ("Resident".equals(pmProfileType))
                        {
                            //Create DAO object to access method to save input to database
                            ResidentDAO residentDAO = new ResidentDAO();

                            //Create a resident object using the DAO
                            residentDAO.modifyResident
                            (
                                pmIDTextBox.getText().trim(),
                                pmFNameTextBox.getText().trim(),
                                pmLNameTextBox.getText().trim(),
                                pmDOBTextBox.getText().trim(),
                                pmEmailTextBox.getText().trim(),
                                pmPhoneTextBox.getText().trim(),
                                pmFIS,
                                pmEContactTextBox.getText().trim(),
                                pmEPhoneTextBox.getText().trim()
                            );

                            //Alert user of successful profile save
                            JOptionPane.showMessageDialog(null, "Resident profile has been updated");
                        }
                        //CAREGIVER OPTION
                        else if ("Caregiver".equals(pmProfileType))
                        {
                            //Create DAO object to access method to save input to database
                            CaregiverDAO caregiverDAO = new CaregiverDAO();

                            //Create a caregiver object using the DAO
                            caregiverDAO.modifyCaregiver
                            (
                                pmIDTextBox.getText().trim(),
                                pmFNameTextBox.getText().trim(),
                                pmLNameTextBox.getText().trim(),
                                pmEmailTextBox.getText().trim(),
                                pmPhoneTextBox.getText().trim(),
                                pmFIS
                            );

                            //Alert user of successful profile update
                            JOptionPane.showMessageDialog(null, "Caregiver profile has been updated");
                        }
                    }
                    //DELETE A PROFILE
                    else if(pmDeleteRadioButton.isSelected())
                    {
                        //RESIDENT OPTION
                        if("Resident".equals(pmProfileType))
                        {

                            //CONFIRM WITH THE USER IF THEY WANT TO DELETE THE PROFILE
                            int pmConfirmDelete = JOptionPane.showConfirmDialog
                                    (null, "Are you sure you want to delete this profile?", "Confirm?", JOptionPane.YES_NO_OPTION);

                            if(pmConfirmDelete == JOptionPane.YES_OPTION)
                            {
                                //Create DAO object to access database
                                ResidentDAO residentDAO = new ResidentDAO();

                                //Delete profile
                                residentDAO.deleteResident(pmIDTextBox.getText().trim());

                                //Alert user of successful profile deletion
                                JOptionPane.showMessageDialog(null, "Profile has been deleted");
                            }
                        }
                        //CAREGIVER OPTION
                        else if("Caregiver".equals(pmProfileType))
                        {
                            //CONFIRM WITH THE USER IF THEY WANT TO DELETE THE PROFILE
                            int pmConfirmDelete = JOptionPane.showConfirmDialog
                                    (null, "Are you sure you want to delete this profile?", "Confirm?", JOptionPane.YES_NO_OPTION);

                            if(pmConfirmDelete == JOptionPane.YES_OPTION)
                            {
                                //Create DAO object to access database
                                CaregiverDAO caregiverDAO = new CaregiverDAO();

                                //Delete profile
                                caregiverDAO.deleteCaregiver(pmIDTextBox.getText().trim());

                                //Alert user of successful profile deletion
                                JOptionPane.showMessageDialog(null, "Profile has been deleted");
                            }
                        }
                    }

                    //Close file input stream
                    if (pmFIS != null)
                    {
                        pmFIS.close();
                    }
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: Profile request was not saved");
                }
            }
        });

        //METHODS FOR MANAGER PROFILE EDIT | me ///////////////////////////////////////////////////////////////////////////////////

        //TOOLBAR BACK BUTTON METHOD
        meToolBarBackButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                menuCardLayout.show(rootPanel, "MAIN_MENU");
                mmListModel.clear();
            }
        });

        //DISABLE WORK ID TEXTBOX (Manager can't change their work ID)
        meIDTextBox.setEnabled(false);

        //CLEAR INPUT BUTTON
        meClearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                meFNameTextBox.setText("");
                meLNameTextBox.setText("");
                meEmailTextBox.setText("");
                mePhoneTextBox.setText("");
                meCurrentPasswordTextBox.setText("");
            }
        });

        //LOAD CURRENT MANAGER INFO
        Manager currentManager = CurrentSession.currentManager;

        //CHECK MANAGER OBJECT
        if(currentManager != null)
        {
            meIDTextBox.setText(currentManager.getWorkID());
            meFNameTextBox.setText(currentManager.getfName());
            meLNameTextBox.setText(currentManager.getlName());
            meEmailTextBox.setText(currentManager.getEmail());
            mePhoneTextBox.setText(currentManager.getPhoneNo());
            meCurrentPasswordTextBox.setText(currentManager.getPasswordHash());
        }

        //SAVE ACCOUNT MODIFICATIONS BUTTON
        meSaveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                //LOAD CURRENT MANAGER INFO
                Manager currentManager = CurrentSession.currentManager;

                //CHECK MANAGER OBJECT
                if(currentManager == null)
                {
                    JOptionPane.showMessageDialog(null, "No manager was session found");
                    return;
                }

                //GET NEW USER INPUT
                String meFName = meFNameTextBox.getText().trim();
                String meLName = meLNameTextBox.getText().trim();
                String meEmail = meEmailTextBox.getText().trim();
                String mePhone = mePhoneTextBox.getText().trim();

                //GET NEW PASSWORD
                String meCurrentPassword = new String(meCurrentPasswordTextBox.getPassword()).trim();
                String meNewPassword = new String(meNewPasswordTextbox.getPassword()).trim();
                String meConfirmPassword = new String(meConfirmPasswordTextBox.getPassword()).trim();

                //Create a DAO object to access database
                ManagerDAO managerDAO = new ManagerDAO();

                //CHECK USER INPUT
                if(meFName.isEmpty() || meLName.isEmpty() || meEmail.isEmpty() || mePhone.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please fill out all fields");
                    return;
                }

                //CHECK IF USER WANTS TO CHANGE THEIR PASSWORD
                //Set a password change flag
                boolean meChangePassword = !meNewPassword.isEmpty() || !meConfirmPassword.isEmpty();

                if(meChangePassword)
                {
                    //Check the user's current password input
                    boolean meMatch = PasswordUtil.verifyPassword(meCurrentPassword, currentManager.getPasswordHash());

                    if(!meMatch)
                    {
                        JOptionPane.showMessageDialog(null, "The current password is incorrect");
                        return;
                    }

                    //Check if the user's new password is retyped correctly (the same) in the confirm password field
                    if(!meNewPassword.equals(meConfirmPassword))
                    {
                        JOptionPane.showMessageDialog(null, "Your passwords do not match");
                        return;
                    }

                    //Enforce a password length
                    if(meNewPassword.length() < 8)
                    {
                        JOptionPane.showMessageDialog(null, "Password must be at least 8 characters");
                        return;
                    }

                    //Update the current Manager's profile with the new password
                    managerDAO.modifyManager(currentManager.getWorkID(), meFName, meLName, meEmail, mePhone, meNewPassword);
                }
                else
                {
                    //Update the current Manager's profile without a new password
                    managerDAO.modifyManager(currentManager.getWorkID(), meFName, meLName, meEmail, mePhone, "");
                }

                //UPDATE THE CURRENT SESSION'S MANAGER'S INFO
                currentManager.setfName(meFName);
                currentManager.setlName(meLName);
                currentManager.setEmail(meEmail);
                currentManager.setPhoneNo(mePhone);
                currentManager.setPasswordHash(meNewPassword);

                //Alert user of the Manager profile update
                JOptionPane.showMessageDialog(null, "Manager profile updated");

                //CLEAR PASSWORD FIELDS
                meCurrentPasswordTextBox.setText("");
                meNewPasswordTextbox.setText("");
                meConfirmPasswordTextBox.setText("");

            }
        });

        //METHODS FOR RECORD SEARCH | rs ///////////////////////////////////////////////////////////////////////////////////

        //TOOLBAR BACK BUTTON METHOD
        rsToolBarBackButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                menuCardLayout.show(rootPanel, "MAIN_MENU");
                mmListModel.clear();
            }
        });

        //ENABLE SEARCH TEXTBOXES BASED ON CHECKBOXES
        rsNameTextBox.setEnabled(false);
        rsDateTextbox.setEnabled(false);
        rsMedStatusTextbox.setEnabled(false);

        rsNameCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rsNameTextBox.setEnabled(rsNameCheckBox.isSelected());
            }
        });

        rsDateCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rsDateTextbox.setEnabled(rsDateCheckBox.isSelected());
            }
        });

        rsMedStatusCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rsMedStatusTextbox.setEnabled(rsMedStatusCheckBox.isSelected());
            }
        });

        //Declare a list model (allows a list to be edited)
        rsListModel = new DefaultListModel<>();
        rsResultList.setModel(rsListModel);

        //Declare a table model (allows a table to be edited)
        rsTableModel = new DefaultTableModel();
        rsResultTable.setModel(rsTableModel);

        rsMedTableModel = new DefaultTableModel();
        rsMedResultTable.setModel(rsMedTableModel);

        //Set up table model for data display starting with headers
        rsTableModel.setColumnIdentifiers
                (new String[]{
                        "Record ID", "HCN", "Date", "Time", "Note",
                        "Mood", "Pain Level", "Sleep Quality",
                        "Systolic Pressure", "Diastolic Pressure", "Blood Sugar", "Temperature", "Heart Rate"
                });

        rsMedTableModel.setColumnIdentifiers
                (new String[]{
                        "Medication Name", "Dose", "Time Given", "Status", "Med Note"
                });

        //CLEAR INPUT BUTTON
        rsClearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                healthRecordCheckGroup.clearSelection();
                rsNameTextBox.setText("");
                rsDateTextbox.setText("");
                rsMedStatusTextbox.setText("");
                rsListModel.clear();
                rsTableModel.setColumnCount(0);
                rsTableModel.setRowCount(0);
                rsMedTableModel.setColumnCount(0);
                rsMedTableModel.setRowCount(0);
            }
        });

        //SEARCH RECORDS BUTTON
        rsSearchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //DETECT INPUT
                if((rsNameCheckBox.isSelected() && rsNameTextBox.getText().isEmpty()) ||
                        (rsDateCheckBox.isSelected() && rsDateTextbox.getText().isEmpty()) ||
                        (rsMedStatusCheckBox.isSelected() && rsMedStatusTextbox.getText().isEmpty()))
                {
                    JOptionPane.showMessageDialog(null, "Please enter input for the selected fields");
                    return;
                }

                //check date format if Date checkbox is selected
                if(rsDateCheckBox.isSelected())
                {
                    try
                    {
                        java.sql.Date.valueOf(rsDateTextbox.getText().trim());
                    }
                    catch(IllegalArgumentException ex)
                    {
                        JOptionPane.showMessageDialog(null, "Please enter date as yyyy-MM-dd");
                        return;
                    }
                }

                //Save user inputs to variables depending on which option they pick for search
                String rsInputName = rsNameCheckBox.isSelected() ? rsNameTextBox.getText().trim() : null;
                String rsInputDate = rsDateCheckBox.isSelected() ? rsDateTextbox.getText().trim() : null;
                String rsInputStatus = rsMedStatusCheckBox.isSelected() ? rsMedStatusTextbox.getText().trim() : null;

                //Create a DAO object to access data and display
                HealthRecordDAO healthRecordDAO = new HealthRecordDAO();
                List<HealthRecord> healthRecordResults = healthRecordDAO.getAllHealthRecords(rsInputName, rsInputDate, rsInputStatus);

                //Clear previous input
                rsTableModel.setRowCount(0);
                rsTableModel.setColumnCount(0);
                rsMedTableModel.setColumnCount(0);
                rsMedTableModel.setRowCount(0);

                //Populate list with health record results
                if(healthRecordResults != null && !healthRecordResults.isEmpty())
                {
                    //Save the current results found from user input
                    rsSelectionResults = healthRecordResults;

                    //Fill out list with the current search results from user input using a loop
                    for(HealthRecord healthRecord : healthRecordResults)
                    {
                        //Get Resident name using HCN
                        String residentName = healthRecordDAO.getResidentNameViaHCN(healthRecord.getHCN());

                        //Store info in string
                        String displayRecord =
                                healthRecord.getRecordID() + " | "
                                + healthRecord.getHCN() + " | "
                                + residentName
                                + healthRecord.getEntryDate();

                        //Add string to list model
                        rsListModel.addElement(displayRecord);
                    }

                    //Set model in list
                    rsResultList.setModel(rsListModel);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No health record was found");
                }
            }
        });

        //LIST SELECTION LISTENER
        //Get info from a listed health record result to display in table
        rsResultList.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                //Check is user is in the middle of a current action
                if(!e.getValueIsAdjusting())
                {
                    //Save the selected list index to a variable
                    int rsSelectedIndex = rsResultList.getSelectedIndex();

                    //Load the data from the selected record into the results table
                    if(rsSelectedIndex != -1)
                    {
                        //Save the index of the selected record to pass to method
                        HealthRecord rsSelectedRecord = rsSelectionResults.get(rsSelectedIndex);

                        //Load details
                        loadHealthRecords(rsSelectedRecord);
                    }
                }
            }
        });

        //METHODS FOR RECORD MANAGEMENT | rm ///////////////////////////////////////////////////////////////////////////////////

        //TOOLBAR BACK BUTTON METHOD
        rmToolBarBackButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                menuCardLayout.show(rootPanel, "MAIN_MENU");
                mmListModel.clear();
            }
        });

        //INSERT TAB +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //POPULATE MEDICATION STATUS COMBO BOX
        iTabStatusComboBox.addItem("Given");
        iTabStatusComboBox.addItem("Late");
        iTabStatusComboBox.addItem("Missed");
        iTabStatusComboBox.setSelectedIndex(-1);

        //Declare a list model (allows a list to be edited)
        iTabListModel = new DefaultListModel<>();
        iTabMedEntryList.setModel(iTabListModel);

        //ADD A MEDICATION ENTRY TO LIST (using list since multiple medications can be attached to one health record)
        iTabAddEntryButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Save user input to variables
                String medName = iTabMedNameTextBox.getText().trim();
                String dose = iTabDoseTextBox.getText().trim();
                String time = iTabTimeTextBox.getText().trim();
                String status = (String) iTabStatusComboBox.getSelectedItem();

                //Check for user input
                if(medName.isEmpty() || dose.isEmpty() || time.isEmpty() || status == null)
                {
                    JOptionPane.showMessageDialog(null, "Please enter input in all the medication fields");
                    return;
                }

                //Enter values into a string variable to display in list model
                String iTabMedEntry = medName + " | " + dose + " | " + time + " | " + status;
                iTabListModel.addElement(iTabMedEntry);

                //Clear fields to allow user to add another set of values for a medication entry if they choose so
                iTabMedNameTextBox.setText("");
                iTabDoseTextBox.setText("");
                iTabTimeTextBox.setText("");
                iTabStatusComboBox.setSelectedIndex(-1);
            }
        });

        //REMOVE A MEDICATION ENTRY FROM LIST (remove a wrong entry BEFORE saving the entire record)
        iTabRemoveEntryButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Save user selected index from list to grab which entry they want to delete
                int iTabSelectedIndex = iTabMedEntryList.getSelectedIndex();

                //Check for user input
                if(iTabSelectedIndex != -1)
                {
                    //Remove entry from list
                    iTabListModel.remove(iTabSelectedIndex);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please select an entry to remove from list");
                }
            }
        });

        //CLEAR INPUT BUTTON
        iTabClearAllButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                iTabHCNTextBox.setText("");
                iTabNameTextBox.setText("");
                iTabNotesTextArea.setText("");
                iTabSystolicPressureTextBox.setText("");
                iTabDiastolicPressureTextBox.setText("");
                iTabBloodSugarTextBox.setText("");
                iTabTemperatureTextBox.setText("");
                iTabHeartRateTextBox.setText("");
                iTabMoodSlider.setValue(0);
                iTabPainLevelSlider.setValue(0);
                iTabSleepQualitySlider.setValue(0);
                iTabMedNameTextBox.setText("");
                iTabDoseTextBox.setText("");
                iTabTimeTextBox.setText("");
                iTabStatusComboBox.setSelectedIndex(-1);
                iTabNameTextBox.setText("");
                iTabListModel.clear();
            }
        });

        iTabSaveAllButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                // Generate a recordID
                int recordID = RecordIDGenerator.generateRecordID();









                //Save user input to variables to pass into create Health Record method
                /*String HCN = iTabHCNTextBox.getText().trim();
                String fullName = iTabNameTextBox.getText().trim();


                String note = iTabNotesTextArea.getText().trim();


                //Create DAO objects to access data
                HealthRecordDAO healthRecordDAO = new HealthRecordDAO();
                healthRecordDAO.createHealthRecord(recordID, HCN, fullName,entryDate, entryTime, note, createdAt);

                //Alert user of record creation*/


            }
        });

        //EDIT TAB +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //POPULATE MEDICATION STATUS COMBO BOX
        eTabStatusComboBox.addItem("Given");
        eTabStatusComboBox.addItem("Late");
        eTabStatusComboBox.addItem("Missed");
        eTabStatusComboBox.setSelectedIndex(-1);

        //Declare a list model (allows a list to be edited)
        eTabListModel = new DefaultListModel<>();
        eTabMedEntryList.setModel(eTabListModel);

        eTabListModelResults = new DefaultListModel<>();
        eTabResultsList.setModel(eTabListModelResults);

        //ENABLE TEXTBOXES BASED ON CHECKED BOXES
        eTabNameTextBox.setEnabled(false);
        eTabRecordIDTextBox.setEnabled(false);

        eTabSearchNameCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                eTabNameTextBox.setEnabled(eTabSearchNameCheckBox.isSelected());
            }
        });

        eTabRecordIDCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                eTabRecordIDTextBox.setEnabled(eTabRecordIDCheckBox.isSelected());
            }
        });

        //ADD A EDITED MEDICATION ENTRY
        eTabAddEntryButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Save user input to variables
                String medName = eTabMedNameTextBox.getText().trim();
                String dose = eTabDoseTextBox.getText().trim();
                String time = eTabTimeTextBox.getText().trim();
                String status = (String) eTabStatusComboBox.getSelectedItem();

                //Check for user input
                if(medName.isEmpty() || dose.isEmpty() || time.isEmpty() || status == null)
                {
                    JOptionPane.showMessageDialog(null, "Please enter input in all the medication fields");
                    return;
                }

                //Enter values into a string variable to display in list model
                String eTabMedEntry = medName + " | " + dose + " | " + time + " | " + status;
                eTabListModel.addElement(eTabMedEntry);

                //Clear fields to allow user to add another set of values for a medication entry if they choose so
                eTabMedNameTextBox.setText("");
                eTabDoseTextBox.setText("");
                eTabTimeTextBox.setText("");
                eTabStatusComboBox.setSelectedIndex(-1);
            }
        });

        //REMOVE A MEDICATION ENTRY
        eTabRemoveEntryButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Save user selected index from list to grab which entry they want to delete
                int eTabSelectedIndex = eTabMedEntryList.getSelectedIndex();

                //Check for user input
                if(eTabSelectedIndex != -1)
                {
                    //Remove entry from list
                    iTabListModel.remove(eTabSelectedIndex);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please select an entry to remove from list");
                }
            }
        });

        //SELECT A MEDICATION ENTRY TO EDIT
        eTabMedEntryList.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);








            }
        });

        //CLEAR INPUT BUTTON
        eTabClearAllButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                eTabSearchNameCheckBox.setSelected(false);
                eTabSearchNameTextBox.setText("");
                eTabRecordIDCheckBox.setSelected(false);
                eTabRecordIDTextBox.setText("");
                eTabHCNTextBox.setText("");
                eTabNameTextBox.setText("");
                eTabNotesTextArea.setText("");
                eTabSystolicPressureTextBox.setText("");
                eTabDiastolicPressureTextBox.setText("");
                eTabBloodSugarTextBox.setText("");
                eTabTemperatureTextBox.setText("");
                eTabHeartRateTextBox.setText("");
                eTabMoodSlider.setValue(0);
                eTabPainLevelSlider.setValue(0);
                eTabSleepQualitySlider.setValue(0);
                eTabMedNameTextBox.setText("");
                eTabDoseTextBox.setText("");
                eTabTimeTextBox.setText("");
                eTabStatusComboBox.setSelectedIndex(-1);
                eTabNameTextBox.setText("");
                eTabListModel.clear();
            }
        });

        //SEARCH BUTTON (Preloads record info)
        eTabSearchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Save user input for searching health records to edit to variables
                String inputName = eTabNameTextBox.getText().trim();
                String inputRecordID = eTabRecordIDTextBox.getText().trim();

                //Save user input to variables
                String medName = eTabMedNameTextBox.getText().trim();
                String dose = eTabDoseTextBox.getText().trim();
                String time = eTabTimeTextBox.getText().trim();
                String status = (String) eTabStatusComboBox.getSelectedItem();

                //Check for user input
                if(medName.isEmpty() || dose.isEmpty() || time.isEmpty() || status == null)
                {
                    JOptionPane.showMessageDialog(null, "Please enter input in all the medication fields");
                    return;
                }

                //Enter values into a string variable to display in list model
                String eTabMedEntry = medName + " | " + dose + " | " + time + " | " + status;
                eTabListModel.addElement(eTabMedEntry);

                //Clear fields to allow user to add another set of values for a medication entry if they choose so
                eTabMedNameTextBox.setText("");
                eTabDoseTextBox.setText("");
                eTabTimeTextBox.setText("");
                eTabStatusComboBox.setSelectedIndex(-1);
            }
        });

        //SAVE BUTTON
        eTabSaveAllButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {












            }
        });

        //DELETE TAB +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //ENABLE TEXTBOXES BASED ON CHECKED BOXES
        dTabNameTextBox.setEnabled(false);
        dTabRecordIDTextBox.setEnabled(false);

        dTabFullNameRadioButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dTabNameTextBox.setEnabled(dTabFullNameRadioButton.isSelected());
            }
        });

        dTabRecordIDRadioButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dTabRecordIDTextBox.setEnabled(dTabRecordIDRadioButton.isSelected());
            }
        });

        //Declare a list model and table mode (allows a list/table to be edited)
        dTabListModel = new DefaultListModel<>();
        dTabResultList.setModel(dTabListModel);

        dTabTableModel = new DefaultTableModel();
        dTabResultsTable.setModel(dTabTableModel);

        //CLEAR INPUT BUTTON
        dTabClearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dTabFullNameRadioButton.setSelected(false);
                dTabRecordIDRadioButton.setSelected(false);
                dTabNameTextBox.setText("");
                dTabRecordIDTextBox.setText("");
                dTabListModel.clear();
            }
        });

        //SEARCH RECORD TO DELETE BUTTON
        dTabSearchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //DETECT INPUT
                if (dTabFullNameRadioButton.isSelected() && dTabNameTextBox.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter a full name");
                    return;
                }

                if (dTabRecordIDRadioButton.isSelected() && dTabRecordIDTextBox.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter a Record ID");
                    return;
                }

                //Variables to grab user input
                String dTabFullName = dTabNameTextBox.getText();
                String dTabRecordID = dTabRecordIDTextBox.getText();

                //Clear previous results
                dTabListModel.clear();
                dTabTableModel.setRowCount(0);
                dTabTableModel.setColumnCount(0);

                //Create DAO object to access database
                HealthRecordDAO healthRecordDAO = new HealthRecordDAO();

                //Populate List depending on user input option
                //If user selects to search by a Full Name
                if(dTabFullNameRadioButton.isSelected())
                {

                    //Create a list to save results to
                    List<HealthRecord> healthRecords = new ArrayList<>();

                    //Grab Health Record results based on user input
                    healthRecords = healthRecordDAO.getHealthRecordViaName(dTabFullName);

                    if(healthRecords != null && !healthRecords.isEmpty())
                    {
                        //Save search results to use in table
                        dTabSelectionResults = healthRecords;

                        //Fill out results list using a loop
                        for(HealthRecord hr : healthRecords)
                        {
                            String dTabResults = "Record ID:" + hr.getRecordID() +
                                                    "HCN: " + hr.getHCN() +
                                                    "Entry Date: " + hr.getEntryDate();
                            dTabListModel.addElement(dTabResults);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No Health Records were found");
                        return;
                    }
                }
                //If user selects to search by Record ID
                else if(dTabRecordIDRadioButton.isSelected())
                {

                    //Create a list to save results to
                    List<HealthRecord> healthRecords = new ArrayList<>();

                    //Grab Health Record results based on user input
                    healthRecords = healthRecordDAO.getHealthRecordViaID(dTabRecordID);

                    if(healthRecords != null && !healthRecords.isEmpty())
                    {
                        //Save search results to use in table
                        dTabSelectionResults = healthRecords;

                        //Fill out results list using a loop
                        for(HealthRecord hr : healthRecords)
                        {
                            String dTabResults = "Record ID:" + hr.getRecordID() +
                                                    "HCN: " + hr.getHCN() +
                                                    "Entry Date: " + hr.getEntryDate();
                            dTabListModel.addElement(dTabResults);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No Health Records were found");
                        return;
                    }
                }
            }
        });

        //LOAD RECORD CONTENTS ONTO TABLE AFTER LIST USER SELECTION
        dTabResultList.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {

                //Check is user is in the middle of a current action
                if(!e.getValueIsAdjusting())
                {

                    //Save the selected list index to a variable
                    int dTabSelectedIndex = dTabResultList.getSelectedIndex();

                    //Load the data from the selected record into the results table
                    if(dTabSelectedIndex != -1)
                    {
                        //Save the index of the selected record to pass to method
                        HealthRecord dTabSelectedHealthRecord = dTabSelectionResults.get(dTabSelectedIndex);

                        //Clear previous results
                        dTabTableModel.setRowCount(0);
                        dTabTableModel.setColumnCount(0);

                        //Set up table model for data display starting with headers
                        dTabTableModel.setColumnIdentifiers
                        (new String[]{
                            "Record ID", "Health Care Number", "Entry Date", "Entry Time", "Notes"
                        });

                        //Load details
                        dTabTableModel.addRow
                        (new Object[]{
                            dTabSelectedHealthRecord.getRecordID(),
                            dTabSelectedHealthRecord.getHCN(),
                            dTabSelectedHealthRecord.getEntryDate(),
                            dTabSelectedHealthRecord.getEntryTime(),
                            dTabSelectedHealthRecord.getNote()
                        });
                    }
                }
            }
        });

        //SAVE BUTTON
        dTabDeleteButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                //Get user selected index from results list
                int dTabSelectedIndex = dTabResultList.getSelectedIndex();

                //CHECK USER SELECTION INPUT
                if(dTabSelectedIndex == -1)
                {
                    JOptionPane.showMessageDialog(null, "Please select a record to delete");
                    return;
                }

                //CONFIRM WITH THE USER IF THEY WANT TO DELETE THE HEALTH RECORD
                int dTabConfirmDelete = JOptionPane.showConfirmDialog
                        (null, "Are you sure you want to delete this health record?", "Confirm?", JOptionPane.YES_NO_OPTION);

                //DELETE RECORD DEPENDING ON USER CONFIRMATION
                if(dTabConfirmDelete == JOptionPane.YES_OPTION)
                {
                    //Get selected health record to delete by selected index
                    HealthRecord dTabSelectedChoice = dTabSelectionResults.get(dTabSelectedIndex);

                    //Create a DAO object to access database
                    HealthRecordDAO healthRecordDAO = new HealthRecordDAO();

                    //Delete the Health Record
                    healthRecordDAO.deleteHealthRecord(dTabSelectedChoice.getRecordID());

                    //Alert user of deletion
                    JOptionPane.showMessageDialog(null, "Health Record has been deleted");

                    //Remove deleted record from the results list
                    dTabListModel.remove(dTabSelectedIndex);
                    dTabTableModel.setRowCount(0);
                    dTabSelectionResults.remove(dTabSelectedIndex);
                }
            }
        });

        //METHODS FOR ACTIVITY SEARCH | as ///////////////////////////////////////////////////////////////////////////////////

        //TOOLBAR BACK BUTTON METHOD
        asToolBarBackButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                menuCardLayout.show(rootPanel, "MAIN_MENU");
                mmListModel.clear();
            }
        });

        //Declare a list model (allows a list to be edited)
        asListModel = new DefaultListModel<>();
        asResultList.setModel(asListModel);

        //Declare a table model (allows a table to be edited)
        asTableModel = new DefaultTableModel();
        asResultTable.setModel(asTableModel);

        //CLEAR INPUT BUTTON
        asClearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                asSearchTextBox.setText("");
                asListModel.clear();
                asTableModel.setColumnCount(0);
                asTableModel.setRowCount(0);
            }
        });

        //SEARCH ACTIVITY BUTTON
        asSearchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //DETECT USER INPUT
                if(asSearchTextBox.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter a title");
                    return;
                }

                //Grab user input
                String inputTitle = asSearchTextBox.getText().trim();

                //Clear previous search results
                asListModel.clear();
                asTableModel.setRowCount(0);
                asTableModel.setColumnCount(0);

                //Create DAO objects to access database
                ActivityDAO activityDAO = new ActivityDAO();
                List<Activity> activities = activityDAO.getAllActivitiesByTitle(inputTitle);

                if(activities != null && !activities.isEmpty())
                {

                    //Save the search results to a list to use for the results table
                    asSelectionResults = activities;

                    //Fill out results list using a loop
                    for(Activity a : activities)
                    {
                        String asResults = a.getActivityID() + " | " + a.getTitle();
                        asListModel.addElement(asResults);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No activities were found");
                    return;
                }
            }
        });

        //RESULTS LIST ON SELECTION LOADS DETAILS ONTO TABLE
        asResultList.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                //Check is user is in the middle of a current action
                if(!e.getValueIsAdjusting())
                {
                    //Save the selected list index to a variable
                    int asSelectedIndex = asResultList.getSelectedIndex();

                    //Load the data from the selected record into the results table
                    if(asSelectedIndex != 1)
                    {
                        //Save the index of the selected record to pass to method
                        Activity asSelectedActivity = asSelectionResults.get(asSelectedIndex);

                        //Clear previous results
                        asTableModel.setRowCount(0);
                        asTableModel.setColumnCount(0);

                        //Set up table model for data display starting with headers
                        asTableModel.setColumnIdentifiers
                        (new String[]{
                            "Activity ID", "Title", "Date", "Time",
                            "Description", "Participant Notes", "Status"
                        });

                        //Load details
                        asTableModel.addRow
                        (new Object[]{
                            asSelectedActivity.getActivityID(),
                            asSelectedActivity.getTitle(),
                            asSelectedActivity.getDate(),
                            asSelectedActivity.getTime(),
                            asSelectedActivity.getDescription(),
                            asSelectedActivity.getParticipantNotes(),
                            asSelectedActivity.getStatus()
                        });
                    }
                }
            }
        });

        //METHODS FOR ACTIVITY MANAGEMENT | am ///////////////////////////////////////////////////////////////////////////////////

        //TOOLBAR BACK BUTTON METHOD
        amToolBarBackButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                menuCardLayout.show(rootPanel, "MAIN_MENU");
                mmListModel.clear();
            }
        });

        //POPULATE COMBO BOX
        amStatusComboBox.addItem("Planned");
        amStatusComboBox.addItem("Ongoing");
        amStatusComboBox.addItem("Completed");
        amStatusComboBox.addItem("Cancelled");
        amStatusComboBox.setSelectedIndex(-1);

        //DISABLE & ENABLE SEARCH BOX BASED ON RADIO BUTTON CHOICE
        amCreateRadioButton.setSelected(true);
        amSearchTextBox.setEnabled(false);

        amModifyRadioButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                amSearchTextBox.setEnabled(amModifyRadioButton.isSelected());
            }
        });

        amDeleteRadioButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                amSearchTextBox.setEnabled(amDeleteRadioButton.isSelected());
            }
        });

        //CLEAR INPUT BUTTON
        amClearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                amCreateRadioButton.setSelected(true);
                amSearchTextBox.setEnabled(false);
                amTitleTextBox.setText("");
                amDateTextBox.setText("");
                amTimeTextBox.setText("");
                amDescriptionTextArea.setText("");
                amNotesTextArea.setText("");
                amStatusComboBox.setSelectedIndex(-1);
            }
        });

        //SEARCH ACTIVITY BUTTON
        amSearchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                if(amSearchTextBox.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter a title");
                    return;
                }

                //Clear any past results
                amTitleTextBox.setText("");
                amDateTextBox.setText("");
                amTimeTextBox.setText("");
                amDescriptionTextArea.setText("");
                amNotesTextArea.setText("");
                amStatusComboBox.setSelectedIndex(-1);

                //Grab user input and save to a variable
                String titleInput = amSearchTextBox.getText().trim();

                //Creat DAO object to connect to database
                ActivityDAO activityDAO = new ActivityDAO();
                Activity activity = activityDAO.getOneActivity(titleInput);

                //Populate textboxes with data for user to modify
                if(activity != null)
                {
                    amTitleTextBox.setText(activity.getTitle());
                    amDateTextBox.setText(activity.getDate().toString());
                    amTimeTextBox.setText(activity.getTime().toString());
                    amDateTextBox.setText(activity.getDescription());
                    amNotesTextArea.setText(activity.getParticipantNotes());
                    amStatusComboBox.setSelectedItem(activity.getStatus());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No Activity was found");
                }
            }
        });

        //SAVE ACTIVITY BUTTON
        amSaveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //check empty fields
                if(amTitleTextBox.getText().trim().isEmpty() ||
                        amDateTextBox.getText().trim().isEmpty() ||
                        amTimeTextBox.getText().trim().isEmpty() ||
                        amDescriptionTextArea.getText().trim().isEmpty() ||
                        amNotesTextArea.getText().trim().isEmpty() ||
                        amStatusComboBox.getSelectedItem() == null)
                {
                    JOptionPane.showMessageDialog(null, "Please fill out all fields");
                    return;
                }

                //check date format
                try
                {
                    java.sql.Date.valueOf(amDateTextBox.getText().trim());
                }
                catch(IllegalArgumentException ex)
                {
                    JOptionPane.showMessageDialog(null, "Please enter date as yyyy-MM-dd");
                    return;
                }

                //check time format
                try
                {
                    java.sql.Time.valueOf(amTimeTextBox.getText().trim());
                }
                catch(IllegalArgumentException ex)
                {
                    JOptionPane.showMessageDialog(null, "Please enter time as HH:mm:ss");
                    return;
                }

                try
                {
                    ActivityDAO aDAO = new ActivityDAO();

                    //Save user input to variables
                    String amTitle = amTitleTextBox.getText().trim();
                    String amDate = amDateTextBox.getText().trim();
                    String amTime = amTimeTextBox.getText().trim();
                    String amDescription = amDescriptionTextArea.getText();
                    String amNotes = amNotesTextArea.getText();
                    String amStatus = amStatusComboBox.getSelectedItem().toString();

                    //Check user input
                    if(amTitle.isEmpty() || amDate.isEmpty() || amTime.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Please fill all required fields");
                        return;
                    }

                    //CONVERT TYPES
                    java.sql.Date amDateStr = java.sql.Date.valueOf(amDate); // format: YYYY-MM-DD
                    java.sql.Time amTimeStr = java.sql.Time.valueOf(amTime); // format: HH:MM:SS

                    //CREATE
                    if(amCreateRadioButton.isSelected())
                    {
                        aDAO.createActivity(amTitle, amDateStr, amTimeStr, amDescription, amNotes, amStatus);
                        JOptionPane.showMessageDialog(null, "Activity has been created");
                    }
                    //MODIFY
                    else if(amModifyRadioButton.isSelected())
                    {
                        //Check if the activity the user is searching for exists
                        Activity existing = aDAO.getOneActivity(amTitle);

                        if(existing == null)
                        {
                            JOptionPane.showMessageDialog(null, "No Activity was found");
                            return;
                        }

                        //Update the activity
                        aDAO.modifyActivity
                        (
                            existing.getActivityID(),
                            amTitle, amDateStr, amTimeStr, amDescription, amNotes, amStatus
                        );

                        JOptionPane.showMessageDialog(null, "Activity has been updated");
                    }
                    //DELETE
                    else if(amDeleteRadioButton.isSelected())
                    {
                        //CONFIRM WITH THE USER IF THEY WANT TO DELETE THE ACTIVITY
                        int amConfirmDelete = JOptionPane.showConfirmDialog
                                (null, "Are you sure you want to delete this activity?", "Confirm?", JOptionPane.YES_NO_OPTION);

                        //DELETE ACTIVITY DEPENDING ON USER CONFIRMATION
                        if(amConfirmDelete == JOptionPane.YES_OPTION)
                        {
                            //Delete Activity
                            aDAO.deleteActivity(amTitle);

                            //Alert user of deletion
                            JOptionPane.showMessageDialog(null, "Activity has been deleted");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Please select an action");
                    }
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Invalid date/time format");
                }
            }
        });

        //METHODS FOR REPORT GENERATE | rg ///////////////////////////////////////////////////////////////////////////////////

        //TOOLBAR BACK BUTTON METHOD
        rgToolBarBackButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                menuCardLayout.show(rootPanel, "MAIN_MENU");
                mmListModel.clear();
            }
        });

        //ACTIVATE TEXT BOX FOR YEAR/MONTH
        rgYearTextBox.setEnabled(false);
        rgMonthTextBox.setEnabled(false);

        rgYearCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rgYearTextBox.setEnabled(rgYearCheckBox.isSelected());
            }
        });

        rgMonthCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rgMonthTextBox.setEnabled(rgMonthCheckBox.isSelected());
            }
        });

        //Declare a table model (allows a table to be edited)
        rgTableModel = new DefaultTableModel();
        rgResultsTable.setModel(rgTableModel);

        rgTableModelCounts = new DefaultTableModel();
        rgTotalCountsTable.setModel(rgTableModelCounts);

        //CLEAR INPUT BUTTON
        rgClearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rgUserMedRadioButton.setSelected(false);
                rgYearCheckBox.setSelected(false);
                rgMonthCheckBox.setSelected(false);
                rgYearTextBox.setText("");
                rgMonthTextBox.setText("");
                rgTableModel.setColumnCount(0);
                rgTableModel.setRowCount(0);
            }
        });

        //GENERATE A REPORT BUTTON
        rgGenerateButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                //CHECK USER INPUT FOR RADIO BUTTONS
                if(!rgUserMedRadioButton.isSelected() && !rgHealthIrregRadioButton.isSelected())
                {
                    JOptionPane.showMessageDialog(null, "Please select a report type");
                    return;
                }

                //Save type of report to a variable
                String rgReportType = "";
                if(rgUserMedRadioButton.isSelected())
                {
                    rgReportType = "UserMedicationSummary";
                }
                else if(rgHealthIrregRadioButton.isSelected())
                {
                    rgReportType = "HealthIrregularitiesSummary";
                }

                //Save the year and/or month from user input to a variable
                int rgReportYear = 0;
                int rgReportMonth = 0;

                //ENFORCE USER INPUT TO BE NUMBERS
                //CHECK USER INPUT
                try
                {
                    if(rgYearCheckBox.isSelected())
                    {
                        if(rgYearTextBox.getText().isEmpty())
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a year");
                            return;
                        }

                        //Save year input
                        rgReportYear = Integer.parseInt(rgYearTextBox.getText().trim());

                    }

                    if(rgMonthCheckBox.isSelected())
                    {
                        if(rgMonthTextBox.getText().isEmpty())
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a month");
                            return;
                        }

                        //Save month input
                        rgReportMonth = Integer.parseInt(rgMonthTextBox.getText().trim());

                    }
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "Please enter Year and Month input must as numbers");
                }

                //CALL METHODS TO CREATE AND STORE REPORTS IN DATABASE
                if(rgReportType.equals("UserMedicationSummary"))
                {
                    generateReportUMS(rgReportYear, rgReportMonth);
                    JOptionPane.showMessageDialog(null, "Report has been created");
                }
                else if(rgReportType.equals("HealthIrregularitiesSummary"))
                {
                    generateReportHIS(rgReportYear, rgReportMonth);
                    JOptionPane.showMessageDialog(null, "Report has been created");
                }
            }
        });

        //METHODS FOR PROFILE MANAGEMENT | rgs ///////////////////////////////////////////////////////////////////////////////////

        //TOOLBAR BACK BUTTON METHOD
        rgsToolBarButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                menuCardLayout.show(rootPanel, "MAIN_MENU");
                mmListModel.clear();
            }
        });

        //Declare a list and table model (allows them to be edited)
        rgsListModel = new DefaultListModel<>();
        rgsResultList.setModel(rgsListModel);

        rgsTableModel = new DefaultTableModel();
        rgsResultTable.setModel(rgsTableModel);

        //Enable textboxes based on user input
        rgsYearTextBox.setEnabled(rgsYearCheckBox.isSelected());
        rgsMonthTextbox.setEnabled(rgsMonthCheckBox.isSelected());


        //CLEAR INPUT BUTTON
        rgsClearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rgsHealthIrregularitiesSummaryRadioButton.setSelected(false);
                rgsUserMedicationSummaryRadioButton.setSelected(false);
                rgsYearCheckBox.setSelected(false);
                rgsMonthCheckBox.setSelected(false);
                rgsYearTextBox.setText("");
                rgsMonthTextbox.setText("");
                rgsListModel.clear();
                rgsTableModel.setRowCount(0);
                rgsTableModel.setColumnCount(0);
            }
        });

        //SEARCH REPORTS
        rgsSearchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Get report type, year, and month from user's input
                String reportType = "";
                int inputYear = 0;
                int inputMonth = 0;

                //Get a list of reports depending on type selected (AND CHECK USER INPUT)
                if(rgsUserMedicationSummaryRadioButton.isSelected())
                {
                    reportType = "UserMedicationSummary";
                }
                else if(rgsHealthIrregularitiesSummaryRadioButton.isSelected())
                {
                    reportType = "HealthIrregularitiesSummary";
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please select a report type");
                    return;
                }

                //Grab user input (ENFORCE DATE INPUT)
                try
                {
                    if(rgsYearCheckBox.isSelected())
                    {
                        inputYear = Integer.parseInt(rgsYearTextBox.getText().trim());
                    }

                    if(rgsMonthCheckBox.isSelected())
                    {
                        inputMonth = Integer.parseInt(rgsMonthTextbox.getText().trim());
                    }
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "Date input must be numbers");
                    return;
                }

                //Convert type (Integer can be null)
                Integer reportYear = (inputYear != 0) ? inputYear : null;
                Integer reportMonth = (inputMonth != 0) ? inputMonth : null;

                //Clear previous search results
                rgsListModel.clear();
                rgsTableModel.setRowCount(0);
                rgsTableModel.setColumnCount(0);

                //Create DAO object to access database
                ReportDAO reportDAO = new ReportDAO();

                //Declare a list of Report objects
                List<Report> reports = reportDAO.getReportsViaUserInput(reportType, reportYear, reportMonth);

                //Populate results list with Reports
                if(reports != null && !reports.isEmpty())
                {
                    //Save the search results to a list to use for the results table
                    rgsSelectionResults = reports;

                    //Fill out results list using a loop
                    for(Report r : reports)
                    {
                        String rgsResults =
                                r.getReportID() + " | " +
                                r.getType() + " | " +
                                "Year: " + r.getYear() + " | " +
                                "Month: " + r.getMonth();

                        rgsListModel.addElement(rgsResults);

                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No reports were found");
                }
            }
        });

        //DISPLAY REPORT DETAILS ON USER SELECTION IN A TABLE
        rgsResultList.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                //Check is user is in the middle of a current action
                if(!e.getValueIsAdjusting())
                {
                    //Save the selected list index to a variable
                    int rgsSelectedIndex = rgsResultList.getSelectedIndex();

                    //Load the data from the selected record into the results table
                    if(rgsSelectedIndex != -1)
                    {
                        //Save the index of the selected record to pass to method
                        Report rgsSelectedReport = rgsSelectionResults.get(rgsSelectedIndex);

                        //Clear previous results
                        rgsTableModel.setRowCount(0);
                        rgsTableModel.setColumnCount(0);

                        //Set up table model starting with headers
                        rgsTableModel.setColumnIdentifiers
                        (new String[]{
                            "Report ID", "Type", "Year", "Month", "Details"
                        });

                        //Load details
                        rgsTableModel.addRow
                        (new Object[]{
                            rgsSelectedReport.getReportID(),
                            rgsSelectedReport.getType(),
                            rgsSelectedReport.getYear(),
                            rgsSelectedReport.getMonth(),
                            rgsSelectedReport.getContent()
                        });
                    }
                }
            }
        });


    }

    //MainPackage.Main method for creating an object to attach form to
    public static void openMainMenuWindow()
    {
        ManagerMenuWindow managerMenuObj = new ManagerMenuWindow();
        managerMenuObj.callForm();
    }

    //Form structure to attach an object
    public void callForm()
    {

        //Set up JFrame and Root Panel
        managerMenuWindowFrame.setContentPane(rootPanel);
        menuCardLayout.show(rootPanel, "MAIN_MENU");
        managerMenuWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        managerMenuWindowFrame.setTitle("Care Ops | Main Menu");
        managerMenuWindowFrame.setSize(1500, 1000);
        managerMenuWindowFrame.setLocationRelativeTo(null);
        managerMenuWindowFrame.setVisible(true);

    }

}
