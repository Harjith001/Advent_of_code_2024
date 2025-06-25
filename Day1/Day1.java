package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Day1 {
    private List<Integer> list1;
    private List<Integer> list2;
    private int bufferSize = 4096;
    private final String source = "input1.txt";

    Day1(){
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
    }


    private void inputToList(){
        try(BufferedReader bis = new BufferedReader(new FileReader(source), bufferSize)){
            String line;

            while((line = bis.readLine()) != null){
                String[] lineSplit = line.split("\\s+");
                list1.add(Integer.parseInt(lineSplit[0]));
                list2.add(Integer.parseInt(lineSplit[1]));
            }
        }
        catch(Exception e){
            //
        }
    }

    private int simarityScore(){
        int result = 0;
        HashMap<Integer, Integer> occurences = new HashMap<>();

        for(int i: list2){
            occurences.put(i, occurences.getOrDefault(i, 0) + 1);
        }

        for(int j : list1){
            result += (j*occurences.getOrDefault(j, 0));
        }

        return result;
    }

    public static void main(String[] args) {
        Day1 d = new Day1();
        d.inputToList();

        Collections.sort(d.list1);
        Collections.sort(d.list2);
        
        long result = 0;
        for(int i = 0; i < d.list1.size();i++){
            result += Math.abs(d.list1.get(i) - d.list2.get(i));
        }
        System.out.println(result);
        System.out.println(d.simarityScore());
    }
}
