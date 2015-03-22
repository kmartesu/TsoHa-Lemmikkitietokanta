INSERT INTO postinumero VALUES
(00980, 'Etelä-Vuosaari - Helsinki');

INSERT INTO rotu VALUES
(1, 'Griffon bruxellois', 'Griffon bruxellois eli brysselingriffoni on Belgiasta kotoisin oleva koirarotu.');

INSERT INTO ryhmä (ryhmänimi, kuvaus) VALUES
('Etelä-Vuosaaren koirat', 'Ryhmä Etelä-Vuosaaressa asuville koirille');

INSERT INTO käyttäjä VALUES
('testikäyttäjä', 'testisalasana', 'testi', 'testaaja', 'testi@testaaja.fi', CURRENT_TIMESTAMP, 00980);

INSERT INTO lemmikki (nimi, väri, ikä, kuvaus, käyttäjätunnus, rotuID) VALUES
('Napero', 'Ruskea', 5, 'Napero on iloinen pieni koira', 'testikäyttäjä', 1);

INSERT INTO kuuluu_ryhmään (lemmikkiID, ryhmänimi)
SELECT lemmikki.lemmikkiID, 'Etelä-Vuosaaren koirat' 
FROM lemmikki 
WHERE lemmikki.nimi = 'Napero';
