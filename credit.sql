-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 31 oct. 2020 à 14:22
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `credit`
--


--
-- Structure de la table `tclient`
--

CREATE TABLE `tclient` (
  `username` varchar(255) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `tclient`
--

INSERT INTO `tclient` (`username`, `adresse`, `mail`, `nom`, `password`, `prenom`, `tel`, `ville`) VALUES
('aa', 'Ramon Carande , 9', 'aaa', 'aaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaa', 'aa', 'pixie.cristiana@cowaway.com', 'aaaaaaaaaaa', 'rabat'),
('aba', 'Via Ippolito D Este 1', 'yguhio', 'NAR Shop', 'aba', 'nar2017@gmail.com', 'ghjklm', 'Ferrara'),
('bra', '10 rue de france', 'brahi@gmail.com', 'Mo', 'bra', 'Brahim', '0661524872', 'rabat'),
('ah', 'hay salam', 'ahlamhouari@gmail.com', 'houari', 'ah', 'ahlam', '0632547852', 'salé'),
('sam', 'Via Ippolito D Este 1', 'samirel@gmail.com', 'EL', 'sam', 'samir', '06856589635', 'Ferrara'),
('amine', 'amine', 'amine', 'amine', 'amine', 'amine', 'amine', 'amine'),
('wafi', 'wafi', 'wafi', 'wafi', 'wafi', 'wafi', 'wafi', 'wafi'),
('sami', 'sami', 'sami@gmail.com', 'sami', 'sami', 'sami', 'sami', 'sami');

-- --------------------------------------------------------

--
-- Structure de la table `tcredit`
--

CREATE TABLE `tcredit` (
  `numcredit` int(11) NOT NULL,
  `annuite` double DEFAULT NULL,
  `datecredit` datetime DEFAULT NULL,
  `dateprever` datetime DEFAULT NULL,
  `duree` int(11) DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `taux` double DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `tcredit`
--

INSERT INTO `tcredit` (`numcredit`, `annuite`, `datecredit`, `dateprever`, `duree`, `montant`, `taux`, `username`) VALUES
(2, 500.5, NULL, NULL, 140, 80000, 0.08, 'aba'),
(26, 2110.470675832132, NULL, NULL, 120, 200000, 0.05, 'amine'),
(25, 2996.4381798606305, NULL, NULL, 120, 250000, 0.08, 'amine'),
(24, 2638.088344790165, NULL, NULL, 120, 250000, 0.05, 'amine'),
(23, 2638.088344790165, NULL, NULL, 120, 250000, 0.05, 'amine'),
(22, 2110, NULL, NULL, 120, 200000, 0.05, 'sam'),
(30, 2110.470675832132, NULL, NULL, 120, 200000, 0.05, 'ah'),
(31, 2110.470675832132, NULL, NULL, 120, 200000, 0.05, 'sami'),
(29, 1751.6871338203648, NULL, NULL, 120, 200000, 0.01, 'sam'),
(27, 2300.0660009034614, NULL, NULL, 120, 200000, 0.07, 'amine'),
(28, 2110, NULL, NULL, 130, 212623.37460922328, 0.05, 'bra'),
(32, 2110, NULL, NULL, 120, 199955.3961267956, 0.05, 'sami');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `tclient`
--
ALTER TABLE `tclient`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `tcredit`
--
ALTER TABLE `tcredit`
  ADD PRIMARY KEY (`numcredit`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `tcredit`
--
ALTER TABLE `tcredit`
  MODIFY `numcredit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
