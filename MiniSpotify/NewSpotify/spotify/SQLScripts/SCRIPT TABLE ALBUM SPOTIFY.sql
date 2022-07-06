CREATE TABLE tb_album
(
    id numeric constraint pk_album primary key,
    name varchar(50) not null,
    release_date varchar(50) not null,
    id_artist numeric not null constraint fk_artist_album references tb_artist(id),
    status varchar(10) not null constraint album_status check ( status in ('ACTIVE', 'INACTIVE') )
);

comment on table  tb_album is 'Album table';
comment on column tb_album.id is 'Album id';
comment on column tb_album.name is 'Album name';
comment on column tb_album.release_date is 'Album release date';
comment on column tb_album.id_artist is 'Foreign key to artist table';
comment on column tb_album.status is 'Album status'