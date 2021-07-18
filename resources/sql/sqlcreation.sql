-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Erstellungszeit: 17. Jul 2021 um 18:57
-- Server-Version: 10.3.30-MariaDB-1:10.3.30+maria~focal
-- PHP-Version: 7.4.21


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";



DROP TABLE IF EXISTS `airport_frequencies`;
DROP TABLE IF EXISTS `airports`;
DROP TABLE IF EXISTS `countries`;
DROP TABLE IF EXISTS `navaids`;
DROP TABLE IF EXISTS `regions`;
DROP TABLE IF EXISTS `runways`;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


--
-- Datenbank: `airports`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `airports`
--

CREATE TABLE `airports` (
  `id` bigint(20) NOT NULL,
  `ident` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `type` char(20) COLLATE latin1_general_ci DEFAULT NULL,
  `name` char(100) COLLATE latin1_general_ci DEFAULT NULL,
  `latitude_deg` char(20) COLLATE latin1_general_ci DEFAULT NULL,
  `longitude_deg` char(20) COLLATE latin1_general_ci DEFAULT NULL,
  `elevation_ft` int(11) DEFAULT NULL,
  `continent` char(2) COLLATE latin1_general_ci DEFAULT NULL,
  `iso_country` char(2) COLLATE latin1_general_ci DEFAULT NULL,
  `iso_region` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `municipality` char(30) COLLATE latin1_general_ci DEFAULT NULL,
  `scheduled_service` tinyint(1) DEFAULT NULL,
  `gps_code` char(4) COLLATE latin1_general_ci DEFAULT NULL,
  `iata_code` char(4) COLLATE latin1_general_ci DEFAULT NULL,
  `local_code` char(4) COLLATE latin1_general_ci DEFAULT NULL,
  `home_link` char(200) COLLATE latin1_general_ci DEFAULT NULL,
  `wikipedia_link` char(200) COLLATE latin1_general_ci DEFAULT NULL,
  `keywords` char(100) COLLATE latin1_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `airport_frequencies`
--

CREATE TABLE `airport_frequencies` (
  `id` int(11) NOT NULL,
  `airport_ref` int(11) DEFAULT NULL,
  `airport_ident` char(4) COLLATE latin1_general_ci DEFAULT NULL,
  `type` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `description` char(100) COLLATE latin1_general_ci DEFAULT NULL,
  `frequency_mhz` char(10) COLLATE latin1_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `countries`
--

CREATE TABLE `countries` (
  `id` int(11) NOT NULL,
  `code` char(2) COLLATE latin1_general_ci DEFAULT NULL,
  `name` char(50) COLLATE latin1_general_ci DEFAULT NULL,
  `continent` char(2) COLLATE latin1_general_ci DEFAULT NULL,
  `wikipedia_link` char(100) COLLATE latin1_general_ci DEFAULT NULL,
  `keywords` char(100) COLLATE latin1_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `navaids`
--

CREATE TABLE `navaids` (
  `filename` char(100) COLLATE latin1_general_ci DEFAULT NULL,
  `ident` char(4) COLLATE latin1_general_ci DEFAULT NULL,
  `name` char(100) COLLATE latin1_general_ci DEFAULT NULL,
  `type` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `frequency_khz` int(11) DEFAULT NULL,
  `latitude_deg` char(40) COLLATE latin1_general_ci DEFAULT NULL,
  `longitude_deg` char(40) COLLATE latin1_general_ci DEFAULT NULL,
  `elevation_ft` int(11) DEFAULT NULL,
  `iso_country` char(2) COLLATE latin1_general_ci DEFAULT NULL,
  `dme_frequency_khz` int(11) DEFAULT NULL,
  `dme_channel` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `dme_latitude_deg` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `dme_longitude_deg` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `dme_elevation_ft` int(11) DEFAULT NULL,
  `slaved_variation_deg` int(11) DEFAULT NULL,
  `magnetic_variation_deg` int(11) DEFAULT NULL,
  `usageType` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `power` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `associated_airport` char(10) COLLATE latin1_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `regions`
--

CREATE TABLE `regions` (
  `id` int(11) NOT NULL,
  `code` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `local_code` char(2) COLLATE latin1_general_ci DEFAULT NULL,
  `name` char(50) COLLATE latin1_general_ci DEFAULT NULL,
  `continent` char(2) COLLATE latin1_general_ci DEFAULT NULL,
  `iso_country` char(2) COLLATE latin1_general_ci DEFAULT NULL,
  `wikipedia_link` char(100) COLLATE latin1_general_ci DEFAULT NULL,
  `keywords` char(100) COLLATE latin1_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `runways`
--

CREATE TABLE `runways` (
  `id` int(11) NOT NULL,
  `airport_ref` int(11) DEFAULT NULL,
  `airport_ident` char(4) COLLATE latin1_general_ci DEFAULT NULL,
  `length_ft` int(11) DEFAULT NULL,
  `width_ft` int(11) DEFAULT NULL,
  `surface` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `lighted` tinyint(1) DEFAULT NULL,
  `closed` tinyint(1) DEFAULT NULL,
  `le_ident` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `le_latitude_deg` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `le_longitude_deg` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `le_elevation_ft` int(11) DEFAULT NULL,
  `le_heading_degT` int(11) DEFAULT NULL,
  `le_displaced_threshold_ft` int(11) DEFAULT NULL,
  `he_ident` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `he_latitude_deg` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `he_longitude_deg` char(10) COLLATE latin1_general_ci DEFAULT NULL,
  `he_elevation_ft` int(11) DEFAULT NULL,
  `he_heading_degT` int(11) DEFAULT NULL,
  `he_displaced_threshold_ft` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `airports`
--
ALTER TABLE `airports`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ident` (`ident`);

--
-- Indizes für die Tabelle `airport_frequencies`
--
ALTER TABLE `airport_frequencies`
  ADD PRIMARY KEY (`id`),
  ADD KEY `airport_ref` (`airport_ref`),
  ADD KEY `airport_ident` (`airport_ident`);

--
-- Indizes für die Tabelle `countries`
--
ALTER TABLE `countries`
  ADD PRIMARY KEY (`id`),
  ADD KEY `code` (`code`);

--
-- Indizes für die Tabelle `regions`
--
ALTER TABLE `regions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `code` (`code`);

--
-- Indizes für die Tabelle `runways`
--
ALTER TABLE `runways`
  ADD PRIMARY KEY (`id`),
  ADD KEY `airport_ref` (`airport_ref`),
  ADD KEY `airport_ident` (`airport_ident`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
