CREATE TABLE tb_playlist_song
(
    song_id numeric not null constraint fk_song references tb_song(id),
    playlist_id numeric not null constraint fk_playlist references tb_playlist(id)
);

comment on table  tb_playlist_song is 'Join table of Songs and Playlists';
comment on column tb_song.id is 'Song id';
comment on column tb_playlist.id is 'Playlist id';
