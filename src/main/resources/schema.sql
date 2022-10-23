DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS author;

CREATE TABLE  PUBLIC.books(
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       author_id INT NOT NULL,
                       title VARCHAR(250) NOT NULL,
                       PRICE_OLD  VARCHAR(250) DEFAULT NULL,
                       price VARCHAR(250) DEFAULT NULL
);

CREATE TABLE  PUBLIC.authors(
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        first_name VARCHAR(250) NOT NULL,
                        last_name VARCHAR(250) NOT NULL
);
