CREATE DATABASE  IF NOT EXISTS `farshop` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `farshop`;

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) COLLATE utf8_bin NOT NULL,
  `password` varchar(40) COLLATE utf8_bin NOT NULL,
  `phone` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `mail` text COLLATE utf8_bin,
  `address` text COLLATE utf8_bin,
  `role` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) COLLATE utf8_bin NOT NULL,
  `parentId` bigint(20) DEFAULT NULL,
  `description` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `categoryId` bigint(20) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `size` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `distImageUrl1` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `distImageUrl2` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `distImageUrl3` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `mainImageUrl1` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `mainImageUrl2` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `mainImageUrl3` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `mainImageUrl4` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id`         bigint(20) NOT NULL AUTO_INCREMENT,
  `orderTime`  datetime DEFAULT NULL,
  `payTime`    datetime DEFAULT NULL,
  `orderMoney` decimal(10,0) DEFAULT NULL,
  `orderSt`    smallint(6) DEFAULT NULL,
  `address`    text COLLATE utf8_bin,
  `phone`      char(11) COLLATE utf8_bin DEFAULT NULL,
  `customerId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderdetail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `productId` bigint(20) DEFAULT NULL,
  `orderId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `shoppingcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingcart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` tinyint(4) DEFAULT NULL COMMENT '1±íÊ¾ÒÑ¹ºÂò£¬0±íÊ¾Î´¹ºÂò',
  `userId` bigint(20) DEFAULT NULL
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `shoppingcartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingcartitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cartId` bigint(20) NOT NULL,
  `productId` bigint(20) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '1±íÊ¾ÒÑ¹ºÂò£¬0±íÊ¾Î´¹ºÂò',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;
