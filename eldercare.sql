CREATE DATABASE IF NOT EXISTS CareOps;
USE CareOps;

CREATE TABLE Manager (
    workID CHAR(7) PRIMARY KEY,
    fName VARCHAR(25) NOT NULL,
    lName VARCHAR(25) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phoneNo VARCHAR(15) NOT NULL,
    passwordHash VARCHAR(255) NOT NULL
);

CREATE TABLE Resident (
    HCN CHAR(10) PRIMARY KEY,
    fName VARCHAR(25) NOT NULL,
    lName VARCHAR(25) NOT NULL,
    dateOfBirth DATE NOT NULL,
    email VARCHAR(50) NOT NULL,
    phoneNo VARCHAR(15) NOT NULL,
    profileImage BLOB,
    eContact_fName VARCHAR(25),
    eContact_phoneNo VARCHAR(50)
);

CREATE TABLE Caregiver (
    workID CHAR(7) PRIMARY KEY,
    fName VARCHAR(25) NOT NULL,
    lName VARCHAR(25) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phoneNo VARCHAR(15) NOT NULL
);

CREATE TABLE Assignment (
    assignmentID CHAR(7) PRIMARY KEY,
    HCN CHAR(10),
    workID CHAR(7),
    assignedDate DATE NOT NULL,
    FOREIGN KEY (HCN) REFERENCES Resident(HCN),
    FOREIGN KEY (workID) REFERENCES Caregiver(workID)
);

CREATE TABLE HealthRecord (
    recordID INT PRIMARY KEY AUTO_INCREMENT,
    HCN CHAR(10),
    entryDate VARCHAR(25) NOT NULL,
    entryTime VARCHAR(50) NOT NULL,
    note MEDIUMTEXT,
    FOREIGN KEY (HCN) REFERENCES Resident(HCN)
);

CREATE TABLE VitalSigns (
    recordID INT PRIMARY KEY,
    bloodPressure INT NOT NULL,
    bloodSugar INT NOT NULL,
    temperature DECIMAL(4,1) NOT NULL,
    heartRate INT NOT NULL,
    FOREIGN KEY (recordID) REFERENCES HealthRecord(recordID)
);

CREATE TABLE MedicationEntry (
    medEntryID INT PRIMARY KEY AUTO_INCREMENT,
    recordID INT,
    mName VARCHAR(25) NOT NULL,
    dose DOUBLE NOT NULL,
    status ENUM('Given', 'Late', 'Missed') NOT NULL,
    note MEDIUMTEXT,
    FOREIGN KEY (recordID) REFERENCES HealthRecord(recordID)
);

CREATE TABLE ConditionRecord (
    recordID INT PRIMARY KEY,
    mood INT NOT NULL,
    painLevel VARCHAR(25) NOT NULL,
    sleepQuality INT NOT NULL,
    FOREIGN KEY (recordID) REFERENCES HealthRecord(recordID)
);

CREATE TABLE TrendAnalyzer (
    declineThreshold DOUBLE,
    windowDays INT
);

CREATE TABLE ReportGenerator (
    month INT,
    year INT
);

CREATE TABLE Report (
    reportID INT PRIMARY KEY AUTO_INCREMENT,
    type ENUM('UserMedicationSummary', 'HealthIrregularitiesSummary') NOT NULL,
    generatedAt DATE NOT NULL,
    content MEDIUMTEXT NOT NULL
);