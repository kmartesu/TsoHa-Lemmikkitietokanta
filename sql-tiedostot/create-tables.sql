CREATE TABLE k�ytt�j�(
k�ytt�j�tunnus CHAR(20) PRIMARY KEY NOT NULL,
salasana CHAR(20) NOT NULL,
etunimi CHAR(20),
sukunimi CHAR(20),
s�hk�posti CHAR(50),
k�ytt�j�_luotu TIMESTAMP,
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
v�ri CHAR(20),
ik� INTEGER,
kuvaus CHAR(500),
kuva BYTEA,
k�ytt�j�tunnus CHAR(20) NOT NULL REFERENCES k�ytt�j�(k�ytt�j�tunnus) ON DELETE cascade
ON UPDATE cascade,
rotuID INTEGER REFERENCES rotu(rotuID) ON DELETE cascade
ON UPDATE cascade
);


CREATE TABLE rotu(
rotuID INTEGER PRIMARY KEY,
nimi CHAR(20),
kuvaus CHAR(500)
);


CREATE TABLE kuuluu_ryhm��n(
lemmikkiID INTEGER NOT NULL REFERENCES lemmikki(lemmikkiID) ON DELETE cascade
ON UPDATE cascade,
ryhm�nimi CHAR(100) NOT NULL REFERENCES ryhm�(ryhm�nimi) ON DELETE cascade
ON UPDATE cascade,
PRIMARY KEY(lemmikkiID, ryhm�nimi)
);


CREATE TABLE ryhm�(
ryhm�nimi CHAR(100) PRIMARY KEY NOT NULL,
kuvaus CHAR(500),
kuva BYTEA
);