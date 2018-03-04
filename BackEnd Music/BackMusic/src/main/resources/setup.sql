create database if not exists music;

use music;

drop table if exists usuarios;

CREATE TABLE `music`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `data_nascimento` DATETIME NULL,
  `sexo` VARCHAR(1) NULL,
  `usuario` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
PRIMARY KEY (`id`));

INSERT INTO `usuarios` (`id`,`nome`,`data_nascimento`,`sexo`, `usuario`, `senha`) 
VALUES (1,'Filipe','1994-02-17','M', 'fedispato@gmail.com', '123456');

drop table if exists faixas;
drop table if exists albuns;

CREATE TABLE `music`.`albuns` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `ano_lancamento` INT NOT NULL,
  `artista` VARCHAR(45) NULL,
PRIMARY KEY (`id`));

INSERT INTO `albuns` (`id`,`nome`,`ano_lancamento`,`artista`)
VALUES (1,'Skank - Multishow Ao Vivo','2000','Skank');

CREATE TABLE `music`.`faixas` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `duracao` INT NOT NULL,
  `id_album` INT NOT NULL,
  `ordem` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`id_album` ASC),
  CONSTRAINT `id`
    FOREIGN KEY (`id_album`)
    REFERENCES `music`.`albuns` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
INSERT INTO `faixas` (`id`,`nome`,`duracao`,`id_album`,`ordem`)
VALUES (1,'Sutilmente',185,1,1)