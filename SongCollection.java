import java.util.Hashtable;

public class SongCollection {

    //Attributes
    private String name;
    private Hashtable<String, Song> songs;


    //Constructor
    public SongCollection(String name){
    this.name = name;
    songs = new Hashtable<String, Song>();
}

    //Set Methods
    public void setName(String name) {this.name = name;}
    public void setSongs (Hashtable songs) {
        this.songs = songs;
    }

    //Get Methods
    public String getName(){return this.name;}
    public Hashtable getSongs(){return songs;}

    //Add song to Song collection
    public void addSong(Song song) {
    this.songs.put(song.getTitle(), song);

    }

    //Prints Songs in each collection
    public void printSongs() {
        this.songs.forEach((title, song) -> {
            String artist = song.getArtist();
            String genre = song.getGenre();
            System.out.println("-------------");
            System.out.println(title.toUpperCase());
            System.out.println(artist);
            System.out.println(genre);
        });
    }



    //Finding song with specified title
    public Song lookUpSong(String Title){
        return this.songs.get(Title);
    }



}
