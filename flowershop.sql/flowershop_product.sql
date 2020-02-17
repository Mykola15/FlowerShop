-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: localhost    Database: flowershop
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (4,'A rose is a woody perennial flowering plant of the genus Rosa, in the family Rosaceae, or the flower it bears. ','roses','ef124684-e559-4f91-adf3-06410b6539bb.item1.png',25,20,'roses'),(5,'A rose is a woody perennial flowering plant of the genus Rosa, in the family Rosaceae, or the flower it bears. ','roses2','917e4636-8c51-4d2d-80f5-9b3d5735df12.item4.png',30,20,'roses'),(6,'A rose is a woody perennial flowering plant of the genus Rosa, in the family Rosaceae, or the flower it bears. ','roses1','bc7edd6c-28bf-41ac-8d18-c910e3f46e27.item5.png',35,20,'roses'),(7,'Roses with violence ','Bouquet','3ab9081f-041e-46f4-a299-95c7efcae2e1.item2.png',300,1,'bouquet'),(8,'Pretty bouquet ','Bouquet2','73a0fc0e-72aa-4d93-a321-41daa3239be2.item6.png',250,1,'bouquet'),(9,'Peonies are among the most popular garden plants in temperate regions. Herbaceous peonies are also sold as cut flowers on a large scale, although generally only available in late spring and early summer.','Peony','9d3f8cf7-5db7-42cb-b160-ac1a71157e1c.item8.png',20,20,'peony'),(10,'Tulips (Tulipa) form a genus of spring-blooming perennial herbaceous bulbiferous geophytes (having bulbs as storage organs). ','tulip','bb11caed-d188-4ed9-a389-8b60f602f7a6.item3.png',15,20,'tulips'),(11,'Tulips (Tulipa) form a genus of spring-blooming perennial herbaceous bulbiferous geophytes (having bulbs as storage organs). ','tulip1','588f8ea0-cd5b-4fff-8bc2-5c01ba34b597.item11.png',15,20,'tulips'),(13,'Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Flowers','75cd8d62-1096-49fc-8feb-3aea6a108c66.item10.png',25,20,'another'),(14,'Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Flowers1','4a16a6f0-09e6-43f6-9f7c-46729130c9b0.item7.png',33,20,'another'),(15,'Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Flowers2','70a9ab19-bf8a-4b2a-a3e5-86f4ea3891dd.item9.png',17,20,'another');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-17 18:12:44
