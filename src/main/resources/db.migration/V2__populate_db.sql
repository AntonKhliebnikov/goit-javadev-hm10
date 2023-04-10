-- Додати 10 клієнтів
INSERT INTO Client (name)
VALUES ('John Doe'), ('Jane Doe'), ('Bob Smith'), ('Alice Johnson'), ('Tom Wilson'), ('Sarah Brown'), ('Mike Davis'), ('Emily Lee'), ('David Kim'), ('Olivia Rodriguez');

-- Додати 5 планет
INSERT INTO Planet (id, name)
VALUES ('MARS', 'Mars'), ('VEN', 'Venus'), ('MER', 'Mercury'), ('SAT', 'Saturn'), ('JUP', 'Jupiter');

-- Додати 10 квитків
INSERT INTO Ticket (created_at, client_id, from_planet_id, to_planet_id)
VALUES
    (CURRENT_TIMESTAMP, 1, 'MARS', 'VEN'),
    (CURRENT_TIMESTAMP, 2, 'MER', 'JUP'),
    (CURRENT_TIMESTAMP, 3, 'SAT', 'MARS'),
    (CURRENT_TIMESTAMP, 4, 'JUP', 'VEN'),
    (CURRENT_TIMESTAMP, 5, 'VEN', 'SAT'),
    (CURRENT_TIMESTAMP, 6, 'MARS', 'JUP'),
    (CURRENT_TIMESTAMP, 7, 'MER', 'VEN'),
    (CURRENT_TIMESTAMP, 8, 'SAT', 'JUP'),
    (CURRENT_TIMESTAMP, 9, 'MARS', 'VEN'),
    (CURRENT_TIMESTAMP, 10, 'JUP', 'SAT');
