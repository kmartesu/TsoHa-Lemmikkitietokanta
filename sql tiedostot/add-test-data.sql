INSERT INTO k‰ytt‰j‰ VALUES
('testik‰ytt‰j‰', 'testisalasana', 'testi', 'testaaja', 'testi@testaaja.fi', CURRENT_TIMESTAMP, 00980);

INSERT INTO postinumero VALUES
(00980, 'Etel‰-Vuosaari - Helsinki');

INSERT INTO lemmikki (nimi, v‰ri, ik‰, kuvaus, k‰ytt‰j‰tunnus, rotuID) VALUES
('Napero', 'Ruskea', 5, 'Napero on iloinen pieni koira', 'testik‰ytt‰j‰', 1);


INSERT INTO rotu VALUES
(1, 'Griffon bruxellois', 'Griffon bruxellois eli brysselingriffoni on Belgiasta kotoisin oleva koirarotu.');

INSERT INTO ryhm‰ (ryhm‰nimi, kuvaus) VALUES
('Etel‰-Vuosaaren koirat', 'Ryhm‰ Etel‰-Vuosaaressa asuville koirille');

INSERT INTO kuuluu_ryhm‰‰n (lemmikkiID, ryhm‰nimi)
SELECT lemmikki.lemmikkiID, 'Etel‰-Vuosaaren koirat' 
FROM lemmikki 
WHERE lemmikki.nimi = 'Napero';
