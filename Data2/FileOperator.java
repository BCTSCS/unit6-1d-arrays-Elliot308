package Data2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.lang.*;

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

    // public static int countInstances(String target, String[] list){
    //     int count = 0;
    //     for (String word : list){
    //         if(target.equals(word)){
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    public static int Most_Popular_Model(int[] sales_record){
        int max = 0;
        int index = 0;
        for(int i = 0; i<sales_record.length; i++){
            if(sales_record[i] > max){
                max = sales_record[i];
                index = i;
            }
        }
        return index;
    }
    
    public static int Biggest_Improvement(int[] prev_record, int[] curr_record){
        Double improvement = 0.0;
        int index = 0;
        for(int i = 0; i<prev_record.length; i++){
            Double rec;
            if(prev_record[i] == 0){
                rec = 0.0;
            }else{
                rec = Double.valueOf((curr_record[i] - prev_record[i])/(double)(prev_record[i]));
            }
            if(rec > improvement){
                improvement = rec;
                index = i;
            }
        }
        return index;
    }

        
    public static int Biggest_Bust(int[] prev_record, int[] curr_record){
        Double improvement = 0.0;
        int index = 0;
        for(int i = 0; i<prev_record.length; i++){
            Double rec;
            if(prev_record[i] == 0){
                rec = 0.0;
            }else{
                rec = Double.valueOf((curr_record[i] - prev_record[i])/(double)(prev_record[i]));
            }
            if(rec < improvement){
                improvement = rec;
                index = i;
            }
        }
        return index;
    }

    public static Double[] percent_change(int[] prev_record, int[] curr_record){
        Double[] percents = new Double[prev_record.length];
        for(int i = 0; i<prev_record.length; i++){
            Double p;
            if(prev_record[i] == 0){
                p = 0.0;
            }else{
                p = Double.valueOf((curr_record[i] - prev_record[i])/(double)(prev_record[i]) * 100);
                //System.out.print("Calculation: " + p);
            }
            percents[i] = p;
        }
        return percents;
    }

    public static Boolean existing_model(String model, String[] model_list){
        for(String m : model_list){
            if(m.equals(model)){
                return true;
            }
        }
        return false;
    } 
    public static void main(String[] args) {
        FileOperator m = new FileOperator("./Data2/ToyotaModels.txt");
        FileOperator s23 = new FileOperator("./Data2/ToyotaSales2023.txt");
        FileOperator s24 = new FileOperator("./Data2/ToyotaSales2024.txt");
        String[] models = m.toStringArray(20);
        int[] sales_23 = s23.toIntArray(20);
        int[] sales_24 = s24.toIntArray(20);

        //Most_Popular_Model()
        System.out.println("The most popular model from Toyota for 2023 was " + models[Most_Popular_Model(sales_23)]);
        System.out.println("The most popular model from Toyota for 2024 was " + models[Most_Popular_Model(sales_24)]);
        
        //Biggest_Improvement()
        System.out.println("The model with the biggest improvement in sales for Toyota from 2023 to 2024 was " + models[Biggest_Improvement(sales_23, sales_24)]);
        
        //Biggest_Bust()
        System.out.println("The model with the biggest bust in sales for Toyota from 2023 to 2024 was " + models[Biggest_Bust(sales_23, sales_24)]);
        
        //percent_change()
        Double[] sales_percent = percent_change(sales_23, sales_24);
        for(Double change : sales_percent){
            System.out.println(change);
        }

        //existing_model()
        String test1 = "Crown";
        String test2 = "Civic";
        String test3 = "Grand Highlander";
        if(existing_model(test1, models)){
            System.out.println(test1 + " is a model of Toyota.");
        }else{
            System.out.println(test1 + " is not a model of Toyota. Were you thinking of another manufacturer?");
        }
        if(existing_model(test2, models)){
            System.out.println(test2 + " is a model of Toyota.");
        }else{
            System.out.println(test2 + " is not a model of Toyota. Were you thinking of another manufacturer?");
        }
        if(existing_model(test3, models)){
            System.out.println(test3 + " is a model of Toyota.");
        }else{
            System.out.println(test3 + " is not a model of Toyota. Were you thinking of another manufacturer?");
        }
    }

}