BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `Books` (
	`ISBN`	INTEGER,
	`author`	INTEGER NOT NULL,
	`title`	TEXT NOT NULL,
	`publisher`	TEXT NOT NULL,
	`publication_year`	INTEGER NOT NULL,
	`price`	REAL NOT NULL,
	`type`	INTEGER NOT NULL,
	FOREIGN KEY(`author`) REFERENCES `Authors`(`author_id`),
	FOREIGN KEY(`publisher`) REFERENCES `Publishers`(`publisher_id`),
	PRIMARY KEY(`ISBN`),
	FOREIGN KEY(`type`) REFERENCES `TypeBook`(`type_id`)
);
INSERT INTO `Books` VALUES (9780099540656,4,'The Tin Drum','5k4',2017,56.0,1);
INSERT INTO `Books` VALUES (9780099594024,6,'Hag Seed','5k4',2017,45.0,1);
INSERT INTO `Books` VALUES (9780701172879,7,'Nigella Bites','cub',2001,13.99,1);
INSERT INTO `Books` VALUES (9780701184605,7,'Chatto & Windus','cub',2010,87.8,1);
INSERT INTO `Books` VALUES (9780701189358,7,'Simply Nigella: Feel Good Food','cub',2015,69.9,1);
INSERT INTO `Books` VALUES (9781784700805,5,'Tulip Fever','5k4',2017,34.0,2);
INSERT INTO `Books` VALUES (9781784703684,4,'Of All That Ends','5k4',2017,45.0,2);
INSERT INTO `Books` VALUES (9781784741631,7,'At My Table','5k4',2017,115.5,2);
INSERT INTO `Books` VALUES (9781784871444,6,'The Handmaids Tale','5k4',2016,44.1,2);
INSERT INTO `Books` VALUES (9781784871581,8,'The Adventures of Tom Sawyer','5k4',2016,11.6,2);
INSERT INTO `Books` VALUES (9781784871727,3,'Pride and Prejudice','5k4',2016,11.6,2);
INSERT INTO `Books` VALUES (9781784871741,3,'Sense and Sensibility','5k4',2016,11.6,2);
INSERT INTO `Books` VALUES (9781785150162,2,'The Ten Types of Human','2ak',2017,62.0,2);
INSERT INTO `Books` VALUES (9781785151521,1,'Uncommon Type','2ak',2017,51.5,1);
INSERT INTO `Books` VALUES (9781840221831,8,'Tom Sawyer Abroad & Detective','2g8',2009,11.6,1);
INSERT INTO `Books` VALUES (9781840226362,8,'The Innocents Abroad','2g8',2010,11.6,2);
INSERT INTO `Books` VALUES (9781840226836,8,'Life on the Mississippi','2g8',2012,11.6,1);
INSERT INTO `Books` VALUES (9781853260117,8,'Tom Sawyer & Huckleberry Finn','2g8',2001,13.0,2);
INSERT INTO `Books` VALUES (9788375617634,3,'Pride and Prejudice','112',2017,29.9,1);
INSERT INTO `Books` VALUES (9788380976535,3,'Lady Susan','83f',2016,24.9,2);
CREATE TABLE IF NOT EXISTS `Publishers` (
	`publisher_id`	TEXT,
	`name`	TEXT NOT NULL,
	`city`	TEXT NOT NULL,
	`country`	TEXT NOT NULL,
	PRIMARY KEY(`publisher_id`)
);
INSERT INTO `Publishers` VALUES ('2ak','William Heinemann','London','UK');
INSERT INTO `Publishers` VALUES ('112','Poltex','Warsaw','Poland');
INSERT INTO `Publishers` VALUES ('83f','StoryBox','Piaseczno','Poland');
INSERT INTO `Publishers` VALUES ('5k4','Vintage','London','UK');
INSERT INTO `Publishers` VALUES ('cub','Chatto & Windus','London','UK');
INSERT INTO `Publishers` VALUES ('2g8','Wordsworth','Ware','UK');
CREATE TABLE IF NOT EXISTS `Authors` (
	`author_id`	INTEGER,
	`name`	TEXT NOT NULL,
	`surname`	TEXT NOT NULL,
	`birth_year`	INTEGER NOT NULL,
	`city`	TEXT NOT NULL,
	`country`	TEXT NOT NULL,
	PRIMARY KEY(`author_id`)
);
INSERT INTO `Authors` VALUES (1,'Tom','Hanks',1956,'Concord','USA');
INSERT INTO `Authors` VALUES (2,'Dexter','Dias',1967,'London','UK');
INSERT INTO `Authors` VALUES (3,'Jane','Austen',1775,'Steventon','UK');
INSERT INTO `Authors` VALUES (4,'Gunter','Grass',1927,'Gdansk','Poland');
INSERT INTO `Authors` VALUES (5,'Deborah','Moggah',1948,'England','UK');
INSERT INTO `Authors` VALUES (6,'Atwood','Margaret',1939,'Ottawa','Canada');
INSERT INTO `Authors` VALUES (7,'Lawson','Nigella',1960,'Wandsworth','UK');
INSERT INTO `Authors` VALUES (8,'Mark','Twain',1835,'Florida','USA');
CREATE TABLE IF NOT EXISTS `TypeBook` (
	`type_id`	INTEGER,
	`type`	TEXT NOT NULL,
	PRIMARY KEY(`type_id`)
);
INSERT INTO `TypeBook` VALUES (1,'Ebook');
INSERT INTO `TypeBook` VALUES (2,'Printed Book');
COMMIT;
