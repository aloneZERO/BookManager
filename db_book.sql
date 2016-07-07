/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.11 : Database - db_book_leo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_book_leo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_book_leo`;

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `bookTypeId` int(11) DEFAULT NULL,
  `bookDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bookTypeId` (`bookTypeId`),
  CONSTRAINT `t_book_ibfk_1` FOREIGN KEY (`bookTypeId`) REFERENCES `t_booktype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `t_book` */

insert  into `t_book`(`id`,`bookName`,`author`,`sex`,`price`,`bookTypeId`,`bookDesc`) values (1,'哈哈计算机','void','unknown',23,1,''),(2,'哈哈Java','unknown','男',66,1,''),(3,'土豪狗','阿狗','unknown',0,8,''),(4,'疯狂测试','哦哈呦','男',177,6,'一言不合就测试！'),(5,'无名','佚名','不明',233,4,'无语'),(6,'不知名+1','佚名','不明',122,5,''),(7,'测试1','佚名','不明',12,1,''),(8,'测试2','佚名','不明',34,1,''),(9,'测试3','佚名','不明',56,1,''),(10,'测试3','哦哈呦','男',78,1,''),(11,'测试5','whoami','男',66,12,'一切都是为了测试'),(12,'极限测试','疯子测','男',988,13,'我要测试！！！');

/*Table structure for table `t_booktype` */

DROP TABLE IF EXISTS `t_booktype`;

CREATE TABLE `t_booktype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookTypeName` varchar(20) DEFAULT NULL,
  `bookTypeDesc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `t_booktype` */

insert  into `t_booktype`(`id`,`bookTypeName`,`bookTypeDesc`) values (1,'计算机类','计算机相关图书'),(2,'艺术类','艺术类相关图书'),(4,'娱乐类','哈哈哈'),(5,'生物类',''),(6,'测试1','楼下有只土豪狗！！！它的名字叫阿狗'),(8,'阿狗日常','土豪狗'),(9,'测试2',''),(10,'测试3',''),(11,'测试4',''),(12,'测试5',''),(13,'测试6','');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`userName`,`password`) values (1,'leo','leobookbase'),(2,'zero','zerobookbase'),(3,'刘阿龟','233');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
