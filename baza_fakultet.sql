-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 15, 2018 at 09:57 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `baza_fakultet`
--

-- --------------------------------------------------------

--
-- Table structure for table `predmet`
--

CREATE TABLE `predmet` (
  `id` int(11) NOT NULL,
  `espb` varchar(200) COLLATE utf8mb4_bin NOT NULL,
  `naziv` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `opis` longtext COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `predmet`
--

INSERT INTO `predmet` (`id`, `espb`, `naziv`, `opis`) VALUES
(1, '10', 'Uvod u objektno-orijentisano programiranje', 'Predmet uvodi studente u osnovne koncepte programiranja iz perspektive objektno-orijentisanog programiranja. Nastavne teme obuhvataju jednostavne tipove podataka, upravljačke strukture, strukture podataka u vidu nizova karaktera i redova, algoritme, kao i upoznavanje sa programskim jezicima. Studenti se upoznaju sa osnovama objektno-orijentisanog programiranja: objektima, klasama, metodima, prenosu parametar, učauravanja, nasleđivanja i polimorfizma. Pored toga, studenti ovladavaju i osnovama sintakse i semantike programskih jezika: promenljive, tipovi, izrazi, dodeljivanje vrednosti, ulazno-izlazne instrukcije, uslovne i iterativne upravljačke strukture i strukturisane dekompozicija. Izlažu se principi softverskog inženjerstva i razvoja osnovnih veština programiranja u objektno-orijentisanim jezicima.'),
(2, '8', 'Arhitektura računara', 'Predmet uvodi studente u oblast arhitektura modernih računarskih sistema. Kurs pokriva teme kao što su sekvencijalna i paralelna izvršavanja instrukcija, sinkronizacija, cjevovode, vektorsko procesiranje. SIMD i MIMD mašine. Predstavljene su i mreže sa više stepena i računarske interkonekcione mreže. Uvodi se pojam usmjeravanja i kontrole protoka u tim mrežama. Analiziraju se koncepti kao što su deljena memorija, sistemi multiračunara, keš memorija i koherencija keš memorije. Cilj predmeta je da upozna studenta s modernom arhitekturom računara. Studenti će se upoznati s organizacijom računarskog sistema, srodnim oblastima računarskih nauka, analizom performasi, metodama mjerenje performansi.'),
(3, '8', 'Matematika 1', 'Ovaj nastavni predmet omogućava studentima da razumeju i ovladaju osnovnim znanjima iz matematike potrebnim za praćenje daljih studija koji su predviđeni za izučavanje na tehničkim fakultetima. U okviru ovog predmeta studenti će, na početku, obnoviti i proširi svoja znanja koja se odnose na pojam broja, matematičku logiku i teoriju skupova. Nakon toga, obrađuju se osnovni pojmovi iz algebarskih struktura, kao elementi apstraktne algebre, zaključno sa poljem kompleksnih brojeva. Izlaganje gradiva se, potom, nastavlja izučavanjem elemenata linearne algebre i to: determinanti, matrica i sistema linearnih jednačina.\r\nJedan deo gradiva je posvećen vektorskoj algebra, kao i analitičkoj geometriji u prostoru. Uvod u matematičku analizu realne funkcije jedne realne promenljive počinje predavanjima koji su u vezi sa pregledom elementarnih i neelemantarnih funkcija, preko realnih nizova i brojnih redova, zatim granične vrednosti i neprekidnosti realne funkcije jedne promenljive, pa sve do diferencijalnog računa realne funkcije jedne promenljive.\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `prijava_ispita`
--

CREATE TABLE `prijava_ispita` (
  `id` int(11) NOT NULL,
  `student_id` int(11) DEFAULT NULL,
  `termin_ispita_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `prijava_ispita`
--

INSERT INTO `prijava_ispita` (`id`, `student_id`, `termin_ispita_id`) VALUES
(22, 2, 1),
(23, 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `adresa` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `ime` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `pol` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  `prezime` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `telefon` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `adresa`, `email`, `ime`, `password`, `pol`, `prezime`, `telefon`, `username`) VALUES
(2, 'Somborska 45/32', 'mary.mary_94@hotmail.com', 'Marija', 'marija', 'Ženski', 'Stošić', '0612857340', 'marija.stosic'),
(3, 'Somborska 45/22', 'nikolast3@gmail.com', 'NIkola', 'nikola', 'Muški', 'Stošić', '0641021579', 'nikola.stosic');

-- --------------------------------------------------------

--
-- Table structure for table `termin_ispita`
--

CREATE TABLE `termin_ispita` (
  `id` int(11) NOT NULL,
  `datum` date NOT NULL,
  `vreme` varchar(5) COLLATE utf8mb4_bin NOT NULL,
  `predmet_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `termin_ispita`
--

INSERT INTO `termin_ispita` (`id`, `datum`, `vreme`, `predmet_id`) VALUES
(1, '2018-07-18', '14:00', 1),
(2, '2018-07-19', '11:00', 2),
(3, '2018-07-19', '15:00', 3);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `student_id` int(11) NOT NULL,
  `enabled` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `student_id`, `enabled`) VALUES
('marija.stosic', 'marija', 2, 1),
('nikola.stosic', 'nikola', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL,
  `role` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`id`, `role`, `username`) VALUES
(1, 'ROLE_USER', 'marija.stosic'),
(2, 'ROLE_USER', 'nikola.stosic');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `predmet`
--
ALTER TABLE `predmet`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `prijava_ispita`
--
ALTER TABLE `prijava_ispita`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK74C6E2061FD04720` (`termin_ispita_id`),
  ADD KEY `FK74C6E206572A9457` (`student_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `termin_ispita`
--
ALTER TABLE `termin_ispita`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3B8AABBE3DDCC857` (`predmet_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`),
  ADD KEY `fk_users_korisnik` (`student_id`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `predmet`
--
ALTER TABLE `predmet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `prijava_ispita`
--
ALTER TABLE `prijava_ispita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `termin_ispita`
--
ALTER TABLE `termin_ispita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `prijava_ispita`
--
ALTER TABLE `prijava_ispita`
  ADD CONSTRAINT `FK74C6E2061FD04720` FOREIGN KEY (`termin_ispita_id`) REFERENCES `termin_ispita` (`id`),
  ADD CONSTRAINT `FK74C6E206572A9457` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);

--
-- Constraints for table `termin_ispita`
--
ALTER TABLE `termin_ispita`
  ADD CONSTRAINT `FK3B8AABBE3DDCC857` FOREIGN KEY (`predmet_id`) REFERENCES `predmet` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
