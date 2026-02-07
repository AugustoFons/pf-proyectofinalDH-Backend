-- Seed: categorías base (idempotente)

INSERT INTO categories (name) VALUES ('Vehículos')
    ON DUPLICATE KEY UPDATE name = VALUES(name);

INSERT INTO categories (name) VALUES ('Propiedades')
    ON DUPLICATE KEY UPDATE name = VALUES(name);

INSERT INTO categories (name) VALUES ('Deportes')
    ON DUPLICATE KEY UPDATE name = VALUES(name);

INSERT INTO categories (name) VALUES ('Hogar')
    ON DUPLICATE KEY UPDATE name = VALUES(name);

INSERT INTO categories (name) VALUES ('Electrónica')
    ON DUPLICATE KEY UPDATE name = VALUES(name);

INSERT INTO categories (name) VALUES ('Entretenimiento')
    ON DUPLICATE KEY UPDATE name = VALUES(name);

INSERT INTO categories (name) VALUES ('Indumentaria')
    ON DUPLICATE KEY UPDATE name = VALUES(name);

INSERT INTO categories (name) VALUES ('Música')
    ON DUPLICATE KEY UPDATE name = VALUES(name);

INSERT INTO categories (name) VALUES ('Juegos')
    ON DUPLICATE KEY UPDATE name = VALUES(name);

INSERT INTO categories (name) VALUES ('Mascotas')
    ON DUPLICATE KEY UPDATE name = VALUES(name);

INSERT INTO categories (name) VALUES ('Servicios')
    ON DUPLICATE KEY UPDATE name = VALUES(name);

INSERT INTO categories (name) VALUES ('Otros')
    ON DUPLICATE KEY UPDATE name = VALUES(name);
