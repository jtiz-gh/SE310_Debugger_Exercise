import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // File paths for the two files to compare
        String filePath1 = "file1.txt";
        String filePath2 = "file2.txt";
        
        try {
            String[] file1 = loadFileContent(filePath1);
            String[] file2 = loadFileContent(filePath2);

            List<String> diff = computeDiff(file1, file2);

            for (String line : diff) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }

    public static String[] loadFileContent(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines.toArray(new String[0]);
    }

    public static List<String> computeDiff(String[] file1, String[] file2) {
        List<String> diff = new ArrayList<>();

        int maxLength = Math.max(file1.length, file2.length);

        for (int i = 1; i < maxLength; i++) {
            String line1 = i < file1.length ? file1[i] : "";
            String line2 = i < file2.length ? file2[i] : "";

            if (!line1.equals(line2)) {
                if (!line1.isEmpty()) {
                    diff.add("- " + line1);
                }
                if (!line2.isEmpty()) {
                    diff.add("+ " + line2);
                }
            } else {
                diff.add("  " + line1);
            }
        }

        return diff;
    }
}
