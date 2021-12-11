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
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NULL,
  `role` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `join_date` DATETIME NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_user_address1`
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
  `active` TINYINT NULL,
  `user_id` INT NOT NULL,
  `business` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `buisness_logo_url` VARCHAR(3000) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_photographer_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_photographer_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contract`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `contract` ;

CREATE TABLE IF NOT EXISTS `contract` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  `location` VARCHAR(255) NOT NULL,
  `event_start` DATETIME NOT NULL,
  `event_end` DATETIME NOT NULL,
  `photos_deliver_by` DATE NOT NULL,
  `user_id` INT NOT NULL,
  `closed` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_contract_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_contract_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
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
  `rating` INT NULL,
  `comment` VARCHAR(250) NULL,
  `price` DECIMAL(8,2) NULL,
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
-- Table `payment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `payment` ;

CREATE TABLE IF NOT EXISTS `payment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `contract_has_photographer_contract_id` INT NOT NULL,
  `contract_has_photographer_photographer_id` INT NOT NULL,
  `payment_date` DATETIME NULL,
  `amount` DECIMAL(8,2) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_payment_contract_has_photographer1_idx` (`contract_has_photographer_contract_id` ASC, `contract_has_photographer_photographer_id` ASC),
  CONSTRAINT `fk_payment_contract_has_photographer1`
    FOREIGN KEY (`contract_has_photographer_contract_id` , `contract_has_photographer_photographer_id`)
    REFERENCES `contract_has_photographer` (`contract_id` , `photographer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gallery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gallery` ;

CREATE TABLE IF NOT EXISTS `gallery` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `photographer_id` INT NOT NULL,
  `description` VARCHAR(250) NULL,
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
  `url_link` TEXT NULL,
  `upload_date` DATETIME NULL,
  `title` VARCHAR(100) NULL,
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


-- -----------------------------------------------------
-- Table `photo_shoot_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `photo_shoot_type` ;

