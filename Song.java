    public class Song {
        //Attributes
        private String title;
        private String artist;
        private String genre;

    //Constructor
    public Song(String Title, String Artist, String Genre){
        this.title = Title;
        this.artist = Artist;
        this.genre = Genre;
}

    //Set Methods
    public void setTitle(String Title) {this.title = Title;}
    public void setArtist(String Artist) {this.artist = Artist;}
    public void setGenre(String Genre) {this.genre = Genre;}


    //Get Methods
    public String getTitle(){return this.title;}
    public String getArtist(){return this.artist;}
    public String getGenre(){return this.genre;}



}
