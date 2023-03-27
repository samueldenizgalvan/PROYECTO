-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-03-2023 a las 13:57:55
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `universidad`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignatura`
--

CREATE TABLE `asignatura` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `creditos` int(10) UNSIGNED NOT NULL,
  `tipo` enum('básica','obligatoria','optativa') NOT NULL,
  `curso` int(3) UNSIGNED NOT NULL,
  `cuatrimestre` int(3) UNSIGNED NOT NULL,
  `id_profesor` int(10) UNSIGNED DEFAULT NULL,
  `id_grado` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `asignatura`
--

INSERT INTO `asignatura` (`id`, `nombre`, `creditos`, `tipo`, `curso`, `cuatrimestre`, `id_profesor`, `id_grado`) VALUES
(2, 'Cálculo', 6, 'básica', 1, 1, 14, 4),
(3, 'Física para informática', 6, 'básica', 1, 1, 3, 4),
(4, 'Introducción a la programación', 6, 'básica', 1, 1, 14, 4),
(5, 'Organización y gestión de empresas', 6, 'básica', 1, 1, 3, 4),
(6, 'Estadística', 6, 'básica', 1, 2, 14, 4),
(7, 'Estructura y tecnología de computadores', 6, 'básica', 1, 2, 3, 4),
(8, 'FP Desarrollo de aplicaciones multiplataforma', 6, 'básica', 1, 2, 14, 4),
(9, 'Lógica y algorítmica', 6, 'básica', 1, 2, 3, 4),
(10, 'Metodología de la programación', 6, 'básica', 1, 2, 14, 4),
(11, 'Arquitectura de Computadores', 6, 'básica', 2, 1, 3, 4),
(12, 'Estructura de Datos y Algoritmos I', 6, 'obligatoria', 2, 1, 3, 4),
(13, 'Ingeniería del Software', 6, 'obligatoria', 2, 1, 14, 4),
(14, 'Sistemas Inteligentes', 6, 'obligatoria', 2, 1, 3, 4),
(15, 'Sistemas Operativos', 6, 'obligatoria', 2, 1, 14, 4),
(16, 'Bases de Datos', 6, 'básica', 2, 2, 14, 4),
(17, 'Estructura de Datos y Algoritmos II', 6, 'obligatoria', 2, 2, 14, 4),
(18, 'Fundamentos de Redes de Computadores', 6, 'obligatoria', 2, 2, 3, 4),
(19, 'Planificación y Gestión de Proyectos Informáticos', 6, 'obligatoria', 2, 2, 3, 4),
(20, 'Programación de Servicios Software', 6, 'obligatoria', 2, 2, 14, 4),
(21, 'Desarrollo de interfaces de usuario', 6, 'obligatoria', 3, 1, 14, 4),
(23, 'Integración de las Tecnologías de la Información en las Organizaciones', 6, 'optativa', 3, 1, NULL, 4),
(24, 'Modelado y Diseño del Software 1', 6, 'optativa', 3, 1, NULL, 4),
(25, 'Multiprocesadores', 6, 'optativa', 3, 1, NULL, 4),
(26, 'Seguridad y cumplimiento normativo', 6, 'optativa', 3, 1, NULL, 4),
(27, 'Sistema de Información para las Organizaciones', 6, 'optativa', 3, 1, NULL, 4),
(28, 'Tecnologías web', 6, 'optativa', 3, 1, NULL, 4),
(29, 'Teoría de códigos y criptografía', 6, 'optativa', 3, 1, NULL, 4),
(30, 'Administración de bases de datos', 6, 'optativa', 3, 2, NULL, 4),
(31, 'Herramientas y Métodos de Ingeniería del Software', 6, 'optativa', 3, 2, NULL, 4),
(32, 'Informática industrial y robótica', 6, 'optativa', 3, 2, NULL, 4),
(33, 'Ingeniería de Sistemas de Información', 6, 'optativa', 3, 2, NULL, 4),
(34, 'Modelado y Diseño del Software 2', 6, 'optativa', 3, 2, NULL, 4),
(35, 'Negocio Electrónico', 6, 'optativa', 3, 2, NULL, 4),
(36, 'Periféricos e interfaces', 6, 'optativa', 3, 2, NULL, 4),
(37, 'Sistemas de tiempo real', 6, 'optativa', 3, 2, NULL, 4),
(38, 'Tecnologías de acceso a red', 6, 'optativa', 3, 2, NULL, 4),
(39, 'Tratamiento digital de imágenes', 6, 'optativa', 3, 2, NULL, 4),
(40, 'Administración de redes y sistemas operativos', 6, 'optativa', 4, 1, NULL, 4),
(41, 'Almacenes de Datos', 6, 'optativa', 4, 1, NULL, 4),
(42, 'Fiabilidad y Gestión de Riesgos', 6, 'optativa', 4, 1, NULL, 4),
(43, 'Líneas de Productos Software', 6, 'optativa', 4, 1, NULL, 4),
(44, 'Procesos de Ingeniería del Software 1', 6, 'optativa', 4, 1, NULL, 4),
(45, 'Tecnologías multimedia', 6, 'optativa', 4, 1, NULL, 4),
(46, 'Análisis y planificación de las TI', 6, 'optativa', 4, 2, NULL, 4),
(47, 'Desarrollo Rápido de Aplicaciones', 6, 'optativa', 4, 2, NULL, 4),
(48, 'Gestión de la Calidad y de la Innovación Tecnológica', 6, 'optativa', 4, 2, NULL, 4),
(49, 'Inteligencia del Negocio', 6, 'optativa', 4, 2, NULL, 4),
(50, 'Procesos de Ingeniería del Software 2', 6, 'optativa', 4, 2, NULL, 4),
(51, 'Seguridad Informática', 6, 'optativa', 4, 2, NULL, 4),
(52, 'Biologia celular', 6, 'básica', 1, 1, NULL, 7),
(53, 'Física', 6, 'básica', 1, 1, NULL, 7),
(54, 'Matemáticas I', 6, 'básica', 1, 1, NULL, 7),
(55, 'Química general', 6, 'básica', 1, 1, NULL, 7),
(56, 'Química orgánica', 6, 'básica', 1, 1, NULL, 7),
(57, 'Biología vegetal y animal', 6, 'básica', 1, 2, NULL, 7),
(58, 'Bioquímica', 6, 'básica', 1, 2, NULL, 7),
(59, 'Genética', 6, 'básica', 1, 2, NULL, 7),
(60, 'Matemáticas II', 6, 'básica', 1, 2, NULL, 7),
(61, 'Microbiología', 6, 'básica', 1, 2, NULL, 7),
(62, 'Botánica agrícola', 6, 'obligatoria', 2, 1, NULL, 7),
(63, 'Fisiología vegetal', 6, 'obligatoria', 2, 1, NULL, 7),
(64, 'Genética molecular', 6, 'obligatoria', 2, 1, NULL, 7),
(65, 'Ingeniería bioquímica', 6, 'obligatoria', 2, 1, NULL, 7),
(66, 'Termodinámica y cinética química aplicada', 6, 'obligatoria', 2, 1, NULL, 7),
(67, 'Biorreactores', 6, 'obligatoria', 2, 2, NULL, 7),
(68, 'Biotecnología microbiana', 6, 'obligatoria', 2, 2, NULL, 7),
(69, 'Ingeniería genética', 6, 'obligatoria', 2, 2, NULL, 7),
(70, 'Inmunología', 6, 'obligatoria', 2, 2, NULL, 7),
(71, 'Virología', 6, 'obligatoria', 2, 2, NULL, 7),
(72, 'Bases moleculares del desarrollo vegetal', 4, 'obligatoria', 3, 1, NULL, 7),
(73, 'Fisiología animal', 4, 'obligatoria', 3, 1, NULL, 7),
(74, 'Metabolismo y biosíntesis de biomoléculas', 6, 'obligatoria', 3, 1, NULL, 7),
(75, 'Operaciones de separación', 6, 'obligatoria', 3, 1, NULL, 7),
(76, 'Patología molecular de plantas', 4, 'obligatoria', 3, 1, NULL, 7),
(77, 'Técnicas instrumentales básicas', 4, 'obligatoria', 3, 1, NULL, 7),
(78, 'Bioinformática', 4, 'obligatoria', 3, 2, NULL, 7),
(79, 'Biotecnología de los productos hortofrutículas', 4, 'obligatoria', 3, 2, NULL, 7),
(80, 'Biotecnología vegetal', 6, 'obligatoria', 3, 2, NULL, 7),
(81, 'Genómica y proteómica', 4, 'obligatoria', 3, 2, NULL, 7),
(82, 'Procesos biotecnológicos', 6, 'obligatoria', 3, 2, NULL, 7),
(83, 'Técnicas instrumentales avanzadas', 4, 'obligatoria', 3, 2, NULL, 7),
(89, '22', 2, 'optativa', 1, 1, 1, 1),
(90, '1111', 1, 'optativa', 1, 1, 1, 1),
(91, 'prueba asignatura', 1, 'obligatoria', 2, 2, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso_escolar`
--

