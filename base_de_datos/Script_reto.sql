DROP DATABASE IF EXISTS FabricaIndustrial;
CREATE DATABASE FabricaIndustrial;

use FabricaIndustrial;
DROP TABLE IF EXISTS huella_carbono;
DROP TABLE IF EXISTS categoria;
DROP TABLE IF EXISTS tipo_consumo;
DROP TABLE IF EXISTS consumo;


CREATE TABLE huella_carbono (
  `anio_mes` INTEGER NOT NULL,
  `anio` INTEGER NOT NULL,
  `mes` INTEGER NOT NULL,
  PRIMARY KEY (`anio_mes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE categoria (
  `id_categoria` INTEGER NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50),
  `descripcion` VARCHAR(100),
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tipo_consumo (
  `id_t_consumo` INTEGER NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50),
  PRIMARY KEY (`id_t_consumo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE consumo (
  `id_consumo` INTEGER NOT NULL AUTO_INCREMENT,
  `consumo` DECIMAL(8,2) NOT NULL,
  `id_categoria` INTEGER NOT NULL,
  `huella` INTEGER NOT NULL,
  `id_t_consumo` INTEGER NOT NULL,
  PRIMARY KEY (`id_consumo`),
  FOREIGN KEY(`id_categoria`) REFERENCES categoria (`id_categoria`),
  FOREIGN KEY(`huella`) REFERENCES huella_carbono (`anio_mes`),
  FOREIGN KEY(`id_t_consumo`) REFERENCES tipo_consumo (`id_t_consumo`),
  CONSTRAINT consumo_id_huella UNIQUE (`id_consumo`,`huella`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
