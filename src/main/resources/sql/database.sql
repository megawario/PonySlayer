SET FOREIGN_KEY_CHECKS=0; -- to disable them
CREATE OR REPLACE DATABASE lisrpg CHARACTER SET = 'utf8';
SET FOREIGN_KEY_CHECKS=1; -- to re-enable them

USE lisrpg;

CREATE TABLE USER (
   id INT NOT NULL auto_increment,
   display_name VARCHAR(20) NOT NULL,
   login_name  VARCHAR(20) NOT NULL,
   password    VARCHAR(20) NOT NULL,
   admin	BOOLEAN DEFAULT false,
   PRIMARY KEY (id)
);

CREATE TABLE EVENT (
   id INT NOT NULL auto_increment,
   event_date	TIMESTAMP NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE ADVENTURE (
	id	INT	NOT NULL auto_increment,
	event_id INT,
--	time_start	TIMESTAMP,
--	time_end	TIMESTAMP,
	dmName	VARCHAR(20) NOT NULL,
	system	VARCHAR(100) NOT NULL,
	title		VARCHAR(100) NOT NULL,
	subtitle		VARCHAR(100),
	synopsis		VARCHAR(10000),
	image		VARCHAR(2000),
	slot_min		INTEGER NOT NULL,
	slot_max		INTEGER NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (event_id) REFERENCES EVENT(id)
);

CREATE TABLE HAS_USER(
	adventure_id INT NOT NULL,
	user_id INT NOT NULL,
	FOREIGN KEY (adventure_id) REFERENCES ADVENTURE(id),
	FOREIGN KEY (user_id) REFERENCES USER(id)
);