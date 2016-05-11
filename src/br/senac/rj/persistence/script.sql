-- Banco Livraria
CREATE DATABASE IF NOT EXISTS livraria_pos;

USE livraria_pos;

CREATE TABLE livro(
	idlivro INT PRIMARY KEY AUTO_INCREMENT,
	isbn INT NOT NULL,
	titulo VARCHAR(255) NOT NULL,
	datalancamento DATE NOT NULL,
	imagem VARCHAR(255) NOT NULL,
	id_autor INT NOT NULL,
	id_editora INT NOT NULL,
	id_categoria INT NOT NULL,
	id_idioma INT NOT NULL
);

ALTER TABLE livro ADD CONSTRAINT livro_autor
FOREIGN KEY(id_autor) REFERENCES autor(idautor) ON DELETE CASCADE;

ALTER TABLE livro ADD CONSTRAINT livro_editora
FOREIGN KEY(id_editora) REFERENCES editora(ideditora) ON DELETE CASCADE;

ALTER TABLE livro ADD CONSTRAINT livro_categoria
FOREIGN KEY(id_categoria) REFERENCES categoria(idcategoria) ON DELETE CASCADE;

ALTER TABLE livro ADD CONSTRAINT livro_idioma
FOREIGN KEY(id_idioma) REFERENCES idioma(ididioma) ON DELETE CASCADE;

CREATE TABLE autor(
	idautor INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL
);

CREATE TABLE editora(
	ideditora INT PRIMARY KEY AUTO_INCREMENT,
	razaosocial VARCHAR(255) NOT NULL,
	nomefantasia VARCHAR(255) NOT NULL
);

CREATE TABLE categoria(
	idcategoria INT PRIMARY KEY AUTO_INCREMENT,
	nomecategoria ENUM('ACAO', 'Aventura', 'Drama', 'Infantil')
);

CREATE TABLE idioma(
	ididioma INT PRIMARY KEY AUTO_INCREMENT,
	lingua VARCHAR(20) NOT NULL
);

CREATE TABLE cliente(
	idCliente INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	email VARCHAR(100) UNIQUE NOT NULL,
	senha VARCHAR(50) NOT NULL
);

CREATE VIEW livrocompleto AS
SELECT * FROM livro
JOIN autor on
id_autor = idautor
JOIN editora on 
id_editora = ideditora
JOIN categoria on
id_categoria = idcategoria
JOIN idioma on 
id_idioma = ididioma;

