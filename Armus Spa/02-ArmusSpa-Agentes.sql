DROP PROCEDURE IF EXISTS sp_crea_agente;
 
DELIMITER $$
 
CREATE PROCEDURE sp_crea_agente(
    IN _nombres VARCHAR(300),
	IN _interes INT)
BEGIN
    
INSERT INTO agentes
(nombre,
interes)
VALUES(
	_nombres,
	_interes);

	
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
	IN _nombres varchar(50),
   	IN _interes INT)
BEGIN

UPDATE agentes
SET
nombre = _nombres,
interes = _interes
WHERE idagentes = _id;
	
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS sp_del_Agente;
 
DELIMITER $$
 
CREATE PROCEDURE sp_del_Agente(
	IN _id INT)
BEGIN

UPDATE agentes
SET
	estado = 1
WHERE idagentes = _id;
	
END $$
DELIMITER ;