-- phpMyAdmin SQL Dump
-- version 
-- http://www.phpmyadmin.net
--
-- Servidor: mysql3000.mochahost.com
-- Tiempo de generación: 08-10-2018 a las 20:38:26
-- Versión del servidor: 5.6.23
-- Versión de PHP: 5.6.30

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `armusspa_armus`
--
DROP DATABASE `armusspa_armus`;
CREATE DATABASE `armusspa_armus` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `armusspa_armus`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `sp_crea_agente`$$
$$

DROP PROCEDURE IF EXISTS `sp_crea_cheque`$$
CREATE DEFINER=`armusspa`@`mocha6007.mochahost.com` PROCEDURE `sp_crea_cheque`(

   
	IN _idCliente INT,
	IN _interes INT,
	IN _fechaVencimiento VARCHAR(20),
	IN _fechaInicial VARCHAR(20),
	IN _totalPrestamo INT,
	IN _diasCheque INT,
	IN _numCheque VARCHAR(255),
	IN _idTitular INT
	)
BEGIN
    
INSERT INTO cheque(
					 idCliente,
					 interes,
					 fechaVencimiento,
					 fechaInicial,
					 diasCheque,
					 totalPrestamo,
					 numCheque,
					 idTitular,
					 estado)
					 VALUES (
					 _idCliente,
					 _interes,
					 _fechaVencimiento,
					 _fechaInicial,
					 _totalPrestamo,
					 _diasCheque,
					 _numCheque,
					 _idTitular,
					 1);

	
END$$

DROP PROCEDURE IF EXISTS `sp_crea_cliente`$$
CREATE DEFINER=`armusspa`@`mocha6007.mochahost.com` PROCEDURE `sp_crea_cliente`(IN `_nombres` VARCHAR(300), IN `_banco` VARCHAR(200), IN `_c_corriente` VARCHAR(200), IN `_interes_mensual` DECIMAL(20,4), IN `_monto_maximo_prestamo` DECIMAL(20))
BEGIN
    
	INSERT INTO clientes
(nombres,banco,c_corriente,interes_mensual,monto_maximo_prestamo,estado)
VALUES
( 	_nombres,
	_banco,
	_c_corriente,
	_interes_mensual,
	_monto_maximo_prestamo,
    0);

	
END$$

DROP PROCEDURE IF EXISTS `sp_crea_titular`$$
CREATE DEFINER=`armusspa`@`mocha6007.mochahost.com` PROCEDURE `sp_crea_titular`(IN `_nombres` VARCHAR(300), IN `_rut` INT, IN `_dv_titular` CHAR(1), IN `_c_corriente` VARCHAR(200), IN `_banco` VARCHAR(200), IN `_idCliente` INT, IN `_montoMaximo` INT)
BEGIN
    
	INSERT INTO cuentas_anexas
(nombres,rut,dv,c_corriente,banco,Clientes_idClientes,montoMaximo)
VALUES
( 	_nombres,
	_rut,
	_dv_titular,
	_c_corriente,
	_banco,
	_idCliente,
	_montoMaximo);

	
END$$

DROP PROCEDURE IF EXISTS `sp_del_Agente`$$
$$

DROP PROCEDURE IF EXISTS `sp_del_cliente`$$
CREATE DEFINER=`armusspa`@`mocha6007.mochahost.com` PROCEDURE `sp_del_cliente`(IN `_id` INT)
BEGIN

UPDATE clientes
SET
	estado = 1
WHERE idClientes = _id;
	
END$$

DROP PROCEDURE IF EXISTS `sp_lst_agente`$$
$$

DROP PROCEDURE IF EXISTS `sp_lst_cheque_fingreso`$$
CREATE DEFINER=`armusspa`@`mocha6007.mochahost.com` PROCEDURE `sp_lst_cheque_fingreso`(
	IN _fIngreso varchar(10),
	IN _estado INT
)
BEGIN

 SELECT 
	*
FROM cheque where estado = _estado and fechaInicial = _fIngreso;
	
END$$

DROP PROCEDURE IF EXISTS `sp_lst_cheque_fvencimiento`$$
CREATE DEFINER=`armusspa`@`mocha6007.mochahost.com` PROCEDURE `sp_lst_cheque_fvencimiento`(
	IN _fVencimiento varchar(10),
	IN _estado INT
)
BEGIN

 SELECT 
	*
