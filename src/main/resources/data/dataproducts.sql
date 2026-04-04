-- PRODUCTS (id, description, name, price, product_type)
INSERT INTO products (id, description, name, price, product_type) VALUES
  (1,'Bicicleta de montaña rodado 29, cuadro de aluminio, frenos a disco y 21 velocidades. Ideal para ciudad y senderos.','Bicicleta MTB rodado 29',180000.00,'VENTA'),
  (6,'Notebook de 15 pulgadas con procesador Intel i5, 8GB de RAM y SSD de 256GB. Ideal para trabajo y estudio.','Notebook 15\" Intel i5 8GB RAM',520000.00,'VENTA'),
  (7,'Remera unisex de algodón, color negro con lisa. Talle M.','Remera unisex lisa talle M',15000.00,'VENTA'),
  (8,'Zapatillas para running, suela con buena amortiguación y capellada respirable. Talle 42.','Zapatillas running hombre 42',42000.00,'VENTA'),
  (9,'Guitarra criolla clásica de madera, ideal para principiantes y estudiantes de música.','Guitarra criolla clásica',65000.00,'VENTA'),
  (10,'Parlante Bluetooth portátil, batería recargable de larga duración y manos libres integrado.','Parlante Bluetooth portátil',28000.00,'VENTA'),
  (12,'Pack de 4 juegos de mesa familiares ideales para reuniones y noches de entretenimiento.','Set de juegos de mesa familiares',38000.00,'VENTA'),
  (13,'Transportadora rígida para perro de tamaño mediano, con ventilación y cierre seguro.','Transportadora para perro mediano',35000.00,'RESERVA'),
  (16,'Disponible en color celeste y blanco. Talle único (41).','Botines Fútbol 5 Talle 41',55000.00,'VENTA'),
  (23,'Reloj alemán de pared antiguo, único en stock.','Reloj de pared',24000.00,'VENTA'),
  (24,'Patineta SkatePark ideal para uso diario','Patineta  SkatePark',27000.00,'VENTA'),
  (25,'Departamento con excelente ubicación, ideal para dos personas. Apto máscotas.','Departamento en alquiler en Boston',650000.00,'RESERVA'),
  (26,'Local en alquiler, excelente ubicación en el centro de miami.','Local en Alquiler',1500000.00,'RESERVA'),
  (27,'Libro electrónico marca kindle, últimas unidades.','Ebook marca Kindle',25000.00,'VENTA'),
  (28,'Reserva tu día de paseo en canoa','Paseo en canoa Lago Blake',1500.00,'RESERVA'),
  (29,'Máquina de escribir antigua, estilo francesa. Impecable.','Máquina de escribir antigua',23500.00,'VENTA'),
  (30,'Camioneta todo terreno, excelente estado. Papeles al día.','Camioneta todo terreno',1000000.00,'RESERVA'),
  (31,'Taza con motivo personalizado','Taza personalizada',8000.00,'VENTA'),
  (32,'Nuevo Iphone edición limitada color rojo.','Iphone rojo 2025',800000.00,'VENTA'),
  (33,'Llevate la última camiseta de la selección oficial.','Camiseta Argentina oficial AFA',400000.00,'VENTA'),
  (34,'Cafetera de última generación ideal para el hogar o el trabajo.','Cafetera profesional',130000.00,'VENTA'),
  (35,'Micrófono ideal para cualquier actividad profesional.','Micrófono multiuso',110000.00,'VENTA');

