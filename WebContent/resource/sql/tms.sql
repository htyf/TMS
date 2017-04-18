/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.40 : Database - tms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tms` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `tms`;

/*Table structure for table `stu` */

DROP TABLE IF EXISTS `stu`;

CREATE TABLE `stu` (
  `sid` varchar(32) COLLATE utf8_bin NOT NULL,
  `sname` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `sage` int(11) DEFAULT NULL,
  `ssex` varchar(3) COLLATE utf8_bin DEFAULT NULL,
  `sphone` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `stu` */

insert  into `stu`(`sid`,`sname`,`sage`,`ssex`,`sphone`) values ('1','aa',12,'男','11111'),('1a3e6999a891404dab0094a7554','s',12,'男','1211111'),('1b8c38eb34bf4975aeba97bd23b26452','zhangsan',21,'男','13600001111'),('2','bb',33,'女','13111111'),('287781cce8394acfad3bfa80154e6539','占撒',21,'男','13800001111'),('6b3d37002b204e84ba185bb604de6594','占撒',21,'男','13600001111'),('6c4617a33b2a47b1a345a80111f3bec9','占撒',21,'男','13677771111'),('700a98a21b734d98bdbb98c5a74997a8','张三22',21,'男','13677771111'),('8240bf58e92a4f048cea11abd8738757','浏览器',23,'男',''),('93f597c428974d0497c907ca741b4ed9','liulan',12,'女','13600001111'),('9dbeb8996ae149df9362b2a8224cd971','张三',21,'男','13600001111'),('b59eeb6d31824740ae1ed5bfa7ae390e','张三',21,'男','13600001111'),('ba6329776e864537b66656c03e2f2ba1','张三',21,'男','13600001111'),('df8ed2b9a5bf4b60961f213db2d61ba0','占撒',21,'男','13677771111'),('e78a274170be4ca4a4c596d8e59c2354','季炜',21,'男','13600001111'),('f13ca64649704f46beff82c6d10e0482','张三',21,'男','13600001111');

/*Table structure for table `sys_headmenu` */

DROP TABLE IF EXISTS `sys_headmenu`;

CREATE TABLE `sys_headmenu` (
  `hid` int(32) NOT NULL AUTO_INCREMENT,
  `hname` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `sys_headmenu` */

insert  into `sys_headmenu`(`hid`,`hname`) values (1,'教学管理'),(2,'教务管理'),(3,'结业管理'),(4,'系统管理'),(5,'公司管理'),(6,'测试管理1'),(7,'测试管理2'),(8,'324'),(9,'34'),(10,'123123'),(11,'12');

/*Table structure for table `sys_privilege` */

DROP TABLE IF EXISTS `sys_privilege`;

CREATE TABLE `sys_privilege` (
  `power_id` int(32) NOT NULL,
  `power` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`power_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_privilege` */

insert  into `sys_privilege`(`power_id`,`power`) values (1,'教学周报'),(2,'周考统计'),(3,'班级管理'),(4,'学生管理'),(5,'教务周报'),(6,'口碑统计'),(7,'正在就业班级'),(8,'待就业班级'),(9,'已就业班级'),(10,'角色管理'),(11,'权限管理'),(12,'用户管理'),(13,'菜单管理');

/*Table structure for table `sys_privilege_role` */

DROP TABLE IF EXISTS `sys_privilege_role`;

CREATE TABLE `sys_privilege_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `role_id` int(8) DEFAULT NULL,
  `privilege_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `sys_privilege_role` */

insert  into `sys_privilege_role`(`id`,`role_id`,`privilege_id`) values (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,2,1),(6,2,2),(7,2,3),(8,3,2),(9,3,4),(10,4,2);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` int(8) NOT NULL,
  `role_position` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_position`) values (1,'项目经理'),(2,'讲师'),(3,'班主任'),(4,'人事');

/*Table structure for table `sys_teachreport_course` */

DROP TABLE IF EXISTS `sys_teachreport_course`;

CREATE TABLE `sys_teachreport_course` (
  `courseId` int(16) NOT NULL AUTO_INCREMENT COMMENT '课程序号',
  `courseName` varchar(32) DEFAULT NULL COMMENT '课程名称',
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `sys_teachreport_course` */

insert  into `sys_teachreport_course`(`courseId`,`courseName`) values (1,'java'),(2,'web');

/*Table structure for table `sys_teachreport_teacher` */

DROP TABLE IF EXISTS `sys_teachreport_teacher`;

CREATE TABLE `sys_teachreport_teacher` (
  `tid` int(16) NOT NULL AUTO_INCREMENT COMMENT '教师序号',
  `tname` varchar(32) DEFAULT NULL COMMENT '教师姓名',
  `teachMethods` varchar(16) DEFAULT NULL COMMENT '授课方式',
  `courseId` int(16) DEFAULT NULL COMMENT '课程序号',
  PRIMARY KEY (`tid`),
  KEY `FK_sys_teachreport_teacher` (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `sys_teachreport_teacher` */

insert  into `sys_teachreport_teacher`(`tid`,`tname`,`teachMethods`,`courseId`) values (0,'','',NULL),(1,'钟华磊','视频',1),(2,'高新杰','视频',2),(3,'周然','面授',3);

/*Table structure for table `sys_titlemenu` */

DROP TABLE IF EXISTS `sys_titlemenu`;

CREATE TABLE `sys_titlemenu` (
  `tid` int(32) NOT NULL AUTO_INCREMENT,
  `tname` varchar(32) DEFAULT NULL,
  `hid` int(32) DEFAULT NULL,
  `address` varchar(64) DEFAULT NULL,
  `tnameEng` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  KEY `FK_titlemenu` (`hid`),
  CONSTRAINT `FK_titlemenu` FOREIGN KEY (`hid`) REFERENCES `sys_headmenu` (`hid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `sys_titlemenu` */

