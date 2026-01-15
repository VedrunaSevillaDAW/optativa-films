-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;

SET
    @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS,
    FOREIGN_KEY_CHECKS = 0;

SET
    @OLD_SQL_MODE = @@SQL_MODE,
    SQL_MODE = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema filmsmicroservice
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `filmsmicroservice`;

-- -----------------------------------------------------
-- Schema filmsmicroservice
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `filmsmicroservice` DEFAULT CHARACTER SET utf8mb3;

SHOW WARNINGS;

USE `filmsmicroservice`;

-- -----------------------------------------------------
-- Table `filmsmicroservice`.`films`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `filmsmicroservice`.`films`;

SHOW WARNINGS;

CREATE TABLE IF NOT EXISTS `filmsmicroservice`.`films` (
    `film_id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(150) NOT NULL,
    `release_date` DATE NOT NULL,
    `poster` VARCHAR(255) NULL DEFAULT NULL,
    `in_cinemas` TINYINT(1) NOT NULL DEFAULT 0,
    `rating` DECIMAL(3, 1) NULL DEFAULT NULL,
    PRIMARY KEY (`film_id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;

CREATE UNIQUE INDEX `title_UNIQUE` ON `filmsmicroservice`.`films` (`title` ASC) VISIBLE;

SHOW WARNINGS;

SET SQL_MODE = @OLD_SQL_MODE;

SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;

SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;