-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: epub
-- ------------------------------------------------------
-- Server version	5.7.19

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
  `user_id` varchar(105) DEFAULT NULL,
  `description` varchar(405) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `chapter` varchar(145) DEFAULT NULL,
  `percentage` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `probation` int(11) DEFAULT '-1',
  `bid` varchar(100) DEFAULT NULL,
  `source` varchar(500) DEFAULT NULL,
  `is_init` int(2) DEFAULT NULL,
  `is_index` int(2) DEFAULT NULL COMMENT '是否导入到搜索系统中',
  PRIMARY KEY (`id`),
  UNIQUE KEY `url_UNIQUE` (`url`),
  UNIQUE KEY `bid_UNIQUE` (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=3793 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `book_copy`
--

DROP TABLE IF EXISTS `book_copy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_copy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(405) DEFAULT NULL,
  `book_code` varchar(405) DEFAULT NULL,
  `url` varchar(205) DEFAULT NULL,
  `total_page_num` int(11) DEFAULT NULL,
  `cfis` varchar(405) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `probation` int(11) DEFAULT '-1',
  `bid` varchar(100) DEFAULT NULL,
  `source` varchar(500) DEFAULT NULL,
  `is_init` int(2) DEFAULT NULL,
  `is_index` int(2) DEFAULT NULL COMMENT '是否导入到搜索系统中',
  PRIMARY KEY (`id`),
  UNIQUE KEY `url_UNIQUE` (`url`),
  UNIQUE KEY `bid_UNIQUE` (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=3793 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `book_mark`
--

DROP TABLE IF EXISTS `book_mark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_mark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `user_id` varchar(105) DEFAULT NULL,
  `cfi` varchar(105) DEFAULT NULL,
  `description` varchar(105) DEFAULT NULL,
  `abst` varchar(105) DEFAULT NULL,
  `page` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `chapter` varchar(105) DEFAULT NULL,
  `percentage` double DEFAULT NULL,
  `book_markcol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=18450 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=1733 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `theme_id` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-04 16:38:47
