

DELIMITER $$
DROP PROCEDURE IF EXISTS  modificar;
CREATE PROCEDURE modificar(
IN nom VARCHAR(20),
IN precio NUMERIC(6,2),
IN tipo VARCHAR(20)
)
begin
    update dispositivos
    set precio=precio,
        tipo=tipo
    where nombre=nom;
END$$
DELIMITER ; 
