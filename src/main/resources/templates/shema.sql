CREATE TABLE estado_tarjeta
(
    id     SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL

);

CREATE TABLE estado_compra
(
    id     SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE titular
(
    id       SERIAL PRIMARY KEY,
    nombre   VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL
);

CREATE TABLE tarjeta
(
    numero_tarjeta    VARCHAR(16) PRIMARY KEY NOT NULL,
    producto_id       INT                     NOT NULL,
    titular           INT,
    fecha_creacion    DATE                    NOT NULL,
    fecha_vencimiento DATE                    NOT NULL,
    saldo             DECIMAL(10, 2)          NOT NULL,
    estado_tarjeta    INT,
    FOREIGN KEY (titular) REFERENCES titular (id),
    FOREIGN KEY (estado_tarjeta) REFERENCES estado_tarjeta (id)
);

CREATE TABLE compra
(
    id                SERIAL PRIMARY KEY,
    fecha_transaccion DATE NOT NULL,
    tarjeta           VARCHAR(16),
    estado_compra     INT,
    FOREIGN KEY (tarjeta) REFERENCES tarjeta (numero_tarjeta),
    FOREIGN KEY (estado_compra) REFERENCES estado_compra (id)
);

CREATE TABLE producto
(
    id                  SERIAL PRIMARY KEY,
    nombre              VARCHAR(255)   NOT NULL,
    precio              DECIMAL(10, 2) NOT NULL,
    cantidad_disponible INT            NOT NULL
);

CREATE TABLE compra_producto
(
    id_producto INT,
    id_compra   INT,
    cantidad    INT NOT NULL,
    PRIMARY KEY (id_producto, id_compra),
    FOREIGN KEY (id_producto) REFERENCES producto (id),
    FOREIGN KEY (id_compra) REFERENCES compra (id)
);

--INSERT QUERY