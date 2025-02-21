package Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    public static int countInstances(String target, String[] list){
        int count = 0;
        for (String word : list){
            if(target.equals(word)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        FileOperator A = new FileOperator("./Data/albums.txt");
        FileOperator B = new FileOperator("./Data/artists.txt");
        String[] albums = A.toStringArray(7);
        for(String album: albums){
            System.out.println(album);
        }
        String[] artists = B.toStringArray(498);
        String targ_artist = "The Beatles";
        System.out.println("There are " + countInstances(targ_artist, artists) + " occurences of the artist: " + targ_artist);
        String targ_artist2 = "Love";
        System.out.println("There are " + countInstances(targ_artist2, artists) + " occurences of the artist: " + targ_artist2);
        String targ_artist3 = "Prince";
        System.out.println("There are " + countInstances(targ_artist3, artists) + " occurences of the artist: " + targ_artist3);

    }
}

