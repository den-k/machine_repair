CREATE TABLE "users" (
"id" serial4 NOT NULL,
"login" varchar(32) NOT NULL,
"password" text NOT NULL,
"enabled" bool NOT NULL,
PRIMARY KEY ("id") ,
CONSTRAINT "uq_users_login" UNIQUE ("login")
);

CREATE TABLE "clients" (
"id" serial4 NOT NULL,
"name" varchar(32) NOT NULL,
"user_id" int NOT NULL,
PRIMARY KEY ("id") ,
CONSTRAINT "uq_clients_users_user_id" UNIQUE ("user_id")
);

CREATE TABLE "users_roles" (
"user_id" int NOT NULL,
"role_id" int NOT NULL
);

CREATE TABLE "session_management" (
"session_timeout" int NOT NULL DEFAULT 300
);

CREATE TABLE "roles" (
"id" serial4 NOT NULL,
"name" text NOT NULL,
PRIMARY KEY ("id") ,
CONSTRAINT "uq_roles_name" UNIQUE ("name")
);


ALTER TABLE "clients" ADD CONSTRAINT "fq_clients_users_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("id");
ALTER TABLE "users_roles" ADD CONSTRAINT "fq_roles_users_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("id");
ALTER TABLE "users_roles" ADD CONSTRAINT "fq_roles_users_role_id" FOREIGN KEY ("role_id") REFERENCES "roles" ("id");
INSERT INTO "users" ("id", "login", "password", "enabled") VALUES (1, 'admin', 'admin', 't');INSERT INTO "users" ("id", "login", "password", "enabled") VALUES (2, 'manager', 'manager', 't');INSERT INTO "users" ("id", "login", "password", "enabled") VALUES (3, 'client', 'client', 't');INSERT INTO "roles" ("id", "name") VALUES (1, 'ROLE_ADMIN');INSERT INTO "roles" ("id", "name") VALUES (2, 'ROLE_MANAGER');INSERT INTO "roles" ("id", "name") VALUES (3, 'ROLE_CLIENT');INSERT INTO "users_roles" ("user_id", "role_id") VALUES (1, 1);INSERT INTO "users_roles" ("user_id", "role_id") VALUES (1, 2);INSERT INTO "users_roles" ("user_id", "role_id") VALUES (2, 2);INSERT INTO "users_roles" ("user_id", "role_id") VALUES (3, 3);INSERT INTO "clients" ("id", "name", "user_id") VALUES (1, 'Client', 3);INSERT INTO "session_management" ("session_timeout") VALUES (300);