FROM cheque where estado = _estado and fechaVencimiento = _fVencimiento;
	
END$$

DROP PROCEDURE IF EXISTS `sp_lst_cheque_id_titular`$$
CREATE DEFINER=`armusspa`@`mocha6007.mochahost.com` PROCEDURE `sp_lst_cheque_id_titular`(
	IN _idTitular INT
)
BEGIN

 SELECT 
	*
FROM cheque where idTitular = _idTitular;
	
END$$

DROP PROCEDURE IF EXISTS `sp_lst_cheque_nCheque`$$
CREATE DEFINER=`armusspa`@`mocha6007.mochahost.com` PROCEDURE `sp_lst_cheque_nCheque`(
	IN _nCheque varchar(255),
	IN _estado INT
)
BEGIN

 SELECT 
	*
FROM cheque where estado = _estado and numCheque = _nCheque;
	
END$$

DROP PROCEDURE IF EXISTS `sp_lst_cheque_ragente`$$
CREATE DEFINER=`armusspa`@`mocha6007.mochahost.com` PROCEDURE `sp_lst_cheque_ragente`(
	IN _rutAgente INT,
	IN _estado INT
)
BEGIN

 SELECT 
	*
FROM cheque where estado = _estado and rutAgente = _rutAgente;
	
END$$

DROP PROCEDURE IF EXISTS `sp_lst_cheque_rcliente`$$
CREATE DEFINER=`armusspa`@`mocha6007.mochahost.com` PROCEDURE `sp_lst_cheque_rcliente`(
	IN _idCliente INT,
	IN _estado INT
)
BEGIN

 SELECT 
	*
FROM cheque where estado = _estado and idCliente = _idCliente;
	
END$$

DROP PROCEDURE IF EXISTS `sp_lst_cliente`$$
CREATE DEFINER=`armusspa`@`mocha6007.mochahost.com` PROCEDURE `sp_lst_cliente`()
BEGIN

 SELECT idClientes,
	nombres,
    rut,
    dv_cliente,
    banco,
    c_corriente,
    interes_mensual,
    monto_maximo_prestamo
FROM clientes where estado = 0;
	
END$$

DROP PROCEDURE IF EXISTS `sp_lst_titular`$$
CREATE DEFINER=`armusspa`@`mocha6007.mochahost.com` PROCEDURE `sp_lst_titular`(IN `_idCliente` INT)
BEGIN

SELECT * from cuentas_anexas where Clientes_idClientes = _idCliente;
    
END$$

DROP PROCEDURE IF EXISTS `sp_lst_titularID`$$
CREATE DEFINER=`armusspa`@`mocha6007.mochahost.com` PROCEDURE `sp_lst_titularID`(IN `_idTitular` INT)
BEGIN

SELECT * from cuentas_anexas where idcuentas_anexas = _idTitular;
    
END$$

DROP PROCEDURE IF EXISTS `sp_lst_titular_nombre`$$
CREATE DEFINER=`armusspa`@`mocha6007.mochahost.com` PROCEDURE `sp_lst_titular_nombre`(
	IN _nombre varchar(255)
)
BEGIN

 SELECT 
	*
FROM cuentas_anexas where nombres like _nombre;
	
END$$

DROP PROCEDURE IF EXISTS `sp_lst_usuario_nombre`$$
CREATE DEFINER=`armusspa`@`mocha6007.mochahost.com` PROCEDURE `sp_lst_usuario_nombre`(
	IN _usuario varchar(255)
)
BEGIN

 SELECT 
	*
FROM usuario where usuario = _usuario ;
	
END$$

DROP PROCEDURE IF EXISTS `sp_upd_agente`$$
$$

DROP PROCEDURE IF EXISTS `sp_upd_cliente`$$
CREATE DEFINER=`armusspa`@`mocha6007.mochahost.com` PROCEDURE `sp_upd_cliente`(IN `_id` INT, IN `_nombres` VARCHAR(300), IN `_interes_mensual` DECIMAL(20))
BEGIN

