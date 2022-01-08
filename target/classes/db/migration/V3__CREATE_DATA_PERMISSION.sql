INSERT INTO "m-stock-user"."permission"
(permission_type, permission_description)
VALUES(1, 'ADMIN');

INSERT INTO "m-stock-user"."permission"
(permission_type, permission_description)
VALUES(1, 'COMUM');


INSERT INTO "m-stock-user".permission_user
(id_permission, id_user)
VALUES(1, 1);

INSERT INTO "m-stock-user".permission_user
(id_permission, id_user)
VALUES(2, 1);

INSERT INTO "m-stock-user".permission_user
(id_permission, id_user)
VALUES(1, 2);

INSERT INTO "m-stock-user".permission_user
(id_permission, id_user)
VALUES(1, 3);

INSERT INTO "m-stock-user".permission_user
(id_permission, id_user)
VALUES(1, 4);

INSERT INTO "m-stock-user".permission_user
(id_permission, id_user)
VALUES(1, 5);