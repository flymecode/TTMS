-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: ttms
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `aid` varchar(45) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('1','马旭','admin','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `cid` varchar(20) NOT NULL,
  `cname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('1','正在上映'),('2','即将上映'),('3','热播影片'),('4','经典影片');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hall`
--

DROP TABLE IF EXISTS `hall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hall` (
  `hid` varchar(35) NOT NULL,
  `hname` varchar(20) DEFAULT NULL,
  `hdescription` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hall`
--

LOCK TABLES `hall` WRITE;
/*!40000 ALTER TABLE `hall` DISABLE KEYS */;
INSERT INTO `hall` VALUES ('1','一号厅','很轻松'),('2','二号厅','美丽'),('3','三号厅','大方'),('4','四号厅','温柔 '),('A0B2D24167E84A919CD6EBF5908D61D0','六号厅','超级炫酷');
/*!40000 ALTER TABLE `hall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `mid` varchar(55) NOT NULL,
  `mname` varchar(20) DEFAULT NULL,
  `mprice` varchar(20) DEFAULT NULL,
  `mdescription` varchar(255) DEFAULT NULL,
  `mimage` varchar(20) DEFAULT NULL,
  `mstate` int(11) DEFAULT NULL,
  `cid` varchar(20) DEFAULT NULL,
  `video` varchar(25) DEFAULT NULL,
  `playtime` varchar(20) DEFAULT NULL,
  `actor` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`mid`),
  KEY `fk_cid_idx` (`cid`),
  CONSTRAINT `fk_cid` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES ('1','飞龙在天','20','漫威电影宇宙10周年的历史性集结，将为影迷们带来史诗版的终极对决。面对灭霸突然发起的闪电袭击，复仇者联盟及其所有超级英雄盟友必须全力以赴，才能阻止他对全宇宙造成毁灭性的打击。','/img/movie/r1.jpg',1,'1','/video/4.mp4','110','高翌华,马旭,吴任鹏,小沃金'),('10','发射点','22','范德萨','/img/movie/f4.jpg',1,'2',NULL,'120',NULL),('11','大海','22','好的人','/img/movie/f5.jpg',1,'2',NULL,NULL,NULL),('12','小朋友','33','很不错','/img/movie/f6.jpg',1,'2',NULL,NULL,NULL),('2','小黄人','30','不错哦','/img/movie/r2.jpg',1,'1',NULL,NULL,NULL),('3','奥特曼','33','好看','/img/movie/r3.jpg',1,'1',NULL,NULL,NULL),('4','我是你爸爸','33','超级帮 ','/img/movie/r4.jpg',1,'1',NULL,NULL,NULL),('5','我是你妈妈','33','很好的','/img/movie/r5.jpg',1,'1',NULL,NULL,NULL),('6','真的吗','33','不错哦','/img/movie/r6.jpg',1,'1',NULL,NULL,NULL),('7','复仇者联盟','44','真的澳门','/img/movie/f1.jpg',1,'2',NULL,NULL,NULL),('8','麦霸','33','不好看','/img/movie/f2.jpg',1,'2',NULL,NULL,NULL),('9','妈妈','33','好的','/img/movie/f3.jpg',1,'2',NULL,NULL,NULL);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordercart`
--

DROP TABLE IF EXISTS `ordercart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordercart` (
  `oid` varchar(55) NOT NULL,
  `uid` varchar(55) DEFAULT NULL,
  `total` double(10,0) DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  `state` int(10) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `fk_order_uid` (`uid`),
  CONSTRAINT `fk_order_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordercart`
--

LOCK TABLES `ordercart` WRITE;
/*!40000 ALTER TABLE `ordercart` DISABLE KEYS */;
INSERT INTO `ordercart` VALUES ('5F319584AB644A87B9CC6727A65CD369','05BCD8EA30984236A97056C925D227F7',40,'2018-05-29 09:01:38',0),('8B39B887C9E4410FBACBAE5065524132','05BCD8EA30984236A97056C925D227F7',40,'2018-05-29 21:50:02',0),('A4CC40AC08744751BD759A86C5D81DBD','05BCD8EA30984236A97056C925D227F7',40,'2018-05-29 12:52:55',0),('B9A24014E4AA45B694E3F31511BAB18D','05BCD8EA30984236A97056C925D227F7',40,'2018-05-29 21:12:12',0),('D04043805A8F4C46B65F235C166C55C9','05BCD8EA30984236A97056C925D227F7',40,'2018-06-03 18:47:47',0);
/*!40000 ALTER TABLE `ordercart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitem`
--

DROP TABLE IF EXISTS `orderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderitem` (
  `oiid` varchar(55) NOT NULL,
  `mid` varchar(55) DEFAULT NULL,
  `oid` varchar(55) DEFAULT NULL,
  `num` int(20) DEFAULT NULL,
  `subtotal` double(20,0) DEFAULT NULL,
  `hname` varchar(20) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`oiid`),
  KEY `fk_oid_idx` (`oid`),
  KEY `fk_mid_idx` (`mid`),
  CONSTRAINT `fk_mid` FOREIGN KEY (`mid`) REFERENCES `movie` (`mid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_oid` FOREIGN KEY (`oid`) REFERENCES `ordercart` (`oid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitem`
--

LOCK TABLES `orderitem` WRITE;
/*!40000 ALTER TABLE `orderitem` DISABLE KEYS */;
INSERT INTO `orderitem` VALUES ('00D979E0CBEE49FA8E912274CD2FE080','1','8B39B887C9E4410FBACBAE5065524132',2,40,'一号厅','2018-05-02T03:03'),('2847533D848B4F92869BC3BCFE493F04','1','A4CC40AC08744751BD759A86C5D81DBD',2,40,'一号厅','2018-05-02T03:03'),('304BB5D273A04B6990DDE2B397BBD032','1','5F319584AB644A87B9CC6727A65CD369',2,40,'一号厅','2018-05-02T03:03'),('336888445F88455E827F3628DE85FFDC','1','B9A24014E4AA45B694E3F31511BAB18D',2,40,'一号厅','2018-05-02T03:03'),('3442612D4970431D9C8B453DFA631BF1','1','D04043805A8F4C46B65F235C166C55C9',2,40,'一号厅','2018-05-02T03:03');
/*!40000 ALTER TABLE `orderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `sid` varchar(45) NOT NULL,
  `mid` varchar(20) DEFAULT NULL,
  `hid` varchar(35) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `fk_mid_idx` (`mid`),
  KEY `fk_hid_idx` (`hid`),
  CONSTRAINT `fk_hid` FOREIGN KEY (`hid`) REFERENCES `hall` (`hid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_mmid` FOREIGN KEY (`mid`) REFERENCES `movie` (`mid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES ('0F1945BC962D41018F059169B98EA98D','10','2','2018-05-02T03:03'),('1','1','1','2018-05-02T03:03'),('2','1','2','2018-05-02T03:03'),('264A57C6C223430782B6D45B9EAAA11D','7','3','2018-05-11T03:03'),('267D0CFED1B444AAB3C48B66DDF39475','10','1','2018-05-10T03:03'),('2C3540D09D5E4B3BAF9494E6D0AE1D79','1','4','2018-05-08T03:03'),('3','1','3','2018-05-02T03:03'),('4','1','4','2018-05-02T03:03'),('6390A55D004848C8B07C6476C1C4E854','3','3','2018-05-20T04:04'),('6F698812C7684667997A9B22FCB9D455','10','2','2018-05-10T03:03'),('A5854D5288E24D1F812E1F0520C61FC4','6','2','2018-05-24T03:03'),('BBE3D8F135544FDEBF1A94B7D9E167F7','7','A0B2D24167E84A919CD6EBF5908D61D0','2018-05-11T04:04'),('D5A5D9C4903E4717B6AAD00CD20E4628','6','2','2018-05-08T03:03'),('EC6169F0ABBF4CC3A68744A094E414B2','1','1','2018-05-03T01:01'),('EE6CDA5384C0480FB36876DC06A83262','2','2','2018-05-02T05:05');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat` (
  `seid` varchar(45) NOT NULL,
  `row` int(20) DEFAULT NULL,
  `column` int(20) DEFAULT NULL,
  `state` varchar(5) DEFAULT NULL,
  `hid` varchar(20) DEFAULT NULL,
  `oid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`seid`),
  KEY `fk_sehid_idx` (`hid`),
  KEY `fk_sdoid` (`oid`),
  CONSTRAINT `fk_sehid` FOREIGN KEY (`hid`) REFERENCES `hall` (`hid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES ('0BA4DF4B23114D86992EB6BDC77E9C96',7,10,'1','1','A4CC40AC08744751BD759A86C5D81DBD'),('2A76EA8A33E146BCA2D7807C666ACDCB',6,9,'1','1','D04043805A8F4C46B65F235C166C55C9'),('819BC14F7FF44859BDD5CBFFD1CA0610',4,8,'1','1','8B39B887C9E4410FBACBAE5065524132'),('8775CD941CF54306B6123E9819B9526A',7,9,'1','1','D04043805A8F4C46B65F235C166C55C9'),('8CE0BAA38A424B4EB541B09389F78702',5,8,'1','1','8B39B887C9E4410FBACBAE5065524132'),('91A5783F14CE484A8B5D97BC0A97C053',5,9,'1','1','B9A24014E4AA45B694E3F31511BAB18D'),('CE4D39CB5CC24F59BB6EF3A6AE05B3E2',4,9,'1','1','B9A24014E4AA45B694E3F31511BAB18D'),('F473A0F0F0504BAAAFACE5140006B2D7',6,10,'1','1','A4CC40AC08744751BD759A86C5D81DBD'),('FA5BB77DC94B49F88AAF856DEDAF52AB',5,10,'1','1','5F319584AB644A87B9CC6727A65CD369'),('FCDF607F6DEA4210B013CD4F25D9801E',4,10,'1','1','5F319584AB644A87B9CC6727A65CD369');
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `uid` varchar(32) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(10) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('05BCD8EA30984236A97056C925D227F7','admin','admin','马旭','aaa@store.com','2018-05-11',NULL,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ttms'
--

--
-- Dumping routines for database 'ttms'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-03 22:55:43
