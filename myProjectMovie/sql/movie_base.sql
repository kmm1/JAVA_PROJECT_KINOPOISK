CREATE DATABASE movie_base;
USE movie_base;

DROP TABLE users;
DROP TABLE reviews;
DROP TABLE movies_actors;
DROP TABLE movies_producers;
DROP TABLE movies;
DROP TABLE actors;
DROP TABLE producers;


CREATE TABLE users (id INT AUTO_INCREMENT, name VARCHAR(255), lastname VARCHAR(255),
                        email VARCHAR (255), password VARCHAR (255),
                        role VARCHAR(255) NOT NULL DEFAULT 'user',
                        registration_date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        PRIMARY KEY (id));

CREATE TABLE movies (id INT AUTO_INCREMENT, name VARCHAR(255),
                        year INT, country VARCHAR (255),
                        genre VARCHAR (255),
					            	PRIMARY KEY (id));

CREATE TABLE actors (id INT AUTO_INCREMENT, name VARCHAR (255), lastname VARCHAR (255),
                        year_of_birth INT,
					              PRIMARY KEY(id));

CREATE TABLE producers (id INT AUTO_INCREMENT, name VARCHAR (255), lastname VARCHAR (255),
                        year_of_birth INT,
						            PRIMARY KEY(id));

CREATE TABLE reviews (id INT AUTO_INCREMENT, text TEXT NOT NULL, movies_id INT NOT NULL, users_id INT,
						            PRIMARY KEY(id),
					              FOREIGN KEY (movies_id) REFERENCES movies(id),
                        FOREIGN KEY (users_id) REFERENCES users(id));

CREATE TABLE movies_actors (movies_id INT, actors_id INT,
                        PRIMARY KEY (movies_id, actors_id),
					              FOREIGN KEY (actors_id) REFERENCES actors(id),
 					              FOREIGN KEY (movies_id) REFERENCES movies(id));

CREATE TABLE movies_producers (movies_id INT, producers_id INT,
                       PRIMARY KEY (movies_id, producers_id),
                       FOREIGN KEY (producers_id) REFERENCES producers(id),
                       FOREIGN KEY (movies_id) REFERENCES movies(id));

SELECT * FROM users;
SELECT * FROM movies;
SELECT * FROM actors;
SELECT * FROM reviews;
SELECT * FROM movies_actors;
SELECT * FROM movies_producers;

INSERT into users ( name, lastname, email, password, role) VALUES('Kate', 'M', 'km.kathrin@gmail.com','rose','admin');
INSERT into users ( name, lastname, email, password) VALUES('Mike', 'P', 'mike@gmail.com','rose');


INSERT into movies (name, year, country, genre) VALUES(
'От заката до рассвета', 1995, 'USA','fantacy');

INSERT into actors (name, lastname, year_of_birth) VALUES ('Джордж', ' Клуни', 1961);
INSERT into producers (name, lastname, year_of_birth) VALUES ('Джанни', 'Нуннари', 1959);
INSERT into movies_actors (movies_id, actors_id) VALUES (1, 1);
INSERT into movies_producers (movies_id, producers_id) VALUES (1, 1);
INSERT into reviews (text, movies_id, users_id) VALUES ('супер', 1, 1);