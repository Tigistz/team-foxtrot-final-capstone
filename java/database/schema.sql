BEGIN TRANSACTION;

DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS users;


CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

--CREATE SEQUENCE book_serial;
CREATE TABLE inventory (
	book_id SERIAL,
	book_isbn varchar(40),
	user_id int, --NOT NULL,
	book_title varchar(100),
	book_author varchar(100),
	book_genre varchar(100),
	CONSTRAINT pk_inventory PRIMARY KEY (book_id)
	--CONSTRAINT fk_inventory FOREIGN KEY (user_id) references users(user_id)
);

COMMIT TRANSACTION;

ROLLBACK;

SELECT * FROM inventory

