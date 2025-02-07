import java.util.*;
import java.io.*;
public class DataAnalyzer {

    public static int searchList(int[] numbers, int target){
        int index = 0;
        while(index < numbers.length){
            if(numbers[index]==target){
                return index;
            }
            index++;
        }
        return -1;
    }

    public static int binarySearch(int[] numbers, int target){
        int index_start = 0;
        int index_end = numbers.length;
        
        return -1;

    }

    public static int find_in_list(int[] list, int target){
        for(int i = 0; i < list.length; i++){
            if (list[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        System.out.println(searchList(arr, 40));
        String filename = "numbers.txt";
        //try{
            File f = new File("numbers.txt");
            Scanner input = new Scanner(f);
            int[] num_list = {};
            for (int i = 0; i < 100; i++){
                num_list[i] = Integer.valueOf(input.nextLine());
            }
        //}catch(IOException e){
        //    System.out.println("file not found");
        //}
        
        System.out.println(find_in_list(num_list, 43));
    }
}
