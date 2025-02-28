package Data;
public class Album {
    private String title;
    private String artist;
    private String genre;
    public Album(){

    }
    public Album(String t, String a, String g){
        title = t;
        artist = a;
        genre = g;
    }

    public void setTitle(String t){
        title = t;
    }

    public void setArtist(String a){
        artist = a;
    }

    public void setGenre(String g){
        genre = g;
    }

    public String getTitle(){
        return title;
    }

    public String getArtist(){
        return artist;
    }

    public String getGenre(){
        return genre;
    }

    public String toString() {
        return "Album Information: \n Album: " + title + "\n Artist: " + artist + "\n Genre: " + genre;
    }
}
