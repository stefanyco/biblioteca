-- MySQL Script generated by MySQL Workbench
-- 11/02/16 15:09:32
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering
-- Author: Stefany Souza & Eveline Renata

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema DB_BIBLIOTECA
-- -----------------------------------------------------

DROP SCHEMA IF EXISTS `DB_BIBLIOTECA` ;


-- -----------------------------------------------------
-- Schema DB_BIBLIOTECA
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DB_BIBLIOTECA` DEFAULT CHARACTER SET utf8 ;
USE `DB_BIBLIOTECA` ;

-- -----------------------------------------------------
-- Table `DB_BIBLIOTECA`.`tb_editora`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DB_BIBLIOTECA`.`tb_editora` ;

CREATE TABLE IF NOT EXISTS `DB_BIBLIOTECA`.`tb_editora` (
  `id_editora` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_editora`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_BIBLIOTECA`.`tb_autor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DB_BIBLIOTECA`.`tb_autor` ;

CREATE TABLE IF NOT EXISTS `DB_BIBLIOTECA`.`tb_autor` (
  `id_autor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `sobrenome` VARCHAR(50) NULL,
  PRIMARY KEY (`id_autor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_BIBLIOTECA`.`tb_categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DB_BIBLIOTECA`.`tb_categoria` ;

CREATE TABLE IF NOT EXISTS `DB_BIBLIOTECA`.`tb_categoria` (
  `id_categoria` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_categoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_BIBLIOTECA`.`tb_livro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DB_BIBLIOTECA`.`tb_livro` ;

CREATE TABLE IF NOT EXISTS `DB_BIBLIOTECA`.`tb_livro` (
  `id_livro` INT NOT NULL AUTO_INCREMENT,
  `id_editora` INT NOT NULL,
  `id_autor` INT NOT NULL,
  `id_categoria` INT NOT NULL,
  `titulo` VARCHAR(100) NOT NULL,
  `edicao` INT NULL,
  `ano` INT NULL,
  `qtd` INT NULL,
  `sinopse` VARCHAR(250) NULL,
  PRIMARY KEY (`id_livro`),
  INDEX `fk_editora_idx` (`id_editora` ASC),
  INDEX `fk_autor_idx` (`id_autor` ASC),
  INDEX `fk_categoria_idx` (`id_categoria` ASC),
  CONSTRAINT `fk_editora`
    FOREIGN KEY (`id_editora`)
    REFERENCES `DB_BIBLIOTECA`.`tb_editora` (`id_editora`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_autor`
    FOREIGN KEY (`id_autor`)
    REFERENCES `DB_BIBLIOTECA`.`tb_autor` (`id_autor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_categoria`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `DB_BIBLIOTECA`.`tb_categoria` (`id_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_BIBLIOTECA`.`tb_usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DB_BIBLIOTECA`.`tb_usuario` ;

CREATE TABLE IF NOT EXISTS `DB_BIBLIOTECA`.`tb_usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `ra` INT NULL,
  `cpf` VARCHAR(15) NULL,
  `nome` VARCHAR(100) NOT NULL,
  `tipo_usuario` VARCHAR(20) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `ativo` BIT NOT NULL,
  `qtd_livros` INT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_BIBLIOTECA`.`tb_emprestimo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DB_BIBLIOTECA`.`tb_emprestimo` ;

CREATE TABLE IF NOT EXISTS `DB_BIBLIOTECA`.`tb_emprestimo` (
  `id_emprestimo` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT NOT NULL,
  `id_livro` INT NOT NULL,
  `dataEmprestimo` DATE NULL,
  `dataDevolução` DATE NULL,
  PRIMARY KEY (`id_emprestimo`),
  INDEX `fk_usuario_idx` (`id_usuario` ASC),
  INDEX `fk_livro_idx` (`id_livro` ASC),
  CONSTRAINT `fk_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `DB_BIBLIOTECA`.`tb_usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_livro`
    FOREIGN KEY (`id_livro`)
    REFERENCES `DB_BIBLIOTECA`.`tb_livro` (`id_livro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
