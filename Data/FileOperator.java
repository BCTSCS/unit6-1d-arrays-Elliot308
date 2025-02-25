package Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperator {
    private Scanner fileReader;
    private String filename;

    
    public FileOperator(String f){
        filename = f;
        setFile(filename);
        // Scanner fileReader = new Scanner(filename);
    }

    public void setFile(String f){
        try {
            fileReader = new Scanner(new File(f));
        } 
        catch (IOException FileNotFoundException) {
            System.out.println("failed to build Scanner");
        }
    }

    public String[] toStringArray(int arraySize){  
        String[] word_list = new String[arraySize];
        
        for (int i = 0; i < arraySize; i++){
            word_list[i] = fileReader.nextLine();
        }
        return word_list;
    }

    public int[] toIntArray(int arraySize){  
        int[] num_list = new int[arraySize];
        
        for (int i = 0; i < arraySize; i++){
            num_list[i] = Integer.valueOf(fileReader.nextLine());
        }
        return num_list;
    }

    public double[] toDoubleArray(int arraySize){
        double[] num_list = new double[arraySize];

        for (int i = 0; i < arraySize; i++){
            num_list[i] = Double.valueOf(fileReader.nextLine());
        }
        return num_list;
    }

    // public ArrayList<Integer> toIntList()
    // public ArrayList<String> toStringList()
    // public ArrayList<Double> toDoubleList()

    public ArrayList<Integer> toIntList(){
        ArrayList<Integer> list = new ArrayList<>();
        while(fileReader.hasNextLine()){
            list.add(Integer.valueOf(fileReader.nextLine()));
        }
        return list;
    }

    public ArrayList<Double> toDoubleList(){
        ArrayList<Double> list = new ArrayList<>();
        while(fileReader.hasNextLine()){
            list.add(Double.valueOf(fileReader.nextLine()));
        }
        return list;
    }

    public ArrayList<String> toStringList(){
        ArrayList<String> list = new ArrayList<>();
        while(fileReader.hasNextLine()){
            list.add(fileReader.nextLine());
        }
        return list;
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
        FileOperator A = new FileOperator("./Data/albums.txt");
        FileOperator B = new FileOperator("./Data/artists.txt");
        FileOperator C = new FileOperator("./Data/genres.txt");
        String[] albums = A.toStringArray(498);
        // for(String album: albums){
        //     System.out.println(album);
        // }
    
        //countInstances
        String[] artists = B.toStringArray(498);
        String[] genres = C.toStringArray(498);
        ArrayList<String> genres_2 = C.toStringList();
        String targ_artist = "The Beatles";
        System.out.println("There are " + countInstances(targ_artist, artists) + " occurences of the artist: " + targ_artist);
        String targ_artist2 = "Love";
        System.out.println("There are " + countInstances(targ_artist2, artists) + " occurences of the artist: " + targ_artist2);
        String targ_artist3 = "Prince";
        System.out.println("There are " + countInstances(targ_artist3, artists) + " occurences of the artist: " + targ_artist3);

        //least common genre
        System.out.println("The least common genre is " + least_common(genres));

        //find genres by artist
        System.out.println(genre_artist(genres, artists, "The Beatles"));
        System.out.println(genre_artist(genres, artists, "Love"));
        System.out.println(genre_artist(genres, artists, "Prince"));
        

    }
}

