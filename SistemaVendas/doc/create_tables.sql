-- MySQL Script generated by MySQL Workbench
-- Wed 29 Jun 2016 11:49:06 PM BRT
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sv
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sv
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sv` DEFAULT CHARACTER SET utf8 ;
USE `sv` ;

-- -----------------------------------------------------
-- Table `sv`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sv`.`cliente` (
  `cpf` INT(12) NOT NULL,
  `nome_cliente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sv`.`vendedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sv`.`vendedor` (
  `cpf` INT(12) NOT NULL,
  `nome_cliente` VARCHAR(45) NOT NULL,
  `nivel` INT NOT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sv`.`estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sv`.`estoque` (
  `codigo_estoque` INT NOT NULL,
  `qtd` INT NOT NULL,
  `qtd_reservada` INT NOT NULL,
  `estado_estoque` INT NOT NULL,
  PRIMARY KEY (`codigo_estoque`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sv`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sv`.`produto` (
  `codigo_produto` INT NOT NULL AUTO_INCREMENT,
  `nome_produto` VARCHAR(45) NOT NULL,
  `preco` DOUBLE NOT NULL,
  `codigo_estoque` INT NOT NULL,
  PRIMARY KEY (`codigo_produto`),
  INDEX `fk_produto_estoque1_idx` (`codigo_estoque` ASC),
  CONSTRAINT `fk_produto_estoque1`
    FOREIGN KEY (`codigo_estoque`)
    REFERENCES `sv`.`estoque` (`codigo_estoque`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sv`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sv`.`pedido` (
  `codigo_pedido` INT NOT NULL,
  `forma_pagamento` INT NOT NULL,
  `valor_total` DOUBLE NOT NULL,
  `vendedor_cpf` INT NOT NULL,
  `cliente_cpf` INT NOT NULL,
  PRIMARY KEY (`codigo_pedido`),
  INDEX `fk_pedido_vendedor1_idx` (`vendedor_cpf` ASC),
  INDEX `fk_pedido_cliente1_idx` (`cliente_cpf` ASC),
  CONSTRAINT `fk_pedido_vendedor1`
    FOREIGN KEY (`vendedor_cpf`)
    REFERENCES `sv`.`vendedor` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_cliente1`
    FOREIGN KEY (`cliente_cpf`)
    REFERENCES `sv`.`cliente` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sv`.`item_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sv`.`item_pedido` (
  `valor` DOUBLE NOT NULL,
  `qtd` INT NULL,
  `codigo_pedido` INT NOT NULL,
  `codigo_produto` INT NOT NULL,
  PRIMARY KEY (`codigo_pedido`, `codigo_produto`),
  INDEX `fk_item_pedido_pedido1_idx` (`codigo_pedido` ASC),
  INDEX `fk_item_pedido_produto1_idx` (`codigo_produto` ASC),
  CONSTRAINT `fk_item_pedido_pedido1`
    FOREIGN KEY (`codigo_pedido`)
    REFERENCES `sv`.`pedido` (`codigo_pedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_pedido_produto1`
    FOREIGN KEY (`codigo_produto`)
    REFERENCES `sv`.`produto` (`codigo_produto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
