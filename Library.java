import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;

public class Library {
    private String ownerName;
    private SongCollection home;
    private Hashtable<String, Playlist> playlists;
    Scanner inputDevice;


    //Library Constructor
    public Library(String OwnerName){
        this.ownerName = OwnerName;
        this.home = new SongCollection("Home");
        this.playlists = new Hashtable<String, Playlist>();
    }

    //Get Methods
    public String getOwnerName(String OwnerName) {return this.ownerName;}
    public SongCollection getHome() {return home;}
    public Hashtable getPlaylists(){return playlists;}


   //Creating playlist
    public Playlist createPlaylist(Scanner inputDevice){

        System.out.println("Playlist name:  ");
        String name = inputDevice.nextLine();
        System.out.println("Description:  ");
        String description = inputDevice.nextLine();
        Playlist playlist = new Playlist (name, description);
        char addAnother='n';
        do {
            System.out.println("Adding to your " + name + " playlist");
            String title, artist, genre;
            System.out.print("Song name: ");
            title = inputDevice.nextLine();
            System.out.print("Artist name: ");
            artist = inputDevice.nextLine();
            System.out.print("Genre: ");
            genre = inputDevice.nextLine();
            playlist.addSong(new Song(title, artist, genre));
            System.out.println("Would you like to add another song? (y/n) ");
            addAnother = inputDevice.nextLine().charAt(0);
        } while (Character.toLowerCase(addAnother) == 'y');
        return playlist;
    }
        //Saving Playlist
    public void addPlaylist(Playlist playlist){
        this.playlists.put(playlist.getName(), playlist);
        playlist.getSongs().forEach((title, song) -> {
            this.home.addSong((Song) song);
        });

        }
        //Adding Songs from demo_songs.txt file
        public void uploadDemoSongs(){
        Path file= Paths.get("./demo_songs.txt");
            InputStream input = null;
            try {

                input = newInputStream(file);
                BufferedReader reader=new BufferedReader(new InputStreamReader(input));
                String s=null;
                String[] songDetails;

                while ((s=reader.readLine()) != null) {
                    String title;
                    String artist;
                    String genre;

                    songDetails = s.split(",");
                    System.out.println(Arrays.toString(songDetails));


                    title = songDetails[0];
                    artist = songDetails[1];
                    genre = songDetails[2];

                    Song song = new Song(title, artist, genre);
                    this.home.addSong(song);
                }
                input.close();

            }
            catch (IOException e) {
                System.out.println(e);
            }


        }

    //Prints playlist including description and songs within
    public void printLibrary () {
        System.out.println("Library Owner: " + ownerName) ;
        System.out.println("Songs in Library: ");
        this.home.printSongs();
        this.playlists.forEach((name, playlist) -> {
            System.out.println();
            System.out.println("Your playlist " + playlist.getName() + " \n Description: " + playlist.getDescription());
            System.out.println("---------------");
            playlist.printSongs();
        });

    }
}


