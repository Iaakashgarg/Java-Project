-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.8-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema gasagency
--

CREATE DATABASE IF NOT EXISTS gasagency;
USE gasagency;

--
-- Definition of table `billinfo`
--

DROP TABLE IF EXISTS `billinfo`;
CREATE TABLE `billinfo` (
  `billid` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerID` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `cylinderno` varchar(20) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `billdate` datetime DEFAULT NULL,
  `cylinderid` int(11) DEFAULT NULL,
  PRIMARY KEY (`billid`),
  KEY `CustomerID` (`CustomerID`),
  KEY `FK_billinfo_2` (`cylinderid`),
  CONSTRAINT `FK_billinfo_2` FOREIGN KEY (`cylinderid`) REFERENCES `cylinderinfo` (`CylinderID`),
  CONSTRAINT `billinfo_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customerinfo` (`CustomerID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `billinfo`
--

/*!40000 ALTER TABLE `billinfo` DISABLE KEYS */;
INSERT INTO `billinfo` (`billid`,`CustomerID`,`price`,`cylinderno`,`quantity`,`billdate`,`cylinderid`) VALUES 
 (1,1,250,'1234567',1,'2014-09-24 10:34:09',2),
 (2,1,300,'123453',1,'2014-09-24 10:34:24',3);
/*!40000 ALTER TABLE `billinfo` ENABLE KEYS */;


--
-- Definition of table `customerinfo`
--

DROP TABLE IF EXISTS `customerinfo`;
CREATE TABLE `customerinfo` (
  `CustomerID` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerName` varchar(100) DEFAULT NULL,
  `ColonyName` varchar(100) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `ContactNo` varchar(20) DEFAULT NULL,
  `NoOfCylinder` int(11) DEFAULT NULL,
  `TypeID` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CustomerID`),
  KEY `TypeID` (`TypeID`),
  CONSTRAINT `customerinfo_ibfk_1` FOREIGN KEY (`TypeID`) REFERENCES `cylindertype` (`TypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customerinfo`
--

/*!40000 ALTER TABLE `customerinfo` DISABLE KEYS */;
INSERT INTO `customerinfo` (`CustomerID`,`CustomerName`,`ColonyName`,`Address`,`ContactNo`,`NoOfCylinder`,`TypeID`) VALUES 
 (1,'Rajan','Model Town','Model Town Yamuna Nagar','9896985685',2,'DC'),
 (2,'Rakesh Malhotra','Model Colony','Model Colony Yamuna Nagar','9896984585',4,'DC');
/*!40000 ALTER TABLE `customerinfo` ENABLE KEYS */;


--
-- Definition of table `cylinderinfo`
--

DROP TABLE IF EXISTS `cylinderinfo`;
CREATE TABLE `cylinderinfo` (
  `CylinderID` int(11) NOT NULL AUTO_INCREMENT,
  `CompanyName` varchar(100) DEFAULT NULL,
  `FilledQty` int(11) DEFAULT NULL,
  `TypeID` varchar(20) DEFAULT NULL,
  `Price` float DEFAULT NULL,
  `EmptyQty` int(11) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  PRIMARY KEY (`CylinderID`),
  KEY `TypeID` (`TypeID`),
  CONSTRAINT `cylinderinfo_ibfk_1` FOREIGN KEY (`TypeID`) REFERENCES `cylindertype` (`TypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cylinderinfo`
--

/*!40000 ALTER TABLE `cylinderinfo` DISABLE KEYS */;
INSERT INTO `cylinderinfo` (`CylinderID`,`CompanyName`,`FilledQty`,`TypeID`,`Price`,`EmptyQty`,`weight`) VALUES 
 (1,'Indane',15,'CM',350,50,19.5),
 (2,'Indane',100,'DC',250,50,14.5),
 (3,'Reliance',25,'DC',300,10,17.5),
 (4,'Reliance',150,'CM',450,50,20.5);
/*!40000 ALTER TABLE `cylinderinfo` ENABLE KEYS */;


--
-- Definition of table `cylinderstock`
--

DROP TABLE IF EXISTS `cylinderstock`;
CREATE TABLE `cylinderstock` (
  `stockid` int(11) NOT NULL AUTO_INCREMENT,
  `cylinderid` int(11) DEFAULT NULL,
  `stocktype` enum('IN','OUT') DEFAULT NULL,
  `CylinderStatus` enum('Fill','Empty') DEFAULT NULL,
  `StockDate` datetime DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`stockid`),
  KEY `cylinderid` (`cylinderid`),
  CONSTRAINT `cylinderstock_ibfk_1` FOREIGN KEY (`cylinderid`) REFERENCES `cylinderinfo` (`CylinderID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cylinderstock`
--

/*!40000 ALTER TABLE `cylinderstock` DISABLE KEYS */;
INSERT INTO `cylinderstock` (`stockid`,`cylinderid`,`stocktype`,`CylinderStatus`,`StockDate`,`Quantity`) VALUES 
 (1,1,'IN','Fill','2014-09-24 08:21:06',15),
 (2,4,'IN','Fill','2014-09-24 08:21:15',150),
 (3,2,'IN','Fill','2014-09-24 08:21:22',100),
 (4,3,'IN','Fill','2014-09-24 08:21:28',25),
 (5,3,'IN','Empty','2014-09-24 08:21:34',10),
 (6,2,'IN','Empty','2014-09-24 08:21:40',50),
 (7,4,'IN','Empty','2014-09-24 08:21:43',50),
 (8,1,'IN','Empty','2014-09-24 08:21:46',50);
/*!40000 ALTER TABLE `cylinderstock` ENABLE KEYS */;


--
-- Definition of table `cylindertype`
--

DROP TABLE IF EXISTS `cylindertype`;
CREATE TABLE `cylindertype` (
  `TypeID` varchar(20) NOT NULL,
  `TypeName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`TypeID`),
  UNIQUE KEY `TypeName` (`TypeName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cylindertype`
--

/*!40000 ALTER TABLE `cylindertype` DISABLE KEYS */;
INSERT INTO `cylindertype` (`TypeID`,`TypeName`) VALUES 
 ('CM','Commercial'),
 ('DC','Domestic');
/*!40000 ALTER TABLE `cylindertype` ENABLE KEYS */;


--
-- Definition of table `logininfo`
--

DROP TABLE IF EXISTS `logininfo`;
CREATE TABLE `logininfo` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logininfo`
--

/*!40000 ALTER TABLE `logininfo` DISABLE KEYS */;
INSERT INTO `logininfo` (`username`,`password`) VALUES 
 ('admin','admin@123');
/*!40000 ALTER TABLE `logininfo` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
