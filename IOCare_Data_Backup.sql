-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (arm64)
--
-- Host: localhost    Database: IOCare
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Aspirations`
--

DROP TABLE IF EXISTS `Aspirations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Aspirations` (
  `AspirationId` int NOT NULL AUTO_INCREMENT,
  `AspirationDes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`AspirationId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Aspirations`
--

LOCK TABLES `Aspirations` WRITE;
/*!40000 ALTER TABLE `Aspirations` DISABLE KEYS */;
INSERT INTO `Aspirations` VALUES (1,'Chắc chắn đóng HP'),(2,'Cân nhắc - đang suy nghĩ về HP'),(3,'Không đóng HP -THO'),(4,'Sẽ bảo lưu'),(5,'Không liên lạc được'),(6,'Đã đóng học phí'),(7,'Huỷ bảo lưu'),(8,'Gia hạn Học phí'),(9,'Khác');
/*!40000 ALTER TABLE `Aspirations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Authorities`
--

DROP TABLE IF EXISTS `Authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Authorities` (
  `AuthorityId` int NOT NULL AUTO_INCREMENT,
  `EmployeeId` varchar(50) DEFAULT NULL,
  `RoleId` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`AuthorityId`),
  KEY `EmployeeId` (`EmployeeId`),
  KEY `RoleId` (`RoleId`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`EmployeeId`) REFERENCES `Employees` (`EmployeeId`),
  CONSTRAINT `authorities_ibfk_2` FOREIGN KEY (`RoleId`) REFERENCES `Roles` (`RoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Authorities`
--

LOCK TABLES `Authorities` WRITE;
/*!40000 ALTER TABLE `Authorities` DISABLE KEYS */;
INSERT INTO `Authorities` VALUES (4,'phuc33','1'),(7,'phuc55','3'),(8,'phuc44','3'),(9,'phuc66','2');
/*!40000 ALTER TABLE `Authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Campaigns`
--

DROP TABLE IF EXISTS `Campaigns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Campaigns` (
  `CampaignId` varchar(5) NOT NULL,
  `CampaignName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CampaignId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Campaigns`
--

LOCK TABLES `Campaigns` WRITE;
/*!40000 ALTER TABLE `Campaigns` DISABLE KEYS */;
INSERT INTO `Campaigns` VALUES ('CSHP','Cham soc hoc phi'),('CSVH','Cham soc vang hoc');
/*!40000 ALTER TABLE `Campaigns` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employees`
--

DROP TABLE IF EXISTS `Employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employees` (
  `EmployeeId` varchar(50) NOT NULL,
  `EmployeePassword` varchar(255) DEFAULT NULL,
  `EmployeeName` varchar(30) DEFAULT NULL,
  `EmployeeEmail` varchar(30) DEFAULT NULL,
  `EmployeePhone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`EmployeeId`),
  UNIQUE KEY `EmployeeEmail` (`EmployeeEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employees`
--

LOCK TABLES `Employees` WRITE;
/*!40000 ALTER TABLE `Employees` DISABLE KEYS */;
INSERT INTO `Employees` VALUES ('phuc22','1234','Pham Hoang Phuc','phuc22@gmail.com','0933081812'),('phuc33','$2a$10$zcICvt2wYQa0mkIGxlH3kue2wu09Qbs8mN/wcuvyg3AVt4GVIdBTq','Phạm Hoàng Phúc','phuc33@gmail.com','0933081812'),('phuc44','$2a$10$lrsz3juO0Z26P4ujEh09rujahUJFhhSM.m9OjQbs3QmnvwbQtA0/a','Phạm Hoàng Phúc','phuc44@gmail.com','0933081812'),('phuc55','$2a$10$ssYjIjgiowGYr5bALLOXs.d7E/dVyXZXIot6LkXF/8z4vXwrEA39u','Phạm Hoàng Phúc','phuc55@gmail.com','0933081812'),('phuc66','$2a$10$J/ey68HhWlt/05fIdVwgW.UxImumV7..v8nY761aE9ollkldRZwZ6','Phạm Hoàng Phúc 6','phuc66@gmail.com','0933081812');
/*!40000 ALTER TABLE `Employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ImportedData`
--

DROP TABLE IF EXISTS `ImportedData`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ImportedData` (
  `ImportedFileName` varchar(50) NOT NULL,
  `SemesterId` varchar(5) DEFAULT NULL,
  `CampaignId` varchar(5) DEFAULT NULL,
  `ImportedDate` date DEFAULT NULL,
  `EmployeeId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ImportedFileName`),
  KEY `CampaignId` (`CampaignId`),
  KEY `SemesterId` (`SemesterId`),
  KEY `EmployeeId` (`EmployeeId`),
  CONSTRAINT `importeddata_ibfk_1` FOREIGN KEY (`CampaignId`) REFERENCES `Campaigns` (`CampaignId`),
  CONSTRAINT `importeddata_ibfk_2` FOREIGN KEY (`SemesterId`) REFERENCES `Semesters` (`SemesterId`),
  CONSTRAINT `importeddata_ibfk_3` FOREIGN KEY (`EmployeeId`) REFERENCES `Employees` (`EmployeeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ImportedData`
--

LOCK TABLES `ImportedData` WRITE;
/*!40000 ALTER TABLE `ImportedData` DISABLE KEYS */;
INSERT INTO `ImportedData` VALUES ('',NULL,NULL,'2023-06-19',NULL);
/*!40000 ALTER TABLE `ImportedData` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `JoinCampaigns`
--

DROP TABLE IF EXISTS `JoinCampaigns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `JoinCampaigns` (
  `JoinCampaignsId` int NOT NULL AUTO_INCREMENT,
  `CampaignId` varchar(5) DEFAULT NULL,
  `StudentId` varchar(10) DEFAULT NULL,
  `StudyingStatusId` varchar(10) DEFAULT NULL,
  `SemesterId` varchar(5) DEFAULT NULL,
  `ReasonAbsenteeismId` int DEFAULT NULL,
  `ReasonFeeId` int DEFAULT NULL,
  PRIMARY KEY (`JoinCampaignsId`),
  UNIQUE KEY `StudentId` (`StudentId`),
  KEY `CampaignId` (`CampaignId`),
  KEY `StudyingStatusId` (`StudyingStatusId`),
  KEY `SemesterId` (`SemesterId`),
  KEY `ReasonAbsenteeismId` (`ReasonAbsenteeismId`),
  KEY `ReasonFeeId` (`ReasonFeeId`),
  CONSTRAINT `joincampaigns_ibfk_1` FOREIGN KEY (`CampaignId`) REFERENCES `Campaigns` (`CampaignId`),
  CONSTRAINT `joincampaigns_ibfk_2` FOREIGN KEY (`StudentId`) REFERENCES `Students` (`StudentId`),
  CONSTRAINT `joincampaigns_ibfk_3` FOREIGN KEY (`StudyingStatusId`) REFERENCES `StudyingStatus` (`StudyingStatusId`),
  CONSTRAINT `joincampaigns_ibfk_4` FOREIGN KEY (`SemesterId`) REFERENCES `Semesters` (`SemesterId`),
  CONSTRAINT `joincampaigns_ibfk_5` FOREIGN KEY (`ReasonAbsenteeismId`) REFERENCES `ReasonAbsenteeisms` (`ReasonAbsenteeismId`),
  CONSTRAINT `joincampaigns_ibfk_6` FOREIGN KEY (`ReasonFeeId`) REFERENCES `ReasonFees` (`ReasonFeeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `JoinCampaigns`
--

LOCK TABLES `JoinCampaigns` WRITE;
/*!40000 ALTER TABLE `JoinCampaigns` DISABLE KEYS */;
/*!40000 ALTER TABLE `JoinCampaigns` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ObjClassification`
--

DROP TABLE IF EXISTS `ObjClassification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ObjClassification` (
  `ObjClassificationId` int NOT NULL AUTO_INCREMENT,
  `ObjClassificationDes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ObjClassificationId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ObjClassification`
--

LOCK TABLES `ObjClassification` WRITE;
/*!40000 ALTER TABLE `ObjClassification` DISABLE KEYS */;
INSERT INTO `ObjClassification` VALUES (1,'Cần chăm sóc lại'),(2,'Không cần chăm sóc tiếp');
/*!40000 ALTER TABLE `ObjClassification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ReasonAbsenteeisms`
--

DROP TABLE IF EXISTS `ReasonAbsenteeisms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ReasonAbsenteeisms` (
  `ReasonAbsenteeismId` int NOT NULL AUTO_INCREMENT,
  `ReasonAbsenteeismName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ReasonAbsenteeismId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ReasonAbsenteeisms`
--

LOCK TABLES `ReasonAbsenteeisms` WRITE;
/*!40000 ALTER TABLE `ReasonAbsenteeisms` DISABLE KEYS */;
INSERT INTO `ReasonAbsenteeisms` VALUES (1,'Sai/Không có SDT'),(2,'Thuê bao/Không nghe máy'),(3,'Có vấn đề sức khỏe'),(4,'Không đủ năng lực học tập/không theo kịp chương trình'),(5,'Lười học/chán học'),(6,'Nhầm/Quên/Không biết lịch học'),(7,'Ngủ quên'),(8,'Đi trễ'),(9,'Ca học không phù hợp/vướng lịch làm thêm'),(10,'Nghỉ học luôn để đi làm'),(11,'Khó khăn kinh tế'),(12,'Không có thiết bị học/Laptop hư'),(13,'Bận việc cá nhân/việc gia đình/về quê'),(14,'Đợi chuyển ngành'),(15,'Đóng học phí trễ được add lớp trễ'),(16,'Đi NVQS'),(17,'Có ý định thi đại học/Chuyển trường khác'),(18,'Có ý định du học'),(19,'Đang học cái khác song song'),(20,'Nhà xa/chuyển nơi sống'),(21,'Chưa rõ nguyên nhân(SV không chia sẻ/khó nói)'),(22,'Mất định hướng tương lai'),(23,'Không hài lòng cơ sở vật chất'),(24,'Khác');
/*!40000 ALTER TABLE `ReasonAbsenteeisms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ReasonFees`
--

DROP TABLE IF EXISTS `ReasonFees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ReasonFees` (
  `ReasonFeeId` int NOT NULL AUTO_INCREMENT,
  `ReasonFeeName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ReasonFeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ReasonFees`
--

LOCK TABLES `ReasonFees` WRITE;
/*!40000 ALTER TABLE `ReasonFees` DISABLE KEYS */;
INSERT INTO `ReasonFees` VALUES (1,'Có vấn đề sức khỏe'),(2,'Bận việc cá nhân - gia đình'),(3,'Khó khăn tài chính'),(4,'Nghỉ học đi làm'),(5,'Không có thiết bị học'),(6,'Không liên lạc được'),(7,'Trả nợ môn'),(8,'Đợi chuyển ngành'),(9,'Đi du học'),(10,'Nghỉ đi học đại học'),(11,'Đi NVQS'),(12,'Nghỉ học 1 time để định hướng cuộc đời'),(13,'Khác'),(14,'Không đủ dk HDI kỳ 7');
/*!40000 ALTER TABLE `ReasonFees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RiskClassification`
--

DROP TABLE IF EXISTS `RiskClassification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `RiskClassification` (
  `RiskClassificationId` int NOT NULL AUTO_INCREMENT,
  `RiskClassificationDes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`RiskClassificationId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RiskClassification`
--

LOCK TABLES `RiskClassification` WRITE;
/*!40000 ALTER TABLE `RiskClassification` DISABLE KEYS */;
INSERT INTO `RiskClassification` VALUES (1,'Nguy cơ thấp'),(2,'Nguy cơ cao'),(3,'Nguy cơ rất cao'),(4,'Chắc chắn THO');
/*!40000 ALTER TABLE `RiskClassification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Roles`
--

DROP TABLE IF EXISTS `Roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Roles` (
  `RoleId` varchar(10) NOT NULL,
  `RoleName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Roles`
--

LOCK TABLES `Roles` WRITE;
/*!40000 ALTER TABLE `Roles` DISABLE KEYS */;
INSERT INTO `Roles` VALUES ('1','ADMIN'),('2','USER1'),('3','USER2');
/*!40000 ALTER TABLE `Roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Semesters`
--

DROP TABLE IF EXISTS `Semesters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Semesters` (
  `SemesterId` varchar(5) NOT NULL,
  `SemesterName` varchar(50) DEFAULT NULL,
  `StartTime` date DEFAULT NULL,
  `EndTime` date DEFAULT NULL,
  PRIMARY KEY (`SemesterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Semesters`
--

LOCK TABLES `Semesters` WRITE;
/*!40000 ALTER TABLE `Semesters` DISABLE KEYS */;
INSERT INTO `Semesters` VALUES ('FA23','Fall2023','2023-06-17','2023-06-27');
/*!40000 ALTER TABLE `Semesters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Students`
--

DROP TABLE IF EXISTS `Students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Students` (
  `StudentId` varchar(10) NOT NULL,
  `SemesterId` varchar(5) DEFAULT NULL,
  `SubjectId` longtext,
  `TotalFee` double DEFAULT NULL,
  `CampaignId` varchar(5) DEFAULT NULL,
  `Major` varchar(50) DEFAULT NULL,
  `EmployeeId` varchar(50) DEFAULT NULL,
  `TakeCareTime` date DEFAULT NULL,
  `Reason` varchar(50) DEFAULT NULL,
  `AspirationId` int DEFAULT NULL,
  `ObjClassificationId` int DEFAULT NULL,
  `RiskClassificationId` int DEFAULT NULL,
  `DescriptionDetailsId` longtext,
  `ImportedFileName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`StudentId`),
  KEY `SemesterId` (`SemesterId`),
  KEY `EmployeeId` (`EmployeeId`),
  KEY `AspirationId` (`AspirationId`),
  KEY `ObjClassificationId` (`ObjClassificationId`),
  KEY `RiskClassificationId` (`RiskClassificationId`),
  KEY `ImportedFileName` (`ImportedFileName`),
  CONSTRAINT `students_ibfk_1` FOREIGN KEY (`SemesterId`) REFERENCES `Semesters` (`SemesterId`),
  CONSTRAINT `students_ibfk_2` FOREIGN KEY (`EmployeeId`) REFERENCES `Employees` (`EmployeeId`),
  CONSTRAINT `students_ibfk_3` FOREIGN KEY (`AspirationId`) REFERENCES `Aspirations` (`AspirationId`),
  CONSTRAINT `students_ibfk_4` FOREIGN KEY (`ObjClassificationId`) REFERENCES `ObjClassification` (`ObjClassificationId`),
  CONSTRAINT `students_ibfk_5` FOREIGN KEY (`RiskClassificationId`) REFERENCES `RiskClassification` (`RiskClassificationId`),
  CONSTRAINT `students_ibfk_6` FOREIGN KEY (`ImportedFileName`) REFERENCES `ImportedData` (`ImportedFileName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Students`
--

LOCK TABLES `Students` WRITE;
/*!40000 ALTER TABLE `Students` DISABLE KEYS */;
/*!40000 ALTER TABLE `Students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StudyingStatus`
--

DROP TABLE IF EXISTS `StudyingStatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `StudyingStatus` (
  `StudyingStatusId` varchar(10) NOT NULL,
  `StudyingStatusName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`StudyingStatusId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StudyingStatus`
--

LOCK TABLES `StudyingStatus` WRITE;
/*!40000 ALTER TABLE `StudyingStatus` DISABLE KEYS */;
INSERT INTO `StudyingStatus` VALUES ('HDI','Học đi'),('HL','Học lại'),('TN','Tốt nghiệp');
/*!40000 ALTER TABLE `StudyingStatus` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-19 15:02:55
