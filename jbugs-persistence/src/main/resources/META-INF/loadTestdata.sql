-- User test data
INSERT INTO USER (FIRSTNAME, LASTNAME, Status, password, username) VALUES ('John', 'Doe', true,'pass','john.doe');
INSERT INTO USER (FIRSTNAME, LASTNAME, password, username) VALUES ('Max', 'Mustermann', 'pass','max.muster');
INSERT INTO USER (FIRSTNAME, LASTNAME) VALUES ('Mary', 'Jane');

-- other tables TODO

INSERT INTO PERMISSION (DESCRIPTION, PERMISSIONNAME) VALUES ('some descript text', 'PERMISSION_MANAGEMENT');
INSERT INTO PERMISSION (DESCRIPTION, PERMISSIONNAME) VALUES ('some other text', 'USER_MANAGEMENT');
INSERT INTO PERMISSION (DESCRIPTION, PERMISSIONNAME) VALUES ('some other text2222', 'BUG_MANAGEMENT');


INSERT INTO ROLE (ROLENAME) VALUES ('ADM');
INSERT INTO ROLE (ROLENAME) VALUES ('PM');
INSERT INTO ROLE (ROLENAME) VALUES ('TM');
INSERT INTO ROLE (ROLENAME) VALUES ('DEV');
INSERT INTO ROLE (ROLENAME) VALUES ('TEST');

INSERT INTO ROLE_PERMISSION (ID_ROLE, ID_PERMISSION) VALUES (1, 1);
INSERT INTO ROLE_PERMISSION (ID_ROLE, ID_PERMISSION) VALUES (1, 2);
INSERT INTO ROLE_PERMISSION (ID_ROLE, ID_PERMISSION) VALUES (2, 3);
INSERT INTO ROLE_PERMISSION (ID_ROLE, ID_PERMISSION) VALUES (2, 2);
=======

-- Bug test data
INSERT INTO BUG (description, title, severity, status, targetDate, versionFound, versionFixed, assignedTo, createdBy) VALUES ('Bug nasol', 'Tre rezolvat', 'CRITICAL', 'NEW', '2017-12-12', 1.0, 0.0, 1, 2);
INSERT INTO BUG (description, title, severity, status, targetDate, versionFound, versionFixed, assignedTo, createdBy) VALUES ('Bug usor', 'Bug usor', 'MEDIUM', 'IN_PROGRESS', '2017-08-08', 1.3, 0.0, 2, 1);
INSERT INTO BUG (description, title, severity, status, targetDate, versionFound, versionFixed, assignedTo, createdBy) VALUES ('Bug nr. 3', 'Rezolva', 'HIGH', 'FIXED', "2017-09-09", 2.3, 0.0, 2, 1);
INSERT INTO BUG (description, title, severity, status, targetDate, versionFound, versionFixed, assignedTo, createdBy) VALUES ('Bug nr. 4', 'Hei', 'LOW', 'CLOSED', '2017-06-08', 5.5, 5.5, 3, 3);
INSERT INTO BUG (description, title, severity, status, targetDate, versionFound, versionFixed, assignedTo, createdBy) VALUES ('Bug nr. 5', 'Hello', 'HIGH', 'REJECTED', '2017-12-12', 2.3, 0.0, 2, 3);

-- other tables TODO
