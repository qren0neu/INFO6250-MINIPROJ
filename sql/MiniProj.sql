CREATE DATABASE  IF NOT EXISTS `mini_proj_web` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mini_proj_web`;
-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: mini_proj_web
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `pkBook` int NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(255) NOT NULL,
  `name` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `publisher` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `instock` int NOT NULL,
  `coverimg` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pkBook`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'1260440230','The Complete Reference','Herbert','McGraw Hill\n','one of the world’s leading programming authors and has written extensively on Java, C, C++, and C#. His books have sold millions of copies worldwide. Herb’s acclaimed books include Java: The Complete Reference, Java: A Beginner\'s Guide, C: The Complete Reference, C++: The Complete Reference and C#: The Complete Reference. \n',9,'/images/book.png'),(3,'1234567890','JAVA: Guide Book','Qi','NEU','A good book.',0,'images/book.png'),(4,'1234567891','JAVA: Guide Book 2','Ren','NEU','A good book.',9,'images/book.png');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow_book`
--

DROP TABLE IF EXISTS `borrow_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `borrow_book` (
  `pkBorrowBook` int NOT NULL AUTO_INCREMENT,
  `fromDate` date NOT NULL,
  `todate` date DEFAULT NULL,
  `fkUser` int NOT NULL,
  `fkBook` int NOT NULL,
  PRIMARY KEY (`pkBorrowBook`),
  KEY `fk_user_idx` (`fkUser`),
  KEY `fk_book_idx` (`fkBook`),
  CONSTRAINT `fk_book` FOREIGN KEY (`fkBook`) REFERENCES `book` (`pkBook`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user` FOREIGN KEY (`fkUser`) REFERENCES `user` (`pkUser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow_book`
--

LOCK TABLES `borrow_book` WRITE;
/*!40000 ALTER TABLE `borrow_book` DISABLE KEYS */;
INSERT INTO `borrow_book` VALUES (4,'2022-10-14','2022-10-14',6,1),(5,'2022-10-14','2022-10-14',6,1),(6,'2022-10-14','2022-10-14',6,3),(7,'2022-10-14','2022-10-15',6,4),(8,'2022-10-14','2022-10-14',6,1),(9,'2022-10-14',NULL,5,3),(10,'2022-10-14',NULL,5,4),(11,'2022-10-14','2022-10-14',5,1),(12,'2022-10-14',NULL,5,1),(14,'2022-10-15',NULL,6,4);
/*!40000 ALTER TABLE `borrow_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `pkUser` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `addr` varchar(255) NOT NULL,
  `city` varchar(45) NOT NULL,
  `state` char(2) NOT NULL,
  `postalcode` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `birthday` date NOT NULL,
  `role` int NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`pkUser`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'Ritchard','Golfman','100 King St East','Toronto','ON','M1A 1B2','123-456-8910','ritchard@gmail.com','male','2022-10-04',0,'ritchard','5b0eb199d99d1076d86d784fd238478a'),(4,'Fang','Chen','100 King St East West','Beijing','ON','M1A 1B2','123-456-8910','cf@gmail.com','male','2022-10-06',1,'fangc1','134375e2d7dbd17e0cb8f4cf15650fc1'),(5,'Chen','Liang','100 King St East West','Toronto','ON','M1A 1B2','123-456-8910','chenliang@gmail.com','male','2022-10-13',1,'cliang00','134375e2d7dbd17e0cb8f4cf15650fc1'),(6,'Qi','Ren','100 King St East West','Toronto','ON','M1A 1B2','123-456-8910','renqi@a.com','male','2022-10-11',1,'renqi198','134375e2d7dbd17e0cb8f4cf15650fc1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-15  0:11:55
