CREATE TABLE käyttäjä(
käyttäjätunnus CHAR(20) PRIMARY KEY NOT NULL,
salasana CHAR(20) NOT NULL,
etunimi CHAR(20),
sukunimi CHAR(20),
sähköposti CHAR(50),
käyttäjä_luotu TIMESTAMP,
postinumero INTEGER REFERENCES postinumero(postinumero) ON DELETE cascade
ON UPDATE CASCADE
);



CREATE TABLE postinumero(
postinumero INTEGER PRIMARY KEY NOT NULL,
alueen_nimi CHAR(50)
);



CREATE TABLE lemmikki(
lemmikkiID SERIAL PRIMARY KEY,
nimi CHAR(20),
väri CHAR(20),
ikä INTEGER,
kuvaus CHAR(500),
kuva BYTEA,
käyttäjätunnus CHAR(20) NOT NULL REFERENCES käyttäjä(käyttäjätunnus) ON DELETE cascade
ON UPDATE cascade,
rotuID INTEGER REFERENCES rotu(rotuID) ON DELETE cascade
ON UPDATE cascade
);


CREATE TABLE rotu(
rotuID INTEGER PRIMARY KEY,
nimi CHAR(20),
kuvaus CHAR(500)
);


CREATE TABLE kuuluu_ryhmään(
lemmikkiID INTEGER NOT NULL REFERENCES lemmikki(lemmikkiID) ON DELETE cascade
ON UPDATE cascade,
ryhmänimi CHAR(100) NOT NULL REFERENCES ryhmä(ryhmänimi) ON DELETE cascade
ON UPDATE cascade,
PRIMARY KEY(lemmikkiID, ryhmänimi)
);


CREATE TABLE ryhmä(
ryhmänimi CHAR(100) PRIMARY KEY NOT NULL,
kuvaus CHAR(500),
kuva BYTEA
);