insert  into `sys_titlemenu`(`tid`,`tname`,`hid`,`address`,`tnameEng`) values (1,'教学周报',1,'teachReport.jsp','tweekly'),(2,'周考统计',1,'weeklyExam.jsp','weeklyExam'),(3,'班级管理',2,'classesManage.jsp','classesManage'),(4,'学生管理',2,'studentManage.jsp','studentMange'),(5,'教务周报',2,'educationalManager.jsp',NULL),(6,'口碑统计',2,'#',NULL),(7,'正在就业班级',3,'#',NULL),(8,'待就业班级',3,'#',NULL),(9,'已就业班级',3,'#',NULL),(10,'角色管理',4,'#',NULL),(11,'权限管理',4,'#',NULL),(12,'用户管理',4,'#',NULL),(13,'菜单管理',4,'menu.jsp','menuManger'),(14,'测试1',6,'#',NULL),(15,'测试2',7,'#',NULL),(16,'ceshi1',7,'ceshi',NULL),(17,'erfe',NULL,'werq3we',NULL),(19,'123124',1,'',NULL),(20,'大所发生的',1,'',NULL),(21,'周考统计12',11,'',NULL);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(8) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `age` int(8) DEFAULT NULL,
  `gender` varchar(8) DEFAULT NULL,
  `position` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`name`,`password`,`age`,`gender`,`position`) values (1,'张三','123456',23,'男','项目经理'),(2,'李四','123456',22,'男','教师'),(3,'小红','123456',20,'女','班主任'),(4,'4','4',4,'4','4'),(6,'6','6',6,'6','6'),(7,'7','7',7,'7','7'),(8,'8','8',8,'8','8'),(9,'9','9',9,'9','9'),(10,'10','10',10,'10','10'),(11,'11','11',11,'11','11');

/*Table structure for table `tb_classes` */

DROP TABLE IF EXISTS `tb_classes`;

