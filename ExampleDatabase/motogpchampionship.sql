-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Set 09, 2022 alle 09:40
-- Versione del server: 10.4.24-MariaDB
-- Versione PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `motogpchampionship`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `aggregazionegommisti`
--

CREATE TABLE `aggregazionegommisti` (
  `CodiceGommista` int(11) NOT NULL,
  `CodiceTeam` int(11) NOT NULL,
  `Anno` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `aggregazionegommisti`
--

INSERT INTO `aggregazionegommisti` (`CodiceGommista`, `CodiceTeam`, `Anno`) VALUES
(1, 1, 2022),
(2, 2, 2022),
(3, 3, 2022),
(4, 4, 2022),
(5, 5, 2022),
(6, 6, 2022),
(7, 7, 2022),
(8, 8, 2022),
(9, 9, 2022),
(10, 10, 2022),
(11, 11, 2022),
(12, 12, 2022),
(13, 13, 2022),
(14, 14, 2022),
(15, 15, 2022);

-- --------------------------------------------------------

--
-- Struttura della tabella `aggregazioneingegneri`
--

CREATE TABLE `aggregazioneingegneri` (
  `CodiceIngegnere` int(11) NOT NULL,
  `CodiceTeam` int(11) NOT NULL,
  `Anno` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `aggregazioneingegneri`
--

INSERT INTO `aggregazioneingegneri` (`CodiceIngegnere`, `CodiceTeam`, `Anno`) VALUES
(1, 1, 2022),
(2, 1, 2022),
(3, 1, 2022),
(4, 2, 2022),
(5, 2, 2022),
(6, 2, 2022),
(7, 3, 2022),
(8, 3, 2022),
(9, 3, 2022),
(10, 4, 2022),
(11, 4, 2022),
(12, 4, 2022),
(13, 5, 2022),
(14, 5, 2022),
(15, 5, 2022),
(16, 6, 2022),
(17, 6, 2022),
(18, 6, 2022),
(19, 7, 2022),
(20, 7, 2022),
(21, 7, 2022),
(22, 8, 2022),
(23, 8, 2022),
(24, 8, 2022),
(25, 9, 2022),
(26, 9, 2022),
(27, 9, 2022),
(28, 10, 2022),
(29, 10, 2022),
(30, 10, 2022),
(31, 11, 2022),
(32, 11, 2022),
(33, 11, 2022),
(34, 12, 2022),
(35, 12, 2022),
(36, 12, 2022),
(37, 13, 2022),
(38, 13, 2022),
(39, 13, 2022),
(40, 14, 2022),
(41, 14, 2022),
(42, 14, 2022),
(43, 15, 2022),
(44, 15, 2022),
(45, 15, 2022);

-- --------------------------------------------------------

--
-- Struttura della tabella `aggregazionepiloti`
--

CREATE TABLE `aggregazionepiloti` (
  `CodicePilota` int(11) NOT NULL,
  `CodiceTeam` int(11) NOT NULL,
  `Anno` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `aggregazionepiloti`
--

INSERT INTO `aggregazionepiloti` (`CodicePilota`, `CodiceTeam`, `Anno`) VALUES
(1, 13, 2022),
(2, 8, 2022),
(3, 15, 2022),
(4, 1, 2022),
(5, 4, 2022),
(6, 5, 2022),
(7, 15, 2022),
(8, 9, 2022),
(9, 11, 2022),
(10, 7, 2022),
(11, 6, 2022),
(12, 6, 2022),
(13, 12, 2022),
(14, 13, 2022),
(15, 1, 2022),
(16, 11, 2022),
(17, 3, 2022),
(18, 10, 2022),
(19, 4, 2022),
(20, 2, 2022),
(21, 3, 2022),
(22, 7, 2022),
(23, 5, 2022),
(24, 12, 2022),
(25, 9, 2022),
(26, 8, 2022),
(27, 10, 2022),
(28, 14, 2022),
(29, 14, 2022),
(30, 2, 2022);

-- --------------------------------------------------------

--
-- Struttura della tabella `aggregazionetelemetristi`
--

CREATE TABLE `aggregazionetelemetristi` (
  `CodiceTelemetrista` int(11) NOT NULL,
  `CodiceTeam` int(11) NOT NULL,
  `Anno` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `aggregazionetelemetristi`
--

INSERT INTO `aggregazionetelemetristi` (`CodiceTelemetrista`, `CodiceTeam`, `Anno`) VALUES
(1, 1, 2022),
(2, 2, 2022),
(3, 3, 2022),
(4, 4, 2022),
(5, 5, 2022),
(6, 6, 2022),
(7, 7, 2022),
(8, 8, 2022),
(9, 9, 2022),
(10, 10, 2022),
(11, 11, 2022),
(12, 12, 2022),
(13, 13, 2022),
(14, 14, 2022),
(15, 15, 2022);

-- --------------------------------------------------------

--
-- Struttura della tabella `autodromi`
--

CREATE TABLE `autodromi` (
  `CodiceAutodromo` int(11) NOT NULL,
  `Nome` char(30) NOT NULL,
  `Stato` char(20) NOT NULL,
  `NumeroPostiTotali` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `autodromi`
--

INSERT INTO `autodromi` (`CodiceAutodromo`, `Nome`, `Stato`, `NumeroPostiTotali`) VALUES
(1, 'Lusail International Circuit', 'QATAR', 120000),
(2, 'Pertamina Mandalika Circuit', 'INDONESIA', 80000),
(3, 'Termas de Río Hondo', 'ARGENTINA', 100000),
(4, 'Circuit of The Americas', 'USA', 110000),
(5, 'Autódromo do Algarve', 'PORTUGAL', 110000),
(6, 'Circuito de Jerez', 'SPAIN', 100000),
(7, 'Le Mans', 'FRANCE', 80000),
(8, 'Mugello', 'ITALY', 120000),
(9, 'Circuit de Catalunya', 'SPAIN', 90000),
(10, 'Sachsenring', 'GERMANY', 90000),
(11, 'TT Circuit Assen', 'NETHERLANDS', 100000),
(12, 'Silverstone Circuit', 'GREAT BRITAIN', 110000),
(13, 'Red Bull Ring', 'AUSTRIA', 100000),
(14, 'Misano World Circuit', 'ITALY', 140000),
(15, 'MotorLand Aragón', 'SPAIN', 80000),
(16, 'Motegi', 'JAPAN', 90000),
(17, 'Chang Circuit', 'THAILAND', 100000),
(18, 'Phillip Island', 'AUSTRALIA', 90000),
(19, 'Sepang Circuit', 'MALAYSIA', 100000),
(20, 'Circuit Ricardo Tormo', 'SPAIN', 90000);

-- --------------------------------------------------------

--
-- Struttura della tabella `biglietti`
--

CREATE TABLE `biglietti` (
  `Data` date NOT NULL,
  `CodiceSpettatore` int(11) NOT NULL,
  `CodiceAutodromo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `biglietti`
--

INSERT INTO `biglietti` (`Data`, `CodiceSpettatore`, `CodiceAutodromo`) VALUES
('2022-01-08', 1, 1),
('2022-01-08', 2, 1),
('2022-01-08', 3, 1),
('2022-01-08', 4, 1),
('2022-01-08', 5, 1),
('2022-01-22', 1, 2),
('2022-01-22', 2, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `campionati`
--

CREATE TABLE `campionati` (
  `CodiceCampionato` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `campionati`
--

INSERT INTO `campionati` (`CodiceCampionato`) VALUES
(1);

-- --------------------------------------------------------

--
-- Struttura della tabella `corre`
--

CREATE TABLE `corre` (
  `Anno` year(4) NOT NULL,
  `CodiceCampionato` int(11) NOT NULL,
  `CodiceAutodromo` int(11) NOT NULL,
  `CodicePilota` int(11) NOT NULL,
  `TempoGara` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `corre`
--

INSERT INTO `corre` (`Anno`, `CodiceCampionato`, `CodiceAutodromo`, `CodicePilota`, `TempoGara`) VALUES
(2022, 1, 1, 1, '00:31:45'),
(2022, 1, 1, 2, '00:31:50'),
(2022, 1, 1, 3, '00:31:55'),
(2022, 1, 1, 4, '00:32:00'),
(2022, 1, 1, 5, '00:32:05'),
(2022, 1, 1, 6, '00:32:10'),
(2022, 1, 1, 7, '00:32:15'),
(2022, 1, 1, 8, '00:32:20'),
(2022, 1, 1, 9, '00:32:25'),
(2022, 1, 1, 10, '00:32:30'),
(2022, 1, 1, 11, '00:32:35'),
(2022, 1, 1, 12, '00:32:40'),
(2022, 1, 1, 13, '00:32:45'),
(2022, 1, 1, 14, '00:32:50'),
(2022, 1, 1, 15, '00:32:55'),
(2022, 1, 1, 16, '00:32:43'),
(2022, 1, 1, 17, '00:32:27'),
(2022, 1, 1, 18, '00:32:11'),
(2022, 1, 1, 19, '00:32:32'),
(2022, 1, 1, 20, '00:32:39'),
(2022, 1, 1, 21, '00:31:41'),
(2022, 1, 1, 22, '00:32:59'),
(2022, 1, 1, 23, '00:33:07'),
(2022, 1, 1, 24, '00:32:12'),
(2022, 1, 1, 25, '00:31:59'),
(2022, 1, 1, 26, '00:31:56'),
(2022, 1, 1, 27, '00:31:46'),
(2022, 1, 1, 28, '00:32:28'),
(2022, 1, 1, 29, '00:32:13'),
(2022, 1, 1, 30, '00:33:05'),
(2022, 1, 2, 10, '00:15:50'),
(2022, 1, 2, 15, '00:15:49'),
(2022, 1, 2, 21, '00:11:25');

-- --------------------------------------------------------

--
-- Struttura della tabella `costruttori`
--

CREATE TABLE `costruttori` (
  `CodiceCostruttore` int(11) NOT NULL,
  `Nome` char(20) NOT NULL,
  `TipoMotore` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `costruttori`
--

INSERT INTO `costruttori` (`CodiceCostruttore`, `Nome`, `TipoMotore`) VALUES
(1, 'YAMAHA', 'I4'),
(2, 'HONDA', 'V4'),
(3, 'DUCATI', 'V4'),
(4, 'SUZUKI', 'I4'),
(5, 'KTM', 'V4');

-- --------------------------------------------------------

--
-- Struttura della tabella `fornitori`
--

CREATE TABLE `fornitori` (
  `CodiceCostruttore` int(11) NOT NULL,
  `CodiceTeam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `fornitori`
--

INSERT INTO `fornitori` (`CodiceCostruttore`, `CodiceTeam`) VALUES
(1, 6),
(1, 13),
(1, 14),
(2, 1),
(2, 5),
(2, 10),
(3, 3),
(3, 4),
(3, 8),
(4, 7),
(4, 11),
(4, 15),
(5, 2),
(5, 9),
(5, 12);

-- --------------------------------------------------------

--
-- Struttura della tabella `gare`
--

CREATE TABLE `gare` (
  `Anno` year(4) NOT NULL,
  `CodiceCampionato` int(11) NOT NULL,
  `CodiceAutodromo` int(11) NOT NULL,
  `Data` date NOT NULL,
  `NumeroGiri` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `gare`
--

INSERT INTO `gare` (`Anno`, `CodiceCampionato`, `CodiceAutodromo`, `Data`, `NumeroGiri`) VALUES
(2022, 1, 1, '2022-01-08', 30),
(2022, 1, 2, '2022-01-22', 29),
(2022, 1, 3, '2022-01-29', 34),
(2022, 1, 4, '2022-02-12', 28),
(2022, 1, 5, '2022-02-26', 30),
(2022, 1, 6, '2022-03-05', 27),
(2022, 1, 8, '2022-03-12', 25),
(2022, 1, 9, '2022-04-02', 31),
(2022, 1, 10, '2022-04-09', 29),
(2022, 1, 11, '2022-04-23', 32),
(2022, 1, 12, '2022-04-30', 27),
(2022, 1, 13, '2022-05-07', 34),
(2022, 1, 14, '2022-05-21', 30),
(2022, 1, 15, '2022-05-28', 29),
(2022, 1, 16, '2022-06-04', 31),
(2022, 1, 17, '2022-06-18', 28),
(2022, 1, 18, '2022-07-23', 29),
(2022, 1, 19, '2022-07-30', 27),
(2022, 1, 20, '2022-08-06', 27),
(2023, 1, 3, '2022-05-06', 21),
(2023, 1, 4, '2023-10-10', 30),
(2024, 1, 3, '2024-10-10', 30);

-- --------------------------------------------------------

--
-- Struttura della tabella `gommisti`
--

CREATE TABLE `gommisti` (
  `CodiceGommista` int(11) NOT NULL,
  `Nome` char(20) NOT NULL,
  `Cognome` char(20) NOT NULL,
  `CodiceFiscale` char(16) NOT NULL,
  `DataNascita` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `gommisti`
--

INSERT INTO `gommisti` (`CodiceGommista`, `Nome`, `Cognome`, `CodiceFiscale`, `DataNascita`) VALUES
(1, 'Riccardo', 'Tommaselli', '', '1988-01-02'),
(2, 'Francesco', 'Rossi', '', '1999-06-03'),
(3, 'Alex', 'Montanari', '', '1998-10-10'),
(4, 'Andrea', 'Savadori', '', '1997-06-01'),
(5, 'Lorenzo', 'Bianchi', '', '2000-02-03'),
(6, 'Nicola', 'Lundini', '', '2001-03-03'),
(7, 'Paolo', 'Tomba', '', '2000-07-08'),
(8, 'Giovanni', 'Mucciaccia', '', '2000-06-09'),
(9, 'Antonio', 'Santi', '', '1994-04-06'),
(10, 'Alessio', 'Ponti', '', '1997-12-12'),
(11, 'Mattia', 'Tamburini', '', '2001-08-12'),
(12, 'Federico', 'Mosconi', '', '2001-09-03'),
(13, 'Matteo', 'Morri', '', '2000-07-07'),
(14, 'Teo', 'Zacconi', '', '1996-05-03'),
(15, 'Gianmaria', 'Lorenzini', '', '1993-04-03');

-- --------------------------------------------------------

--
-- Struttura della tabella `ingegnerimeccanici`
--

CREATE TABLE `ingegnerimeccanici` (
  `CodiceIngegnere` int(11) NOT NULL,
  `Nome` char(20) NOT NULL,
  `Cognome` char(20) NOT NULL,
  `CodiceFiscale` char(16) NOT NULL,
  `DataNascita` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `ingegnerimeccanici`
--

INSERT INTO `ingegnerimeccanici` (`CodiceIngegnere`, `Nome`, `Cognome`, `CodiceFiscale`, `DataNascita`) VALUES
(1, 'Tommaso', 'Rossi', '', '1999-05-04'),
(2, 'Lorenzo', 'Pirozzi', '', '2001-07-06'),
(3, 'Andrea', 'Santini', '', '1999-05-06'),
(4, 'Alessio', 'Mosconi', '', '2000-04-01'),
(5, 'Alberto', 'Soli', '', '1997-05-03'),
(6, 'Francesco', 'Muccioli', '', '2001-05-03'),
(7, 'Leonardo', 'Romeo', '', '1999-08-03'),
(8, 'Valentino', 'Bianchi', '', '1994-05-03'),
(9, 'Nicola', 'Dominici', '', '1996-05-03'),
(10, 'Thomas', 'Ricci', '', '1999-03-03'),
(11, 'Alex', 'Ostuni', '', '1995-03-05'),
(12, 'Francesco', 'Romani', '', '1995-06-08'),
(13, 'Paolo', 'Sartini', '', '1999-04-03'),
(14, 'Enrico', 'Rossi', '', '1988-05-03'),
(15, 'Niccolo', 'Bianchini', '', '1999-06-04'),
(16, 'Francesco', 'Nanni', '', '1975-04-03'),
(17, 'Lollo', 'Portogallo', '', '2000-06-03'),
(18, 'Lino', 'Baratto', '', '2001-01-01'),
(19, 'Mirco', 'Giacomini', '', '2000-04-09'),
(20, 'Lorenzo', 'Morri', '', '2002-08-09'),
(21, 'Riccardo', 'Torino', '', '1998-05-03'),
(22, 'Pietro', 'Belin', '', '2001-04-09'),
(23, 'Gianmarco', 'Bottino', '', '2003-04-06'),
(24, 'Alessio', 'Savino', '', '1999-06-05'),
(25, 'Riccardo', 'Romani', '', '2001-07-08'),
(26, 'Amedeo', 'Nanni', '', '2001-04-06'),
(27, 'Pierpaolo', 'Antonelli', '', '2001-04-08'),
(28, 'Nicola', 'Santini', '', '2000-04-08'),
(29, 'Enrico', 'Rossi', '', '2003-04-10'),
(30, 'Giovanni', 'Marini', '', '1986-09-10'),
(31, 'Carlo', 'Ricci', '', '1999-07-07'),
(32, 'Alessio', 'Zanzini', '', '2000-12-12'),
(33, 'Pietro', 'Ravenna', '', '1998-04-06'),
(34, 'Lorenzo', 'Montani', '', '1976-10-11'),
(35, 'Elvis', 'Romani', '', '1996-04-05'),
(36, 'Alex', 'Manzilli', '', '1986-02-06'),
(37, 'Alex', 'Postilli', '', '1999-01-02'),
(38, 'Niccolo', 'Ostuni', '', '2000-01-03'),
(39, 'Riccardo', 'Rossini', '', '1984-06-12'),
(40, 'Saverio', 'Albani', '', '1991-01-07'),
(41, 'Enrico', 'Savadori', '', '2002-08-09'),
(42, 'Umberto', 'Anelli', '', '1990-05-09'),
(43, 'Rick', 'Roll', '', '1987-07-08'),
(44, 'Pietro', 'Ricci', '', '1963-05-04'),
(45, 'Nicola', 'Santilli', '', '1999-01-05');

-- --------------------------------------------------------

--
-- Struttura della tabella `iscrizioni`
--

CREATE TABLE `iscrizioni` (
  `CodiceCampionato` int(11) NOT NULL,
  `CodiceTeam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `iscrizioni`
--

INSERT INTO `iscrizioni` (`CodiceCampionato`, `CodiceTeam`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14),
(1, 15);

-- --------------------------------------------------------

--
-- Struttura della tabella `piloti`
--

CREATE TABLE `piloti` (
  `CodicePilota` int(11) NOT NULL,
  `Nome` char(20) NOT NULL,
  `Cognome` char(20) NOT NULL,
  `CodiceFiscale` char(16) NOT NULL,
  `DataNascita` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `piloti`
--

INSERT INTO `piloti` (`CodicePilota`, `Nome`, `Cognome`, `CodiceFiscale`, `DataNascita`) VALUES
(1, 'Andrea', 'Dovizioso', '', '1986-03-23'),
(2, 'Johann', 'Zarco', '', '1990-07-16'),
(3, 'Stefan', 'Bradl', '', '1989-11-29'),
(4, 'Maverick', 'Vinales', '', '1995-01-12'),
(5, 'Enea', 'Bastianini', '', '1997-12-30'),
(6, 'Takaaki', 'Nakagami', '', '1992-02-09'),
(7, 'Lorenzo', 'Savadori', '', '1993-04-04'),
(8, 'Brad', 'Binder', '', '1995-08-11'),
(9, 'Joan', 'Mir', '', '1997-09-01'),
(10, 'Luca', 'Marini', '', '1997-08-10'),
(11, 'Fabio', 'Quartararo', '', '1999-04-20'),
(12, 'Franco', 'Morbidelli', '', '1994-12-04'),
(13, 'Raul', 'Fernandez', '', '2000-10-23'),
(14, 'Darryn', 'Binder', '', '1998-01-21'),
(15, 'Aleix', 'Espargaro', '', '1989-07-30'),
(16, 'Alex', 'Rins', '', '1995-12-08'),
(17, 'Jack', 'Miller', '', '1995-01-18'),
(18, 'Pol', 'Espargaro', '', '1991-06-10'),
(19, 'Fabio', 'Di Giannantonio', '', '1998-10-10'),
(20, 'Michele', 'Pirro', '', '1986-07-05'),
(21, 'Francesco', 'Bagnaia', '', '1997-01-14'),
(22, 'Marco', 'Bezzecchi', '', '1998-11-12'),
(23, 'Alex', 'Marquez', '', '1996-04-23'),
(24, 'Remy', 'Gardner', '', '1998-02-24'),
(25, 'Miguel', 'Oliveira', '', '1995-01-04'),
(26, 'Jorge', 'Martin', '', '1998-01-29'),
(27, 'Marc', 'Marquez', '', '1993-02-17'),
(28, 'Cameron', 'Beaubier', '', '1992-12-06'),
(29, 'Dylan', 'Kelly', '', '2002-05-17'),
(30, 'Joe', 'Roberts', '', '1997-06-16');

-- --------------------------------------------------------

--
-- Struttura della tabella `spettatori`
--

CREATE TABLE `spettatori` (
  `CodiceSpettatore` int(11) NOT NULL,
  `Nome` char(20) NOT NULL,
  `Cognome` char(20) NOT NULL,
  `CodiceFiscale` char(16) NOT NULL,
  `DataNascita` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `spettatori`
--

INSERT INTO `spettatori` (`CodiceSpettatore`, `Nome`, `Cognome`, `CodiceFiscale`, `DataNascita`) VALUES
(1, 'Alessandro', 'Ferrari', '', '2001-05-06'),
(2, 'Fabio', 'Costa', '', '1978-05-07'),
(3, 'Giovanni', 'Fontana', '', '1970-08-09'),
(4, 'Matteo', 'Romani', '', '1998-04-07'),
(5, 'Gabriele', 'Russo', '', '1985-01-02');

-- --------------------------------------------------------

--
-- Struttura della tabella `team`
--

CREATE TABLE `team` (
  `CodiceTeam` int(11) NOT NULL,
  `Nome` char(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `team`
--

INSERT INTO `team` (`CodiceTeam`, `Nome`) VALUES
(1, 'Aprilia Racing'),
(2, 'Aruba.it Racing'),
(3, 'Ducati Lenovo Team'),
(4, 'Gresini Racing MotoGP'),
(5, 'LCR Honda'),
(6, 'Monster Energy Yamaha'),
(7, 'Mooney VR46 Racing Team'),
(8, 'Prima Pramac Racing'),
(9, 'Red Bull KTM Factory'),
(10, 'Repsol Honda Team'),
(11, 'Team SUZUKI ECSTAR'),
(12, 'Tech3 KTM Factory'),
(13, 'WithU Yamaha RNF'),
(14, 'American Racing'),
(15, 'Italtrans Racing Team');

-- --------------------------------------------------------

--
-- Struttura della tabella `telemetristi`
--

CREATE TABLE `telemetristi` (
  `CodiceTelemetrista` int(11) NOT NULL,
  `Nome` char(20) NOT NULL,
  `Cognome` char(20) NOT NULL,
  `CodiceFiscale` char(16) NOT NULL,
  `DataNascita` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `telemetristi`
--

INSERT INTO `telemetristi` (`CodiceTelemetrista`, `Nome`, `Cognome`, `CodiceFiscale`, `DataNascita`) VALUES
(1, 'Alessandro', 'Tommaselli', '', '1998-04-08'),
(2, 'Gianmarco', 'Alessandrini', '', '1986-05-03'),
(3, 'Niccolo', 'Giacomelli', '', '1995-03-07'),
(4, 'Tommaso', 'Ostuni', '', '2001-04-08'),
(5, 'Pietro', 'Rossi', '', '2001-04-03'),
(6, 'Flavio', 'Pozzi', '', '2002-07-01'),
(7, 'Riccardo', 'Bianchi', '', '1999-04-07'),
(8, 'Umberto', 'Zanni', '', '1998-05-06'),
(9, 'Carlo', 'Ugolini', '', '1997-06-05'),
(10, 'Lorenzo', 'Nicolini', '', '1998-04-07'),
(11, 'Antonio', 'Savino', '', '2001-07-03'),
(12, 'Francesco', 'Zaghini', '', '2000-04-07'),
(13, 'Marco', 'Antonelli', '', '1998-03-04'),
(14, 'Alex', 'Migliarini', '', '1997-04-02'),
(15, 'Ugo', 'Rossini', '', '1988-04-02');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `aggregazionegommisti`
--
ALTER TABLE `aggregazionegommisti`
  ADD PRIMARY KEY (`CodiceGommista`,`CodiceTeam`),
  ADD KEY `CodiceTeam` (`CodiceTeam`);

--
-- Indici per le tabelle `aggregazioneingegneri`
--
ALTER TABLE `aggregazioneingegneri`
  ADD PRIMARY KEY (`CodiceIngegnere`,`CodiceTeam`),
  ADD KEY `CodiceTeam` (`CodiceTeam`);

--
-- Indici per le tabelle `aggregazionepiloti`
--
ALTER TABLE `aggregazionepiloti`
  ADD PRIMARY KEY (`CodicePilota`,`CodiceTeam`),
  ADD KEY `CodiceTeam` (`CodiceTeam`);

--
-- Indici per le tabelle `aggregazionetelemetristi`
--
ALTER TABLE `aggregazionetelemetristi`
  ADD PRIMARY KEY (`CodiceTelemetrista`,`CodiceTeam`),
  ADD KEY `CodiceTeam` (`CodiceTeam`);

--
-- Indici per le tabelle `autodromi`
--
ALTER TABLE `autodromi`
  ADD PRIMARY KEY (`CodiceAutodromo`);

--
-- Indici per le tabelle `biglietti`
--
ALTER TABLE `biglietti`
  ADD PRIMARY KEY (`Data`,`CodiceSpettatore`,`CodiceAutodromo`),
  ADD KEY `CodiceSpettatore` (`CodiceSpettatore`),
  ADD KEY `CodiceAutodromo` (`CodiceAutodromo`);

--
-- Indici per le tabelle `campionati`
--
ALTER TABLE `campionati`
  ADD PRIMARY KEY (`CodiceCampionato`);

--
-- Indici per le tabelle `corre`
--
ALTER TABLE `corre`
  ADD PRIMARY KEY (`Anno`,`CodiceCampionato`,`CodiceAutodromo`,`CodicePilota`),
  ADD KEY `CodiceCampionato` (`CodiceCampionato`),
  ADD KEY `CodiceAutodromo` (`CodiceAutodromo`),
  ADD KEY `CodicePilota` (`CodicePilota`);

--
-- Indici per le tabelle `costruttori`
--
ALTER TABLE `costruttori`
  ADD PRIMARY KEY (`CodiceCostruttore`);

--
-- Indici per le tabelle `fornitori`
--
ALTER TABLE `fornitori`
  ADD PRIMARY KEY (`CodiceCostruttore`,`CodiceTeam`),
  ADD KEY `CodiceTeam` (`CodiceTeam`);

--
-- Indici per le tabelle `gare`
--
ALTER TABLE `gare`
  ADD PRIMARY KEY (`Anno`,`CodiceCampionato`,`CodiceAutodromo`),
  ADD KEY `gare_ibfk_1` (`CodiceCampionato`),
  ADD KEY `gare_ibfk_2` (`CodiceAutodromo`);

--
-- Indici per le tabelle `gommisti`
--
ALTER TABLE `gommisti`
  ADD PRIMARY KEY (`CodiceGommista`);

--
-- Indici per le tabelle `ingegnerimeccanici`
--
ALTER TABLE `ingegnerimeccanici`
  ADD PRIMARY KEY (`CodiceIngegnere`);

--
-- Indici per le tabelle `iscrizioni`
--
ALTER TABLE `iscrizioni`
  ADD PRIMARY KEY (`CodiceCampionato`,`CodiceTeam`),
  ADD KEY `CodiceTeam` (`CodiceTeam`);

--
-- Indici per le tabelle `piloti`
--
ALTER TABLE `piloti`
  ADD PRIMARY KEY (`CodicePilota`);

--
-- Indici per le tabelle `spettatori`
--
ALTER TABLE `spettatori`
  ADD PRIMARY KEY (`CodiceSpettatore`);

--
-- Indici per le tabelle `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`CodiceTeam`);

--
-- Indici per le tabelle `telemetristi`
--
ALTER TABLE `telemetristi`
  ADD PRIMARY KEY (`CodiceTelemetrista`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `autodromi`
--
ALTER TABLE `autodromi`
  MODIFY `CodiceAutodromo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT per la tabella `campionati`
--
ALTER TABLE `campionati`
  MODIFY `CodiceCampionato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `costruttori`
--
ALTER TABLE `costruttori`
  MODIFY `CodiceCostruttore` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT per la tabella `gommisti`
--
ALTER TABLE `gommisti`
  MODIFY `CodiceGommista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT per la tabella `ingegnerimeccanici`
--
ALTER TABLE `ingegnerimeccanici`
  MODIFY `CodiceIngegnere` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT per la tabella `piloti`
--
ALTER TABLE `piloti`
  MODIFY `CodicePilota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT per la tabella `spettatori`
--
ALTER TABLE `spettatori`
  MODIFY `CodiceSpettatore` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT per la tabella `team`
--
ALTER TABLE `team`
  MODIFY `CodiceTeam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT per la tabella `telemetristi`
--
ALTER TABLE `telemetristi`
  MODIFY `CodiceTelemetrista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `aggregazionegommisti`
--
ALTER TABLE `aggregazionegommisti`
  ADD CONSTRAINT `aggregazionegommisti_ibfk_1` FOREIGN KEY (`CodiceGommista`) REFERENCES `gommisti` (`CodiceGommista`),
  ADD CONSTRAINT `aggregazionegommisti_ibfk_2` FOREIGN KEY (`CodiceTeam`) REFERENCES `team` (`CodiceTeam`);

--
-- Limiti per la tabella `aggregazioneingegneri`
--
ALTER TABLE `aggregazioneingegneri`
  ADD CONSTRAINT `aggregazioneingegneri_ibfk_1` FOREIGN KEY (`CodiceIngegnere`) REFERENCES `ingegnerimeccanici` (`CodiceIngegnere`),
  ADD CONSTRAINT `aggregazioneingegneri_ibfk_2` FOREIGN KEY (`CodiceTeam`) REFERENCES `team` (`CodiceTeam`);

--
-- Limiti per la tabella `aggregazionepiloti`
--
ALTER TABLE `aggregazionepiloti`
  ADD CONSTRAINT `CodicePilota` FOREIGN KEY (`CodicePilota`) REFERENCES `piloti` (`CodicePilota`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `CodiceTeam` FOREIGN KEY (`CodiceTeam`) REFERENCES `team` (`CodiceTeam`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `aggregazionetelemetristi`
--
ALTER TABLE `aggregazionetelemetristi`
  ADD CONSTRAINT `aggregazionetelemetristi_ibfk_1` FOREIGN KEY (`CodiceTelemetrista`) REFERENCES `telemetristi` (`CodiceTelemetrista`),
  ADD CONSTRAINT `aggregazionetelemetristi_ibfk_2` FOREIGN KEY (`CodiceTeam`) REFERENCES `team` (`CodiceTeam`);

--
-- Limiti per la tabella `biglietti`
--
ALTER TABLE `biglietti`
  ADD CONSTRAINT `biglietti_ibfk_1` FOREIGN KEY (`CodiceSpettatore`) REFERENCES `spettatori` (`CodiceSpettatore`),
  ADD CONSTRAINT `biglietti_ibfk_2` FOREIGN KEY (`CodiceAutodromo`) REFERENCES `autodromi` (`CodiceAutodromo`);

--
-- Limiti per la tabella `corre`
--
ALTER TABLE `corre`
  ADD CONSTRAINT `corre_ibfk_1` FOREIGN KEY (`Anno`) REFERENCES `gare` (`Anno`),
  ADD CONSTRAINT `corre_ibfk_2` FOREIGN KEY (`CodiceCampionato`) REFERENCES `gare` (`CodiceCampionato`),
  ADD CONSTRAINT `corre_ibfk_3` FOREIGN KEY (`CodiceAutodromo`) REFERENCES `gare` (`CodiceAutodromo`),
  ADD CONSTRAINT `corre_ibfk_4` FOREIGN KEY (`CodicePilota`) REFERENCES `piloti` (`CodicePilota`);

--
-- Limiti per la tabella `fornitori`
--
ALTER TABLE `fornitori`
  ADD CONSTRAINT `fornitori_ibfk_1` FOREIGN KEY (`CodiceTeam`) REFERENCES `team` (`CodiceTeam`),
  ADD CONSTRAINT `fornitori_ibfk_2` FOREIGN KEY (`CodiceCostruttore`) REFERENCES `costruttori` (`CodiceCostruttore`);

--
-- Limiti per la tabella `gare`
--
ALTER TABLE `gare`
  ADD CONSTRAINT `gare_ibfk_1` FOREIGN KEY (`CodiceCampionato`) REFERENCES `campionati` (`CodiceCampionato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `gare_ibfk_2` FOREIGN KEY (`CodiceAutodromo`) REFERENCES `autodromi` (`CodiceAutodromo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `iscrizioni`
--
ALTER TABLE `iscrizioni`
  ADD CONSTRAINT `iscrizioni_ibfk_1` FOREIGN KEY (`CodiceCampionato`) REFERENCES `campionati` (`CodiceCampionato`),
  ADD CONSTRAINT `iscrizioni_ibfk_2` FOREIGN KEY (`CodiceTeam`) REFERENCES `team` (`CodiceTeam`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
