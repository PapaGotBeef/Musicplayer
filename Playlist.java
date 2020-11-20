public class Playlist extends SongCollection {

    //Attributes
    private String description;

    //Custom constructor
    public Playlist(String name, String description) {
        super(name);
        this.description = description;
    }


    //Set Method
    public void setDescription(String description){
    this.description = description;
    }
    //Get Method
    public String getDescription(){
        return this.description;
    }
}
