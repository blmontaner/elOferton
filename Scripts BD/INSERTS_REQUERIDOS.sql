-- Empresas que se devuleven en el servicio de ofertas, ninguna empresa que se devuelva en el servicio puede faltar aca sino explotan las foreing keys al insertar las ofertas en base

INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (1, 'Colonia 1234', 'hs@gmail.com', 'Hotel Suizo', '0900 1324');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (2, 'Benito Blanco 1234', 'adelgaceya@gmail.com', 'Clinica de Adelgazamiento', '221196874');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (3, 'Av Rivera 1234', 'pizza@gmail.com', 'Pizzeria pizzaPizza', '0900 1324');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (4, '25 de Mayo 1234', 'mayo@gmail.com', 'Clinica de Mayo', '0900 1324');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (5, 'Colonia 8234', 'coloniaEx@gmail.com', 'ColoniaExpress', '0900 8888');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (6, 'San Jose 1234', 'masajesSA@gmail.com', 'Masajes Sa', '0900 1888');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (7, 'Ruta 5 Km22', 'exSports@gmail.com', 'ExtremeSports', '0900 0324');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (8, 'Rambla Argentina 1234', 'pitaEnter@gmail.com', 'Pittamiglio Entertainments', '0900 2324');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (9, 'Av Brasil 1234', 'sushingo@gmail.com', 'Sushi n go', '0900 1324');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (10, 'Rondeau 1234', 'laRique@gmail.com', 'Taller laRique', '0900 1324');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (11, 'Cno Maldonado 1234', 'laPelu@gmail.com', 'Peluqueria Celeste', '0900 1324');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (12, 'Mercedes 1234', 'dentistas@gmail.com', 'Consultorio Odontológico', '0933 1324');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (13, 'Mercedes 1234', 'texis@gmail.com', 'Texsis', '0933 1111');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (14, 'Mercedes 1234', 'stelaArtois@gmail.com', 'Stela Artois Sa', '0933 1324');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (15, 'Mercedes 1234', 'ledstar@gmail.com', 'Ledstar', '0933 1324');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (16, 'cno sonio 1234', 'sony@gmail.com', 'Sony', '0933 1324');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (17, 'Rondeau 1234', 'chimestry@gmail.com', 'Chimi CHumi', '0933 1324');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (18, 'Uruguay 1234', 'coutinho@gmail.com', 'Cotinho', '0933 1324');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (19, 'Propios 1234', 'musgo@gmail.com', 'Piscinazo', '0933 1324');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (20, 'Tacuarembo 1234', 'perroRengo@gmail.com', 'veterinaria Perro Rengo', '0933 1324');
INSERT INTO `eloferton`.`t_empresa` (`ID`, `DIRECCION`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES (21, 'Siracusa 1234', 'pixar@gmail.com', 'Pixar', '0933 1324');

-- Esta fecha se utiliza para saber cuando fue la ultima vez que se consultaron las ofertas, cada vez que se consulta se actualiza con la fecha actual (una vez por dia)
insert into eloferton.t_parametro (clave,valor) values ('FECHA_ULTIMA_CONSULTA_OFERTAS','15/11/2013');