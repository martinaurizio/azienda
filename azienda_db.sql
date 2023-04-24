-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Apr 24, 2023 alle 12:41
-- Versione del server: 10.4.14-MariaDB
-- Versione PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `azienda`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `badge`
--

CREATE TABLE `badge` (
  `codice` int(10) NOT NULL,
  `CF` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `badge`
--

INSERT INTO `badge` (`codice`, `CF`) VALUES
(1234567891, 'CHRSCR90FEPS902D'),
(1234567892, 'FRNMNT93TFSS209P'),
(1234567893, 'LCUBNC89SKFP038F'),
(1234567894, 'LCULPU79SFFW203G'),
(1234567890, 'NGLPRD88SOGH201R'),
(1234567895, 'RSSMRA78RADP293S'),
(1234567896, 'SNDLSA84FWOQ201S');

-- --------------------------------------------------------

--
-- Struttura della tabella `ceo`
--

CREATE TABLE `ceo` (
  `matricola` int(6) NOT NULL,
  `dataAssunzione` date DEFAULT NULL,
  `CF` varchar(16) NOT NULL,
  `CFAgente` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `ceo`
--

INSERT INTO `ceo` (`matricola`, `dataAssunzione`, `CF`, `CFAgente`) VALUES
(165, '2023-03-02', 'RSSMRA78RADP293S', NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `dev`
--

CREATE TABLE `dev` (
  `matricola` int(6) NOT NULL,
  `dataAssunzione` date NOT NULL,
  `CF` varchar(16) NOT NULL,
  `CFAgente` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `dev`
--

INSERT INTO `dev` (`matricola`, `dataAssunzione`, `CF`, `CFAgente`) VALUES
(182, '2023-03-26', 'CHRSCR90FEPS902D', 'RSSMRA78RADP293S'),
(190, '2023-03-25', 'FRNMNT93TFSS209P', 'RSSMRA78RADP293S'),
(191, '2023-03-28', 'LCUBNC89SKFP038F', 'RSSMRA78RADP293S'),
(199, '2023-04-01', 'NGLPRD88SOGH201R', 'RSSMRA78RADP293S'),
(200, '2023-04-06', 'LXANDR94PANO294T', 'RSSMRA78RADP293S');

-- --------------------------------------------------------

--
-- Struttura della tabella `impiegato`
--

CREATE TABLE `impiegato` (
  `nome` varchar(40) NOT NULL,
  `cognome` varchar(40) NOT NULL,
  `CF` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `impiegato`
--

INSERT INTO `impiegato` (`nome`, `cognome`, `CF`) VALUES
('Chiara', 'Scura', 'CHRSCR90FEPS902D'),
('Franca', 'Mente', 'FRNMNT93TFSS209P'),
('Luca', 'Bianchi', 'LCUBNC89SKFP038F'),
('Lucio', 'Lupo', 'LCULPU79SFFW203G'),
('Alex', 'Andro', 'LXANDR94PANO294T'),
('Angelo', 'Paradiso', 'NGLPRD88SOGH201R'),
('Mario', 'Rossi', 'RSSMRA78RADP293S'),
('Sandra', 'Ales', 'SNDLSA84FWOQ201S');

-- --------------------------------------------------------

--
-- Struttura della tabella `pm`
--

CREATE TABLE `pm` (
  `matricola` int(6) NOT NULL,
  `dataAssunzione` date NOT NULL,
  `CF` varchar(16) NOT NULL,
  `CFAgente` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `pm`
--

INSERT INTO `pm` (`matricola`, `dataAssunzione`, `CF`, `CFAgente`) VALUES
(168, '2023-03-22', 'LCULPU79SFFW203G', 'RSSMRA78RADP293S'),
(180, '2023-03-23', 'SNDLSA84FWOQ201S', 'RSSMRA78RADP293S');

-- --------------------------------------------------------

--
-- Struttura della tabella `progetto`
--

CREATE TABLE `progetto` (
  `codice` varchar(30) NOT NULL,
  `CF` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `progetto`
--

INSERT INTO `progetto` (`codice`, `CF`) VALUES
('WEB00339810000000000999110MI', 'LCULPU79SFFW203G'),
('WEB0000381000000000002201VE', 'SNDLSA84FWOQ201S');

-- --------------------------------------------------------

--
-- Struttura della tabella `task`
--

CREATE TABLE `task` (
  `ID` varchar(50) NOT NULL,
  `codice` varchar(30) NOT NULL,
  `descrizione` text DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `deadline` date NOT NULL,
  `CF_pm` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `task`
--

INSERT INTO `task` (`ID`, `codice`, `descrizione`, `status`, `deadline`, `CF_pm`) VALUES
('000000000000000000000000001100101523541010102', 'WEB0000381000000000002201VE', 'Aggiornare il DB', 1, '2023-04-27', 'SNDLSA84FWOQ201S'),
('000000000000000000000000001100101523541010103', 'WEB00339810000000000999110MI', 'Aggiornare le CTA della homepage', 0, '2023-04-21', 'LCULPU79SFFW203G'),
('000000000000000000000000001100101523541010109', 'WEB0000381000000000002201VE', 'Inviare la bozza al cliente', 0, '2023-04-20', 'SNDLSA84FWOQ201S'),
('0000000000000000000000000011001015235410101098', 'WEB00339810000000000999110MI', 'Aggiungere la nuova pagina', 0, '2023-04-21', 'LCULPU79SFFW203G'),
('000000000000000000000000001100101523541010115', 'WEB00339810000000000999110MI', 'Rivedere la SEO', 0, '2023-04-16', 'LCULPU79SFFW203G'),
('000000000000000000000000001100101523541010127', 'WEB00339810000000000999110MI', 'Correggere il form', 1, '2023-04-30', 'LCULPU79SFFW203G'),
('000000000000000000000000001100101523541010199', 'WEB00339810000000000999110MI', 'Fare una prova', 0, '2023-04-19', 'LCULPU79SFFW203G'),
('AAABBBCCC111', 'WEB0000381000000000002201VE', 'Provare esperimento aggiunta', 0, '2023-03-14', 'SNDLSA84FWOQ201S');

--
-- Trigger `task`
--
DELIMITER $$
CREATE TRIGGER `checkTaskStatus` BEFORE INSERT ON `task` FOR EACH ROW BEGIN
IF (NEW.deadline< NOW() AND NEW.status=1) THEN
SET NEW.status = 0;
END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struttura della tabella `task_dev`
--

CREATE TABLE `task_dev` (
  `ID` varchar(50) NOT NULL,
  `codice` varchar(30) NOT NULL,
  `CF` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `task_dev`
--

INSERT INTO `task_dev` (`ID`, `codice`, `CF`) VALUES
('000000000000000000000000001100101523541010102', 'WEB0000381000000000002201VE', 'LCUBNC89SKFP038F'),
('000000000000000000000000001100101523541010103', 'WEB00339810000000000999110MI', 'CHRSCR90FEPS902D'),
('000000000000000000000000001100101523541010109', 'WEB0000381000000000002201VE', 'NGLPRD88SOGH201R'),
('000000000000000000000000001100101523541010115', 'WEB00339810000000000999110MI', 'FRNMNT93TFSS209P'),
('000000000000000000000000001100101523541010127', 'WEB00339810000000000999110MI', 'CHRSCR90FEPS902D');

-- --------------------------------------------------------

--
-- Struttura della tabella `team`
--

CREATE TABLE `team` (
  `nome` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `team`
--

INSERT INTO `team` (`nome`) VALUES
('TeamA'),
('TeamB');

-- --------------------------------------------------------

--
-- Struttura della tabella `team_dev`
--

CREATE TABLE `team_dev` (
  `nome` varchar(30) NOT NULL,
  `CF` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `team_dev`
--

INSERT INTO `team_dev` (`nome`, `CF`) VALUES
('TeamA', 'CHRSCR90FEPS902D'),
('TeamA', 'FRNMNT93TFSS209P'),
('TeamA', 'LXANDR94PANO294T'),
('TeamB', 'LCUBNC89SKFP038F'),
('TeamB', 'NGLPRD88SOGH201R');

-- --------------------------------------------------------

--
-- Struttura della tabella `team_pm`
--

CREATE TABLE `team_pm` (
  `nome` varchar(30) NOT NULL,
  `CF` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `team_pm`
--

INSERT INTO `team_pm` (`nome`, `CF`) VALUES
('TeamA', 'LCULPU79SFFW203G'),
('TeamB', 'SNDLSA84FWOQ201S');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `badge`
--
ALTER TABLE `badge`
  ADD PRIMARY KEY (`codice`),
  ADD KEY `impiegato_badge` (`CF`);

--
-- Indici per le tabelle `ceo`
--
ALTER TABLE `ceo`
  ADD PRIMARY KEY (`matricola`),
  ADD KEY `impiegato_ceo` (`CF`),
  ADD KEY `ceo_assuntoda` (`CFAgente`);

--
-- Indici per le tabelle `dev`
--
ALTER TABLE `dev`
  ADD PRIMARY KEY (`matricola`),
  ADD KEY `impiegato_dev` (`CF`),
  ADD KEY `dev_assuntoda` (`CFAgente`);

--
-- Indici per le tabelle `impiegato`
--
ALTER TABLE `impiegato`
  ADD PRIMARY KEY (`CF`);

--
-- Indici per le tabelle `pm`
--
ALTER TABLE `pm`
  ADD PRIMARY KEY (`matricola`),
  ADD KEY `impiegato_pm` (`CF`),
  ADD KEY `pm_assuntoda` (`CFAgente`);

--
-- Indici per le tabelle `progetto`
--
ALTER TABLE `progetto`
  ADD PRIMARY KEY (`codice`),
  ADD KEY `progetto_assegnato_al_pm` (`CF`);

--
-- Indici per le tabelle `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`ID`,`codice`),
  ADD KEY `task_creato_dal_pm` (`CF_pm`),
  ADD KEY `codice_progetto` (`codice`);

--
-- Indici per le tabelle `task_dev`
--
ALTER TABLE `task_dev`
  ADD PRIMARY KEY (`ID`,`CF`,`codice`),
  ADD KEY `CF_dev` (`CF`),
  ADD KEY `ID_e_codice_del_task` (`ID`,`codice`),
  ADD KEY `codice_relativo_al_progetto` (`codice`);

--
-- Indici per le tabelle `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`nome`);

--
-- Indici per le tabelle `team_dev`
--
ALTER TABLE `team_dev`
  ADD PRIMARY KEY (`nome`,`CF`),
  ADD KEY `CF_dev_nel_team` (`CF`);

--
-- Indici per le tabelle `team_pm`
--
ALTER TABLE `team_pm`
  ADD PRIMARY KEY (`nome`,`CF`),
  ADD KEY `CF_pm_nel_team` (`CF`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `badge`
--
ALTER TABLE `badge`
  ADD CONSTRAINT `impiegato_badge` FOREIGN KEY (`CF`) REFERENCES `impiegato` (`CF`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `ceo`
--
ALTER TABLE `ceo`
  ADD CONSTRAINT `ceo_assuntoda` FOREIGN KEY (`CFAgente`) REFERENCES `impiegato` (`CF`),
  ADD CONSTRAINT `impiegato_ceo` FOREIGN KEY (`CF`) REFERENCES `impiegato` (`CF`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `dev`
--
ALTER TABLE `dev`
  ADD CONSTRAINT `dev_assuntoda` FOREIGN KEY (`CFAgente`) REFERENCES `ceo` (`CF`),
  ADD CONSTRAINT `impiegato_dev` FOREIGN KEY (`CF`) REFERENCES `impiegato` (`CF`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `pm`
--
ALTER TABLE `pm`
  ADD CONSTRAINT `impiegato_pm` FOREIGN KEY (`CF`) REFERENCES `impiegato` (`CF`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pm_assuntoda` FOREIGN KEY (`CFAgente`) REFERENCES `ceo` (`CF`);

--
-- Limiti per la tabella `progetto`
--
ALTER TABLE `progetto`
  ADD CONSTRAINT `progetto_assegnato_al_pm` FOREIGN KEY (`CF`) REFERENCES `pm` (`CF`);

--
-- Limiti per la tabella `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `codice_progetto` FOREIGN KEY (`codice`) REFERENCES `progetto` (`codice`),
  ADD CONSTRAINT `task_creato_dal_pm` FOREIGN KEY (`CF_pm`) REFERENCES `pm` (`CF`);

--
-- Limiti per la tabella `task_dev`
--
ALTER TABLE `task_dev`
  ADD CONSTRAINT `CF_dev` FOREIGN KEY (`CF`) REFERENCES `dev` (`CF`),
  ADD CONSTRAINT `ID_task` FOREIGN KEY (`ID`) REFERENCES `task` (`ID`),
  ADD CONSTRAINT `codice_relativo_al_progetto` FOREIGN KEY (`codice`) REFERENCES `task` (`codice`);

--
-- Limiti per la tabella `team_dev`
--
ALTER TABLE `team_dev`
  ADD CONSTRAINT `CF_dev_nel_team` FOREIGN KEY (`CF`) REFERENCES `dev` (`CF`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nome_team_listadev` FOREIGN KEY (`nome`) REFERENCES `team` (`nome`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `team_pm`
--
ALTER TABLE `team_pm`
  ADD CONSTRAINT `CF_pm_nel_team` FOREIGN KEY (`CF`) REFERENCES `pm` (`CF`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nome_team_listapm` FOREIGN KEY (`nome`) REFERENCES `team` (`nome`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
