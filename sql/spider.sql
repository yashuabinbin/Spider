/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : spider

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-04-27 10:00:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sp_seed
-- ----------------------------
DROP TABLE IF EXISTS `sp_seed`;
CREATE TABLE `sp_seed` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `url` varchar(255) NOT NULL COMMENT 'url地址',
  `create_uid` int(11) NOT NULL COMMENT '创建人id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_uid` int(11) DEFAULT NULL COMMENT '更新人id',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sp_seed
-- ----------------------------

-- ----------------------------
-- Table structure for sp_user
-- ----------------------------
DROP TABLE IF EXISTS `sp_user`;
CREATE TABLE `sp_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `username` varchar(30) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码(md5后的值)',
  `realname` varchar(20) DEFAULT NULL COMMENT '真名',
  `email` varchar(30) NOT NULL COMMENT '邮箱',
  `sex` tinyint(4) NOT NULL COMMENT '1-male, 2-female',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sp_user
-- ----------------------------
INSERT INTO `sp_user` VALUES ('1', 'admin', '21232F297A57A5A743894A0E4A801FC3', '陆炳彬', 'lubingbin@qq.com', '1', '2017-04-26 10:08:10');
