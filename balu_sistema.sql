-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2018 at 10:00 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `balu_sistema`
--

-- --------------------------------------------------------

--
-- Table structure for table `darbai`
--

CREATE TABLE `darbai` (
  `DARBO_ID` varchar(7) NOT NULL,
  `ATS_TEXT` varchar(255) NOT NULL,
  `IVERTINIMAS` float(4,2) NOT NULL,
  `IKELIMO_DATA` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `IVERTINIMO_DATA` datetime NOT NULL,
  `KOMENTARAS` varchar(255) NOT NULL,
  `STUD_ID` int(8) NOT NULL,
  `UZD_PAV` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `darbai`
--

INSERT INTO `darbai` (`DARBO_ID`, `ATS_TEXT`, `IVERTINIMAS`, `IKELIMO_DATA`, `IVERTINIMO_DATA`, `KOMENTARAS`, `STUD_ID`, `UZD_PAV`) VALUES
('1', 'gdfgdfgdfgdg', 2.20, '2018-12-22 00:00:00', '0000-00-00 00:00:00', 'fdsfdsfsf', 20163654, 'Namu darbas NR.1');

-- --------------------------------------------------------

--
-- Table structure for table `destytojai`
--

CREATE TABLE `destytojai` (
  `id` int(4) NOT NULL,
  `vardas` varchar(25) NOT NULL,
  `pavarde` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `destytojai`
--

INSERT INTO `destytojai` (`id`, `vardas`, `pavarde`) VALUES
(2016, 'Jonas', 'Petras'),
(5555, 'iiii', 'jjjj'),
(19971021, 'Tomas', 'Gaufys');

-- --------------------------------------------------------

--
-- Table structure for table `grupes`
--

CREATE TABLE `grupes` (
  `grupes_kodas` varchar(12) NOT NULL,
  `metai` int(4) NOT NULL,
  `specialybe` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `grupes`
--

INSERT INTO `grupes` (`grupes_kodas`, `metai`, `specialybe`) VALUES
('Prif-162', 2016, 'Programu inzinerija'),
('PRif-163', 2016, 'Programu inzinerija');

-- --------------------------------------------------------

--
-- Table structure for table `grupes_kursai`
--

CREATE TABLE `grupes_kursai` (
  `grupes_kodas` varchar(12) NOT NULL,
  `kurso_kodas` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `grupes_kursai`
--

INSERT INTO `grupes_kursai` (`grupes_kodas`, `kurso_kodas`) VALUES
('Prif-162', 'DBVS_2018'),
('Prif-162', 'PSI_2018'),
('PRif-163', 'PSI_2018');

-- --------------------------------------------------------

--
-- Table structure for table `kursai`
--

CREATE TABLE `kursai` (
  `kurso_kodas` varchar(10) NOT NULL,
  `kurso_pav` varchar(50) NOT NULL,
  `DEST_ID` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kursai`
--

INSERT INTO `kursai` (`kurso_kodas`, `kurso_pav`, `DEST_ID`) VALUES
('DBVS_2018', 'Duomenu baziu valdymo sistemos', 19971021),
('PSI_2018', 'Programu sistemu inzinerija', 2016),
('PVP_2018', 'Projekt? valdymo principai', 2016);

-- --------------------------------------------------------

--
-- Table structure for table `studentai`
--

CREATE TABLE `studentai` (
  `grupes_kodas` varchar(12) NOT NULL,
  `id` int(8) NOT NULL,
  `vardas` varchar(25) NOT NULL,
  `pavarde` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `studentai`
--

INSERT INTO `studentai` (`grupes_kodas`, `id`, `vardas`, `pavarde`) VALUES
('Prif-162', 20163654, 'Eliot', 'Berriere');

-- --------------------------------------------------------

--
-- Table structure for table `uzduotys`
--

CREATE TABLE `uzduotys` (
  `PAV` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `SALYGA` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `VERT_TVARKA` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MAX_BALAI` float(4,2) NOT NULL,
  `TERMINAS` datetime NOT NULL,
  `GALIMA_IKELTI` tinyint(1) NOT NULL,
  `kurso_kodas` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `uzduotys`
--

INSERT INTO `uzduotys` (`PAV`, `SALYGA`, `VERT_TVARKA`, `MAX_BALAI`, `TERMINAS`, `GALIMA_IKELTI`, `kurso_kodas`) VALUES
('klkoko', 'hjhjghjg\r\nhjgjhgjhgkjgkjg\r\nhkjhkjhk', 'hjhjhjh', 3.50, '2018-12-31 00:00:00', 1, 'PSI_2018'),
('Namu darbas NR.1', 'Padaryti ta ir ta, taip ir anaip, naudojant tai ir tai.', 'Kiek tasku, toks pazimys.', 10.00, '2018-12-24 23:59:59', 0, 'PSI_2018');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `darbai`
--
ALTER TABLE `darbai`
  ADD PRIMARY KEY (`DARBO_ID`),
  ADD KEY `FK_STUD_ID` (`STUD_ID`),
  ADD KEY `FK_UZD_PAV` (`UZD_PAV`);

--
-- Indexes for table `destytojai`
--
ALTER TABLE `destytojai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `grupes`
--
ALTER TABLE `grupes`
  ADD PRIMARY KEY (`grupes_kodas`);

--
-- Indexes for table `grupes_kursai`
--
ALTER TABLE `grupes_kursai`
  ADD PRIMARY KEY (`grupes_kodas`,`kurso_kodas`);

--
-- Indexes for table `kursai`
--
ALTER TABLE `kursai`
  ADD PRIMARY KEY (`kurso_kodas`),
  ADD KEY `FK_DEST_ID` (`DEST_ID`);

--
-- Indexes for table `studentai`
--
ALTER TABLE `studentai`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_stud_grupe` (`grupes_kodas`);

--
-- Indexes for table `uzduotys`
--
ALTER TABLE `uzduotys`
  ADD PRIMARY KEY (`PAV`),
  ADD UNIQUE KEY `UZD_PAV_UNQ` (`PAV`),
  ADD UNIQUE KEY `UZD_SAL_UNQ` (`SALYGA`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `darbai`
--
ALTER TABLE `darbai`
  ADD CONSTRAINT `FK_STUD_ID` FOREIGN KEY (`STUD_ID`) REFERENCES `studentai` (`id`),
  ADD CONSTRAINT `FK_UZD_PAV` FOREIGN KEY (`UZD_PAV`) REFERENCES `uzduotys` (`PAV`);

--
-- Constraints for table `kursai`
--
ALTER TABLE `kursai`
  ADD CONSTRAINT `FK_DEST_ID` FOREIGN KEY (`DEST_ID`) REFERENCES `destytojai` (`id`);

--
-- Constraints for table `studentai`
--
ALTER TABLE `studentai`
  ADD CONSTRAINT `FK_stud_grupe` FOREIGN KEY (`grupes_kodas`) REFERENCES `grupes` (`grupes_kodas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
