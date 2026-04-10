CREATE DATABASE IF NOT EXISTS CareOps;
USE CareOps;

CREATE TABLE Manager (
    workID CHAR(7) PRIMARY KEY,
    fName VARCHAR(25) NOT NULL,
    lName VARCHAR(25) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    phoneNo VARCHAR(15) NOT NULL,
    passwordHash VARCHAR(255) NOT NULL
);

CREATE TABLE Resident (
    HCN CHAR(10) PRIMARY KEY,
    fName VARCHAR(25) NOT NULL,
    lName VARCHAR(25) NOT NULL,
    dateOfBirth DATE NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    phoneNo VARCHAR(15) NOT NULL,
    profileImage BLOB,
    eContact_fName VARCHAR(25),
    eContact_phoneNo VARCHAR(15)
);

CREATE TABLE Caregiver (
    workID CHAR(7) PRIMARY KEY,
    fName VARCHAR(25) NOT NULL,
    lName VARCHAR(25) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    phoneNo VARCHAR(15) NOT NULL,
    profileImage BLOB
);

CREATE TABLE Assignment (
    assignmentID CHAR(7) PRIMARY KEY,
    HCN CHAR(10) NOT NULL,
    workID CHAR(7) NOT NULL,
    assignedDate DATE NOT NULL,
    FOREIGN KEY (HCN) REFERENCES Resident(HCN) ON DELETE CASCADE,
    FOREIGN KEY (workID) REFERENCES Caregiver(workID) ON DELETE CASCADE
);

CREATE TABLE HealthRecord (
    recordID INT PRIMARY KEY AUTO_INCREMENT,
    HCN CHAR(10) NOT NULL,
    entryDate DATE NOT NULL,
    entryTime TIME(6) NOT NULL,
    note MEDIUMTEXT,
    FOREIGN KEY (HCN) REFERENCES Resident(HCN) ON DELETE CASCADE
    
);

CREATE TABLE VitalSigns (
    recordID INT PRIMARY KEY,
    systolic INT NOT NULL CHECK (systolic BETWEEN 50 AND 250),
    diastolic INT NOT NULL CHECK (diastolic BETWEEN 30 AND 150),
    bloodSugar INT NOT NULL CHECK (bloodSugar > 0),
    temperature DECIMAL(4,1) NOT NULL CHECK (temperature > 0),
    heartRate INT NOT NULL CHECK (heartRate > 0),
    FOREIGN KEY (recordID) REFERENCES HealthRecord(recordID) ON DELETE CASCADE
);

CREATE TABLE MedicationEntry (
    medEntryID INT PRIMARY KEY AUTO_INCREMENT,
    recordID INT NOT NULL,
    mName VARCHAR(25) NOT NULL,
    dose DOUBLE NOT NULL CHECK (dose > 0),
    administeredTime TIME NOT NULL, 
    status ENUM('Given', 'Late', 'Missed') NOT NULL,
    note MEDIUMTEXT,
    FOREIGN KEY (recordID) REFERENCES HealthRecord(recordID) ON DELETE CASCADE
);

CREATE TABLE ConditionRecord (
    recordID INT PRIMARY KEY,
    mood INT NOT NULL CHECK (mood BETWEEN 1 AND 10),
    painLevel INT NOT NULL CHECK (painLevel BETWEEN 1 AND 10),
    sleepQuality INT NOT NULL CHECK (sleepQuality BETWEEN 1 AND 10),
    FOREIGN KEY (recordID) REFERENCES HealthRecord(recordID) ON DELETE CASCADE
);



CREATE TABLE Report (
    reportID INT PRIMARY KEY AUTO_INCREMENT,
    type ENUM('UserMedicationSummary', 'HealthIrregularitiesSummary') NOT NULL,
    content MEDIUMTEXT NOT NULL
);

CREATE TABLE Alert (
    alertID INT PRIMARY KEY AUTO_INCREMENT,
    HCN CHAR(10) NOT NULL,
    type ENUM('MedicationLate', 'MedicationMissed', 'HealthDecline') NOT NULL,
    message VARCHAR(255),
    createdAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (HCN) REFERENCES Resident(HCN) ON DELETE CASCADE
);

CREATE TABLE Activity (
    activityID INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    date DATE NOT NULL,
    time TIME NOT NULL,
    description TEXT,
    participantNotes TEXT,
    status ENUM('Planned', 'Ongoing', 'Completed', 'Cancelled') NOT NULL
);

-- INDEXES WERE CREATED TO ENSURE FASTER SEARCH RESULTS

CREATE INDEX idx_resident_name ON Resident(fName, lName);
CREATE INDEX idx_resident_hcn ON Resident(HCN);

CREATE INDEX idx_caregiver_name ON Caregiver(fName, lName);
CREATE INDEX idx_caregiver_workid ON Caregiver(workID);

CREATE INDEX idx_health_date ON HealthRecord(entryDate);
CREATE INDEX idx_health_hcn ON HealthRecord(HCN);

CREATE INDEX idx_med_name ON MedicationEntry(mName);
CREATE INDEX idx_med_record ON MedicationEntry(recordID);

CREATE INDEX idx_assignment_hcn ON Assignment(HCN);
CREATE INDEX idx_assignment_workid ON Assignment(workID);

CREATE INDEX idx_alert_hcn ON Alert(HCN);

CREATE INDEX idx_vital_record ON VitalSigns(recordID);

INSERT INTO Manager VALUES
('M000001', 'Sarah', 'Lee', 'sarah.lee@careops.com', '6045551200', 'hashed_password_1');
INSERT INTO Caregiver VALUES
('C000001', 'Anna', 'Lopez', 'anna.lopez@careops.com', '6045553000', NULL),
('C000002', 'Michael', 'Nguyen', 'michael.nguyen@careops.com', '6045553001', NULL),
('C000003', 'Priya', 'Patel', 'priya.patel@careops.com', '6045553002', NULL);
INSERT INTO Resident VALUES
('HCN1000001', 'John', 'Peterson', '1942-05-10', 'john.peterson@email.com', '6045552000', NULL, 'Emily', '6045559001'),
('HCN1000002', 'Mary', 'Williams', '1938-09-22', 'mary.williams@email.com', '6045552001', NULL, 'David', '6045559002'),
('HCN1000003', 'Robert', 'Brown', '1945-03-18', 'robert.brown@email.com', '6045552002', NULL, 'Linda', '6045559003'),
('HCN1000004', 'Alice', 'Johnson', '1940-12-02', 'alice.johnson@email.com', '6045552003', NULL, 'Kevin', '6045559004');
