-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 13, 2021 at 06:30 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `new`
--

-- --------------------------------------------------------

--
-- Table structure for table `employeeinfo`
--

CREATE TABLE `employeeinfo` (
  `EID` int(10) NOT NULL,
  `Name` varchar(25) DEFAULT NULL,
  `Surname` varchar(25) DEFAULT NULL,
  `Age` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employeeinfo`
--

INSERT INTO `employeeinfo` (`EID`, `Name`, `Surname`, `Age`) VALUES
(1, 'Gabriel', 'Reyes', '20'),
(2, 'Hallo', 'Niece', '21');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID` tinyint(4) DEFAULT NULL,
  `UserName` varchar(14) DEFAULT NULL,
  `Password` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `UserName`, `Password`) VALUES
(1, 'admin', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employeeinfo`
--
ALTER TABLE `employeeinfo`
  ADD PRIMARY KEY (`EID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employeeinfo`
--
ALTER TABLE `employeeinfo`
  MODIFY `EID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
