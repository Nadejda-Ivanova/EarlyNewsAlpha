-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: news
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Dumping data for table `art_img`
--

LOCK TABLES `art_img` WRITE;
/*!40000 ALTER TABLE `art_img` DISABLE KEYS */;
/*!40000 ALTER TABLE `art_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (3,'sdgrg','Mareshki prodava evtin benzin',1,'2016-03-25 19:47:53','2016-03-25 19:47:53',NULL),(4,'test title',':24 PM org.apache.catalina.core.StandardContext reload\r\nINFO: Reloading Context with name [/NewsProject] is completed\r\nMar 26, 2016 5:55:24 PM org.apache.catalina.core.StandardContext reload\r\nINFO: Reloading Context with name [/NewsProject] has started\r\nMar 26, 2016 5:55:24 PM org.apache.jasper',1,'2016-03-26 15:58:09','2016-03-26 15:58:09',NULL),(5,'566u5u56uj','rttjrtjrjfgcvnmh;ui;oooooooooooooooooooooooooooooiuy',1,'2016-03-26 16:21:59','2016-03-26 16:21:59',NULL);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Business','Business news',1,1,1),(2,'Health','Health news',4,1,1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,'1','2016-03-25 17:38:49'),(2,'2','2016-03-25 17:40:33'),(3,'3','2016-03-25 17:45:42'),(4,'C:pics','2016-03-25 17:57:27'),(5,'5','2016-03-25 18:02:29'),(6,'6','2016-03-25 18:43:42'),(7,'C:\\pics7.jpg','2016-03-25 18:52:49'),(8,'C:\\pics\\8.jpg','2016-03-25 18:56:09'),(9,'C:\\pics\\9.jpg','2016-03-25 19:43:20'),(10,'C:\\pics\\10.jpg','2016-03-25 19:46:11'),(11,'C:\\pics\\11.jpg','2016-03-25 19:47:52'),(12,'C:\\pics12.jpg','2016-03-26 15:56:00'),(13,'C:\\pics13.jpg','2016-03-26 15:58:08'),(14,'C:\\pics\\14.jpg','2016-03-26 16:21:58');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `subscribe`
--

LOCK TABLES `subscribe` WRITE;
/*!40000 ALTER TABLE `subscribe` DISABLE KEYS */;
/*!40000 ALTER TABLE `subscribe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'gosho','1234','erhdhdhfd',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `videos`
--

LOCK TABLES `videos` WRITE;
/*!40000 ALTER TABLE `videos` DISABLE KEYS */;
/*!40000 ALTER TABLE `videos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-27 21:42:06
