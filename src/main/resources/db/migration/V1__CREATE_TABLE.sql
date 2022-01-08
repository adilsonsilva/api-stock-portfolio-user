-- -----------------------------------------------------
-- Schema user
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS "m-stock-user";

-- -----------------------------------------------------
-- Table "m-stock-user"."user"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "m-stock-user"."user" (
  "id_user" INT NOT NULL,
  "user_full_name" VARCHAR(200) NOT NULL,
  "user_surname" VARCHAR(40) NOT NULL,
  "register_date" TIMESTAMP NOT NULL,
  "status" BOOLEAN DEFAULT FALSE,
  "email" VARCHAR(100) NOT NULL,
  "password" VARCHAR(30) NOT NULL,
  "cpf" VARCHAR(11) NOT NULL);
    
 ALTER TABLE "m-stock-user"."user"
	ADD CONSTRAINT "pkUser" PRIMARY KEY ("id_user");

CREATE UNIQUE INDEX "email_UNIQUE" 
ON "m-stock-user"."user" ("email" ASC);
-- -----------------------------------------------------
-- Table "user"."permission"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "m-stock-user"."permission" (
  "id_permission" INT NOT NULL,
  "permission_type" INT NOT NULL,
  "permission_description" VARCHAR(50) NOT NULL);
  
ALTER TABLE "m-stock-user"."permission"
	ADD CONSTRAINT "pkPermission" PRIMARY KEY ("id_permission");
-- -----------------------------------------------------
-- Table "m-stock-user"."permission_user"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "m-stock-user"."permission_user" (
  "id_permission" INT NOT NULL,
  "id_user" INT NOT NULL);

CREATE INDEX "idx_user_email" ON "m-stock-user"."user"("email");
CREATE INDEX "idx_user_status" ON "m-stock-user"."user"("id_user", "status"); 
CREATE INDEX "idx_user_credencial" ON "m-stock-user"."user"("email", "password"); 
  
CREATE INDEX "fk_permission_has_user_user1_idx" ON "m-stock-user"."permission_user"
( 
	"id_user" ASC
);

CREATE INDEX "fk_permission_has_user_permission_idx" ON "m-stock-user"."permission_user"
( 
	"id_permission" ASC
);


ALTER TABLE "m-stock-user"."permission_user"
	ADD CONSTRAINT "fk_permission_has_user_permission" FOREIGN KEY ("id_permission") REFERENCES "m-stock-user"."permission" ("id_permission");
	
ALTER TABLE "m-stock-user"."permission_user"
	ADD CONSTRAINT "fk_permission_has_user_user1" FOREIGN KEY ("id_user") REFERENCES "m-stock-user"."user" ("id_user");	

CREATE SEQUENCE "m-stock-user"."user_id_seq"
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER TABLE "m-stock-user"."user" ALTER COLUMN "id_user" SET DEFAULT nextval('"m-stock-user"."user_id_seq"'::regclass);

CREATE SEQUENCE "m-stock-user"."permission_id_seq"
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER TABLE "m-stock-user"."permission" ALTER COLUMN "id_permission" SET DEFAULT nextval('"m-stock-user"."permission_id_seq"'::regclass);

