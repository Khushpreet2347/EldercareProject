package GUIPackage;

import ClassPackage.Manager;
import DAOPackage.ManagerDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LogInWindow
{

    private JPanel loginPanel;
    private JTextField workIDTextBox;
    private JTextField passwordTextBox;
    private JLabel careOpsTitleLabel;
    private JLabel workIDTitleLabel;
    private JLabel passwordTitleLabel;
    private JLabel logoLabel;
    private JButton createAccountButton;
    private JButton logInButton;

    //Declare JFrame
    JFrame loginWindowFrame = new JFrame();

    //Variables
    private String workIDInput = "";
    private String passwordInput = "";

    private String workID = "";
    private String password = "";

    private int loginAttemptCount = 3;

    //Class holding methods for JFrame
    public LogInWindow()
    {

        //GET MANAGER INFO FROM THE DATABASE
        //List scans each Manager object to search for an ID and password that matches user input
        ManagerDAO mDAO = new ManagerDAO();
        List<Manager> managers = mDAO.getAllManagers();











        //GET USER INPUT TO COMPARE TO DATABASE LOGIN INFO
        workIDInput = workIDTextBox.getText();
        password = passwordTextBox.getText();

        //DETECT IF THERE IS USER INPUT
        if(workIDTextBox.equals("") && passwordTextBox.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter your login details");
        }
        else if(workIDTextBox.equals("") || passwordTextBox.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter your login details");
        }
        else
        {
            return;
        }

        //USER LOG IN ATTEMPTS
        logInButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                //Login attempts while checking login info
                while(loginAttemptCount != 0)
                {
                    if(workIDInput.equals("") && passwordInput.equals(""))
                    {
                        //Show Main Menu after login
                        ManagerMenuWindow.openMainMenuWindow();

                        //Dispose of the login screen
                        loginWindowFrame.dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Invalid ID or password, please try again");
                        loginAttemptCount--;
                    }
                }

                if(loginAttemptCount == 0)
                {
                    JOptionPane.showMessageDialog(loginWindowFrame, "Login attempts limit reached, please contact your company Admin to reset your account");
                    loginWindowFrame.dispose();
                    System.exit(0);
                }

            }
        });

        //Action Listener for the Create Account Window
        createAccountButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                CreateManagerAcctWindow.openCreateManagerWindow();
            }
        });

    }

    //Method for creating an object to attach form to
    public static void openLoginWindow()
    {
        LogInWindow loginObj = new LogInWindow();
        loginObj.callForm();
    }

    //Form structure to attach an object
    public void callForm()
    {
        loginWindowFrame.setContentPane(new LogInWindow().loginPanel);
        loginWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginWindowFrame.setTitle("Care Ops | Login");
        loginWindowFrame.setSize(250, 200);
        loginWindowFrame.setLocationRelativeTo(null);
        loginWindowFrame.setVisible(true);
    }

}
