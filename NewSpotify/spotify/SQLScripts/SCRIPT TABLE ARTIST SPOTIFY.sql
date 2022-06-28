CREATE TABLE tb_artist
(
    id numeric constraint pk_artist primary key,
    name varchar(50) not null,
    description varchar(256) not null,
    twitter_link varchar(256),
    instagram_link varchar(256),
    facebook_link varchar(256),
    picture bytea not null,
    status varchar(10) not null constraint artist_status check ( status in ('ACTIVE', 'INACTIVE') )
);

comment on table  tb_artist is 'Artist table';
comment on column tb_artist.id is 'Artist id';
comment on column tb_artist.name is 'Artist name';
comment on column tb_artist.twitter_link is 'Twitter link';
comment on column tb_artist.instagram_link is 'Instagram link';
comment on column tb_artist.facebook_link is 'Facebook link';
comment on column tb_artist.status is 'Artist status'