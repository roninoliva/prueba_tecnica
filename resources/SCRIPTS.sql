CREATE TABLE sucursales (
                            id_sucursal BIGINT PRIMARY KEY,
                            nombre VARCHAR
);
CREATE SEQUENCE id_sucursal_seq START 1 INCREMENT 1;
ALTER TABLE sucursales ALTER COLUMN id_sucursal SET DEFAULT nextval('id_sucursal_seq');

CREATE TABLE ordenes (

                         orden_id BIGINT PRIMARY KEY,
                         id_sucursal BIGINT,
                         date DATE,
                         total FLOAT,
                         CONSTRAINT id_sucursal_fk FOREIGN KEY (id_sucursal) REFERENCES sucursales(id_sucursal)
);

CREATE SEQUENCE orden_id_seq START 1 INCREMENT 1;
ALTER TABLE ordenes ALTER COLUMN orden_id SET DEFAULT nextval('orden_id_seq');

CREATE TABLE productos (
                           id BIGINT PRIMARY KEY,
                           id_producto BIGINT,
                           orden_id BIGINT,
                           descripcion VARCHAR,
                           precio FLOAT,
                           CONSTRAINT orden_id_fk FOREIGN KEY (orden_id) REFERENCES ordenes(orden_id)
);
CREATE SEQUENCE producto_id_seq START 1 INCREMENT 1;
ALTER TABLE productos ALTER COLUMN id SET DEFAULT nextval('producto_id_seq');


INSERT INTO sucursales(nombre) values ('CDMX');