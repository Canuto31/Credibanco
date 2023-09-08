INSERT INTO estado_tarjeta (nombre)
VALUES ('Activa'),
       ('Inactiva'),
       ('Bloqueada');

INSERT INTO estado_compra (nombre)
VALUES ('Aprobada'),
       ('Anulada');

INSERT INTO titular (nombre, apellido)
VALUES ('Juan', 'Pérez'),
       ('María', 'López'),
       ('Pedro', 'González');

INSERT INTO tarjeta (numero_tarjeta, producto_id, titular, fecha_creacion, fecha_vencimiento, saldo, estado_tarjeta)
VALUES ('1234567890123456', 123456, 1, '2023-09-01', '2026-09-01', 15.00, 1),
       ('2345678901234567', 234567, 2, '2023-09-02', '2026-09-02', 12.00, 1),
       ('3456789012345678', 345678, 3, '2023-09-03', '2026-09-03', 17.00, 1);


INSERT INTO compra (tarjeta, fecha_transaccion, precio, estado_compra)
VALUES ('1234567890123456', '2023-09-10', 5.00, 1),
       ('2345678901234567', '2023-09-11', 8.00, 1),
       ('3456789012345678', '2023-09-12', 3.00, 1);
