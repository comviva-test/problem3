/* Single line comment */
CREATE TABLE IF NOT EXISTS comviva (
 FILENAME VARCHAR(256) NOT NULL,
 FILEVALUE FLOAT,
 PROCESSDATE DATETIME,
 PRIMARY KEY(FILENAME, PROCESSDATE)
);