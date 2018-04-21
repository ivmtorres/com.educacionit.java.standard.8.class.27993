CREATE SCHEMA `educationit` ;


CREATE TABLE `educationit`.`user` (
  `email` VARCHAR(128) NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  `enabled` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`email`));