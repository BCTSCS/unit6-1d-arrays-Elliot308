package Data;
import java.util.Scanner;

public class Spotbox {
    private String[] albums;
    private String[] artists;
    private String[] genres;
    public Spotbox(String alb_file, String art_file, String gen_file){
        FileOperator A = new FileOperator("./Data/" + alb_file + ".txt");
        FileOperator B = new FileOperator("./Data/" + art_file + ".txt");
        FileOperator C = new FileOperator("./Data/" + gen_file + ".txt");
        albums = A.toStringArray(498);
        artists = B.toStringArray(498);
        genres = C.toStringArray(498);
    }
  public static int countInstances(String target, String[] list){
    int count = 0;
    for (String word : list){
        if(target.equals(word)){
            count++;
        }
    }
    return count;
}

public static String least_common(String[] list){
    int occurences = countInstances(list[0], list);
    int index_least = 0;
    for(int i = 0; i<list.length; i++){
        int new_o = countInstances(list[i], list);
        // System.out.println(new_o + ": " +  list[new_o]);
        if(occurences > new_o){
            occurences = new_o;
            index_least = i;
           // System.out.println("smaller!" + list[new_o]);
        }
    }
    return list[index_least];
}

public static String genre_artist(String[] genre_list, String[] artist_list, String artist){
    String msg = "The genres that " + artist + " has explored is/are: \n";
    for (int i = 0; i < artist_list.length; i++){
        if(artist_list[i].equals(artist)){
            msg+=(genre_list[i] + "\n");
        }
    }
    return msg;
}
public static void main(String[] args) {

    
    
  }
}