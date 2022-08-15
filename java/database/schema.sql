BEGIN TRANSACTION;

DROP TABLE IF EXISTS master_table;
DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS reading_list;



CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE inventory (
	book_id SERIAL,
	book_isbn varchar(40),
	--user_id int,
	book_title varchar(100),
	book_author varchar(100),
	book_genre varchar(100),
	CONSTRAINT pk_inventory PRIMARY KEY (book_id)
);


CREATE TABLE reading_list (
	list_id SERIAL,
	list_name varchar(100),
	CONSTRAINT pk_reading_list PRIMARY KEY (list_id)
);

CREATE TABLE master_table (
	book_id int,
	list_id int,
	user_id int,
	
	CONSTRAINT pk_master_table PRIMARY KEY (book_id, list_id, user_id),
	CONSTRAINT fk_master_table_inventory FOREIGN KEY (book_id) REFERENCES inventory(book_id),
	CONSTRAINT fk_master_table_users FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT fk_master_table_reading_list FOREIGN KEY (list_id) REFERENCES reading_list(list_id)
);

COMMIT TRANSACTION;

ROLLBACK;


SELECT * FROM inventory;
SELECT * FROM users;



