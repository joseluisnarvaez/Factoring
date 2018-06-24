DROP PROCEDURE IF EXISTS sp_crea_cliente;
 
DELIMITER $$
 
CREATE PROCEDURE sp_crea_cliente(
    IN _nombres VARCHAR(300),
	IN _rut INT,
	IN _dv_cliente char(1),
	IN _banco VARCHAR(200),
	IN _c_corriente VARCHAR(200),
	IN _interes_mensual decimal(20,4),
	IN _monto_maximo_prestamo decimal(20))
BEGIN
    
	INSERT INTO clientes
(nombres,rut,dv_cliente,banco,c_corriente,interes_mensual,monto_maximo_prestamo,estado)
VALUES
( 	_nombres,
	_rut,
	_dv_cliente,
	_banco,
	_c_corriente,
	_interes_mensual,
	_monto_maximo_prestamo,
    0);

	
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_lst_cliente;
 
DELIMITER $$
 
CREATE PROCEDURE sp_lst_cliente()
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
	
END $$
DELIMITER ;



DROP PROCEDURE IF EXISTS sp_upd_cliente;
 
DELIMITER $$
 
CREATE PROCEDURE sp_upd_cliente(
	IN _id INT,
	IN _nombres VARCHAR(300),
	IN _rut INT,
	IN _dv_cliente char(1),
	IN _banco VARCHAR(200),
	IN _c_corriente VARCHAR(200),
	IN _interes_mensual decimal(20),
	IN _monto_maximo_prestamo decimal(20))
BEGIN

UPDATE clientes
SET
nombres = _nombres,
rut = _rut,
dv_cliente = _dv_cliente,
banco = _banco,
c_corriente = _c_corriente,
interes_mensual = _interes_mensual,
monto_maximo_prestamo =_monto_maximo_prestamo
WHERE idClientes = _id;
	
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS sp_del_cliente;
 
DELIMITER $$
 
CREATE PROCEDURE sp_del_cliente(
	IN _id INT)
BEGIN

UPDATE clientes
SET
	estado = 1
WHERE idClientes = _id;
	
END $$
DELIMITER ;




DROP PROCEDURE IF EXISTS sp_crea_titular;
 
DELIMITER $$
 
CREATE PROCEDURE sp_crea_titular(
    IN _nombres VARCHAR(300),
	IN _rut INT,
	IN _dv_titular char(1),
	IN _c_corriente VARCHAR(200),
	IN _banco VARCHAR(200),
	IN _idCliente INT,
	IN _montoMaximo INT)
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

	
END $$
DELIMITER ;




DROP PROCEDURE IF EXISTS sp_lst_titular;
 
DELIMITER $$
 
CREATE PROCEDURE sp_lst_titular(
	IN _idCliente INT)
BEGIN

SELECT * from cuentas_anexas where Clientes_idClientes = _idCliente;
    
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS sp_lst_titularID;
 
DELIMITER $$
 
CREATE PROCEDURE sp_lst_titularID(
	IN _idTitular INT)
BEGIN

SELECT * from cuentas_anexas where idcuentas_anexas = _idTitular;
    
END $$
DELIMITER ;
