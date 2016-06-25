CREATE DATABASE IF NOT EXISTS `proyectofinal` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `proyectofinal`;


CREATE TABLE `anuncios` (
  `usuario` varchar(60) NOT NULL,
  `nombre_empresa` varchar(60) NOT NULL,
  `numero_telefono` int(11) NOT NULL,
  `numero_telefono2` int(11) NOT NULL,
  `precio` double(5,2) NOT NULL,
  `titulo` varchar(60) NOT NULL,
  `texto` varchar(500) NOT NULL,
  `comunidad_autonoma` varchar(60) NOT NULL,
  `tipo_profesional` set('Fontaneros','Electricistas','albañiles','Pintores','Informáticos','Limpieza','Mudanza') NOT NULL,
  `imagen` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `email` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE `anuncios`
  ADD PRIMARY KEY (`usuario`);

ALTER TABLE `users`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `email` (`email`);

ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_role_id`),
  ADD UNIQUE KEY `uc_PersonID` (`username`,`role`),
  ADD KEY `username` (`username`);


ALTER TABLE `user_roles`
  MODIFY `user_role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
ALTER TABLE `anuncios`
  ADD CONSTRAINT `anuncios_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `user_roles`
  ADD CONSTRAINT `anuncios_ibfk_11` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;
