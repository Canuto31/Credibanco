INSERT INTO estado_tarjeta (nombre)
VALUES ('Activa'),
       ('Inactiva'),
       ('Bloqueada');

INSERT INTO estado_compra (nombre)
VALUES ('Pendiente'),
       ('Aprobada'),
       ('Rechazada');

INSERT INTO titular (nombre, apellido)
VALUES ('Juan', 'Pérez'),
       ('María', 'López'),
       ('Pedro', 'González');

INSERT INTO tarjeta (id, numero_tarjeta, titular, fecha_creacion, fecha_vencimiento, saldo, estado_tarjeta)
VALUES (123456, '1234567890123456', 1, '2023-09-01', '2026-09-01', 0.00, 1),
       (234567, '2345678901234567', 2, '2023-09-02', '2026-09-02', 0.00, 1),
       (345678, '3456789012345678', 3, '2023-09-03', '2026-09-03', 0.00, 1);


INSERT INTO compra (fecha_transaccion, tarjeta, estado_compra)
VALUES ('2023-09-10', 123456, 2),
       ('2023-09-11', 234567, 2),
       ('2023-09-12', 345678, 1);

INSERT INTO producto (nombre, precio, cantidad_disponible)
VALUES ('Producto A', 10.00, 100),
       ('Producto B', 15.00, 150),
       ('Producto C', 20.00, 200);

INSERT INTO compra_producto (id_producto, id_compra, cantidad)
VALUES (1, 1, 2),
       (2, 1, 1),
       (2, 2, 3),
       (3, 2, 2);
