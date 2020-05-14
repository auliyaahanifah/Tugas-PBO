-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2020 at 07:05 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `BookId` int(3) NOT NULL,
  `BookTitle` varchar(30) NOT NULL,
  `Author` varchar(30) NOT NULL,
  `Genre` varchar(20) NOT NULL,
  `Stock` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`BookId`, `BookTitle`, `Author`, `Genre`, `Stock`) VALUES
(1, 'Matematika', 'Rama Tri Agung', 'Pelajaran SMA', 5),
(2, 'Biologi', 'Siapa Aja Deh', 'Pelajaran SMP', 5),
(3, 'Fisika', 'Siapa Aja Deh', 'Pelajaran SMP', 5),
(4, 'Kimia', 'Siapa Aja Deh', 'Pelajaran SMP', 5),
(5, 'Sejarah', 'Siapa Aja Deh', 'Pelajaran SMP', 5);

-- --------------------------------------------------------

--
-- Table structure for table `kartu_pinjam`
--

CREATE TABLE `kartu_pinjam` (
  `NoCard` int(3) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `BookId` int(3) NOT NULL,
  `TglPinjam` date NOT NULL,
  `TglKembali` date DEFAULT NULL,
  `Status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kartu_pinjam`
--

INSERT INTO `kartu_pinjam` (`NoCard`, `Email`, `BookId`, `TglPinjam`, `TglKembali`, `Status`) VALUES
(2, 'auliyaahanifah@gmail.com', 1, '2020-04-27', '2020-04-28', 'dikembalikan'),
(6, 'zahra123@gmail.com', 3, '2020-05-02', '2020-05-02', 'dikembalikan'),
(7, 'zahra123@gmail.com', 1, '2020-05-02', '2020-05-02', 'dikembalikan'),
(8, 'zahra123@gmail.com', 2, '2020-05-02', '2020-05-02', 'dikembalikan'),
(9, 'zahra123@gmail.com', 4, '2020-05-02', '2020-05-02', 'dikembalikan'),
(10, 'zahra123@gmail.com', 5, '2020-05-02', '2020-05-02', 'dikembalikan');

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `Email` varchar(40) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `NoHp` varchar(12) NOT NULL,
  `Address` text NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`Email`, `Name`, `NoHp`, `Address`, `Password`) VALUES
('auliyaahanifah@gmail.com', 'Auliyaa Hanifah', '081223435543', 'Gatau', '12345678'),
('ramatriagung91@gmail.com', 'Rama Tri Agung', '081377879966', 'Lubuklinggau', '12345678'),
('zahra123@gmail.com', 'Iffatuz Zahra', '081377879966', 'Padang', '12345678');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`BookId`);

--
-- Indexes for table `kartu_pinjam`
--
ALTER TABLE `kartu_pinjam`
  ADD PRIMARY KEY (`NoCard`),
  ADD KEY `fkBookId` (`BookId`),
  ADD KEY `fkEmail` (`Email`);

--
-- Indexes for table `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`Email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `BookId` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `kartu_pinjam`
--
ALTER TABLE `kartu_pinjam`
  MODIFY `NoCard` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kartu_pinjam`
--
ALTER TABLE `kartu_pinjam`
  ADD CONSTRAINT `fkBookId` FOREIGN KEY (`BookId`) REFERENCES `books` (`BookId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkEmail` FOREIGN KEY (`Email`) REFERENCES `members` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
