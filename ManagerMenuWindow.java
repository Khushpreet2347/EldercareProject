package GUIPackage;

import ClassPackage.*;
import DAOPackage.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Time;
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
    private JLabel pmNameLabel;
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
    private JLabel meIDLabel;
    private JLabel meFNameLabel;
    private JLabel meLNameLabel;
    private JLabel meEmailLabel;
    private JTextField mePhoneTextBox;
    private JLabel mePhoneLabel;
    private JSeparator meSeparator;
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
    private List<HealthRecord> rsCurrentSearchResults;
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
    private JLabel iTabNameLabel;
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
    private JTextField dTabDateTextBox;
    private JComboBox dTabMedStatusComboBox;
    private JCheckBox dTabNameCheckBox;
    private JCheckBox dTabDateCheckBox;
    private JCheckBox dTabRecordIDCheckBox;
    private JCheckBox dTabMedStatusCheckBox;
    private JButton dTabClearButton;
    private JButton dTabSearchButton;
    private JSeparator dTabSeparator;
    private DefaultListModel<String> dTabListModel;
    private JList dTabResultList;

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
    private JSplitPane rgSplitPane;
    private DefaultTableModel rgLeftTableModel;
    private JTable rgLeftTable;
    private DefaultTableModel rgRightTableModel;
    private JTable rgRightTable;
    private JButton rgGenerateButton;
    private JButton rgClearButton;
    private JTextField rgYearTextBox;
    private JTextField rgMonthTextBox;
    private JCheckBox rgMonthCheckBox;
    private JCheckBox rgYearCheckBox;
    private JRadioButton rgUserMedRadioButton;
    private JRadioButton rgHealthIrregRadioButton;
    private JToolBar rgToolBar;
    private JButton rgToolBarBackButton;

    //REPORT SEARCH PANEL | rgs
    private JTextField rgsSearchTextBox;
    private DefaultListModel<String> rgsListModel;
    private JList rgsResultList;
    private DefaultTableModel rgsTableModel;
    private JTable rgsResultTable;
    private JButton rgsToolBarButton;
    private JToolBar rgsToolBar;
    private JLabel rgsTitleLabel;
    private JLabel rgsSearchlabel;
    private JButton rgsClearButton;
    private JButton rgsSearchButton;

    //Declare a root card panel, other card panels will attach to the root
    private JPanel rootPanel;
    private JPanel reportSearchPanel;

    //Radio Button Groups
    private ButtonGroup activityManagementRadioGroup;
    private ButtonGroup profileManagementRadioGroup;
    private ButtonGroup reportGenerateRadioGroup;

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

        //Save health recordID to variable (is a foreign key in related health record tables in database
        int recordID = healthRecord.getRecordID();

        //Load DAOs to access data from
        ConditionDAO conditionDAO = new ConditionDAO();
        MedicationEntryDAO medicationEntryDAO = new MedicationEntryDAO();
        VitalSignsDAO vitalSignsDAO = new VitalSignsDAO();

        //Grab records of associated tables using a matching recordID from Health Record table
        //(Will return objects related to the Health Record entry
        Condition condition = conditionDAO.getOneCondition(recordID);
        List<MedicationEntry> medicationEntryList = medicationEntryDAO.getMedicationEntriesViaID(recordID);
        VitalSigns vitalSigns = vitalSignsDAO.getOneVitalSigns(recordID);

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

        //Add info to tables
        //HEALTH RECORD TABLE (Will show one record)
        rsTableModel.addRow
                (new Object[]
                {
                 recordID, healthRecord.getHCN(), healthRecord.getfName(), healthRecord.getlName(),
                        healthRecord.getEntryDate(), healthRecord.getEntryTime(), healthRecord.getNote(),
                 mood, painLevel, sleepQuality,
                 systolic, diastolic, bloodSugar, temperature, heartRate
                });

        //MEDICATION TABLE (Will show multiple records attach to the one health record
        if(medicationEntryList != null && !medicationEntryList.isEmpty())
        {
            for(MedicationEntry me : medicationEntryList)
            {
                rsMedTableModel.addRow(new Object[]
                {
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

        //ICONS FOR MAIN MENU PAGE
        ImageIcon menuLogo = new ImageIcon(getClass().getResource("/CareOpsLogo.png"));
        ImageIcon menuIcon = new ImageIcon(getClass().getResource("/healthcare.png"));

        //Convert and scale images
        Image menuLogoImage = menuLogo.getImage();
        Image scaledMenuLogo = menuLogoImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledImageMenuLogo = new ImageIcon(scaledMenuLogo);

        Image menuIconImage = menuIcon.getImage();
        Image scaledMenuIcon = menuIconImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledImageMenuIcon = new ImageIcon(scaledMenuIcon);

        //Set labels to be icons
        mmLogoLabel.setIcon(scaledImageMenuLogo);
        mmIconLabel.setIcon(scaledImageMenuIcon);

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

                //Clear any pass results
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
                        pmIDTextBox.setText(resident.getHCN());
                        pmFNameTextBox.setText(resident.getfName());
                        pmLNameTextBox.setText(resident.getlName());
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
                                pmIDTextBox.getText(),
                                pmFNameTextBox.getText(),
                                pmLNameTextBox.getText(),
                                pmEmailTextBox.getText(),
                                pmPhoneTextBox.getText(),
                                pmDOBTextBox.getText(),
                                pmFIS,
                                pmEContactTextBox.getText(),
                                pmEPhoneTextBox.getText()
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
                                pmIDTextBox.getText(),
                                pmFNameTextBox.getText(),
                                pmLNameTextBox.getText(),
                                pmEmailTextBox.getText(),
                                pmPhoneTextBox.getText(),
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
                                pmIDTextBox.getText(),
                                pmFNameTextBox.getText(),
                                pmLNameTextBox.getText(),
                                pmEmailTextBox.getText(),
                                pmPhoneTextBox.getText(),
                                pmDOBTextBox.getText(),
                                pmFIS,
                                pmEContactTextBox.getText(),
                                pmEPhoneTextBox.getText()
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
                                pmIDTextBox.getText(),
                                pmFNameTextBox.getText(),
                                pmLNameTextBox.getText(),
                                pmEmailTextBox.getText(),
                                pmPhoneTextBox.getText(),
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
                            ResidentDAO residentDAO = new ResidentDAO();
                            residentDAO.deleteResident(pmIDTextBox.getText());
                        }
                        //CAREGIVER OPTION
                        else if("Caregiver".equals(pmProfileType))
                        {
                            CaregiverDAO caregiverDAO = new CaregiverDAO();
                            caregiverDAO.deleteCaregiver(pmIDTextBox.getText());
                        }

                        //Alert user of successful profile deletion
                        JOptionPane.showMessageDialog(null, "Caregiver profile has been deleted");

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

        //LOAD CURRENT MANAGER INFO







        //DISABLE WORK ID TEXTBOX (Manager can't change their work ID)
        meIDTextBox.setEnabled(false);

        //CLEAR INPUT BUTTON
        meClearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                meFNameLabel.setText("");
                meLNameLabel.setText("");
                meEmailTextBox.setText("");
                mePhoneTextBox.setText("");
            }
        });

        //SAVE ACCOUNT MODIFICATIONS BUTTON
        meSaveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

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

                //Save user inputs to variables depending on which option they pick for search
                String rsInputName = rsNameCheckBox.isSelected() ? rsNameTextBox.getText().trim() : null;
                String rsInputDate = rsDateCheckBox.isSelected() ? rsDateTextbox.getText().trim() : null;
                String rsInputStatus = rsMedStatusCheckBox.isSelected() ? rsMedStatusTextbox.getText().trim() : null;

                //Create a DAO object to access data and display
                HealthRecordDAO healthRecordDAO = new HealthRecordDAO();
                ConditionDAO conditionDAO = new ConditionDAO();
                MedicationEntry medicationEntry = new MedicationEntry();
                VitalSignsDAO vitalSignsDAO = new VitalSignsDAO();
                List<HealthRecord> healthRecordResults = healthRecordDAO.getAllHealthRecords(rsInputName, rsInputDate, rsInputStatus);

                //Clear previous input
                rsTableModel.setRowCount(0);
                rsTableModel.setColumnCount(0);
                rsMedTableModel.setColumnCount(0);
                rsMedTableModel.setRowCount(0);

                //Get info from a listed health record result to display in table
                rsResultList.addListSelectionListener(new ListSelectionListener()
                {
                    @Override
                    public void valueChanged(ListSelectionEvent e)
                    {
                        //Check if value is empty
                        if(!e.getValueIsAdjusting())
                        {
                            //Save the selected list index to a variable
                            int rsSelectedIndex = rsResultList.getSelectedIndex();

                            //Load the data from the selected record into the results table
                            if(rsSelectedIndex != -1)
                            {
                                //Save the index of the selected record to pass to method
                                HealthRecord rsSelectedRecord = rsCurrentSearchResults.get(rsSelectedIndex);

                                //Load details
                                loadHealthRecords(rsSelectedRecord);
                            }
                        }
                    }
                });

                //Set up table model for data display starting with headers
                rsTableModel.setColumnIdentifiers
                        (new String[]{
                                "Record ID", "HCN", "Date", "Time", "Note", "Mood", "Pain Level", "Sleep Quality", "Systolic Pressure", "Diastolic Pressure", "Blood Sugar", "Temperature", "Heart Rate"
                        });

                rsMedTableModel.setColumnIdentifiers
                        (new String[]{
                                "Medication Name", "Dose", "Time Given", "Status", "Med Note"
                        });

                //Display search results in table













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

        iTabStatusComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        iTabRemoveEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        iTabAddEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        iTabMedEntryList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        iTabClearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        iTabSaveAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //EDIT TAB +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        eTabSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eTabStatusComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eTabRemoveEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eTabAddEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eTabMedEntryList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        eTabClearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eTabSaveAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //DELETE TAB +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //POPULATE MEDICATION STATUS COMBO BOX
        dTabMedStatusComboBox.addItem("Given");
        dTabMedStatusComboBox.addItem("Late");
        dTabMedStatusComboBox.addItem("Missed");
        dTabMedStatusComboBox.setSelectedIndex(-1);

        //ENABLE TEXTBOXES BASED ON CHECKED BOXES
        dTabNameTextBox.setEnabled(false);
        dTabDateTextBox.setEnabled(false);
        dTabRecordIDTextBox.setEnabled(false);
        dTabMedStatusComboBox.setEnabled(false);

        dTabNameCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dTabNameTextBox.setEnabled(dTabNameCheckBox.isSelected());
            }
        });

        dTabDateCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dTabDateTextBox.setEnabled(dTabDateCheckBox.isSelected());
            }
        });

        dTabRecordIDCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dTabRecordIDTextBox.setEnabled(dTabRecordIDCheckBox.isSelected());
            }
        });
        dTabMedStatusCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dTabMedStatusComboBox.setEnabled(dTabMedStatusCheckBox.isSelected());
            }
        });

        //Declare a list model (allows a list to be edited)
        dTabListModel = new DefaultListModel<>();
        dTabResultList.setModel(dTabListModel);

        //CLEAR INPUT BUTTON
        dTabClearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dTabNameCheckBox.setSelected(false);
                dTabDateCheckBox.setSelected(false);
                dTabMedStatusCheckBox.setSelected(false);
                dTabMedStatusComboBox.setSelectedIndex(-1);
                dTabNameTextBox.setText("");
                dTabDateTextBox.setText("");
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
                if(dTabNameCheckBox.isSelected() && dTabNameTextBox.getText().isEmpty() && dTabDateCheckBox.isSelected()
                        && dTabDateTextBox.getText().isEmpty() && dTabRecordIDCheckBox.isSelected() && dTabRecordIDTextBox.getText().isEmpty()
                        && dTabMedStatusCheckBox.isSelected() && dTabMedStatusComboBox.getSelectedIndex() == -1)
                {
                    JOptionPane.showMessageDialog(null, "Please enter at least one input");
                }
                else if((dTabNameCheckBox.isSelected() && dTabNameTextBox.getText().isEmpty()) || (dTabDateCheckBox.isSelected()
                        && dTabDateTextBox.getText().isEmpty()) || (dTabRecordIDCheckBox.isSelected() && dTabRecordIDTextBox.getText().isEmpty())
                        || (dTabMedStatusCheckBox.isSelected() && dTabMedStatusComboBox.getSelectedIndex() == -1))
                {
                    JOptionPane.showMessageDialog(null, "Please enter input for checked fields");
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
                String titleInput = asSearchTextBox.getText();

                //CHECK INPUT
                if(titleInput.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter a title");
                    return;
                }

                //CALL DAO
                ActivityDAO aDAO = new ActivityDAO();
                Activity activity = aDAO.getOneActivity(titleInput);

                if(activity == null)
                {
                    JOptionPane.showMessageDialog(null, "Activity not found");
                }
                else
                {
                    //FILL FIELDS
                    amTitleTextBox.setText(activity.getTitle());
                    amDateTextBox.setText(activity.getDate().toString());
                    amTimeTextBox.setText(activity.getTime().toString());
                    amDescriptionTextArea.setText(activity.getDescription());
                    amNotesTextArea.setText(activity.getParticipantNotes());
                    amStatusComboBox.setSelectedItem(activity.getStatus());
                }
            }
        });

        //SAVE ACTIVITY BUTTON
        amSaveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    ActivityDAO aDAO = new ActivityDAO();

                    //GET INPUT
                    String title = amTitleTextBox.getText();
                    String dateStr = amDateTextBox.getText();
                    String timeStr = amTimeTextBox.getText();
                    String description = amDescriptionTextArea.getText();
                    String notes = amNotesTextArea.getText();
                    String status = amStatusComboBox.getSelectedItem().toString();

                    //VALIDATION
                    if(title.isEmpty() || dateStr.isEmpty() || timeStr.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Please fill required fields");
                        return;
                    }

                    //CONVERT TYPES
                    java.sql.Date date = java.sql.Date.valueOf(dateStr); // format: YYYY-MM-DD
                    java.sql.Time time = java.sql.Time.valueOf(timeStr); // format: HH:MM:SS

                    //CREATE
                    if(amCreateRadioButton.isSelected())
                    {
                        aDAO.createActivity(0, title, date, time, description, notes, status);
                        JOptionPane.showMessageDialog(null, "Activity created");
                    }

                    //MODIFY
                    else if(amModifyRadioButton.isSelected())
                    {
                        Activity existing = aDAO.getOneActivity(title);

                        if(existing == null)
                        {
                            JOptionPane.showMessageDialog(null, "Activity not found to modify");
                            return;
                        }

                        aDAO.modifyActivity(
                                existing.getActivityID(),
                                title, date, time, description, notes, status
                        );

                        JOptionPane.showMessageDialog(null, "Activity updated");
                    }

                    //DELETE
                    else if(amDeleteRadioButton.isSelected())
                    {
                        aDAO.deleteActivity(title);
                        JOptionPane.showMessageDialog(null, "Activity deleted");
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

        //CLEAR ACTIVITY BUTTON
        amClearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                amTitleTextBox.setText("");
                amDateTextBox.setText("");
                amTimeTextBox.setText("");
                amDescriptionTextArea.setText("");
                amNotesTextArea.setText("");
                amStatusComboBox.setSelectedIndex(0);
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

        //SEARCH ACTIVITY TO MANAGE BUTTON
        amSaveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(amCreateRadioButton.isSelected() && amTitleTextBox.getText().isEmpty() && amDateTextBox.getText().isEmpty() && amTimeTextBox.getText().isEmpty() && amDescriptionTextArea.getText().isEmpty() && amNotesTextArea.getText().isEmpty() && amStatusComboBox.getSelectedIndex() == -1)
                {
                    JOptionPane.showMessageDialog(null, "Please fill out all activity details");
                }
                else if(amCreateRadioButton.isSelected() && (amTitleTextBox.getText().isEmpty() || amDateTextBox.getText().isEmpty() || amTimeTextBox.getText().isEmpty() || amDescriptionTextArea.getText().isEmpty() || amNotesTextArea.getText().isEmpty() || amStatusComboBox.getSelectedIndex() == -1))
                {
                    JOptionPane.showMessageDialog(null, "Please fill out selected textboxes");
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
        rgLeftTableModel = new DefaultTableModel();
        rgLeftTable.setModel(rgLeftTableModel);

        rgRightTableModel = new DefaultTableModel();
        rgRightTable.setModel(rgRightTableModel);

        //CLEAR INPUT BUTTON
        rgClearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rgUserMedRadioButton.setSelected(true);
                rgYearCheckBox.setSelected(false);
                rgMonthCheckBox.setSelected(false);
                rgYearTextBox.setText("");
                rgMonthTextBox.setText("");
                rgLeftTableModel.setColumnCount(0);
                rgLeftTableModel.setRowCount(0);
                rgRightTableModel.setColumnCount(0);
                rgRightTableModel.setRowCount(0);
            }
        });

        //GENERATE A REPORT BUTTON
        rgGenerateButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //CHECK TYPE SELECTED
                if(!rgUserMedRadioButton.isSelected() && !rgHealthIrregRadioButton.isSelected())
                {
                    JOptionPane.showMessageDialog(null, "Please select a report type");
                    return;
                }

                //GET TYPE
                String type = "";
                if(rgUserMedRadioButton.isSelected())
                {
                    type = "UserMedicationSummary";
                }
                else if(rgHealthIrregRadioButton.isSelected())
                {
                    type = "HealthIrregularitiesSummary";
                }

                //GET YEAR/MONTH
                Integer year = null;
                Integer month = null;

                try
                {
                    if(rgYearCheckBox.isSelected())
                    {
                        if(rgYearTextBox.getText().isEmpty())
                        {
                            JOptionPane.showMessageDialog(null, "Enter a year");
                            return;
                        }
                        year = Integer.parseInt(rgYearTextBox.getText());
                    }

                    if(rgMonthCheckBox.isSelected())
                    {
                        if(rgMonthTextBox.getText().isEmpty())
                        {
                            JOptionPane.showMessageDialog(null, "Enter a month");
                            return;
                        }
                        month = Integer.parseInt(rgMonthTextBox.getText());
                    }
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "Year and Month must be numbers");
                    return;
                }

                //CALL DAO
                ReportDAO rDAO = new ReportDAO();
                List<Report> reports = rDAO.generateReport(type, year, month);

                //CLEAR TABLE
                rgLeftTableModel.setRowCount(0);

                //DISPLAY DATA
                for(Report r : reports)
                {
                    rgLeftTableModel.addRow(new Object[]
                            {
                                    r.getReportID(),
                                    r.getType(),
                                    r.getGeneratedAt(),
                                    r.getContent()
                            });
                }

                if(reports.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "No reports were found");
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


        //CLEAR INPUT BUTTON
        rgsClearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rgsSearchTextBox.setText("");
                rgsListModel.clear();
                rgsTableModel.setRowCount(0);
                rgsTableModel.setColumnCount(0);
            }
        });

        //SEARCH REPORTS BY YEAR BUTTON
        rgsSearchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //CHECK FOR INPUT
                if(rgsSearchTextBox.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter a year");
                }

                //COLLECT YEAR INPUT
                String inputYear = rgsSearchTextBox.getText();

                //CREATE DAO TO ACCESS REPORT OBJECT DATA
                ReportDAO reportDAO = new ReportDAO();







            }
        });

        //DISPLAY REPORT INFORMATION WHEN ITEM FROM LIST IS SELECTED
        rgsResultList.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
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
        managerMenuWindowFrame.setSize(1000, 950);
        managerMenuWindowFrame.setLocationRelativeTo(null);
        managerMenuWindowFrame.setVisible(true);

    }

}
