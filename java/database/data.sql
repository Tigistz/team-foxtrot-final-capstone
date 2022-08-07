BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO inventory (book_isbn, book_title, book_author, book_genre)
VALUES ('9781400079278', 'Kafka by the Shore', 'Haruki Murakami', 'Fiction');

INSERT INTO inventory (book_isbn, book_title, book_author, book_genre)
VALUES ('9780356500157', 'The Girl With All the Gifts', 'M.R. Carey', 'Non-Fiction');

COMMIT TRANSACTION;

rollback;

SELECT * FROM inventory