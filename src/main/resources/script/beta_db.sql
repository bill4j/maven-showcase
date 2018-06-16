/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : beta_db

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-06-16 16:55:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(32) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `emailAddress` varchar(255) DEFAULT NULL,
  `dateOfBirth` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'santoshbs1', 'Santosh', 'B S', 'Test123', 'santosh.bse@gmail.com', '2018-06-16 15:17:08');
INSERT INTO `student` VALUES ('2', 'bill', '&#25105;&#19981;&#21578;&#35785;&#20320;', 'wbgsn', 'wbgsn', 'bill@yongyou.com', '2018-06-16 15:28:43');
