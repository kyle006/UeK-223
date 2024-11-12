-- Insert test data into the Category table
INSERT INTO Category (id, title) VALUES 
(1, 'Category 1'),
(2, 'Category 2'),
(3, 'Category 3');

-- Insert test data into the Tag table
INSERT INTO Tag (id, title) VALUES 
(1, 'Tag 1'),
(2, 'Tag 2'),
(3, 'Tag 3');

-- Insert test data into the Entry table with description field
INSERT INTO Entry (id, checkIn, checkOut, category_id, description) VALUES 
(1, '2023-01-01T08:00:00', '2023-01-01T17:00:00', 1, 'Erster Testeintrag mit Beschreibung'),
(2, '2023-01-02T08:00:00', '2023-01-02T17:00:00', 2, 'Zweiter Testeintrag für Kategorie 2'),
(3, '2023-01-03T08:00:00', '2023-01-03T17:00:00', 1, 'Dritter Eintrag, nochmal Kategorie 1');

-- Insert test data into the join table for Entry and Tag
INSERT INTO entry_tags (entry_id, tag_id) VALUES 
(1, 1),
(1, 2),
(2, 2),
(2, 3),
(3, 1),
(3, 3);
