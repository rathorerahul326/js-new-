/*
SQLyog Enterprise - MySQL GUI v8.14 
MySQL - 5.0.24-community-nt : Database - onlinetest
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`onlinetest` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `onlinetest`;

/*Table structure for table `firetest` */

DROP TABLE IF EXISTS `firetest`;

CREATE TABLE `firetest` (
  `f_id` int(11) NOT NULL auto_increment,
  `test_id` int(11) default NULL,
  `date` date default NULL,
  `start_time` time default NULL,
  `end_time` time default NULL,
  PRIMARY KEY  (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `firetest` */

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `stid` int(11) default NULL,
  `Question` varchar(1000) default NULL,
  `A` varchar(200) default NULL,
  `B` varchar(200) default NULL,
  `C` varchar(200) default NULL,
  `D` varchar(200) default NULL,
  `ans` varchar(10) default NULL,
  `marking` int(11) default NULL,
  `qid` int(10) NOT NULL auto_increment,
  PRIMARY KEY  (`qid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `question` */

insert  into `question`(`stid`,`Question`,`A`,`B`,`C`,`D`,`ans`,`marking`,`qid`) values (9,'What is your name?				','vipul','vip','pull','sha','A',2,1),(3,'Which of the following is true about extends Attribute?		','The extends attribute can be used to define a subclass of generated servlet','The extends attribute is used to specify a superclass that the generated servlet must extend','Both of the above.',' None of the above.','B',2,2),(3,'config is instance of which class?		','javax.servlet.ServletContext',' javax.servlet.ServletConfig','javax.servlet.Context',' javax.servlet.Application','B',3,3),(9,'				what is you surname?','vipul','sha','shar','sharma','D',2,4),(25,'				what is quuestion?','question is answer','answer is of question','c option is wrong','d option','B',2,5),(9,'				what is muti','ksdh','kdfh','kdjfh','dkfhg','C',3,6),(26,'Types of inheritance use in java?','3','2',NULL,'2','A',2,7),(9,'How many thread available in simple java program by default?','0','2',NULL,'1','A',5,8),(32,'What is subtopic99 ?','xyz','abc',NULL,'pqr','C',2,9),(32,'What is your name ?','no mane','aaa',NULL,'kkk','A',3,10),(9,'What is synchronization in java?','interthread communication','interprocess comm',NULL,'achieved only by synchronixed keyword','A',2,11);

/*Table structure for table `subtopic` */

DROP TABLE IF EXISTS `subtopic`;

CREATE TABLE `subtopic` (
  `tid` int(10) default NULL,
  `stid` int(10) NOT NULL auto_increment,
  `subtopic_name` varchar(50) default NULL,
  PRIMARY KEY  (`stid`),
  KEY `FK_subtopic` (`tid`),
  CONSTRAINT `FK_subtopic` FOREIGN KEY (`tid`) REFERENCES `topic` (`tid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `subtopic` */

insert  into `subtopic`(`tid`,`stid`,`subtopic_name`) values (2,3,'jsp'),(2,4,'servlet'),(2,5,'kahsd'),(2,6,'kjsdh'),(37,7,'ljds'),(37,8,'ldskjf'),(1,9,'Multi-Threading'),(1,10,'Object Class'),(1,11,'Static Keyword'),(2,12,'JDBC'),(39,13,'id selector'),(39,14,'class selector'),(39,15,'name selector'),(39,16,'Function'),(39,17,'Object'),(39,18,'Scope'),(2,21,'sessionTracking'),(1,22,'Variable'),(37,23,'fff'),(37,24,'kjjs'),(43,25,'my subtopic'),(1,26,'Inheritance'),(46,27,'ase'),(47,28,'Introduction'),(1,29,'Thread pool'),(48,30,'sub theory'),(48,31,'sub'),(50,32,'Subtopic99'),(50,33,'subtopic199');

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `test_id` int(11) NOT NULL auto_increment,
  `test_name` varchar(30) default NULL,
  `total` int(11) default NULL,
  `duration` int(11) default NULL,
  PRIMARY KEY  (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `test` */

insert  into `test`(`test_id`,`test_name`,`total`,`duration`) values (1,'Test1',40,120),(2,'Test2',20,60),(3,'Test3',20,180),(4,'Test4',25,240),(5,'testdemo',5,30),(6,'t1',2,30),(7,'tded',5,50),(8,'Monthly Test',5,10),(9,'',5,30),(10,'Create test ',2,10);

/*Table structure for table `test_topics` */

DROP TABLE IF EXISTS `test_topics`;

CREATE TABLE `test_topics` (
  `test_topicid` int(11) NOT NULL auto_increment,
  `test_id` int(11) default NULL,
  `subtopic_id` int(11) default NULL,
  `no_of_question` int(11) default NULL,
  PRIMARY KEY  (`test_topicid`),
  KEY `FK_test_topics` (`test_id`),
  CONSTRAINT `FK_test_topics` FOREIGN KEY (`test_id`) REFERENCES `test` (`test_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `test_topics` */

insert  into `test_topics`(`test_topicid`,`test_id`,`subtopic_id`,`no_of_question`) values (1,1,3,2),(2,1,4,3),(3,1,5,4),(4,1,6,5),(5,1,9,4),(6,1,10,5),(7,1,11,4),(8,1,12,5),(9,1,21,4),(10,1,22,7),(11,2,3,3),(12,4,9,1),(13,4,10,2),(14,6,9,1),(15,6,10,1),(16,6,11,1),(17,6,22,1),(18,6,26,1),(19,8,9,3),(20,5,9,4),(21,10,32,2);

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `tid` int(10) NOT NULL auto_increment,
  `topic_name` varchar(50) default NULL,
  PRIMARY KEY  (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `topic` */

insert  into `topic`(`tid`,`topic_name`) values (1,'Core Java'),(2,'Advanced Java'),(37,'spring'),(38,'Hibernate'),(39,'ajax'),(40,'sturt'),(41,'abc'),(42,'java script'),(43,'my topic'),(44,'vipul'),(45,'vipin'),(46,'rdfdhg'),(47,'Generic'),(48,'Theory'),(49,'Aman'),(50,'TestTopic99');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
