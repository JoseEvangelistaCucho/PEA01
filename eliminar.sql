

DELIMITER $$
DROP PROCEDURE IF EXISTS  eliminar;
CREATE PROCEDURE eliminar(
IN nom varchar(20)
)
begin
    delete from dispositivos where nombre=nom;
END$$
DELIMITER ;