/*
DIVYA JAGADEESH, M.S.
UNIVERSITY OF PITTSBURGH AT BRADFORD
CIST 1450 - FALL 2020
HOMEWORK 3
DO NOT MODIFY OR SUBMIT THIS FILE.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Spotify {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        char addAnother = 'n';
        ArrayList<Library> libraries = new ArrayList<>();

        // Create user libraries
        do {
            Library library = createLibrary(input);
            addPlaylistToLibrary(library, input);
            addSongToLibrary(library, input);
            library.printLibrary();
            libraries.add(library);
            System.out.print("Would you like to add another library? (y/n): ");
            addAnother = input.nextLine().charAt(0);
        } while (Character.toLowerCase(addAnother) == 'y');

        // Print user libraries
        for (int i = 0; i < libraries.size(); i++) {
            libraries.get(i).printLibrary();
        }

    }

    public static Library createLibrary(Scanner input) {
        System.out.print("Who is the owner of this library?: ");
        String name = input.nextLine();
        Library library = new Library(name);
        library.uploadDemoSongs();
        return library;
    }

    //Create New Playlist and add to library
    public static void addPlaylistToLibrary(Library library, Scanner input) {
        char addAnother = 'n';
        do {
            System.out.println("Let's make a new playlist!");
            Playlist playlist = library.createPlaylist(input);
            library.addPlaylist(playlist);
            System.out.print("Would you like to add another playlist to the library? (y/n): ");
            addAnother = input.nextLine().charAt(0);
        } while(Character.toLowerCase(addAnother) == 'y');

    }

    //Add a singular song to a library
    public static void addSongToLibrary(Library library, Scanner input) {
        System.out.print("Would you like to add a song to the library? (y/n): ");
        char addAnother = input.nextLine().charAt(0);

        //While user enter Y at prompt, a new song will be added
        while (Character.toLowerCase(addAnother) == 'y') {
            System.out.println("Let's add a song to your song library.");
            String title, artist, genre;
            System.out.print("Song name: ");
            title = input.nextLine();
            System.out.print("Artist name: ");
            artist = input.nextLine();
            System.out.print("Genre: ");
            genre = input.nextLine();
            library.getHome().addSong(new Song(title, artist, genre));
            System.out.print("Would you like to add another song to the library? (y/n): ");
            addAnother = input.nextLine().charAt(0);
        }
    }

}
