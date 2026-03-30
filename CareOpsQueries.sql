USE CareOps;

-- residents
SELECT * FROM Resident;

-- caregivers
SELECT * FROM Caregiver;

-- managers
SELECT * FROM Manager;
 
-- TOTALS
SELECT COUNT(*) AS TotalResidents
FROM Resident;

SELECT COUNT(*) AS TotalCaregivers
FROM Caregiver;

SELECT COUNT(*) AS TotalAlerts
FROM Alert;

-- all meds
SELECT * FROM MedicationEntry;

-- meds summary
SELECT status, COUNT(*) AS total
FROM MedicationEntry
GROUP BY status;

-- missed meds
SELECT * FROM MedicationEntry
WHERE status = 'Missed';

-- late meds
SELECT * FROM MedicationEntry
WHERE status = 'Late';

-- late or missed meds (for alerts)
SELECT * FROM MedicationEntry
WHERE status IN ('Late', 'Missed');

-- allerts in desc order
SELECT * FROM Alert
ORDER BY createdAt DESC;

-- alerts per resident
SELECT HCN, COUNT(*) AS alertTotal
FROM Alert
GROUP BY HCN;

-- alerts for a single resident
SELECT * FROM Alert
WHERE HCN = 'HCN1000001';

-- all health records
SELECT * FROM HealthRecord
WHERE HCN = 'HCN1000001';

-- latest health record
SELECT * FROM HealthRecord
ORDER BY entryDate DESC, entryTime DESC;

-- residents and assigned caregivers
SELECT r.fName, r.lName, r.HCN,
CONCAT(c.fName, ' ', c.lName) AS caregiverName
FROM Resident r
JOIN Assignment a ON r.HCN = a.HCN
JOIN Caregiver c ON a.workID = c.workID;

-- all reports
SELECT * FROM Report;

-- monthly report
SELECT * FROM Report
WHERE MONTH(generatedAt) = 3 AND YEAR(generatedAt) = 2026;

-- reports by type
SELECT * FROM Report
WHERE type = 'UserMedicationSummary';

-- vital signs
SELECT h.HCN, v.bloodPressure, v.bloodSugar, v.temperature, v.heartRate
FROM HealthRecord h
JOIN VitalSigns v ON h.recordID = v.recordID;

-- activities
SELECT * FROM Activity;

-- activities per resident
SELECT * FROM Activity 
WHERE HCN = 'HCN1000001';

-- Completed activities
SELECT * FROM Activity
WHERE status = 'Completed';

-- insert activity
INSERT INTO Activity (HCN, title, date, time, description, participantNotes, status)
VALUES ('HCN1000001', 'Afternoon Walk', '2026-03-26', '15:00:00',
'Moderate walk for 15 minutes', 'Good performance', 'Completed'); 

-- insert alert
INSERT INTO Alert (HCN, type, message, createdAt)
VALUES ('HCN1000001', 'MedicationLate', 'Medication late', NOW());

-- update med status
UPDATE MedicationEntry
SET status = 'Given'
WHERE medEntryID = 1;

-- update activity status
UPDATE Activity
SET status = 'Completed'
WHERE activityID = 1;
