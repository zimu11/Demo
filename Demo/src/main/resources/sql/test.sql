/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 26/07/2023 15:29:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee_list
-- ----------------------------
DROP TABLE IF EXISTS `employee_list`;
CREATE TABLE `employee_list`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '职工ID',
  `emp_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职员姓名',
  `sex` int(4) NOT NULL COMMENT '性别',
  `age` int(10) NOT NULL COMMENT '年龄',
  `dept_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `emp_degree_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学历',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee_list
-- ----------------------------
INSERT INTO `employee_list` VALUES (1, '张一', 1, 25, '业务部', '本科');
INSERT INTO `employee_list` VALUES (4, '薄冰', 1, 12, '后勤部', '高中');
INSERT INTO `employee_list` VALUES (5, '张二', 1, 23, '人事部', '小学');
INSERT INTO `employee_list` VALUES (6, '张三', 1, 22, '后勤部', '专科');
INSERT INTO `employee_list` VALUES (7, '张四', 0, 19, '人事部', '专科');
INSERT INTO `employee_list` VALUES (8, '张五', 0, 22, '业务部', '本科');
INSERT INTO `employee_list` VALUES (9, '张六', 0, 22, '业务部', '本科');
INSERT INTO `employee_list` VALUES (10, '张七', 1, 23, '人事部', '高中');
INSERT INTO `employee_list` VALUES (11, '李四', 1, 20, '业务部', '小学');
INSERT INTO `employee_list` VALUES (12, '张八', 0, 26, '业务部', '本科');
INSERT INTO `employee_list` VALUES (13, '张久', 0, 25, '人事部', '专科');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'admin', '111111');

SET FOREIGN_KEY_CHECKS = 1;
