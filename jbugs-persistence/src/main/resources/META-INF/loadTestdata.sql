-- User test data
INSERT INTO USER (FIRSTNAME, LASTNAME, Status, password, username,email) VALUES ('John', 'Doe', true,'pass','john.doe','john.doe@msggroup.com');
INSERT INTO USER (FIRSTNAME, LASTNAME, password, username,email) VALUES ('Max', 'Mustermann', 'pass','max.muster','max.muster@msggroup.com');
INSERT INTO USER (FIRSTNAME, LASTNAME,email) VALUES ('Mary', 'Jane','mary.jones@msggroup.com');


-- Bug test data
INSERT INTO BUG (description, title, severity, status, targetDate, versionFound, versionFixed, assignedTo, createdBy) VALUES ('Bug nasol', 'Tre rezolvat', 'CRITICAL', 'NEW', '2017-12-12', 1.0, 0.0, 1, 2);
INSERT INTO BUG (description, title, severity, status, targetDate, versionFound, versionFixed, assignedTo, createdBy) VALUES ('Bug usor', 'Bug usor', 'MEDIUM', 'IN_PROGRESS', '2017-08-08', 1.3, 0.0, 2, 1);
INSERT INTO BUG (description, title, severity, status, targetDate, versionFound, versionFixed, assignedTo, createdBy) VALUES ('Bug nr. 3', 'Rezolva', 'HIGH', 'FIXED', "2017-09-09", 2.3, 0.0, 2, 1);
INSERT INTO BUG (description, title, severity, status, targetDate, versionFound, versionFixed, assignedTo, createdBy) VALUES ('Bug nr. 4', 'Hei', 'LOW', 'CLOSED', '2017-06-08', 5.5, 5.5, 3, 3);
INSERT INTO BUG (description, title, severity, status, targetDate, versionFound, versionFixed, assignedTo, createdBy) VALUES ('Bug nr. 5', 'Hello', 'HIGH', 'REJECTED', '2017-12-12', 2.3, 0.0, 2, 3);

-- other tables TODO
