/*
Navicat MySQL Data Transfer

Source Server         : vue
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : myhome

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2018-11-25 11:16:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answers
-- ----------------------------
DROP TABLE IF EXISTS `answers`;
CREATE TABLE `answers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer_content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `answer_status` tinyint(2) DEFAULT NULL,
  `answer_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of answers
-- ----------------------------
INSERT INTO `answers` VALUES ('1', '大概1个月', '2', null, null, '11');
INSERT INTO `answers` VALUES ('2', '各种费用', '1', null, null, '33');
INSERT INTO `answers` VALUES ('3', '阿斯蒂芬', '1', null, null, '12');
INSERT INTO `answers` VALUES ('4', 'asdfasdf', '2', null, null, '22');

-- ----------------------------
-- Table structure for chatinfos
-- ----------------------------
DROP TABLE IF EXISTS `chatinfos`;
CREATE TABLE `chatinfos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_user` int(11) DEFAULT NULL,
  `to_user` int(11) DEFAULT NULL,
  `chat_time` bigint(13) DEFAULT NULL,
  `chat_msg` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `info_type` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of chatinfos
-- ----------------------------
INSERT INTO `chatinfos` VALUES ('1', '1', '4', '1531045313395', '123123阿斯顿发生阿斯顿发斯蒂芬', null);
INSERT INTO `chatinfos` VALUES ('2', '4', '1', '1531045313395', '2332423', null);
INSERT INTO `chatinfos` VALUES ('3', '1', '3', '1531045313395', '12213123', null);
INSERT INTO `chatinfos` VALUES ('4', '1', '3', '1531045313395', '12', null);
INSERT INTO `chatinfos` VALUES ('5', '1', '3', '1531045313395', '12', null);
INSERT INTO `chatinfos` VALUES ('6', '1', '3', '1531045313395', '1212', null);
INSERT INTO `chatinfos` VALUES ('7', '1', '5', '1531045313395', '21', null);
INSERT INTO `chatinfos` VALUES ('8', '1', '5', '1531045313395', '21', null);
INSERT INTO `chatinfos` VALUES ('9', '1', '5', '1531045313395', '21', null);
INSERT INTO `chatinfos` VALUES ('10', '1', '5', '1531045313395', '21', null);
INSERT INTO `chatinfos` VALUES ('11', '1', '4', '1531045313395', 'asdfasdf', null);
INSERT INTO `chatinfos` VALUES ('12', '1', '4', '1531045313395', 'asdfasdf', null);
INSERT INTO `chatinfos` VALUES ('13', '4', '1', '1531045313395', 'qqqqqqqqqqqqqqq', null);
INSERT INTO `chatinfos` VALUES ('14', '4', '1', '1531045313395', 'qqqqqqqqqqqqqqq', null);
INSERT INTO `chatinfos` VALUES ('15', '1', '4', '1531045313395', 'asdfasdf', null);
INSERT INTO `chatinfos` VALUES ('16', '4', '1', '1531045325852', 'qqqqqqqqqqqqqqq', null);
INSERT INTO `chatinfos` VALUES ('17', '4', '1', '1531045370933', '111111111111111111111111111', null);
INSERT INTO `chatinfos` VALUES ('18', '1', '4', '1531045556105', 'ddddd', null);
INSERT INTO `chatinfos` VALUES ('19', '1', '4', '1531045661187', 'ddddd', null);
INSERT INTO `chatinfos` VALUES ('20', '4', '1', '1531046801236', 'ffffffffffff', null);
INSERT INTO `chatinfos` VALUES ('21', '1', '4', '1531046808033', 'qqqqqqqqqqq', null);
INSERT INTO `chatinfos` VALUES ('22', '1', '4', '1531046885117', 'qqqqqqqqqqq', null);
INSERT INTO `chatinfos` VALUES ('23', '4', '1', '1531046894848', 'ffffffffffff', null);
INSERT INTO `chatinfos` VALUES ('24', '1', '4', '1531046914735', 'qqqqqqqqqqq', null);
INSERT INTO `chatinfos` VALUES ('25', '4', '1', '1531046939552', 'ffffffffffff', null);
INSERT INTO `chatinfos` VALUES ('26', '4', '1', '1531047011310', 'xxxxxxxxxxxx', null);
INSERT INTO `chatinfos` VALUES ('27', '1', '4', '1531048063180', 'ff', null);
INSERT INTO `chatinfos` VALUES ('28', '4', '1', '1531048083611', 'cc', null);
INSERT INTO `chatinfos` VALUES ('29', '1', '4', '1531048211102', 'qq', null);
INSERT INTO `chatinfos` VALUES ('30', '4', '1', '1531048221818', 'zzzzz', null);
INSERT INTO `chatinfos` VALUES ('31', '1', '4', '1531048508556', '1123', null);
INSERT INTO `chatinfos` VALUES ('32', '1', '4', '1531048645638', 'q1', null);
INSERT INTO `chatinfos` VALUES ('33', '1', '4', '1531048716097', 'q2', null);
INSERT INTO `chatinfos` VALUES ('34', '1', '4', '1531051755172', '11', null);
INSERT INTO `chatinfos` VALUES ('35', '4', '1', '1531051882470', '123', null);
INSERT INTO `chatinfos` VALUES ('36', '1', '4', '1531051904051', '12333', null);
INSERT INTO `chatinfos` VALUES ('37', '1', '4', '1531052012222', 'asfdasd', null);
INSERT INTO `chatinfos` VALUES ('38', '4', '1', '1531052026630', 'asdfasdfsafasdf', null);
INSERT INTO `chatinfos` VALUES ('39', '1', '4', '1531052106458', 'aaaaaaaa', null);
INSERT INTO `chatinfos` VALUES ('40', '4', '1', '1531052223896', 'asdfasdf', null);
INSERT INTO `chatinfos` VALUES ('41', '1', '4', '1531052230472', 'asdfasdfs', null);
INSERT INTO `chatinfos` VALUES ('42', '1', '4', '1531052293531', 'asdfasdf', null);
INSERT INTO `chatinfos` VALUES ('43', '1', '4', '1531052463653', 'asdfasdf', null);
INSERT INTO `chatinfos` VALUES ('44', '4', '1', '1531052472240', '34', null);
INSERT INTO `chatinfos` VALUES ('45', '1', '4', '1531052483350', 'asdfasdfasdf', null);
INSERT INTO `chatinfos` VALUES ('46', '1', '4', '1531052551695', '11', null);
INSERT INTO `chatinfos` VALUES ('47', '4', '1', '1531052557989', '22', null);
INSERT INTO `chatinfos` VALUES ('48', '1', '4', '1531052567608', '33', null);
INSERT INTO `chatinfos` VALUES ('49', '4', '1', '1531052988841', '22ggggg', null);
INSERT INTO `chatinfos` VALUES ('50', '1', '4', '1531053000380', '3377777', null);
INSERT INTO `chatinfos` VALUES ('51', '4', '1', '1534671948813', 'adfasdfsadf', null);
INSERT INTO `chatinfos` VALUES ('52', '1', '4', '1534671981066', 'asdfasdfadsf', null);
INSERT INTO `chatinfos` VALUES ('53', '1', '4', '1534671985657', 'asdfasdfadsfasdfasdf', null);
INSERT INTO `chatinfos` VALUES ('54', '1', '4', '1534672132633', '你好', null);
INSERT INTO `chatinfos` VALUES ('55', '4', '1', '1534672157322', '你也好', null);
INSERT INTO `chatinfos` VALUES ('56', '1', '4', '1534672173177', '你更好', null);
INSERT INTO `chatinfos` VALUES ('57', '1', '4', '1534672204390', 'hello', null);
INSERT INTO `chatinfos` VALUES ('58', '1', '4', '1534749788241', '123', null);
INSERT INTO `chatinfos` VALUES ('59', '4', '1', '1534749800342', 'nihao', null);
INSERT INTO `chatinfos` VALUES ('60', '1', '4', '1534749915288', '1', null);
INSERT INTO `chatinfos` VALUES ('61', '4', '1', '1534750017542', '2', null);
INSERT INTO `chatinfos` VALUES ('62', '4', '1', '1534750095142', '123', null);
INSERT INTO `chatinfos` VALUES ('63', '1', '4', '1534750113016', '111', null);
INSERT INTO `chatinfos` VALUES ('64', '1', '4', '1534752091940', 'adsf', null);
INSERT INTO `chatinfos` VALUES ('65', '4', '1', '1534752107251', '111', null);
INSERT INTO `chatinfos` VALUES ('66', '1', '4', '1534752412046', '你好', null);
INSERT INTO `chatinfos` VALUES ('67', '4', '1', '1534752426778', '你也好', null);

-- ----------------------------
-- Table structure for homeimgs
-- ----------------------------
DROP TABLE IF EXISTS `homeimgs`;
CREATE TABLE `homeimgs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `home_id` int(11) DEFAULT NULL,
  `img_status` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of homeimgs
-- ----------------------------

-- ----------------------------
-- Table structure for homes
-- ----------------------------
DROP TABLE IF EXISTS `homes`;
CREATE TABLE `homes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `home_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `home_price` decimal(10,0) DEFAULT NULL,
  `home_desc` varchar(512) COLLATE utf8_bin DEFAULT NULL,
  `home_infos` varchar(512) COLLATE utf8_bin DEFAULT NULL,
  `home_type` tinyint(2) DEFAULT NULL,
  `home_tags` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `home_address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `home_status` tinyint(2) DEFAULT NULL,
  `home_time` bigint(13) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of homes
-- ----------------------------
INSERT INTO `homes` VALUES ('1', '安贞西里123', '4511', '72.32㎡/南 北/低楼层', null, '1', '海淀,昌平', null, null, null, '12');
INSERT INTO `homes` VALUES ('2', '安贞西里 三室一厅', '4533', '72.32㎡/南 北/低楼层', null, '1', '海淀', null, null, null, '1212');
INSERT INTO `homes` VALUES ('3', '安贞西里 三室一厅', '4220', '72.32㎡/南 北/低楼层', null, '2', '海淀', null, null, null, '1');
INSERT INTO `homes` VALUES ('4', '安贞西里 三室一厅', '4500', '72.32㎡/南 北/低楼层', '4500', '2', '海淀', '', null, null, '12');
INSERT INTO `homes` VALUES ('5', '安贞西里 三室一厅', '4522', '72.32㎡/南 北/低楼层', null, '3', '海淀', null, null, null, '23');
INSERT INTO `homes` VALUES ('6', '安贞西里 三室一厅', '4500', '72.32㎡/南 北/低楼层', null, '3', '海淀', null, null, null, '1221');
INSERT INTO `homes` VALUES ('7', '安贞西里 三室一厅', '4500', '72.32㎡/南 北/低楼层', null, '2', '海淀', null, null, null, '23');
INSERT INTO `homes` VALUES ('8', '安贞西里 三室一厅', '4500', '72.32㎡/南 北/低楼层', null, '1', '海淀', null, null, null, '23');
INSERT INTO `homes` VALUES ('9', '安贞西里 三室一厅', '4500', '72.32㎡/南 北/低楼层', null, '4', '海淀', null, null, null, '23');

-- ----------------------------
-- Table structure for informations
-- ----------------------------
DROP TABLE IF EXISTS `informations`;
CREATE TABLE `informations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `info_thumb` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `info_time` int(11) DEFAULT NULL,
  `info_content` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `info_status` tinyint(2) DEFAULT NULL,
  `info_type` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of informations
-- ----------------------------
INSERT INTO `informations` VALUES ('1', '房企半年销售业绩继', null, null, null, null, null, '1');
INSERT INTO `informations` VALUES ('2', '上半年土地市场两重天：一线降温三四线量价齐升', null, null, null, null, null, '1');
INSERT INTO `informations` VALUES ('3', '上半年土地市场两重天：一线降温三四线量价齐升', null, null, null, null, null, '1');
INSERT INTO `informations` VALUES ('4', '上半年土地市场两重天：一线降温三四线量价齐升', null, null, null, null, null, '1');
INSERT INTO `informations` VALUES ('5', '房企半年销售业绩继续冲高三巨头销售额过亿', null, null, null, null, null, '2');
INSERT INTO `informations` VALUES ('6', '房企半年销售业绩继续冲高三巨头销售额过亿', null, null, null, null, null, '2');
INSERT INTO `informations` VALUES ('7', '房企半年销售业绩继续冲高三巨头销售额过亿', null, null, null, null, null, '2');
INSERT INTO `informations` VALUES ('8', '房企半年销售业绩继续冲高三巨头销售额过亿', null, null, null, null, null, '3');
INSERT INTO `informations` VALUES ('9', '房企半年销售业绩继续冲高三巨头销售额过亿', null, null, null, null, null, '2');
INSERT INTO `informations` VALUES ('10', '房企半年销售业绩继续冲高三巨头销售额过亿', null, null, null, null, null, '1');
INSERT INTO `informations` VALUES ('11', '房企半年销售业绩继续冲高三巨头销售额过亿', null, null, null, null, null, '1');
INSERT INTO `informations` VALUES ('12', '房企半年销售业绩继', null, null, null, null, null, '1');
INSERT INTO `informations` VALUES ('13', 'wwwwwwwwwwwww', null, null, null, null, null, '1');
INSERT INTO `informations` VALUES ('14', '房企半年销售业绩继续冲高三巨头销售额过亿', null, null, null, null, null, '3');
INSERT INTO `informations` VALUES ('15', '房企半年销售业绩继续冲高三巨头销售额过亿', null, null, null, null, null, '3');

-- ----------------------------
-- Table structure for map
-- ----------------------------
DROP TABLE IF EXISTS `map`;
CREATE TABLE `map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `x` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `y` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of map
-- ----------------------------
INSERT INTO `map` VALUES ('1', '116.43244', '39.929986', '1');
INSERT INTO `map` VALUES ('2', '116.424355', '39.92982', '1');
INSERT INTO `map` VALUES ('3', '116.423349', '39.935214', '1');
INSERT INTO `map` VALUES ('4', '116.350444', '39.931645', '1');
INSERT INTO `map` VALUES ('5', '116.351684', '39.91867', '1');
INSERT INTO `map` VALUES ('6', '116.353983', '39.913855', '1');
INSERT INTO `map` VALUES ('7', '116.357253', '39.923152', '1');
INSERT INTO `map` VALUES ('8', '116.349168', '39.923152', '1');
INSERT INTO `map` VALUES ('9', '116.354954', '39.935767', '1');
INSERT INTO `map` VALUES ('10', '116.36232', '39.938339', '1');
INSERT INTO `map` VALUES ('11', '116.374249', '39.94625', '1');
INSERT INTO `map` VALUES ('12', '116.380178', '39.953053', '1');

-- ----------------------------
-- Table structure for menus
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `menu_logo` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `menu_path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `menu_status` tinyint(2) DEFAULT NULL,
  `menu_style` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of menus
-- ----------------------------
INSERT INTO `menus` VALUES ('1', '二手房', 'home', '/home', '1', null);
INSERT INTO `menus` VALUES ('2', '新房', null, null, null, null);
INSERT INTO `menus` VALUES ('3', '租房', null, null, null, null);
INSERT INTO `menus` VALUES ('4', '海外', null, null, null, null);
INSERT INTO `menus` VALUES ('5', '地图找房', null, null, null, null);
INSERT INTO `menus` VALUES ('6', '查公交', null, null, null, null);
INSERT INTO `menus` VALUES ('7', '计算器', null, null, null, null);
INSERT INTO `menus` VALUES ('8', '问答', null, null, null, null);

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `question_time` int(11) DEFAULT NULL,
  `question_tag` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of questions
-- ----------------------------
INSERT INTO `questions` VALUES ('1', '在北京买房，需要支付的税费有哪些？', '1', null, '学区,海淀');
INSERT INTO `questions` VALUES ('2', '一般首付之后，贷款多久可以下来？', '1', null, '学区,昌平');
INSERT INTO `questions` VALUES ('3', '按时发生', '1', null, '学区,昌平');
INSERT INTO `questions` VALUES ('4', 'asdfasdfasda', '4', '2147483647', '学区,昌平');
INSERT INTO `questions` VALUES ('5', 'asfsadfsaf', '4', '2147483647', '学区,昌平');
INSERT INTO `questions` VALUES ('6', 'sadsad', '4', '2147483647', '学区,昌平');
INSERT INTO `questions` VALUES ('7', 'adsfasdf', '1', '2147483647', null);
INSERT INTO `questions` VALUES ('8', 'afdasdfasdfadsf', '1', '2147483647', null);
INSERT INTO `questions` VALUES ('9', '你好', '1', '2147483647', null);
INSERT INTO `questions` VALUES ('10', 'asdfsdf', '1', '2147483647', null);

-- ----------------------------
-- Table structure for swipes
-- ----------------------------
DROP TABLE IF EXISTS `swipes`;
CREATE TABLE `swipes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `original_path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `thumbnail_path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of swipes
-- ----------------------------
INSERT INTO `swipes` VALUES ('1', 'public/1.png', 'pic-thumb1.png', null);
INSERT INTO `swipes` VALUES ('2', 'public/2.png', 'pic-thumb2.png', null);
INSERT INTO `swipes` VALUES ('3', 'public/3.png', 'pic-thumb3.png', null);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mobile` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `weixin` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_detail` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  `avatar` mediumtext COLLATE utf8_bin,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'tom', '123', '123', 'qqq', 'qqq', '111', null, null, 0x7075626C69632F69636F6E2E706E67);
INSERT INTO `users` VALUES ('2', 'jerry', '123', null, null, null, null, null, null, 0x7075626C69632F69636F6E2E706E67);
INSERT INTO `users` VALUES ('3', 'spike', '123', null, null, null, null, null, null, 0x7075626C69632F69636F6E2E706E67);
INSERT INTO `users` VALUES ('4', 'abc', '1234', null, null, null, null, null, null, 0x7075626C69632F69636F6E2E706E67);
INSERT INTO `users` VALUES ('5', 'asfdasdf', null, null, null, null, null, null, null, 0x7075626C69632F69636F6E2E706E67);
