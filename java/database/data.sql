BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO inventory (book_isbn, book_title, book_author, book_genre)
VALUES ('9781400079278', 'Kafka by the Shore', 'Haruki Murakami', 'Fiction');

INSERT INTO inventory (book_isbn, book_title, book_author, book_genre)
VALUES ('9780356500157', 'The Girl With All the Gifts', 'M.R. Carey', 'Non-Fiction');

INSERT INTO reading_list (list_name)
VALUES('Dummy Starting List');


COMMIT TRANSACTION;

rollback;

SELECT * FROM inventory
SELECT * FROM users
SELECT * FROM reading_list
SELECT * FROM master_table

Select * from inventory WHERE book_isbn = '9781903773178';

SELECT * FROM master_table 
JOIN inventory ON inventory.book_id = master_table.book_id
JOIN users ON users.user_id = master_table.user_id
WHERE master_table.user_id = 3

SELECT inventory.book_id, inventory.book_isbn, inventory.book_title, inventory.book_author, 
	reading_list.list_id, reading_list.list_name,
	users.user_id, users.username
FROM master_table 
JOIN inventory ON inventory.book_id = master_table.book_id
JOIN users ON users.user_id = master_table.user_id
JOIN reading_list ON reading_list.list_id = master_table.list_id
WHERE users.user_id = 3 AND reading_list.list_name = 'Dummy Starting List'



SELECT * 
FROM master_table
WHERE book_id = 3 AND user_id = 3 AND list_id = 1;