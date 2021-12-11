-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema photographerforme
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `photographerforme` ;

-- -----------------------------------------------------
-- Schema photographerforme
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `photographerforme` DEFAULT CHARACTER SET utf8 ;
USE `photographerforme` ;

-- -----------------------------------------------------
-- Table `country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `country` ;

CREATE TABLE IF NOT EXISTS `country` (
  `id` CHAR(2) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(60) NOT NULL,
  `street2` VARCHAR(60) NULL,
  `city` VARCHAR(45) NOT NULL,
  `state_province` VARCHAR(45) NOT NULL,
  `postal_code` INT NOT NULL,
  `phone` VARCHAR(14) NULL,
  `country_id` CHAR(2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_country_idx` (`country_id` ASC),
  CONSTRAINT `fk_address_country`
    FOREIGN KEY (`country_id`)
    REFERENCES `country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `customer` ;

CREATE TABLE IF NOT EXISTS `customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `join_date` DATE NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `address_id` INT NOT NULL,
  `profile_id` INT NOT NULL,
  `enabled` TINYINT NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `fk_customer_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_customer_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `photographer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `photographer` ;

CREATE TABLE IF NOT EXISTS `photographer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NULL,
  `join_date` DATE NULL,
  `active` TINYINT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `address_id` INT NULL,
  `photographer_profile_id` INT NULL,
  `enabled` TINYINT NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `fk_photographer_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_photographer_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee` ;

CREATE TABLE IF NOT EXISTS `employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `join_date` DATE NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `active` TINYINT NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NULL,
  `address_id` INT NOT NULL,
  `employee_profile_id` INT NOT NULL,
  `enabled` TINYINT NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `fk_empolyee_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_empolyee_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contract`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `contract` ;

CREATE TABLE IF NOT EXISTS `contract` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `description` VARCHAR(45) NULL,
  `location_agreed` VARCHAR(255) NOT NULL,
  `event_start` DATETIME NOT NULL,
  `event_end` DATETIME NOT NULL,
  `photos_deliver_by` DATE NOT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_contract_customer1_idx` (`customer_id` ASC),
  CONSTRAINT `fk_contract_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `payment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `payment` ;

CREATE TABLE IF NOT EXISTS `payment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `paid_amount` DOUBLE NULL,
  `total_paid` DOUBLE NULL,
  `total_remaining` DOUBLE NULL,
  `total_due` DOUBLE NOT NULL,
  `contract_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_payment_contract1_idx` (`contract_id` ASC),
  CONSTRAINT `fk_payment_contract1`
    FOREIGN KEY (`contract_id`)
    REFERENCES `contract` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contract_has_photographer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `contract_has_photographer` ;

CREATE TABLE IF NOT EXISTS `contract_has_photographer` (
  `contract_id` INT NOT NULL,
  `photographer_id` INT NOT NULL,
  PRIMARY KEY (`contract_id`, `photographer_id`),
  INDEX `fk_contract_has_photographer_photographer1_idx` (`photographer_id` ASC),
  INDEX `fk_contract_has_photographer_contract1_idx` (`contract_id` ASC),
  CONSTRAINT `fk_contract_has_photographer_contract1`
    FOREIGN KEY (`contract_id`)
    REFERENCES `contract` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contract_has_photographer_photographer1`
    FOREIGN KEY (`photographer_id`)
    REFERENCES `photographer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gallery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gallery` ;

CREATE TABLE IF NOT EXISTS `gallery` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `photographer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_gallery_photographer1_idx` (`photographer_id` ASC),
  CONSTRAINT `fk_gallery_photographer1`
    FOREIGN KEY (`photographer_id`)
    REFERENCES `photographer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `image` ;

CREATE TABLE IF NOT EXISTS `image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `url_link` VARCHAR(80) NULL,
  `upload_date` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `image_has_gallery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `image_has_gallery` ;

CREATE TABLE IF NOT EXISTS `image_has_gallery` (
  `image_id` INT NOT NULL,
  `gallery_id` INT NOT NULL,
  PRIMARY KEY (`image_id`, `gallery_id`),
  INDEX `fk_image_has_gallery_gallery1_idx` (`gallery_id` ASC),
  INDEX `fk_image_has_gallery_image1_idx` (`image_id` ASC),
  CONSTRAINT `fk_image_has_gallery_image1`
    FOREIGN KEY (`image_id`)
    REFERENCES `image` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_image_has_gallery_gallery1`
    FOREIGN KEY (`gallery_id`)
    REFERENCES `gallery` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS dbamanager@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'dbamanager'@'localhost' IDENTIFIED BY 'dbamanager';

GRANT ALL ON * TO 'dbamanager'@'localhost';
SET SQL_MODE = '';
DROP USER IF EXISTS customer@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'customer'@'localhost' IDENTIFIED BY 'customer';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'customer'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `country`
-- -----------------------------------------------------
START TRANSACTION;
USE `photographerforme`;
INSERT INTO `country` (`id`, `name`) VALUES ('US', 'United States');

COMMIT;


-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `photographerforme`;
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state_province`, `postal_code`, `phone`, `country_id`) VALUES (1, '10435 walle dr', NULL, 'Portland', 'OR', 53291, '123456789', 'US');

COMMIT;


-- -----------------------------------------------------
-- Data for table `customer`
-- -----------------------------------------------------
START TRANSACTION;
USE `photographerforme`;
INSERT INTO `customer` (`id`, `username`, `email`, `password`, `join_date`, `first_name`, `last_name`, `address_id`, `profile_id`, `enabled`, `role`) VALUES (1, 'customer1', 'customer1@gmail.com', 'customer1', NULL, 'bob', 'billy', 1, 1, 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `photographer`
-- -----------------------------------------------------
START TRANSACTION;
USE `photographerforme`;
INSERT INTO `photographer` (`id`, `username`, `email`, `password`, `join_date`, `active`, `first_name`, `last_name`, `address_id`, `photographer_profile_id`, `enabled`, `role`) VALUES (1, 'Jim', 'jim.carne@gmail.com', 'jimcarne', NULL, 1, 'jim', 'carne', NULL, NULL, NULL, NULL);

COMMIT;