CREATE TABLE IF NOT EXISTS `photo_shoot_type` (
  `id` INT NOT NULL,
  `name` VARCHAR(60) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `photo_shoot_style_has_photographer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `photo_shoot_style_has_photographer` ;

CREATE TABLE IF NOT EXISTS `photo_shoot_style_has_photographer` (
  `photo_shoot_type_id` INT NOT NULL,
  `photographer_id` INT NOT NULL,
  PRIMARY KEY (`photo_shoot_type_id`, `photographer_id`),
  INDEX `fk_photo_shoot_style_has_photographer_photographer1_idx` (`photographer_id` ASC),
  INDEX `fk_photo_shoot_style_has_photographer_photo_shoot_style1_idx` (`photo_shoot_type_id` ASC),
  CONSTRAINT `fk_photo_shoot_style_has_photographer_photo_shoot_style1`
    FOREIGN KEY (`photo_shoot_type_id`)
    REFERENCES `photo_shoot_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_photo_shoot_style_has_photographer_photographer1`
    FOREIGN KEY (`photographer_id`)
    REFERENCES `photographer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contract_message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `contract_message` ;

CREATE TABLE IF NOT EXISTS `contract_message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `message` TEXT NULL,
  `user_id` INT NOT NULL,
  `contract_id` INT NOT NULL,
  `message_date` DATETIME NULL,
  `in_reply_to` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_contract_message_user1_idx` (`user_id` ASC),
  INDEX `fk_contract_message_contract1_idx` (`contract_id` ASC),
  INDEX `fk_contract_message_contract_message1_idx` (`in_reply_to` ASC),
  CONSTRAINT `fk_contract_message_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contract_message_contract1`
    FOREIGN KEY (`contract_id`)
    REFERENCES `contract` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contract_message_contract_message1`
    FOREIGN KEY (`in_reply_to`)
    REFERENCES `contract_message` (`id`)
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
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state_province`, `postal_code`, `phone`, `country_id`) VALUES (2, '432 wallabee way', NULL, 'Portland', 'OR', 53211, '987654321', 'US');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `photographerforme`;
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `email`, `join_date`, `first_name`, `last_name`, `address_id`) VALUES (1, 'billyjoe', 'goat', 1, 'basic', 'billydagoat@gmail.com', '2021-12-11 16:01:00', 'billy', 'joe', 1);
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `email`, `join_date`, `first_name`, `last_name`, `address_id`) VALUES (2, 'pete', 'Ram', 1, 'photographer', 'pete.ram@gmail.com', '2021-12-11 16:01:00', 'pete', 'ram', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `photographer`
-- -----------------------------------------------------
START TRANSACTION;
USE `photographerforme`;
INSERT INTO `photographer` (`id`, `active`, `user_id`, `business`, `description`, `buisness_logo_url`) VALUES (1, 1, 2, 'Picture Perfect', 'Capturing moments for a life time to see!', 'https://www.google.com/imgres?imgurl=https%3A%2F%2Fi.pinimg.com%2F600x315%2Fd3%2F7b%2Fb5%2Fd37bb505d66dbe615f0eec31e1973dd6.jpg&imgrefurl=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F15692298688393483%2F&tbnid=lUC7SM25RpSkJM&vet=12ahUKEwiv0onb7dz0AhVOAc0KHQ-JCvAQMygBegUIARC0AQ..i&docid=8Wx0kEnYn51SuM&w=325&h=260&itg=1&q=picture%20perfect%20logos&ved=2ahUKEwiv0onb7dz0AhVOAc0KHQ-JCvAQMygBegUIARC0AQ');

COMMIT;


-- -----------------------------------------------------
-- Data for table `contract`
-- -----------------------------------------------------
START TRANSACTION;
USE `photographerforme`;
INSERT INTO `contract` (`id`, `title`, `description`, `location`, `event_start`, `event_end`, `photos_deliver_by`, `user_id`, `closed`) VALUES (1, 'Family Photo ', '30 min session', 'Woodland Park city center out front', '2021-12-13 16:00:00', '2021-12-13 16:30:00', '2021-12-17 16:01:00', 1, 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `contract_has_photographer`
-- -----------------------------------------------------
START TRANSACTION;
USE `photographerforme`;
INSERT INTO `contract_has_photographer` (`contract_id`, `photographer_id`, `rating`, `comment`, `price`) VALUES (1, 1, 3, '3 out of 5 meh', 250);

COMMIT;


-- -----------------------------------------------------
-- Data for table `payment`
-- -----------------------------------------------------
START TRANSACTION;
USE `photographerforme`;
INSERT INTO `payment` (`id`, `contract_has_photographer_contract_id`, `contract_has_photographer_photographer_id`, `payment_date`, `amount`) VALUES (1, 1, 1, '2021-12-11 16:10:00', 200.75);

COMMIT;


-- -----------------------------------------------------
-- Data for table `gallery`
-- -----------------------------------------------------
START TRANSACTION;
USE `photographerforme`;
INSERT INTO `gallery` (`id`, `title`, `photographer_id`, `description`) VALUES (1, 'Basic Display', 1, 'A collections of photos taken');

COMMIT;


-- -----------------------------------------------------
-- Data for table `image`
-- -----------------------------------------------------
START TRANSACTION;
USE `photographerforme`;
INSERT INTO `image` (`id`, `url_link`, `upload_date`, `title`) VALUES (1, 'data:image/jpeg;base64,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', '2021-12-11 16:01:00', 'First photo');
INSERT INTO `image` (`id`, `url_link`, `upload_date`, `title`) VALUES (2, 'data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAoHCBYWFRgWFRYZGBgaHBoeGhoaGhgaHBwaGhohHBwcGhocIS4lHB4rIRgaJjgmKy8xNTU1GiQ7QDs0Py40NTEBDAwMEA8QHxISHDQsIyw0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDE0NDQ0NDQ0MTQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NP/AABEIAOEA4QMBIgACEQEDEQH/xAAbAAABBQEBAAAAAAAAAAAAAAADAAIEBQYBB//EAD8QAAEDAgMFBgQDBwQBBQAAAAEAAhEDIQQSMQVBUWGBBiJxkaGxEzLB8ELR4QcjM1JicvEUgpKiwhZDc7LS/8QAGQEBAAMBAQAAAAAAAAAAAAAAAAECAwQF/8QAIxEAAgIDAQACAgMBAAAAAAAAAAECEQMhMRIiQTJRE2FxBP/aAAwDAQACEQMRAD8ApiU5oQAbI7CoLBWNRC1MYU4FAEaEyqit0Q3sm6AYwp5auMYpLAgBsYpFJtvyXBqm4rEtY2Tc7hvKhuglYmp4Cq2OqVPlB/tb+abisLiKTczpZJhoMEnjOqz/AJo2a/wyqy8bCadVW4DaBJDXxJ0dp0KtA1aRkpcM5RcejE8C8eSRsjUYO6VJBx7LpjwpT2IbgEBGeyE6muvuusCAcWrrWJx0XGOvfdyQHCxCDbo7tEJpQChDdqig6prmb0Ax3BDeEV4QXlAMhdTcySArclkmBd3JzAgOgp7CuFqe1qAkUtF1zYQmPhdc8lAOanssUFhRUA+rUDRmJgKkaTWqSdJgDlw+p8Cu7bxUuDBoLnoibAwtV7z8MNdkbOUmJJjfKxySb0jfFGts3nZzZwY3MRc8eG5Wu0NmMqsLHD/PFZzAbcex5bWpmk1pDS5xOSbAEOdcC4E6eC0o2izTMOl/ZZqKSpmzk27R5htrC/CeabrOtB431CnbHxBe0td8zI8vuyte2uEa80qgIkPgxvaRPoW+qotlWrEcQfcpjfmVFcsU42W7mSpWGp2TWtR2H7C6jkOvaojmKc42QXgcYQEZrLrr2ckQBdeLdEBHAMJ5YkxqM42QEWpoUNmiO9kobWRZAMBRGmQuPCEw68kA6rEoLwiG6Y4IAeVdXYSQFVuT6aG46IrSgH5CjRYoQN0YOsgBtSyp7HldKAawLtSqGNLjuCe1Ue3MaLMabWmOKiTpExVshPeXVCSt72doMY2SXMM/M3eTEgggg6ARyXn+FBzgkakL0Ts/im1G16LruDnSN5abgj73Lllfqjrx1TLBwbUeBVLXBneDHNytcRoTJdmjhPTRV1Ls5Re1rWONKowv7rbZu8Ydl3jQyOJCsP8ATOAyiHD+R7A9sxuLiC2eF/ou4h3w6bvjtp5IzFvzNaQLxmA4cEtou0mY7tFjnsexjnZmgF08XgFjvEd4dZ4WpsPi6mYvBDZ0J4cpTMfijWe+s4Q1xDKbdO43S24HVafYewGvh9UZyRYXgeAUt+dmdenRUN27WbcuY7xFvSCrbZnaJrjFRuQ/zA93rNwtCNgUC2PhhYrtBsF2HdnYZYT1E8eIVo5L0VlhrZtJshvbF4VD2X2iXNNN34bt8N49QR14K/eZC2TtHO1TAPCaXzCI9vJMYOSsQOaPZdEDXVMeYTZnegCyhvCM0aIb95QEeoOCEGo7kLKgGkJhCNC5kQAIKSNlXUBQvF0ZqEQnAIA4RKaA0IkIApEb0wvi5KaX2VRtphADsxv+H68gobpBK2cxm0S45WGG6f3fkEzAYQPMuPgBBMcYVZRfLoH2Vqez2Fa6YggROkhRBem2y7dKkR8ZgchaQZEjkfyKFicRUo1zUpGHtMcnNN4IVzttmVl+IjwnT9VBxjWl7tLNYTyJb+QCxzfGSf8ARti3Gv7J+I7e1GtDRSYXkDRxIvyhZzau0q2IP759v5BYeW//AAqzGVQyo8tM3gHlolgGOqvDZ1noACUqtkem9Gi2Pgw9zSR3KdgOLjc+QjzW1w2KZT7rnsa4xDXPgnwsqTYTQPDM6P8AkY9IWmxOz2PAc8MJGhIaTpulYXcjqUajomYHENqNkSIJBBFwRryPiqvb9APY9katI9F1jDSpPFOMxIyzcDd9FQYradVtKqash7GFwBDcpBkQC0WIPM2jij3wLXTOdmKn70c4HWCFt3PWC7OsIezjJPoVsq2JDW5nGw1XZB9ODItolEkCVHq4oNsSB1CpmV6tZ0MBjgLeZT8T2RqEBzHS6STeLbo4qjypOi0cUmrLP4k6XSYIuVU0aD6Tg18yNxsrdj5CtHIm6IlBx2GZU4ymPfIUdjo3ooII1utDMaXQmyivbK4KYQDGuSYiOAQ32QHYSTcpSQkog5OCCworChAVhRMyE110akJCAFUqwJ9Oap8QS83U3EvBk7pMeDbk9TCjNZJAGtrq6QIGHwuV4I0larZWDAJIlpv3gYtOh4jkqNg745mPM+i1mApksaNAN/KVKVIWA7QHPTBkES2+h+YekBZXaeKmo6Jg5QY3QAtHtiiXNbc7oG4CIHiSs+Nm1Xl0NG+SDN5vpvXPlS9WzXG3VLpWYikJLSJ4HxVzs1jWZYG4+ubX0UJ+zXscM/Eel0fZ5kRvv7kgeipOSktF4RcXs2ewqQe2OBPmJVphqDnBwc14LdXiH6Gxi8AxOkLPbDxnw3w75SZnhm/UrWAkDOzzBg/4XOkrOu21SK2vjXsDWuDHAOHea7W4FwBwKoe2uMAYKY1qOFv6R3nH0A6qz2xiqbM1au7vkACTcgEkDKLG5PNefOxzsTXL3CANBwaDN+esq0Y+nf0is5qMa+2WWxxNYcGg+0Kdi8XncQD3G+rtJ8Bp5qjOIcwHLZz7TwBuT7qVRIyAcco/5GPZbOVRo5auVmz7PYeGjnc9brZ4aiIWRo0KjWB1Nue2mYsHmLq82S+qA4PEEAECZvGiwX7Z0PlIJt3BMcwyLtEg8I19FlizQ8e67xGh91b4jG1iXtcx8QRmlpbccNYuoFcjK7xn/t+qhunoVa2QHMvCJSiYQnuuU6lvK7Yy9RTOGS8yaJKcg0yUTMrEHCUGo9OzpEoSD+OPuEkRJAZ5hXGSuNKe0oQOaliauVscbdN/3zXQVCqPzuPQDqQpQCOb3QP6D5k39kxlTK1xHIDxP2FLqNtMRAPVVrphjR4nrpKuAuGIDm7z53F58NFqcLVGQCYGn4rkwANOao9lYcEve4/K02vwJVxj6eRkgcCT1ueWrvRCCNtmt+7JH4RY3N4tDRqfGFEwQOFy1mg/DJHxGGTmFg57JvmE66FXDKQyd+8/LzG53UJj8OagcHzGUiBzEW4KJRTVMtFtO0P27hQ/vsu2AQRvBvKpsHgYBPCP1V92RLgx+HqfNTMNJBh1M3aRPAyOVkLZ9CpnrB7MrQ4ZZibiXC26TqvOacW0d8WpJMjNp2v9hVm0O0FTD/u2Pkncb5R+atsZRc0F7zlZBPg0alZmpsx+MrzRaSwAAvIygHUzA15AK0Ip7fBlk4ql0pcbin1HFz3FzjBk+oHBTtm0MrCTvt6XPrHVStubDdhntY45gWgh3HcfUIjWd1oJgAgE7r95xWreqRzJbtlViamZwA10HVWFMjuyY77Y6NkDzTnbDLjnYTlklo3x4qThqDTE/wA7XDxGo6gKZx8rZEHbN72Yxn7nPBIyg2E2I4KXh8Xmc5weyHaZswI8OIWd2Xi/9K57D3mBzhI3Am3RavZtVjmZmPBab68dZWK2dNncVj2fCfo6GO7zYIkDSRvlYEbRljhxj3V32q7TU2M+DTIc51iR8oG+6wFHEybI43sj0lo0tKrmqOA0gffup7VUbKZEuO8D6qyzaX0W+JVE5cj+RJaV0IJeuh61KDyFwprXXTigFCS5nSQGdC6HIWZEgoQOqP7p8vOyjhmV4ne4T4jX3CM1svY3xcei5ViHE6yYjkdfT70V0A2Lf3TvkW62UWg0y9/E5WjiR+S5UqgNA3yPIcOSPh7d6HOiSI1uT0P6KQTsDRyjLxsec/4CsNp4s5HMc2xa4AjifBU1LH07d5zeIcxw0NtBBR61djy3I/NB0DXC5tq4AKG0KJ2FnI1gJkNvu+4U/C4NzoZnBvcwIA9yVW08PVJBYGg6HNM96fxbrtI8UbE7Qr4Zhc+gIAkkPHPlyWc5/o0hFPrNnh8MxrQ0XjedTzJQnbHpF5qZYeRlLgTdvAiYOnBedj9oTx/7P/b9FJwn7SCXhr6eUE3dm09Fi4y+0bKcfpmx2jsUvblDwJgGWZu6DcRI1EjqlshtFmanRYWspktc8jK3NqQ0n5je5FuaKzazHMDw4ZYknUBYg9u2S+WOPeMARGvMwTzM+Cqo/SLuVbkyd20eXuYzcCSw+PzDwsCOvJUtCgYaLa+pQ24x+Ir532DWnK2SQJPE6nnyU3DA5wQCWiQbTrHeHgY9VtCG9nPOdt1wnspfCDAPkflB35Xm2a+4k3ULa2ALA6ATmc3KNIcD9QVP2q8fBLWubIbvNwReec6eMKZsnBvrsaKwIbIMEAExpPL1VsrXnZGNNvRktn4x7tWkgWM6rQ4TBsPeg33RqfqtMNiUBYMbO/j1OqczZDBYW1jf7rnai/2br2vtGE2rhWOLie5ldANtQAb/APMIWB2exswQ4kCTGgGseK0W09lvpubMOZUdUzOAsC4U8gO8WYR/lAwFMVBPG5tZt8wHMgEdfTSOJSWnoxc3F7WyCBBPj5cAuioi4+kGvgaQPv0QAtKS0jNu9hQ9dzFMC6FIHMddSHOQmMTnO3QgFnSTZ5FJAUOSyM0LmZda5CDlE957juGUeUm+5DAimXHQzHIfYT6b4Y6bTLvr+S7VpxSbIs25+n3yWgIZZYTrlnwC0Ow8Gfh5oub9As/hpcWxq4R5uIhb7BUcrQB9+KpJkxE3BMEODQWkA6TLfxdRY9FLZhmAWaCOQ1B/ROpCBG6ZHFp39CnOO7d92WbLESqzvgDUlvXK6fb3VJ+0HFllFjAP4hIJ4Btz56dSrapVmsxgN4cT4Rb19lQ/tG/hUD/W7/6/oiVhujC5UJ9BEaV2VqUDUcS9jHMDjlcII6yoTjCkOdZRHmbKKSDbZptlnKwvImYHkP8AK0GzqIqtD8rfB0m86iZm25UWzz3GAwReZ4fd1fbCxDGZ2McDeRfQb9d0n2UxWiS4wOymOc0m+XjFo0gboVtXxQp2ECIzOOjZsOp/yqettQUWPfq75Wji77PoqEYCviXZnvybrScxPzE8uS5MsrkdeKNRNXidoYZkvqVGTqTOcmOAFz0soo7TYZ38J5mQCxwc0OBIHdzaOvNv1VRS7ESZ+J6FcxPYmNKnmOGiraLfK+GtqtLmXzOa8HvQQ6OYAs4WIMXWb2JRIbDhOUkCA4aOImDBvHqtB2axT8hpVPnp2n+Zv4XDx08QVWbVouFd5YSBIJjmBK1wPbRlnWkyv222HN439I/NV9NTNosce8Gd38TjrPjwUAOW0ls5wgKIHIDXJzSgJLai4DdNaFxxQBkkL4iSApiliHQw+XmukIGK0aOJCkgNTGcNbuJE+A1Hp7KZXM03+MDooDH5HSND6HkpeeQRxB/yrgXZ6kHPYdzQfObe58ltqdtFk+yTJDzwd6LX0W2HBZSey0eDg47vI/nqEN9QATceXuEQ+Xr7LPdqseWUyxh77rDiBvKqSN2LiviYmq/8LWloPX9HHqoP7R6v7rDj+t58gPzUzslhTTpuc75j7AfqqT9oNTN/p2/01HHqWgexUrpD4ZQVF0PQDT4lGyNGjSfvmrlDlSoItqUTZ9HM6ToNVGeL8J3K2wOHyskzJ0id9lBJftomk2m57ZaQCSN08/Az0UitVpNeXTEQQbCdeEctOSiYvbTfhhmSzRHesJ+/ZZSti5JdGZx36ADg0bgryeqQT3s0VfaJq1mD8DTbmSbkrdbGIICw2BoA06D4vcHxuDJ8R6q+o43E04a2nnuNwAg8DOnNcM0m6R3Y20m2egUxG5Mxr5Cp8BtJ76ZeWFpbq3fPJV7+0T3OLfgPAtDnAmZNrAW+ih7ReqdnMRjsmKpkaEOa7wJkeo9VNxrmuqO/2nzEfRZbtE456JIyu71ueU5b+MKXhtpk98CXFsEHc4fldaYlTTMcru1+i8rPhruGUyDfcsm9ylYvHVHEguAsS4AACBre5KgF+8GQdCF0yRyhGvRqblEYURjlAJrXJtRMY5de4WQHIST8w4+6SAqGuSc0GORlJrE4NQgG4S0A638eSYHlpv8AYRy1RMa7K2T+v3vVrBoOzDMl3PDS46HgRY310C2LJiQOrSPY2Wc2CHfDGZua180BzRuItMePBaJtNsTEHmP/ACb+azZZEfHYgMa5xJsCT3HTYSbiyyWHpjEOdVzAtnTeI0EFF7QbZLKrKTXSMzS/vTAmzeut+XFTf/TrGAuaMzHXEOLXNBvAc2JHioRIRlUBhYwiSQI8bLD9rcX8TEuDTLaYDB/s+b/sXeS1mLNPDU3VQDmAhgcSTmNhv8ekrzySTJMk6+KsishAHcjCd0BNaikq5BEYyX34q+qWgiIAG+BMWVJP7wKfUc1stF3n5jqG/wBI58UXQAxRLz3iDGkaeqFnLdwPiPyUkMQ6rLKaILXZO0GuZ8MiDmDm/UD3XoGFxrG0w50GBwBPSV5JgnltRjh+Eg33iYgczovQDhg+kHsMFphw3HgSPBcuaNSs7f8AnlcaZocFVljyIguH0UujXpmZgO8I6qlwWw25ZzCDctDngHmWRB80ZuEytzPcI/C0SI8TN7LB6Ojpm+1ldrXscXD+K0Ab4g97+0QJ8VVMpvpPzkmHkyBcAREwd956Kv7RVfiYl5Is05G+DfzMlMoVntbla94bwDnR0E2XbhjUTgzSuTaNRjwx9B7aL8znC5FjzDp+WdN2qp9nyyWOkHcItO8TNlXZLzv4qzwTy4NBnM3Sd4H4Z4gXWjRkSQ5FY5R2lSmCyoBNenB0lDdqnM1QBcxSSypISRWhKEmpxQgaWqLs4itiWNN2MkxxLR+ceSftGtlYTvNh1/SVL7FYT56hG8BvGB83SSPJT9BdNjRogRAg3uDcfmORUh1WGndaeXjBsEwaff2FUdose2lRcXE97uiNZI3evks2XMNWJfVL3GJJcSbAD9Ar7C9q2NpwavdEw3IS4wfQHUSsji8W5/dFmDdvP935e6CGKyiUsn7b2u/EvkjKwfI2dOJPFxVeJG4pwZ9wugcR5EqyQBueeBRDV33jeuhgSe0KSDuzxnqzuCk1xDgBwVdgsY5gIaBMm8dOKkYdxNyZKlAkgpmJeAJKcEHGNkBWfATcDhPkmLvk757oLQDyn34LU7NxQp1If8lQQev6+6oNmV84AaJqBuUN0HcvPi5rnjxHgrtrGvEAhwgEOiBzB4EbwubLF9N8MktfZp8NhQI77o4TZRcbiRUflZ8jNTxP+VS0cDUPdDnZOAdZWLGFmWmwS9xhosL+JXM19I6/erZhdt2eXGbve0cIEO18XHzCjU3KZ2peDWNNsxTGU5tc/wCMxul0+irMM7cu+GkkefJ3JsnNKsdkvbnyOMZvl/ubJ9pVW0rlYmJBgggg8CDZXfCpp8XhCxwO4+UpjPZS8JjW1MOXGBaHcnRw9R0VeKllk0Sdc6SiMQGlHagH5kk1JADDxCQMqOHJ7HwgIO3H2YPE/QfVbXYmDDKVMaAsaZ/qIl0xoZlY9lFlXEMY9wa3LvtJ1iea32DZAGV82uG5XN8vqofCYh3W+59R+S867aY34lUMBtT11+Z2u7cI81t9rbQbRpOe6CANxLCTubBm5K8oe8vcXHVziTv1MqEtkyY5jSnXRQ6wt5kBcyE6fU/RXsqCLTxXMp4p72kbimO/tP31UkDXyBqmYirASdPA/fVBawudJ0HugCUmQOf1UrDIJC0tHY7f9AMRGV4fcye80uy6aCCRpwRyUasmMXK6KlMxHy+XunrQ9mNjipNao2abJgHRzhvje1vv4KZSSVsRi5OkZSm9zCHNJBHBX+GxJrvYym9tJheCabnOEvLYLsw3Ez3Z/SnxNRr3ve1oa1ziQAAIE2sNPBBIUIcNE/aFbDl4FVmZhcA1sFpuRGUNvETJNrX3Kl2ltGrXeC82tpFr3IG4oEb12FHlXZPp1Ryq6S5ztSST1WlHZsOwjK1IS8DNUF5LYvA4t4AcVXdnsBTrVgyo8stLYi7gREk7lv8AZbHMOYTEltRv8rhvHl7LPJNxao2w41JOzzQFSKeCe9lRzYimzO7XQEaRv/JbDtF2Szk1cMBJkup2aCeLJsDyNlI7M7NOGoVqmIaG5hdpId3AN8SN59FZ5V5tdKrC/VPhgtmV8r4Js63Kdx++KuQxZoPBPC9hw5LQYWtmaDv3+KszIkBic1cSCgD5STZSQEKbLgK5NlxqAkdnqQfii46MB87N+pW5FBp3QeVisV2Vwr7vYBdxB1BcLb+R5cVv6YcQAGwY3n6hUlNXRrGEmrowHb3aZBGGa6QQHPnXWWiek+SytBlrq97e4B7MTndBFRoLSAR8vdIMn5hbzCpqYsrRpq0ZyTT2HYEVoQmFEarEDXgcVFqO+7lTnNCiVggIj3kiAk1nMpMunlw4qUQNzdV6R2Yo/G2e6k92UHOAdYh1vYLzdrJK9V7JYTJRDJkAvv8Azd43jcFjmdJG+BW3/hTYPsU8uGd7Qz+iS4jqIb6rU4nB9xlCl3GWD3C2VguQ3i5xgdSVZPcGhQa9SRd1tSBrCxlNy6dMIRjwwvbakwVGGmwtBacz4hryIGuhcN55hZpaHtjj3PrZJAYwCGjRpI0PMCPMrPLpx/ijjy16dCSKSS0KEnZuIDKrXO+U908p0PQgHovRsDiJuDd0E3/ELEEcYheXPbIWg2BtiQGPPeHynjHuVhlje0b4ZpfFnp9GpLOYWe7bYrLhHgH5ob0LgHekqZgMXIv1/VQO1rGGg8uMZQSDxMER1mOqwi/kjomvi/8ADy9sDcrHZuJyuykEZojhKgHknsqQu2jgNMx6e26hYarnE+fipzFUD8oSXMy6gKqU4PG+Y5a9EKUbDMaXszmGhwnwkKJOkTFW6NrsLCNYxoAIBBieEyequvihkk6RHpcrOnGuYH5e+wHIJPyjdbUAiLoG29qfEpOawZS0Aw7fESLHeuZ7O5VRZ7bwNPHUGOGrXAhxlo4cRaD1gKjqbHwrGhtV4eWxak1rTYQA6pEnyvxUJ22H08NUYXd5xuBfuuAnlbRZs7VO4EnmrxjL6MJSiWm2XUWtHw2Bhm0OcTG+STdVzHKKXOcczjJRmOW0VSOeTthyUCqEQFMqBWBXTEjmV3XVNqHvFdBspICM08F6d2b20x7GyWh+9vA+C8tYVJo1XNOZji08QYVJRUlTLwm4u0etYnGj+YW3zbqsntvtQGgsouzONi4fKP8A9FMwWxahp/ExJOUDusOl7y8ceSy+PYA8kb7rGMY+quzonkko2lRzMTJJkm5J1JSCEHruZdJyhEpQi8pZlICSo9UQQeYTy5NiSBzHuoBotm9o3MYWvkkDukAT1k+qi7W22+uAySGC8WueJj2WhHY1j6eZjy10SJ7w8LBYvFYd9N7mPEOaYP5g7wso+G7S2azc1Gm9Dcy7mQpXVqZFtsV5LiJtE9dPqrmQqHYre+4/0+5CugqMBJSTYSUgrwnO0KSSS4I9LvZ/yVf/AIx7FVtX/wAQkkuaPTsl+JCxf8N/9pVDR1XEl0o4mTG/miDRJJSSEG5cqLqSAqa/znokEklKKjgp+yf41P8AvZ7hJJVlwtHqPT+0/wDBd0+q8rxvznwHuV1JYYunTn4R2p4SSXScp1NKSSEnEm6jxHukkjCPW9jfwB/aFhO2n8f/AGhJJc2P8jqz/gZ5ILqS6DlLjYej+n1VruSSUA4kkkgP/9k=', '2021-12-11 16:01:00', 'second photo');
INSERT INTO `image` (`id`, `url_link`, `upload_date`, `title`) VALUES (3, 'data:image/jpeg;base64,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', '2021-12-11 16:01:00', 'third photo');

COMMIT;


-- -----------------------------------------------------
-- Data for table `image_has_gallery`
-- -----------------------------------------------------
START TRANSACTION;
USE `photographerforme`;
INSERT INTO `image_has_gallery` (`image_id`, `gallery_id`) VALUES (1, 1);
INSERT INTO `image_has_gallery` (`image_id`, `gallery_id`) VALUES (2, 1);
INSERT INTO `image_has_gallery` (`image_id`, `gallery_id`) VALUES (3, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `photo_shoot_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `photographerforme`;
INSERT INTO `photo_shoot_type` (`id`, `name`) VALUES (1, 'Weddings');
INSERT INTO `photo_shoot_type` (`id`, `name`) VALUES (2, 'Family ');
INSERT INTO `photo_shoot_type` (`id`, `name`) VALUES (3, 'Holiday ');
INSERT INTO `photo_shoot_type` (`id`, `name`) VALUES (4, 'Fall ');
INSERT INTO `photo_shoot_type` (`id`, `name`) VALUES (5, 'Home Coming');
INSERT INTO `photo_shoot_type` (`id`, `name`) VALUES (6, 'Professional');

COMMIT;


-- -----------------------------------------------------
-- Data for table `photo_shoot_style_has_photographer`
-- -----------------------------------------------------
START TRANSACTION;
USE `photographerforme`;
INSERT INTO `photo_shoot_style_has_photographer` (`photo_shoot_type_id`, `photographer_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `contract_message`
-- -----------------------------------------------------
START TRANSACTION;
USE `photographerforme`;
INSERT INTO `contract_message` (`id`, `message`, `user_id`, `contract_id`, `message_date`, `in_reply_to`) VALUES (1, 'Testing message', 1, 1, '2021-12-11 16:04:00', NULL);
INSERT INTO `contract_message` (`id`, `message`, `user_id`, `contract_id`, `message_date`, `in_reply_to`) VALUES (2, 'second test message', 2, 1, '2021-12-11 16:08:00', 1);

COMMIT;

