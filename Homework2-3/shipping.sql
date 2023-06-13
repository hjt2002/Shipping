/*
 Navicat Premium Data Transfer

 Source Server         : Shipping
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : shipping

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 18/05/2023 10:40:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for billings
-- ----------------------------
DROP TABLE IF EXISTS `billings`;
CREATE TABLE `billings`  (
  `shipment_id` int NOT NULL,
  `amount` int NOT NULL,
  `duedate` date NOT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`shipment_id`) USING BTREE,
  CONSTRAINT `shipment_id` FOREIGN KEY (`shipment_id`) REFERENCES `order` (`shipment_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of billings
-- ----------------------------
INSERT INTO `billings` VALUES (100001, 100, '2023-05-24', 'pending');
INSERT INTO `billings` VALUES (100002, 50, '2023-05-27', 'paid');
INSERT INTO `billings` VALUES (100003, 200, '2023-05-16', 'pending');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `shipment_id` int NOT NULL,
  `consignee_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `consignee_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `weigth` int NOT NULL,
  PRIMARY KEY (`shipment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (100001, '王先生', '北京海淀', '十箱木材', 100);
INSERT INTO `order` VALUES (100002, '刘先生', '上海浦东', '十箱玻璃', 50);
INSERT INTO `order` VALUES (100003, '赵先生', '北京海淀', '汽车', 1000);

-- ----------------------------
-- Table structure for shipper
-- ----------------------------
DROP TABLE IF EXISTS `shipper`;
CREATE TABLE `shipper`  (
  `shipper_id` int NOT NULL,
  `shipper_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `shipper_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`shipper_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shipper
-- ----------------------------
INSERT INTO `shipper` VALUES (1001, 'John', 'John@example.com', '123', '北京海淀');
INSERT INTO `shipper` VALUES (1002, '赵子龙', '123456@css.com', '123456', '常山');

-- ----------------------------
-- Table structure for track
-- ----------------------------
DROP TABLE IF EXISTS `track`;
CREATE TABLE `track`  (
  `shipper_id` int NOT NULL,
  `shipment_id` int NOT NULL,
  `ship_date` date NOT NULL,
  `delivery_date` date NOT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`shipper_id`, `shipment_id`) USING BTREE,
  INDEX `shipment_id`(`shipment_id` ASC) USING BTREE,
  CONSTRAINT `track_ibfk_1` FOREIGN KEY (`shipper_id`) REFERENCES `shipper` (`shipper_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `track_ibfk_2` FOREIGN KEY (`shipment_id`) REFERENCES `order` (`shipment_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of track
-- ----------------------------
INSERT INTO `track` VALUES (1001, 100001, '2023-05-10', '2023-05-17', 'unshipped');

-- ----------------------------
-- Table structure for trackinfo
-- ----------------------------
DROP TABLE IF EXISTS `trackinfo`;
CREATE TABLE `trackinfo`  (
  `shipment_id` int NOT NULL,
  `tracking_datetime` datetime NOT NULL,
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`shipment_id`, `tracking_datetime`) USING BTREE,
  CONSTRAINT `trackinfo_ibfk_1` FOREIGN KEY (`shipment_id`) REFERENCES `order` (`shipment_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trackinfo
-- ----------------------------
INSERT INTO `trackinfo` VALUES (100001, '2023-05-13 10:20:16', '北京', 'shipping');
INSERT INTO `trackinfo` VALUES (100001, '2023-05-14 10:22:31', '上海', 'transit');
INSERT INTO `trackinfo` VALUES (100001, '2023-05-15 10:23:02', '广州', 'delivered');
INSERT INTO `trackinfo` VALUES (100002, '2023-05-18 20:24:45', '西安', 'transit');
INSERT INTO `trackinfo` VALUES (100002, '2023-05-24 10:02:25', '北京昌平', 'shipping');

SET FOREIGN_KEY_CHECKS = 1;
