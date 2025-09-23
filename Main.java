import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // File paths for the two files to compare
        String filePath1 = "file1.txt";
        String filePath2 = "file2.txt";
        
        try {
            String[] file1 = FileUtils.loadFileContent(filePath1);
            String[] file2 = FileUtils.loadFileContent(filePath2);

            List<String> diff = FileUtils.computeDiff(file1, file2);

            for (String line : diff) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }

}
