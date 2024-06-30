CREATE SCHEMA "dbo" AUTHORIZATION "SYSDBA";

create table "dbo"."Test_Tab"
(
    "id" INTEGER identity(1, 1) not null  unique ,
    "content" CHAR(1024),
    "ctime" CHAR(16),
    "utime" CHAR(16),
    primary key("id")
)
    storage(initial 1, next 1, minextents 1, fillfactor 0)
;