CREATE TABLE `tb_classes` (
  `classId` varchar(32) NOT NULL COMMENT '班级Id',
  `className` varchar(50) DEFAULT NULL COMMENT '班级名称',
  `classOpenTime` datetime DEFAULT NULL COMMENT '班级创建时间',
  `classStuNum` int(4) DEFAULT NULL COMMENT '班级学生人数',
  `classManagerId` varchar(32) DEFAULT NULL COMMENT '班主任id',
  `classCategoryId` varchar(32) DEFAULT NULL COMMENT '班级类型',
  `classDesc` varchar(300) DEFAULT NULL COMMENT '班级描述',
  `classQuality` varchar(4) DEFAULT NULL COMMENT '班级质量（优良及差）',
  `jobDireTeacId` varchar(32) DEFAULT NULL COMMENT '就业指导老师',
  `classMonitorId` varchar(32) DEFAULT NULL COMMENT '班长Id',
  `classTeacId` varchar(10) DEFAULT NULL COMMENT '授课老师Id',
  `classTaecLevelId` varchar(32) DEFAULT NULL COMMENT '班级授课等级Id',
  `isFace` int(1) DEFAULT NULL COMMENT '是否面授',
  `classEndTime` datetime DEFAULT NULL COMMENT '班级结课时间',
  `courseId` varchar(16) DEFAULT NULL COMMENT '班级所学课程',
  PRIMARY KEY (`classId`),
  UNIQUE KEY `className` (`className`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='班级表';

/*Data for the table `tb_classes` */

insert  into `tb_classes`(`classId`,`className`,`classOpenTime`,`classStuNum`,`classManagerId`,`classCategoryId`,`classDesc`,`classQuality`,`jobDireTeacId`,`classMonitorId`,`classTeacId`,`classTaecLevelId`,`isFace`,`classEndTime`,`courseId`) values ('1','java一班','2016-12-01 08:30:00',33,'1','社招','好','优','1','1','2','1',0,'2017-01-01 00:00:00','1'),('2','java二班','2016-12-01 08:30:00',23,'1','社招','棒','良','1','4','3','2',1,NULL,'2'),('3','web一班','2016-11-10 00:00:00',26,'2','社招','很好','1','2','1','1','1',0,NULL,'3'),('4','java四班','2016-11-14 00:00:00',31,'0','社招','','良','2','0','1','2',0,NULL,'2'),('5','java五班','2016-12-12 00:00:00',NULL,'0','','','','0','0','0','0',0,NULL,NULL);

/*Table structure for table `tb_classmanager` */

DROP TABLE IF EXISTS `tb_classmanager`;

CREATE TABLE `tb_classmanager` (
  `classManagerId` varchar(32) NOT NULL COMMENT '班主任id',
  `classManagerName` varchar(32) DEFAULT NULL COMMENT '班主任姓名',
  `classManagerSex` varchar(16) DEFAULT NULL COMMENT '班主任性别',
  `classManagerAge` varchar(16) DEFAULT NULL COMMENT '班主任年龄',
  `classManagePhone` varchar(16) DEFAULT NULL COMMENT '班主任电话',
  `leadClassId` varchar(16) DEFAULT NULL COMMENT '所带班级的id',
  PRIMARY KEY (`classManagerId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `tb_classmanager` */

insert  into `tb_classmanager`(`classManagerId`,`classManagerName`,`classManagerSex`,`classManagerAge`,`classManagePhone`,`leadClassId`) values ('0','',NULL,NULL,NULL,NULL),('1','朱玲凤','女',NULL,NULL,'1'),('2','祝友菲','女',NULL,NULL,NULL);

/*Table structure for table `tb_educational` */

DROP TABLE IF EXISTS `tb_educational`;

CREATE TABLE `tb_educational` (
  `eduId` varchar(32) NOT NULL COMMENT '教务表Id',
  `classId` varchar(32) DEFAULT NULL COMMENT '班级ID',
  `eduDesciption` varchar(500) DEFAULT NULL COMMENT '班级描述',
  `problemsReport` varchar(500) DEFAULT NULL COMMENT '问题学员描述',
  `EducationReport` varchar(500) DEFAULT NULL COMMENT '反馈教学问题',
  `classActivity` varchar(500) DEFAULT NULL COMMENT '班级活动',
  `praiseReport` varchar(500) DEFAULT NULL COMMENT '口碑情况',
  `educationalTimeId` varchar(32) DEFAULT NULL COMMENT '周报时间',
  `stuLeaveNum` int(10) DEFAULT NULL COMMENT '请假学员数量',
  `stuTruant` int(10) DEFAULT NULL COMMENT '旷课学员数量',
  `stuAbnormal` int(10) DEFAULT NULL COMMENT '异动学员数量',
  PRIMARY KEY (`eduId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `tb_educational` */

insert  into `tb_educational`(`eduId`,`classId`,`eduDesciption`,`problemsReport`,`EducationReport`,`classActivity`,`praiseReport`,`educationalTimeId`,`stuLeaveNum`,`stuTruant`,`stuAbnormal`) values ('1','1','UIWEB班学员反馈有些知识点老师讲解的不够细致，希望老师讲的细致点。Java四班有几名学员询问之后的课程是否会上Android，担心不上Android，也怕课程时间紧张，已告知学生了。','没什么问题','UIWEB班学员反馈有些知识点老师讲解的不够细致，希望老师讲的细致点。Java四班有几名学员询问之后的课程是否会上Android，担心不上Android，也怕课程时间紧张，已告知学生了。','WEB2班网页设计大赛','口碑1人，JAVA5班汪雅升介绍胡金文报名JAVA5班','1',2,1,0),('2','2','good','no','ssssssssssssssssssssss','ssssssssssssssss','ssssssssssssssss','2',2,3,2),('3','3','3333','3333','33333','33333','33333','3',3,3,3);

/*Table structure for table `tb_educationaltime` */

DROP TABLE IF EXISTS `tb_educationaltime`;

CREATE TABLE `tb_educationaltime` (
  `educationalTimeId` varchar(32) NOT NULL,
  `educationalYear` varchar(4) DEFAULT NULL,
  `educationalMonth` varchar(2) DEFAULT NULL,
  `educationalDay` varchar(2) DEFAULT NULL,
  `educationalTime` datetime DEFAULT NULL,
  `eduId` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`educationalTimeId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `tb_educationaltime` */

insert  into `tb_educationaltime`(`educationalTimeId`,`educationalYear`,`educationalMonth`,`educationalDay`,`educationalTime`,`eduId`) values ('1','2016','12','一','2016-12-01 16:12:00','1'),('2','2016','12','二','2016-12-10 16:12:00','1'),('3','2016','11','二','2016-11-07 11:12:00','2'),('4','2016','11','三','2016-11-12 11:12:00','3'),('5','2016','11','四','2016-11-29 11:11:00','3');

/*Table structure for table `tb_exam` */

DROP TABLE IF EXISTS `tb_exam`;

CREATE TABLE `tb_exam` (
  `examId` int(32) NOT NULL AUTO_INCREMENT COMMENT '考试id',
  `examName` varchar(32) DEFAULT NULL COMMENT '考试名称',
  `examClass` varchar(32) DEFAULT NULL COMMENT '考试班级编号',
  `startTime` datetime DEFAULT NULL COMMENT '开考时间',
  `endTime` datetime DEFAULT NULL COMMENT '结束时间',
  `examStuNum` int(32) DEFAULT NULL COMMENT '参加考试人数',
  `createUserId` int(32) DEFAULT NULL COMMENT '创建人id',
  `createUserName` varbinary(32) DEFAULT NULL COMMENT '创建人姓名',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `attentionItem` varchar(32) DEFAULT NULL COMMENT '注意事项',
  `highRate` double DEFAULT NULL COMMENT '高分比',
  `lowRate` double DEFAULT NULL COMMENT '低分比例',
  `mediumRate` double DEFAULT NULL COMMENT '中分比',
  `weeklyTimeId` varchar(32) DEFAULT NULL COMMENT '周考时间编号',
  PRIMARY KEY (`examId`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tb_exam` */

insert  into `tb_exam`(`examId`,`examName`,`examClass`,`startTime`,`endTime`,`examStuNum`,`createUserId`,`createUserName`,`createDate`,`attentionItem`,`highRate`,`lowRate`,`mediumRate`,`weeklyTimeId`) values (1,'java第一周周考','1',NULL,NULL,22,NULL,NULL,NULL,NULL,30,10,60,'1'),(2,'java阶段考试','1',NULL,NULL,18,NULL,NULL,NULL,NULL,20,30,50,'3'),(3,'web前端周考','3',NULL,NULL,19,NULL,NULL,NULL,NULL,15,15,70,'6'),(4,'java第二周周考','1',NULL,NULL,21,NULL,NULL,NULL,NULL,30,20,50,'2'),(5,'java第一周周考','2',NULL,NULL,20,NULL,NULL,NULL,NULL,30,20,50,'4'),(6,'java第二周周考','2',NULL,NULL,21,NULL,NULL,NULL,NULL,25,20,55,'5'),(7,'java预科考试','1',NULL,NULL,22,NULL,NULL,NULL,NULL,10,30,60,'7'),(8,'2345','1',NULL,NULL,23,NULL,NULL,NULL,NULL,20,12,45,'8');

/*Table structure for table `tb_jobdireteacher` */

DROP TABLE IF EXISTS `tb_jobdireteacher`;

CREATE TABLE `tb_jobdireteacher` (
  `jobTeacherId` varchar(32) NOT NULL COMMENT '就业指导教师序号',
  `jobTeaName` varchar(32) DEFAULT NULL COMMENT '就业指导教师姓名',
  PRIMARY KEY (`jobTeacherId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `tb_jobdireteacher` */

insert  into `tb_jobdireteacher`(`jobTeacherId`,`jobTeaName`) values ('1','小王'),('2','小李'),('0',NULL);

/*Table structure for table `tb_score` */

DROP TABLE IF EXISTS `tb_score`;

CREATE TABLE `tb_score` (
  `scoreId` int(32) NOT NULL AUTO_INCREMENT COMMENT '分数序号',
  `stuIdCard` varchar(32) DEFAULT NULL COMMENT '学生身份证号',
  `stuName` varchar(32) DEFAULT NULL COMMENT '学生姓名',
  `score` double DEFAULT NULL COMMENT '分数',
  `classGradeId` varchar(32) DEFAULT NULL COMMENT '班级id',
  `examCourseId` varchar(32) DEFAULT NULL COMMENT '课程ID',
  `examId` int(32) DEFAULT NULL COMMENT '考试id',
  PRIMARY KEY (`scoreId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `tb_score` */

/*Table structure for table `tb_status_abnormal` */

DROP TABLE IF EXISTS `tb_status_abnormal`;

CREATE TABLE `tb_status_abnormal` (
  `abnormalId` varchar(32) NOT NULL COMMENT '学生异动表主键',
  `sid` varchar(32) DEFAULT NULL COMMENT '学生主键',
  `abnormalDesc` varchar(200) DEFAULT NULL COMMENT '异动描述',
  `abnormalLevel` int(2) DEFAULT NULL COMMENT '异动等级 范围值（1-10），等级越高异动影响越大',
  `abnormalTime` datetime DEFAULT NULL COMMENT '异动时间',
  `abnormalPerson` varchar(32) DEFAULT NULL COMMENT '异动处理人',
  PRIMARY KEY (`abnormalId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `tb_status_abnormal` */

/*Table structure for table `tb_status_stuleave` */

DROP TABLE IF EXISTS `tb_status_stuleave`;

CREATE TABLE `tb_status_stuleave` (
  `leaveId` varchar(32) NOT NULL,
  `sid` varchar(32) DEFAULT NULL COMMENT '学员ID',
  `askingLeave` double DEFAULT NULL COMMENT '请假天数',
  `isAgree` int(1) DEFAULT NULL COMMENT '0代表不同意，1代表已经同意',
  `agreePerson` varchar(32) DEFAULT NULL COMMENT '审批人',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `leaveStartTime` datetime DEFAULT NULL COMMENT '请假开始时间',
  `leaveEndTime` datetime DEFAULT NULL COMMENT '请假结束时间',
  `leaveApplyTime` datetime DEFAULT NULL COMMENT '请假申请时间',
  PRIMARY KEY (`leaveId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `tb_status_stuleave` */

insert  into `tb_status_stuleave`(`leaveId`,`sid`,`askingLeave`,`isAgree`,`agreePerson`,`remark`,`leaveStartTime`,`leaveEndTime`,`leaveApplyTime`) values ('1','1',4,0,'1','ghgj',NULL,NULL,NULL),('2','4',2,0,'1','erewrw',NULL,NULL,NULL),('3','5',2,0,'1','sdfdsfsdf',NULL,NULL,NULL);

/*Table structure for table `tb_status_stutruant` */

DROP TABLE IF EXISTS `tb_status_stutruant`;

CREATE TABLE `tb_status_stutruant` (
  `truantId` varchar(32) NOT NULL COMMENT '旷课表主键',
  `sid` varchar(32) DEFAULT NULL COMMENT '学生id',
  `truantStartTime` datetime DEFAULT NULL COMMENT '旷课开始时间',
  `truantEndTime` datetime DEFAULT NULL COMMENT '旷课结束时间',
  `reportPerson` varchar(10) DEFAULT NULL COMMENT '记录人',
  `reportTime` datetime DEFAULT NULL COMMENT '记录时间',
  PRIMARY KEY (`truantId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `tb_status_stutruant` */

/*Table structure for table `tb_student` */

DROP TABLE IF EXISTS `tb_student`;

CREATE TABLE `tb_student` (
  `stuId` varchar(32) NOT NULL COMMENT '学生id',
  `stuName` varchar(20) DEFAULT NULL COMMENT '学生姓名',
  `stuAge` int(11) DEFAULT NULL COMMENT '年龄',
  `stuSex` varchar(2) DEFAULT NULL COMMENT '性别',
  `borthDate` date DEFAULT NULL COMMENT '出生日期',
  `idNum` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `addr` varchar(200) DEFAULT NULL COMMENT '地址',
  `classId` varchar(32) DEFAULT NULL COMMENT '班级 id',
  `createDate` datetime DEFAULT NULL COMMENT '创建日期',
  `emerConPerson` varchar(20) DEFAULT NULL COMMENT '紧急联系人',
  `emerConPhone` varchar(11) DEFAULT NULL COMMENT '紧急联系电话',
  `password` varchar(50) DEFAULT NULL COMMENT '登陆密码',
  `stuNum` varchar(30) DEFAULT NULL COMMENT '学号',
  `status` int(11) DEFAULT '0' COMMENT '删除状态 1 表示删除',
  `entranceDate` date DEFAULT NULL COMMENT '入学时间',
  `graduationDate` date DEFAULT NULL COMMENT '毕业时间',
  `nativePlace` varchar(20) DEFAULT NULL COMMENT '籍贯',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `communityId` varchar(32) DEFAULT NULL,
  `createUserName` varchar(20) DEFAULT NULL COMMENT '创建人姓名',
  `createUserId` varchar(32) DEFAULT NULL COMMENT '创建人Id',
  `deleteUserId` varchar(32) DEFAULT NULL COMMENT '删除人id',
  PRIMARY KEY (`stuId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `tb_student` */

insert  into `tb_student`(`stuId`,`stuName`,`stuAge`,`stuSex`,`borthDate`,`idNum`,`phone`,`addr`,`classId`,`createDate`,`emerConPerson`,`emerConPhone`,`password`,`stuNum`,`status`,`entranceDate`,`graduationDate`,`nativePlace`,`email`,`communityId`,`createUserName`,`createUserId`,`deleteUserId`) values ('1','张三',23,'女',NULL,'1',NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0'),('4','赵六',16,'男',NULL,'342601',NULL,NULL,'2',NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0'),('5','韦小宝',20,'男',NULL,'342601',NULL,NULL,'2',NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0'),('6','张欢',21,'男',NULL,'342601',NULL,NULL,'3',NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0'),('7','王丽丽',22,'女',NULL,'342601',NULL,NULL,'3',NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0'),('0','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `tb_teachschedule` */

DROP TABLE IF EXISTS `tb_teachschedule`;

CREATE TABLE `tb_teachschedule` (
  `teachScheduleId` varchar(16) NOT NULL COMMENT '授课进度ID',
  `courseId` varchar(16) DEFAULT NULL COMMENT '课程序号',
  `courseContent` varchar(16) DEFAULT NULL COMMENT '课程内容',
  `courseRate` varchar(16) DEFAULT NULL COMMENT '课程进度%',
  PRIMARY KEY (`teachScheduleId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `tb_teachschedule` */

insert  into `tb_teachschedule`(`teachScheduleId`,`courseId`,`courseContent`,`courseRate`) values ('1','1','java基础','20%'),('2','2','web基础','20%'),('0',NULL,'',NULL);

/*Table structure for table `tb_weeklyexam` */

DROP TABLE IF EXISTS `tb_weeklyexam`;

CREATE TABLE `tb_weeklyexam` (
  `weeklyExamId` varchar(32) NOT NULL COMMENT '周考编号',
  `weeklyExamScore` double DEFAULT NULL COMMENT '周考成绩',
  `stuId` varchar(32) DEFAULT NULL COMMENT '学生编号',
  `weeklyTimeId` varchar(32) DEFAULT NULL COMMENT '周考时间编号',
  PRIMARY KEY (`weeklyExamId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `tb_weeklyexam` */

insert  into `tb_weeklyexam`(`weeklyExamId`,`weeklyExamScore`,`stuId`,`weeklyTimeId`) values ('1',32,'1','1'),('2',70,'2','1'),('3',85,'3','1'),('4',72,'1','2'),('5',89,'2','2'),('6',67,'3','2'),('7',90,'4','4'),('8',88,'5','4'),('9',98,'1','3'),('10',96,'2','3'),('11',77,'4','8'),('12',88,'5','5'),('13',78,'6','6'),('14',75,'7','6'),('15',94,'1','8'),('16',90,'2','7');

/*Table structure for table `tb_weeklytime` */

DROP TABLE IF EXISTS `tb_weeklytime`;

CREATE TABLE `tb_weeklytime` (
  `weeklyTimeId` varchar(32) NOT NULL COMMENT '周考编号',
  `weeklyYear` varchar(4) DEFAULT NULL COMMENT '周考年份',
  `weeklyMonth` varchar(2) DEFAULT NULL COMMENT '周考月份',
  `weeklyDay` varchar(2) DEFAULT NULL COMMENT '周考为当月第几周',
  `weeklyTime` datetime DEFAULT NULL COMMENT '周考精确时间',
  `classId` varchar(32) DEFAULT NULL COMMENT '周考班级编号',
  PRIMARY KEY (`weeklyTimeId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `tb_weeklytime` */

insert  into `tb_weeklytime`(`weeklyTimeId`,`weeklyYear`,`weeklyMonth`,`weeklyDay`,`weeklyTime`,`classId`) values ('1','2016','12','一','2016-12-01 16:12:00','3'),('2','2016','12','二','2016-12-06 16:18:00','1'),('3','2017','01','三','2017-01-15 14:10:00','1'),('4','2016','11','一','2016-11-02 14:00:00','2'),('5','2016','12','二','2016-12-07 14:00:11','2'),('6','2016','12','一','2016-12-01 14:00:10','3'),('7','2016','11','一','2016-11-02 16:12:11','1'),('8','2017','01','一','2017-01-02 12:13:12','1');

/*Table structure for table `tb_workexperience` */

DROP TABLE IF EXISTS `tb_workexperience`;

CREATE TABLE `tb_workexperience` (
  `workExperienceId` varchar(32) NOT NULL COMMENT '工作经历id',
  `companyName` varchar(16) DEFAULT NULL COMMENT '公司名称',
  `industry` varchar(16) DEFAULT NULL COMMENT '行业',
  `position` varchar(16) DEFAULT NULL COMMENT '职位',
  `workSeniority` varchar(16) DEFAULT NULL COMMENT '工作年限',
  `salaryRange` varchar(16) DEFAULT NULL COMMENT '薪资范围',
  `stuId` varchar(16) DEFAULT NULL COMMENT '学生号',
  PRIMARY KEY (`workExperienceId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `tb_workexperience` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
