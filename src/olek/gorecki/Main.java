package olek.gorecki;

import olek.gorecki.LinkedListChallenge.Album;
import olek.gorecki.LinkedListChallenge.Playlist;
import olek.gorecki.LinkedListChallenge.Song;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Song s1 = new Song("WAP","2.44");
        Song s2 = new Song("Chun-Li","2.55");
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        Album album = new Album(songs);
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(album);
        Playlist playlist = new Playlist(albums);
        playlist.addSong(s1);
        playlist.addSong(s2);
        playlist.play();
    }
}
