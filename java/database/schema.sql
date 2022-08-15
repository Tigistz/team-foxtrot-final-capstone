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
	user_id int,
	book_title varchar(100),
	book_author varchar(100),
	book_genre varchar(100),
	CONSTRAINT pk_inventory PRIMARY KEY (book_id),
	CONSTRAINT fk_inventory FOREIGN KEY (user_id) references users(user_id)
);

COMMIT TRANSACTION;

ROLLBACK;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
select * from inventory
=======
SELECT * FROM inventory;

>>>>>>> 7032df6b2497611196244fb455c2821c5a6e2f14
=======
SELECT * FROM inventory
>>>>>>> be736c66ec3bd2720bbf47d8f06f62a51b4015fe
=======

SELECT * FROM inventory;


>>>>>>> 68b626291d98692e3851fc4b91ce4832385ea047

>>>>>>> be736c66ec3bd2720bbf47d8f06f62a51b4015fe
