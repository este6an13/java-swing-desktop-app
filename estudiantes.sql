-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2019 a las 01:54:22
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `estudiantes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datosacceso`
--

CREATE TABLE `datosacceso` (
  `nombre` varchar(30) NOT NULL,
  `id` varchar(10) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `datosacceso`
--

INSERT INTO `datosacceso` (`nombre`, `id`, `password`) VALUES
('Miranda Peña', '0005', 'mirandap'),
('David Bolaños', '0004', 'davidb'),
('Katherine Lara', '0007', 'katherinel'),
('Sergio Cifuentes', '0006', 'sergioc'),
('Martín Zamora', '0001', 'martinz'),
('Andrea González', '0000', 'andreag'),
('Snader Díaz', '0012', 'snaderd'),
('Carolina Soler', '0003', 'carolinas'),
('Camilo Quintana', '0002', 'camiloq'),
('Sofía Méndez', '0011', 'sofiam'),
('Vanessa Rodríguez', '0009', 'vanessar'),
('César Moreno', '0008', 'cesarm'),
('Brayan Vanegas', '0010', 'brayanv');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
