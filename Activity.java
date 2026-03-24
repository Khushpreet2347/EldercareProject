package careops;

import java.util.Date;

public class Activity {

	//variables
	private int activityID; //PK
	private String type; //Medication, alert, login...
	private String description;
	private Date timestamp;
	private String workID; //FK - caregivers or managers
	private String HCN; // FK from resident
	
	//default constructor
	
	public Activity() {
		this.activityID = 0;
		this.type = "";
		this.description = "";
		this.timestamp = null;
		this.workID = "";
		this.HCN = "";
	}
	
	//parameterized
	public Activity(int activityID, String type, String description, Date timestamp, String workID, String HCN) {
		this.activityID = activityID;
		this.type = type;
		this.description = description;
		this.timestamp = timestamp;
		this.workID = workID;
		this.HCN = HCN;

	}
	
	//setters
	
	public void setActivityID(int activityID) {
		this.activityID = activityID;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public void setWorkID(String workID) {
		this.workID = workID;
	}
	
	public void setHCN(String HCN) {
		this.HCN = HCN;
	}
	
	
	//method to log actions
	
	public void logActivity() {
		System.out.println("Activity type: " + type + ", for Resident (HCN: " + HCN + "), by Employee (work ID: " + workID + ") at " + timestamp + ".");
		
	}
	
	

	
}
