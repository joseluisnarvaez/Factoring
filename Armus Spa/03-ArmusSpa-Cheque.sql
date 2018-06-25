DROP PROCEDURE IF EXISTS sp_crea_cheque;
 
DELIMITER $$
 
CREATE PROCEDURE sp_crea_cheque(

   
	IN _rutCliente INT,
	IN _interes INT,
	IN _fechaVencimiento VARCHAR(20),
	IN _fechaInicial VARCHAR(20),
	IN _totalPrestamo INT,
	IN _diasCheque INT,
	IN _numCheque VARCHAR(255),
	IN _idTitular INT
	)
BEGIN
    
INSERT INTO Cheque(
					 rutCliente,
					 interes,
					 fechaVencimiento,
					 fechaInicial,
					 diasCheque,
					 totalPrestamo,
					 numCheque,
					 idTitular,
					 estado)
					 VALUES (
					 _rutCliente,
					 _interes,
					 _fechaVencimiento,
					 _fechaInicial,
					 _totalPrestamo,
					 _diasCheque,
					 _numCheque,
					 _idTitular,
					 1);

	
END $$
DELIMITER ;

-- Numero de cheque

DROP PROCEDURE IF EXISTS sp_lst_cheque_nCheque;
 
DELIMITER $$
 
CREATE PROCEDURE sp_lst_cheque_nCheque(
	IN _nCheque varchar(255),
	IN _estado INT
)
BEGIN

 SELECT 
	*
FROM Cheque where estado = _estado and numCheque = _nCheque;
	
END $$
DELIMITER ;

-- fecha de ingreso

DROP PROCEDURE IF EXISTS sp_lst_cheque_fingreso;
 
DELIMITER $$
 
CREATE PROCEDURE sp_lst_cheque_fingreso(
	IN _fIngreso varchar(10),
	IN _estado INT
)
BEGIN

 SELECT 
	*
FROM Cheque where estado = _estado and fechaInicial = _fIngreso;
	
END $$
DELIMITER ;

-- fecha de Vencimiento

DROP PROCEDURE IF EXISTS sp_lst_cheque_fvencimiento;
 
DELIMITER $$
 
CREATE PROCEDURE sp_lst_cheque_fvencimiento(
	IN _fVencimiento varchar(10),
	IN _estado INT
)
BEGIN

 SELECT 
	*
FROM Cheque where estado = _estado and fechaVencimiento = _fVencimiento;
	
END $$
DELIMITER ;


-- rut Cliente

DROP PROCEDURE IF EXISTS sp_lst_cheque_rcliente;
 
DELIMITER $$
 
CREATE PROCEDURE sp_lst_cheque_rcliente(
	IN _rutCliente INT,
	IN _estado INT
)
BEGIN

 SELECT 
	*
FROM Cheque where estado = _estado and rutCliente = _rutCliente;
	
END $$
DELIMITER ;



-- rut Agente

DROP PROCEDURE IF EXISTS sp_lst_cheque_ragente;
 
DELIMITER $$
 
CREATE PROCEDURE sp_lst_cheque_ragente(
	IN _rutAgente INT,
	IN _estado INT
)
BEGIN

 SELECT 
	*
FROM Cheque where estado = _estado and rutAgente = _rutAgente;
	
END $$
DELIMITER ;


-- idTitular 

DROP PROCEDURE IF EXISTS sp_lst_cheque_id_titular;
 
DELIMITER $$
 
CREATE PROCEDURE sp_lst_cheque_id_titular(
	IN _idTitular INT
)
BEGIN

 SELECT 
	*
FROM Cheque where idTitular = _idTitular;
	
END $$
DELIMITER ;



-- titular por nombre 

DROP PROCEDURE IF EXISTS sp_lst_titular_nombre;
 
DELIMITER $$
 
CREATE PROCEDURE sp_lst_titular_nombre(
	IN _nombre varchar(255)
)
BEGIN

 SELECT 
	*
FROM cuentas_anexas where nombres like _nombre;
	
END $$
DELIMITER ;



-- Usuario

DROP PROCEDURE IF EXISTS sp_lst_usuario_nombre;
 
DELIMITER $$
 
CREATE PROCEDURE sp_lst_usuario_nombre(
	IN _usuario varchar(255)
)
BEGIN

 SELECT 
	*
FROM usuario where usuario = _usuario ;
	
END $$
DELIMITER ;