-- PRODUCT_IMAGES (id, position, url, product_id)
INSERT INTO product_images (id, position, url, product_id) VALUES
  (49,0,'https://images.pexels.com/photos/7187882/pexels-photo-7187882.jpeg',16),
  (50,1,'https://images.pexels.com/photos/7188057/pexels-photo-7188057.jpeg',16),
  (51,2,'https://images.pexels.com/photos/7188095/pexels-photo-7188095.jpeg',16),
  (65,0,'https://images.pexels.com/photos/814133/pexels-photo-814133.jpeg',12),
  (66,1,'https://images.pexels.com/photos/277124/pexels-photo-277124.jpeg',12),
  (67,2,'https://images.pexels.com/photos/278918/pexels-photo-278918.jpeg',12),
  (68,3,'https://images.pexels.com/photos/279321/pexels-photo-279321.jpeg',12),
  (69,4,'https://images.pexels.com/photos/2283803/pexels-photo-2283803.jpeg',12),
  (70,5,'https://images.pexels.com/photos/229566/pexels-photo-229566.jpeg',12),
  (71,6,'https://images.pexels.com/photos/3701276/pexels-photo-3701276.jpeg',12),
  (72,7,'https://images.pexels.com/photos/278918/pexels-photo-278918.jpeg',12),
  (73,8,'https://images.pexels.com/photos/814133/pexels-photo-814133.jpeg',12),
  (80,0,'https://images.pexels.com/photos/8532616/pexels-photo-8532616.jpeg',7),
  (81,1,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRW4zz8NX4JX9L88YyBfWxq-r77IzkTJiir5w&s',7),
  (82,2,'https://picsum.photos/id/1005/800/600',7),
  (89,0,'https://cdn.pixabay.com/photo/2012/12/31/14/37/speaker-73187_1280.jpg',10),
  (90,1,'https://images.unsplash.com/photo-1662927705497-ad79adb43228?q=80&w=1127&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',10),
  (91,2,'https://media.istockphoto.com/id/1481093340/photo/bluetooth-speaker.jpg?s=2048x2048&w=is&k=20&c=PFk3E0jz52b03J8_l_lYXUANnY_ZMDIqDViBvWcpCSg=',10),
  (96,0,'https://images.pexels.com/photos/2118045/pexels-photo-2118045.jpeg',9),
  (97,1,'https://cdn.pixabay.com/photo/2010/12/13/10/01/guitar-2119_1280.jpg',9),
  (98,2,'https://media.istockphoto.com/id/1387389124/es/foto/guitarra-ac%C3%BAstica-en-un-escenario-vac%C3%ADo.jpg?s=2048x2048&w=is&k=20&c=SRaVshMePPMBqTML527N29HZDyHQryPjN1d9cflAkeE=',9),
  (99,3,'https://img.freepik.com/foto-gratis/cabezal-diapason-madera-clasica-diapason_1172-289.jpg?semt=ais_hybrid&w=740&q=80',9),
  (100,4,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYFUV9xxWSo2vncCXWOH0qbekxUlNqmyszNQ&s',9),
  (101,5,'https://musicmarket.by/images/detailed/1029/21685.970_0ul8-s7.jpeg',9),
  (102,0,'https://m.media-amazon.com/images/I/71I2TPvWRwL._UF894,1000_QL80_.jpg',13),
  (103,1,'https://img.freepik.com/foto-gratis/hermoso-retrato-mascota-perro-pequeno-jaula_23-2149218436.jpg?semt=ais_hybrid&w=740&q=80',13),
  (104,2,'https://picsum.photos/id/237/800/600',13),
  (110,0,'https://fastly.picsum.photos/id/157/5000/3914.jpg?hmac=A23PziOOpi_DIdiPRI30m9_1A8keOtMF3a6Vb-D7dRA',24),
  (115,0,'https://fastly.picsum.photos/id/315/2100/1500.jpg?hmac=-04N-t7k_WwNeI30ryvWT4KGzy7XVdsw41fNRDFizck',25),
  (116,1,'https://fastly.picsum.photos/id/305/4928/3264.jpg?hmac=s2FLjeAIyYH0CZl3xuyOShFAtL8yEGiYk31URLDxQCI',25),
  (117,2,'https://fastly.picsum.photos/id/299/5000/3288.jpg?hmac=vajPmKo1hPW0RLYeb2h14Ry9Mp5Gw0rs0yc78FmBmdM',25),
  (118,3,'https://fastly.picsum.photos/id/283/3823/2538.jpg?hmac=a_UsYMvJaoPttj7INb2UOcCbMuKb9cEu70ZgzcwCDqs',25),
  (119,0,'https://fastly.picsum.photos/id/175/2896/1944.jpg?hmac=djMSfAvFgWLJ2J3cBulHUAb4yvsQk0d4m4xBJFKzZrs',23),
  (120,1,'https://fastly.picsum.photos/id/357/3888/2592.jpg?hmac=322FsZ93_k9v7NNFeCTlqk_gobPP_1mYJIQwk7GxjMc',23),
  (121,0,'https://picsum.photos/id/180/800/600',6),
  (122,1,'https://picsum.photos/id/4/800/600',6),
  (123,2,'https://fastly.picsum.photos/id/370/4928/3264.jpg?hmac=UGe0txSnG4hhV-fAoi7e3mTnvQFhYYNcPJJbYFePh5Q',6),
  (124,0,'https://fastly.picsum.photos/id/76/4912/3264.jpg?hmac=VkFcSa2Rbv0R0ndYnz_FAmw02ON1pPVjuF_iVKbiiV8',1),
  (125,1,'https://fastly.picsum.photos/id/146/5000/3333.jpg?hmac=xdlFnzoavokA3U-bzo35Vk4jTBKx8C9fqH5IuCPXj2U',1),
  (126,2,'https://fastly.picsum.photos/id/203/4032/3024.jpg?hmac=yeLnHOEAWUYBtMnanR0-0Q7gSvYbyxPG3PLJYvm170Q',1),
  (127,3,'https://fastly.picsum.photos/id/212/2000/1394.jpg?hmac=5mJ6tJgbGO0Wl1jBHXsiOQQYq-bRf47wLE9vmXjcEuU',1),
  (128,4,'https://fastly.picsum.photos/id/428/2529/1581.jpg?hmac=FmX3-15B3BDpSiq3wq-eiTuAZ51CdKcJwrDeRICFCIU',1),
  (129,0,'https://fastly.picsum.photos/id/42/3456/2304.jpg?hmac=dhQvd1Qp19zg26MEwYMnfz34eLnGv8meGk_lFNAJR3g',26),
  (131,0,'https://fastly.picsum.photos/id/367/4928/3264.jpg?hmac=H-2OwMlcYm0a--Jd2qaZkXgFZFRxYyGrkrYjupP8Sro',27),
  (134,0,'https://fastly.picsum.photos/id/514/3179/4238.jpg?hmac=OmmsoWSTgOdsCjg94wlT1VqyJPSPBypTtr-wxfTeLLI',30),
  (135,1,'https://fastly.picsum.photos/id/551/5000/3337.jpg?hmac=j2rbnFFCSL6ssVP1iYHUak_9xhIpAdof4lIf1WZNnww',30),
  (136,2,'https://fastly.picsum.photos/id/555/4608/3456.jpg?hmac=fktOzZVYXPdhiBS9WSuPoxrtMrPE9JSNfyk6n89hc40',30),
  (137,3,'https://fastly.picsum.photos/id/605/2513/1670.jpg?hmac=2r8cThRG-HoN42A9oCO19I1RC78posajQDKgVbNqy1s',30),
  (138,0,'https://fastly.picsum.photos/id/486/3409/5000.jpg?hmac=1cAnmyih0Is_jGyd7R8vHTCb1sVMeM6fr0gGIJ50meo',29),
  (139,1,'https://fastly.picsum.photos/id/885/4000/2667.jpg?hmac=IrjRbqugGjfrXfEv6t65cpdv8j6EFpGT7ZOJipcgHJc',29),
  (140,0,'https://fastly.picsum.photos/id/469/3008/2000.jpg?hmac=vVTZk-Z-hUCiDlU8Y0lDTN0ek87O51fBbB4uqwFJNCc',28),
  (141,1,'https://fastly.picsum.photos/id/1011/5000/3333.jpg?hmac=N0TqVY7tgK_I8-1SyTBP1BRo0KlV1yPgpmEAvteQkWQ',28),
  (142,2,'https://fastly.picsum.photos/id/588/2509/1673.jpg?hmac=09nSJgh9ylbzEnI7HTVOkIqbyIjREzpm0kTaDnJuFaY',28),
  (143,0,'https://fastly.picsum.photos/id/30/1280/901.jpg?hmac=A_hpFyEavMBB7Dsmmp53kPXKmatwM05MUDatlWSgATE',31),
  (144,1,'https://fastly.picsum.photos/id/63/5000/2813.jpg?hmac=HvaeSK6WT-G9bYF_CyB2m1ARQirL8UMnygdU9W6PDvM',31),
  (148,0,'https://images.pexels.com/photos/35826931/pexels-photo-35826931.jpeg',33),
  (149,1,'https://images.pexels.com/photos/35826930/pexels-photo-35826930.jpeg',33),
  (150,2,'https://images.pexels.com/photos/35826927/pexels-photo-35826927.jpeg',33),
  (151,3,'https://images.pexels.com/photos/35826959/pexels-photo-35826959.jpeg',33),
  (152,4,'https://images.pexels.com/photos/35826943/pexels-photo-35826943.jpeg',33),
  (153,0,'https://images.pexels.com/photos/1102776/pexels-photo-1102776.jpeg',8),
  (154,1,'https://images.pexels.com/photos/8266799/pexels-photo-8266799.jpeg',8),
  (155,2,'https://images.pexels.com/photos/4724526/pexels-photo-4724526.jpeg',8),
  (156,0,'https://images.pexels.com/photos/4349727/pexels-photo-4349727.jpeg',34),
  (157,1,'https://images.pexels.com/photos/4349957/pexels-photo-4349957.jpeg',34),
  (158,2,'https://images.pexels.com/photos/6032797/pexels-photo-6032797.jpeg',34),
  (159,3,'https://images.pexels.com/photos/4349957/pexels-photo-4349957.jpeg',34),
  (162,0,'https://images.pexels.com/photos/9837428/pexels-photo-9837428.jpeg',32),
  (163,1,'https://images.pexels.com/photos/9741360/pexels-photo-9741360.jpeg',32),
  (164,2,'https://images.pexels.com/photos/2378138/pexels-photo-2378138.jpeg',32),
  (165,0,'https://images.pexels.com/photos/11884525/pexels-photo-11884525.jpeg',35),
  (166,1,'https://images.pexels.com/photos/14540987/pexels-photo-14540987.jpeg',35);
  
-- PRODUCT_CATEGORIES (product_id, category_id) por NOMBRE (no depende de IDs)
-- Requiere que existan las categorías (seed automático) y los productos.

-- category_id 1 -> Vehículos
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 1, c.id FROM categories c WHERE c.name = 'Vehículos';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 24, c.id FROM categories c WHERE c.name = 'Vehículos';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 30, c.id FROM categories c WHERE c.name = 'Vehículos';

-- category_id 2 -> Propiedades
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 25, c.id FROM categories c WHERE c.name = 'Propiedades';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 26, c.id FROM categories c WHERE c.name = 'Propiedades';

-- category_id 3 -> Deportes
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 1, c.id FROM categories c WHERE c.name = 'Deportes';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 8, c.id FROM categories c WHERE c.name = 'Deportes';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 16, c.id FROM categories c WHERE c.name = 'Deportes';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 33, c.id FROM categories c WHERE c.name = 'Deportes';

-- category_id 4 -> Hogar
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 23, c.id FROM categories c WHERE c.name = 'Hogar';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 29, c.id FROM categories c WHERE c.name = 'Hogar';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 31, c.id FROM categories c WHERE c.name = 'Hogar';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 34, c.id FROM categories c WHERE c.name = 'Hogar';

-- category_id 5 -> Electrónica
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 6, c.id FROM categories c WHERE c.name = 'Electrónica';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 10, c.id FROM categories c WHERE c.name = 'Electrónica';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 27, c.id FROM categories c WHERE c.name = 'Electrónica';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 32, c.id FROM categories c WHERE c.name = 'Electrónica';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 35, c.id FROM categories c WHERE c.name = 'Electrónica';

-- category_id 6 -> Entretenimiento
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 12, c.id FROM categories c WHERE c.name = 'Entretenimiento';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 24, c.id FROM categories c WHERE c.name = 'Entretenimiento';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 35, c.id FROM categories c WHERE c.name = 'Entretenimiento';

-- category_id 7 -> Indumentaria
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 7, c.id FROM categories c WHERE c.name = 'Indumentaria';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 8, c.id FROM categories c WHERE c.name = 'Indumentaria';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 16, c.id FROM categories c WHERE c.name = 'Indumentaria';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 33, c.id FROM categories c WHERE c.name = 'Indumentaria';

-- category_id 8 -> Música
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 9, c.id FROM categories c WHERE c.name = 'Música';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 10, c.id FROM categories c WHERE c.name = 'Música';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 35, c.id FROM categories c WHERE c.name = 'Música';

-- category_id 9 -> Juegos
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 12, c.id FROM categories c WHERE c.name = 'Juegos';

-- category_id 10 -> Mascotas
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 13, c.id FROM categories c WHERE c.name = 'Mascotas';

-- category_id 11 -> Servicios
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 28, c.id FROM categories c WHERE c.name = 'Servicios';

-- category_id 12 -> Otros
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 23, c.id FROM categories c WHERE c.name = 'Otros';
INSERT IGNORE INTO product_categories (product_id, category_id)
SELECT 29, c.id FROM categories c WHERE c.name = 'Otros';

-- Asigna caracteristicas aleatorias a algunos productos

INSERT INTO product_features (product_id, icon, label, position)
SELECT
  ra.product_id,
  f.icon,
  f.label,
  ra.position
FROM (
  SELECT
    pp.product_id,
    pos.position,
    1 + FLOOR(RAND() * 8) AS feature_id
  FROM (
    SELECT p.id AS product_id
    FROM products p
    ORDER BY RAND()
    LIMIT 8
  ) pp
  CROSS JOIN (
    SELECT 0 AS position
    UNION ALL
    SELECT 1 AS position
  ) pos
) ra
JOIN (
  SELECT 1 AS id, 'TbTruck' AS icon, 'Envío rápido' AS label
  UNION ALL SELECT 2, 'TbShieldCheck', 'Compra protegida'
  UNION ALL SELECT 3, 'TbCertificate', 'Garantía oficial'
  UNION ALL SELECT 4, 'TbClock', 'Entrega estimada 24h'
  UNION ALL SELECT 5, 'TbWifi', 'Conectividad estable'
  UNION ALL SELECT 6, 'TbBolt', 'Bajo consumo'
  UNION ALL SELECT 7, 'TbPalette', 'Variedad de colores'
  UNION ALL SELECT 8, 'TbWeight', 'Peso liviano'
) f ON f.id = ra.feature_id
WHERE NOT EXISTS (
  SELECT 1
  FROM product_features pf
  WHERE pf.product_id = ra.product_id
    AND pf.position = ra.position
);