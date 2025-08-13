ALTER TABLE sucursales ALTER COLUMN id_sucursal SET DEFAULT nextval('id_sucursal_seq');

INSERT INTO sucursales(nombre) VALUES('CDMX');
