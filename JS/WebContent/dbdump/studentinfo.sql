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

/*Table structure for table `studentinformation` */

DROP TABLE IF EXISTS `studentinformation`;

CREATE TABLE `studentinformation` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) default NULL,
  `lname` varchar(50) default NULL,
  `mobno` varchar(20) default NULL,
  `email` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `state` varchar(50) default NULL,
  `city` varchar(50) default NULL,
  `image` varchar(500) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `studentinformation` */

insert  into `studentinformation`(`id`,`name`,`lname`,`mobno`,`email`,`password`,`state`,`city`,`image`) values ('Achoukse7','Aman','Choukse','9755552578','aman.choukse@gmail.com','Aman@123','MadhyaPradesh','Indore','D:\\OnlineTest\\JS\\WebContent\\pic\\IMG_4445.JPG');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
