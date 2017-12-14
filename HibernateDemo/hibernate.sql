/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50632
Source Host           : localhost:3306
Source Database       : hibernate

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2017-12-14 16:36:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `table_role`
-- ----------------------------
DROP TABLE IF EXISTS `table_role`;
CREATE TABLE `table_role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(255) DEFAULT NULL,
  `rmemo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table_role
-- ----------------------------
INSERT INTO `table_role` VALUES ('4', '学生', '学生');
INSERT INTO `table_role` VALUES ('5', '教师', '教师');
INSERT INTO `table_role` VALUES ('6', '校长', '校长');

-- ----------------------------
-- Table structure for `table_user`
-- ----------------------------
DROP TABLE IF EXISTS `table_user`;
CREATE TABLE `table_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table_user
-- ----------------------------
INSERT INTO `table_user` VALUES ('1', 'Mary', '1236');
INSERT INTO `table_user` VALUES ('3', 'Alice', '123');
INSERT INTO `table_user` VALUES ('4', 'Bob', '456');

-- ----------------------------
-- Table structure for `t_customer`
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  `clevel` varchar(255) DEFAULT NULL,
  `cphone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('1', '童话镇', 'VIP', '123456');
INSERT INTO `t_customer` VALUES ('2', 'Tongx', 'VIP', '1');
INSERT INTO `t_customer` VALUES ('3', '童心眠', 'VIP', '123456');

-- ----------------------------
-- Table structure for `t_linkman`
-- ----------------------------
DROP TABLE IF EXISTS `t_linkman`;
CREATE TABLE `t_linkman` (
  `link_id` int(11) NOT NULL AUTO_INCREMENT,
  `link_name` varchar(255) DEFAULT NULL,
  `link_phone` varchar(255) DEFAULT NULL,
  `link_gender` varchar(255) DEFAULT NULL,
  `clid` int(11) DEFAULT NULL,
  PRIMARY KEY (`link_id`),
  KEY `FKjtgu0oocf35ij4fmulu123vwk` (`clid`),
  CONSTRAINT `FKjtgu0oocf35ij4fmulu123vwk` FOREIGN KEY (`clid`) REFERENCES `t_customer` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_linkman
-- ----------------------------
INSERT INTO `t_linkman` VALUES ('1', 'Alice', '654312', '女', '1');
INSERT INTO `t_linkman` VALUES ('2', 'Bob', 'fe', '男', null);
INSERT INTO `t_linkman` VALUES ('3', 'Tongx', '654312', '男', '3');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('2', 'Tonghuazhen', '123', 'zhuzhou');
INSERT INTO `t_user` VALUES ('3', '童心眠', '123', 'zhuzhou');
INSERT INTO `t_user` VALUES ('4', '童话镇', '123', 'zhuzhou');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`rid`,`uid`),
  KEY `FK8xxu4kvfyg5pi1r90dppsbs64` (`uid`),
  CONSTRAINT `FK8xxu4kvfyg5pi1r90dppsbs64` FOREIGN KEY (`uid`) REFERENCES `table_user` (`uid`),
  CONSTRAINT `FKl7x9dfjb9f99hiasr2yiumkty` FOREIGN KEY (`rid`) REFERENCES `table_role` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('3', '4');
INSERT INTO `user_role` VALUES ('3', '5');
INSERT INTO `user_role` VALUES ('4', '4');
INSERT INTO `user_role` VALUES ('4', '6');