UPDATE clientes
SET
nombres = _nombres,
interes_mensual = _interes_mensual
WHERE idClientes = _id;
	
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agentes`
--

DROP TABLE IF EXISTS `agentes`;
CREATE TABLE IF NOT EXISTS `agentes` (
  `idagentes` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) DEFAULT NULL,
  `interes` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT '0',
  PRIMARY KEY (`idagentes`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `agentes`
--

INSERT INTO `agentes` (`idagentes`, `nombre`, `interes`, `estado`) VALUES
(1, 'werwert', 15, 0),
(2, 'asdfasdfa', 15, 0),
(3, '', 0, 1),
(4, '88$%&/(', 17, 0),
(5, 'PEPe', 12, 1),
(6, '455', 0, 1),
(7, 'gjkghhkh', 100, 1),
(8, 'GABRIEL', 9999999, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cheque`
--

DROP TABLE IF EXISTS `cheque`;
CREATE TABLE IF NOT EXISTS `cheque` (
  `idCheque` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) DEFAULT NULL,
  `interes` int(11) DEFAULT NULL,
  `fechaVencimiento` varchar(10) DEFAULT NULL,
  `fechaInicial` varchar(10) DEFAULT NULL,
  `diasCheque` int(11) DEFAULT NULL,
  `totalPrestamo` int(11) DEFAULT NULL,
  `numCheque` int(11) DEFAULT NULL,
  `idTitular` int(11) NOT NULL,
  `estado` int(1) NOT NULL,
  PRIMARY KEY (`idCheque`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- Volcado de datos para la tabla `cheque`
--

INSERT INTO `cheque` (`idCheque`, `idCliente`, `interes`, `fechaVencimiento`, `fechaInicial`, `diasCheque`, `totalPrestamo`, `numCheque`, `idTitular`, `estado`) VALUES
(7, 100, 15, '27 06 2018', '24/06/2018', 1015228, 3, 34234234, 1, 1),
(8, 100, 15, '29 06 2018', '25/06/2018', 4, 510200, 1234567890, 1, 1),
(9, 100, 15, '28 07 2018', '26/06/2018', 32, 840000, 159357, 1, 1),
(10, 0, 15, '31 10 2018', '08/10/2018', 23, 111500, 2147483647, 1, 1),
(11, 0, 15, '31 10 2018', '08/10/2018', 23, 111500, 123123123, 1, 1),
(12, 0, 15, '31 10 2018', '08/10/2018', 23, 89686, 2147483647, 1, 1),
(13, 100, 15, '31 10 2018', '08/10/2018', 23, 111500, 6543651, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `idClientes` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(300) DEFAULT NULL,
  `rut` int(11) DEFAULT NULL,
  `dv_cliente` char(1) DEFAULT NULL,
  `banco` varchar(200) DEFAULT NULL,
  `c_corriente` varchar(200) DEFAULT NULL,
  `interes_mensual` decimal(10,4) DEFAULT NULL,
  `monto_maximo_prestamo` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idClientes`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=142 ;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idClientes`, `nombres`, `rut`, `dv_cliente`, `banco`, `c_corriente`, `interes_mensual`, `monto_maximo_prestamo`, `estado`) VALUES
(100, 'Alejandro Vasquez', 0, NULL, '0', NULL, 15.0000, 0, 0),
(101, 'Andres Escobar', 0, NULL, '0', NULL, 10.0000, 0, 0),
(102, 'Arturo Contador', 0, NULL, '0', NULL, 10.0000, 0, 0),
(103, 'Checo', 0, NULL, '0', NULL, 10.0000, 0, 0),
(104, 'Claudio Arenas', 0, NULL, '0', NULL, 10.0000, 0, 0),
(105, 'Claudio Perez', 0, NULL, '0', NULL, 40.0000, 0, 0),
(106, 'Cristian Gonzalez', 0, NULL, '0', NULL, 10.0000, 0, 0),
(107, 'Cristian Luengo', 0, NULL, '0', NULL, 12.0000, 0, 0),
(108, 'Eduardo Oyaneder', 0, NULL, '0', NULL, 12.0000, 0, 0),
(109, 'Eduardo Provoste', 0, NULL, '0', NULL, 7.7000, 0, 0),
(110, 'Fernando Arratia', 0, NULL, '0', NULL, 12.0000, 0, 0),
(111, 'Gabriela Brizuela', 0, NULL, '0', NULL, 10.0000, 0, 0),
(112, 'Gastón Canales', 0, NULL, '0', NULL, 15.0000, 0, 0),
(113, 'Humberto Monzón', 0, NULL, '0', NULL, 10.0000, 0, 0),
(114, 'Ivan Dinamarca', 0, NULL, '0', NULL, 10.0000, 0, 0),
(115, 'Jano', 0, NULL, '0', NULL, 40.0000, 0, 0),
(116, 'Jorge Giovanetti', 0, NULL, '0', NULL, 10.0000, 0, 0),
(117, 'Lalo Perez', 0, NULL, '0', NULL, 10.0000, 0, 0),
(118, 'Leo', 0, NULL, '0', NULL, 12.5000, 0, 0),
(119, 'Luis Rojas S.', 0, NULL, '0', NULL, 0.0000, 0, 0),
(120, 'Luis Tobar', 0, NULL, '0', NULL, 10.0000, 0, 0),
(121, 'Luis Tropa', 0, NULL, '0', NULL, 15.0000, 0, 0),
(122, 'Luzmina Contreras', 0, NULL, '0', NULL, 15.0000, 0, 0),
(123, 'Marcelo Lina', 0, NULL, '0', NULL, 15.0000, 0, 0),
(124, 'Mario Cabello', 0, NULL, '0', NULL, 0.0000, 0, 0),
(125, 'Mary Pia', 0, NULL, '0', NULL, 20.0000, 0, 0),
(126, 'Ociel Cortes', 0, NULL, '0', NULL, 0.0000, 0, 0),
(127, 'Oscar Salazar', 0, NULL, '0', NULL, 15.0000, 0, 0),
(128, 'Osvaldo Jano', 0, NULL, '0', NULL, 12.5000, 0, 0),
(129, 'Pia Rojas', 0, NULL, '0', NULL, 0.0000, 0, 0),
(130, 'Rony,,', 0, NULL, '0', NULL, 10.0000, 0, 0),
(131, 'Sabor Sureño', 0, NULL, '0', NULL, 10.0000, 0, 0),
(132, 'Victor Hugo', 0, NULL, '0', NULL, 15.0000, 0, 0),
(133, 'Patricia Lillo', 0, NULL, '0', NULL, 10.0000, 0, 0),
(134, 'Daniel Fernandez', 0, NULL, '0', NULL, 12.0000, 0, 0),
(135, 'Berty', 0, NULL, '0', NULL, 12.0000, 0, 0),
(136, 'Luis Rojas G.', 0, NULL, '0', NULL, 0.0000, 0, 0),
(137, 'JC', NULL, NULL, '0', NULL, 40.0000, 0, 1),
(138, 'JC el mas cabron', NULL, NULL, '0', NULL, 30.0000, 0, 0),
(139, '55', NULL, NULL, '0', NULL, 5.0000, 0, 1),
(140, '55', NULL, NULL, '0', NULL, 0.0000, 0, 1),
(141, '!"!"!#!oo', NULL, NULL, '0', NULL, 999999.9999, 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas_anexas`
--

DROP TABLE IF EXISTS `cuentas_anexas`;
CREATE TABLE IF NOT EXISTS `cuentas_anexas` (
  `idcuentas_anexas` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(200) DEFAULT NULL,
  `aPaterno` varchar(200) DEFAULT NULL,
  `aMaterno` varchar(200) DEFAULT NULL,
  `rut` int(11) DEFAULT NULL,
  `dv` char(1) DEFAULT NULL,
  `c_corriente` varchar(200) DEFAULT NULL,
  `banco` varchar(200) DEFAULT NULL,
  `Clientes_idClientes` int(11) NOT NULL,
  `montoMaximo` int(11) NOT NULL,
  PRIMARY KEY (`idcuentas_anexas`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `cuentas_anexas`
--

INSERT INTO `cuentas_anexas` (`idcuentas_anexas`, `nombres`, `aPaterno`, `aMaterno`, `rut`, `dv`, `c_corriente`, `banco`, `Clientes_idClientes`, `montoMaximo`) VALUES
(1, 'Jose Narvaez', NULL, NULL, 17449355, '3', '112341234', '3', 100, 0),
(2, 'JC Titular', NULL, NULL, 1744935, '5', '6546546574984', '3', 138, 500000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(200) DEFAULT NULL,
  `contrasenia` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `usuario`, `contrasenia`) VALUES
(1, 'usuario', '12345'),
(2, 'luis rojas ', '7741'),
(3, 'ignacio', '8552');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
