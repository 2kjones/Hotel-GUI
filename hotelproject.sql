-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 20, 2017 at 08:54 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hotelproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `guests`
--

CREATE TABLE IF NOT EXISTS `guests` (
`Guest_ID` int(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Num_Of_Guests` int(1) NOT NULL,
  `Credit_Info` int(16) NOT NULL,
  `Driver_License` varchar(15) NOT NULL,
  `Car_Info` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reservations`
--

CREATE TABLE IF NOT EXISTS `reservations` (
`Res_ID` int(10) NOT NULL,
  `Date` date NOT NULL,
  `Room_ID` int(3) NOT NULL,
  `Guest_ID` int(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservations`
--

INSERT INTO `reservations` (`Res_ID`, `Date`, `Room_ID`, `Guest_ID`) VALUES
(1, '2017-01-22', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE IF NOT EXISTS `rooms` (
`Room_ID` int(3) NOT NULL,
  `Room_Num` int(3) NOT NULL,
  `Bed_Type` int(1) NOT NULL,
  `Smoking` int(1) NOT NULL,
  `Ocean_View` int(1) NOT NULL,
  `Price_Low` int(8) NOT NULL,
  `Price_High` int(8) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`Room_ID`, `Room_Num`, `Bed_Type`, `Smoking`, `Ocean_View`, `Price_Low`, `Price_High`) VALUES
(1, 101, 1, 0, 1, 55, 85),
(2, 102, 2, 1, 0, 25, 45);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `guests`
--
ALTER TABLE `guests`
 ADD PRIMARY KEY (`Guest_ID`);

--
-- Indexes for table `reservations`
--
ALTER TABLE `reservations`
 ADD PRIMARY KEY (`Res_ID`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
 ADD PRIMARY KEY (`Room_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `guests`
--
ALTER TABLE `guests`
MODIFY `Guest_ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `reservations`
--
ALTER TABLE `reservations`
MODIFY `Res_ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
MODIFY `Room_ID` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
