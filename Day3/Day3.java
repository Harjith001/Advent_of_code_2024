package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    private static final String SOURCE = "input3.txt";

    
    private String inputToString(){
        String input ="";
        try (BufferedReader bis = new BufferedReader(new FileReader(SOURCE))){
            String content;
            while((content = bis.readLine())!= null){
                input+=content;
            }


        } catch (Exception e) {
            // TODO: handle exception
        }
        return input;
    }

    public static void main(String[] args) {

        Day3 d = new Day3();
        String input = d.inputToString();
        
        Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
        Matcher matcher = pattern.matcher(input);

        int total = 0;

        while (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            total += x * y;
        }
        System.out.println(total);
    }
}
