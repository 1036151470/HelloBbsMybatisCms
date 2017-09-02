/*
Navicat MySQL Data Transfer

Source Server         : forliu
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : forliu

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-02 14:32:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bbs_forlink
-- ----------------------------
DROP TABLE IF EXISTS `bbs_forlink`;
CREATE TABLE `bbs_forlink` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pics` text,
  `adress` text,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