CREATE TABLE `curso_escolar` (
  `id` int(10) UNSIGNED NOT NULL,
  `anyo_inicio` year(4) NOT NULL,
  `anyo_fin` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `curso_escolar`
--

INSERT INTO `curso_escolar` (`id`, `anyo_inicio`, `anyo_fin`) VALUES
(1, 2014, 2015),
(2, 2015, 2016),
(3, 2016, 2017),
(4, 2017, 2018),
(5, 2018, 2019);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`id`, `nombre`) VALUES
(1, 'Informática'),
(2, 'Matemáticas'),
(3, 'Economía y Empresa'),
(4, 'Educación'),
(5, 'Agronomía'),
(6, 'Química y Física'),
(7, 'Filología'),
(8, 'Derecho'),
(9, 'Biología y Geología');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grado`
--

CREATE TABLE `grado` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `grado`
--

INSERT INTO `grado` (`id`, `nombre`) VALUES
(1, 'Grado en Ingeniería Agrícola (Plan 2015)'),
(2, 'Grado en Ingeniería Eléctrica (Plan 2014)'),
(3, 'Grado en Ingeniería Electrónica Industrial (Plan 2010)'),
(4, 'Grado en Ingeniería Informática (Plan 2015)'),
(5, 'Grado en Ingeniería Mecánica (Plan 2010)'),
(6, 'Grado en Ingeniería Química Industrial (Plan 2010)'),
(7, 'Grado en Biotecnología (Plan 2015)'),
(8, 'Grado en Ciencias Ambientales (Plan 2009)'),
(9, 'Grado en Matemáticas (Plan 2010)'),
(10, 'Grado en Química (Plan 2009)');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id` int(10) UNSIGNED NOT NULL,
  `nif` varchar(9) DEFAULT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellido1` varchar(50) NOT NULL,
  `apellido2` varchar(50) DEFAULT NULL,
  `ciudad` varchar(25) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `sexo` varchar(20) NOT NULL,
  `tipo` enum('profesor','alumno') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `nif`, `nombre`, `apellido1`, `apellido2`, `ciudad`, `direccion`, `telefono`, `fecha_nacimiento`, `sexo`, `tipo`) VALUES
(1, '26902806M', 'Salvador', 'Sánchez', 'Pérez', 'Almería', 'C/ Real del barrio alto', '950254837', '1991-03-28', 'MASCULINO', 'profesor'),
(2, '89542419S', 'Juan', 'Saez', 'Vega', 'Almería', 'C/ Mercurio', '618253876', '1992-08-08', 'M', 'alumno'),
(4, '17105885A', 'Pedro', 'Heller', 'Pagac', 'Almería', 'C/ Estrella fugaz', NULL, '2000-10-05', 'M', 'alumno'),
(5, '38223286T', 'David', 'Schmidt', 'Fisher', 'Almería', 'C/ Venus', '678516294', '1978-01-19', 'M', 'profesor'),
(6, '04233869Y', 'José', 'Koss', 'Bayer', 'Almería', 'C/ Júpiter', '628349590', '1998-01-28', 'M', 'alumno'),
(8, '79503962T', 'Cristina', 'Lemke', 'Rutherford', 'Almería', 'C/ Saturno', '669162534', '1977-08-21', 'F', 'profesor'),
(9, '82842571K', 'Ramón', 'Herzog', 'Tremblay', 'Almería', 'C/ Urano', '626351429', '1996-11-21', 'M', 'alumno'),
(10, '61142000L', 'Esther', 'Spencer', 'Lakin', 'Almería', 'C/ Plutón', NULL, '1977-05-19', 'F', 'profesor'),
(11, '46900725E', 'Daniel', 'Herman', 'Pacocha', 'Almería', 'C/ Andarax', '679837625', '1997-04-26', 'M', 'alumno'),
(12, '85366986W', 'Carmen', 'Streich', 'Hirthe', 'Almería', 'C/ Almanzora', NULL, '1971-04-29', 'F', 'profesor'),
(13, '73571384L', 'Alfredo', 'Stiedemann', 'Morissette', 'Almería', 'C/ Guadalquivir', '950896725', '1980-02-01', 'M', 'profesor'),
(14, '82937751G', 'Manolo', 'Hamill', 'Kozey', 'Almería', 'C/ Duero', '950263514', '1977-01-02', 'M', 'profesor'),
(15, '80502866Z', 'Alejandro', 'Kohler', 'Schoen', 'Almería', 'C/ Tajo', '668726354', '1980-03-14', 'M', 'profesor'),
(16, '10485008K', 'Antonio', 'Fahey', 'Considine', 'Almería', 'C/ Sierra de los Filabres', NULL, '1982-03-18', 'M', 'profesor'),
(17, '85869555K', 'Guillermo', 'Ruecker', 'Upton', 'Almería', 'C/ Sierra de Gádor', NULL, '1973-05-05', 'M', 'profesor'),
(18, '04326833G', 'Micaela', 'Monahan', 'Murray', 'Almería', 'C/ Veleta', '662765413', '1976-02-25', 'F', 'profesor'),
(19, '11578526G', 'Inma', 'Lakin', 'Yundt', 'Almería', 'C/ Picos de Europa', '678652431', '1998-09-01', 'F', 'alumno'),
(20, '79221403L', 'Francesca', 'Schowalter', 'Muller', 'Almería', 'C/ Quinto pino', NULL, '1980-10-31', 'F', 'profesor'),
(21, '79089577Y', 'Juan', 'Gutiérrez', 'López', 'Almería', 'C/ Los pinos', '678652431', '1998-01-01', 'M', 'alumno'),
(22, '41491230N', 'Antonio', 'Domínguez', 'Guerrero', 'Almería', 'C/ Cabo de Gata', '626652498', '1999-02-11', 'M', 'alumno'),
(23, '64753215G', 'Irene', 'Hernández', 'Martínez', 'gran canaria', 'C/ Zapillo', '628452384', '1996-03-12', 'MASCULINO', 'profesor'),
(31, '44748620g', 'samuel', 'deniz', 'galvan', 'las palmas', 'c nstra se?ora del carmen', '666666666', '1992-07-08', 'MASCULINO', 'alumno');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `id_profesor` int(10) UNSIGNED NOT NULL,
  `id_departamento` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`id_profesor`, `id_departamento`) VALUES
(3, 1),
(14, 1),
(5, 2),
(15, 2),
(8, 3),
(16, 3),
(10, 4),
(12, 4),
(17, 4),
(18, 5),
(13, 6),
(20, 6);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_profesor` (`id_profesor`),
  ADD KEY `id_grado` (`id_grado`);

--
-- Indices de la tabla `curso_escolar`
--
ALTER TABLE `curso_escolar`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `grado`
--
ALTER TABLE `grado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nif_2` (`nif`),
  ADD KEY `nif` (`nif`) USING BTREE;

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`id_profesor`),
  ADD KEY `profesor_ibfk_2` (`id_departamento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=92;

--
-- AUTO_INCREMENT de la tabla `curso_escolar`
--
ALTER TABLE `curso_escolar`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `grado`
--
ALTER TABLE `grado`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
