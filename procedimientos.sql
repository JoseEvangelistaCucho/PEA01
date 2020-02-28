
DELIMITER $$
DROP PROCEDURE IF EXISTS  ingresar;
CREATE PROCEDURE ingresar(
IN nom varchar(20),
IN precio numeric(6,2),
IN tipo varchar(20)
)
begin
insert into dispositivos(nombre,precio,tipo) values(nom,precio,tipo);
END$$
DELIMITER ;