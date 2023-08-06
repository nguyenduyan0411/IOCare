create database IOCare;
drop database IOCare
-- 1.Học kỳ
create table IOCare.Semesters (
   SemesterId 					varchar(5),
   SemesterName 				varchar(50),
   StartTime 					date,
   EndTime 					date,
   primary key (SemesterId)
);

-- 2.Droplist Lý do vắng học
create table IOCare.ReasonAbsenteeisms (
  ReasonAbsenteeismId 		int auto_increment,
  ReasonAbsenteeismName 		varchar(50),
  primary key (ReasonAbsenteeismId)
);

-- 3.Droplist Lý do chiến dịch học phí
create table IOCare.ReasonFees (
  ReasonFeeId 				int auto_increment,
  ReasonFeeName 				varchar(50),
  primary key (ReasonFeeId)
);

-- 4.Chiến dịch
create table IOCare.Campains (
  CampaignId 					varchar(5),
  CampaignName 				varchar(50),
  SubjectId 					varchar(10),
  StudyingStatus 				varchar(10),
  TotalFee 					float,
  SemesterId 					varchar(5),
  ReasonAbsenteeismId 		int,
  ReasonFeeId 				int,
  FOREIGN KEY (SemesterId) REFERENCES IOCare.Semesters(SemesterId),
  FOREIGN KEY (ReasonAbsenteeismId) REFERENCES IOCare.ReasonAbsenteeisms(ReasonAbsenteeismId),
  FOREIGN KEY (ReasonFeeId) REFERENCES IOCare.ReasonFees(ReasonFeeId),
  primary key (CampaignId)
);

-- 5.Thuộc loại đối tượng
create table IOCare.ObjClassification (
  ObjClassificationId 		int auto_increment,
  ObjClassificationDes 		varchar(50),
  primary key (ObjClassificationId)
);

-- 6.Phân loại rủi ro
create table IOCare.RiskClassification (
  RiskClassificationId 		int auto_increment,
  RiskClassificationDes 		varchar(50),
  primary key (RiskClassificationId)
);

-- 7.Diễn giải chi tiết
create table IOCare.DescriptionDetails (
  DescriptionDetailsId int,
  DescriptionDetailsDes varchar(50),
  primary key (DescriptionDetailsId)
);
-- 11. Employees
create table IOCare.Employees (
  EmployeeId 					varchar(50),
  Password 					varchar(30),
  EmployeeName 				varchar(30),
  EmpoyeeEmail 				varchar(30)			unique,
  EmployeePhone 				varchar(10),
  primary key (EmployeeId)
);

-- 8.Import file excel
create table IOCare.ImportedData (
  ImportedId 					int auto_increment,
  SemesterId 					varchar(5),
  CampaignId 					varchar(5),
  ImportedFileName 			varchar(50),
  ImportedDate				date,
  EmployeeId 					varchar(50),
  FOREIGN KEY (SemesterId) REFERENCES IOCare.Semesters(SemesterId),
  FOREIGN KEY (EmployeeId) REFERENCES IOCare.Employees(EmployeeId),
  primary key (ImportedId)
);

-- 9. Students
create table IOCare.Students (
  StudentId 					varchar(10),
  SemesterId				 	varchar(5),
  Major 						varchar(50),
  EmployeeId 					varchar(50),
  TakeCareTime 				date,
  Reason 						varchar(50),
  Aspirations 				varchar(100),
  ObjClassificationId 		int,
  RiskClassificationId 			int,
  DescriptionDetailsId 			int,
  ImportedId 					int,
  FOREIGN KEY (SemesterId) REFERENCES IOCare.Semesters(SemesterId),
  FOREIGN KEY (EmployeeId) REFERENCES IOCare.Employees(EmployeeId),
  FOREIGN KEY (ObjClassificationId) REFERENCES IOCare.ObjClassification(ObjClassificationId),
  FOREIGN KEY (RiskClassificationId) REFERENCES IOCare.RiskClassification(RiskClassificationId),
  FOREIGN KEY (DescriptionDetailsId) REFERENCES IOCare.DescriptionDetails(DescriptionDetailsId),
  FOREIGN KEY (ImportedId) REFERENCES IOCare.ImportedData(ImportedId),
  primary key (StudentId)
);

-- 10. Join Campains
create table IOCare.JoinCampains (
  JoinCampainsId 				int auto_increment,
  CampaignId 					varchar(5),
  StudentId 					varchar(10),
  FOREIGN KEY (CampaignId) REFERENCES IOCare.Campains(CampaignId),
  FOREIGN KEY (StudentId) REFERENCES IOCare.Students(StudentId),
  primary key (JoinCampainsId)
);



-- 12.Authorities
create table IOCare.Authorities (
  AuthorityId 				int auto_increment,
  EmployeeId 					varchar(50),			
  RoleId 						varchar(10),
  FOREIGN KEY (EmployeeId) REFERENCES IOCare.Employees(EmployeeId),
  FOREIGN KEY (RoleId) REFERENCES IOCare.Roles(RoleId),
  primary key (AuthorityId)
);

-- 13.Roles
create table IOCare.Roles (
  RoleId 						varchar(10),
  RoleName 					varchar(50),
  primary key (RoleId)
);

