package careops;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;


public class MedicationEntry {
	
	// variables
	private int recordID; //FK from HealthRecord
	private int medEntryID; //PK
	private String mName; //name of medication
	private double dose;
	private String status; //given, late, missed
	private String note;
	private LocalTime time; //actual time admin by the caregiver
	private String workID; // who gave the meds
	private String HCN; // which resident the meds are for
	//constructors

	//default
	public MedicationEntry() {}

	//parameterized 
	public MedicationEntry(int recordID, int medEntryID, String mName, double dose, String status, String note, LocalTime time) {

	this.recordID = recordID;
	this.medEntryID = medEntryID;
	this.mName = mName;
	this.dose = dose;
	this.status = status;
	this.note = note;
	this.time = time;
	this.workID = workID;
	this.HCN = HCN;
	}

	//method to update med status

	public void updateStatus(LocalTime expectedTime) {

	long minutes = Duration.between(expectedTime, time).toMinutes();

	if (minutes <= 60) {
	status = "Given";
	} else if (minutes <= 120) {
	status = "Late";
	} else {
	status = "Missed";
	}
	
	//log activity
	
	Activity activity = new Activity();
	activity.setType("Medication");
	activity.setDescription("Medication " + status + " for " + mName);
	activity.setTimestamp(new Date());
	activity.setWorkID(this.workID);
	activity.setHCN(this.HCN);
	
	activity.logActivity(); //we could save to the DB to store the activity if needed
	
	
	
	}


}
