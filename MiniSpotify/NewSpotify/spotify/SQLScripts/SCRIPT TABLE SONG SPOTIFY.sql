CREATE TABLE tb_song
(
    id numeric constraint pk_song primary key,
    name varchar(50) not null,
    mp3_file bytea not null,
    release_date varchar(50) not null,
    picture bytea not null,
    kind varchar(50) not null,
    id_album numeric not null constraint fk_album references tb_album(id),
    id_artist numeric not null constraint fk_artist_song references tb_artist(id),
    status varchar(10) not null constraint song_status check ( status in ('ACTIVE', 'INACTIVE') )
);

comment on table  tb_song is 'Song table';
comment on column tb_song.id is 'Song id';
comment on column tb_song.name is 'Song name';
comment on column tb_song.mp3_file is 'Song mp3 file';
comment on column tb_song.id_album is 'Foreign Key to album id';
comment on column tb_song.id_artist is 'Foreign Key to artist id';
comment on column tb_song.status is 'Song status'