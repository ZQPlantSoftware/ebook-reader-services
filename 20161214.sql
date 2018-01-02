-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: 182.92.11.96    Database: epubreader
-- ------------------------------------------------------
-- Server version	5.5.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `annotator`
--

DROP TABLE IF EXISTS `annotator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `annotator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `text` varchar(500) DEFAULT NULL,
  `quote` varchar(505) DEFAULT NULL,
  `uri` varchar(405) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `description` varchar(405) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `chapter` varchar(145) DEFAULT NULL,
  `percentage` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annotator`
--

LOCK TABLES `annotator` WRITE;
/*!40000 ALTER TABLE `annotator` DISABLE KEYS */;
/*!40000 ALTER TABLE `annotator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(405) DEFAULT NULL,
  `book_code` varchar(405) DEFAULT NULL,
  `url` varchar(205) DEFAULT NULL,
  `total_page_num` int(11) DEFAULT NULL,
  `cfis` varchar(405) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `probation` int(11) NOT NULL DEFAULT '-1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `url_UNIQUE` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_mark`
--

DROP TABLE IF EXISTS `book_mark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_mark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `cfi` varchar(105) DEFAULT NULL,
  `description` varchar(105) DEFAULT NULL,
  `abst` varchar(105) DEFAULT NULL,
  `page` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `chapter` varchar(105) DEFAULT NULL,
  `percentage` double DEFAULT NULL,
  `book_markcol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_mark`
--

LOCK TABLES `book_mark` WRITE;
/*!40000 ALTER TABLE `book_mark` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_mark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `userId` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `epub_metadata`
--

DROP TABLE IF EXISTS `epub_metadata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `epub_metadata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) DEFAULT NULL,
  `book_title` varchar(45) DEFAULT NULL,
  `creator` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `direction` varchar(45) DEFAULT NULL,
  `identifier` varchar(45) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  `layout` varchar(45) DEFAULT NULL,
  `modified_data` varchar(45) DEFAULT NULL,
  `orientation` varchar(45) DEFAULT NULL,
  `pubdata` varchar(45) DEFAULT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `rights` varchar(45) DEFAULT NULL,
  `spread` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `epub_metadata`
--

LOCK TABLES `epub_metadata` WRITE;
/*!40000 ALTER TABLE `epub_metadata` DISABLE KEYS */;
/*!40000 ALTER TABLE `epub_metadata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `epub_page`
--

DROP TABLE IF EXISTS `epub_page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `epub_page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) DEFAULT NULL,
  `cfi` varchar(145) DEFAULT NULL,
  `page` int(11) DEFAULT NULL,
  `height` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=351 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `epub_page`
--

LOCK TABLES `epub_page` WRITE;
/*!40000 ALTER TABLE `epub_page` DISABLE KEYS */;
/*!40000 ALTER TABLE `epub_page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `epub_spine`
--

DROP TABLE IF EXISTS `epub_spine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `epub_spine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cfi` varchar(145) DEFAULT NULL,
  `cfi_base` varchar(145) DEFAULT NULL,
  `href` varchar(145) DEFAULT NULL,
  `s_index` int(11) DEFAULT NULL,
  `s_linear` varchar(45) DEFAULT NULL,
  `url` varchar(145) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `epub_spine`
--

LOCK TABLES `epub_spine` WRITE;
/*!40000 ALTER TABLE `epub_spine` DISABLE KEYS */;
/*!40000 ALTER TABLE `epub_spine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mark`
--

DROP TABLE IF EXISTS `mark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mark` (
  `id` int(11) NOT NULL,
  `epubcfi` varchar(45) DEFAULT NULL,
  `userId` varchar(45) DEFAULT NULL,
  `comment` varchar(45) DEFAULT NULL,
  `bookId` varchar(45) DEFAULT NULL,
  `target` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mark`
--

LOCK TABLES `mark` WRITE;
/*!40000 ALTER TABLE `mark` DISABLE KEYS */;
/*!40000 ALTER TABLE `mark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ranges`
--

DROP TABLE IF EXISTS `ranges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ranges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `annotator_id` int(11) DEFAULT NULL,
  `start` varchar(145) DEFAULT NULL,
  `start_offset` int(11) DEFAULT NULL,
  `end` varchar(145) DEFAULT NULL,
  `end_offset` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ranges`
--

LOCK TABLES `ranges` WRITE;
/*!40000 ALTER TABLE `ranges` DISABLE KEYS */;
INSERT INTO `ranges` VALUES (1,2,'/p[1]',188,'/p[1]',193),(2,3,'/p[1]',114,'/p[1]',119),(9,10,'/p[36]',113,'/p[36]',122),(10,11,'/p[29]',753,'/p[29]',762),(11,12,'/p[1]',258,'/p[1]',264),(12,13,'/p[4]',76,'/p[4]',81),(13,14,'/p[22]',83,'/p[22]',151),(14,15,'/div[44]/a[1]',7,'/div[44]/a[1]',12),(15,16,'/div[39]/a[1]',9,'/div[39]/a[1]',12),(16,17,'/div[42]',29,'/div[42]',35),(17,18,'/p[2]',141,'/p[2]',146),(19,20,'/p[2]',3,'/p[2]',16),(20,21,'/p[112]',244,'/p[112]',296);
/*!40000 ALTER TABLE `ranges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `regtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2016-12-14 23:44:03
