DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS author;

CREATE TABLE  PUBLIC.books(
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       authorId INT NOT NULL,
                       title VARCHAR(250) NOT NULL,
                       priceOld  VARCHAR(250) DEFAULT NULL,
                       price VARCHAR(250) DEFAULT NULL
);

CREATE TABLE  PUBLIC.authors(
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(250) NOT NULL
);
