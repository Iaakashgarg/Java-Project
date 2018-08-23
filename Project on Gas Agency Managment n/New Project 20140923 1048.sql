-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.89-community-nt


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
-- Definition of table `cylindertype`
--

DROP TABLE IF EXISTS `cylindertype`;
CREATE TABLE `cylindertype` (
  `typeid` varchar(100) NOT NULL,
  `typename` varchar(100) default NULL,
  PRIMARY KEY  (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cylindertype`
--

/*!40000 ALTER TABLE `cylindertype` DISABLE KEYS */;
/*!40000 ALTER TABLE `cylindertype` ENABLE KEYS */;


--
-- Definition of table `logininfo`
--

DROP TABLE IF EXISTS `logininfo`;
CREATE TABLE `logininfo` (
  `username` varchar(100) default NULL,
  `password` varchar(100) default NULL,
  `rolename` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logininfo`
--

/*!40000 ALTER TABLE `logininfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `logininfo` ENABLE KEYS */;


--
-- Definition of table `logininformation`
--

DROP TABLE IF EXISTS `logininformation`;
CREATE TABLE `logininformation` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) default NULL,
  `rolename` varchar(100) default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logininformation`
--

/*!40000 ALTER TABLE `logininformation` DISABLE KEYS */;
/*!40000 ALTER TABLE `logininformation` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
