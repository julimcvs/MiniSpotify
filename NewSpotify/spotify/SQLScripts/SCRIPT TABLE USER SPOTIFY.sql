CREATE TABLE tb_user
(
    id numeric constraint pk_user primary key,
    username varchar(50) not null,
    fullname varchar(100) not null,
    email varchar(100) not null,
    birth_date varchar(50) not null,
    status varchar(10) not null constraint ck_status check ( status in 'ACTIVE','INACTIVE')
);

comment on table  tb_user is 'User table';
comment on column tb_user.id is 'User id';
comment on column tb_user.username is 'Username';
comment on column tb_user.fullname is 'User full name';
comment on column tb_user.email is 'User email';
comment on column tb_user.birth_date is 'User birth date';
comment on column tb_user.status is 'User status';
