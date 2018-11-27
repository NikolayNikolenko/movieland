CREATE SCHEMA IF NOT EXISTS MOVIE_LAND;

SET SCHEMA MOVIE_LAND;

DROP TABLE IF EXISTS  movie
;

DROP TABLE IF EXISTS  movie_poster
;

CREATE TABLE IF NOT EXISTS movie
(
	movie_id  INTEGER IDENTITY PRIMARY KEY,
	movie_name_russian VARCHAR(400),
	movie_name_native VARCHAR(400),
	year_of_release NUMBER(4),
	movie_rate double precision default 0,
	price double precision default 0
)
;

CREATE TABLE IF NOT EXISTS  movie_poster
( movie_id INTEGER,
  poster_url VARCHAR(4000)
)
;

CREATE TABLE IF NOT EXISTS genre
(
	genre_id  INTEGER IDENTITY PRIMARY KEY,
	genre_name VARCHAR(400)
)
;

CREATE TABLE IF NOT EXISTS movie_genre
(
	movie_id INTEGER,
	genre_id INTEGER
)
;
