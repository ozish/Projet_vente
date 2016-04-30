-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 23 Mars 2016 à 18:05
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `formation`
--

-- --------------------------------------------------------

--
-- Structure de la table `cercle`
--

CREATE TABLE IF NOT EXISTS `cercle` (
  `ID_Cercle` int(11) NOT NULL AUTO_INCREMENT,
  `x` int(11) NOT NULL,
  `y` int(11) NOT NULL,
  `rayon` int(11) NOT NULL,
  PRIMARY KEY (`ID_Cercle`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `cercle`
--

INSERT INTO `cercle` (`ID_Cercle`, `x`, `y`, `rayon`) VALUES
(1, 2, 5, 8);

-- --------------------------------------------------------

--
-- Structure de la table `objet_vente`
--

CREATE TABLE IF NOT EXISTS `objet_vente` (
  `ID_Objet` int(6) NOT NULL DEFAULT '0',
  `Designation` varchar(30) NOT NULL,
  `Prix` int(5) NOT NULL,
  `Categories` varchar(15) NOT NULL,
  `Lieu` varchar(15) NOT NULL,
  `Date` date NOT NULL,
  `Email` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_Objet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `points`
--

CREATE TABLE IF NOT EXISTS `points` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `x` int(11) NOT NULL,
  `y` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `points`
--

INSERT INTO `points` (`ID`, `x`, `y`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID_Utilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(40) NOT NULL,
  `mdp` varchar(30) NOT NULL,
  `Role` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_Utilisateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=59 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_Utilisateur`, `Login`, `mdp`, `Role`, `Email`) VALUES
(2, 'senna', 'mouya', 'Utilisateur', ''),
(3, 'toto', 'mlkjtp', 'Administrateur', ''),
(4, 'titi', 'titietgros', 'Utilisateur', ''),
(5, 'Vette1', 'Seb', 'Administrateur', ''),
(15, 'gege', 'mdp', 'Admin', ''),
(16, 'gege', 'mdp', 'Admin', ''),
(17, 'Bruno', '2351983', 'Utilisateur', ''),
(18, 'bhj@hjk', '', 'Utilisateur', ''),
(19, 'bvkhjv@hgjok', '123', 'Utilisateur', ''),
(21, 'rtshy', 'hgkg', 'Utilisateur', ''),
(34, 'duchmol', '123', 'Utilisateur', 'oz@hot.fr'),
(35, 'duchmol', '123', 'Utilisateur', 'oz@hot.fr'),
(52, 'azerty', 'aze', 'Utilisateur', 'azerty@azerty.com'),
(53, 'azerty', 'aze', 'Utilisateur', 'azerty@azerty.com'),
(54, 'qwerty', 'aze', 'Utilisateur', 'qwerty@azerty.com'),
(55, 'qwerty', 'aze', 'Utilisateur', 'qwerty@azerty.com'),
(56, 'zerzerzer', 'aze', 'Utilisateur', 'ezsrzerze@azerty.com'),
(57, 'azertyoz', '123', 'Utilisateur', 'azerty@azerty.com'),
(58, '123oz', '123', 'Utilisateur', 'oz@azerty.com');
--
-- Base de données :  `geometrie`
--

-- --------------------------------------------------------

--
-- Structure de la table `cercle`
--

CREATE TABLE IF NOT EXISTS `cercle` (
  `ID_Cercle` int(11) NOT NULL AUTO_INCREMENT,
  `X` int(11) NOT NULL,
  `Y` int(11) NOT NULL,
  `Rayon` double NOT NULL,
  `Surface` double NOT NULL,
  `Perimetre` double NOT NULL,
  PRIMARY KEY (`ID_Cercle`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `cercle`
--

INSERT INTO `cercle` (`ID_Cercle`, `X`, `Y`, `Rayon`, `Surface`, `Perimetre`) VALUES
(2, 20, 25, 28, 2463.0086404143976, 175.92918860102841),
(3, 20, 25, 28, 2463.0086404143976, 175.92918860102841),
(4, 20, 25, 28, 2463.0086404143976, 175.92918860102841);

-- --------------------------------------------------------

--
-- Structure de la table `point`
--

CREATE TABLE IF NOT EXISTS `point` (
  `ID_Point` int(11) NOT NULL,
  `X` int(11) NOT NULL,
  `Y` int(11) NOT NULL,
  PRIMARY KEY (`ID_Point`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `rectangle`
--

CREATE TABLE IF NOT EXISTS `rectangle` (
  `ID_Rectangle` int(11) NOT NULL AUTO_INCREMENT,
  `X` int(11) NOT NULL,
  `Y` int(11) NOT NULL,
  `Longueur` double NOT NULL,
  `Largeur` double NOT NULL,
  `Surface` double NOT NULL,
  `Perimetre` double NOT NULL,
  PRIMARY KEY (`ID_Rectangle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;
--
-- Base de données :  `projet_etude`
--

-- --------------------------------------------------------

--
-- Structure de la table `objet`
--

CREATE TABLE IF NOT EXISTS `objet` (
  `ID_Objet` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` char(15) NOT NULL,
  `Prix` int(6) NOT NULL,
  `Categories` char(15) NOT NULL,
  `Lieu` char(15) NOT NULL,
  `Heure` datetime NOT NULL,
  PRIMARY KEY (`ID_Objet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;
--
-- Base de données :  `test`
--

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
