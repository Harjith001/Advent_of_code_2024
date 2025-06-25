package Day2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day2 {
    private final static String SOURCE = "input2.txt";

    ArrayList<ArrayList<Integer>> inputToList() {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(SOURCE))) {
        String line;

        while ((line = br.readLine()) != null) {
            String[] lineSplit = line.trim().split("\\s+");

            ArrayList<Integer> row = new ArrayList<>();
            for (String part : lineSplit) {
                row.add(Integer.parseInt(part));
            }

            list.add(row);
        }

    } catch (Exception e) {
        e.printStackTrace(); // don't swallow the error silently
    }

    return list;
    }
        public static void main(String[] args) {
        Day2 d = new Day2();
        ArrayList<ArrayList<Integer>> list = d.inputToList();

        int safeReports = 0;

        for (ArrayList<Integer> row : list) {
            if (isSafe(row)) {
                safeReports++;
            }
        }

        System.out.println("Safe reports: " + safeReports);
    }
static boolean isSafe(ArrayList<Integer> row) {
    if (isStrictlySafe(row)) return true;

    // Try removing one element at each position
    for (int i = 0; i < row.size(); i++) {
        ArrayList<Integer> copy = new ArrayList<>(row);
        copy.remove(i);
        if (isStrictlySafe(copy)) return true;
    }

    return false;
}

// Original logic for strictly safe reports
static boolean isStrictlySafe(ArrayList<Integer> row) {
    if (row.size() < 2) return false;

    boolean increasing = row.get(1) > row.get(0);
    boolean decreasing = row.get(1) < row.get(0);

    if (!increasing && !decreasing) return false;

    for (int i = 0; i < row.size() - 1; i++) {
        int diff = row.get(i + 1) - row.get(i);

        if (diff == 0 || Math.abs(diff) > 3) return false;

        if (increasing && diff <= 0) return false;
        if (decreasing && diff >= 0) return false;
    }

    return true;
}

}
