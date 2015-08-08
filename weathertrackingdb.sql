-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 28, 2015 at 04:22 PM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `weathertrackingdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `configuration`
--

CREATE TABLE IF NOT EXISTS `configuration` (
  `ID` int(11) NOT NULL,
  `displayTemperature` tinyint(1) DEFAULT NULL,
  `displayHumidity` tinyint(1) DEFAULT NULL,
  `displayLight` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `configuration`
--

INSERT INTO `configuration` (`ID`, `displayTemperature`, `displayHumidity`, `displayLight`) VALUES
(2, 1, 2, 0),
(3, 1, 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `notifications`
--

CREATE TABLE IF NOT EXISTS `notifications` (
  `ID` int(11) NOT NULL,
  `email` varchar(254) NOT NULL,
  `temperatureThreshold` int(11) DEFAULT NULL,
  `humidityThreshold` int(11) DEFAULT NULL,
  `lightThreshold` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notifications`
--

INSERT INTO `notifications` (`ID`, `email`, `temperatureThreshold`, `humidityThreshold`, `lightThreshold`) VALUES
(1, 'jack@my.jcu.edu.au', 23, 45, 34),
(2, 'joel@my.jcu.edu.au', 45, 34, 21),
(3, 'jill@my.jcu.edu.au', 45, 45, 20),
(4, 'james@my.jcu.edu.au', 44, 30, 21),
(5, 'jacinta@my.jcu.edu.au', 41, 10, 63),
(6, 'test6@my.jcu.edu.au', 34, 45, 24),
(7, 'david@my.jcu.edu.au', 30, 70, 20);

-- --------------------------------------------------------

--
-- Table structure for table `variables`
--

CREATE TABLE IF NOT EXISTS `variables` (
  `ID` int(11) NOT NULL,
  `temperature` int(11) DEFAULT NULL,
  `humidity` int(11) DEFAULT NULL,
  `light` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `variables`
--

INSERT INTO `variables` (`ID`, `temperature`, `humidity`, `light`) VALUES
(1, 34, 76, 46),
(2, 34, 80, 43),
(3, 37, 90, 0),
(4, 2, 60, 13),
(5, 69, 21, 53),
(51, 52, 45, 10),
(52, 37, 38, 23),
(53, 90, 67, 67),
(54, 85, 80, 23),
(55, 92, 34, 34),
(56, 77, 26, 76),
(57, 39, 2, 51),
(58, 64, 61, 70),
(59, 97, 90, 93),
(60, 16, 16, 16);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `configuration`
--
ALTER TABLE `configuration`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `variables`
--
ALTER TABLE `variables`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `configuration`
--
ALTER TABLE `configuration`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `notifications`
--
ALTER TABLE `notifications`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `variables`
--
ALTER TABLE `variables`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=61;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
