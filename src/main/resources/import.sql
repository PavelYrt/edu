INSERT INTO Genre (name) VALUES ('Comedy');
INSERT INTO Genre (name) VALUES ('Tragedy');
INSERT INTO Genre (name) VALUES ('Drama');
INSERT INTO Genre (name) VALUES ('Roman');

INSERT INTO Author (authorFullName) VALUES ('Pushkin');
INSERT INTO Author (authorFullName) VALUES ('Lermontov');
INSERT INTO Author (authorFullName) VALUES ('Tolstoy');
INSERT INTO Author (authorFullName) VALUES ('Dostoevsky');

INSERT INTO Book (name, author, genre, pagecount, description) VALUES ('Book1', 1, 2, 145, 'flkgdflkn');
INSERT INTO Book (name, author, genre, pagecount, description) VALUES ('Kniga2', 2, 2, 365, 'ssss');
INSERT INTO Book (name, author, genre, pagecount, description) VALUES ('SomeBook', 3, 2, 353, 'rrrr');
INSERT INTO Book (name, author, genre, pagecount, description) VALUES ('CheckOutFilter', 3, 1, 434, 'eeeee');
INSERT INTO Book (name, author, genre, pagecount, description) VALUES ('CCC', 1, 3, 333, 'bbbbb');
INSERT INTO Book (name, author, genre, pagecount, description) VALUES ('BbBB', 4, 4, 387, 'qqwwqwq');
INSERT INTO Book (name, author, genre, pagecount, description) VALUES ('KKK', 1, 2, 347, 'flkgdflkn');
INSERT INTO Book (name, author, genre, pagecount, description) VALUES ('OOO', 2, 2, 345, 'ssss');
INSERT INTO Book (name, author, genre, pagecount, description) VALUES ('III', 3, 2, 345, 'rrrr');
INSERT INTO Book (name, author, genre, pagecount, description) VALUES ('RRR', 3, 1, 324, 'eeeee');

-- INSERT INTO BookCard (internal_number, bookId) VALUES (222, 1);
-- INSERT INTO BookCard (internal_number, bookId) VALUES (223, 2);
-- INSERT INTO BookCard (internal_number, bookId) VALUES (224, 3);
-- INSERT INTO BookCard (internal_number, bookId) VALUES (225, 5);
-- INSERT INTO BookCard (internal_number, bookId) VALUES (226, 4);
-- INSERT INTO BookCard (internal_number, bookId) VALUES (227, 7);
-- INSERT INTO BookCard (internal_number, bookId) VALUES (228, 6);
-- INSERT INTO BookCard (internal_number, bookId) VALUES (229, 8);
-- INSERT INTO BookCard (internal_number, bookId) VALUES (212, 9);
-- INSERT INTO BookCard (internal_number, bookId) VALUES (213, 10);

INSERT INTO Passport (series, number, dateOfBirth, placeOfIssue, dateOfIssue, residence)
VALUES (5606, 894345, '1991-12-24', 'Penza', '2011-01-20', 'Penza');
INSERT INTO Passport (series, number, dateOfBirth, placeOfIssue, dateOfIssue, residence)
VALUES (5632, 543465, '1988-06-14', 'Moscow', '2012-04-21', 'Moscow');
INSERT INTO Passport (series, number, dateOfBirth, placeOfIssue, dateOfIssue, residence)
VALUES (5612, 562352, '1971-10-01', 'N.Novgorod', '2012-01-25', 'Saint Petersburg');

INSERT INTO User (userFullName, passport) VALUES ('Ivanov Ivan Ivanovich', 1);
INSERT INTO User (userFullName, passport) VALUES ('Sergeev Sergey Sergeevich', 3);
INSERT INTO User (userFullName, passport) VALUES ('Antonov Anton Antonovich', 2);