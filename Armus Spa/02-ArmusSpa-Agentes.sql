DROP PROCEDURE IF EXISTS sp_crea_agente;
 
DELIMITER $$
 
CREATE PROCEDURE sp_crea_agente(
    IN _nombres VARCHAR(300),
	IN _rut INT,
	IN _dv_Agente char(1),
	IN _banco VARCHAR(200),
	IN _c_corriente VARCHAR(200),
	IN _monto decimal(20))
BEGIN
    
INSERT INTO agentes
(nombre,
rut,
dv_Agente,
banco,
cCorriente,
monto)
VALUES(
	_nombres,
	_rut,
	_dv_Agente,
	_banco,
	_c_corriente,
	_monto);

	
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_lst_agente;
 
DELIMITER $$
 
CREATE PROCEDURE sp_lst_agente()
BEGIN

SELECT * FROM agentes where estado = 0;
	
END $$
DELIMITER ;



DROP PROCEDURE IF EXISTS sp_upd_agente;
 
DELIMITER $$
 
CREATE PROCEDURE sp_upd_agente(
	IN _id INT,
    IN _nombres VARCHAR(300),
	IN _rut INT,
	IN _dv_Agente char(1),
	IN _banco VARCHAR(200),
	IN _c_corriente VARCHAR(200),
	IN _monto decimal(20))
BEGIN

UPDATE agentes
SET
nombre = _nombres,
rut = _rut,
dv_Agente = _dv_Agente,
banco = _banco,
cCorriente = _c_corriente,
monto = _monto
WHERE idagentes = _id;
	
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS sp_del_cliente;
 
DELIMITER $$
 
CREATE PROCEDURE sp_del_cliente(
	IN _id INT)
BEGIN

UPDATE agentes
SET
	estado = 1
WHERE idagentes = _id;
	
END $$
DELIMITER ;