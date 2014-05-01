SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `mydb` ;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Poblacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Poblacion` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Poblacion` (
  `idPoblacion` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `no_habitantes` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPoblacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Centro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Centro` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Centro` (
  `idCentro` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `telefono` INT NOT NULL,
  `Poblacion_idPoblacion` INT NOT NULL,
  PRIMARY KEY (`idCentro`),
  INDEX `fk_Centro_Poblacion1_idx` (`Poblacion_idPoblacion` ASC),
  CONSTRAINT `fk_Centro_Poblacion1`
    FOREIGN KEY (`Poblacion_idPoblacion`)
    REFERENCES `mydb`.`Poblacion` (`idPoblacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Empleado` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Empleado` (
  `idEmpleado` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NOT NULL,
  `ape_paterno` VARCHAR(45) NOT NULL,
  `ape_materno` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `telefono` INT NOT NULL,
  `Centro_idCentro` INT NOT NULL,
  `Poblacion_idPoblacion` INT NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  INDEX `fk_Empleado_Centro_idx` (`Centro_idCentro` ASC),
  INDEX `fk_Empleado_Poblacion1_idx` (`Poblacion_idPoblacion` ASC),
  CONSTRAINT `fk_Empleado_Centro`
    FOREIGN KEY (`Centro_idCentro`)
    REFERENCES `mydb`.`Centro` (`idCentro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Poblacion1`
    FOREIGN KEY (`Poblacion_idPoblacion`)
    REFERENCES `mydb`.`Poblacion` (`idPoblacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NOT NULL,
  `ape_paterno` VARCHAR(45) NOT NULL,
  `ape_materno` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `pedidos_totales` INT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Factura` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Factura` (
  `idFactura` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `cantidad` INT NOT NULL,
  `total` INT NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  `Empleado_idEmpleado` INT NOT NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `fk_Factura_Cliente1_idx` (`Cliente_idCliente` ASC),
  INDEX `fk_Factura_Empleado1_idx` (`Empleado_idEmpleado` ASC),
  CONSTRAINT `fk_Factura_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Factura_Empleado1`
    FOREIGN KEY (`Empleado_idEmpleado`)
    REFERENCES `mydb`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Plato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Plato` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Plato` (
  `idPlato` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `precio` INT NOT NULL,
  PRIMARY KEY (`idPlato`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Factura_has_Plato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Factura_has_Plato` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Factura_has_Plato` (
  `Factura_idFactura` INT NOT NULL,
  `Plato_idPlato` INT NOT NULL,
  PRIMARY KEY (`Factura_idFactura`, `Plato_idPlato`),
  INDEX `fk_Factura_has_Plato_Plato1_idx` (`Plato_idPlato` ASC),
  INDEX `fk_Factura_has_Plato_Factura1_idx` (`Factura_idFactura` ASC),
  CONSTRAINT `fk_Factura_has_Plato_Factura1`
    FOREIGN KEY (`Factura_idFactura`)
    REFERENCES `mydb`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Factura_has_Plato_Plato1`
    FOREIGN KEY (`Plato_idPlato`)
    REFERENCES `mydb`.`Plato` (`idPlato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
