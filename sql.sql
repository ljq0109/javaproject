/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.0.22-community-nt : Database - studentmanagesystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studentmanagesystem` /*!40100 DEFAULT CHARACTER SET gbk */;

USE `studentmanagesystem`;

/*Table structure for table `college_infor` */

DROP TABLE IF EXISTS `college_infor`;

CREATE TABLE `college_infor` (
  `college_id` varchar(15) NOT NULL,
  `college_name` varchar(20) default NULL,
  PRIMARY KEY  (`college_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `college_infor` */

insert  into `college_infor`(`college_id`,`college_name`) values ('1','信息科学与技术学院'),('2','艺术学院'),('3','外国语学院'),('4','理学院');

/*Table structure for table `course_infor` */

DROP TABLE IF EXISTS `course_infor`;

CREATE TABLE `course_infor` (
  `cou_id` varchar(15) NOT NULL,
  `cou_name` varchar(20) default NULL,
  `cou_college` varchar(15) default NULL,
  `cou_credit` float default NULL,
  `cou_teacher` varchar(15) default NULL,
  PRIMARY KEY  (`cou_id`),
  KEY `cou_college` (`cou_college`),
  KEY `cou_teacher` (`cou_teacher`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `course_infor` */

insert  into `course_infor`(`cou_id`,`cou_name`,`cou_college`,`cou_credit`,`cou_teacher`) values ('1','计算机网络','1',3,'2006060112'),('2','软件工程导论','1',3,'2006060112'),('3','艺术发展史','2',3,'2004080712'),('4','物理力学','4',2,'2004040712');

/*Table structure for table `grade_infor` */

DROP TABLE IF EXISTS `grade_infor`;

CREATE TABLE `grade_infor` (
  `stu_id` varchar(15) NOT NULL,
  `cou_id` varchar(15) NOT NULL,
  `grade` float default NULL,
  `stu_name` varchar(10) default NULL,
  `cou_name` varchar(20) default NULL,
  `cou_teacher` varchar(15) default NULL,
  `stu_college` varchar(15) default NULL,
  PRIMARY KEY  (`stu_id`,`cou_id`),
  KEY `cou_id` (`cou_id`),
  KEY `cou_teacher` (`cou_teacher`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `grade_infor` */

insert  into `grade_infor`(`stu_id`,`cou_id`,`grade`,`stu_name`,`cou_name`,`cou_teacher`,`stu_college`) values ('2015234060411','2',84,'张三','软件工程导论','2006060112','1'),('2015234060411','4',86,'张三','物理力学','2004040712','1'),('2015234060417','4',82,'青春','物理力学','2004040712','1');

/*Table structure for table `login_user` */

DROP TABLE IF EXISTS `login_user`;

CREATE TABLE `login_user` (
  `userid` varchar(15) NOT NULL default '',
  `password` varchar(15) default NULL,
  `role` varchar(5) default NULL,
  `realname` varchar(10) default NULL,
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `login_user` */

insert  into `login_user`(`userid`,`password`,`role`,`realname`) values ('200012453','200012453','管理员','家家'),('2004040712','2004040712','教师','aa'),('2004080712','2004080712','教师','汤姆'),('2006060112','2006060112','教师','小米'),('2007060413','2007060413','教师','王五'),('2015234060410','2015234060410','学生','李四'),('2015234060411','2015234060411','学生','张三'),('2015234060412','2015234060412','学生','赵丽'),('2015234060417','2015234060417','学生','无力'),('2015345030201','2015345030201','学生','玩笑'),('2015345030202','2015345030202','学生','幸福');

/*Table structure for table `state` */

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
  `state_id` int(11) NOT NULL,
  `state_name` varchar(15) default NULL,
  PRIMARY KEY  (`state_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `state` */

insert  into `state`(`state_id`,`state_name`) values (1,'在校'),(2,'毕业'),(3,'结业'),(4,'退学');

/*Table structure for table `student_infor` */

DROP TABLE IF EXISTS `student_infor`;

CREATE TABLE `student_infor` (
  `stu_id` varchar(15) NOT NULL default '',
  `stu_name` varchar(10) default NULL,
  `stu_sex` varchar(2) default NULL,
  `stu_birth` date default NULL,
  `stu_college` varchar(15) default NULL,
  `stu_subject` varchar(15) default NULL,
  `stu_class` varchar(10) default NULL,
  `stu_state` int(11) default NULL,
  `intime` date default NULL,
  `sanhao` varchar(5) default NULL,
  PRIMARY KEY  (`stu_id`),
  KEY `stu_college` (`stu_college`),
  KEY `stu_subject` (`stu_subject`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `student_infor` */

insert  into `student_infor`(`stu_id`,`stu_name`,`stu_sex`,`stu_birth`,`stu_college`,`stu_subject`,`stu_class`,`stu_state`,`intime`,`sanhao`) values ('2010234060417','青春','女','1993-05-20','2','1','1002',2,'2010-06-15','否'),('2010234060418','海洌','男','1993-04-20','1','2','1002',3,'2010-06-15','否'),('2010234060419','原为','女','1993-03-20','1','2','1002',4,'2010-06-15','否'),('2015234060410','李四','男','1998-03-04','1','1','1502',1,'2015-06-01','是'),('2015234060411','张三','女','1996-01-09','1','1','1502',1,'2016-06-10','是'),('2015234060412','赵丽','男','1996-01-09','1','1','1601',1,'2016-06-10','否'),('2015234060417','无力','男','1996-02-09','1','1','1601',1,'2016-06-10','否'),('2015345030201','玩笑','女','1997-05-06','2','6','1601',1,'2016-06-10','否'),('2015345030202','幸福','女','1996-09-09','2','7','1602',1,'2016-06-10','否');

/*Table structure for table `subject_infor` */

DROP TABLE IF EXISTS `subject_infor`;

CREATE TABLE `subject_infor` (
  `sub_id` varchar(15) NOT NULL,
  `sub_name` varchar(20) default NULL,
  `sub_college` varchar(15) default NULL,
  PRIMARY KEY  (`sub_id`),
  KEY `sub_college` (`sub_college`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `subject_infor` */

insert  into `subject_infor`(`sub_id`,`sub_name`,`sub_college`) values ('1','软件工程','1'),('2','计算机技术','1'),('3','网络工程','1'),('4','英语专业','3'),('5','数学专业','4'),('6','美术专业','2'),('7','音乐专业','2'),('8','法语专业','3'),('9','物理专业','4');

/*Table structure for table `teacher_infor` */

DROP TABLE IF EXISTS `teacher_infor`;

CREATE TABLE `teacher_infor` (
  `tea_id` varchar(15) NOT NULL,
  `tea_name` varchar(10) default NULL,
  `tea_sex` varchar(2) default NULL,
  `tea_college` varchar(15) default NULL,
  PRIMARY KEY  (`tea_id`),
  KEY `tea_college` (`tea_college`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `teacher_infor` */

insert  into `teacher_infor`(`tea_id`,`tea_name`,`tea_sex`,`tea_college`) values ('2004040712','aa','女','4'),('2004080712','汤姆','女','2'),('2006060112','小米','女','1'),('2007060413','王五','男','1');

/*Table structure for table `teacher_infors` */

DROP TABLE IF EXISTS `teacher_infors`;

CREATE TABLE `teacher_infors` (
  `tea_id` varchar(15) NOT NULL,
  `tea_name` varchar(10) default NULL,
  PRIMARY KEY  (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `teacher_infors` */

insert  into `teacher_infors`(`tea_id`,`tea_name`) values ('2004040712','aa'),('2004080712','汤姆'),('2006060112','小米'),('2007060413','王五');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
