INSERT INTO Genre (name) VALUES ('Comedy');
INSERT INTO Genre (name) VALUES ('Tragedy');
INSERT INTO Genre (name) VALUES ('Drama');
INSERT INTO Genre (name) VALUES ('Roman');
INSERT INTO Genre (name) VALUES ('Novell');
INSERT INTO Genre (name) VALUES ('Oda');
INSERT INTO Genre (name) VALUES ('Poem');

INSERT INTO Author (fullName) VALUES ('Pushkin');
INSERT INTO Author (fullName) VALUES ('Lermontov');
INSERT INTO Author (fullName) VALUES ('Tolstoy');
INSERT INTO Author (fullName) VALUES ('Dostoevsky');

INSERT INTO Book (name, authorId, genreId, pagecount, description) VALUES ('Book1', 1, 2, 145, 'flkgdflkn');
INSERT INTO Book (name, authorId, genreId, pagecount, description) VALUES ('Kniga2', 2, 2, 365, 'ssss');
INSERT INTO Book (name, authorId, genreId, pagecount, description) VALUES ('SomeBook', 3, 2, 353, 'rrrr');
INSERT INTO Book (name, authorId, genreId, pagecount, description) VALUES ('CheckOutFilter', 3, 1, 434, 'eeeee');
INSERT INTO Book (name, authorId, genreId, pagecount, description) VALUES ('CCC', 1, 3, 333, 'bbbbb');
INSERT INTO Book (name, authorId, genreId, pagecount, description) VALUES ('BbBB', 4, 4, 387, 'qqwwqwq');
INSERT INTO Book (name, authorId, genreId, pagecount, description) VALUES ('KKK', 1, 2, 347, 'flkgdflkn');
INSERT INTO Book (name, authorId, genreId, pagecount, description) VALUES ('OOO', 2, 2, 345, 'ssss');
INSERT INTO Book (name, authorId, genreId, pagecount, description) VALUES ('III', 3, 2, 345, 'rrrr');
INSERT INTO Book (name, authorId, genreId, pagecount, description) VALUES ('RRR', 3, 1, 324, 'eeeee');


INSERT INTO Passport (series, number, placeOfIssue, dateOfIssue, residence)
VALUES (5606, 894345, 'Penza', '2011-01-20', 'Penza');
INSERT INTO Passport (series, number, placeOfIssue, dateOfIssue, residence)
VALUES (5632, 543465, 'Moscow', '2012-04-21', 'Moscow');
INSERT INTO Passport (series, number, placeOfIssue, dateOfIssue, residence)
VALUES (5612, 562352, 'N.Novgorod', '2012-01-25', 'Saint Petersburg');

INSERT INTO User (fullName, passportId) VALUES ('Ivanov Ivan Ivanovich', 1);
INSERT INTO User (fullName, passportId) VALUES ('Sergeev Sergey Sergeevich', 3);
INSERT INTO User (fullName, passportId) VALUES ('Antonov Anton Antonovich', 2);