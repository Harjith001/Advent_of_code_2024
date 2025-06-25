package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    private static final String SOURCE = "input3.txt";

    private String inputToString(){
        StringBuilder input = new StringBuilder();
        try (BufferedReader bis = new BufferedReader(new FileReader(SOURCE))){
            String content;
            while((content = bis.readLine())!= null){
                input.append(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input.toString();
    }

    public static void main(String[] args) {
        Day3 d = new Day3();
        String input = d.inputToString();

        // Match mul(x,y), do(), don't()
        Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)|do\\(\\)|don't\\(\\)");
        Matcher matcher = pattern.matcher(input);

        int total = 0;
        boolean enabled = true;

        while (matcher.find()) {
            String match = matcher.group();

            if (match.equals("do()")) {
                enabled = true;
            } else if (match.equals("don't()")) {
                enabled = false;
            } else if (match.startsWith("mul(") && enabled) {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                total += x * y;
            }
        }

        System.out.println(total);
    }
}
