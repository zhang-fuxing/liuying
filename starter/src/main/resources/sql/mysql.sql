use mysql;
create database testdb;
create table Test_Tab
(
    id      int auto_increment,
    content varchar(1024) null,
    ctime   varchar(16)   null,
    utime   varchar(16)   null,
    constraint Test_Tab_pk
        primary key (id)
);

select *
from testdb.Test_Tab;