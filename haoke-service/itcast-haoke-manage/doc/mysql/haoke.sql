/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.100.134
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 192.168.100.134:3306
 Source Schema         : haoke

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 05/03/2022 22:49:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_estate
-- ----------------------------
DROP TABLE IF EXISTS `tb_estate`;
CREATE TABLE `tb_estate`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼盘名称',
  `province` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在省',
  `city` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在市',
  `area` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在区',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体地址',
  `year` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建筑年代',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建筑类型',
  `property_cost` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物业费',
  `property_company` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物业公司',
  `developers` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开发商',
  `created` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1006 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '楼盘表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_estate
-- ----------------------------
INSERT INTO `tb_estate` VALUES (1001, '中远两湾城', '上海市', '上海市', '普陀区', '远景路97弄', '2001', '塔楼/板楼', '1.5', '上海中远物业管理发展有限公司', '上海万业企业股份有限公司', '2018-11-06 23:00:20', '2018-11-06 23:00:23');
INSERT INTO `tb_estate` VALUES (1002, '上海康城', '上海市', '上海市', '闵行区', '莘松路958弄', '2001', '塔楼/板楼', '1.5', '盛孚物业', '闵行房地产', '2018-11-06 23:02:30', '2018-11-27 23:02:33');
INSERT INTO `tb_estate` VALUES (1003, '保利西子湾', '上海市', '上海市', '松江区', '广富林路1188弄', '2008', '塔楼/板楼', '1.75', '上海保利物业管理', '上海城乾房地产开发有限公司', '2018-11-06 23:04:22', '2018-11-06 23:04:25');
INSERT INTO `tb_estate` VALUES (1004, '万科城市花园', '上海市', '上海市', '松江区', '广富林路1188弄', '2002', '塔楼/板楼', '1.5', '上海保利物业管理', '上海城乾房地产开发有限公司', '2018-11-13 16:43:40', '2018-11-13 16:43:42');
INSERT INTO `tb_estate` VALUES (1005, '上海阳城', '上海市', '上海市', '闵行区', '罗锦路888弄', '2002', '塔楼/板楼', '1.5', '上海莲阳物业管理有限公司', '上海莲城房地产开发有限公司', '2018-11-06 23:23:52', '2018-11-06 23:23:55');

-- ----------------------------
-- Table structure for tb_house_resources
-- ----------------------------
DROP TABLE IF EXISTS `tb_house_resources`;
CREATE TABLE `tb_house_resources`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房源标题',
  `estate_id` bigint(20) NULL DEFAULT NULL COMMENT '楼盘id',
  `building_num` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼号（栋）',
  `building_unit` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单元号',
  `building_floor_num` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门牌号',
  `rent` int(10) NULL DEFAULT NULL COMMENT '租金',
  `rent_method` tinyint(1) NULL DEFAULT NULL COMMENT '租赁方式，1-整租，2-合租',
  `payment_method` tinyint(1) NULL DEFAULT NULL COMMENT '支付方式，1-付一押一，2-付三押一，3-付六押一，4-年付押一，5-其它',
  `house_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户型，如：2室1厅1卫',
  `covered_area` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建筑面积',
  `use_area` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用面积',
  `floor` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼层，如：8/26',
  `orientation` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '朝向：东、南、西、北',
  `decoration` tinyint(1) NULL DEFAULT NULL COMMENT '装修，1-精装，2-简装，3-毛坯',
  `facilities` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配套设施， 如：1,2,3',
  `pic` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片，最多5张',
  `house_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `contact` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `time` tinyint(1) NULL DEFAULT NULL COMMENT '看房时间，1-上午，2-中午，3-下午，4-晚上，5-全天',
  `property_cost` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物业费',
  `created` datetime NULL DEFAULT NULL,
  `updated` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '房源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_house_resources
-- ----------------------------


-- ----------------------------
-- Table structure for tb_house_resources
-- ----------------------------
CREATE TABLE `tb_ad` (
    `id`      bigint(20) NOT NULL AUTO_INCREMENT,
    `type`    int(10)      DEFAULT NULL COMMENT '广告类型',
    `title`   varchar(100) DEFAULT NULL COMMENT '描述',
    `url`     varchar(200) DEFAULT NULL COMMENT '图片URL地址',
    `created` datetime     DEFAULT NULL,
    `updated` datetime     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='广告表';

-- ----------------------------
-- Records of tb_house_resources
-- ----------------------------
INSERT INTO `tb_ad` (`id`, `type`, `title`, `url`, `created`, `updated`) VALUES ('1', '1', 'UniCity万科天空之城', 'http://itcast-haoke.oss-cn- qingdao.aliyuncs.com/images/2018/11/26/15432029097062227.jpg', '2018-11-26 11:28:49', '2018-11-26 11:28:51');
INSERT INTO `tb_ad` (`id`, `type`, `title`, `url`, `created`, `updated`) VALUES ('2', '1', '天和尚海庭前', 'http://itcast-haoke.oss-cn- qingdao.aliyuncs.com/images/2018/11/26/1543202958579877.jpg', '2018-11-26 11:29:27', '2018-11-26 11:29:29');
INSERT INTO `tb_ad` (`id`, `type`, `title`, `url`, `created`, `updated`) VALUES ('3', '1', '[奉贤 南桥] 光语著', 'http://itcast-haoke.oss-cn- qingdao.aliyuncs.com/images/2018/11/26/15432029946721854.jpg', '2018-11-26 11:30:04', '2018-11-26 11:30:06');
INSERT INTO `tb_ad` (`id`, `type`, `title`, `url`, `created`, `updated`) VALUES ('4', '1', '[上海周边 嘉兴] 融创海逸长洲', 'http://itcast-haoke.oss-cn- qingdao.aliyuncs.com/images/2018/11/26/15432029946721854.jpg', '2018-11-26 11:30:49', '2018-11-26 11:30:53');



SET FOREIGN_KEY_CHECKS = 1;