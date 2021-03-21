package olek.gorecki.LinkedListChallenge;

import java.util.*;

public class Playlist {
    private LinkedList<Song> songs;
    private ArrayList<Album> albums;

    public Playlist( ArrayList<Album> albums) {
        this.songs = new LinkedList<>();
        this.albums = albums;
    }

    public void addSong(Song song) {
        if(albums.stream().anyMatch(album -> album.getSongs().contains(song))) {
            songs.add(song);
        } else {
            System.out.println("the song have to be added to album first !!!");
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> songListIterator = this.songs.listIterator();
        if(songs.getFirst() == null) {
            System.out.println("no songs in the playlist");
            return;
        } else {
            System.out.println("now listening to "+songListIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            switch (action) {
                case 0:
                    System.out.println("you stopped playing ");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward) {
                        if(songListIterator.hasNext()) {
                            songListIterator.next();
                        }
                        goingForward = true;
                    }
                    if(songListIterator.hasNext()) {
                        System.out.println("Now listening to "+songListIterator.next());
                    } else {
                        System.out.println("You reached the end of the playlist");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if(goingForward) {
                        if(songListIterator.hasPrevious()) {
                            songListIterator.previous();
                        }
                        goingForward = true;
                    }
                    if(songListIterator.hasPrevious()) {
                        System.out.println("Now listening to "+songListIterator.previous());
                    } else {
                        System.out.println("You reached the end of the playlist");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if(songListIterator.hasNext()) {
                        songListIterator.next();
                        System.out.println("Now listening to "+ songListIterator.previous());
                    } else if(songListIterator.hasPrevious()) {
                        songListIterator.previous();
                        System.out.println("Now listening to "+ songListIterator.next());
                    }
                    break;
                case 4:
                    for (Song song : songs) {
                        System.out.println(song);
                    }
                    System.out.println("========================");
                    break;
            }
        }
    }

    private void printMenu() {
        System.out.println("Available actions");
        System.out.println("0 - quit");
        System.out.println("1 - next song");
        System.out.println("2 - previous song");
        System.out.println("3 - replay current song");
        System.out.println("4 - show songs int the playlist");
    }
}
