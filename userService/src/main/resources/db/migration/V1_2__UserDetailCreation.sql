CREATE TABLE `user_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` char(50) NOT NULL UNIQUE ,
  `name` varchar(300) DEFAULT NOT NULL,
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `deleted_on` TIMESTAMP DEFAULT NULL,
  `ssn` varchar(20) NOT NULL,
  `date_of_birth` TIMESTAMP NOT NULL,
  `gender` int(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `user_details_userId_DeletedOn` (`user_id`,`deleted_on`),
  KEY `user_id_deleted` (`deleted_on`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` char(36) NOT NULL,
  `city` varchar(300),
  `address_line` varchar(300) NOT NULL,
  `pincode` char(36) NOT NULL,
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `deleted_on` TIMESTAMP DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `addresses_user_id_DeletedOn` (`user_id`,`deleted_on`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;