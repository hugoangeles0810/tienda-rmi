-- MySQL dump 10.13  Distrib 5.7.12, for linux-glibc2.5 (x86_64)
--
-- Host: 127.0.0.1    Database: tienda_db
-- ------------------------------------------------------
-- Server version	5.7.15-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `boleta_cabeceras`
--

DROP TABLE IF EXISTS `boleta_cabeceras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boleta_cabeceras` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente` varchar(255) DEFAULT '',
  `direccion` varchar(45) DEFAULT '',
  `monto` decimal(15,2) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boleta_cabeceras`
--

LOCK TABLES `boleta_cabeceras` WRITE;
/*!40000 ALTER TABLE `boleta_cabeceras` DISABLE KEYS */;
INSERT INTO `boleta_cabeceras` VALUES (1,'pedro','piura',15.00,'2016-10-09 00:00:00'),(3,'juan','lambayeque',75.00,'2016-10-09 00:00:00');
/*!40000 ALTER TABLE `boleta_cabeceras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boleta_detalles`
--

DROP TABLE IF EXISTS `boleta_detalles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boleta_detalles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producto_id` int(11) NOT NULL,
  `cantidad` decimal(15,2) NOT NULL,
  `precio` decimal(15,2) NOT NULL,
  `cabecera_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_boleta_detalles_producto_idx` (`producto_id`),
  KEY `fk_boleta_detalles_boleta_cabecera_idx` (`cabecera_id`),
  CONSTRAINT `fk_boleta_detalles_boleta_cabecera` FOREIGN KEY (`cabecera_id`) REFERENCES `boleta_cabeceras` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_boleta_detalles_producto` FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boleta_detalles`
--

LOCK TABLES `boleta_detalles` WRITE;
/*!40000 ALTER TABLE `boleta_detalles` DISABLE KEYS */;
INSERT INTO `boleta_detalles` VALUES (1,1,10.00,1.50,1),(3,1,50.00,1.50,3);
/*!40000 ALTER TABLE `boleta_detalles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guia_cabeceras`
--

DROP TABLE IF EXISTS `guia_cabeceras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guia_cabeceras` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(255) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guia_cabeceras`
--

LOCK TABLES `guia_cabeceras` WRITE;
/*!40000 ALTER TABLE `guia_cabeceras` DISABLE KEYS */;
INSERT INTO `guia_cabeceras` VALUES (2,'000002','2016-10-09 00:00:00');
/*!40000 ALTER TABLE `guia_cabeceras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guia_detalles`
--

DROP TABLE IF EXISTS `guia_detalles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guia_detalles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producto_id` int(11) NOT NULL,
  `cantidad` decimal(15,2) NOT NULL,
  `cabecera_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_guia_detalles_guia_cabecera_idx` (`producto_id`),
  CONSTRAINT `fk_guia_detalles_guia_cabecera` FOREIGN KEY (`producto_id`) REFERENCES `guia_cabeceras` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guia_detalles`
--

LOCK TABLES `guia_detalles` WRITE;
/*!40000 ALTER TABLE `guia_detalles` DISABLE KEYS */;
/*!40000 ALTER TABLE `guia_detalles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `stock` decimal(15,2) NOT NULL DEFAULT '0.00',
  `unidad_id` int(11) NOT NULL,
  `precio` decimal(15,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_productos_unidades_idx` (`unidad_id`),
  CONSTRAINT `fk_productos_unidades` FOREIGN KEY (`unidad_id`) REFERENCES `unidades` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Lapicero Azul Pilot',0.00,1,1.50),(2,'Cemento Pacasmayo',50.00,1,50.00),(3,'Leche Gloria Lata',100.00,1,2.40),(4,'Laptop HP 14 INCH',100.00,1,1500.00);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidades`
--

DROP TABLE IF EXISTS `unidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `abreviatura` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidades`
--

LOCK TABLES `unidades` WRITE;
/*!40000 ALTER TABLE `unidades` DISABLE KEYS */;
INSERT INTO `unidades` VALUES (1,'unidad','und'),(2,'kilogramo','kg'),(3,'caja','caja');
/*!40000 ALTER TABLE `unidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(70) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'hugo','angeles');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-12 21:40:01
