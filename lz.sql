/*
Navicat MySQL Data Transfer

Source Server         : lp
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : lz

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2018-05-06 11:36:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_id` int(11) DEFAULT NULL,
  `staff_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `grade` int(11) DEFAULT '1' COMMENT '第一级是基本的，只要有账号就有；第二级是各个部门的普通员工，拥有该部门的基本权限，第三级是部门主管，拥有部门主管的权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '1', 'jack', '1', '2');
INSERT INTO `account` VALUES ('2', '2', 'tom', '2', '3');
INSERT INTO `account` VALUES ('3', '3', 'mary', '3', '2');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `staff_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='部门表							\r\ndept							\r\nid	char(32)	uuid					\r\nname	vachar						\r\nstaff_id	char(32)	uuid	manager				\r\nwork_time	time						\r\nend_time	time						\r\n';

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '生产部        ', null);
INSERT INTO `dept` VALUES ('2', '工艺部', null);
INSERT INTO `dept` VALUES ('3', '计划部', '3');
INSERT INTO `dept` VALUES ('4', '质检部', null);
INSERT INTO `dept` VALUES ('5', '人事部', '2');
INSERT INTO `dept` VALUES ('6', '管理部', '1');

-- ----------------------------
-- Table structure for facility
-- ----------------------------
DROP TABLE IF EXISTS `facility`;
CREATE TABLE `facility` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='设备表\r\n';

-- ----------------------------
-- Records of facility
-- ----------------------------
INSERT INTO `facility` VALUES ('1', '数控车床', null, null);

-- ----------------------------
-- Table structure for facility_trouble
-- ----------------------------
DROP TABLE IF EXISTS `facility_trouble`;
CREATE TABLE `facility_trouble` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `facility_id` int(32) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `staff_id` int(32) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of facility_trouble
-- ----------------------------

-- ----------------------------
-- Table structure for manufacture
-- ----------------------------
DROP TABLE IF EXISTS `manufacture`;
CREATE TABLE `manufacture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state` varchar(255) DEFAULT NULL,
  `plan_staff_id` int(11) DEFAULT NULL,
  `plan_detail_id` int(11) DEFAULT NULL,
  `plan_start_time` datetime DEFAULT NULL,
  `plan_end_time` datetime DEFAULT NULL,
  `part_technology_id` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `work_staff_id` int(11) DEFAULT NULL,
  `facility` int(11) DEFAULT NULL,
  `reality_time` datetime DEFAULT NULL,
  `check_staff_id` int(11) DEFAULT NULL,
  `qualified_num` int(11) DEFAULT NULL,
  `unqualified_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manufacture
-- ----------------------------

-- ----------------------------
-- Table structure for part
-- ----------------------------
DROP TABLE IF EXISTS `part`;
CREATE TABLE `part` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `darwing` varchar(255) DEFAULT NULL,
  `tested` varchar(255) DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of part
-- ----------------------------

-- ----------------------------
-- Table structure for part_technology
-- ----------------------------
DROP TABLE IF EXISTS `part_technology`;
CREATE TABLE `part_technology` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `part_id` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `drawing` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of part_technology
-- ----------------------------

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state` varchar(255) DEFAULT NULL,
  `create_staff_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `plan_end` date DEFAULT NULL,
  `reality_time` datetime DEFAULT NULL,
  `plan_staff_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------

-- ----------------------------
-- Table structure for plan_detail
-- ----------------------------
DROP TABLE IF EXISTS `plan_detail`;
CREATE TABLE `plan_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `part_id` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `plan_id` int(11) DEFAULT NULL,
  `qualified_num` int(11) DEFAULT NULL,
  `unqualified_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan_detail
-- ----------------------------

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `join_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='人力资源管理						\r\n						\r\nstaff						\r\nid	char(32)	uuid				\r\nname	vachar					\r\nsex	char(1)		只能是男或女			\r\nnum	int	员工号	唯一			\r\naddress	vachar					\r\nstate	int		1	2	3	\r\nbirthday	date		入职	在职	离职	\r\ndept_id	char(32)	uuid				\r\njoindate	date		入职日期			\r\n';

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', 'jack', '男', '12345678910', '12@12.com', '哈尔滨', '在职', '2018-01-19', '6', '文员', '2017-11-16');
INSERT INTO `staff` VALUES ('2', 'tom', '男', '手机号', '123456@123.com', '地址', '在职', '2016-12-20', '5', '文员', '2017-12-28');
INSERT INTO `staff` VALUES ('3', 'mary', '女', '手机号', 'mary—email', 'mary地址', '离职', '2018-05-08', '3', '计划分配员', '2018-05-08');
